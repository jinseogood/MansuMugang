<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script>
$(window).on("load resize ", function() {
	  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
	  $('.tbl-header').css({'padding-right':scrollWidth});
	}).resize();



</script>

<style>
 
 @font-face { font-family: 'GoyangDeogyang'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/GoyangDeogyang.woff') format('woff'); font-weight: normal; font-style: normal; }
 

h1{
  font-size: 30px;
  color: black;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
}

body{
  font-family:GoyangDeogyang;
}

section{
  /* margin: 50px; */
}

.notice{
	margin:50px;
	color:black;
}

#top{
	height:400px;
	background:tomato;
}

#main {
	width:100%;
}

.img {
	width:700px;
	height:200px;
	margin-left:auto;
	margin-right:auto;
}

.img > img{
	width:200px;
	height:200px;
	position:absolute;
}




</style>


<meta charset="UTF-8">
<title>결제완료</title>
</head>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<body>
	<div id="top">
		<%@ include file="../common/menubar.jsp"%>
	</div>
	<div id="main">
	<h1 class="notice">주문 완료</h1>
	<h5 class="notice" align="center">주문이 성공적으로 완료되었습니다.</h5>


      <div class="final_button" align="center">
        	<button class="w3-button w3-ripple w3-yellow" onclick="location.href='/msmg/views/foodPlan/menu_plan.jsp'"> 식단 계속 보기  </button>
        	<button class="w3-button w3-ripple w3-yellow" onclick="location.href='/msmg/index.jsp'"> 메인화면  </button>
        </div>
        
        </div>
        <!-- <div id="img">
        	<img src="/msmg/images/common/boxcar.PNG">
        </div> -->
        <div class="img">
        	<img id="img2" src="/msmg/images/common/boxcar2.png">
        </div>
        <script>
        $(document).ready(function(){
        	$("#img2").animate({"left": "+=500px"}, "slow");
        });
        
        
        </script>
<div id="mainBottom">
	<%@ include file="../common/footer.jsp" %>
</div>


</body>
</html>