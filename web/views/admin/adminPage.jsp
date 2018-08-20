<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
	#adminAlert{
		width:8%;
		height:100%;
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
	#food, #board, #member{
		height:200%;
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
</style>
<script>
	function logout(){
		var check = window.confirm("로그아웃 하시겠습니까?");
		
		if(check == true){
			location.href = "<%= request.getContextPath() %>/logout.me"
		}
	}

	$(function(){
		
		//재료추가
		$("#matAdd").click(function(){
			window.open("/msmg/views/admin/addMaterial.jsp", "재료추가", "width=350, height=250, top=20, left=20, scrollbars=no");
		});
		
		//재료조회
		$("#matSearch").click(function(){
			$.ajax({
				url:"/msmg/selectMatList",
				type:"get",
				success:function(data){
					console.log(data);
					
					$tableBody = $("#baseTable tbody");
					$tableBody.html('');
					
					$.each(data, function(index, value){
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
					});
				},
				error:function(){
					console.log("error");
				}
			});
		});
	
		//메뉴추가
		$("#fAdd").click(function(){
			window.open("/msmg/views/admin/addMenu.jsp", "메뉴추가", "width=350, height=250, top=20, left=20, scrollbars=no");
		});
		
		//메뉴조회
		$("#fSearch").click(function(){
			$.ajax({
				url:"selectFoodList",
				type:"get",
				success:function(data){
					/* console.log(data);
					
					$tableBody = $("#userInfoTable tbody");
					$tableBody.html('');
					
					$.each(data, function(index, value){
						var $tr=$("<tr>");
						var $noTd=$("<td>").text(value.userNo);
						var $nameTd=$("<td>").text(decodeURIComponent(value.userName));
						var $nationTd=$("<td>").text(decodeURIComponent(value.userNation));
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nationTd);
						$tableBody.append($tr);
					}); */
				},
				error:function(){
					console.log("error");
				}
			});
		});
		
		//공지조회
		$("#nSearch").click(function(){
			$.ajax({
				url:"selectNoticeList",
				type:"get",
				success:function(data){
					/* console.log(data);
					
					$tableBody = $("#userInfoTable tbody");
					$tableBody.html('');
					
					$.each(data, function(index, value){
						var $tr=$("<tr>");
						var $noTd=$("<td>").text(value.userNo);
						var $nameTd=$("<td>").text(decodeURIComponent(value.userName));
						var $nationTd=$("<td>").text(decodeURIComponent(value.userNation));
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nationTd);
						$tableBody.append($tr);
					}); */
				},
				error:function(){
					console.log("error");
				}
			});
		});
		
		//공지작성
		$("#nWrite").click(function(){
			window.open("/msmg/index.jsp");
		});
		
		//정보게시판조회
		$("#iSearch").click(function(){
			$.ajax({
				url:"selectInfoList",
				type:"get",
				success:function(data){
					/* console.log(data);
					
					$tableBody = $("#userInfoTable tbody");
					$tableBody.html('');
					
					$.each(data, function(index, value){
						var $tr=$("<tr>");
						var $noTd=$("<td>").text(value.userNo);
						var $nameTd=$("<td>").text(decodeURIComponent(value.userName));
						var $nationTd=$("<td>").text(decodeURIComponent(value.userNation));
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nationTd);
						$tableBody.append($tr);
					}); */
				},
				error:function(){
					console.log("error");
				}
			});
		});
		
		//후기게시판조회
		$("#rSearch").click(function(){
			$.ajax({
				url:"selectReviewList",
				type:"get",
				success:function(data){
					/* console.log(data);
					
					$tableBody = $("#userInfoTable tbody");
					$tableBody.html('');
					
					$.each(data, function(index, value){
						var $tr=$("<tr>");
						var $noTd=$("<td>").text(value.userNo);
						var $nameTd=$("<td>").text(decodeURIComponent(value.userName));
						var $nationTd=$("<td>").text(decodeURIComponent(value.userNation));
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nationTd);
						$tableBody.append($tr);
					}); */
				},
				error:function(){
					console.log("error");
				}
			});
		});
		
		//회원조회
		$("#mSearch").click(function(){
			$.ajax({
				url:"/msmg/selectMemberList",
				type:"get",
				success:function(data){
					console.log(data);
					
					$tableBody = $("#memberTable tbody");
					$tableBody.html('');
					
					$.each(data, function(index, value){
						var $tr=$("<tr>");
						var $noTd=$("<td>").text(value.mCode);
						var $nameTd=$("<td>").text(decodeURIComponent(value.mName));
						var $idTd=$("<td>").text(decodeURIComponent(value.mId));
						var $telTd=$("<td>").text("-");
						var $addrTd=$("<td>").text("-");
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
					});
				},
				error:function(){
					console.log("error");
				}
			});
		});
		
		//주문조회
		$("#oSearch").click(function(){
			$.ajax({
				url:"selectOrderList",
				type:"get",
				success:function(data){
					/* console.log(data);
					
					$tableBody = $("#userInfoTable tbody");
					$tableBody.html('');
					
					$.each(data, function(index, value){
						var $tr=$("<tr>");
						var $noTd=$("<td>").text(value.userNo);
						var $nameTd=$("<td>").text(decodeURIComponent(value.userName));
						var $nationTd=$("<td>").text(decodeURIComponent(value.userNation));
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nationTd);
						$tableBody.append($tr);
					}); */
				},
				error:function(){
					console.log("error");
				}
			});
		});
		
		//문의조회
		$("#qSearch").click(function(){
			$.ajax({
				url:"selectQnAList",
				type:"get",
				success:function(data){
					/* console.log(data);
					
					$tableBody = $("#userInfoTable tbody");
					$tableBody.html('');
					
					$.each(data, function(index, value){
						var $tr=$("<tr>");
						var $noTd=$("<td>").text(value.userNo);
						var $nameTd=$("<td>").text(decodeURIComponent(value.userName));
						var $nationTd=$("<td>").text(decodeURIComponent(value.userNation));
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nationTd);
						$tableBody.append($tr);
					}); */
				},
				error:function(){
					console.log("error");
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="container">
  		<div id="info">
  			<div id="infoAlert" align="right">
  				<a href="#">
	  				<img src="/msmg/images/admin/adminAlertIcon.png" id="adminAlert">
  				</a>
  			</div>
  			<div id="infoIcon">
	  			<img src="/msmg/images/admin/adminUserIcon.png" id="adminIcon">
	  			<br>
	  			<label style="margin-left:10px;">관리자 님</label>
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
  		</ul>
	</div>
	<div class="content">
		<div id="food">
			<h2 style="margin-left:1%;">메뉴 관리</h2>
			<hr>
			<h4 style="margin-left:5%;">재료</h4>
			<table id="baseTable" border="1">
				<thead>
					<tr height="20px">
						<td colspan="6" style="text-align:right;"><button id="matSearch">조회</button>&nbsp;<button id="matAdd">추가</button></td>
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
			<h4 style="margin-left:5%;">메뉴</h4>
			<table id="menuTable" border="1">
				<thead>
					<tr height="20px">
						<td colspan="4" style="text-align:right;"><button id="fSearch">조회</button>&nbsp;<button id="fAdd">추가</button></td>
					</tr>
					<tr height="45px" style="background:#D1D1D1;">
						<td width="15%"><b>메뉴코드</b></td>
						<td width="30%"><b>메뉴명</b></td>
						<td width="10%"><b>가격</b></td>
						<td width="45%"><b>메뉴정보</b></td>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
			<br>
			<h4 style="margin-left:5%;">판매 통계</h4>
		</div>
		<div id="board">
			<h2 style="margin-left:1%;">게시판 관리</h2>
			<hr>
			<h4 style="margin-left:5%;">공지사항</h4>
			<table id="noticeTable" border="1">
				<thead>
					<tr height="20px">
						<td colspan="4" style="text-align:right;"><button id="nSearch">조회</button>&nbsp;<button id="nWrite">작성</button></td>
					</tr>
					<tr height="45px" style="background:#D1D1D1;">
						<td width="15%"><b>글번호</b></td>
						<td width="30%"><b>제목</b></td>
						<td width="10%"><b>작성자</b></td>
						<td width="45%"><b>내용</b></td>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
			<br>
			<h4 style="margin-left:5%;">정보게시판</h4>
			<table id="infoTable" border="1">
				<thead>
					<tr height="20px">
						<td colspan="4" style="text-align:right;"><button id="iSearch">조회</button></td>
					</tr>
					<tr height="45px" style="background:#D1D1D1;">
						<td width="15%"><b>글번호</b></td>
						<td width="30%"><b>제목</b></td>
						<td width="10%"><b>작성자</b></td>
						<td width="45%"><b>내용</b></td>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
			<br>
			<h4 style="margin-left:5%;">후기게시판</h4>
			<table id="reviewTable" border="1">
				<thead>
					<tr height="20px">
						<td colspan="4" style="text-align:right;"><button id="rSearch">조회</button></td>
					</tr>
					<tr height="45px" style="background:#D1D1D1;">
						<td width="15%"><b>글번호</b></td>
						<td width="30%"><b>제목</b></td>
						<td width="10%"><b>작성자</b></td>
						<td width="45%"><b>내용</b></td>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
		</div>
		<div id="member">
			<h2 style="margin-left:1%;">회원 관리</h2>
			<hr>
			<h4 style="margin-left:5%;">회원내역</h4>
			<table id="memberTable" border="1">
				<thead>
					<tr height="20px">
						<td colspan="7" style="text-align:right;"><button id="mSearch">조회</button></td>
					</tr>
					<tr height="45px" style="background:#D1D1D1;">
						<td width="10%"><b>회원코드</b></td>
						<td width="10%"><b>회원명</b></td>
						<td width="20%"><b>아이디</b></td>
						<td width="10%"><b>연락처</b></td>
						<td width="30%"><b>주소</b></td>
						<td width="10%"><b>구분</b></td>
						<td width="10%"><b>탈퇴유무</b></td>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
			<br>
			<h4 style="margin-left:5%;">주문내역</h4>
			<table id="orderTable" border="1">
				<thead>
					<tr height="20px">
						<td colspan="4" style="text-align:right;"><button id="oSearch">조회</button></td>
					</tr>
					<tr height="45px" style="background:#D1D1D1;">
						<td width="15%"><b>메뉴코드</b></td>
						<td width="30%"><b>메뉴명</b></td>
						<td width="10%"><b>가격</b></td>
						<td width="45%"><b>메뉴정보</b></td>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
			<br>
			<h4 style="margin-left:5%;">문의내역</h4>
			<table id="qnaTable" border="1">
				<thead>
					<tr height="20px">
						<td colspan="4" style="text-align:right;"><button id="qSearch">조회</button></td>
					</tr>
					<tr height="45px" style="background:#D1D1D1;">
						<td width="15%"><b>글번호</b></td>
						<td width="30%"><b>제목</b></td>
						<td width="10%"><b>작성자</b></td>
						<td width="45%"><b>내용</b></td>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
			<br>
			<h4 style="margin-left:5%;">결제수단 통계</h4>
		</div>
	</div>
</body>
</html>