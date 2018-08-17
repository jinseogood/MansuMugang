<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.clear{
		weight:300px;
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
	}
	
</style>
</head>
<body>
<div class="mainmenu">
   <%@ include file="../common/menubar.jsp"%>
</div>
	<div align="center">
		<table>
		<tr>
			<td>
				<h1>아이디 찾기</h1>
				<p>이름과 연락처로 아이디 찾기가 가능합니다.<br>
				찾기가 어려우시면, 고객센터로 문의주세요</p>
	
				<div>
				
		<table>
		<tr><td>　</td></tr>
			<tr>
				<td><label>이름 : </label></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><label>연락처 : </label></td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td colspan="2"><button>아이디 찾기</button></td>
			</tr>
		</table>
	</div>
	</td>
	</div>
	
	<td><div class="clear"></div></td>
	
	<div align="center">
	<td>
	<h1>비밀번호 찾기</h1>
	<p>이름과 연락처로 비밀번호 찾기가 가능합니다.<br>
	찾기가 어려우시면, 고객센터로 문의주세요</p>
	
	<div>
		<table>
			<tr>
				<td><label>이메일 : </label></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><label>이름 : </label></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><label>연락처 : </label></td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td colspan="2"><button>비밀번호 찾기</button></td>
			</tr>
		</table>
	</div>
	</td>
	</tr>
	</table>
	</div>
</body>
</html>