<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE>
<html>  
<head>
<meta charset="UTF-8">
<title>정보게시판 수정</title>
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
           $.ajax({ // ajax를 통해 파일 업로드 처리
               data : data,
               type : "POST",
               url : "./summernote_imageUpload.jsp",
               cache : false,
               contentType : false,
               processData : false,
               success : function(data) { // 처리가 성공할 경우
                    // 에디터에 이미지 출력
                   console.log("11");
                  $(editor).summernote('editor.insertImage', data.url);
               },
               error:function(request,status,error){
                  alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                
               
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
	background: #e83f26;
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

#mainBottom{
		width:100%;
		height:200px;
}

</style>
</head>
<body>
<div id="back">
	<%@ include file="../../common/menubar.jsp"%>
</div>
	<div class="outer">
		<!-- <h2>게시글 글 수정</h2> -->
		<%-- <%java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm"); %> --%>
		<br>
		<div id="view">
			<table id="tableView">
				<tr id="tableView2">
					<td class="titleN" id="title">제목</td>
					<td><input type="text"
						style="background-color: transparent; border: 0 solid black; text-align: left; width: 350px;"></td>
					<td class="titleN" id="date">작성일</td>
					<td><input type="text"
						style="background-color: transparent; border: 0 solid black; text-align: left; width: 250px;"></td>
				</tr>
			</table>
			
			<br>
			<div>
				<form name="writeForm" action="./summernote_insert.jsp" method="post">
      			<textarea id="summernote">
      			
      			</textarea></form>
        <script>
             $(document).ready(function() {
                $('#summernote').summernote({ // summernote를 사용하기 위한 선언
                    height: 400,
                callbacks: { // 콜백을 사용
                        // 이미지를 업로드할 경우 이벤트를 발생
                   onImageUpload: function(files, editor, welEditable) {
                       console.log(files);
                         console.log(editor);
                         console.log(welEditable);
                         
                        /*  var opt = {};
                         for (var i = files.length - 1; i >= 0; i--) {
                          files[i]; //해당파일들을 ajax로 한번씩 FormData로담아서 보내거나 다양하게 처리하시믄됩니다.                 
                         } */
                       sendFile(files[0], this); 
                  }
               } 
            });
         }); 
      </script>

		</div>
		<hr>
		<br>
		<div id="writeBtn">
			<button type="button" class="btn btn-primary" value="취소" OnClick="window.location='informationBoard.jsp'">취소</button>
			&nbsp;
			<button type="button" class="btn btn-primary" value="수정 완료" OnClick="window.location='information_modify_ok.jsp'">수정 완료</button>
		</div>
		
	</div>
</div>
<div id="mainBottom">
<%@include file = "../../common/footer.jsp" %>
</div>
</body>
</html>