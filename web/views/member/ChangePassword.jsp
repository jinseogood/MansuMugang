<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	
	$(function() {

	    var $sidebar   = $("#sidebar"), 
	        $window    = $(window),
	        offset     = $sidebar.offset(),
	        topPadding = 15;

	    $window.scroll(function() {
	        if ($window.scrollTop() > offset.top) {
	            $sidebar.stop().animate({
	                marginTop: $window.scrollTop() - offset.top + topPadding
	            });
	        } else {
	            $sidebar.stop().animate({
	                marginTop: 0
	            });
	        }
	    });
	    
	});
</script>


</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
	.guide {
		color:red;
		align:center;
	}
	/* .te{
		border:1px solid black;
		align:center; */
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
	.clear{
		height:20px;
	}
	
	#div{
		min-height: 100%;
		position: relative;
	}
	.footer{
		height:400px;
	}
	#test{
		min-height: 70%;
		position: relative;
	}
	.clear{
		height:20px;
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
	
</style>
<body>

<div class="mainmenu">
   <%@ include file="../common/menubar.jsp"%>
</div>
	
<div id="test">
<div id="sidebar">
        <ul>
          <li><a href="/msmg/views/member/EditMyInformation.jsp">회원정보 수정</a></li>
  		  <li><a href="/msmg/views/member/ChangePassword.jsp">비밀번호 변경</a></li>
  		  <li><a href="/msmg/views/member/Withdrawal.jsp">회원 탈퇴</a></li>
  		  <li class="ui-widget-header"><a href="/msmg/views/member/ShoppingCart.jsp">장바구니</a></li>
  		  <li class="ui-widget-header"><a href="/msmg/views/member/OrderHistory.jsp">주문내역</a></li>
  		  <li class="ui-widget-header"><a href="/msmg/views/member/MyPosts.jsp">활동내역</a></li>
  		  <li><a href="/msmg/views/member/Question.jsp">1:1 문의내역</a></li>
  		  <li><a href="/msmg/views/member/MyPosts.jsp">내가 쓴 글</a></li>
      	</ul>
	</div>
	<div class="te">
	<h3 align="center">비밀번호 변경</h3>
	<table class="table-bordered" align="center">
	<tr>
	<td>
			<form action="" method="post">
				<table align="center" >
					<tr class="guide"><td colspan="2" align="center">안전한 비밀번호로 내 정보를 보호하세요</td></tr>
					
					<tr>
						<td><label>현재 비밀번호</label></td>
						<td><input type="password" name="password0"></td>
						<td><label>　</label></td>
					</tr>
					<br>
					<tr>
						<td><label>새 비밀번호</label></td>
						<td><input type="password" name="password1"></td>
					</tr>
					<tr>
						<td><label>새 비밀번호 확인</label></td>
						<td><input type="password" name="password2"></td>
					</tr>
				</table>
				</form>
				</td>
				<td>
				<label>비밀번호 작성규칙 영문과 숫자를 혼용하여 8자 이상 20자 이하로 만드세요.<br>
				특수문자(!,@,%,^,&,*)를 포함할 수 있습니다.<br>
				같은 문자를 4번 이상 사용하실 수 없습니다.<br>
				아이디가 포함되어 있는 비밀번호는 사용하실 수 없습니다.<br></label>
				</td>
				</tr>
					<tr align="center" class="wrap">
						<td colspan="2">
						<div class="clear"></div>
							<input type="submit" value="비밀번호 변경" href="#" class="w3-button w3-ripple w3-yellow">
						<div class="clear"></div>
						</td>
					</tr>
				</table>
				</div>
		</div>	
		<div class="footer">
<%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>