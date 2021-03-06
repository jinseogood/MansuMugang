<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.msmg.admin.model.vo.*, com.msmg.member.model.vo.*"%>
<%
	Member loginUser=(Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<title>만수무강 관리자</title>
<style>
	html{
		height:100%;
	}
	body{
		height:100%;
	}
	.container{
		float:left;
		width:15%;
		height:100%;
		border-right:1px solid lightgray;
	}
	.container > ul > li{
		margin-top:15px;
	}
	.container > ul > li > a{
		color:black;
	}
	#info{
		width:90%;
		height:15%;
		margin-top:20px;
	}
	#infoAlert{
		width:100%;
		height:10%;
	}
	#infoIcon{
		width:100%;
		height:80%;
	}
	#adminIcon{
		float:left;
		width:50%;
		height:100%;
	}
	#infoLogout{
		width:100%;
		height:10%;
	}
	#infoLogout > a{
		text-decoration:none;
		color:black;	
	}
	#infoLogout > a:hover{
		cursor:pointer;
	}
	.content{
		display:inline-block;
		width:85%;
		height:100%;
		overflow:auto;
	}
	#food, #board, #member, #stat{
		height:200%;
	}
	#food-1, #food-2{
		height:40%;
	}
	#board-1, #board-2, #board-3{
		height:33%;
	}
	#member-1, #member-2, #member-3{
		height:33%;
	}
	#stat-1, #stat-2, #stat-3{
		height:33%;
	}
	#refreshArea{
		height:30px;
	}
	#refreshArea > img{
		width:30px;
		height:30px;
		margin-right:3%;
	}
	#refreshArea > img:hover{
		cursor:pointer;
	}
	#dietTypeStat, #payTypeStat{
		width:900px;
		height:500px;
	}
	#saleGoStat, #saleDangStat, #saleHeadStat{
		display:block;
		height:130px;
	}
	#baseTable{
		border:1px solid lightgray;
		width:90%;
		height:25%;
		margin-left:5%;
		text-align:center;
	}
	#menuTable{
		border:1px solid lightgray;
		width:90%;
		height:25%;
		margin-left:5%;
		text-align:center;
	}
	#noticeTable{
		border:1px solid lightgray;
		width:90%;
		height:25%;
		margin-left:5%;
		text-align:center;
	}
	#infoTable{
		border:1px solid lightgray;
		width:90%;
		height:25%;
		margin-left:5%;
		text-align:center;
	}
	#reviewTable{
		border:1px solid lightgray;
		width:90%;
		height:25%;
		margin-left:5%;
		text-align:center;
	}
	#memberTable{
		border:1px solid lightgray;
		width:90%;
		height:25%;
		margin-left:5%;
		text-align:center;
	}
	#orderTable{
		border:1px solid lightgray;
		width:90%;
		height:25%;
		margin-left:5%;
		text-align:center;
	}
	#qnaTable{
		border:1px solid lightgray;
		width:90%;
		height:25%;
		margin-left:5%;
		text-align:center;
	}
	#matpageArea{
		width:100%;
		height:20px;
	}
	#menupageArea{
		width:100%;
		height:20px;
	}
	#noticepageArea{
		width:100%;
		height:20px;
	}
	#infopageArea{
		width:100%;
		height:20px;
	}
	#reviewpageArea{
		width:100%;
		height:20px;
	}
	#memberpageArea{
		width:100%;
		height:20px;
	}
	#orderpageArea{
		width:100%;
		height:20px;
	}
	#qnapageArea{
		width:100%;
		height:20px;
	}
</style>
<script>
	function logout(){
		var check = window.confirm("로그아웃 하시겠습니까?");
		
		if(check == true){
			location.href = "<%= request.getContextPath() %>/logout.me"
		}
	}
	
	function pagingAJAX(currentPage, type){
		//재료 조회
		if(type == 1){
			$.ajax({
				url:"/msmg/selectMatList",
				type:"get",
				data:{currentPage:currentPage},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#baseTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#matpageArea");
					$pageBody.html('');
					
					$.each(data, function(index, value){
						if(decodeURIComponent(value.matCode)!="undefined"){
							var $tr=$("<tr>");
							var $noTd=$("<td>").text(decodeURIComponent(value.matCode));
							var $nameTd=$("<td>").text(decodeURIComponent(value.matName));
							var $alleTd=$("<td>").text(decodeURIComponent(value.alleCode));
							var $goTd=$("<td>").text(decodeURIComponent(value.d_go));
							var $dangTd=$("<td>").text(decodeURIComponent(value.d_dang));
							var $headTd=$("<td>").text(decodeURIComponent(value.d_head));
							
							$tr.append($noTd);
							$tr.append($nameTd);
							$tr.append($alleTd);
							$tr.append($goTd);
							$tr.append($dangTd);
							$tr.append($headTd);
							$tableBody.append($tr);
						}
						else{
							var startPage=value.startPage;
							var endPage=value.endPage;
							var maxPage=value.maxPage;
							var currentPage=value.currentPage;
							var limit=value.limit;
							var listCount=value.listCount;
							
							$pageBody.append("<button onclick='goFirstPage("+currentPage+", 1);'><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick='goPrevPage("+currentPage+", 1);'><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick='goPage("+p+", 1);'>"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick='goNextPage("+currentPage+", 1);'>></button");
							}
							
							$pageBody.append("<button onclick='goLastPage("+maxPage+", 1);'>>></button>");
						}
					});
					
				},
				error:function(){
					console.log("error");
				}
			});
		}
		//메뉴 조회
		else if(type == 2){
			$.ajax({
				url:"/msmg/selectMenuList",
				type:"get",
				data:{currentPage:currentPage},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#menuTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#menupageArea");
					$pageBody.html('');
					
					$.each(data, function(index, value){
						if(decodeURIComponent(value.menuName)!="undefined"){
							var $tr=$("<tr onclick='openMDetail("+value.menuCode+")'>");
							var $codeTd=$("<td>").text(value.menuCode);
							var $nameTd=$("<td>").text(decodeURIComponent(value.menuName));
							var $mMatTd=$("<td>").text(decodeURIComponent(value.mainMat));
							var $sMatTd=$("<td>").text(decodeURIComponent(value.subMat));
							var $mInfoTd=$("<td>").text(decodeURIComponent(value.info));
							var $priceTd=$("<td>").text(value.price);
							
							$tr.append($codeTd);
							$tr.append($nameTd);
							$tr.append($mMatTd);
							$tr.append($sMatTd);
							$tr.append($mInfoTd);
							$tr.append($priceTd);
							$tableBody.append($tr);
						}
						else{
							var startPage=value.startPage;
							var endPage=value.endPage;
							var maxPage=value.maxPage;
							var currentPage=value.currentPage;
							var limit=value.limit;
							var listCount=value.listCount;
							
							$pageBody.append("<button onclick='goFirstPage("+currentPage+", 2);'><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick='goPrevPage("+currentPage+", 2);'><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick='goPage("+p+", 2);'>"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick='goNextPage("+currentPage+", 2);'>></button");
							}
							
							$pageBody.append("<button onclick='goLastPage("+maxPage+", 2);'>>></button>");
						}
					});
					
				},
				error:function(){
					console.log("error");
				}
			});
		}
		//공지 조회
		else if(type == 3){
			$.ajax({
				url:"/msmg/selectNoticeList",
				type:"get",
				data:{currentPage:currentPage},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#noticeTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#noticepageArea");
					$pageBody.html('');
					
					for(var key in data){
						console.log(key);
						
						if(key == "nList"){
							for(i=0;i<data[key].length;i++){
								var $tr=$("<tr onclick='openNotice("+data[key][i].board_no+");'>");
								var $noTd=$("<td>").text(data[key][i].board_no);
								var $titleTd=$("<td>").text(data[key][i].title);
								var $writerTd=$("<td>").text(data[key][i].u_name);
								var $dateTd=$("<td>").text(data[key][i].board_date);
								var $countTd=$("<td>").text(data[key][i].b_count);
								
								$tr.append($noTd);
								$tr.append($titleTd);
								$tr.append($writerTd);
								$tr.append($dateTd);
								$tr.append($countTd);
								$tableBody.append($tr);
							}
						}
						else{
							var startPage=data[key].startPage;
							var endPage=data[key].endPage;
							var maxPage=data[key].maxPage;
							var currentPage=data[key].currentPage;
							var limit=data[key].limit;
							var listCount=data[key].listCount;
							
							$pageBody.append("<button onclick='goFirstPage("+currentPage+", 3);'><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick='goPrevPage("+currentPage+", 3);'><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick='goPage("+p+", 3);'>"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick='goNextPage("+currentPage+", 3);'>></button");
							}
							
							$pageBody.append("<button onclick='goLastPage("+maxPage+", 3);'>>></button>");
						}
					}
				},
				error:function(data){
					console.log(data);
				}
			});
		}
		//정보 조회
		else if(type == 4){
			$.ajax({
				url:"/msmg/selectInfoList",
				type:"get",
				data:{currentPage:currentPage},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#infoTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#infopageArea");
					$pageBody.html('');
					
					for(var key in data){
						console.log(key);
						if(key == "infoList"){
							for(i=0;i<data[key].length;i++){
								var $tr=$("<tr onclick='openInfo("+data[key][i].boardId+");'>");
								var $noTd=$("<td>").text(data[key][i].boardNo);
								var $titleTd=$("<td>").text(data[key][i].title);
								var $writerTd=$("<td>").text(data[key][i].uCode);
								var $dateTd=$("<td>").text(data[key][i].boardDate);
								var $countTd=$("<td>").text(data[key][i].bCount);
								
								$tr.append($noTd);
								$tr.append($titleTd);
								$tr.append($writerTd);
								$tr.append($dateTd);
								$tr.append($countTd);
								$tableBody.append($tr);
							}
						}
						else{
							var startPage=data[key].startPage;
							var endPage=data[key].endPage;
							var maxPage=data[key].maxPage;
							var currentPage=data[key].currentPage;
							var limit=data[key].limit;
							var listCount=data[key].listCount;
							
							$pageBody.append("<button onclick='goFirstPage("+currentPage+", 4);'><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick='goPrevPage("+currentPage+", 4);'><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick='goPage("+p+", 4);'>"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick='goNextPage("+currentPage+", 4);'>></button");
							}
							
							$pageBody.append("<button onclick='goLastPage("+maxPage+", 4);'>>></button>");
						}
					}
				},
				error:function(data){
					console.log(data);
					console.log("error");
				}
			});
		}
		//후기 조회
		else if(type == 5){
			$.ajax({
				url:"/msmg/selectReviewList",
				type:"get",
				data:{currentPage:currentPage},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#reviewTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#reviewpageArea");
					$pageBody.html('');
					
					for(var key in data){
						console.log(key);
						if(key == "rList"){
							for(i=0;i<data[key].length;i++){
								var $tr=$("<tr onclick='openReview("+data[key][i].boardId+");'>");
								var $noTd=$("<td>").text(data[key][i].boardNo);
								var $titleTd=$("<td>").text(data[key][i].title);
								var $writerTd=$("<td>").text(data[key][i].uCode);
								var $dateTd=$("<td>").text(data[key][i].boardDate);
								var $countTd=$("<td>").text(data[key][i].bCount);
								
								$tr.append($noTd);
								$tr.append($titleTd);
								$tr.append($writerTd);
								$tr.append($dateTd);
								$tr.append($countTd);
								$tableBody.append($tr);
							}
						}
						else{
							var startPage=data[key].startPage;
							var endPage=data[key].endPage;
							var maxPage=data[key].maxPage;
							var currentPage=data[key].currentPage;
							var limit=data[key].limit;
							var listCount=data[key].listCount;
							
							$pageBody.append("<button onclick='goFirstPage("+currentPage+", 5);'><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick='goPrevPage("+currentPage+", 5);'><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick='goPage("+p+", 5);'>"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick='goNextPage("+currentPage+", 5);'>></button");
							}
							
							$pageBody.append("<button onclick='goLastPage("+maxPage+", 5);'>>></button>");
						}
					}
				},
				error:function(data){
					console.log(data);
					console.log("error");
				}
			});
		}
		//회원 조회
		else if(type == 6){
			$.ajax({
				url:"/msmg/selectMemberList",
				type:"get",
				data:{currentPage:currentPage},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#memberTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#memberpageArea");
					$pageBody.html('');
					
					$.each(data, function(index, value){
						if(decodeURIComponent(value.mName)!="undefined"){
							var $tr=$("<tr>");
							var $noTd=$("<td>").text(value.mCode);
							var $nameTd=$("<td>").text(decodeURIComponent(value.mName));
							var $idTd=$("<td>").text(decodeURIComponent(value.mId));
							var $telTd=$("<td>").text(decodeURIComponent(value.mTel));
							var $addrTd=$("<td>").text(decodeURIComponent(value.mAddr));
							var $typeTd=$("<td>").text(decodeURIComponent(value.mType));
							var $dropTd=$("<td>").text(decodeURIComponent(value.mDrop));
							
							$tr.append($noTd);
							$tr.append($nameTd);
							$tr.append($idTd);
							$tr.append($telTd);
							$tr.append($addrTd);
							$tr.append($typeTd);
							$tr.append($dropTd);
							$tableBody.append($tr);
						}
						else{
							var startPage=value.startPage;
							var endPage=value.endPage;
							var maxPage=value.maxPage;
							var currentPage=value.currentPage;
							var limit=value.limit;
							var listCount=value.listCount;
							
							$pageBody.append("<button onclick='goFirstPage("+currentPage+", 6);'><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick='goPrevPage("+currentPage+", 6);'><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick='goPage("+p+", 6);'>"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick='goNextPage("+currentPage+", 6);'>></button");
							}
							
							$pageBody.append("<button onclick='goLastPage("+maxPage+", 6);'>>></button>");
						}
					});
				},
				error:function(){
					console.log("error");
				}
			});
		}
		//주문 조회
		else if(type == 7){
			$.ajax({
				url:"/msmg/selectOrderList",
				type:"get",
				data:{currentPage:currentPage},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#orderTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#orderpageArea");
					$pageBody.html('');
					
					for(var key in data){
						console.log(key);
						if(key == "oList"){
							for(i=0;i<data[key].length;i++){
								var $tr=$("<tr onclick='openOrder("+data[key][i].diet_no+");'>");
								var $noTd=$("<td>").text(data[key][i].diet_no);
								var $dietTd=$("<td>").text(data[key][i].diet_name);
								var $userTd=$("<td>").text(data[key][i].u_name);
								var $dateTd=$("<td>").text(data[key][i].buy_date);
								var $statusTd=$("<td>").text(data[key][i].status);
								
								$tr.append($noTd);
								$tr.append($dietTd);
								$tr.append($userTd);
								$tr.append($dateTd);
								$tr.append($statusTd);
								$tableBody.append($tr);
							}
						}
						else{
							var startPage=data[key].startPage;
							var endPage=data[key].endPage;
							var maxPage=data[key].maxPage;
							var currentPage=data[key].currentPage;
							var limit=data[key].limit;
							var listCount=data[key].listCount;
							
							$pageBody.append("<button onclick='goFirstPage("+currentPage+", 7);'><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick='goPrevPage("+currentPage+", 7);'><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick='goPage("+p+", 7);'>"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick='goNextPage("+currentPage+", 7);'>></button");
							}
							
							$pageBody.append("<button onclick='goLastPage("+maxPage+", 7);'>>></button>");
						}
					}
				},
				error:function(){
					console.log("error");
				}
			});
		}
		//문의 조회
		else if(type == 8){
			$.ajax({
				url:"/msmg/selectQnAList",
				type:"get",
				data:{currentPage:currentPage},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#qnaTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#qnapageArea");
					$pageBody.html('');
					
					for(var key in data){
						console.log(key);
						if(key == "qList"){
							for(i=0;i<data[key].length;i++){
								var $tr=$("<tr onclick='openQnA("+data[key][i].board_id+");'>");
								var $noTd=$("<td>").text(i+1);
								var $titleTd=$("<td>").text(data[key][i].title);
								var $writerTd=$("<td>").text(data[key][i].u_name);
								var $dateTd=$("<td>").text(data[key][i].board_date);
								
								$tr.append($noTd);
								$tr.append($titleTd);
								$tr.append($writerTd);
								$tr.append($dateTd);
								$tableBody.append($tr);
							}							
						}
						else{
							var startPage=data[key].startPage;
							var endPage=data[key].endPage;
							var maxPage=data[key].maxPage;
							var currentPage=data[key].currentPage;
							var limit=data[key].limit;
							var listCount=data[key].listCount;
							
							$pageBody.append("<button onclick='goFirstPage("+currentPage+", 8);'><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick='goPrevPage("+currentPage+", 8);'><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick='goPage("+p+", 8);'>"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick='goNextPage("+currentPage+", 8);'>></button");
							}
							
							$pageBody.append("<button onclick='goLastPage("+maxPage+", 8);'>>></button>");
						}
					}
				},
				error:function(){
					console.log("error");
				}
			});
		}
		
	}
	
	function searchPagingAJAX(currentPage, type, sType, sContent){
		//재료검색
		if(type == 1){
			$.ajax({
				url:"/msmg/searchMatList",
				type:"get",
				data:{currentPage:currentPage, sType:sType, sContent:sContent},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#baseTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#matpageArea");
					$pageBody.html('');
					
					$.each(data, function(index, value){
						if(decodeURIComponent(value.matCode)!="undefined"){
							var $tr=$("<tr>");
							var $noTd=$("<td>").text(decodeURIComponent(value.matCode));
							var $nameTd=$("<td>").text(decodeURIComponent(value.matName));
							var $alleTd=$("<td>").text(decodeURIComponent(value.alleCode));
							var $goTd=$("<td>").text(decodeURIComponent(value.d_go));
							var $dangTd=$("<td>").text(decodeURIComponent(value.d_dang));
							var $headTd=$("<td>").text(decodeURIComponent(value.d_head));
							
							$tr.append($noTd);
							$tr.append($nameTd);
							$tr.append($alleTd);
							$tr.append($goTd);
							$tr.append($dangTd);
							$tr.append($headTd);
							$tableBody.append($tr);
						}
						else{
							var startPage=value.startPage;
							var endPage=value.endPage;
							var maxPage=value.maxPage;
							var currentPage=value.currentPage;
							var limit=value.limit;
							var listCount=value.listCount;
							
							$pageBody.append("<button onclick=\"goFirstSearchPage("+currentPage+", 1, '"+sType+"', '"+sContent+"');\"><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick=\"goPrevSearchPage("+currentPage+", 1, '"+sType+"', '"+sContent+"');\"><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick=\"goSearchPage("+p+", 1, '"+sType+"', '"+sContent+"');\">"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick=\"goNextSearchPage("+currentPage+", 1, '"+sType+"', '"+sContent+"');\">></button");
							}
							
							$pageBody.append("<button onclick=\"goLastSearchPage("+maxPage+", 1, '"+sType+"', '"+sContent+"');\">>></button>");
						}
					});
					
				},
				error:function(){
					console.log("error");
				}
			});
		}
		//메뉴검색
		else if(type == 2){
			$.ajax({
				url:"/msmg/searchMenuList",
				type:"get",
				data:{currentPage:currentPage, sType:sType, sContent:sContent},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#menuTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#menupageArea");
					$pageBody.html('');
					
					$.each(data, function(index, value){
						if(decodeURIComponent(value.menuName)!="undefined"){
							var $tr=$("<tr onclick='openMDetail("+value.menuCode+")'>");
							var $codeTd=$("<td>").text(value.menuCode);
							var $nameTd=$("<td>").text(decodeURIComponent(value.menuName));
							var $mMatTd=$("<td>").text(decodeURIComponent(value.mainMat));
							var $sMatTd=$("<td>").text(decodeURIComponent(value.subMat));
							var $mInfoTd=$("<td>").text(decodeURIComponent(value.info));
							var $priceTd=$("<td>").text(value.price);
							
							$tr.append($codeTd);
							$tr.append($nameTd);
							$tr.append($mMatTd);
							$tr.append($sMatTd);
							$tr.append($mInfoTd);
							$tr.append($priceTd);
							$tableBody.append($tr);
						}
						else{
							var startPage=value.startPage;
							var endPage=value.endPage;
							var maxPage=value.maxPage;
							var currentPage=value.currentPage;
							var limit=value.limit;
							var listCount=value.listCount;
							
							$pageBody.append("<button onclick=\"goFirstSearchPage("+currentPage+", 2, '"+sType+"', '"+sContent+"');\"><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick=\"goPrevSearchPage("+currentPage+", 2, '"+sType+"', '"+sContent+"');\"><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick=\"goSearchPage("+p+", 2, '"+sType+"', '"+sContent+"');\">"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick=\"goNextSearchPage("+currentPage+", 2, '"+sType+"', '"+sContent+"');\">></button");
							}
							
							$pageBody.append("<button onclick=\"goLastSearchPage("+maxPage+", 2, '"+sType+"', '"+sContent+"');\">>></button>");
						}
					});
					
				},
				error:function(){
					console.log("error");
				}
			});
		}
		//공지검색
		else if(type == 3){
			$.ajax({
				url:"/msmg/searchNoticeList",
				type:"get",
				data:{currentPage:currentPage, sType:sType, sContent:sContent},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#noticeTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#noticepageArea");
					$pageBody.html('');
					
					for(var key in data){
						console.log(key);
						
						if(key == "nList"){
							for(i=0;i<data[key].length;i++){
								var $tr=$("<tr onclick='openNotice("+data[key][i].board_no+");'>");
								var $noTd=$("<td>").text(data[key][i].board_no);
								var $titleTd=$("<td>").text(data[key][i].title);
								var $writerTd=$("<td>").text(data[key][i].u_name);
								var $dateTd=$("<td>").text(data[key][i].board_date);
								var $countTd=$("<td>").text(data[key][i].b_count);
								
								$tr.append($noTd);
								$tr.append($titleTd);
								$tr.append($writerTd);
								$tr.append($dateTd);
								$tr.append($countTd);
								$tableBody.append($tr);
							}
						}
						else{
							var startPage=data[key].startPage;
							var endPage=data[key].endPage;
							var maxPage=data[key].maxPage;
							var currentPage=data[key].currentPage;
							var limit=data[key].limit;
							var listCount=data[key].listCount;
							
							$pageBody.append("<button onclick=\"goFirstSearchPage("+currentPage+", 3, '"+sType+"', '"+sContent+"');\"><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick=\"goPrevSearchPage("+currentPage+", 3, '"+sType+"', '"+sContent+"');\"><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick=\"goSearchPage("+p+", 3, '"+sType+"', '"+sContent+"');\">"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick=\"goNextSearchPage("+currentPage+", 3, '"+sType+"', '"+sContent+"');\">></button");
							}
							
							$pageBody.append("<button onclick=\"goLastSearchPage("+maxPage+", 3, '"+sType+"', '"+sContent+"');\">>></button>");
						}
					}
				},
				error:function(data){
					console.log(data);
				}
			});
		}
		//정보검색
		else if(type == 4){
			$.ajax({
				url:"/msmg/searchInfoList",
				type:"get",
				data:{currentPage:currentPage, sType:sType, sContent:sContent},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#infoTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#infopageArea");
					$pageBody.html('');
					
					for(var key in data){
						console.log(key);
						if(key == "infoList"){
							for(i=0;i<data[key].length;i++){
								var $tr=$("<tr onclick='openInfo("+data[key][i].boardId+");'>");
								var $noTd=$("<td>").text(data[key][i].boardNo);
								var $titleTd=$("<td>").text(data[key][i].title);
								var $writerTd=$("<td>").text(data[key][i].uCode);
								var $dateTd=$("<td>").text(data[key][i].boardDate);
								var $countTd=$("<td>").text(data[key][i].bCount);
								
								$tr.append($noTd);
								$tr.append($titleTd);
								$tr.append($writerTd);
								$tr.append($dateTd);
								$tr.append($countTd);
								$tableBody.append($tr);
							}							
						}
						else{
							var startPage=data[key].startPage;
							var endPage=data[key].endPage;
							var maxPage=data[key].maxPage;
							var currentPage=data[key].currentPage;
							var limit=data[key].limit;
							var listCount=data[key].listCount;
							
							$pageBody.append("<button onclick=\"goFirstSearchPage("+currentPage+", 4, '"+sType+"', '"+sContent+"');\"><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick=\"goPrevSearchPage("+currentPage+", 4, '"+sType+"', '"+sContent+"');\"><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick=\"goSearchPage("+p+", 4, '"+sType+"', '"+sContent+"');\">"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick=\"goNextSearchPage("+currentPage+", 4, '"+sType+"', '"+sContent+"');\">></button");
							}
							
							$pageBody.append("<button onclick=\"goLastSearchPage("+maxPage+", 4, '"+sType+"', '"+sContent+"');\">>></button>");
						}
					}
				},
				error:function(data){
					console.log(data);
					console.log("error");
				}
			});
		}
		//후기검색
		else if(type == 5){
			$.ajax({
				url:"/msmg/searchReviewList",
				type:"get",
				data:{currentPage:currentPage, sType:sType, sContent:sContent},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#reviewTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#reviewpageArea");
					$pageBody.html('');
					
					for(var key in data){
						console.log(key);
						if(key == "rList"){
							for(i=0;i<data[key].length;i++){
								var $tr=$("<tr onclick='openReview("+data[key][i].boardId+");'>");
								var $noTd=$("<td>").text(data[key][i].boardNo);
								var $titleTd=$("<td>").text(data[key][i].title);
								var $writerTd=$("<td>").text(data[key][i].uCode);
								var $dateTd=$("<td>").text(data[key][i].boardDate);
								var $countTd=$("<td>").text(data[key][i].bCount);
								
								$tr.append($noTd);
								$tr.append($titleTd);
								$tr.append($writerTd);
								$tr.append($dateTd);
								$tr.append($countTd);
								$tableBody.append($tr);
							}
						}
						else{
							var startPage=data[key].startPage;
							var endPage=data[key].endPage;
							var maxPage=data[key].maxPage;
							var currentPage=data[key].currentPage;
							var limit=data[key].limit;
							var listCount=data[key].listCount;
							
							$pageBody.append("<button onclick=\"goFirstSearchPage("+currentPage+", 5, '"+sType+"', '"+sContent+"');\"><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick=\"goPrevSearchPage("+currentPage+", 5, '"+sType+"', '"+sContent+"');\"><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick=\"goSearchPage("+p+", 5, '"+sType+"', '"+sContent+"');\">"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick=\"goNextSearchPage("+currentPage+", 5, '"+sType+"', '"+sContent+"');\">></button");
							}
							
							$pageBody.append("<button onclick=\"goLastSearchPage("+maxPage+", 5, '"+sType+"', '"+sContent+"');\">>></button>");
						}
					}
				},
				error:function(data){
					console.log(data);
					console.log("error");
				}
			});
		}
		//회원검색
		else if(type == 6){
			$.ajax({
				url:"/msmg/searchMemberList",
				type:"get",
				data:{currentPage:currentPage, sType:sType, sContent:sContent},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#memberTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#memberpageArea");
					$pageBody.html('');
					
					$.each(data, function(index, value){
						if(decodeURIComponent(value.mName)!="undefined"){
							var $tr=$("<tr>");
							var $noTd=$("<td>").text(value.mCode);
							var $nameTd=$("<td>").text(decodeURIComponent(value.mName));
							var $idTd=$("<td>").text(decodeURIComponent(value.mId));
							var $telTd=$("<td>").text(decodeURIComponent(value.mTel));
							var $addrTd=$("<td>").text(decodeURIComponent(value.mAddr));
							var $typeTd=$("<td>").text(decodeURIComponent(value.mType));
							var $dropTd=$("<td>").text(decodeURIComponent(value.mDrop));
							
							$tr.append($noTd);
							$tr.append($nameTd);
							$tr.append($idTd);
							$tr.append($telTd);
							$tr.append($addrTd);
							$tr.append($typeTd);
							$tr.append($dropTd);
							$tableBody.append($tr);
						}
						else{
							var startPage=value.startPage;
							var endPage=value.endPage;
							var maxPage=value.maxPage;
							var currentPage=value.currentPage;
							var limit=value.limit;
							var listCount=value.listCount;
							
							$pageBody.append("<button onclick=\"goFirstSearchPage("+currentPage+", 6, '"+sType+"', '"+sContent+"');\"><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick=\"goPrevSearchPage("+currentPage+", 6, '"+sType+"', '"+sContent+"');\"><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick=\"goSearchPage("+p+", 6, '"+sType+"', '"+sContent+"');\">"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick=\"goNextSearchPage("+currentPage+", 6, '"+sType+"', '"+sContent+"');\">></button");
							}
							
							$pageBody.append("<button onclick=\"goLastSearchPage("+maxPage+", 6, '"+sType+"', '"+sContent+"');\">>></button>");
						}
					});
				},
				error:function(){
					console.log("error");
				}
			});
		}
		//주문검색
		else if(type == 7){
			$.ajax({
				url:"/msmg/searchOrderList",
				type:"get",
				data:{currentPage:currentPage, sType:sType, sContent:sContent},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#orderTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#orderpageArea");
					$pageBody.html('');
					
					for(var key in data){
						console.log(key);
						if(key == "oList"){
							for(i=0;i<data[key].length;i++){
								var $tr=$("<tr onclick='openOrder("+data[key][i].diet_no+");'>");
								var $noTd=$("<td>").text(data[key][i].diet_no);
								var $dietTd=$("<td>").text(data[key][i].diet_name);
								var $userTd=$("<td>").text(data[key][i].u_name);
								var $dateTd=$("<td>").text(data[key][i].buy_date);
								var $statusTd=$("<td>").text(data[key][i].status);
								
								$tr.append($noTd);
								$tr.append($dietTd);
								$tr.append($userTd);
								$tr.append($dateTd);
								$tr.append($statusTd);
								$tableBody.append($tr);
							}
						}
						else{
							var startPage=data[key].startPage;
							var endPage=data[key].endPage;
							var maxPage=data[key].maxPage;
							var currentPage=data[key].currentPage;
							var limit=data[key].limit;
							var listCount=data[key].listCount;
							
							$pageBody.append("<button onclick=\"goFirstSearchPage("+currentPage+", 7, '"+sType+"', '"+sContent+"');\"><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick=\"goPrevSearchPage("+currentPage+", 7, '"+sType+"', '"+sContent+"');\"><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick=\"goSearchPage("+p+", 7, '"+sType+"', '"+sContent+"');\">"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick=\"goNextSearchPage("+currentPage+", 7, '"+sType+"', '"+sContent+"');\">></button");
							}
							
							$pageBody.append("<button onclick=\"goLastSearchPage("+maxPage+", 7, '"+sType+"', '"+sContent+"');\">>></button>");
						}
					}
				},
				error:function(){
					console.log("error");
				}
			});
		}
		//문의검색
		else if(type == 8){
			$.ajax({
				url:"/msmg/searchQnAList",
				type:"get",
				data:{currentPage:currentPage, sType:sType, sContent:sContent},
				success:function(data){
					console.log(data);
					
					$tableBody = $("#qnaTable tbody");
					$tableBody.html('');
					
					$pageBody = $("#qnapageArea");
					$pageBody.html('');
					
					for(var key in data){
						console.log(key);
						if(key == "qList"){
							for(i=0;i<data[key].length;i++){
								var $tr=$("<tr onclick='openQnA("+data[key][i].board_id+");'>");
								var $noTd=$("<td>").text(i+1);
								var $titleTd=$("<td>").text(data[key][i].title);
								var $writerTd=$("<td>").text(data[key][i].u_name);
								var $dateTd=$("<td>").text(data[key][i].board_date);
								
								$tr.append($noTd);
								$tr.append($titleTd);
								$tr.append($writerTd);
								$tr.append($dateTd);
								$tableBody.append($tr);
							}
						}
						else{
							var startPage=data[key].startPage;
							var endPage=data[key].endPage;
							var maxPage=data[key].maxPage;
							var currentPage=data[key].currentPage;
							var limit=data[key].limit;
							var listCount=data[key].listCount;
							
							$pageBody.append("<button onclick=\"goFirstSearchPage("+currentPage+", 8, '"+sType+"', '"+sContent+"');\"><<</button>");
							
							if(currentPage <= 1){
								$pageBody.append("<button disabled><</button>");
							}
							else{
								$pageBody.append("<button onclick=\"goPrevSearchPage("+currentPage+", 8, '"+sType+"', '"+sContent+"');\"><</button>");
							}
							
							for(var p=startPage;p<=endPage;p++){
								if(p == currentPage){
									$pageBody.append("<button disabled>"+p+"</button>");
								}
								else{
									$pageBody.append("<button onclick=\"goSearchPage("+p+", 8, '"+sType+"', '"+sContent+"');\">"+p+"</button>");
								}
							}
							
							if(currentPage >= maxPage){
								$pageBody.append("<button disabled>></button>");
							}
							else{
								$pageBody.append("<button onclick=\"goNextSearchPage("+currentPage+", 8, '"+sType+"', '"+sContent+"');\">></button");
							}
							
							$pageBody.append("<button onclick=\"goLastSearchPage("+maxPage+", 8, '"+sType+"', '"+sContent+"');\">>></button>");
						}
					}
				},
				error:function(){
					console.log("error");
				}
			});
		}
	}
	
	//조회 페이징 메소드
	function goFirstPage(currentPage, type){
		currentPage=1;
		pagingAJAX(currentPage, type);
	}
	
	function goPrevPage(currentPage, type){
		currentPage=currentPage-1;
		pagingAJAX(currentPage, type);
	}
	
	function goPage(p, type){
		pagingAJAX(p, type);
	}
	
	function goNextPage(currentPage, type){
		currentPage=currentPage+1;
		pagingAJAX(currentPage, type);
	}
	
	function goLastPage(maxPage, type){
		pagingAJAX(maxPage, type);
	}
	
	//검색 페이징 메소드
	function goFirstSearchPage(currentPage, type, sType, sContent){
		currentPage=1;
		searchPagingAJAX(currentPage, type, sType, sContent);
	}
	
	function goPrevSearchPage(currentPage, type, sType, sContent){
		currentPage=currentPage-1;
		searchPagingAJAX(currentPage, type, sType, sContent);
	}
	
	function goSearchPage(p, type, sType, sContent){
		console.log("p : " + p)
		console.log("gsp test : " + sType);
		searchPagingAJAX(p, type, sType, sContent);
	}
	
	function goNextSearchPage(currentPage, type, sType, sContent){
		currentPage=currentPage+1;
		searchPagingAJAX(currentPage, type, sType, sContent);
	}
	
	function goLastSearchPage(maxPage, type, sType, sContent){
		searchPagingAJAX(maxPage, type, sType, sContent);
	}
	
	//메뉴 상세보기 메소드
	function openMDetail(menuCode){
		window.open("<%= request.getContextPath() %>/selectOneMenu?menuCode="+menuCode+"", "메뉴 상세보기", "width=340, height=280, top=20, left=20, scrollbars=no");
	}
	
	//공지사항 상세보기 메소드
	function openNotice(boardNo){
		console.log(boardNo);
		window.open("<%= request.getContextPath() %>/noticeDetail.admin?board_no="+boardNo+"", "공지사항 상세보기", "width=1100, height=815, top=20, left=20, scrollbars=no");
	}
	
	//정보게시판 상세보기 메소드
	function openInfo(boardId){
		var num=String(boardId);
		window.open("<%= request.getContextPath() %>/adminInfor?num="+num+"", "정보게시판 상세보기", "width=1100, height=815, top=20, left=20, scrollbars=no");
	}
	
	//후기게시판 상세보기 메소드
	function openReview(boardId){
		var num=String(boardId);
		window.open("<%= request.getContextPath() %>/adminReview?num="+num+"", "후기게시판 상세보기", "width=1100, height=815, top=20, left=20, scrollbars=no");
	}
	
	//주문내역 상세보기 메소드
	function openOrder(dietNo){
		console.log(dietNo);
		window.open("<%= request.getContextPath() %>/selectOneOrderList?dietNo="+dietNo+"&currentPage=1", "주문내역 상세보기", "width=530, height=480, top=20, left=20, scrollbars=no");
	}
	
	//문의내역 상세보기 메소드
	function openQnA(boardId){
		console.log(boardId);
		window.open("<%= request.getContextPath() %>/readQnaDetail.qna?board_id="+boardId+"", "문의내역 상세보기", "width=1100, height=815, top=20, left=20, scrollbars=no");
	}
	
	//고혈압 메뉴 판매 통계
	google.charts.load('current', {packages: ['corechart', 'bar']});
	google.charts.setOnLoadCallback(drawGoSales);
	
	function drawGoSales(){
		
		var jsonData=$.ajax({
			url:"/msmg/statGoMenuCount",
			dataType:"json",
			async:false
		}).responseText;
		
		var jsonSlice=jsonData.slice(1, jsonData.length-1);
		
		var arr=jsonSlice.split("},{");
		
		var arrKey=[];
		var arrValue=[];
		
		if(arr.length == 1){
			var result=JSON.parse(arr[0]);
			
			arrKey.push(result.menu_name);
			arrValue.push(result.sale_count);
		}
		else{
			for(var i=0;i<arr.length;i++){
				var arrSlice;
				var arrParse;
				var result;
				if(i==0){
					arrSlice=arr[i].slice(1, arr[i].length);
					arrParse="{"+arrSlice+"}";
					result=JSON.parse(arrParse);
					
				}
				else if(i==arr.length-1){
					arrSlice=arr[i].slice(0, arr[i].length);
					arrParse="{"+arrSlice;
					result=JSON.parse(arrParse);
					
				}
				else{
					arrParse="{"+arr[i]+"}";
					result=JSON.parse(arrParse);
					
				}
				
				arrKey.push(result.menu_name);
				arrValue.push(result.sale_count);
				
			}
		}
		
		var totalArr=[['메뉴명', '판매량']];
		for(var i=1;i<=arrKey.length;i++){
			for(var k=0;k<2;k++){
				totalArr[i]=[arrKey[i-1], arrValue[i-1]];
			}
		}
		
		var data=new google.visualization.arrayToDataTable(totalArr);
		
		var options={
				title: "고혈압 식단"	
			};
		
		var chart=new google.visualization.ColumnChart(document.getElementById('saleGoStat'));

		chart.draw(data, options);

	}
		
	//당뇨병 메뉴 판매 통계
	google.charts.load('current', {packages: ['corechart', 'bar']});
	google.charts.setOnLoadCallback(drawDangSales);
	
	function drawDangSales(){
		
		var jsonData=$.ajax({
			url:"/msmg/statDangMenuCount",
			dataType:"json",
			async:false
		}).responseText;
		
		var jsonSlice=jsonData.slice(1, jsonData.length-1);
		
		var arr=jsonSlice.split("},{");
		
		var arrKey=[];
		var arrValue=[];
		
		if(arr.length == 1){
			var result=JSON.parse(arr[0]);
			
			arrKey.push(result.menu_name);
			arrValue.push(result.sale_count);
		}
		else{
			for(var i=0;i<arr.length;i++){
				var arrSlice;
				var arrParse;
				var result;
				if(i==0){
					arrSlice=arr[i].slice(1, arr[i].length);
					arrParse="{"+arrSlice+"}";
					result=JSON.parse(arrParse);
					
				}
				else if(i==arr.length-1){
					arrSlice=arr[i].slice(0, arr[i].length);
					arrParse="{"+arrSlice;
					result=JSON.parse(arrParse);
					
				}
				else{
					arrParse="{"+arr[i]+"}";
					result=JSON.parse(arrParse);
					
				}
				
				arrKey.push(result.menu_name);
				arrValue.push(result.sale_count);
				
			}
		}
		
		var totalArr=[['메뉴명', '판매량']];
		for(var i=1;i<=arrKey.length;i++){
			for(var k=0;k<2;k++){
				totalArr[i]=[arrKey[i-1], arrValue[i-1]];
			}
		}
		
		var data=new google.visualization.arrayToDataTable(totalArr);
		
		var options={
				title: "당뇨병 식단"	
			};
		
		var chart=new google.visualization.ColumnChart(document.getElementById('saleDangStat'));

		chart.draw(data, options);

	}
		
	//뇌질환 메뉴 판매 통계
	google.charts.load('current', {packages: ['corechart', 'bar']});
	google.charts.setOnLoadCallback(drawHeadSales);
	
	function drawHeadSales(){
		
		var jsonData=$.ajax({
			url:"/msmg/statHeadMenuCount",
			dataType:"json",
			async:false
		}).responseText;
		
		var jsonSlice=jsonData.slice(1, jsonData.length-1);
		
		var arr=jsonSlice.split("},{");
		
		var arrKey=[];
		var arrValue=[];
		
		if(arr.length == 1){
			var result=JSON.parse(arr[0]);
			
			arrKey.push(result.menu_name);
			arrValue.push(result.sale_count);
		}
		else{
			for(var i=0;i<arr.length;i++){
				var arrSlice;
				var arrParse;
				var result;
				if(i==0){
					arrSlice=arr[i].slice(1, arr[i].length);
					arrParse="{"+arrSlice+"}";
					result=JSON.parse(arrParse);
					
				}
				else if(i==arr.length-1){
					arrSlice=arr[i].slice(0, arr[i].length);
					arrParse="{"+arrSlice;
					result=JSON.parse(arrParse);
					
				}
				else{
					arrParse="{"+arr[i]+"}";
					result=JSON.parse(arrParse);
					
				}
				
				arrKey.push(result.menu_name);
				arrValue.push(result.sale_count);
				
			}
		}
		
		var totalArr=[['메뉴명', '판매량']];
		for(var i=1;i<=arrKey.length;i++){
			for(var k=0;k<2;k++){
				totalArr[i]=[arrKey[i-1], arrValue[i-1]];
			}
		}
		
		var data=new google.visualization.arrayToDataTable(totalArr);
		
		var options={
			title: "뇌질환 식단"	
		};
		
		var chart=new google.visualization.ColumnChart(document.getElementById('saleHeadStat'));

		chart.draw(data, options);

	}
	
	//식단 통계
	google.charts.load('current', {packages: ['corechart']});
	google.charts.setOnLoadCallback(drawDietType);
	
	function drawDietType(){
		var jsonData=$.ajax({
			url:"/msmg/statDietType",
			dataType:"json",
			async:false
		}).responseText;
		
		var obj = JSON.parse(jsonData, function (key, value) {
    	if (key == "go") {
        	return value;
    	} else if(key == "dang"){
        	return value;
    	} else if(key == "head"){
    		return value;
    	} else if(key == "gd"){
    		return value;
    	} else if(key == "gh"){
    		return value;
    	} else if(key == "dh"){
    		return value;
    	} else{
			return value;
    	}
    	
    	});
		
		var data=new google.visualization.arrayToDataTable([
			['식단명', '건 수'],
			['고혈압 식단', obj.go],
			['당뇨병 식단', obj.dang],
			['뇌질환 식단', obj.head],
			['고혈압, 당뇨병 식단', obj.gd],
			['고혈압, 뇌질환 식단', obj.gh],
			['당뇨병, 뇌질환 식단', obj.dh],
			['고혈압, 당뇨병, 뇌질환 식단', obj.gdh]
		]);
		
		
		var options={
				pieHole: 0.3,
		};
		
		var chart=new google.visualization.PieChart(document.getElementById('dietTypeStat'));
		
		chart.draw(data, options);
	}
	
	//결제 수단 통계
	google.charts.load('current', {packages: ['corechart']});
	google.charts.setOnLoadCallback(drawPayType);
	
	function drawPayType(){
		var jsonData=$.ajax({
			url:"/msmg/statPayType",
			dataType:"json",
			async:false
		}).responseText;
		
		var obj = JSON.parse(jsonData, function (key, value) {
    	if (key == "money") {
        	return value;
    	} else {
        	return value;
    	}});
		
		var data=new google.visualization.arrayToDataTable([
			['결제수단', '건 수'],
			['신용카드', obj.card],
			['무통장입금', obj.money]
		]);
		
		
		var options={
				is3D: true
		};
		
		var chart=new google.visualization.PieChart(document.getElementById('payTypeStat'));
		
		chart.draw(data, options);
	}

	$(function(){
		
		//재료추가
		$("#matAdd").click(function(){
			window.open("/msmg/views/admin/addMaterial.jsp", "재료추가", "width=350, height=250, top=20, left=20, scrollbars=no");
		});
		
		//재료조회
		$("#matSearch").click(function(){
			var currentPage=1;
			
			pagingAJAX(currentPage, 1);
			
		});
		
		//재료검색
		$("#matDSearch").click(function(){
			var currentPage=1;
			var stype=$("#matSType").val();
			var sContent=$("#matSText").val();
			
			searchPagingAJAX(currentPage, 1, stype, sContent);
		});
	
		//메뉴추가
		$("#fAdd").click(function(){
			window.open("/msmg/selectMatAddMenu", "메뉴추가", "width=340, height=280, top=20, left=20, scrollbars=no");
		});
		
		//메뉴조회
		$("#fSearch").click(function(){
			var currentPage=1;
			
			pagingAJAX(currentPage, 2);
		});
		
		//메뉴검색
		$("#menuDSearch").click(function(){
			var currentPage=1;
			var stype=$("#menuSType").val();
			var sContent=$("#menuSText").val();
			
			searchPagingAJAX(currentPage, 2, stype, sContent);
		});
		
		//공지작성
		$("#nWrite").click(function(){
			window.open("/msmg/insertNotice.no", "공지작성", "width=1100, height=800, top=20, left=20, scrollbars=no");
		});
		
		//공지조회
		$("#nSearch").click(function(){
			var currentPage=1;
			
			pagingAJAX(currentPage, 3);
		});
		
		//공지검색
		$("#noticeDSearch").click(function(){
			var currentPage=1;
			var stype=$("#noticeSType").val();
			var sContent=$("#noticeSText").val();
			
			searchPagingAJAX(currentPage, 3, stype, sContent);
		});
		
		//정보게시판조회
		$("#iSearch").click(function(){
			var currentPage=1;
			
			pagingAJAX(currentPage, 4);
		});
		
		//정보게시판 검색
		$("#infoDSearch").click(function(){
			var currentPage=1;
			var stype=$("#infoSType").val();
			var sContent=$("#infoSText").val();
			
			searchPagingAJAX(currentPage, 4, stype, sContent);
		});
		
		//후기게시판조회
		$("#rSearch").click(function(){
			var currentPage=1;
			
			pagingAJAX(currentPage, 5);
		});
		
		//후기게시판 검색
		$("#reviewDSearch").click(function(){
			var currentPage=1;
			var stype=$("#reviewSType").val();
			var sContent=$("#reviewSText").val();
			
			searchPagingAJAX(currentPage, 5, stype, sContent);
		});
		
		//회원조회
		$("#mSearch").click(function(){
			var currentPage=1;
			
			pagingAJAX(currentPage, 6);
		});
		
		//회원검색
		$("#memberDSearch").click(function(){
			var currentPage=1;
			var stype=$("#memberSType").val();
			var sContent=$("#memberSText").val();
			
			searchPagingAJAX(currentPage, 6, stype, sContent);
		});
		
		//주문조회
		$("#oSearch").click(function(){
			var currentPage=1;
			
			pagingAJAX(currentPage, 7);
		});
		
		//주문내역 검색
		$("#orderDSearch").click(function(){
			var currentPage=1;
			var stype=$("#orderSType").val();
			var sContent=$("#orderSText").val();
			
			searchPagingAJAX(currentPage, 7, stype, sContent);
		});
		
		//문의조회
		$("#qSearch").click(function(){
			var currentPage=1;
			
			pagingAJAX(currentPage, 8);
		});
		
		//문의내역 검색
		$("#qnaDSearch").click(function(){
			var currentPage=1;
			var stype=$("#qnaSType").val();
			var sContent=$("#qnaSText").val();
			
			searchPagingAJAX(currentPage, 8, stype, sContent);
		});
	});
</script>
</head>
<body>
<%-- <% if(loginUser != null && loginUser.getU_name().equals("admin")){ %> --%>
	<div class="container">
  		<div id="info">
  			<div id="infoIcon">
	  			<img src="/msmg/images/admin/adminUserIcon.png" id="adminIcon">
	  			<br>
	  			<label style="margin-left:10px;"><%= loginUser.getU_name() %> 님</label>
  			</div>
  			<div id="infoLogout" align="right">
  				<a onclick="logout();">로그아웃</a>
  			</div>
  		</div>
  		<br><br><br>
  		<ul class="nav nav-pills nav-stacked">
    		<li><a href="#food">메뉴 관리</a></li>
    		<li><a href="#board">게시판 관리</a></li>
    		<li><a href="#member">회원 관리</a></li>
    		<li><a href="#stat">통계</a></li>
  		</ul>
	</div>
	<div class="content">
		<div id="food">
			<h2 style="margin-left:1%;">메뉴 관리</h2>
			<hr>
			<div id="food-1">
				<h4 style="margin-left:5%;">재료</h4>
				<table id="baseTable" border="1">
					<thead>
						<tr height="20px">
							<td colspan="6" style="text-align:right;">
								<select name="matSType" id="matSType">
									<option value="grad_code">재료코드</option>
									<option value="grad_name">재료명</option>
									<option value="al_code">알레르기코드</option>
									<option value="go">고혈압</option>
									<option value="dang">당뇨병</option>
									<option value="head">뇌질환</option>
								</select>
								<input type="text" name="matSText" id="matSText" size="20">
								<button id="matDSearch">검색</button>&nbsp;
								<button id="matSearch">조회</button>&nbsp;
								<button id="matAdd">추가</button>
							</td>
						</tr>
						<tr height="45px" style="background:#D1D1D1;">
							<td width="10%"><b>재료코드</b></td>
							<td width="30%"><b>재료명</b></td>
							<td width="10%"><b>알레르기코드</b></td>
							<td width="15%"><b>고혈압</b></td>
							<td width="15%"><b>당뇨병</b></td>
							<td width="15%"><b>뇌질환</b></td>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
				<br>
				<div id="matpageArea" align="center">
					
				</div>
			</div>
			<div id="food-2">
				<h4 style="margin-left:5%;">메뉴</h4>
				<table id="menuTable" border="1">
					<thead>
						<tr height="20px">
							<td colspan="6" style="text-align:right;">
								<select name="menuSType" id="menuSType">
									<option value="menu_code">메뉴코드</option>
									<option value="menu_name">메뉴명</option>
									<option value="menu_main">주재료</option>
									<option value="menu_sub">보조재료</option>
									<option value="menu_info">메뉴정보</option>
									<option value="price">가격</option>
								</select>
								<input type="text" name="menuSText" id="menuSText" size="20">
								<button id="menuDSearch">검색</button>&nbsp;
								<button id="fSearch">조회</button>&nbsp;
								<button id="fAdd">추가</button>
							</td>
						</tr>
						<tr height="45px" style="background:#D1D1D1;">
							<td width="15%"><b>메뉴코드</b></td>
							<td width="20%"><b>메뉴명</b></td>
							<td width="15%"><b>주재료</b></td>
							<td width="15%"><b>보조재료</b></td>
							<td width="25%"><b>메뉴정보</b></td>
							<td width="10%"><b>가격</b></td>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
				<br>
				<div id="menupageArea" align="center">
					
				</div>
			</div>
		</div>
		<div id="board">
			<h2 style="margin-left:1%;">게시판 관리</h2>
			<hr>
			<div id="board-1">
				<h4 style="margin-left:5%;">공지사항</h4>
				<table id="noticeTable" border="1">
					<thead>
						<tr height="20px">
							<td colspan="5" style="text-align:right;">
								<select name="noticeSType" id="noticeSType">
									<option value="title">제목</option>
									<option value="u_name">작성자</option>
								</select>
								<input type="text" name="noticeSText" id="noticeSText" size="20">
								<button id="noticeDSearch">검색</button>&nbsp;
								<button id="nSearch">조회</button>&nbsp;
								<button id="nWrite">작성</button>
							</td>
						</tr>
						<tr height="45px" style="background:#D1D1D1;">
							<td width="10%"><b>글번호</b></td>
							<td width="25%"><b>제목</b></td>
							<td width="10%"><b>작성자</b></td>
							<td width="15%"><b>작성일</b></td>
							<td width="10%"><b>조회수</b></td>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
				<br>
				<div id="noticepageArea" align="center">
					
				</div>
			</div>
			<div id="board-2">
				<h4 style="margin-left:5%;">정보게시판</h4>
				<table id="infoTable" border="1">
					<thead>
						<tr height="20px">
							<td colspan="5" style="text-align:right;">
								<select name="infoSType" id="infoSType">
									<option value="title">제목</option>
									<option value="u_name">작성자</option>
								</select>
								<input type="text" name="infoSText" id="infoSText" size="20">
								<button id="infoDSearch">검색</button>&nbsp;
								<button id="iSearch">조회</button>
							</td>
						</tr>
						<tr height="45px" style="background:#D1D1D1;">
							<td width="10%"><b>글번호</b></td>
							<td width="25%"><b>제목</b></td>
							<td width="10%"><b>작성자</b></td>
							<td width="15%"><b>작성일</b></td>
							<td width="10%"><b>조회수</b></td>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
				<br>
				<div id="infopageArea" align="center">
					
				</div>
			</div>
			<div id="board-3">
				<h4 style="margin-left:5%;">후기게시판</h4>
				<table id="reviewTable" border="1">
					<thead>
						<tr height="20px">
							<td colspan="5" style="text-align:right;">
								<select name="reviewSType" id="reviewSType">
									<option value="title">제목</option>
									<option value="u_name">작성자</option>
								</select>
								<input type="text" name="reviewSText" id="reviewSText" size="20">
								<button id="reviewDSearch">검색</button>&nbsp;
								<button id="rSearch">조회</button>
							</td>
						</tr>
						<tr height="45px" style="background:#D1D1D1;">
							<td width="10%"><b>글번호</b></td>
							<td width="25%"><b>제목</b></td>
							<td width="10%"><b>작성자</b></td>
							<td width="15%"><b>작성일</b></td>
							<td width="10%"><b>조회수</b></td>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
				<br>
				<div id="reviewpageArea" align="center">
					
				</div>
			</div>
		</div>
		<div id="member">
			<h2 style="margin-left:1%;">회원 관리</h2>
			<hr>
			<div id="member-1">
				<h4 style="margin-left:5%;">회원내역</h4>
				<table id="memberTable" border="1">
					<thead>
						<tr height="20px">
							<td colspan="7" style="text-align:right;">
								<select name="memberSType" id="memberSType">
									<option value="u_code">회원코드</option>
									<option value="u_name">회원명</option>
									<option value="u_id">아이디</option>
									<option value="tel">연락처</option>
									<option value="des">주소</option>
									<option value="type">구분</option>
									<option value="drop_yn">회원상태</option>
								</select>
								<input type="text" name="memberSText" id="memberSText" size="20">
								<button id="memberDSearch">검색</button>&nbsp;
								<button id="mSearch">조회</button>
							</td>
						</tr>
						<tr height="45px" style="background:#D1D1D1;">
							<td width="10%"><b>회원코드</b></td>
							<td width="10%"><b>회원명</b></td>
							<td width="20%"><b>아이디</b></td>
							<td width="10%"><b>연락처</b></td>
							<td width="30%"><b>주소</b></td>
							<td width="10%"><b>구분</b></td>
							<td width="10%"><b>회원상태</b></td>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
				<br>
				<div id="memberpageArea" align="center">
					
				</div>
			</div>
			<div id="member-2">
				<h4 style="margin-left:5%;">주문내역</h4>
				<table id="orderTable" border="1">
					<thead>
						<tr height="20px">
							<td colspan="5" style="text-align:right;">
								<select name="orderSType" id="orderSType">
									<option value="diet_no">식단번호</option>
									<option value="diet_name">식단명</option>
									<option value="u_name">주문자</option>
									<option value="buy_date">주문일</option>
									<option value="status">싱픔상태</option>
								</select>
								<input type="text" name="orderSText" id="orderSText" size="20">
								<button id="orderDSearch">검색</button>&nbsp;
								<button id="oSearch">조회</button>
							</td>
						</tr>
						<tr height="45px" style="background:#D1D1D1;">
							<td width="10%"><b>식단번호</b></td>
							<td width="30%"><b>식단명</b></td>
							<td width="20%"><b>주문자</b></td>
							<td width="20%"><b>주문일</b></td>
							<td width="10%"><b>상품상태</b></td>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
				<br>
				<div id="orderpageArea" align="center">
					
				</div>
			</div>
			<div id="member-3">
				<h4 style="margin-left:5%;">문의내역</h4>
				<table id="qnaTable" border="1">
					<thead>
						<tr height="20px">
							<td colspan="4" style="text-align:right;">
								<select name="qnaSType" id="qnaSType">
									<option value="title">제목</option>
									<option value="u_name">작성자</option>
								</select>
								<input type="text" name="qnaSText" id="qnaSText" size="20">
								<button id="qnaDSearch">검색</button>&nbsp;
								<button id="qSearch">조회</button>
							</td>
						</tr>
						<tr height="45px" style="background:#D1D1D1;">
							<td width="10%"><b>글번호</b></td>
							<td width="30%"><b>제목</b></td>
							<td width="10%"><b>작성자</b></td>
							<td width="15%"><b>작성일</b></td>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
				<br>
				<div id="qnapageArea" align="center">
					
				</div>
			</div>
		</div>
		<div id="stat">
			<h2 style="margin-left:1%;">통계</h2>
			<hr>
			<div id="stat-1">
				<h4 style="margin-left:5%;">식단별 메뉴 판매량</h4>
				<br>
				<div id="refreshArea" onclick="drawGoSales();" align="right"><img src="/msmg/images/admin/refreshIcon.png"></div>
				<div id="saleGoStat"></div>
				<br>
				<div id="refreshArea" onclick="drawDangSales();" align="right"><img src="/msmg/images/admin/refreshIcon.png"></div>
				<div id="saleDangStat"></div>
				<br>
				<div id="refreshArea" onclick="drawHeadSales();" align="right"><img src="/msmg/images/admin/refreshIcon.png"></div>
				<div id="saleHeadStat"></div>
			</div>
			<div id="stat-2">
				<h4 style="margin-left:5%;">식단</h4>
				<br>
				<div id="refreshArea" onclick="drawDietType();" align="right"><img src="/msmg/images/admin/refreshIcon.png"></div>
				<div id="dietTypeStat"></div>
			</div>
			<div id="stat-3">
				<h4 style="margin-left:5%;">결제수단</h4>
				<br>
				<div id="refreshArea" onclick="drawPayType();" align="right"><img src="/msmg/images/admin/refreshIcon.png"></div>
				<div id="payTypeStat"></div>
			</div>
		</div>
	</div>
<%-- <% } else { System.out.println("관리자 아님"); } %> --%>
</body>
</html>