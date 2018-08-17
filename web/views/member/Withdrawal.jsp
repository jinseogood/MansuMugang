<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.te{
		border:1px solid black;
	}
	.clear{
		height:30px;
	}
	.mainmenu{
		height:35%;
	}
	#main{
		height:100%;
	}
	html {
		height:100%;
	}
	body {
		height:100%;
		background:pink;
	}
</style>
</head>
<body>
<div class="mainmenu">
   <%@ include file="../common/menubar.jsp"%>
</div>
<div id="main">
	<%@ include file="myPageSubmenu.jsp" %>

	<div class="te" align="center" height="350px" width="450px">
		<p>회원탈퇴시 같은 아이디로 재가입하실 수 없습니다.<br>
		만수무강에서는 정산 등 확인사항이 있는 경우에는 바로 회원탈퇴가 진행되지 않습니다.<br><br>
		1. 자동주문 종료가 되지 않는 경우<br>
		2. 최근 마감일 이후에 주문이 있는 경우<br>
		3. 최근 40일 사이 결제한 주문들 중에서 배송완료가 되지 않은 주문이 있는 경우<br></p>
	</div>
	<div class="clear"></div>
	<div class="te" align="center" height="200px" width="450px">
		<table>
			<tr>
				<td><p>회원탈퇴사유</p></td>
				<td><input type="text" name="reason"></td>
				<td><button>회원탈퇴</button></td>
			</tr>
		</table>
	</div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>