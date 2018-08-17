<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(window).on(
			"load resize ",
			function() {
				var scrollWidth = $('.tbl-content').width()
						- $('.tbl-content table').width();
				$('.tbl-header').css({
					'padding-right' : scrollWidth
				});
			}).resize();
</script>


<style>
@font-face {
	font-family: 'GoyangDeogyang';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/GoyangDeogyang.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

h1 {
	font-size: 30px;
	color: black;
	text-align: center;
	margin-bottom: 15px;
	font-family: GoyangDeogyang;
}

table {
	width: 100%;
	table-layout: fixed;
	font-family: GoyangDeogyang;
}

.tbl-header {
	background-color: rgba(255, 255, 255, 0.3);
}

.tbl-content {
	height: 300px;
	overflow-x: auto;
	margin-top: 0px;
	border: 1px solid rgba(255, 255, 255, 0.3);
}

th {
	padding: 20px 15px;
	text-align: center;
	font-weight: 500;
	font-size: 12px;
	color: black;
	border-bottom: solid 1px black;
	text-transform: uppercase;
	background: tomato;
	font-family: GoyangDeogyang;
	/* 	background: -webkit-linear-gradient(left, #25c481, #25b7c4);
	background: linear-gradient(to right, #25c481, #25b7c4); */
}

td {
	padding: 20px;
	text-align: left;
	vertical-align: auto;
	font-weight: 300;
	font-size: 12px;
	color: black;
	border-bottom: solid 1px black;
	font-family: GoyangDeogyang;
	/* background: -webkit-linear-gradient(left, #25c481, #25b7c4); */
	/* background: linear-gradient(to right, #25c481, #25b7c4); */
}

body {
	/*   background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4); */
	font-family: GoyangDeogyang;
}

section {
	margin: 50px;
}

.mainmenu {
	height: 35%;
	background:#FF884D;
}

#main {
	height: 100%;
}

html {
	height: 100%;
}

body {
	height: 100%;
}

#wrap {
	width: 100%;
	height: 100%;
}

#wrap #top {
	width: 100%;
	height: 300px;
	background:#FF884D;
}

#wrap #left {
	display: inline;
	float: left;
	width: 220px;
	height: 500px;
}

#wrap #content {
	float: left;
	width: 70%;
	height: 100%;
}

#wrap #right {
	float: left;
	width: 30%;
	height: 500px;
}

#wrap #footer {
	clear: both;
	width: 960px;
	height: 150px;
}

span {
	font-size: 30pt;
}
</style>
</head>
<body>

<div id="wrap">

<div id="top">
<div class="mainmenu">
   <%@ include file="../common/menubar.jsp"%>
</div>
</div>
	
<div id="left">
	
		<%@ include file="myPageSubmenu.jsp" %>
	
</div>

<div id="content">
<section>
	
			<h1>주문내역</h1>
			<div class="tbl-header table1">
				<table cellpadding="0" cellspacing="0" border="0">
					<thead>
						<tr>
							<th>주문일자</th>
							<th>상품명</th>
							<th>결제금액</th>
							<th>결제방법</th>
							<th>결제상태</th>
							<th>배송상태</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="tbl-content table1">
				<table cellpadding="0" cellspacing="0" border="0">
					<tbody>
						<tr>
							<td>2018.09.18</td>
							<td>고혈압 7일 3끼</td>
							<td>330,000원</td>
							<td>신용카드</td>
							<td>환불</td>
							<td>반품완료</td>
						</tr>
					</tbody>
				</table>
			</div>
		</section>
		</div>
		

<!-- <div id="right"></div> -->

<div id="footer"></div>

 </div>
		
		
</body>
</html>