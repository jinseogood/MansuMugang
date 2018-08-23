<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.msmg.payment.model.vo.*, java.util.*"%>
<%-- <% ArrayList<Destination> list = (ArrayList<Destination>)request.getAttribute(list); %> --%>
<!DOCTYPE html>
<html>

<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
	font:GoyangDeogyang;
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

#top {
	height: 400px;
	background: tomato;
}

#mainBottom {
	width: 100%;
	height: 200px;
}

#contents {
	min-height: 100%;
	position: relative;
}

.tooltip {
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

</style>


<meta charset="UTF-8">
<title>결제</title>
</head>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<body>

	<div id="top">
		<%@ include file="../common/menubar.jsp"%>
	</div>

	<div id="contents">

		<div id="one"></div>
		<div id="two">

			<h1 class="notice">주문 결제</h1>
			<h5 class="notice">주문 내역을 확인하고 결제로 넘어가실 수 있습니다.</h5>

			<br>

			<div class="basket">
				<div class="notice">
					<p>
						· 신선상품 특성 상 주문취소 및 배송지 변경은 <span>결제완료 상태에서 가능</span>하며, 이후 취소/변경
						하실 수 없습니다. <br> · 주문취소는 [마이페이지&gt;주문/배송정보]에서 신청하세요.
					</p>
				</div>
			</div>

			<section>
				<h1>주문상품 확인</h1>
				<div class="tbl-header table1">
					<table cellpadding="0" cellspacing="0" border="0">
						<thead>
							<tr>
								<th>상품 정보</th>
								<th>수량</th>
								<th>도착일</th>
								<th>금액</th>
							</tr>
						</thead>
					</table>
				</div>
				<div class="tbl-content table1">
					<table cellpadding="0" cellspacing="0" border="0">
						<tbody>
							<tr>
								<td>(상품정보)</td>
								<td>(수량)</td>
								<td>(예정일)</td>
								<td>(____원)</td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>

			<section>
				<h1>주문자 정보</h1>
				<div class="tbl-header table1">
					<table cellpadding="0" cellspacing="0" border="0">
						<thead>
							<tr>
								<th>이름</th>
								<!-- <th>연락처</th> -->
								<th>ID/이메일</th>
							</tr>
						</thead>
					</table>
				</div>
				<div class="tbl-content table1">
					<table cellpadding="0" cellspacing="0" border="0">
						<tbody>
							<tr>
								<td><%= loginUser.getU_name() %></td>
								<%-- <td id="buyer_tel"><%= loginUser. %></td> --%>
								<td><%= loginUser.getU_id() %></td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>






			<section>
				<h1>배송지 정보</h1>

				<div class="tbl-content table1">
					<table cellpadding="0" cellspacing="0" border="0">
						<tbody>
							<tr>

								<th bgcolor=tomato>배송지선택</th>
								<td colspan="4">
									<button class="w3-button w3-ripple w3-yellow"
										data-toggle="modal" data-book-id="my_id_value"
										class="identifyingClass" data-target="#myModal">목록</button> <span>※기존에
										보낸 주소 목록에서 선택하거나 직접 새로운 주소를 입력하세요.</span>
								</td>
							</tr>

							<tr>
								<th bgcolor=tomato>보내는 사람</th>
								<td colspan="4"><input type="text" id="sender"></td>
							</tr>
							<tr>
								<th bgcolor=tomato>받는 사람</th>
								<td colspan="4"><input type="text" id="receiver"></td>
							</tr>
							<tr>
							
							
							
								<th bgcolor=tomato>배송주소</th>
								<td colspan="4">
								
									<div style="padding: 7px 0 10px;">
										<div>
											<form id="pstcd" action="<%=request.getContextPath() %>/insertDestination.pm" method="post">
												<input type="text" readonly name="postcode1" class="postcodify_postcode5" id="postcode">
											</form>
											
											<button id="postcodify_search_button" class="w3-button w3-ripple w3-yellow">검색</button>
											
										</div>
									</div>
								
									
									<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
									<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
									
								<form id="addrrs" action="<%=request.getContextPath()%>/insertDestination.pm" method="post">
									<div>
										<input type="hidden" name="postcode" readonly class="postcodify_postcode5" id="postcode">
										<input type="text" name="addr1" readonly class="postcodify_address" size="60" maxlength="50" id="buyer_addr1"> 
										<input type="text" name="addr2" class="postcodify_details" placeholder="상세주소" size="42" maxlength="50" id="buyer_addr2"> 
										<input type="text" name="addr3" readonly class="postcodify_extra_info" id="buyer_addr3"> 
										<input type="hidden" name="u_code" value=<%= loginUser.getU_code() %>>
										<!-- <input type="text" name="id"><input type="checkbox" id="idSaveCheck"> -->
									</div>
								</form>
									<div style="padding: 5px 0;" class="checks">
										<input type="checkbox" name="AddrSaveCheck" id="AddrSaveCheck">
										<label for="AddrSaveCheck">회원정보의 기존배송주소로 저장 (체크하지 않을 시 최근 배송지로 저장되지 않습니다.) </label>
									</div>
								</td>
							</tr>



							<tr>
								<th bgcolor=tomato>휴대전화</th>
								<td colspan="4"><input type="text" name="hpno1" id="hpno1"
									size="4" maxlength="4"> <span>－</span> <input
									type="text" name="hpno2" id="hpno2" size="4" maxlength="4">
									<span>－</span> <input type="text" name="hpno3" id="hpno3"
									size="4" maxlength="4"></td>
							</tr>
							<tr>
								<th class="big" bgcolor=tomato>배송메시지</th>
								<td colspan="4">

									<div class="deliveryMessage">
										<em>※ 이 메시지는 배송시 택배기사에게 전달하는 메시지입니다.</em>
										<div class="deliveryMessageSelect">
											<ul>
												<li><input type="radio" name="radio">부재 시 경비실에
													맡겨주세요.</li>
												<li><input type="radio" name="radio">부재 시 휴대폰으로
													연락바랍니다.</li>
												<li><input type="radio" name="radio">부재 시 문앞에
													놔주세요.</li>
												<li><input type="radio" name="radio">파손 위험 상품이니
													조심히 다뤄주세요.</li>
											</ul>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>


			<!-- 최근 배송지로 저장된 주소 불러오는 모달 -->
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">배송지 목록 (3개의 최근 배송지 목록을 가져옵니다.)</h4>
						</div>
						<div class="modal-body">
							
							<div class="row">
								<table id="example-table-1" width="100%"
									class="table table-bordered table-hover text-center">
									<thead>
										<tr>
											<th>우편번호</th>
											<th>주소</th>
											<th>상세주소</th>
											<th>보조주소</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>2</td>
											<td>3</td>
											<td>4</td>
										</tr>
										<tr>
											<td>1</td>
											<td>2</td>
											<td>3</td>
											<td>4</td>
										</tr>
										<tr>
											<td>1</td>
											<td>2</td>
											<td>3</td>
											<td>4</td>
										</tr>
									</tbody>
								</table>
								<div class="col-lg-12" id="ex1_Result1"></div>
								<div class="col-lg-12" id="ex1_Result2"></div>
							</div>
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		




		<section>
				<h1>결제방법 선택</h1>

				<div class="tbl-content table1">
					<table cellpadding="0" cellspacing="0" border="0">
						<tbody>

							<tr>
								<th bgcolor=tomato>결제수단</th>
								<td colspan="4">
									<div id="cardPayCd">
										<input type="radio" name="radio2" id="creditCard"><label>신용카드</label>
									</div>
									<div id="bankTransfer">
										<input type="radio" name="radio2" id="bankAccount"><label>무통장입금</label>
									</div>
								</td>
							</tr>

						</tbody>
					</table>
				</div>
			</section>


			<section>
				<h1>적립금</h1>

				<div class="tbl-content table1">
					<table cellpadding="0" cellspacing="0" border="0">
						<tbody>
							<tr>
								<th>적립금</th>
								<td id="savedpoint">(사용 가능한 금액 표시)</td>
								<td><input type="text"></td>
								<td><button class="w3-button w3-ripple w3-yellow" id="lilpoint">사용</button>
								<td><button class="w3-button w3-ripple w3-yellow" id="fullpoint">전부 사용</button>
							</tr>
						</tbody>
					</table>
				</div>
			</section>
			
			<!-- 사용이나 전부 사용 누르면 그만큼 금액 깎여서 총 금액에 뜨게 하기 -->
			

			

			<section>
				<h1>결제금액</h1>
				<div class="tbl-header table1">
					<table cellpadding="0" cellspacing="0" border="0">
						<thead>
							<tr>
								<th>정상가</th>
								<th>주문금액</th>
								<th>배송비</th>
								<th>적립금</th>
							</tr>
						</thead>
					</table>
				</div>
				<div class="tbl-content table1">
					<table cellpadding="0" cellspacing="0" border="0">
						<tbody>
							<tr>
								<td>정상가격</td>
								<td>주문금액</td>
								<td>배송비</td>
								<td>적립금</td>
							</tr>
						</tbody>
					</table>
					<table class="basket_list_tbl2">
						<tbody>
							<tr class=total>
								<td>최종 결제 금액 <span class="red">(총가격)</span>원<input
									type="text" style="display: none;"></td>
						</tbody>
					</table>
				</div>


				
			</section>

			<div align="center">
				<input type="checkbox" id="confirmSettlement"
					name="confirmSettlement"><label for="confirmSettlement"
					align="center">주문할 상품의 상품명, 상품가격, 배송정보를 확인하였으며 구매에 동의합니다.</label>
					<div class="tooltip">상세보기
  <span class="tooltiptext">
		주문제작상품 구매 동의<br>
		· 본 상품은 주문제작상품으로 특정 주문자 만을 위하여 개별적으로 제작 및 생산되는 상품으로서, 다른 소비자에게 재판매가 불가능한 상품을 의미합니다.<br>
		· 주문제작상품은 반품/취소 제한에 동의해야 결제가 진행되며 전자상거래법에 따라 반품/취소가 불가능 할 수 있습니다.<br>
		· 다만, 주문제작상품으로 인정되지 않는 상품의 경우 구매자는 반품/취소 제한에 동의하였는지 여부를 불문하고 전자상거래 관련법령에 의거 보호를 받을 수 있습니다.<br>
</span>
</div>
			</div>
			

			<br> <br>

			<div class="final_button" align="center">
				<button class="w3-button w3-ripple w3-yellow">이전 단계로 이동</button>
				<button onclick="requestPay()" class="w3-button w3-ripple w3-yellow"> 결제하기</button>
			</div>
			

			<script>
		

				function requestPay() {

					var radioVal1 = $('#creditCard:checked').val();
					var radioVal2 = $('#bankAccount:checked').val();
					var checkVal = $('#confirmSettlement:checked').val();
					var sender = $("#sender").val();
					var receiver = $('#receiver').val();
					var postcode = $('#postcode').val();
					var buyer_addr = $('#buyer_addr2').val();
					var hpno1 = $('#hpno1').val();
					var hpno2 = $('#hpno2').val();
					var hpno3 = $('#hpno3').val();
					
					
					var pst = $("[name=postcode1]").val();
					$("[name=postcode]").val(pst);
					
					
					
					
					/* console.log(postcode); */

					if (sender == "") {
						alert("보내는 분의 성함을 입력해주세요.");
					} else {
						if (receiver == "") {
							alert("받는 분의 성함을 입력해주세요.");
						} else {
							if (postcode == "") {
								alert("우편번호를 입력해 주세요.");
							} else {
								if (buyer_addr == "") {
									alert("상세주소를 입력해 주세요.");
								} else {
									if (hpno1 == "") {
										alert("전화번호를 입력해 주세요.");
									} else {
										if (hpno2 == "") {
											alert("전화번호를 입력해 주세요.");
										} else {
											if (hpno3 == "") {
												alert("전화번호를 입력해 주세요.");
											} else {
												if (checkVal != 'on') {
													alert("결제를 진행하기 위해 약관 동의해주십시오.");
												} else {
													if (radioVal1 != 'on'
															&& radioVal2 != 'on') {
														alert("결제 수단을 선택해 주세요.");
													} else {
														if (radioVal1 == 'on') {
															// IMP.request_pay(param, callback) 호출
															IMP
																	.init("imp86047661");

															IMP
																	.request_pay(
																			{ // param
																				pg : "inicis",
																				pay_method : "card",
																				merchant_uid : 'merchant_'+ new Date().getTime(),
																				name : "노르웨이 회전 의자",
																				amount : 100,
																				buyer_email : $('#buyer_email').val(),
																				buyer_name : $('#receiver').val(),
																				buyer_tel : $('#buyer_tel').val(),
																				buyer_addr : $("#addrrs").val(),
																				
																				buyer_postcode : $('#postcode').val(),

																			},
																			function(
																					rsp) { // callback
																				if (rsp.success) {
																					jQuery
																							.ajax(
																									{
																										url : "http://localhost:8001/msmg/views/payment/paymentConfirm.jsp", // 가맹점 서버
																										method : "POST",
																										headers : {
																											"Content-Type" : "application/json"
																										},
																										data : {
																											imp_uid : rsp.imp_uid,
																											merchant_uid : rsp.merchant_uid
																										}
																									})
																							.done(
																									/* function(data) {
																										location.href = "paymentConfirm.jsp"
																									}) */
																									function(data) {
																										
																										if($("#AddrSaveCheck").is(":checked")){
																											
																											$("#pstcd").submit();
																											$("#addrrs").submit();
																											
																										} else {
																											location.href = "paymentConfirm.jsp";
																										}
	
																									})
																				} else {
																					alert("결제에 실패하였습니다. 에러 내용: "
																							+ rsp.error_msg);
																				}
																			});

														} else if (radioVal2 == 'on') {
															alert("만수무강 계좌: KEB하나은행 12345-1234-123245로 입금해 주세요.");
															location.href = "/msmg/views/member/OrderHistory.jsp";
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			</script>

			<script>
			$(function() {
				$("#postcodify_search_button").postcodifyPopUp();
			});
		</script>

<script>
<%-- <input type="checkbox" name="AddrSaveCheck" id="AddrSaveCheck">
<label for="AddrSaveCheck">회원정보의 기존배송주소로 저장</label>

<input type="text" name="addr1" readonly class="postcodify_address" size="60" maxlength="50" id="buyer_addr1"> 
<input type="text" name="addr2" class="postcodify_details" placeholder="상세주소" size="42" maxlength="50" id="buyer_addr2">
<input type="text" name="addr3" readonly class="postcodify_extra_info" id="buyer_addr3">
<input type="hidden" name="u_code" value=<%= loginUser.getU_code() %>> --%>

	

</script>



<!-- <script>
$(document).ready(function(){
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var userInputId = getCookie("userInputId");
    $("input[name='id']").val(userInputId);        
        
    }
     
    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
            var userInputId = $("input[name='id']").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("userInputId");
        }
    });  
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("input[name='id']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            var userInputId = $("input[name='id']").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
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
</script> -->

			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br>

		</div>
		<div id="three"></div>
	</div>
	<div id="mainBottom">
		<%@ include file="../common/footer.jsp"%>
	</div>
</body>
</html>