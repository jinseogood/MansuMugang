<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.msmg.member.model.vo.*" %>
<% FindId fi = (FindId)request.getAttribute("fi");
   System.out.println(fi); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
          
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
	<form name="f" id="f" action="" method="post">
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
				<td><input type="text" name="userName" id="userName"></td>
			</tr>
			<tr>
				<td><label>질문 : </label></td>
				<td>
					<select name="joinQ">
						<option value="Q0">질문을 선택해주세요.</option>
						<option value="Q1">보물 1호는?</option>
						<option value="Q2">세상에서 가장 좋아하는 장소는?</option>
						<option value="Q3">반려동물의 이름은?</option>
						<option value="Q4">가장 좋아하는 노래는?</option>
						<option value="Q5">첫사랑의 이름은?</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label>답 : </label></td>
				<td><input type="text" name="joinA" id="joinA"></td>
			</tr>
			<tr>
				<td colspan="2"><button class="w3-button w3-ripple w3-yellow" name="findId" id="findId" onclick="findId();">아이디 찾기</button></td>
			</tr>
		</table>
	<script>
		$(function(){
			$("#findId").click(function(){
				var userName = $("#userName").val();
				var joinQ = $("#joinQ").val();
				var joinA = $("#joinA").val();
				$.ajax({
				url:"/msmg/selectId.me",
				data:{userName:userName,joinQ:joinQ,joinA:joinA},
				success:function(value){
					
					console.log(value)
		   	   		<%-- if('<%= fi.getUserId() %>' != null){
		   	   			alert(<%= fi.getUserName() %> + "님의 이메일은 " + <%= fi.getUserId() %> + "입니다.");
		   	   		}/* else{
		   	   			alert("일치하는 이메일이 없습니다.");
		   	   		} */ --%>
				},
				error:function(){
					alert("일치하는 이메일이 없습니다.");
				}
			});
		
		});
		
		});
	</script>
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
	</form>
	</div>
		<div id="bottom">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>