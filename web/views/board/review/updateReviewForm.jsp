<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.msmg.board.review.model.vo.*, java.util.*
	, com.msmg.board.information.model.vo.*"%>
<%
	Board b = (Board)request.getAttribute("b");
	ArrayList<BoardFile> bf = (ArrayList<BoardFile>)request.getAttribute("fileList");
%>

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>후기게시판 글 수정</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<style>
 
 #back {
	width:100%;
	height:400px;
	background-image:url("/msmg/images/common/review.png");
	margin-bottom:20px;
}

.outer {
	width: 800px;
	height: 1300px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

.titleN {
	background: tomato;
	color: white;
	width: 100px;
	height: 40px;
	text-align: center;
}

#memo {
	width: 800px;
	height: 500px;
	border: 0;
}

.btn {
	background:tomato;
	border:none;
	float: right;
	margin-left: 10px;
}

.btn:hover {
	background:tomato;
}

hr {
	border-color: #f77a68;
}

#tableView {
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

#view2 {
	float: left;
}

.p1 {
	float: left;
	margin-right: 20px;
}

#view3 {
	float: right;
}

.p2 {
	float: left;
	margin-left: 20px;
}

.con {
	float:left;
	padding-right:10px;
	
}


#ImgTable td {
	padding:20px;
}


#contentImgArea1:hover, #contentImgArea2:hover,
	#contentImgArea3:hover, #contentImgArea4:hover, #contentImgArea5:hover {
	cursor:pointer;
	}
	
#mainBottom {
	width:100%;
	height:200px;
}

#content {
	width:800px;
	height:400px;
}

#content22 {
	width:800px;
	height:400px;
}

#contentImg {
	width:100%;
	height:100px;
	margin-left:50px;
}

#date-writer-hit2 {
	display: inline-block;
	margin: 0;
	padding: 0;
	font-size: 12px;
	color: #555;
	text-align: right;
	margin-top: 10px;
	border-bottom:1px solid tomato;
	margin-right:10px;
	margin-left:auto;
	margin-right:auto;
}

div[id=date-writer-hit2] {
	width:730;
	border-bottom: 1px solid black;

}

#date-writer-hit {
	margin-left:10px;
	float:left;
}

.btn{
	color:white;
}

.btn:hover{
	color:white;
}

</style>
</head>
<body>
<div id="back">
	<%@ include file="../../common/menubar.jsp"%>
</div>
	<div class="outer">
		<!-- <h2 align="left"><b>후기 게시판 글 작성</b></h2> -->
		<%-- <%java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm"); %> --%>
		<br>
		<div id="view">
		<%java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd"); %>
		<form action="<%=request.getContextPath() %>/updateList.rev" method="post" accept-charset="UTF-8" encType="multipart/form-data">
			<table id="tableView">
				<tr id="tableView2" style="border-bottom: 1px solid lightgray">
					<td class="titleN" id="title">제목</td>
					<td><input type="text" name="title" id="title2"
						style="background-color: transparent; border: 0 solid black; text-align: left; width: 350px; margin-left:20px;" value="<%=b.getTitle() %>"></td>
					<td class="titleN" id="date">작성일</td>
					<td><input type="text" name="date" id="date2"
						style="background-color: transparent; border: 0 solid black; text-align: center; width: 250px;" 
						value="<%=df.format(new Date())%>" readonly></td>
					<td><input type="hidden" name="boardId" value="<%=b.getBoardId() %>"></td>
					
				</tr>
				<table id="ImgTable">
				<tr>
					<td><input type="text" id="content22" name="content"
						style="resize:none;" value="<%=b.getContent()%>"></input></td>
					<td><input type="hidden" id="count" value="<%=b.getbCount()%>"></td>
					<td><input type="hidden" id="boardId" value="<%=b.getBoardId()%>"></td>
					<%-- 
					<%for (int i = 0; i < bf.size(); i++) {%>
					<td><input type="hidden" id="fileNo"value="<%=bf.get(i).getFile_no() %>"></td>
					<td><input type="hidden" id="fileNo" name="BoardId" value="<%=bf.get(i).getBoard_id() %>"></td>
					<td><input type="hidden" id="fileNo" name="FileType" value="<%=bf.get(i).getFile_type() %>"></td>
					<td><input type="hidden" id="fileNo" name="BoardSort" value="<%=bf.get(i).getBoard_sort()%>"></td>
					<%} %> --%>
				</tr>
				<tr>
				<div>
					<td>
					<div id="contentImg">
						
							<div class="con" id="contentImgArea1">
								<img id="contentImg1" width="120px" height="100px">
							</div>
							<div class="con" id="contentImgArea2">
								<img id="contentImg2" width="120px" height="100px">
							</div>
							<div class="con" id="contentImgArea3">
								<img id="contentImg3" width="120px" height="100px">
							</div>
							<div class="con" id="contentImgArea4" style="display:none;">
								<img id="contentImg4" width="120px" height="100px">
							</div>
							<div class="con" id="contentImgArea5" style="display:none;">
								<img id="contentImg5" width="120px" height="100px">
							</div>
							
						
					</div>
				</td>
					
				</div>
				</tr>
				</table>
				
				<p>이미지 추가 (최대 5개)</p>
				<div id="AddBtn" onclick="AddButton();"><i class="far fa-plus-square fa-lg"></i></div>
				<div id="AddBtn2" onclick="AddButton2();" style="display:none;"><i class="far fa-plus-square fa-lg"></i></div>
				<script>
					function AddButton(){
		        			$("#contentImgArea4").show();
		        			$("#AddBtn").hide();
		        			$("#AddBtn2").show();
		       		}
					
					function AddButton2(){
							$("#contentImgArea5").show();
					}
				</script> 
				
			</table>
			<div id="fileArea">
				<input type="file" id="thumbnailImg1" name="thumbnailImg1" multiple onchange="loadImg(this, 1)">
				<input type="file" id="thumbnailImg2" name="thumbnailImg2" multiple onchange="loadImg(this, 2)">
				<input type="file" id="thumbnailImg3" name="thumbnailImg3" multiple onchange="loadImg(this, 3)">
				<input type="file" id="thumbnailImg4" name="thumbnailImg4" multiple onchange="loadImg(this, 4)">
				<input type="file" id="thumbnailImg5" name="thumbnailImg5" multiple onchange="loadImg(this, 5)">
			
			</div>
		<hr>
		<br>
		<div id="writeBtn">
			<button type="button" class="btn" value="취소" OnClick="window.location='reviewThumbnailList.jsp'">취소</button>
			&nbsp;
			<button id="updateBtn" type="submit" class="btn" >수정 완료</button>
		</div>
		</form>
	</div>
</div>

<script>
	$(function(){
		$("#fileArea").hide();
		
		$("#contentImgArea1").click(function(){
			$("#thumbnailImg1").click();
		});
		
		$("#contentImgArea2").click(function(){
			$("#thumbnailImg2").click();
		});
		
		$("#contentImgArea3").click(function(){
			$("#thumbnailImg3").click();
		});
		
		$("#contentImgArea4").click(function(){
			$("#thumbnailImg4").click();
		});
		
		$("#contentImgArea5").click(function(){
			$("#thumbnailImg5").click();
		});
	});
	
	function loadImg(value, num){
		if(value.files && value.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				switch(num){
					case 1 : $("#contentImg1").attr("src", e.target.result); break;
					case 2 : $("#contentImg2").attr("src", e.target.result); break;
					case 3 : $("#contentImg3").attr("src", e.target.result); break;
					case 4 : $("#contentImg4").attr("src", e.target.result); break;
					case 5 : $("#contentImg5").attr("src", e.target.result); break;
				}
			}
			reader.readAsDataURL(value.files[0]);
		}
	}
</script>
	
<div id="mainBottom">
<%@include file = "../../common/footer.jsp" %>
</div>
</body>
</html>