<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
	$(window).on(
			"load resize ",
			function() {
				var scrollWidth = $('.tbl-content').width()
						- $('.tbl-content table').width();
				$('.tbl-header').css({
					'padding-right' : scrollWidth
				});
			}).resize();
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
@font-face {
	font-family: 'GoyangDeogyang';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/GoyangDeogyang.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

h1 {
	font-size: 30px;
	color: black;
	text-align: center;
	margin-bottom: 15px;
	font-family: GoyangDeogyang;
}

table {
	width: 100%;
	table-layout: fixed;
	font-family: GoyangDeogyang;
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
	font-family: GoyangDeogyang;
/* 	background: -webkit-linear-gradient(left, #25c481, #25b7c4);
	background: linear-gradient(to right, #25c481, #25b7c4); */
}

td {
   padding: 20px;
   text-align: left;
   vertical-align: auto;
   font-weight: 300;
   font-size: 12px;
   color: black;
   border-bottom: solid 1px black;
   font-family: GoyangDeogyang;
   /* background: -webkit-linear-gradient(left, #25c481, #25b7c4); */
  /* background: linear-gradient(to right, #25c481, #25b7c4); */
}

body {
	/*   background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4); */
	font-family: GoyangDeogyang;
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


</style>

</head>
<body>
<section>
			<h1>만수무강 회원가입</h1>

			<div class="tbl-content table1" align="center">
				<table cellpadding="0" cellspacing="0" border="0">
					<tbody>
						<!-- <tr>
							<th bgcolor=tomato>아이디(이메일)</th> -->
							<!-- <td colspan="4">
								<button class="w3-button w3-ripple w3-yellow">목록</button>
								<span>※ 기존에 보낸 주소 목록에서 선택하거나 직접 새로운 주소를 입력하세요.</span>
							</td> -->
						<!-- </tr> -->
						<tr>
							<th bgcolor=tomato>아이디(이메일)<span class="red">*</span></th>
							<td><input type="text"> <button class="w3-button w3-ripple w3-yellow">중복확인</button></td>
						</tr>
						<tr>
							<th bgcolor=tomato>인증번호</th>
							<td><input type="text"> <button class="w3-button w3-ripple w3-yellow">확인</button></td>
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
							<td><input type="text"></td>
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
										<input type="checkbox" name="allergy" value="올리브" id="olive">
										<label for="olive">올리브</label>
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
							<div class="w3-button w3-ripple w3-yellow"><a href="/msmg/index.jsp">취소하기</a></div>
							<div class="w3-button w3-ripple w3-yellow" onclick="insertMember();"><a href="/msmg/index.jsp">가입하기</a></div>
						</td>
					</tr>
						
						<!-- <tr>
							<th bgcolor=tomato>이름</th>
							<td colspan="4">
								<div style="padding: 7px 0 10px;">
									<input type="text" readonly name="" class="postcodify_postcode5" value="" />
								<button id="postcodify_search_button" class="w3-button w3-ripple w3-yellow">검색</button>
								</div> 
								
 -->
								<!-- <div>
									<input type="text" readonly class="postcodify_address" size="60" maxlength="50"> 
									<input type="text" class="postcodify_details" placeholder="상세주소" size="42" maxlength="50">
									<input type="text" readonly name="" class="postcodify_extra_info">
								</div> -->
								<!-- <div style="padding: 5px 0;" class="checks">
									<input type="checkbox" name="changeDefAdd" id="changeDefAdd"><label
										for="changeDefAdd">회원정보의 기존배송주소로 저장</label>
								</div>
							</td>
						</tr>


						<tr>
							<th bgcolor=tomato>이름</th>
							<td colspan="4"><input type="text" name="hpno1" id="hpno1"
								size="4" maxlength="4" value="010"> <span>－</span> <input
								type="text" name="hpno2" id="hpno2" size="4" maxlength="4"
								value="3101"> <span>－</span> <input type="text"
								name="hpno3" id="hpno3" size="4" maxlength="4" value="3419">

							</td>
						</tr>
						<tr>
							<th class="big" bgcolor=tomato>배송메시지</th>
							<td colspan="4">

								<div class="deliveryMessage">
									<em>※ 이 메시지는 배송시 택배기사에게 전달하는 메시지입니다.</em>
									<div class="deliveryMessageSelect">
										<ul>
											<li><input type="radio" name="radio">부재시 경비실에
												맡겨주세요.</li>
											<li><input type="radio" name="radio">부재시 휴대폰으로
												연락바랍니다.</li>
										</ul>
									</div>
								</div>
							</td>
						</tr> -->
					</tbody>
				</table>
			</div>
		</section>
</body>
</html>