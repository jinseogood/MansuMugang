<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>


<style>
/* body {
	background: pink;
 }*/
 
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
	background: #25e849;
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
	float: right;
	margin-left: 10px;
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
}

#ImgTable td {
	padding:20px;
}

.con {
	padding-right:10px;
}

#titleImgArea:hover, #contentImgArea1:hover, #contentImgArea2:hover,
	#contentImgArea3:hover {
	cursor:pointer;
	}
	
#mainBottom {
	width:100%;
	height:200px;
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
			<table id="tableView">
				<tr id="tableView2" style="border-bottom: 1px solid lightgray">
					<td class="titleN" id="title">제목</td>
					<td><input type="text"
						style="background-color: transparent; border: 0 solid black; text-align: left; width: 350px;"></td>
					<td class="titleN" id="date">작성일</td>
					<td><input type="text"
						style="background-color: transparent; border: 0 solid black; text-align: left; width: 250px;"></td>
				</tr>
				<table id="ImgTable" align="center">
				<tr>
					<td>* 대표 이미지</td>
					<td>
						<div id="titleImgArea">
							<img id="titleImg" width="380px" height="200px" style="margin-top:10px; margin-bottom:10px">
						</div>
					</td>
				</tr>
				<tr>
					<td>추가 사진</td>
					<td>
						<div class="con" id="contentImgArea1">
							<img id="contentImg1" width="120px" height="100px">
						</div>
						<div class="con" id="contentImgArea2">
							<img id="contentImg2" width="120px" height="100px">
						</div>
						<div class="con" id="contentImgArea3">
							<img id="contentImg3" width="120px" height="100px">
						</div>
					</td>
				</tr>
				<tr>
					<td>사진 메모</td>
					<td><textArea name="content" row="10" cols="45"
						style="resize:none"></textArea></td>
				</tr>
				</table>
			</table>
			<div id="fileArea">
				<input type="file" id="thumbnailImg1" name="thumbnailImg1" multiple onchange="loading(this, 1)">
				<input type="file" id="thumbnailImg2" name="thumbnailImg2" multiple onchange="loading(this, 2)">
				<input type="file" id="thumbnailImg3" name="thumbnailImg3" multiple onchange="loading(this, 3)">
				<input type="file" id="thumbnailImg4" name="thumbnailImg4" multiple onchange="loading(this, 4)">
			</div>
		<hr>
		<br>
		<div id="writeBtn">
			<button type="button" class="btn btn-primary" value="취소" OnClick="window.location='reviewThumbnailList.jsp'">취소</button>
			&nbsp;
			<button type="button" class="btn btn-primary" value="등록 완료" OnClick="window.location='review_SignUp.jsp'">등록 완료</button>
		</div>
	</div>
</div>

<script>
	$(function(){
		$("#titleImgArea").click(function(){
			$("#thumbnailImg1").click();
		});
		
		$("#contentImgArea1").click(function(){
			$("#thumbnailImg2").click();
		});
		
		$("#contentImgArea2").click(function(){
			$("#thumbnailImg3").click();
		});
		
		$("#contentImgArea3").click(function(){
			$("#thumbnailImg4").click();
		});
		
	});
	
	function loadImg(value, num){
		if(value.files && value.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				switch(num){
					case 1 : $("#titleImg").attr("src", e.target.result); break;
					case 2 : $("#contentImg1").attr("src", e.target.result); break;
					case 3 : $("#contentImg2").attr("src", e.target.result); break;
					case 4 : $("#contentImg3").attr("src", e.target.result); break;
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