<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "java.util.*, com.msmg.member.model.vo.*"%>
<%
	int bno = (int)request.getAttribute("bno");
	Member loginUser=(Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>공지사항 :: 공지사항 작성 - 관리자</title>
<!-- 폰트 -->
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">

<!-- 썸머노트 에디터 관련 css / js -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- 썸머노트 에디터 관련 CDN / 언어 -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
<script src = "/msmg/resource/summernote-master/lang/summernote-ko-KR.js"></script>

<style>
#wrap {
	width : 1000px;
	height: 800px;
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
                url : "<%= request.getContextPath() %>/imgUpload.no?bno=<%=bno%>&num=<%=loginUser.getU_code() %>",
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
       
       /* 썸머노트 내 이미지 삭제 시 실행할 함수 */
       function deleteFile(src) {

    	    $.ajax({
    	        data: {src : src},
    	        type: "POST",
    	        url: "<%= request.getContextPath() %>/imgDelete.no",
    	        cache: false,
    	        success: function(resp) {
    	            console.log(resp);
    	        }
    	    });
    	}
       
       // 첨부파일 input 태그 추가 함수
       function addbtn(){
    	   
    	   if(cnt == 0){
    	  		$("#attachfile2").show();
    	 		cnt++;
    	   }else if(cnt == 1){
    			$("#attachfile3").show();
    	   }
       };
       
       //첨부파일 input 태그 삭제 함수
       function delbtn(){
    	   
    	   if(cnt == 1){
    		   $("#attachfile3").val("");
    		   $("#attachfile3").hide();
    		   cnt--;
    	   }else if(cnt == 0){
    		   $("#attachfile2").val("");
    		   $("#attachfile2").hide();
    	   }
       }
       
       //글 작성 완료시 수행 함수
       function submitBoard(){
    	   var values = $("#summernote").summernote('code');
    	   $("#smnoteval").val(values);
    	   
    	   //첨부파일에 파일이 없을 때 파일 input 태그 삭제
    	   if($("#attachfile1").val() == ""){
    		   $("#attachfile1").remove();
    	   }
    	   if($("#attachfile2").val() == ""){
    		   $("#attachfile2").remove();
    	   }
    	   if($("#attachfile3").val() == ""){
    		   $("#attachfile3").remove();
    	   }
    	   
    	   //유효성 검사
    	   if($("[name=title]").val() == ""){
    		   alert("제목을 작성하세요");
    		   $("[name=title]").focus();
    		   return false;
    	   }
    	   
    	   if(values == "<p><br></p>" || values == ""){
    		   alert("내용을 작성하세요");
    		   $('#summernote').summernote('focus');
    		   return false;
    	   }
    	   
    	   alert("작성완료");
   	   	   $("#frm").attr("action", '<%=request.getContextPath()%>/updateNotice.no?bno=<%= bno %>&num=<%=loginUser.getU_code() %>');
   	   		$("#frm").submit();
       }
   </script>




</head>
<body>

<!-- 게시판 쓰기 -->
<%if(loginUser != null && loginUser.getU_name().equals("관리자")){ %>
	<div id='wrap' align = 'left'>
		<br>
		<%java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
		<!-- 게시글 작성 시작 -->
		<div id="container">
			<form id = 'frm' method = 'post' encType = "multipart/form-data">
				<table align='center' cellpadding="0" cellspacing="0" border="0" id='memo'>
					<tr class='title'>
						<td width="30" align = 'center' id = 'tdbg'>제목</td>
						<td width="300"><input type='text' class='form-control' name="title" width="300"></td>
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
								<input type = 'file' id = 'attachfile1' name = 'attachfile1'>
								<input type = 'file' id = 'attachfile2' name = 'attachfile2' style = "padding-top : 5px; padding-bottom : 5px;">
								<input type = 'file' id = 'attachfile3' name = 'attachfile3'>
							</div>
							<br>
							<input type = 'button' value = "추가" onclick = 'addbtn()'>&nbsp;<input type = 'button' value = "삭제" onclick = "delbtn()">
					</fieldset>
				</div>
				<br><br>
				<div align='center'>
					<button type="reset" class="btn btn-primary btn-sm" id = 'dobtn' onclick = 'history.go(-1)'>이전으로</button>
					<button type = 'button' class="btn btn-primary btn-sm" id = 'dobtn' onclick = "submitBoard()">작성하기</button>
				</div>
			</form>
		</div>
 		<script>
			 $(document).ready(function() {
	  	 		$("#attachfile2").hide();
	     		$("#attachfile3").hide();
	     		
	     		//에디터 내 들어갈 파일의 확장자 모음
	  			var fileExtension = ['.jpg', '.png', '.jpeg', '.gif',];
   				$('#summernote').summernote({ // summernote를 사용하기 위한 선언
        			height: 400,
        			lang: 'ko-KR',
        			toolbar: [
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
             				//다중 파일 처리
       						for (var i = files.length - 1; i >= 0; i--) {
             					for(var j = 0; j < fileExtension.length; j++){
             						//파일 확장자 검사
             						var extleng = files[i].name.length;
             						var extdot = files[i].name.lastIndexOf('.');
             						var ext = files[i].name.substring(extdot, extleng).toLowerCase();
									
             						//파일의 확장자 일치 시
            	 					if(ext == fileExtension[j]){
         		  						sendFile(files[i], this); 
             						}
                				}
             				}
      				},
      					//이미지 삭제시 이벤트를 발생
      					onMediaDelete : function(target) {
          					deleteFile(target[0].src);
          					console.log(target[0].src)
   						}
					}
   				});
			}); 
      </script>
		<!-- 게시글 작성 끝 -->
	</div>
	<%}else{ 
		request.setAttribute("msg", "잘못된 경로");
		request.getRequestDispatcher("../../common/errorPage.jsp").forward(request, response);
	}%>
</body>
</html>