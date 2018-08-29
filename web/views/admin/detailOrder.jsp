<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.msmg.admin.model.vo.*"%>
<%
	ArrayList<Order> oSelectList=(ArrayList<Order>)request.getAttribute("oSearchList");

	int totalPrice=0;
	for(int i=0;i<oSelectList.size();i++){
		totalPrice+=oSelectList.get(i).getPrice();
	}

	PageInfo pi=(PageInfo)request.getAttribute("pi");
	int listCount=pi.getListCount();
	int currentPage=pi.getCurrentPage();
	int maxPage=pi.getMaxPage();
	int startPage=pi.getStartPage();
	int endPage=pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>주문 내역 상세</title>
<style>
	#content-1{
		width:510px;
		height:350px;
	}
	.pageArea{
		width:510px;
		height:50px;
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
					<%
						for(Order o : oSelectList){
					%>
							<tr>
								<td><%= o.getMenu_code() %></td>
								<td><%= o.getMenu_name() %></td>
								<td><%= o.getMenu_code() %></td>
								<td><%= o.getMenu_code() %></td>
							</tr>
				</tbody>
			</table>
		</div>
		<div class="pageArea" align="center">
			<button onclick="location.href='<%= request.getContextPath() %>/selectOneOrderList?dietNo=<%= oSelectList.get(0).getDiet_no() %>&currentPage=1'"><<</button>
			<%
				if(currentPage <= 1){
			%>
					<button disabled><</button>
			<%
				}
				else{
			%>
					<button onclick="location.href='<%= request.getContextPath() %>/selectOneOrderList?dietNo=<%= oSelectList.get(0).getDiet_no() %>&currentPage=<%= currentPage - 1 %>'"><</button>
			<%
				}
			%>
			
			<%
				for(int p=startPage;p<=endPage;p++){
					if(p==currentPage){
			%>
						<button disabled><%= p %></button>
			<%
					}
					else{
			%>
						<button onclick="location.href='<%= request.getContextPath() %>/selectOneOrderList?dietNo=<%= oSelectList.get(0).getDiet_no() %>&currentPage=<%= p %>'"><%= p %></button>
			<%		
					}
				}
			%>
			
			<%
				if(currentPage >= maxPage){
			%>
					<button disabled>></button>
			<%
				}
				else{
			%>
					<button onclick="location.href='<%= request.getContextPath() %>/selectOneOrderList?dietNo=<%= oSelectList.get(0).getDiet_no() %>&currentPage=<%= currentPage + 1 %>'">></button>
			<%
				}
			%>
			<button onclick="location.href='<%= request.getContextPath() %>/selectOneOrderList?dietNo=<%= oSelectList.get(0).getDiet_no() %>&currentPage=<%= maxPage %>'">>></button>
		</div>
		<div id="content-2" align="center">
			<table id="orderDTable">
				<tr>
					<td width="15%">금액</td>
					<td width="25%" style="text-align:center;"><%= totalPrice %>원</td>
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