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

/* .tooltip {
    position: relative;
    display: inline-block;
    border-bottom: 1px dotted black;
}

.tooltip .tooltiptext {
    visibility: hidden;
    width: 500px;
    background-color: black;
    color: #fff;
    text-align: center;
    border-radius: 6px;
    padding: 5px 0;

    /* Position the tooltip */
    position: absolute;
    z-index: 1;
}

.tooltip:hover .tooltiptext {
    visibility: visible;
}
 */
</style>
</head>
<body>
	<div id="outer">	
		<%@ include file="../common/menubar.jsp"%>
	</div>
	<div id="main" align="center">
		<section>
			<form name="f" action="<%= request.getContextPath() %>/insertMember.me" method="post">
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
							<td><input type="password" name="userPwd" id="userPwd"></td>
						</tr>
						<tr>
							<th bgcolor=tomato>비밀번호 확인<span class="red">*</span></th>
							<td><input type="password" name="userPwd1" id="userPwd1"></td>
						</tr>
						<tr>
							<th bgcolor=tomato>이름</th>
							<td><input type="text" name="userName" id="userName"></td>
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
						<form name="input_form">
							<table>
					<div class="clear"></div>
								<tr>
									<td>
										<input type="checkbox" name="all" id="allCheck">
										<label style="font-weight:bold">모든 약관과 안내에 동의합니다.</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="chk" value="1" id="1">
										<label for="1">만수무강 이용약관(필수)</label>
										<div class="tooltip">
 										 <span class="tooltiptext">
    									이용약관<br>

제1조(목적) <br>
<br>
이 약관은 장터넷 주식회사 회사(전자거래 사업자)가 운영하는 동물사랑APS 사이버 몰(이하 "몰"이라 한다)에서 제공하는 인터넷 관련 서비스(이하 "서비스"라 한다)를 이용함에 있어 사이버몰과 이용자의 권리·의무 및 책임사항을 규정함을 목적으로 합니다. <br>
※ 「PC통신등을 이용하는 전자거래에 대해서도 그 성질에 반하지 않는 한 이 약관을 준용합니다」 <br>
<br>
<br>
제2조(정의) <br>
<br>
① "몰"이란 장터넷 주식회사 회사가 재화 또는 용역을 이용자에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 재화 또는 용역을 거래할 수 있도록 설정한 가상의 영업장을 말하며, 아울러 사이버몰을 운영하는 사업자의 의미로도 사용합니다. <br>
② "이용자"란 "몰"에 접속하여 이 약관에 따라 "몰"이 제공하는 서비스를 받는 회원 및 비회원을 말합니다. <br>
③ '회원’이라 함은 "몰"에 개인정보를 제공하여 회원등록을 한 자로서, "몰"의 정보를 지속적으로 제공받으며, "몰"이 제공하는 서비스를 계속적으로 이용할 수 있는 자를 말합니다. <br>
④ '비회원’이라 함은 회원에 가입하지 않고 "몰"이 제공하는 서비스를 이용하는 자를 말합니다. <br>
<br>

										</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="chk" value="2" id="2">
										<label for="2">개인정보 수집 및 이용에 대한 안내(필수)</label>
										<div class="tooltip">
 										 <span class="tooltiptext">
    									1. 개인정보 수집에 대한 동의 <br>
동물사랑APS은 이용자의 개인정보보호방침 또는 이용약관의 내용에 대해 「동의합니다」버튼 또는 「동의하지 않습니다」버튼을 클릭할 수 있는 절차를 마련하여, 「동의합니다」버튼을 클릭하면 개인정보 수집에 대해 동의한 것으로 봅니다.<br>
<br>
2. 개인정보의 수집목적 및 이용목적<br>
"개인정보"라 함은 생존하는 개인에 관한 정보로서 당해 정보에 포함되어 있는 성명, 휴대폰번호 등의 사항에 의하여 당해 개인을 식별할 수 있는 정보(당해 정보만으로는 특정 개인을 식별할 수 없더라도 다른 정보와 용이하게 결합하여 식별할 수 있는 것을 포함)를 말합니다.<br>
대부분의 서비스는 별도의 사용자 등록이 없이 언제든지 사용할 수 있습니다. 그러나 동물사랑APS은 회원서비스를 통하여 이용자들에게 맞춤식 서비스를 비롯한 보다 더 향상된 양질의 서비스를 제공하기 위하여 다음과 같은 목적으로 이용자 개인의 정보를 수집 · 이용하고 있습니다.<br>
<br>
- 성명, 아이디, 비밀번호, 닉네임 : 회원제 서비스 이용에 따른 본인 확인 절차에 이용<br>
- 이메일, 휴대폰번호 : 고지사항 전달, 불만처리 등을 위한 원활한 의사소통 경로의 확보, 새로운 서비스 및 신상품이나 이벤트 정보 등의 안내<br>
- 주소, 전화번호 : 청구서, 물품배송 시 정확한 배송지의 확보<br>
- 기타 선택항목(직업, 관심분야, 관심분류) : 개인맞춤 서비스를 제공하기 위한 자료<br>
- IP Address : 불량회원의 부정 이용 방지와 비인가 사용 방지<br>

기타 위 수집된 정보를 이용하여 서비스 제공에 관한 계약이행 및 요금정산, 회원관리, 마케팅 및 광고에 활용하고 있습니다.<br>
<br>

										</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="chk" value="3" id="3">
										<label for="3">개인정보 처리 업무의 위탁에 대한 안내(필수)</label>
										<div class="tooltip">
 										 <span class="tooltiptext">
    									개인정보 처리 업무의 위탁<br>
<br>

재단은 이용자에 대하여 보다 더 질 높은 서비스 제공을 위해 아래와 같이 이용자의 개인정보 처리 업무를 외부전문업체에 위탁하고 있습니다.<br>
<br>
"이용자"는 위 개인정보에 수집 및 이용에 동의하지 않을 권리가 있습니다.<br>
다만 동의를 거부할 경우 서비스 이용에 장애(자연이랑 물품 구매 및 배송 등)가 있을 수 있습니다.<br>
<br>
개인정보 수탁자로 표기된 모두에게 (제공되는)개인정보 항목에 있는 정보가 전달되는 것이 아니라,회원이 특정(요청)또는 거래하는 자에게만 정보가 전달 됩니다. <br>
따라서 이용자께서 특정(요청) 또는 거래하지 않는(은)자에게는 동의란에 표시 하시더라도 회원님의 개인정보가 공유되지 않습니다.<br>
<br>
										</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="chk" value="4" id="4">
										<label for="4">개인정보 제 3자 제공 동의에 대한 안내(선택)</label>
										<div class="tooltip">
 										 <span class="tooltiptext">
    									개인정보 제3자 제공<br>
<br>
자연이랑은 이용자가 소속회사로부터 지원금 혜택을 받는 경우 이용자의 주문에 대한 원활한 지원금 지원 및 급여공제 등을 위해 이용자가 소속된 회사 등(회사 등의 담당자에 한 함)에 개인정보를 제공할 수 있습니다.<br>
<br>
										</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox" name="chk" value="5" id="5">
										<label for="5">정보전달을 위한 개인정보 이용 안내(선택)</label>
									</td>
								</tr>
								<tr>
								<table>
									<tr>
										<td>
											<input type="checkbox" name="chk" value="6" id="6">
											<label for="email">이메일</label>
										</td>
										<td>
											<input type="checkbox" name="chk" value="7" id="7">
											<label for="sns">SNS(알림메시지)</label>
										</td>
										<td>
											<input type="checkbox" name="chk" value="8" id="8">
											<label for="tel">전화</label>
										</td>
									</tr>
								</table>
								</tr>
							</table>
							</form>
						<td colspan="2">
						<div class="clear"></div>
							<input class="w3-button w3-ripple w3-yellow" type="reset" value="다시작성하기">
							<!-- <input class="w3-button w3-ripple w3-yellow" type="submit" value="가입하기" onclick="validation();"> -->
							<button onclick="return validation();" class="w3-button w3-ripple w3-yellow">가입하기</button>

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
	
	$(function(){ //전체선택 체크박스 클릭
		$("#allCheck").click(function(){ //만약 전체 선택 체크박스가 체크된상태일경우
			if($("#allCheck").prop("checked")) { //해당화면에 전체 checkbox들을 체크해준다 
				$("input[name=chk]").prop("checked",true); // 전체선택 체크박스가 해제된 경우 
			} else { //해당화면에 모든 checkbox들의 체크를해제시킨다.
				$("input[name=chk]").prop("checked",false);
			}
		});
	});
		
	
		function validation() {
			var userId = $('#userId').val();
			var userPwd = $('#userPwd').val();
			var userPwd1 = $('#userPwd1').val();
			var userName = $('#userName').val();
			var terms1 = $('#1:checked').val();
			console.log(terms1);
			var terms2 = $('#2:checked').val();
			console.log(terms2);
			var terms3 = $('#3:checked').val();
			console.log(terms3);

			if (userId == "") {
				alert("아이디(이메일)를 입력해주세요."); return false;
			} else {
				if (userPwd == "") {
					alert("비밀번호를 입력해주세요."); return false;
				} else {
					if (userPwd != userPwd1) {
						alert("비밀번호가 일치하지 않습니다."); return false;
					} else {
						if (userName == "") {
							alert("이름을 입력해주세요"); return false;
						} else {
							if (terms1 != '1' || terms2 != '2' || terms3 != '3') {
								alert("필수약관에 동의해주세요."); return false;
							} else {
								return true;
							}
						}
					}
				}
			}
		}

		/* 
		  function sendIt() {
		    var email = document.f.userId.value;
		    var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
		    var msg, ss, cc;
		      
		      if (document.f.userId.value == "") {
		          alert("이메일을 입력하지 않았습니다.")
		          document.f.userId.focus()
		          return false;
		      }
		      
		
		      if (regex.test(email) === false) {
		          alert("잘못된 이메일 형식입니다.");
		          document.f.userId.value=""
		          document.f.userId.focus()
		          return false;
		      } 
		      
		   
		    if (document.f.userPwd.value == "") {
		        alert("비밀번호를 입력하지 않았습니다.")
		        document.f.userPwd.focus()
		        return false;
		    }
		    if (f.userPwd.value == f.userId.value) {
		        alert("아이디와 비밀번호가 같습니다.")
		        document.f.userPwd.focus()
		        return false;
		    } 
		   
		    if (document.f.userPwd.value.length<4 || document.f.userPwd.value.length>12) {
		        alert("비밀번호를 4~12자까지 입력해주세요.")
		        document.f.userPwd.focus()
		        document.f.userPwd.select()
		        return false;
		    } 
		
		    
		    if (document.f.userPwd.value != document.f.userPwd1.value) {
		        alert("비밀번호가 일치하지 않습니다")
		        document.f.userPwd1.value = ""
		        document.f.userPwd1.focus()
		        return false;
		    }
		    if (document.f.userName.value == "") {
		        alert("이름을 입력하지 않았습니다.")
		        document.f.userName.focus()
		        return false;
		    }
		    if(document.f.userName.value.length<2){
		        alert("이름을 2자 이상 입력해주십시오.")
		        document.f.userName.focus()
		        return false;
		    }
			
		    function isNumeric(s) { 
		        for (i=0; i<s.length; i++) { 
		          c = s.substr(i, 1); 
		          if (c < "0" || c > "9") return false; 
		        } 
		        return true; 
		      }
		       
		      function isSSN(s1, s2) {
		         n = 2;
		         sum = 0;
		        for (i=0; i<s1.length; i++){
		          sum += parseInt(s1.substr(i, 1)) * n++;
		        }
		        for (i=0; i<s2.length-1; i++) {
		          sum += parseInt(s2.substr(i, 1)) * n++;
		          if (n == 10) n = 2;
		        }
		      
		        
		        c = 11 - sum % 11;
		        if (c == 11) c = 1;
		        if (c == 10) c = 0;
		        if (c != parseInt(s2.substr(6, 1))) return false;
		        else return true;
		
		      document.f.submit()
		  }}
		 */
	</script>
</body>
</html>