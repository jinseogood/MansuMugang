<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>

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

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>

table tr{
		color: #e83f26;
   border-top: 1px solid #e83f26;
   border-bottom: 1px solid #e83f26;
   padding-top: 8px;
   padding-bottom: 8px;
   font-size: 1.3em;
	}
	[type=text] {
		border:none;
		width:50px;
	}
	.mainmenu{
		height:35%;
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
	
	/* .te td::before{
		/* border:1px solid black; */
		background:pink;
	} */

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
   text-transform: uppercase;
   font-weight: 300;
   text-align: center;
   margin-bottom: 15px;
}

table {
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
}

th {
   padding: 20px 15px;
   text-align: center;
   font-weight: 500;
   font-size: 12px;
   color: #fff;
   text-transform: uppercase;
   background: -webkit-linear-gradient(left, #25c481, #25b7c4);
   background: linear-gradient(to right, #25c481, #25b7c4);
}

td {
   padding: 20px;
   text-align: left;
   vertical-align: auto;
   font-weight: 300;
   font-size: 12px;
   color: black;
   border-bottom: solid 1px black;
   /* background: -webkit-linear-gradient(left, #25c481, #25b7c4); */
  /* background: linear-gradient(to right, #25c481, #25b7c4); */
}



section {
   margin: 50px;
}

/* /* follow me template */
.made-with-love {
   margin-top: 40px;
   padding: 10px;
   clear: left;
   text-align: center;
   font-size: 10px;
   color: #fff;
}

.made-with-love i {
   font-style: normal;
   color: black;
   font-size: 14px;
   position: relative;
   top: 2px;
}

.made-with-love a {
   color: #fff;
   /* text-decoration: none; */
}

.made-with-love a:hover {
   text-decoration: underline;
}

.table1 {
   height: auto;
} */
</style>

<body>
<div class="mainmenu">
   <%@ include file="../common/menubar.jsp"%>
</div>
	<%-- <%@ include file="myPageSubmenu.jsp" %> --%>
	<div align="center">
		<form>
			<table cellpadding="0" cellspacing="0" border="0" class="table table-bordered">
				<tr class="te">
					<td bgcolor=tomato><input type="checkbox" class="w3-button w3-ripple w3-yellow"><label>전체 선택</label></td>
					<td bgcolor=tomato>상품</td>
					<td bgcolor=tomato>수량</td>
					<td bgcolor=tomato>도착예정일</td>
					<td bgcolor=tomato>금액</td>
					<td bgcolor=tomato><button class="w3-button w3-ripple w3-yellow">전체삭제</button></td>
				</tr>
				<tr>
					<td><input type="checkbox"></td>
					<td>고혈압 7일 3끼</td>
					<td>1개</td>
					<td>2018년 10월 23일</td>
					<td>330,000원</td>
					<td><button class="w3-button w3-ripple w3-yellow">삭제</button></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>배송비</td>
					<td><input type="text" readonly style="display: none;"></td>
					<td>원</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>합계</td>
					<td><input type="text" readonly style="display: none;"></td>
					<td>원</td>
				</tr>
				<tr align="center">
					<td colspan="6" bgcolor=tomato>
						<input type="button" value="쇼핑계속하기" href="#" class="w3-button w3-ripple w3-yellow">
						<input type="button" value="주문하기" href="#" class="w3-button w3-ripple w3-yellow">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div style="margin-bottom:400px"></div>
<%@ include file="../common/footer.jsp" %>

</body>
</html>