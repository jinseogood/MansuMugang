<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만수무강 로그인</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<style>
a{
		text-decoration:none;
	}
	.member {
		
	}
	body {
		font-size:17px;
	}
	.form {
		width:400px;
		height:350px;
		border-radius:25px;
		border:1px solid #999;
		margin:30px auto;
	}
	.form2 {
		width:380px;
		min-width:320px;
		height:200px;
		margin:60px auto;
		margin-left:20px auto;
		margin-right:20px auto;
	}
	.form3 {
		float:left;
	}
	.form3 label{
		width:100px;
		height:20px;
		float:left;
	}
	.form4 {
		margin-left:70px;
		margin-right:70px;
		margin-top:-5px;
	}
	#wrap {
		width:100%;
		height:800px;
		margin:0 auto;
	}
	.clear {
		clear:both;
		height:5px;
	}
	input[type="submit"] {
		float:left;
		height:50px;
		background:yellow;
		border:none;
		margin-left:5px;
	}
	input[type="submit"] {
		float:left;
		height:50px;
		background:yellow;
		border:none;
		margin-left:5px;
		cursor:pointer;
		font-weight:bolder;
		
	}
	input[type="button"] {
		height:30px;
		background:gray;
		border-radius:5px;
		border:none;
		margin-top:10px;
		margin-right:20px;
		margin-left:20px;
	}
	input[type="checkbox"] {
		margin-top:20px;
	}
	.kakao{
		margin-top:10px;
	}
	.line > a{
		text-decoration:none;
	}
	.line{
		text-decoration:none;
		font-weight:bolder;
		margin-top:5px;
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
	
	#top{
	height:400px;
	background-image:url("/msmg/images/common/login.png");
}

</style>
</head>
<body>
<div id="top">
		<%@ include file="../common/menubar.jsp"%>
</div>
	<form id="loginForm" action="<%=request.getContextPath()%>/login.me" method="post">
		<div id="wrap">
			<h1 class="member" align="center">만수무강에 오신 것을 환영합니다.</h1>
			<h4 class="member" align="center">건강한 식단을 간편하게 집에서 받아보세요!</h3>
				<div align="center" class="form">
					<div align="center" class="form2">
						<div align="center" class="form3">
							<label for="userId">아이디</label><input type="text" id="userId" name="userId">
							<div class="clear"></div>
							<label for="password" >비밀번호</label><input type="password" id="password" name="password">
						</div>
						<div class="w3-button w3-ripple w3-yellow" onclick="login();">로그인</div>
						<!-- <input type="submit" value="로그인" href="index.jsp" onclick="login();"> -->
						<div class="clear"></div>
						<div class="form4" align="left">
							<label class="save" ><input type="checkbox">아이디저장</label><br>
						</div>
						<div class="form5">
						</div>
						<script type="text/javascript">
						function login(){
							$("#loginForm").submit();
							console.log("dd");
						}
						</script>
	<div class="kakao">
	<br>
		<a id="kakao-login-btn"></a>
   		<a href="http://developers.kakao.com/logout"></a>
    <script type='text/javascript'>
      //<![CDATA[
        // 사용할 앱의 JavaScript 키를 설정해 주세요.
        Kakao.init('a8a8876302c686022ec2d4b41d5fa662');
        // 카카오 로그인 버튼을 생성합니다.
        Kakao.Auth.createLoginButton({
          container: '#kakao-login-btn',
          success: function(authObj) {
            alert(JSON.stringify(authObj));
          },
          fail: function(err) {
             alert(JSON.stringify(err));
          }
        });
      //]]>
    </script>
    </div>
						<div class="form6">
						<br><br>
							<label class="line"><a href="/msmg/views/member/FindIdPassword.jsp">아이디 | 비밀번호 찾기</a></label>
						<br><hr>
						<div align="center" class="join">
							<label for="userId">만수무강 회원이 아니신가요?</label>
							<div class="clear"></div>
							<label for="password">회원가입을 하시면 더 많은 혜택을 받으실 수 있습니다.</label><br>
						</div>
						<div>
						<div class="clear"></div>
							<label class="line"><a href="/msmg/views/member/MemberJoinForm.jsp">회원가입하기</a></label>
						</div>
	
						</div>
					</div>
				</div>
		</div>
	</form>

<div id="mainBottom">
	<%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>