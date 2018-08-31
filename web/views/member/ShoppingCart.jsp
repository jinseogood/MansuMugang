<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.msmg.payment.model.vo.*, java.util.*,com.msmg.food.model.vo.*"%>
<%
	ArrayList<Cart> list = (ArrayList<Cart>)request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	

<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

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

table tr{
		color: #e83f26;
   border-top: 1px solid #e83f26;
   border-bottom: 1px solid #e83f26;
   padding-top: 8px;
   padding-bottom: 8px;
   font-size: 1.3em;
	}
	[type=text] {
		border:none;
		width:50px;
	}
.mainmenu{
	height:400px;
	background-image:url("/msmg/images/common/mypage.png");
}
	#main{
		height:100%;
	}
	html {
		height:100%;
	}
	body {
		height:100%;
		
	}

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
   text-transform: uppercase;
   font-weight: 300;
   text-align: center;
   margin-bottom: 15px;
}

table {
   table-layout: fixed;
   width:70%;
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
   color: #fff;
   text-transform: uppercase;
   background: -webkit-linear-gradient(left, #25c481, #25b7c4);
   background: linear-gradient(to right, #25c481, #25b7c4);
}

td {
   padding: 20px;
   text-align: left;
   vertical-align: auto;
   font-weight: 300;
   font-size: 12px;
   color: black;
   border-bottom: solid 1px black;
   /* background: -webkit-linear-gradient(left, #25c481, #25b7c4); */
  /* background: linear-gradient(to right, #25c481, #25b7c4); */
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

section {
   margin: 50px;
}

.center {
	margin-top:100px;
}

.table1 {
   height: auto;
} 
</style>
</head>
<body>
<div class="mainmenu">
   <%@ include file="../common/menubar.jsp"%>
</div>

	<div align="center" class="center">
	
	
	<div id="sidebar">
        <ul>
          <li><a href="/msmg/views/member/EditMyInformation.jsp">회원정보 수정</a></li>
  		  <!-- <li><a href="/msmg/views/member/ChangePassword.jsp">비밀번호 변경</a></li> -->
  		  <li class="ui-widget-header">
  		  <%-- <a href="<%= request.getContextPath() %>/selectCart.fo?ucode="<%=loginUser.getU_code() %>>장바구니</a> --%>
  		  <a onclick="test();">장바구니</a>
  		  </li>
  		  <li class="ui-widget-header"><a href="/msmg/views/member/OrderHistory.jsp">주문내역</a></li>
  		  <!-- <li class="ui-widget-header"><a href="/msmg/views/member/MyPosts.jsp">활동내역</a></li> -->
  		  <li><a href="<%= request.getContextPath() %>/mypageQnaList.mp">1:1 문의내역</a></li>
  		  <li><a href="/msmg/views/member/MyPosts.jsp">내가 쓴 글</a></li>
  		  <li><a href="/msmg/views/member/Withdrawal.jsp">회원 탈퇴</a></li>
      	</ul>
	</div>
                                                                                                                                                                                                                                                                                                                	
	<form>
		<input type="hidden" name="ucode" value=<%= loginUser.getU_code() %>>

			<table cellpadding="0" cellspacing="0" border="0" class="table table-bordered">
				<tr class="te">
					<td bgcolor=tomato width=100px;><input type="checkbox"/>전체선택</td>
					<td bgcolor=tomato>상품</td>
					<td bgcolor=tomato>담은 날짜</td>
					<td bgcolor=tomato>금액</td>
					<td bgcolor=tomato><button class="w3-button w3-ripple w3-yellow">전체삭제</button></td>
				</tr>
				
				<% if(list == null){ %>
					<tr>
						<td colspan="5"><div align="center">장바구니 내역이 없습니다.</div></td>
					</tr>
				<% } else { %>
					<% for(int i=0; i < list.size(); i++){ %>
							<tr>
								<td width=100px;><input type="checkbox" name="checkRow"/></td>
								<td><%= list.get(i).getUser_menu_name() %></td>
								<td><%= list.get(i).getBuy_date() %></td>
								<td><%= list.get(i).getPrice() %></td>
								<td><button class="w3-button w3-ripple w3-yellow">삭제</button></td>
							</tr>
					<% } %>
				<% } %>
				
				<tr>
					<td></td>
					<td></td>
					<td>배송비 </td>
					<td>3500원<input type="text" readonly style="display: none;"></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td>합계 </td>
					<td>원<input type="text" readonly style="display: none;"></td>
					<td></td>
				</tr>
				<tr align="center">
					<td colspan="5" bgcolor=tomato>
						<input type="button" value="쇼핑계속하기" href="#" class="w3-button w3-ripple w3-yellow">
						<input type="button" value="주문하기" href="#" class="w3-button w3-ripple w3-yellow">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div style="margin-bottom:400px"></div> 
	<script>
		function test(){
			var a = "<%= loginUser.getU_code()%>";
			location.href = "<%= request.getContextPath() %>/selectCart.fo?ucode="+a;
		}
	</script>
<%@ include file="../common/footer.jsp" %>

</body>
</html>