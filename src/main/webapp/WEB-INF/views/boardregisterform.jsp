<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>글 생성</title>
    <script src="https://cdn.ckeditor.com/4.16.0/standard/ckeditor.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div id="pageContainer" class="container mt-5">
        <div style="padding-top: 25px; text-align: center">
            <!-- form 시작 ---------->
            <form name="bbs" action="" method="POST">
                <input type="hidden" value="${workspaceId}">
                <table class="table" align="center">
                    <tr>
                        <td width="20%" align="center">제목</td>
                        <td width="80%" align="left"><input id = "Title"type="text" name="boardTitle" class="form-control"></td>
                    </tr>
                    <tr>
                        <td width="20%" align="center">글내용</td>
                        <td width="80%" align="left">
                            <textarea id="textarea"rows="10" cols="60" name="boardContent" class="ckeditor form-control"></textarea>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" id="submittext" value="글쓰기" class="btn btn-primary">
                        </td>
                    </tr>
                </table>
            </form>
	                        <button onclick="window.location.href='${pageContext.request.contextPath}/workspace/${workspaceId}/createBoard'" class="btn btn-primary">다시 쓰기</button>
                             <button onclick="window.location.href='/douzone/workspace/${workspaceId}/board'" class="btn btn-secondary">글쓰기 취소</button>
           
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		
	// CKEditor로 textarea를 변환
		CKEDITOR.replace('textarea');
	  $(document).ready(function(){
		$('#submittext').click(function() {
		var titleValue = $("#Title").val();
  		var textAreaValue = CKEDITOR.instances.textarea.getData(); // editor 값변환 실험용
  		console.log(titleValue);	
  		if (titleValue.trim() === "") {
    		alert("제목은 반드시 입력하셔야 해요."); // 경고창 표시
    	return false; // 폼 제출을 중지
  				}
  		return true; // 폼 제출 진행
			});
		
	  });
	</script>

</body>
</html>
