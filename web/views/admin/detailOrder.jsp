<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>주문 내역 상세</title>
<style>
	#content-1{
		width:510px;
		height:400px;
	}
	#content-2{
		width:510px;
		height:50px;
	}
	#orderMTable > thead > tr > th{
		background:lightgray;
	}
	#orderDTable{
		background:lightgray;
	}
</style>
</head>
<body>
	<form id="detailForm" action="" method="post">
		<div id="content-1" align="center">
			<h3>님 주문내역 상세</h3>
			<table id="orderMTable">
				<thead>
					<tr>
						<th width="15%">메뉴코드</th>
						<th width="35%">메뉴명</th>
						<th width="30%">주문일</th>
						<th width="15%">수량</th>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
		</div>
		<div id="content-2" align="center">
			<table id="orderDTable">
				<tr>
					<td width="15%">금액</td>
					<td width="25%" style="text-align:center;">원</td>
					<td width="15%">상품상태</td>
					<td width="30%">
						<select name="oStatus">
							<option value="1">결제대기</option>
							<option value="2">결제완료</option>
							<option value="3">배송준비</option>
							<option value="4">배송중</option>
							<option value="5">배송완료</option>
						</select>
						&nbsp;&nbsp;
						<button onclick="updateOStatus();">설정</button>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>