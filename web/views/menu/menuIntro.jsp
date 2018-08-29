<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.msmg.food.model.vo.*, java.util.*"%>
<%
	ArrayList<MenuList> list = (ArrayList<MenuList>) request.getAttribute("list");
	ArrayList<Like> MenuList = (ArrayList<Like>) request.getAttribute("MenuList");
	int count = 0;
%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<link ="stylesheet" type="text/css" href="/msmg/web/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>메뉴소개</title>
<style>
#back {
	width: 100%;
	height: 400px;
	background-image: url("/msmg/images/common/menu.png");
	margin-bottom: 20px;
}

.outer {
	height: 1300px;
}

#intro {
	border: 1px solid black;
	width: 100px;
	height: 50px;
}

.images {
	width: 94%;
	height: 700px;
	overflow: scroll;
	overflow-x: hidden;
	text-align: center;
	float: right;
}

.image {
	background: lightgray;
	width: 21%;
	height: 30%;
	margin: 20px;
	display: inline-block;
}

#btn {
	padding-top: 20px;
}

#menupan {
	height: 100px;
}

#mainBottom {
	width: 100%;
	height: 200px;
}

.topMenu {
	display: inline-block;
	width: 60%;
	height: 90%;
	border: 1px solid lightgray;
	border-radius: 3px;
	margin-left: 50px;
	margin-right: 50px;
	position: relative;
}

.topMenu:hover {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}

.topMenuImg {
	width: 90%;
	height: 60%;
	margin-left: 10px;
	margin-right: 10px;
	margin-top: 10px;
	/* position:absolute; */
}

.topMenuImg>div>img {
	width: 100%;
	height: 100%;
}

table td {
	height: 200px;
	width: 30% px;
}

td .in {
	height: 70px;
}

td .like {
	text-align: right;
	/* font-size:20px; */
}

.like>a {
	text-decoration: none;
}
.fa {
    font-size: 25px;
    cursor: pointer;
    user-select: none;
}

.fa:hover {
  color: darkblue;
}
@media ( max-width : 1023px ) {
	.images {
		float: none;
		width: auto;
		height: auto;
	}
	.topMenuImg {
		float: none;
		width: auto
	}
	.topMenu {
		display: block;
		width: auto;
		height: auto;
	}
}

@media ( max-width : 767px ) {
	.topMenu {
		height: auto;
	}
}
</style>
</head>
<body>
	<div id="back">
		<%@ include file="../common/menubar.jsp"%>
	</div>
	<div class="outer">
		<div class="container">
			<div>
				<div id="menupan" class="panel panel-default">
					<div class="panel-body">
						<b>고혈압(高血壓, hypertension)</b>은 혈압이 정상 범위보다 높은 만성 질환을 말한다. 고혈압은 혈액이
						혈관을 순환하는 데 심장이 더 많은 일을 하게 한다. 혈압은 맥박에서 수축기의 최고 혈압과 이완기의 최저 혈압의 두
						측정치로 요약되는데, 휴식시 정상 혈압은 수축시 100~140mmHg에 이완시 60~90mmHg이고, 혈압이 지속적으로
						140/90mmHg 이상일 때 고혈압이 있다고 말한다.
					</div>
				</div>
			</div>
			<div id="btn" class="btn-group-vertical">
				<% if(loginUser != null){ %>
					<button type="button" class="btn btn-primary"
					OnClick="location='<%=request.getContextPath()%>/MenuListG.fo?user='+<%= loginUser.getU_code() %>">고혈압</button>
					<button type="button" class="btn btn-primary"
					OnClick="location='<%=request.getContextPath()%>/MenuListD.fo?user='+<%= loginUser.getU_code() %>">당뇨병</button>
					<button type="button" class="btn btn-primary"
					OnClick="location='<%=request.getContextPath()%>/MenuListH.fo?user='+<%= loginUser.getU_code() %>">뇌질환</button>
				 <% }else{ %>
				 	<button type="button" class="btn btn-primary"
					OnClick="location='<%=request.getContextPath()%>/MenuListG.fo'">고혈압</button>
					<button type="button" class="btn btn-primary"
					OnClick="location='<%=request.getContextPath()%>/MenuListD.fo'">당뇨병</button>
					<button type="button" class="btn btn-primary"
					OnClick="location='<%=request.getContextPath()%>/MenuListH.fo'">뇌질환</button>
				 <% } %>
				
			</div>
			<div class="images">
				<table align="center" text-align="center">
					<%
						for (int j = 0; j <= list.size() / 3; j++) {
					%>

					<tr>
						<%
							for (int i = count; i < list.size();) {
						%>
						<td align="center">
							<div id="g1" class="topMenu">
								<div id="g1-img" class="topMenuImg">
									<div>
										<img
											src="<%=request.getContextPath()%>/images/food/<%=list.get(i).getImg_name()%>">
									</div>
									<div class="in"><%=list.get(i).getMenu_info()%></div>
									<div class="like" text-align="right">
										<input type = "hidden" value = "<%= list.get(i).getMenu_code() %>">			
										<% if(loginUser != null){
											if(MenuList.size() != 0){
											for(int l = 0 ; l < MenuList.size() ; l++){ 
												System.out.print("안오니");
												System.out.print(MenuList.get(l).getM_code() + "과" + list.get(i).getMenu_code());
												if(MenuList.get(l).getM_code() == list.get(i).getMenu_code()){
													
										%>
											
													<i class="fa fa-star" onclick = "like(<%= list.get(i).getMenu_code() %>, this)"></i>
											
										<% 
													break;
												}else{
													System.out.print("여긴오니");
													if(l == MenuList.size()-1){
										%>
													<i class="fa fa-star-o" onclick = "like(<%= list.get(i).getMenu_code() %>, this)"></i>
										<%
													}
												}
											}	
										
										   }else{%>
											   <i class="fa fa-star-o" onclick = "like(<%= list.get(i).getMenu_code() %>, this)"></i>
										   
										<% }
										}else{ %>
											<i class="fa fa-star-o" onclick = "like(<%= list.get(i).getMenu_code() %>, this)"></i>			
										<% } %>
									</div>
								</div>
							</div>
						</td>
						<%
							i++;
									count = i;
									if (count % 3 == 0) {
										break;

									}
						%>
						<%
							}
						%>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>
	<div id="mainBottom">
		<%@include file="../common/footer.jsp"%>
	</div>
	<script>
	function like(num, click){
		console.log(click);
	
        if($(click).attr('class') == 'fa fa-star-o'){
           <%if(loginUser != null){%>
           $(click).attr('class', 'fa fa-star');
              
              $.ajax({
                 url:'InsertLike.fo',
                 data:{
                    num : num,
                    user_no : <%=loginUser.getU_code()%>
                 },
                 success:function(data){
                    if(data != 0){
                       alert('해당 상품을 (좋아요) 하셨습니다!');
                    }else{
                       alert('이미 해당 상품을 (좋아요) 하셨습니다!');
                    }
                 }
              });
              
           <%}else{%>
              alert('로그인이 필요한 기능입니다.');
           <%}%>
        }else{
           <%if(loginUser != null){%>
           $(click).attr('class', 'fa fa-star-o');
           
           $.ajax({
              url:'DeleteLike.fo',
              data:{
                 num : num,
                 user_no : <%=loginUser.getU_code()%>
              },
              success:function(data){
                 if(data != 0){
                    alert('해당 상품을 (좋아요)에서 제거하셨습니다!');
                 }else{
                    alert('(좋아요)제거에 실패하셨습니다.');
                 }
              }
           });
           
        <%}else{%>
           alert('로그인 하셔야지 찜을 하실수 있습니다.');
        <%}%>
        }
     }
	</script>
</body>
</html>