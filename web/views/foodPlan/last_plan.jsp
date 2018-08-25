<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.msmg.food.model.vo.*"%>
<%
	ArrayList<Menu> list = (ArrayList<Menu>)request.getAttribute("list");
	SelectFood sf = (SelectFood)request.getAttribute("sf");
	int total_price = 0;
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>식단짜기</title>
<style>
	html{
		height:100%;
		background:#FAFAFA;
	}
	body{
		/* background:yellowgreen; */
		height:100%;
		align:center;
	}
	.top{
		width:100%;
		height:400px;
		background-image:url("/msmg/images/common/menu3.png");
	}
	#main{
		min-height:80%;
		position:relative;
	}
	/*  .left{
		 width:10%;
	 	 height:600px;
	 	 background:white;
	 	 border-style:hidden;
		 box-shadow:1px 0px 0px 0px black; 
		 position:absolute;
		 top:1px;
		 left:1px;
	}  */
	.content{
		 width:100%;
	 	 height:600px;
	 	 background:#FAFAFA;
		 /* overflow:auto; */
		 /* overflow-x:hidden; */
		 align:center;
	}
	.btn2{
		background:lightgray;
		width:80px;
		height:40px;	
		display:inline-block;
		margin:20px;
		margin-left:-10px;
	}
	
	.btn2 > a > img{
		width:100%;
		height:100%;
	}
	#n{
		text-decoration:none;
	}
	#n:hover{
		color:white;
		text-decoration:none;
	}
	/* .image{
		 width:26%;
		 height:300px;
	     align:center;
	     display:inline-block;
	     background:lightgray;
	     margin-left:20px;
	     margin-right:20px;
	     margin-top:10px;
		 align:left;

	}

	.images{
		width:80%;
		height:1000px;
		margin-top:20px;
		align:center;
	} */
	#Img{
		width:100%;
		height:50%;
	}
	.btns{
		background:#FAFAFA;
		align:center;
		width:100%;
		height:10%;
		margin-top:10px;
	}
	.mainBottom{
		width:100%;
		height:200px;
	}
	.content > #next1{
		text-align:center;
	}
	@media ( max-width: 1600px ) {
		.images{
 	 		float: none;
       		width: 80%;
       		height:auto;
        }
        #content{
        	float: none;
       		width: auto;
       		height:auto;
        }
         .image{
 	 		float:none;
       		width:40%;
        }
	}
	@media ( max-width: 767px ) {
  		 .image{
       		width:80%;
        }
	} 
	table {
		/* border: 1px solid rgba(255, 255, 255, 0.3); */
		text-align: center;
		border-radius:3px;
	}
	.tableArea{
		margin-top: 50px;
		border: 1px solid rgba(255, 255, 255, 0.3);
		margin-left: auto;
		margin-right: auto;
	}
	.menu_info { 
		position: relative;
	}
	.menu_text { 
		visibility: hidden;
		width: 200px;
		background-color: lightgray;
		color: black; 
		text-align: center; 
		border-radius: 10px; 
		padding: 5px 5px; 
		position: absolute; 
		z-index: 999;
		left: 100%;
		top:-100%;
	}
	.menu_info:hover .menu_text { 
		visibility: visible; 
	}


</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div class = "top hidden-xs hidden-sm">
		<%@ include file="../common/menubar.jsp" %>
	</div>
	<div id="main" >
		<div class = "content block1" align="center">
				<br>
				<h1><%= sf.getDay()%>일 <%= sf.getGgi() %>끼의 식단표</h1>
				<br>
		<div class = "tableArea">
			<table id="test" align = "center">
				<%
				int rand=0;
				for(int j = 0 ; j < sf.getDay() ; j++){ %>
				<tr class = "tr1">
					<td bgcolor=tomato width = "390px" height = "30px" colspan = "<%= sf.getGgi() %>">
						<%= j+1 %>일
					</td>
				</tr>
				<tr>
					<% for(int i = 0 ; i < sf.getGgi() ; i++){
						Random r = new Random();
						rand = r.nextInt(list.size());
					%>
					
					    
						<%-- <td id = "menu_chan<%= j %><%= i %>" class = "menu_info" height = "25px" onclick="show('<%= list.get(rand).getName() %>')"> --%>
						<td id = "menu_chan<%= j %><%= i %>" class = "menu_info" height = "25px" width = "130px">
							<div id = "mc" value = ""><%= list.get(rand).getName() %></div>		
							<div class="menu_text">
							
								<table align = "center" id = "menu_table<%= j %><%= i %>">
									<tr>
										<td colspan = "3" width = "200px">
											<img id="Img" 
											src="<%=request.getContextPath() %>/images/food/<%=list.get(rand).getImg_name()%>">
										</td>
									</tr>
									<tr>
										<td>메인재료</td>
										<td>부재료</td>
										<td>가격</td>
									</tr>
									<tr>
										<td><%= list.get(rand).getMain_grad()%></td>
										<td><%= list.get(rand).getSub_grad()%></td>
										<td><%= list.get(rand).getPrice()%></td>
										<input type = "hidden" name="" value = "<%= rand %>">
										<% total_price += list.get(rand).getPrice();%>
									</tr>
									<tr>
										<td colspan = "3"><%= list.get(rand).getInfo()%></td>
									</tr>
									
								</table>

							</div>
						</td>
					<% } %>
				</tr>
				<% } %>
				<tr>
					<td colspan = "<%= sf.getGgi() %>" bgcolor = "yellow">총가격 : <%= total_price %></td>
				</tr>
			</table>
		</div>
				
				<div class = "images">
					<!-- <div class = "image" data-toggle="modal" data-target="#myModal" align="center">사진1</div> -->
				</div>
			
		</div>
		</div>
	<div class = "btns" align="center">
			<div class = "btn2"><a href = "/msmg/index.jsp">
				<img src = "/msmg/images/button/cancelbutton.png">
			</a></div>
			<div class = "btn2"><a href = "#">
				<img src = "/msmg/images/button/basketbutton.png">
			</a></div>
			<div class = "btn2 throw"><a href = "#">
				<img src = "/msmg/images/button/paybutton.png">
			</a></div>
	</div>
	<form>	
<div class="container">
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">메뉴 리스트</h4>
        </div>
        <div class="modal-body">
          <% for(int b = 0 ; b < list.size() ; b++){ 
          %>
          		<div>
				<input type="radio" name="menu_change" value="<%= list.get(b).getName() %>" id="l<%= b %>">
				<input type = "hidden" name="" value = "<%= list.get(b).getImg_name() %>">
				<input type = "hidden" name="" value = "<%= list.get(b).getMain_grad() %>">
				<input type = "hidden" name="" value = "<%= list.get(b).getSub_grad() %>">
				<input type = "hidden" name="" value = "<%= list.get(b).getPrice() %>">
				<input type = "hidden" name="" value = "<%= list.get(b).getInfo() %>">
				<input type = "hidden" name="" value = "<%= b %>">
				<label for="l<%= b %>"><%= list.get(b).getName() %></label>	
				</div>
		  <% } %>
        </div>
        
        <div class="modal-footer">
       	  <input type="button" class = "btn" id ="OK_btn" value="OK" >&nbsp;
          <button type="button" class = "btn" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div>
</form>
	<script>
	/* $(document).ready(function () {
	
	}); */
	var t;
    var first_price = Number(<%= total_price %>);
	
	$("#test tr:odd td").click(function(){     

        $("#myModal").modal('show');
 
        t = $(this);
        
		var last_price;
		var p;
		var seq;
        $("#OK_btn").off().click(function(){
    		var name = $('input[name="menu_change"]:checked').val();
    	        t.children().eq(0).text(name);
    	        
    	    var img_name = $('input[name="menu_change"]:checked').parents().children().eq(1).val();
    	    	t.children().eq(1).children().eq(0).children().eq(0).children().eq(0).children().eq(0).children().eq(0).attr("src", "<%=request.getContextPath() %>/images/food/" + img_name);
    	    var main_grad = $('input[name="menu_change"]:checked').parents().children().eq(2).val();
    	   		t.children().eq(1).children().eq(0).children().eq(0).children().eq(2).children().eq(0).text(main_grad);
    	    var sub_grad = $('input[name="menu_change"]:checked').parents().children().eq(3).val();
    	 		t.children().eq(1).children().eq(0).children().eq(0).children().eq(2).children().eq(1).text(sub_grad);
    	    var	price = $('input[name="menu_change"]:checked').parents().children().eq(4).val();
    	  		p = t.children().eq(1).children().eq(0).children().eq(0).children().eq(2).children().eq(2).text();
    	  	    t.children().eq(1).children().eq(0).children().eq(0).children().eq(2).children().eq(2).text(price);
    	    var info = $('input[name="menu_change"]:checked').parents().children().eq(5).val();
    	  	    t.children().eq(1).children().eq(0).children().eq(0).children().eq(3).children().eq(0).text(info);
    	  	    seq = $('input[name="menu_change"]:checked').parents().children().eq(6).val();    
    	  		t.children().eq(1).children().eq(0).children().eq(0).children().eq(2).children().eq(3).val(seq);
    	  		
    	    $("#myModal").modal('hide');
			last_price = first_price + Number(price) - Number(p);
			first_price = last_price;

			var day = Number(<%= sf.getDay() %>*2+1);
			
			$("#test").children().eq(0).children().eq(15).children().eq(0).text(first_price);
			
			console.log(first_price);
			console.log(seq);
        });
        
	});
	$(function(){
		$(".throw").click(function(){ 
			var day = <%= sf.getDay() %>;
			var ggi = <%= sf.getGgi() %>;
			var side = <%= sf.getSide() %>;
			var go = <%= sf.getGo() %>;
			var dang = <%= sf.getDang() %>;
			var head = <%= sf.getHead() %>;
			var total_price = first_price;
			console.log(total_price);
			var result = "";
			//var num = $("#test").children().eq(0).children().eq(3).children().eq(0).children().eq(1).children().eq(0).children().eq(0).children().eq(2).children().eq(3).val();
			                                                    /*1, 3, 5       0, 1, 2*/
			for(var i = 1 ; i < (day*2); i+=2){
				for(var j = 0 ; j < ggi; j++){
					var name = $("#test").children().eq(0).children().eq(i).children().eq(j).children().eq(0).text();		
																		//1,3,5,7,9,11,13    0,1,2
																		
					if(i==day*2-1 && j == ggi-1){
						
						result += name;
					}else{
						result += name + ", ";
					}													
					//console.log(result);
				}
			}
			
			console.log(result); 
			location.href="<%= request.getContextPath()%>/insertBuy.fo?result=" + result + "&day=" + day + "&ggi=" + ggi + "&side=" + side + "&go=" + go + "&dang=" + dang + "&head=" + head + "&total_price=" + total_price;
		});
	});

</script>

	<div class="mainBottom hidden-xs hidden-sm hidden-md">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>