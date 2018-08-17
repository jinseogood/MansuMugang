<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* body {
	background:pink;
} */
#back {
	width: 100%;
	height: 400px;
	/* background:#ffa500; */
	background-image: url("/msmg/images/common/information.png");
	margin-bottom: 20px;
}

.outer {
	width: 1000px;
	height: 1300px;
	margin-left: auto;
	margin-right: auto;
}

table tr {
	text-align: center;
	font-size: 13;
}

table tr:first-child {
	font-size: 12;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	color: red;
}

#content {
	height: 25px;
}

#container {
	width: 100%;
	margin-left: 0 auto;
	margin-right: 0 auto;
	text-align: center;
}

#container ul {
	display: inline-block;
}

div #offi {
	margin-left: 25%;
	margin-bottom: 15px;
	font-size: 32;
}

.pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover,
	.pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover
	{
	background-color: #D8D8D8;
	color: red;
}

#wrap {
	margin-left: auto;
	margin-right: auto;
	margin-top: 20px;
	width: 1000px;
}

#botitle {
	margin-left: 50px;
}

#wrap #btnlist #btn {
	align: left;
}

#insert {
	margin-top: 10px;
}

#jjff {
	height: 35%;
}

#botitle #botitle_sub {
	border: 1px solid black;
}

#botitle #botitle_sub div {
	display: inline-block;
	border: 1px solid black;
	height: 40px;
	width: 300px;
}

#search {
	width: 150px;
	margin-top: 10px;
}

#fas {
	background-color: rgba(255, 255, 255, 0);
}

#mainBottom {
	width: 100%;
	height: 200px;
}
</style>
</head>
<body>
	<div id="back">
		<%@ include file="../../common/menubar.jsp"%>
	</div>
	<div class="outer">
		<div id="botitle">
			<!-- <h2><b>정보게시판</b></h2s><br> -->
		</div>



		<div id="search2" align="right" style="margin-right: 50px">
			<select name="searchArea" id="result"
				style="width: 50px; height: 27px;">
				<option value="이름">이름</option>
				<option value="제목">제목</option>
			</select> <input id="search" type="text" name="search"> <i id="fas"
				class="fas fa-search fa-lg"></i>
		</div>





		<div id='wrap'>
			<table align='center' cellpadding="0" cellspacing="0" border="0">

				<!-- s : 게시판 타이틀 -->
				<tr
					style="background: url('/msmg/images/board/table_mid.png') /* #E8E8E8 */ repeat-x;">
					<td width="5"><img src="/msmg/images/board/table_left.png"
						width="5" height="30" /></td>
					<td width="73"><span>번호</span></td>
					<td width="630"><span>제목</span></td>
					<td width="73"><span>작성자</span></td>
					<td width="164"><span>작성일</span></td>
					<td width="58"><span>조회수</span></td>
					<td width="7"><img src="/msmg/images/board/table_right.png"
						width="5" height="30" /></td>
				</tr>
				<!-- e : 게시판 타이틀 -->
				<!-- s: 게시글 테스트 영역 -->

				<tr id='content'>
					<td></td>
					<td>1</td>
					<td><a href="../information/informationView.jsp">테스트입니다.</a></td>
					<td>테스트</td>
					<td>2018.08.03</td>
					<td>0</td>
					<td></td>
				</tr>
				<tr height='1' bgcolor="#D2D2D2">
					<td colspan="6" width="752"></td>
				</tr>
				<tr id='content'>
					<td colspan='7'>등록된 글이 없습니다.</td>
				</tr>
				<!-- e: 게시글 테스트 영역 끝 -->

				<!-- 게시판 끝 -->
				<tr bgcolor="#82B5DF" style="height: 1px;">
					<td colspan="6"></td>
				</tr>
				<!-- 게시판 끝 -->
			</table>




			<div id='btnlist' align="right">
				<button type="button" class="btn btn-success"
					onclick='location.href = "../information/informationWrite.jsp"'>글
					작성</button>
			</div>
			<div id="container">
				<ul class="pagination">
					<li><a href="#">이전</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">다음</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script>
      $(function(){
         $("#container ul li").click(function(event){
            $("#container ul li").removeClass("active");
            $(this).addClass("active");
         });
      })
   </script>
	<!-- <div style="margin-bottom:400px;"></div> -->
	<div id="mainBottom">
		<%@include file="../../common/footer.jsp"%>
	</div>
</body>
</html>