<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.msmg.member.model.vo.*"%>
<% int num = (int)request.getAttribute("random");

   Member loginUser2=(Member)session.getAttribute("loginUser");
%>


<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">  
<title>정보게시판 작성</title>
<title></title>  
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<script type="text/javascript">
        /* summernote에서 이미지 업로드시 실행할 함수 */
        function sendFile(file, editor) {
            // 파일 전송을 위한 폼생성
          data = new FormData();
           data.append("uploadFile", file);
           
           console.log(data);
           $.ajax({ // ajax를 통해 파일 업로드 처리
               data : data,
               type : "POST",
               url : "<%= request.getContextPath() %>/selectBoardImg?bno=<%=num%>&num=<%=loginUser2.getU_code()%>",
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
    	        url: "<%= request.getContextPath() %>/deleteImg.bo", // replace with your url
    	        cache: false,
    	        success: function(data) {
    	            console.log(data);
    	            alert('삭제완료');
    	        }
    	    });
    	    
    	}
   </script>

<style>
/* body {
	background: pink;
} */

#back {
	width:100%;
	height:400px;
	/* background:#ffa500; */
	background-image:url("/msmg/images/common/information.png");
	margin-bottom:20px;
}

.outer {
	width: 800px;
	height: 1300px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

.titleN {
	background: #ff6347;
	color: white;
	width: 100px;
	height: 40px;
	text-align: center;
}

#memo {
	width: 800px;
	height: 500px;
	border: 0;
}

.btn {
	float: right;
	margin-left: 10px;
}

hr {
	border-color: #f77a68;
}

#tableView {
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

#view2 {
	float: left;
}

.p1 {
	float: left;
	margin-right: 20px;
}

#view3 {
	float: right;
}

.p2 {
	float: left;
	margin-left: 20px;
}

#fas {
	 background-color: rgba( 255, 255, 255, 0 );
}

#search {
	margin-top:10px;
}

#mainBottom{
		width:100%;
		height:200px;
}

#writeBtn .btn {
	background:#ff6347;
	border:none;
}

#date2 {
	background-color: transparent;
	border: 0 solid black;
	text-align:center;
	width: 250px;
}

</style>

</head>
<body>
<div id="back">
	<%@ include file="../../common/menubar.jsp"%>
</div>
	<div class="outer">
		<!-- <h2 align="left"><b>정보게시판</b></h2> -->
		<%java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd"); %>
		<br>
		<form name="writeform"action="<%=request.getContextPath() %>/insert.bo" method="post">
		
		<div id="view">
			<table id="tableView">
				<tr id="tableView2">
					<td class="titleN" id="title">제목</td>
					<td><input type="text" name="title"
						style="background-color: transparent; border: 0 solid black; text-align: left; width: 350px;"></td>
					<td class="titleN" id="date" name="date">작성일</td>
					<td id="date2"><%= df.format(new Date()) %></td>
					<td><input type="hidden" value="<%=loginUser.getU_name()%>"></td>
					<td><input type="hidden" name="num" value="<%=num %>"></td>
				</tr>
			</table>
			 
			<br>
			<div>
				<form name="writeForm" action="./summernote_insert.jsp" method="post">
      			<textarea id="summernote" name="content"></textarea></form>
       			<script>
 		
 	
             $(document).ready(function() {
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
		</div>
		<hr>
		<br>
		<div id="writeBtn">
			<button  type="reset" class="btn btn-primary" value="취소" onclick = 'location.href="/selectList.bo"'>취소</button>
			&nbsp;
			<input type="button" class="btn btn-primary" value="등록 완료" OnClick="javascript:writeCheck();">
		</div>
	</form>
	<script language = "javascript">
		function writeCheck(){
			var form = document.writeform;
			
			if(!form.title.value){
				alert("제목을 입력하세요.");
				form.title.focus();
				return;
			}
			if(!form.content.value){
				alert("내용을 입력하세요.")
				form.content.focus();
				return;
			}
			
			form.submit();
		}
		</script>
	</div>
</div>

<div id="mainBottom">
<%@include file = "../../common/footer.jsp" %>
</div>
</body>
</html>