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
	<form id="loginForm" name="loginFrom" method="post">
		<div id="wrap">
			<h1 class="member" align="center">만수무강에 오신 것을 환영합니다.</h1>
			<h4 class="member" align="center">건강한 식단을 간편하게 집에서 받아보세요!</h3>
				<div align="center" class="form">
					<div align="center" class="form2">
						<div align="center" class="form3">
							<label for="userId">아이디</label><input type="text" id="userId" name="userId">
							<div class="clear"></div>
							<label for="password" >비밀번호</label><input type="password" id="userPwd" name="userPwd">
						</div>
						<div class="w3-button w3-ripple w3-yellow" onclick="login();">로그인</div>
						<!-- <input type="submit" value="로그인" href="index.jsp" onclick="login();"> -->
						<div class="clear"></div>
						<div class="form4" align="left">
							<label class="save" ><input type="checkbox" id="idSaveCheck" name="idSaveCheck" value="saveOk">아이디저장</label><br>
						</div>
						<div class="form5">
						</div>
						<script type="text/javascript">
						function login(){
							$("#loginForm").attr("action", '<%=request.getContextPath()%>/login.me');
							$("#loginForm").submit();
						}
						</script>
						<div id="kakaoBtn" class="kakaoBtn" onclick="kakao();"><img src="/msmg/images/member/kakaoLogin.png"></div>
	
						<div class="form6">
						
							<label class="line"><a href="/msmg/views/member/FindIdPassword.jsp">아이디 | 비밀번호 찾기</a></label>
						<hr>
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
		<input type="hidden" name="id" id="id">
		<input type="hidden" name="nickname" id="nickname">
		<input type="hidden" name="refreshToken" id="refreshToken">
	</form>

<div id="mainBottom">
	<%@ include file="../common/footer.jsp" %>
</div>
<script>

function kakao(){
	Kakao.init('56d0c8722ca6581d915c2b04a5a0810f');
	
	Kakao.Auth.loginForm({
		success : function(authObj) {
			var accessToken=Kakao.Auth.getAccessToken();
			var refreshToken=authObj.refresh_token;
			
			alert(JSON.stringify(authObj));
			console.log(accessToken);
			console.log(refreshToken);
			
			if(accessToken){
				// 로그인 성공시, API를 호출합니다.
				Kakao.API.request({
					url : '/v1/user/me',
					success : function(res) {
						alert("테스트");
						$("#id").val(res.id);
						$("#nickname").val(res.properties.nickname);
						$("#refreshToken").val(refreshToken);
						$("#loginForm").attr("action", "<%=request.getContextPath()%>/snsLogin.me");
						$("#loginForm").submit();
						console.log(res.id);
						//$("#id").val(res.id);
					},
					fail : function(error) {
						alert(JSON.stringify(error));
					}
				});
			} 
		},
		fail : function(err) {
			alert(JSON.stringify(err));
		}
	});
}







$(document).ready(function(){
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var userId = getCookie("userId");
    $("input[name='userId']").val(userId); 
     
    if($("input[name='userId']").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
        $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
            var userId = $("input[name='userId']").val();
            setCookie("userId", userId, 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("userId");
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("input[name='userId']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            var userInputId = $("input[name='userId']").val();
            setCookie("userId", userId, 7); // 7일 동안 쿠키 보관
        }
    });
});
 
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}
</script>
<%-- <form id="login" method="post" action="<%=request.getContextPath()%>/snsLogin.me">
		<input type="hidden" name="id" id="id">
		<input type="hidden" name="nickname" id="nickname">
		<input type="hidden" name="refreshToken" id="refreshToken">
	</form> --%>
</body>
</html>