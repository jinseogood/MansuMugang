<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 글</title>
     



<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<style>
table tr {
   text-align: center;
   font-family: 'Nanum Gothic', sans-serif;
   font-size: 13;
}

table tr:first-child {
   font-size: 12;
}

a {
   text-decoration: none;
   color: black;
}

a:hover {
   color: red;
}

#content {
   height: 25px;
}

#container {
   width: 100%;
   margin-left: 0 auto;
   margin-right: 0 auto;
   text-align: center;
}

#container ul{
   display : inline-block;
}
div #offi {
   margin-left: 20%;
   margin-bottom: 15px;
   font-size: 32;
   font-family: 'Nanum Gothic', sans-serif;
}

.pagination>.active>a, 
.pagination>.active>a:focus, 
.pagination>.active>a:hover,
.pagination>.active>span, 
.pagination>.active>span:focus, 
.pagination>.active>span:hover
 {background-color: #D8D8D8; color:red;}
 
 #wrap {
    margin-left : auto;
    margin-right : auto;
    margin-top : 20px;
    width : 1000px;
 }
 
 #wrap #btnlist #btn {
    align : left;
 }
 
 #insert {
    margin-top : 10px;
 }
 
 #botitle {
 margin-left: 20%;
    height : 150px;
 }
 
 #jjff {
    height : 35%;
 }
 
 #botitle #botitle_sub {
    border : 1px solid black;
 }
 #botitle #botitle_sub div{
 	display : inline-block;
   border : 1px solid black;
   height : 40px;
   width : 300px;
}
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
</head>
<body>
<div class="mainmenu">
   <%@ include file="../common/menubar.jsp"%>
</div>
   <div id="sidebar"> 
        <ul>
          <li><a href="/msmg/views/member/EditMyInformation.jsp">회원정보 수정</a></li>
  		  <!-- <li><a href="/msmg/views/member/ChangePassword.jsp">비밀번호 변경</a></li> -->
  		  <li class="ui-widget-header"><a onclick="test();">장바구니</a></li>
  		  <li class="ui-widget-header"><a href="/msmg/views/member/OrderHistory.jsp">주문내역</a></li>
  		  <!-- <li class="ui-widget-header"><a href="/msmg/views/member/MyPosts.jsp">활동내역</a></li> -->
  		  <li><a href="<%= request.getContextPath() %>/mypageQnaList.mp">1:1 문의내역</a></li>
  		  <li><a href="/msmg/views/member/MyPosts.jsp">내가 쓴 글</a></li>
  		  <li><a href="/msmg/views/member/Withdrawal.jsp">회원 탈퇴</a></li>
      	</ul>
	</div>
   <div id = "botitle">
   <h3 >내가 쓴 글</h3>
   <p>후기게시판 및 정보게시판에서 내가 쓴 글을 조회하실 수 있습니다.<br>
   타인의 저작물(신문기사, 사진, 동영상 등)을 관리자의 허락 없이 무단으로 복제하여 올리는 것은 저작권 침해에 해당합니다.</p>
   
   </div>
   <div id = 'wrap'>
   <table align='center' cellpadding="0" cellspacing="0" border="0">

      <!-- s : 게시판 타이틀 -->
      <tr style="background: url('image/table_mid.gif') /* #E8E8E8 */ repeat-x;">
         <td width="5"><img src="image/table_left.gif" width="5"
            height="30" /></td>
         <td width="73"><span>번호</span></td>
         <td width="630"><span>제목</span></td>
         <td width="73"><span>작성자</span></td>
         <td width="164"><span>작성일</span></td>
         <td width="58"><span>조회수</span></td>
         <td width="7"><img src="image/table_right.gif" width="5"
            height="30" /></td>
      </tr>
      <!-- e : 게시판 타이틀 -->
      <!-- s: 게시글 테스트 영역 -->
      
      <tr id='content'>
         <td></td>
         <td>1</td>
         <td><a href="views/readBoard.jsp">테스트입니다.</a></td>
         <td>테스트</td>
         <td>2018.08.03</td>
         <td>0</td>
         <td></td>
      </tr>
      <tr height='1' bgcolor="#D2D2D2">
         <td colspan="6" width="752"></td>
      </tr>
      <tr id='content'>
         <td colspan='7'>등록된 글이 없습니다.</td>
      </tr>
      <!-- e: 게시글 테스트 영역 끝 -->

      <!-- 게시판 끝 -->
      <tr bgcolor="#82B5DF" style="height: 1px;">
         <td colspan="6"></td>
      </tr>
      <!-- 게시판 끝 -->
   </table>
   <div id = 'btnlist' align = "right">
   <!-- <button id = 'insert' class="btn btn-success btn-sm" onclick = 'location.href = "views/boradWrite.jsp"'>수정</button> -->
   </div>
   <div id="container">
      <ul class="pagination">
         <li><a href="#">이전</a></li>
         <li ><a href="#">1</a></li>
         <li><a href="#">2</a></li>
         <li><a href="#">3</a></li>
         <li ><a href="#">4</a></li>
         <li><a href="#">5</a></li>
         <li><a href="#">다음</a></li>
      </ul>
   </div>
   </div>
   <script>
      $(function(){
         $("#container ul li").click(function(event){
            $("#container ul li").removeClass("active");
            $(this).addClass("active");
         });
      })
   </script>
   	<script>
		function test(){
			var a = "<%= loginUser.getU_code()%>";
			location.href = "<%= request.getContextPath() %>/selectCart.fo?ucode="+a;
		}
	
	
	</script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>