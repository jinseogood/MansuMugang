<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic"
	rel="stylesheet">
	
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
 <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"> var jb = jQuery.noConflict();</script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<link href="../resource/summernote-master/dist/summernote.css" rel="stylesheet">
<script src="../resource/summernote-master/dist/summernote.min.js"></script> 

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
width : 700px;
}

#jjff {
	height : 300px;
}

#tdbg {
	background : #e83f26;
	color : white;
}

#mainBottom{
		width:100%;
		height:200px;
}

</style>
<script type="text/javascript">
        /* summernote에서 이미지 업로드시 실행할 함수 */
        function sendFile(file, editor) {
            // 파일 전송을 위한 폼생성
          data = new FormData();
           data.append("uploadFile", file);
           $.ajax({ // ajax를 통해 파일 업로드 처리
               data : data,
               type : "POST",
               url : "<%= request.getContextPath() %>/test1",
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
    	        url: "/tt1/img", // replace with your url
    	        cache: false,
    	        success: function(resp) {
    	            console.log(resp);
    	        }
    	    });
    	    
    	}
   </script>




</head>
<body>
<!-- 게시판 쓰기 -->
	<div id = "jjff">
	<%@ include file = "NewFile.jsp" %>
	
	</div>
	<div id='wrap' align = 'left'>
		<!-- 구분 -->
		<h1 >글쓰기</h1>
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
		<!-- 게시글 작성 시작 -->
		<div id="container">
			<form id = 'frm'>
				<table align='center' cellpadding="0" cellspacing="0" border="0"
					id='memo'>
					<tr class='title'>
						<td width="30" align = 'center' id = 'tdbg'>제목</td>
						<td width="300"><input type='text' class='form-control'
							name="btitle" width="300"></td>
						<td  width = '50' align = 'center' id = 'tdbg'>작성일</td>
						<td width = "100" align = 'center'>dscxx</td>
					</tr>
					<tr height="10">
						<td colspan='2' width="700"></td>
					</tr>
					<tr class='title'>
						<td width = '700' colspan = '4'>
							<div id = 'summernote'></div>
						</td>
						
					</tr>
					<tr height="10">
						<td colspan='2' width="700"></td>
					</tr>
				</table>
				<div align='center'>
				<button type="reset" class="btn btn-primary btn-sm" onclick = 'history.go(-1)'>이전으로</button>
				<button id = 'savebutton' class="btn btn-primary btn-sm" onclick = 'showContent()'>작성하기</button>
				</div>
			</form>
			<div class="output"></div>
		</div>
		
		
 <script>
 		
 	
             $(document).ready(function() {
                $('#summernote').summernote({ // summernote를 사용하기 위한 선언
                    height: 400,
                callbacks: { // 콜백을 사용
                        // 이미지를 업로드할 경우 이벤트를 발생
                   onImageUpload: function(files, editor, welEditable) {
                       console.log(files);
                         
                        /*  var opt = {};
                         for (var i = files.length - 1; i >= 0; i--) {
                          files[i]; //해당파일들을 ajax로 한번씩 FormData로담아서 보내거나 다양하게 처리하시믄됩니다.                 
                         } */
                         
                         for (var i = files.length - 1; i >= 0; i--) {
                       sendFile(files[i], this); 
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
</body>
</html>