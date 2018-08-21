<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
html {
	height: 100%;
}

#mainBottom{
		width:100%;
		height:200px;
	}

body {
	/* background:yellowgreen; 토마토:ff6347*/
	height: 100%;
}

#main {
	min-height: 80%;
	position: relative;
}

/* .left {
	width: 10%;
	height: 600px;
	background: white;
	border-style: hidden;
	box-shadow:1px 0px 0px 0px black;
	position: absolute;
	top: 1px;
	left: 1px;
} */

.content {
	width: 100%;
	height: 100%;
	background: white;
	/* padding-left: 20px; */
	/* position: absolute; */
	/* top: 1px; */
	/* left: 11%; */
	/* overflow: scroll;
	overflow-x: hidden; */
}

.choice1_block {
	width: 25%;
	height: 50%;
	text-align: center;
	display: inline-block;
	/* background: lightgray; */
	margin-left: 30px;
	margin-right: 30px;
	margin-top: 10px;
	/*  position:relative; */
	border-radius: 3px;
	border: 1px solid lightgray;
}

.choice1_block>img {
	width: 100%;
	height: 100%;
}
.choice1_block:hover{
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}

.choice1 {
	width: 95%;
	height: 93%;
	margin-top: 20px;
	border-style: hidden;
	/* box-shadow: 0px 1px 0px 0px gray; */

	/* position:absolute; */
}
.choice2_block>img {
	width: 100%;
	height: 100%;
}
.choice2_block:hover{
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
.choice2_block {
	width: 25%;
	height: 60%;
	text-align: center;
	display: inline-block;
	margin-left: 30px;
	margin-right: 30px;
	margin-top: 10px;
	border-radius: 3px;
	border: 1px solid lightgray;
}

.choice2 {
	width: 95%;
	height: 93%;
	margin-top: 20px;
	border-style: hidden;
	/* box-shadow: 0px 1px 0px 0px gray; */
	display: none;
}
.choice3_block>img {
	width: 100%;
	height: 100%;
}
.choice3_block:hover{
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
.choice3_block {
	width: 25%;
	height: 60%;
	text-align: center;
	display: inline-block;
	margin-left: 30px;
	margin-right: 30px;
	margin-top: 10px;
	border-radius: 3px;
	border: 1px solid lightgray;
}

.choice3 {
	width: 95%;
	height: 93%;
	margin-top: 20px;
	border-style: hidden;
	/* box-shadow: 0px 1px 0px 0px gray; */
	display: none;
}
.choice4_block>img {
	width: 100%;
	height: 100%;
}
.choice4_block:hover{
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
.choice4_block {
	width: 25%;
	height: 60%;
	text-align: center;
	display: inline-block;
	margin-left: 30px;
	margin-right: 30px;
	margin-top: 10px;
	border-radius: 3px;
	border: 1px solid lightgray;
}

.next_block {
	display: inline-block;
}

.choice4 {
	width: 95%;
	height: 93%;
	margin-top: 20px;
	border-style: hidden;
	/* box-shadow: 0px 1px 0px 0px gray; */
	display: none;
}

.next {
	background: lightgray;
	margin-top: 110px;
	width: 110px;
	height: 50px;
}

.next > a {
	border-radius: 5px;
}

.next > img{
	width:100%;
	height:100%;
}

.next > a > img{
	width:100%;
	height:100%;
}

#n {
	text-decoration: none;
}

#n:hover {
	color: white;
	text-decoration: none;
}
 @media ( max-width: 1023px ) {
 		.content{
    		float: none;
       		width: auto;
       		height:auto;
        }
		.choice1{
 	 		float: none;
       		width: 50%;
       		height:1500px;
       		display:block;
        }
        
        .choice1_block{
 	 		float: none;
       		width: auto;
       		height:400px;
       		display:block;
        }
        .choice1_block > img{
			float: none; 		
		}
		
		.choice2{
 	 		float: none;
       		width: 50%;
       		height:1500px;
       		display:none;
        }
        
        .choice2_block{
 	 		float: none;
       		width: auto;
       		height:400px;
       		display:block;
        }
        .choice2_block > img{
			float: none; 		
		}
		
		.choice3{
 	 		float: none;
       		width: 50%;
       		height:1500px;
       		display:none;
        }
        
        .choice3_block{
 	 		float: none;
       		width: auto;
       		height:400px;
       		display:block;
        }
        .choice3_block > img{
			float: none; 		
		}
		
		.choice4{
 	 		float: none;
       		width: 50%;
       		height:1500px;
       		display:none;
        }
        
        .choice4_block{
 	 		float: none;
       		width: auto;
       		height:400px;
       		display:block;
        }
        .choice4_block > img{
			float: none; 		
		}
	}
	@media ( max-width: 767px ) {
		.choice1{
       		width: 80%;

        }
		.choice1_block{
       		width:auto;
        }
		.choice2{
       		width: 80%;

        }
		.choice2_block{
       		width:auto;
        }
        .choice3{
       		width: 80%;

        }
		.choice3_block{
       		width:auto;
        }
        .choice4{
       		width: 80%;

        }
		.choice4_block{
       		width:auto;
        }
	} 
	.mb{
		width:100%;
		height:400px;
		background-image:url("/msmg/images/common/menu2.png");
	}

</style>
</head>
<body>
	<div class = "mb hidden-xs">
		<%@ include file="../common/menubar.jsp" %>
		
	</div>
	<div id="main">
		<div class="content block1" align = "center">
			<div class="choice1" id="next1" align="center">
				<div class="choice1_block" id="d">
					<img src="/msmg/images/foodPlan/go.PNG">
				</div>
				<div class="choice1_block" id="g">
					<img src="/msmg/images/foodPlan/dang.PNG">
				</div>
				<div class="choice1_block" id="h">
					<img src="/msmg/images/foodPlan/head.PNG">
				</div>
				<br>
				<div class="next next_block" id="n1" onclick="showDiv(this);">
					<img src = "/msmg/images/button/nextbutton.png">
				</div>
			</div>
			<div class="choice2" id="next2" align="center">
				<div class="choice2_block" id = "t_d">
					<img src="/msmg/images/foodPlan/three_day.PNG">
				</div>
				<div class="choice2_block" id = "s_d">
					<img src="/msmg/images/foodPlan/seven_day.PNG">
				</div>
				<br>
				<div class="next next_block" id="re2" onclick="showDiv(this);">
					<img src = "/msmg/images/button/prevbutton.png">
				</div>
				<div class="next next_block" id="n2" onclick="showDiv(this);">
					<img src = "/msmg/images/button/nextbutton.png">
				</div>
			</div>
			<div class="choice3" id="next3" align="center">
				<div class="choice3_block" id = "o_g">
					<img src="/msmg/images/foodPlan/one_ggi.PNG">
				</div>
				<div class="choice3_block" id = "t_g">
					<img src="/msmg/images/foodPlan/two_ggi.PNG">
				</div>
				<div class="choice3_block" id = "th_g">
					<img src="/msmg/images/foodPlan/three_ggi.PNG">
				</div>
				<br>
				<div class="next next_block" id="re3" onclick="showDiv(this);">
					<img src = "/msmg/images/button/prevbutton.png">
				</div>
				<div class="next next_block" id="n3" onclick="showDiv(this);">
					<img src = "/msmg/images/button/nextbutton.png">
				</div>
			</div>
			<div class="choice4" id="next4" align="center">
				<div class="choice4_block" id = "u">
					<img src="/msmg/images/foodPlan/under.PNG">
				</div>
				<div class="choice4_block" id = "u_l">
					<img src="/msmg/images/foodPlan/under_less.PNG">
				</div>
				<br>
				
				<div class="next next_block" id="n4" onclick="showDiv(this);">
					<img src = "/msmg/images/button/cheoumbutton.png">
				</div>
				<div class="next next_block" id="re4" onclick="showDiv(this);">
					<img src = "/msmg/images/button/prevbutton.png">
				</div>
				<div class="next next_block" id = "nc" onclick="showDiv(this);">
					<!-- <a href="last_plan.jsp" id="n">
						<img src = "/msmg/images/button/nextbutton.png">
					</a> -->
					<img src = "/msmg/images/button/nextbutton.png">
				</div>
			</div>
		</div>
	</div>
	<br><br>
	<div id="mainBottom">
		<%@ include file="../common/footer.jsp" %>
	</div>
	<script>
		var i = 0;
		var j = 0;
		var k = 0;
		var a = 0;
		var b = 0;
		var c = 0;
		var d = 0;
		var e = 0;
		var f = 0;
		var g = 0;
	
		$(function() {
			$("#d").click(function() {
				if(i==1){
					$("#d > img").attr("src", "/msmg/images/foodPlan/go.PNG");
					i=0;
				}
				else{
					$("#d > img").attr("src", "/msmg/images/foodPlan/go_check.PNG");
					i=1;
					
				}
			});
			$("#g").click(function() {
				if(j==1){
					$("#g > img").attr("src", "/msmg/images/foodPlan/dang.PNG");
					j=0;
				}
				else{
					$("#g > img").attr("src", "/msmg/images/foodPlan/dang_check.PNG");
					j=1;
					
				}
			});
			$("#h").click(function() {
				if(k==1){
					$("#h > img").attr("src", "/msmg/images/foodPlan/head.PNG");
					k=0;
				}
				else{
					$("#h > img").attr("src", "/msmg/images/foodPlan/head_check.PNG");
					k=1;
					
				}
			});
			
			
			
			$("#t_d").click(function() {
				if(a==3){
					$("#t_d > img").attr("src", "/msmg/images/foodPlan/three_day.PNG");
					a=0;
				}
				else{
					$("#t_d > img").attr("src", "/msmg/images/foodPlan/three_day_check.PNG");
					a=3;
					$("#s_d > img").attr("src", "/msmg/images/foodPlan/seven_day.PNG");
					b=0;
				}
			});
			
			$("#s_d").click(function() {
				if(b==7){
					$("#s_d > img").attr("src", "/msmg/images/foodPlan/seven_day.PNG");
					b=0;
				}
				else{
					$("#s_d > img").attr("src", "/msmg/images/foodPlan/seven_day_check.PNG");
					b=7;
					$("#t_d > img").attr("src", "/msmg/images/foodPlan/three_day.PNG");
					a=0;
					
				}
			});
			
			$("#o_g").click(function() {
				if(c==1){
					$("#o_g > img").attr("src", "/msmg/images/foodPlan/one_ggi.PNG");
					c=0;
				}
				else{
					$("#o_g > img").attr("src", "/msmg/images/foodPlan/one_ggi_check.PNG");
					c=1;
					$("#t_g > img").attr("src", "/msmg/images/foodPlan/two_ggi.PNG");
					d=0;
					$("#th_g > img").attr("src", "/msmg/images/foodPlan/three_ggi.PNG");
					e=0;
				}
			});
			
			$("#t_g").click(function() {
				if(d==2){
					$("#t_g > img").attr("src", "/msmg/images/foodPlan/two_ggi.PNG");
					d=0;
				}
				else{
					$("#t_g > img").attr("src", "/msmg/images/foodPlan/two_ggi_check.PNG");
					d=2;
					$("#o_g > img").attr("src", "/msmg/images/foodPlan/one_ggi.PNG");
					c=0;
					$("#th_g > img").attr("src", "/msmg/images/foodPlan/three_ggi.PNG");
					e=0;
				}
			});
			
			$("#th_g").click(function() {
				if(e==3){
					$("#th_g > img").attr("src", "/msmg/images/foodPlan/three_ggi.PNG");
					e=0;
				}
				else{
					$("#th_g > img").attr("src", "/msmg/images/foodPlan/three_ggi_check.PNG");
					e=3;
					$("#t_g > img").attr("src", "/msmg/images/foodPlan/two_ggi.PNG");
					d=0;
					$("#o_g > img").attr("src", "/msmg/images/foodPlan/one_ggi.PNG");
					c=0;
				}
			});
			
			$("#u").click(function() {
				if(f==1){
					$("#u > img").attr("src", "/msmg/images/foodPlan/under.PNG");
					f=0;
				}
				else{
					$("#u > img").attr("src", "/msmg/images/foodPlan/under_check.PNG");
					f=1;
					$("#u_l > img").attr("src", "/msmg/images/foodPlan/under_less.PNG");
					g=0;
				}
			});
			
			$("#u_l").click(function() {
				if(g==1){
					$("#u_l > img").attr("src", "/msmg/images/foodPlan/under_less.PNG");
					g=0;
				}
				else{
					$("#u_l > img").attr("src", "/msmg/images/foodPlan/under_less_check.PNG");
					g=1;
					$("#u > img").attr("src", "/msmg/images/foodPlan/under.PNG");
					f=0;
				}
			});
			
			$("#n4").click(function(){
				a = 0;
				b = 0;
				c = 0;
				d = 0;
				e = 0;
				f = 0;
				g = 0;
				i = 0;
				j = 0;
				k = 0;
				
				$("#d > img").attr("src", "/msmg/images/foodPlan/go.PNG");
				$("#g > img").attr("src", "/msmg/images/foodPlan/dang.PNG");
				$("#h > img").attr("src", "/msmg/images/foodPlan/head.PNG");
				$("#t_d > img").attr("src", "/msmg/images/foodPlan/three_day.PNG");
				$("#s_d > img").attr("src", "/msmg/images/foodPlan/seven_day.PNG");
				$("#o_g > img").attr("src", "/msmg/images/foodPlan/one_ggi.PNG");
				$("#t_g > img").attr("src", "/msmg/images/foodPlan/two_ggi.PNG");
				$("#th_g > img").attr("src", "/msmg/images/foodPlan/three_ggi.PNG");
				$("#u > img").attr("src", "/msmg/images/foodPlan/under.PNG");
				$("#u_l > img").attr("src", "/msmg/images/foodPlan/under_less.PNG");
			}); 
			
				
			
		});

		function showDiv(element) {

			var e1 = document.getElementById("n1");
			var e2 = document.getElementById("n2");
			var e3 = document.getElementById("n3");
			//var e4 = document.getElementById("n4");
			var e5 = document.getElementById("next1");
			var e6 = document.getElementById("next2");
			var e7 = document.getElementById("next3");
			var e8 = document.getElementById("next4");
			var e9 = document.getElementById("re2");
			var e10 = document.getElementById("re3");
			var e11 = document.getElementById("re4");
			var e12 = document.getElementById("nc");

			if (element == e1) {
				if(i == 0 && j == 0 && k == 0){
					alert("질병을 선택하세요.");
				}else{
					e5.style.display = "none";
					e6.style.display = "block";
					e7.style.display = "none";
					e8.style.display = "none";
				}
			} else if (element == e2) {
				if(a == 0 && b == 0){
					alert("일수를 선택하세요.");
				}else{
					e5.style.display = "none";
					e6.style.display = "none";
					e7.style.display = "block";
					e8.style.display = "none";
				}	
			} else if (element == e3) {
				if(c == 0 && d == 0 && e == 0){
					alert("끼니를 선택하세요.");
				}else{
					e5.style.display = "none";
					e6.style.display = "none";
					e7.style.display = "none";
					e8.style.display = "block";
				}
			} else if (element == e9) {
				e5.style.display = "block";
				e6.style.display = "none";
				e7.style.display = "none";
				e8.style.display = "none";
			} else if (element == e10) {
				e5.style.display = "none";
				e6.style.display = "block";
				e7.style.display = "none";
				e8.style.display = "none";
			} else if (element == e11) {
				e5.style.display = "none";
				e6.style.display = "none";
				e7.style.display = "block";
				e8.style.display = "none";
			} else if (element == e12) {
				if(f == 0 && g == 0){
					alert("반찬 유무를 선택하세요.");
				}else{
					location.href = "<%= request.getContextPath()%>/selectFoodList.fo?go=" + i + "&dang=" + j + "&head=" + k + "&three_day=" + a + "&seven_day=" + b + "&one_ggi=" + c + "&two_ggi=" + d + "&three_ggi=" + e + "&side=" + f;	
				}
			} 
			
			else{
				a, b, c, d, e, f, g, i, j, k = 0;
				
				e5.style.display = "block";
				e6.style.display = "none";
				e7.style.display = "none";
				e8.style.display = "none";
			}
		}
	</script>
	
</body>
</html>