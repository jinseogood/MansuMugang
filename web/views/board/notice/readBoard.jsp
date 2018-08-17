<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글읽기</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
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
	border-bottom: 1px solid #92B91C;
}

.bbs-table {
	width: 100%;
	margin: 20px 0 0 0;
	padding: 10px 0 10px 0;
}

.bbs-table th {
	color: #92B91C;
	border-top: 1px solid #92B91C;
	border-bottom: 1px solid #92B91C;
	padding-top: 8px;
	padding-bottom: 8px;
	font-size: 1.3em;
}

#whip {
	width: 1000px;
	margin-top: 50px;
}

#whip tr {
	border-bottom: 1px solid #92B91C;
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

#jjff {
	width: 100%;
	height: 400px;
	background-image: url("/msmg/images/common/notice.png");
	margin-bottom: 10px;
}

#main {
	width: 1000px;
	height: 1300px;
	margin-left:auto;
	margin-right:auto;
}

#mainBottom {
	height:200px;
	width:100%;
}
</style>
</head>
<body>
	<div id="jjff">
		<%@ include file="../../common/menubar.jsp"%>
	</div>
	<div id="main">
		<!-- 게시판 읽기 -->
		<div>
			<table class="bbs-table">
				<tr>
					<th style="text-align: left; color: #555; text-align: center;">테스트</th>
				</tr>
			</table>
			<div id="detail">
				<div id="date-writer-hit2">
					<span> 2018-08-07 17:50:30 &nbsp;&nbsp;&nbsp; <b>l</b>&nbsp;&nbsp;&nbsp;
						hit 1330
					</span> <span id="date-writer-hit">작성자 l 관리자</span>
				</div>
				<div id="article-content"></div>
			</div>
		</div>
		<div id='whiptable'>
			<table id='whip'>
				<tr style="border-top: 1px solid #92B91C;">
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
			<button class="btn btn-primary befo btn-sm"
				onclick="location.href = '../index.jsp'">이전으로</button>
		</div>

	</div>
	<div id="mainBottom">
	<%@include file="../../common/footer.jsp"%>
	</div>
</body>
</html>

