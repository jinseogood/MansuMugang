<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.msmg.mypage.model.vo.*" %>
<% 
	ArrayList<BuyAll> bList = (ArrayList<BuyAll>)request.getAttribute("bList");
	System.out.println("주문내역에서 bList : " + bList);
	/* PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();  
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage(); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>
/* @font-face {
	font-family: 'GoyangDeogyang';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/GoyangDeogyang.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
} */

h1 {
	font-size: 30px;
	color: black;
	text-align: center;
	margin-bottom: 15px;
	/* font-family: GoyangDeogyang; */
}

table {
	width: 100%;
	table-layout: fixed;
	/* font-family: GoyangDeogyang; */
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
	/* font-family: GoyangDeogyang; */
	/* 	background: -webkit-linear-gradient(left, #25c481, #25b7c4);
	background: linear-gradient(to right, #25c481, #25b7c4); */
}

a {
   text-decoration: none;
   color: black;
}

td {
	padding: 20px;
	text-align: left;
	vertical-align: auto;
	font-weight: 300;
	font-size: 12px;
	color: black;
	border-bottom: solid 1px black;
	/* font-family: GoyangDeogyang; */
	/* background: -webkit-linear-gradient(left, #25c481, #25b7c4); */
	/* background: linear-gradient(to right, #25c481, #25b7c4); */
}

body {
	/*   background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4); */
	/* font-family: GoyangDeogyang; */
	margin: 0;
}

section {
	margin: 50px;
}

.mainmenu{
	height:400px;
	background-image:url("/msmg/images/common/mypage.png");
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


	#sidebar { 
  width: 190px; 
  position: fixed; 
  margin-left: 0%;
  /* margin-top: 10%;  */
  background: #ffb1a3;
  border-radius:10px;
}

#sidebar a{
	text-decoration:none;
}
.ui-widget-header { padding: 0.3em; }

#content {
	margin: 10%;
}

</style>
</head>
<body>



<div id="top">
<div class="mainmenu">
   <%@ include file="../common/menubar.jsp"%>
</div>
</div>
	
<div id="left">
	
		<div id="sidebar">
        <ul>
          <li><a href="/msmg/views/member/EditMyInformation.jsp">회원정보 수정</a></li>
  		  <!-- <li><a href="/msmg/views/member/ChangePassword.jsp">비밀번호 변경</a></li> -->
  		  <li class="ui-widget-header"><a href="/msmg/views/member/ShoppingCart.jsp">장바구니</a></li>
  		  <li class="ui-widget-header"><a href="/msmg/views/member/OrderHistory.jsp">주문내역</a></li>
  		  <!-- <li class="ui-widget-header"><a href="/msmg/views/member/MyPosts.jsp">활동내역</a></li> -->
  		  <li><a href="<%= request.getContextPath() %>/mypageQnaList.mp">1:1 문의내역</a></li>
  		  <li><a href="/msmg/views/member/MyPosts.jsp">내가 쓴 글</a></li>
  		  <li><a href="/msmg/views/member/Withdrawal.jsp">회원 탈퇴</a></li>
      	</ul>
	</div>
	
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
							<th>주문상태</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="tbl-content table1">
				<table cellpadding="0" cellspacing="0" border="0">
					<tbody>
			<% if(bList == null){ %>
						<tr>
							<td colspan="6"><div align="center">주문하신 내역이 없습니다.</div></td>
						</tr>
			<% }else{ %>
				<% for(BuyAll b : bList){ %>
						<tr>
							<td><%= b.getBuy_date() %></td>
							<td>고혈압 7일 3끼</td>
							<td><%= b.getPrice() %></td>
							<td><%= b.getBuy_sort() %></td>
							<td><%= b.getStatus() %></td>
							<%-- <% if() %> --%>
							<td><div class="w3-button w3-ripple w3-yellow">주문취소</div></td>
						</tr>
				<% } %>
			<% } %>
					</tbody>
				</table>
			</div>
			
			
			
					
		</section>
		</div>
		

<!-- <div id="right"></div> -->

<div class="footer">
<%@ include file="../common/footer.jsp" %>
</div>
		
		
</body>
</html>