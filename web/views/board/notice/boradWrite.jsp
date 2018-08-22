<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "java.util.*"%>
<%
	int bno = (int)request.getAttribute("bno");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>글쓰기</title>
	
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic"
	rel="stylesheet">
	
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
 <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- <link href="/msmg/resource/summernote-master/dist/summernote.css" rel="stylesheet">
<script src="/msmg/resource/summernote-master/dist/summernote.min.js"></script>  -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
<script src = "/msmg/resource/summernote-master/lang/summernote-ko-KR.js"></script>

<style>
#wrap {
	width : 1000px;
	height: 1300px;
	margin-left : auto;
	margin-right : auto;
}
#container {
	margin-left: 0 auto; margin-right : 0 auto;
	margin-right: 0 auto;
}

table {
	font-family: 'Nanum Gothic', sans-serif;
}

#test{
width : 1000px;
}

#jjff {
	height:400px;
	background-image:url("/msmg/images/common/notice.png");
	margin-bottom:15px;
}

#tdbg {
	background : #e83f26;
	color : white;
}

#mainBottom{
		width:100%;
		height:200px;
}

#dobtn {
background : tomato;
border : 1px solid tomato;
}

.output {
width : 800px;
margin-left : auto;
margin-right : auto;
}


</style>
<script type="text/javascript">
		var cnt = 0;
        /* summernote에서 이미지 업로드시 실행할 함수 */
        function sendFile(file, editor) {
            // 파일 전송을 위한 폼생성
          data = new FormData();
           data.append("uploadFile", file);
           $.ajax({ // ajax를 통해 파일 업로드 처리
               data : data,
               type : "POST",
               url : "<%= request.getContextPath() %>/imgUpload.bo?bno=<%=bno%>",
               enctype: 'multipart/form-data',
               cache : false,
               contentType : false,
               processData : false,
               success : function(data) { // 처리가 성공할 경우
                    // 에디터에 이미지 출력
                  $(editor).summernote('editor.insertImage', data.url);
               },
               error:function(request,status,error){
                  alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                
               
               }

           });   
       }
       
       
       function deleteFile(src) {

    	    $.ajax({
    	        data: {src : src},
    	        type: "POST",
    	        url: "<%= request.getContextPath() %>/imgDelete.bo", // replace with your url
    	        cache: false,
    	        success: function(resp) {
    	            console.log(resp);
    	        }
    	    });
    	    
    	}
       
       function addbtn(){
    	   
    	   if(cnt == 0){
    	   $("#attachfile2").show();
    	   cnt++;
    	   }else if(cnt == 1){
    		   $("#attachfile3").show();
    	   }
       };
       
       function delbtn(){
    	   console.log(cnt);
    	   if(cnt == 1){
    		   $("#attachfile3").val("");
    		   $("#attachfile3").hide();
    		   cnt--;
    	   }else if(cnt == 0){
    		   $("#attachfile2").val("");
    		   $("#attachfile2").hide();
    	   }
       }
       
       function loadImg(value){
				if(value.files && value.files[0]){
					var reader = new FileReader();
					reader.readAsDataURL(value.files[0]);
				}
			}
       
       function submitBoard(){
    	   var values = $("#summernote").summernote('code');
    	   alert(values);
    	   $("#smnoteval").val(values);
    	   alert($("#smnoteval").val());
    	   if($("#attachfile1").val() == ""){
    		   $("#attachfile1").remove();
    	   }
    	   if($("#attachfile2").val() == ""){
    		   $("#attachfile2").remove();
    	   }
    	   if($("#attachfile3").val() == ""){
    		   $("#attachfile3").remove();
    	   }
    	   
    	   
    	   
    	   $("#frm").attr("action", '<%=request.getContextPath()%>/updateBoard.bo?bno=<%= bno %>');
       }
   </script>




</head>
<body>

<!-- 게시판 쓰기 -->
	<div id = "jjff">
<%@ include file = "../../common/menubar.jsp" %>
	
	</div>
<%if(loginUser != null && loginUser.getU_name().equals("관리자")){ %>
	<div id='wrap' align = 'left'>
	
		<!-- 구분 -->
		<!-- 게시판 헤더 시작 -->
		<!-- <table align='center' cellpadding="0" cellspacing="0" border="0">
			<tr
				style="background: url('../image/table_mid.gif'); /* #E8E8E8 */ background-repeat: repeat-x;">
				<td width="5"><img src="../image/table_left.gif" width="7"
					height="30" /></td>
				<td width="1030" align='center'><span>글쓰기</span></td>
				<td width="5"><img src="../image/table_right.gif" width="7"
					height="30" /></td>
			</tr>
		</table> -->
		<!-- 게시판 헤더 끝 -->
		<br>
		<%java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
		<!-- 게시글 작성 시작 -->
		<div id="container">
			<form id = 'frm' method = 'post' encType = "multipart/form-data">
				<table align='center' cellpadding="0" cellspacing="0" border="0"
					id='memo'>
					<tr class='title'>
						<td width="30" align = 'center' id = 'tdbg'>제목</td>
						<td width="300"><input type='text' class='form-control'
							name="title" width="300"></td>
						<td  width = '50' align = 'center' id = 'tdbg'>작성일</td>
						<td width = "100" align = 'center'><%= df.format(new Date()) %></td>
					</tr>
					<tr height="10">
						<td colspan='2' width="700"></td>
					</tr>
					<tr class='title'>
						<td width = '700' colspan = '4'>
							<div id = 'summernote'></div>
							<input type = 'hidden' id = 'smnoteval' class = 'smnoteval' name = 'smnoteval'>
						</td>
						
					</tr>
					<tr height="10">
						<td colspan='2' width="700"></td>
					</tr>
				</table>
				<div class="output">
				<fieldset >
					<legend>첨부파일 </legend>
						<div style = "padding : 5px;">
							<input type = 'file' id = 'attachfile1' name = 'attachfile1' multiple onchange = "loadImg(this)">
							<input type = 'file' id = 'attachfile2' name = 'attachfile2' style = "padding-top : 5px; padding-bottom : 5px;" multiple onchange = "loadImg(this)">
							<input type = 'file' id = 'attachfile3' name = 'attachfile3' multiple onchange = "loadImg(this)">
						</div>
						<br>
						<input type = 'button' value = "추가" onclick = 'addbtn()'>&nbsp;<input type = 'button' value = "삭제" onclick = "delbtn()">
				</fieldset>
			</div>
			<br><br>
				<div align='center'>
				<button type="reset" class="btn btn-primary btn-sm" id = 'dobtn' onclick = 'history.go(-1)'>이전으로</button>
				<button class="btn btn-primary btn-sm" id = 'dobtn' onclick = "submitBoard()">작성하기</button>
				</div>
			</form>
			<div class="output"></div>
		</div>
		
		
 <script>
 		
 	
 $(document).ready(function() {
	  	 $("#attachfile2").hide();
	     $("#attachfile3").hide();
	     
	  	 var fileExtension = ['.jpg', '.png', '.jpeg', '.gif',];
    $('#summernote').summernote({ // summernote를 사용하기 위한 선언
        height: 400,
        lang: 'ko-KR',
        toolbar: [
            // [groupName, [list of button]]
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['font', ['strikethrough', 'superscript', 'subscript']],
            ['fontsize', ['fontname', 'fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            ['insert', ['picture', 'link', 'video', 'table', 'hr']]
          ],
    callbacks: { // 콜백을 사용
            // 이미지를 업로드할 경우 이벤트를 발생
       onImageUpload: function(files, editor, welEditable) {
           console.log(files);
             
             for (var i = files.length - 1; i >= 0; i--) {
            	 
             	for(var j = 0; j < fileExtension.length; j++){
             		var extleng = files[i].name.length;
             		var extdot = files[i].name.lastIndexOf('.');
             		var ext = files[i].name.substring(extdot, extleng).toLowerCase();

            		 console.log(ext + ' / ' + fileExtension[j]) 
            	 if(ext == fileExtension[j]){
         		  sendFile(files[i], this); 
             	}
                }
             }
      },
      
      onMediaDelete : function(target) {
          alert(target[0].src);
          deleteFile(target[0].src);
          console.log(target[0].src)
   }
    
    
}});
}); 


      </script>


		<!-- 게시글 작성 끝 -->


	</div>
	<div id="mainBottom">
	<%@include file = "../../common/footer.jsp" %>
	</div>
	
	<%}else{ 
		request.setAttribute("msg", "잘못된 경로");
		request.getRequestDispatcher("../../common/errorPage.jsp").forward(request, response);
	}%>
</body>
</html>