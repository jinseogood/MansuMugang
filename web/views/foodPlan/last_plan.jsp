<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.msmg.food.model.vo.*"%>
<%
	ArrayList<Menu> list = (ArrayList<Menu>)request.getAttribute("list");
	SelectFood sf = (SelectFood)request.getAttribute("sf");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	 	 height:80%;
	 	 background:#FAFAFA;
		 overflow:auto;
		 overflow-x:hidden;
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
	.image{
		 width:26%;
		 height:300px;
		 /* height:100%; */
	     /* text-align:center; */
	     align:center;
	     display:inline-block;
	     background:lightgray;
	     margin-left:20px;
	     margin-right:20px;
	     margin-top:10px;
		 align:left;
	     /* clear:both; */

	}

	.images{
		/* padding-left:50px; */
		width:80%;
		height:1000px;
		margin-top:20px;
		align:center;
		/* float:left; */
	}
	.btns{
		/* padding-left:80px; */
		background:#FAFAFA;
		align:center;
		width:100%;
		height:10%;
		margin-top:10px;
	}
	.images > h1{
		/* padding-right:50px; */
	}
	.mainBottom{
		width:100%;
		height:200px;
	}
	.content > #next1{
		text-align:center;
	}
	@media ( max-width: 1023px ) {
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
				<h1><%= sf.getDay()%>일 <%= sf.getGgi() %>끼의 식단표</h1>
				
				<br><br>
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
			<div class = "btn2"><a href = "#">
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
          <p>셀렉트로 선택하고 사진까지 보여줄까?</p>
        </div>
        <div class="modal-footer">
       	  <input type="submit" class="btn btn-default" value="OK" >&nbsp;
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div>
</form>
	<div class="mainBottom hidden-xs hidden-sm hidden-md">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>