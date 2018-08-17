<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>


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

	#top{
		height:400px;
		background:tomato;
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
					· 신선상품 특성 상 주문취소 및 배송지 변경은 <span>결제완료 상태에서 가능</span>하며, 이후 취소/변경 하실
					수 없습니다. <br> · 주문취소는 [마이페이지&gt;주문/배송정보]에서 신청하세요.
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
							<th>연락처</th>
							<th>이메일</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="tbl-content table1">
				<table cellpadding="0" cellspacing="0" border="0">
					<tbody>
						<tr>
							<td>주문자 이름</td>
							<td>연락처</td>
							<td>이메일</td>
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
								<button class="w3-button w3-ripple w3-yellow">목록</button>
								<span>※ 기존에 보낸 주소 목록에서 선택하거나 직접 새로운 주소를 입력하세요.</span>
							</td>
						</tr>
						<tr>
							<th bgcolor=tomato>보내는 사람</th>
							<td colspan="4"><input type="text"></td>
						</tr>
						<tr>
							<th bgcolor=tomato>받는 사람</th>
							<td colspan="4"><input type="text"></td>
						</tr>
						<tr>
							<th bgcolor=tomato>배송주소</th>
							<td colspan="4">
								<div style="padding: 7px 0 10px;">
									<input type="text" readonly name="" class="postcodify_postcode5" value="" />
								<button id="postcodify_search_button" class="w3-button w3-ripple w3-yellow">검색</button>
								</div> 
								
								<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
								<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>

								<div>
									<input type="text" readonly class="postcodify_address" size="60" maxlength="50"> 
									<input type="text" class="postcodify_details" placeholder="상세주소" size="42" maxlength="50">
									<input type="text" readonly name="" class="postcodify_extra_info">
								</div>
								<div style="padding: 5px 0;" class="checks">
									<input type="checkbox" name="changeDefAdd" id="changeDefAdd"><label
										for="changeDefAdd">회원정보의 기존배송주소로 저장</label>
								</div>
							</td>
						</tr>


						<tr>
							<th bgcolor=tomato>휴대전화</th>
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
						</tr>
					</tbody>
				</table>
			</div>
		</section>

		<section>
			<h1>결제방법 선택</h1>

			<div class="tbl-content table1">
				<table cellpadding="0" cellspacing="0" border="0">
					<tbody>

						<tr>
							<th bgcolor=tomato>결제수단</th>
							<td colspan="4">
								<div id="cardPayCd">
									<input type="radio" name="radio2"><label>신용카드</label>
								</div>
								<div id="rtrsPayCd">
									<input type="radio" name="radio2"><label>실시간계좌이체</label>
								</div>
							</td>
						</tr>

					</tbody>
				</table>
			</div>
		</section>


		<section>
			<h1>결제금액</h1>
			<div class="tbl-header table1">
				<table cellpadding="0" cellspacing="0" border="0">
					<thead>
						<tr>
							<th>정상가</th>
							<th>주문금액</th>
							<th>배송비</th>
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
		</div>

		<br>
		<br>

		<div class="final_button" align="center">
			<button class="w3-button w3-ripple w3-yellow">이전 단계로 이동</button>
			<button onclick="requestPay()" class="w3-button w3-ripple w3-yellow"> 결제하기</button>
		</div>

		<script>
			function requestPay() {
				// IMP.request_pay(param, callback) 호출
				IMP.init("imp86047661");

				IMP.request_pay({ // param
					pg : "inicis",
					pay_method : "card",
					merchant_uid : "ORD20180131-0000013",
					name : "노르웨이 회전 의자",
					amount : 100,
					buyer_email : "gildong@gmail.com",
					buyer_name : "홍길동",
					buyer_tel : "010-4242-4242",
					buyer_addr : "서울특별시 강남구 신사동",
					buyer_postcode : "01181"
				}, function(rsp) { // callback
					if (rsp.success) {
						jQuery.ajax({
				            url: "http://localhost:8001/msmg/views/payment/paymentConfirm.jsp", // 가맹점 서버
				            method: "POST",
				            headers: { "Content-Type": "application/json" },
				            data: {
				                imp_uid: rsp.imp_uid,
				                merchant_uid: rsp.merchant_uid
				            }
				        }).done(function (data) {

				        })
				    } else {
				        alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
				    }
				});
			}

		</script>

		<script>
			$(function() {
				$("#postcodify_search_button").postcodifyPopUp();
			});
		</script>



		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>

	</div>
	<div id="three"></div>
	</div>
		<div id="mainBottom">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>