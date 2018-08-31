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
<script>
	$(function(){})
</script>


<div id="top">
<div class="mainmenu">
   <%@ include file="../common/menubar.jsp"%>
</div>
</div>
	
<div id="left">
	
		<div id="sidebar">
        <ul>
          <li><a href="/msmg/views/member/EditMyInformation.jsp">회원정보 수정</a></li>
  		  <li><a onclick="test();">장바구니</a></li>
  		  <li><a href="<%= request.getContextPath() %>/selectBuyAll.mp">주문내역</a></li>
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
							<th width="150px">주문일자</th>
							<th width="220px">상품명</th>
							<th>결제금액</th>
							<th>결제방법</th>
							<th>주문상태</th>
							<th  width="300px"> </th>
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
				<% for(int i = 0; i < bList.size(); i++){ %>
						<tr>  
							<td width="150px"><div align="center"><%= bList.get(i).getBuy_date() %></div></td>
							<td width="220px"><div align="center"><%= bList.get(i).getUser_menu_name() %></div></td>
							<td><div align="center"><%= bList.get(i).getPrice() + 3500 %>원</div></td>
							<td><div align="center"><%= bList.get(i).getBuy_sort() %></div></td>
							<td>
								<%if(bList.get(i).getStatus().equals("2")) {%>
									<div align="center"><%= bList.get(i).getBuy_status() %></div></td>
									<td width="300px"><div class="w3-button w3-ripple w3-yellow" align="center">주문취소</div>
								<% }else if(bList.get(i).getStatus().equals("5")) {%>
									<div align="center"><%= bList.get(i).getBuy_status() %></div></td>
									<td width="300px"><div class="w3-button w3-ripple w3-yellow"><a href="/msmg/views/board/review/reviewThumbnailInsertForm.jsp">후기작성</a></div> 
									<div class="w3-button w3-ripple w3-yellow">교환문의</div> 
									<div class="w3-button w3-ripple w3-yellow">환불문의</div> 
								<% } else { %>
									<div align="center"><%= bList.get(i).getBuy_status() %></div> 
								<% } %>
							</td>
							
							 <!-- <div class="w3-button w3-ripple w3-yellow">주문취소</div> -->
						</tr>
				<% } %>
			<% } %> 
					</tbody>
				</table>
			</div>
			
			
			
					
		</section>
		</div>
		

<!-- <div id="right"></div> -->
	<script>
		function test(){
			var a = "<%= loginUser.getU_code()%>";
			location.href = "<%= request.getContextPath() %>/selectCart.fo?ucode="+a;
		}
	
	
	</script>
<div class="footer">
<%@ include file="../common/footer.jsp" %>
</div>

<script>
	
	
	
	
	
	
</script>
		
		
</body>
</html>