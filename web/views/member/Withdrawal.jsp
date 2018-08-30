<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<style>    
.te {
	/* border: 1px solid black; */
}

.clear {
	height: 30px;
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
	margin: 0;
}

#sidebar {
	width: 190px;
	position: fixed;
	margin-left: 0%;
	/* margin-top: 10%;  */
	background: #ffb1a3;
	border-radius: 10px;
}

#sidebar a {
	text-decoration: none;
	color: black;
}

.ui-widget-header {
	padding: 0.3em;
}
</style>
</head>
<body>
<div class="mainmenu">
   <%@ include file="../common/menubar.jsp"%>
</div>
<div id="main">
	<div id="sidebar">
        <ul>
          <li><a href="/msmg/views/member/EditMyInformation.jsp">회원정보 수정</a></li>
  		  <li><a href="/msmg/views/member/ShoppingCart.jsp">장바구니</a></li>
  		  <li><a href="<%= request.getContextPath() %>/selectBuyAll.mp">주문내역</a></li>
  		  <li><a href="<%= request.getContextPath() %>/mypageQnaList.mp">1:1 문의내역</a></li>
  		  <li><a href="/msmg/views/member/MyPosts.jsp">내가 쓴 글</a></li>
  		  <li><a href="/msmg/views/member/Withdrawal.jsp">회원 탈퇴</a></li>
      	</ul>
	</div>

	<div class="te" align="center" height="350px" width="450px">
		<h1>회원탈퇴</h1>
		<br>
		<p>회원탈퇴시 같은 아이디로 재가입하실 수 없습니다.<br>
		만수무강에서는 정산 등 확인사항이 있는 경우에는 바로 회원탈퇴가 진행되지 않습니다.<br><br>
		1. 자동주문 종료가 되지 않는 경우<br>
		3. 최근 40일 사이 결제한 주문들 중에서 배송완료가 되지 않은 주문이 있는 경우<br></p>
	</div>
	<form name="f" id="f" action="<%=request.getContextPath()%>/deleteMember.me" method="post">
	<div class="clear"></div>
	<div class="te" align="center" height="200px" width="450px">
		<table>
			<tr>
				<td><p>회원탈퇴사유</p></td>
				<td><input type="text" name="reason" id="reason"></td>
				<td><button class="w3-button w3-ripple w3-yellow" onclick="return validation();">회원탈퇴</button></td>
			</tr>
		</table>
	</div>
	</form>
	<script>
		function validation(){
			var reason = $('#reason').val();
			
			if(reason == ""){
				alert("회원탈퇴사유를 입력해주세요."); return false;
			}else{
				alert("회원탈퇴가 완료되었습니다.");
				return true;
			}
		}
	</script>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>