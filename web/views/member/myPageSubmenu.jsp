<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>서브메뉴</title>
  <!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
  } );
  </script>
  <style>
  .ui-menu { width: 200px;}
  .ui-widget-header { padding: 0.3em; }
  /* html {width:200px;} */
  </style>
</head>
<body>
 <div id ="outer" align="center" class="pull-left">
<ul id="menu">
  <li class="ui-widget-header">회원정보</li>
  <!-- <li><a href="/msmg/views/member/MyInformation.jsp">나의 정보</a></li> -->
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
 
</body>
</html>
