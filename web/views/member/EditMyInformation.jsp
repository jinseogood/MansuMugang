<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.msmg.member.*" %>
<% ArrayList<String> alList = (ArrayList<String>)request.getAttribute("alList");
	String arr[] = new String[alList.size()];
	for(int i = 0; i < arr.length; i++){
		arr[i] = alList.get(i);
		System.out.println("arr[" + i +"] : " + arr[i]);
	}
	System.out.println("alList" + alList);
	int size = alList.size();
	System.out.println(size);
	int a = 0;%>
<!DOCTYPE html>   
<html>
<head>
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
a{
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
  		  <li><a href="/msmg/views/member/ShoppingCart.jsp">장바구니</a></li>
  		  <li><a href="<%= request.getContextPath() %>/selectBuyAll.mp">주문내역</a></li>
  		  <li><a href="<%= request.getContextPath() %>/mypageQnaList.mp">1:1 문의내역</a></li>
  		  <li><a href="/msmg/views/member/MyPosts.jsp">내가 쓴 글</a></li>
  		  <li><a href="/msmg/views/member/Withdrawal.jsp">회원 탈퇴</a></li>
      	</ul>
	</div>
	<div id="main" class="main" align="center">
		<section>
			<h1>회원정보수정</h1>

			<div class="tbl-content table1" align="center">
			<form name="f" id="f" action="" method="post">
				<table cellpadding="0" cellspacing="0" border="0">
					<tbody>
						
						<tr>
							<th bgcolor=tomato>아이디(이메일)<span class="red">*</span></th>
							<td><input type="text" name="userId" id="userId" value="<%= loginUser.getU_id()%>" readonly></td>
						</tr>
						<tr>
							<th bgcolor=tomato>비밀번호<span class="red">*</span></th>
							<td><input type="password" name="userPwd" id="userPwd"></td>
						</tr>
						<tr>
							<th bgcolor=tomato>비밀번호 확인<span class="red">*</span></th>
							<td><input type="password" name="userPwd2" id="userPwd2"></td>
						</tr>
						<tr>
							<th bgcolor=tomato>이름</th>
							<td><input type="text" name="userName" id="userName" value="<%= loginUser.getU_name()%>" readonly></td>
						</tr>
						<tr>
							<th bgcolor=tomato>질문</th>
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
							<th bgcolor=tomato>답</th>
							<td><input type="text" name="joinA" id="joinA"></td>
						</tr>
						<br>
						<tr>
							<table align="center">
									<input type="hidden" name="userCode" value="<%= loginUser.getU_code() %>" id="userCode">
								<tr>
									<th colspan="3"><label>@가지고계신 알레르기를 선택해주세요@</label></th>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="A1" id="A1">
										<label for="A1">난류(계란)</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A2" id="A2">
										<label for="A2">우유</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A3" id="A3">
										<label for="A3">메밀</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="A4" id="A4">
										<label for="A4">땅콩</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A5" id="A5">
										<label for="A5">대두</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A6" id="A6">
										<label for="A6">밀</label><br>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="A7" id="A7">
										<label for="A7">고등어</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A8" id="A8">
										<label for="A8">게</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A9" id="A9">
										<label for="A9">돼지고기</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="A10" id="A10">
										<label for="A10">복숭아</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A11" id="A11">
										<label for="A11">토마토</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A12" id="A12">
										<label for="A12">새우</label><br>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="A13" id="A13">
										<label for="A13">호두</label>
									</td>
									<td> 
										<input type="checkbox" name="allergy" value="A14" id="A14">
										<label for="A14">닭고기</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A15" id="A15">
										<label for="A15">쇠고기</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="A16" id="A16">
										<label for="A16">오징어</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A17" id="A17">
										<label for="A17">조개류</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A18" id="A18">
										<label for="A18">아황산류</label>
									</td>
								</tr>
							</table>
						</tr>
								</table>
								</form>
								</tr>
						<td colspan="2">
						<div class="clear"></div>
							<div class="w3-button w3-ripple w3-yellow"><a href="/msmg/index.jsp">취소하기</a></div>
							<div class="w3-button w3-ripple w3-yellow" onclick="edit();">수정하기</div>
						</td>
					</tr>
					</tbody>
			</div>
		</section>
	</div>
	<div id="bottom">
		<%@ include file="../common/footer.jsp" %>
	</div>
	<script>
	
		$(function(){
			
		
			for(var i = 0; i < <%=alList.size()%>; i++){
				<% for(int i=0;i<alList.size();i++){%>
					var al = <%=arr[i]%>;
					if($('#A1').val() == $(al).val()){
						$("#A1").attr("checked","checked");
					}
					if($('#A2').val() == $(al).val()){
						$("#A2").attr("checked","checked");
					}
					if($('#A3').val() == $(al).val()){
						$("#A3").attr("checked","checked");
					}
					if($('#A4').val() == $(al).val()){
						$("#A4").attr("checked","checked");
					}
					if($('#A5').val() == $(al).val()){
						$("#A5").attr("checked","checked");
					}
					if($('#A6').val() == $(al).val()){
						$("#A6").attr("checked","checked");
					}
					if($('#A7').val() == $(al).val()){
						$("#A7").attr("checked","checked");
					}
					if($('#A8').val() == $(al).val()){
						$("#A8").attr("checked","checked");
					}
					if($('#A9').val() == $(al).val()){
						$("#A9").attr("checked","checked");
					}
					if($('#A10').val() == $(al).val()){
						$("#A10").attr("checked","checked");
					}
					if($('#A11').val() == $(al).val()){
						$("#A11").attr("checked","checked");
					}
					if($('#A12').val() == $(al).val()){
						$("#A12").attr("checked","checked");
					}
					if($('#A13').val() == $(al).val()){
						$("#A13").attr("checked","checked");
					}
					if($('#A14').val() == $(al).val()){
						$("#A14").attr("checked","checked");
					}
					if($('#A15').val() == $(al).val()){
						$("#A15").attr("checked","checked");
					}
					if($('#A16').val() == $(al).val()){
						$("#A16").attr("checked","checked");
					}
					if($('#A17').val() == $(al).val()){
						$("#A17").attr("checked","checked");
					}
					if($('#A18').val() == $(al).val()){
						$("#A18").attr("checked","checked");
					}
				<%}%>
			}
		});
		
		function edit(){
			$("#f").attr("action", '<%=request.getContextPath()%>/updateMember.me');
   	   		$("#f").submit();
		}
	</script>
</body>
</html>