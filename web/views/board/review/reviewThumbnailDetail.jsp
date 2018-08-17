<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>썸네일 상세보기</title>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
/* body {
	background:pink;
} */
#back {
	width:100%;
	height:400px;
	background-image:url("/msmg/images/common/review.png");
	margin-bottom:20px;
}

#outer {
	width: 800px;
	height:1300px;
	margin:0 auto;
}

#detail {
	display: block;
}

a {
	text-decoration: none;
	color: black;
}

#whiptable #whip tr td a:hover {
	text-decoration: none;
	color: red;
}

#date-writer-hit {
	display: inline-block;
	margin: 0;
	padding: 0;
	font-size: 12px;
	color: #555;
	text-align: right;
	float: left;
	margin-bottom: 4px;
}

#date-writer-hit2 {
	display: inline-block;
	margin: 0;
	padding: 0;
	font-size: 12px;
	color: #555;
	text-align: right;
	margin-top: 2px;
	margin-bottom: 10px;
}

div[id=date-writer-hit2] {
	border-bottom: 1px solid black;
}

#article-content {
	font-size: 0.9em;
	color: #333;
	min-height: 400px;
	border-bottom: 1px solid #e83f26;
}

.bbs-table {
	width: 100%;
	margin: 20px 0 0 0;
	padding: 10px 0 10px 0;
}

.bbs-table th {
	color: #e83f26;
	border-top: 1px solid #e83f26;
	border-bottom: 1px solid #e83f26;
	padding-top: 8px;
	padding-bottom: 8px;
	font-size: 1.3em;
}

#whip {
	width: 800px;
	margin-top: 50px;
}

#whip tr {
	border-bottom: 1px solid #e83f26;
	height: 35px;
	font-size: 14px;
}

.btnlist .ddl {
	float: right;
}

.btnlist .btn {
	margin-right: 4px;
	margin-left: 4px;
}

#article-content td{
	padding:10px;
}

#mainBottom {
	width:100%;
	height:200px;
}

.detail {
	margin-left:auto;
	margin-right:auto;
}

.detailImg {
	height:150px;
}

</style>
</head>
<body>
<div id="back">
	<%@ include file="../../common/menubar.jsp"%>
</div>
	<div id="outer">
		<table class="bbs-table">
			<tr>
				<th style="text-align: left; color: #555; text-align: center;">후기게시판 제목 테스트</th>
			</tr>
		</table>
		<div id="detail">
			<div id="date-writer-hit2">
				<span> 2018 08-07 17:50:30 &nbsp;&nbsp;&nbsp; <b>l</b>&nbsp;&nbsp;&nbsp;
					hit 1330
				</span> <span id="date-writer-hit">작성자 l 관리자</span>
			</div>
			<div id="article-content" align="center">
				<table>
					<tr>
						<td>대표사진</td>
						<td>
							<div id="titleImgArea" align="center">
								<img id="titleImg" src="/msmg/thumbnail_uploadFiles/b.png">
							</div>
						</td>
					</tr>
					<table class="detail">
						<tr>
							<td>추가 사진</td>
							<td>
								<div class="detailImgArea">
									<img id="detailImg1" class="detailImg" src="/msmg/thumbnail_uploadFiles/b.png">
								</div>
							</td>
							<td>
								<div class="detailImgArea">
									<img id="detailImg2" class="detailImg" src="/msmg/thumbnail_uploadFiles/b.png">
								</div>
							</td>
							<td>
								<div class="detailImgArea">
									<img id="detailImg3" class="detailImg" src="/msmg/thumbnail_uploadFiles/b.png">
								</div>
							</td>
						</tr>
					</table>
					
					
					
					
					
					
					<tr>
						<td>
							<p id="contentArea" style="height:30px" align="center">
								사진 메모 테스트
							</p>
						</td>
					</tr>
				</table>
			</div>
			
		
		
		
		
		
		
		
		
		
	<div id="comment" style="margin-top:10px; text-align:center">
		<table border="1" bordercolor="#e83f26" height="50px">
			<tr>
				<!-- 아이디, 작성날짜 -->
				<td width="150">
					<!-- <div></div> -->
				</td>
				<!-- 댓글 내용 -->
				<td width="550">
					<!-- <div></div> -->
				</td>
				<td width="150">
					<!-- <div id="btn" style="text-align:center;"> -->
						<a href="#">답변</a>
						<!-- 댓글 작성자만 수정, 삭제 가능하도록 -->
							<a href="#">수정</a>
							<a href="#">삭제</a>
					<!-- </div> -->
				</td>
			</tr>
			<tr bgcolor="#25e849">
			<form id="writeCommentForm">
				<!-- <input name="comment_board"/>
				<input name="comment_id"/> -->
				<!-- 아이디 -->
				<td width="150">
					<!-- <div></div> -->
				</td>
				<!-- 본문 작성 -->
				<td width="550">
					<!-- <div></div> -->
						<textarea name = "comment_content" rows="4" cols="70"></textarea>
				</td>
				<td width="100">
					<!-- <div id="btn" style="text-align:center;"> -->
						<p><a href="#" onclick="writeCmt()">댓글등록</a></p>
					<!-- </div> -->
				</td>
			</form>
			
			</tr>
		</table>
	
	</div>





	</div>
	<div id='whiptable'>
		<table id='whip'>
			<tr style="border-top: 1px solid #e83f26;">
				<td width="100"><span class="glyphicon glyphicon-chevron-up"></span>
					이전글</td>
				<td align="center" width='700'><a href="#">이전글 입니다</a></td>
				<td width="100">2018-08-07</td>
			</tr>
			<tr>
				<td width="100"><span class="glyphicon glyphicon-chevron-down"></span>
					다음글</td>
				<td align="center"><a href="#">다음글 입니다</a></td>
				<td>2018-08-07</td>
			</tr>

		</table>
	</div>
	<br>


	<div class="btnlist">
		<button class="btn btn-default befo btn-sm"
			onclick="location.href='../board/informationBoard.jsp'">이전으로</button>
		<button class="btn btn-default ddl btn-sm">삭제</button>
		<button class="btn btn-default ddl btn-sm" onclick="location.href='../review/reviewThumbnailInsertForm.jsp'">수정</button>
	</div>
</div>

<div id="mainBottom">
<%@include file = "../../common/footer.jsp" %>
</div>


</body>
</html>
