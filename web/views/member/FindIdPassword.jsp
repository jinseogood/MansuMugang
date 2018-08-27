<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
 

<style>
	.clear{
		weight:300px;
	}
.mainmenu{
	height:400px;
	background-image:url("/msmg/images/common/findidpw.png");
}
	#main{
		height:1300px;
	}
	html {
		height:100%;
	}
	body {
		height:100%;
	}

	#div{
		min-height: 100%;
		position: relative;
	}
	.footer{
		height:400px;
	}
	#main{
		height: 500px;
	}

</style>
</head>
<body>
<div class="mainmenu">
   <%@ include file="../common/menubar.jsp"%>
</div>


	<div align="center" id="main">
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
		<div id="bottom">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>