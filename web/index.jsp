<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*, com.msmg.mainIndex.model.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- <script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script> -->
<title>만수무강</title>
<style>
	html{
		height:100%;
	}
	body{
		height:100%;
	}
	#mainTop{
		width:100%;
		height:100%;
	}
	#mainCarousel{
		width:100%;
		height:100%;
	}
	#mainCarousel > #myCarousel{
		width:100%;
		height:100%;
	}
	#mainCarousel > #myCarousel > #myCarouselPhoto{
		width:100%;
		height:100%;
	}
	#myCarouselPhoto > div{
		width:100%;
		height:100%;
	}
	#myCarouselPhoto > div > img{
		width:100%;
		height:100%;
	}
	#mainMb{
		width:100%;
		height:20%;
		position:absolute;
		z-index:999;
	}
	#mainContent{
		width:100%;
		height:1300px;
	}
	#mainBottom{
		width:100%;
		height:200px;
	}
	.topMenuArea{
		width:80%;
		height:400px;
		margin-top:30px;
	}
	.topMenu{
		display:inline-block;
		width:20%;
		height:80%;
		border:1px solid lightgray;
		border-radius:3px;
		margin-left:50px;
		margin-right:50px;
		position:relative;
	}
	.topMenu:hover{
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	}
	.topMenuImg{
		width:90%;
		height:60%;
		margin-left:10px;
		margin-right:10px;
		margin-top:10px;
		/* position:absolute; */
	}
	.topMenuImg > img{
		width:100%;
		height:100%;
	}
	@media ( max-width: 1023px ) {
		.topMenuArea{
 	 		float: none;
       		width: 45%;
       		height:1200px;
        }
        #mainContent{
        	float: none;
       		width: auto;
       		height:auto;
        }
         .topMenuImg{
 	 		float: none;
       		width:auto
        }
        .topMenu{
			display:block;
			width:auto;
			height:400px;
		}
	}
	@media ( max-width: 767px ) {
  		.topMenuArea{
 	 		width: 80%;
        }
        .topMenu{
			height:400px;
		} 
	} 
</style>

</head>
<body>
	<div id="mainTop">
		<div id="mainMb">
			<%@ include file="views/common/menubar.jsp"%>
		</div>
		<div id="mainCarousel" align="center">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div id="myCarouselPhoto" class="carousel-inner">
					<div class="item active">
						<img src="images/main/food4.png" alt="Los Angeles">
					</div>

					<div class="item">
						<img src="images/main/food5.jpg" alt="Chicago">
					</div>

					<div class="item">
						<img src="images/main/food6.jpg" alt="New york">
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel"	data-slide="prev"> 
					<span class="glyphicon glyphicon-chevron-left"></span> 
					<span class="sr-only">Previous</span>
				</a> 
				<a class="right carousel-control" href="#myCarousel" data-slide="next"> 
					<span class="glyphicon glyphicon-chevron-right"></span> 
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	<div id="mainContent" align="center">
		<div id="g" class="topMenuArea">
			<br>
			<h4 align="left">고혈압 인기메뉴 >></h4>
			<div id="g1" class="topMenu">
				<div id="g1-img" class="topMenuImg">
					<img src="/msmg/images/main/food1.png">
				</div>
			</div>
			<div id="g2" class="topMenu">
				<div id="g2-img" class="topMenuImg">
					<img src="/msmg/images/main/food1.png">
				</div>
			</div>
			<div id="g3" class="topMenu">
				<div id="g3-img" class="topMenuImg">
					<img src="/msmg/images/main/food1.png">
				</div>
			</div>
		</div>
		<div id="d" class="topMenuArea">
			<br>
			<h4 align="left">당뇨병 인기메뉴 >></h4>
			<div id="d1" class="topMenu">
				<div id="d1-img" class="topMenuImg">
					<img src="/msmg/images/main/food1.png">
				</div>
			</div>
			<div id="d2" class="topMenu">
				<div id="d2-img" class="topMenuImg">
					<img src="/msmg/images/main/food1.png">
				</div>
			</div>
			<div id="d3" class="topMenu">
				<div id="d3-img" class="topMenuImg">
					<img src="/msmg/images/main/food1.png">
				</div>
			</div>
		</div>
		<div id="b" class="topMenuArea">
			<br>
			<h4 align="left">뇌질환 인기메뉴 >></h4>
			<div id="b1" class="topMenu">
				<div id="b1-img" class="topMenuImg">
					<img src="/msmg/images/main/food1.png">
				</div>
			</div>
			<div id="b2" class="topMenu">
				<div id="b2-img" class="topMenuImg">
					<img src="/msmg/images/main/food1.png">
				</div>
			</div>
			<div id="b3" class="topMenu">
				<div id="b3-img" class="topMenuImg">
					<img src="/msmg/images/main/food1.png">
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br><br><br><br>
	<div id="mainBottom">
		<%@ include file="views/common/footer.jsp" %>
	</div>
</body>
</html>