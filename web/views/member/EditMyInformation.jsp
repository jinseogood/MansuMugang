<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>내 정보</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>

h1 {
	font-size: 30px;
	color: black;
	text-align: center;
	margin-bottom: 15px;
}

table {
	width: 100%;
	table-layout: fixed;
}

.tbl-header {
	background-color: rgba(255, 255, 255, 0.3);
}

.tbl-content {
	height: 300px;
	overflow-x: auto;
	margin-top: 0px;
	border: 1px solid rgba(255, 255, 255, 0.3);
	width:60%;
	overflow-x:center;
	
}

th {
	padding: 20px 15px;
	text-align: center;
	font-weight: 500;
	font-size: 12px;
   color: black;
   border-bottom: solid 1px black;
	text-transform: uppercase;
	background: tomato;
}

td {
   padding: 20px;
   text-align: left;
   vertical-align: auto;
   font-weight: 300;
   font-size: 12px;
   color: black;
   border-bottom: solid 1px black;
}

section {
	margin: 50px;
}


.table1 {
	height: auto;
	overflow-x:center;
}

.notice {
	margin: 50px;
	color: black;
}

#one {
	display: inline-block;
	height: 100%;
	width: 10%;
}

#two {
	display: inline-block;
	height: 100%;
	width: 80%;
}

#three {
	height: 100%;
	width: 10%;
}

#top{
	height:250px;
	background:#FF884D;
}
#mainBottom{
	width:100%;
	height:200px;
}
	
#contents{
	min-height: 100%;
	position: relative;
}
.mainmenu{
	height:400px;
	background-image:url("/msmg/images/common/mypage.png");
}
#main{
	height:1300px;
}
#bottom{
	width:100%;
	height:200px;
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
  		  <li class="ui-widget-header"><a href="/msmg/views/member/ShoppingCart.jsp">장바구니</a></li>
  		  <li class="ui-widget-header"><a href="/msmg/views/member/OrderHistory.jsp">주문내역</a></li>
  		  <!-- <li class="ui-widget-header"><a href="/msmg/views/member/MyPosts.jsp">활동내역</a></li> -->
  		  <li><a href="/msmg/views/member/Question.jsp">1:1 문의내역</a></li>
  		  <li><a href="/msmg/views/member/MyPosts.jsp">내가 쓴 글</a></li>
  		  <li><a href="/msmg/views/member/Withdrawal.jsp">회원 탈퇴</a></li>
      	</ul>
	</div>
	<div id="main" class="main" align="center">
		<section>
			<h1>회원정보수정</h1>

			<div class="tbl-content table1" align="center">
				<table cellpadding="0" cellspacing="0" border="0">
					<tbody>
						
						<tr>
							<th bgcolor=tomato>아이디(이메일)<span class="red">*</span></th>
							<td><input type="text" readonly></td>
						</tr>
						<tr>
							<th bgcolor=tomato>비밀번호<span class="red">*</span></th>
							<td><input type="text"></td>
						</tr>
						<tr>
							<th bgcolor=tomato>비밀번호 확인<span class="red">*</span></th>
							<td><input type="text"></td>
						</tr>
						<tr>
							<th bgcolor=tomato>이름</th>
							<td><input type="text" readonly></td>
						</tr>
						<br>
						<tr>
							<table align="center">
								<tr>
									<th colspan="3"><label>@가지고계신 알레르기를 선택해주세요@</label></th>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="난류(계란)" id="eggs">
										<label for="eggs">난류(계란)</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="우유" id="milk">
										<label for="milk">우유</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="메밀" id="memil">
										<label for="memil">메밀</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="땅콩" id="peanut">
										<label for="peanut">땅콩</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="대두" id="bean">
										<label for="bean">대두</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="밀" id="wheat">
										<label for="wheat">밀</label><br>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="고등어" id="mackerel">
										<label for="mackerel">고등어</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="게" id="crab">
										<label for="crab">게</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="돼지고기" id="pork">
										<label for="pork">돼지고기</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="복숭아" id="peach">
										<label for="peach">복숭아</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="토마토" id="tomato">
										<label for="tomato">토마토</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="새우" id="shrimp">
										<label for="shrimp">새우</label><br>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="호두" id="walnut">
										<label for="walnut">호두</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="닭고기" id="chicken">
										<label for="chicken">닭고기</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="쇠고기" id="beef">
										<label for="beef">쇠고기</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="오징어" id="squid">
										<label for="squid">오징어</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="조개류" id="clam">
										<label for="clam">조개류</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="아황산류" id="acid">
										<label for="acid">아황산류</label>
									</td>
								</tr>
							</table>
						</tr>
								</table>
								</tr>
							</table>
						<td colspan="2">
						<div class="clear"></div>
							<div class="w3-button w3-ripple w3-yellow"><a href="/msmg/index.jsp">취소하기</a></div>
							<div class="w3-button w3-ripple w3-yellow" onclick="#"><a href="#">수정하기</a></div>
						</td>
					</tr>
					</tbody>
				</table>
			</div>
		</section>
	</div>
	<div id="bottom">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>