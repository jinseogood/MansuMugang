<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
	font-size: 16px;
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
   font-size: 16px;
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

#outer{
	height:400px;
	background-image:url("/msmg/images/common/sign_up.png");
}

div a {
	text-decoration:none;
}

</style>
</head>
<body>
	<div id="outer">	
		<%@ include file="../common/menubar.jsp"%>
	</div>
	<div id="main" align="center">
		<section>
			<form action="<%= request.getContextPath() %>/insertMember.me" method="post">
			<div class="tbl-content table1" align="center">
				<table cellpadding="0" cellspacing="0" border="0">
					<tbody>
						<tr>
							<th bgcolor=tomato>아이디(이메일)<span class="red">*</span></th>
							<td><input type="text" id="userId" name="userId"><div class="w3-button w3-ripple w3-yellow" id="idCheck">중복확인</div></button></td>
						</tr>
						<tr>
							<th bgcolor=tomato>인증번호</th>
							<td><input type="text"> <button class="w3-button w3-ripple w3-yellow">확인</button></td>
						</tr>
						<tr>
							<th bgcolor=tomato>비밀번호<span class="red">*</span></th>
							<td><input type="password" name="userPwd"></td>
						</tr>
						<tr>
							<th bgcolor=tomato>비밀번호 확인<span class="red">*</span></th>
							<td><input type="password"></td>
						</tr>
						<tr>
							<th bgcolor=tomato>이름</th>
							<td><input type="text" name="userName"></td>
						</tr>
						<br>
						<tr>
							<table align="center">
								<tr>
									<th colspan="3"><label>@가지고계신 알레르기를 선택해주세요@</label></th>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="A1" id="eggs">
										<label for="eggs">난류(계란)</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A2" id="milk">
										<label for="milk">우유</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A3" id="memil">
										<label for="memil">메밀</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="A4" id="peanut">
										<label for="peanut">땅콩</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A5" id="bean">
										<label for="bean">대두</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A6" id="wheat">
										<label for="wheat">밀</label><br>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="A7" id="mackerel">
										<label for="mackerel">고등어</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A8" id="crab">
										<label for="crab">게</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A9" id="pork">
										<label for="pork">돼지고기</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="A10" id="peach">
										<label for="peach">복숭아</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A11" id="tomato">
										<label for="tomato">토마토</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A12" id="shrimp">
										<label for="shrimp">새우</label><br>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="A13" id="walnut">
										<label for="walnut">호두</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A14" id="chicken">
										<label for="chicken">닭고기</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A15" id="beef">
										<label for="beef">쇠고기</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="allergy" value="A16" id="squid">
										<label for="squid">오징어</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A17" id="clam">
										<label for="clam">조개류</label>
									</td>
									<td>
										<input type="checkbox" name="allergy" value="A18" id="acid">
										<label for="acid">아황산류</label>
									</td>	
								</tr>
							</table>
						</tr>
						<tr align="center" class="wrap">
							<table>
					<div class="clear"></div>
								<tr>
									<td>
										<input type="checkbox" name="terms" value="약관1" id="1">
										<label for="1">모든 약관과 안내에 동의합니다.</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="terms" value="약관2" id="2">
										<label for="2">만수무강 이용약관(필수)</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="terms" value="약관3" id="3">
										<label for="3">개인정보 수집 및 이용에 대한 안내(필수)</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="terms" value="약관4" id="4">
										<label for="4">개인정보 처리 업무의 위탁에 대한 안내(필수)</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="terms" value="약관5" id="5">
										<label for="5">개인정보 제 3자 제공 동의에 대한 안내(선택)</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="terms" value="약관6" id="6">
										<label for="6">정보전달을 위한 개인정보 이용 안내(선택)</label>
									</td>
								</tr>
								<tr>
								<table>
									<tr>
										<td>
											<input type="checkbox" name="terms" value="이메일" id="email">
											<label for="email">이메일</label>
										</td>
										<td>
											<input type="checkbox" name="terms" value="sns" id="sns">
											<label for="sns">SNS(알림메시지)</label>
										</td>
										<td>
											<input type="checkbox" name="terms" value="전화" id="tel">
											<label for="tel">전화</label>
										</td>
									</tr>
								</table>
								</tr>
							</table>
						<td colspan="2">
						<div class="clear"></div>
							<div class="w3-button w3-ripple w3-yellow">취소하기</div>
							<div class="w3-button w3-ripple w3-yellow">가입하기</div>
							<input type="submit" value="가입하기테스트">
						</td>
					</tr>
					</tbody>
				</table>
			</div>
			</form>
		</section>
	</div>
	<div id="mainBottom">
		<%@ include file="../common/footer.jsp" %>
	</div>
	<script>
	$(function(){
		$("#idCheck").click(function(){
			var userId = $("#userId").val();
			console.log(userId);
			$.ajax({
				url:"/msmg/idCheck.me",
				type:"post",
				data:{userId:userId},
				success:function(data){
					console.log(data);
					if(data == "fail"){
						alert("아이디가 중복됩니다.");
					}else{
						alert("사용 가능합니다.")
					}
				},
				error:function(data){
					console.log("실패");
				}
			});
		});
	});
	</script>
</body>
</html>