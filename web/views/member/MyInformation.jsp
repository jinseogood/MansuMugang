<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css); .notosanskr * { font-family: 'Noto Sans KR', sans-serif; }
	
	.te{
		border:1px solid black;
		width:500px;
		height:180px;
		align:center;
		min-height : 90%;
	}
	[type=text] {
		border:none;
		width:50px;
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
		height:90%;
		font-family: 'Noto Sans KR', sans-serif;
	}
	.foot{
		
	}
	
</style>
</head>
<body>
<div class="mainmenu">
   <%@ include file="../common/menubar.jsp"%>
</div>
	<%@ include file="myPageSubmenu.jsp" %>
	<div class="te">
			<form action="" method="post">
				<table>
					<tr>
						<td><label><%-- <%= 회원이름 %> --%>고객님 만수무강하세요</label></td>
					</tr>
					<tr>
						<td><label>진행주문</label></td>
						<td><input type="text" name="order"></td>
						<td><label>건</label></td>
					</tr>
					<tr>
						<td><label>배송중</label></td>
						<td><input type="text" name="shipping"></td>
						<td><label>건</label></td>
					</tr>
					<tr>
						<td><label>적립금</label></td>
						<td><input type="text" name="shipping"></td>
						<td><label>원</label></td>
					</tr>
				</table>
				</form>
				</div>
<div class="foot">
<%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>