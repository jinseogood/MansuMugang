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

<style>
	.clear{
		weight:300px;
	}
.mainmenu{
	height:400px;
	background-image:url("/msmg/images/common/mypage.png");
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
	#div{
		min-height: 100%;
		position: relative;
	}
	.footer{
		height:400px;
	}

</style>
</head>
<body>
<div class="mainmenu">
   <%@ include file="../common/menubar.jsp"%>
</div>

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
		<div id="bottom">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>