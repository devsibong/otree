<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>글 생성</title>
	<script src="https://cdn.ckeditor.com/4.16.0/standard/ckeditor.js"></script>
	<SCRIPT type="text/javascript">
	
function check(){
    if(!bbs.subject.value){
        alert("제목을 입력하세요");
        bbs.subject.focus();
        return false;
    }
    if(!bbs.writer.value){
        alert("이름을 입력하세요");
        bbs.writer.focus();
        return false;
    }
     if(!bbs.content.value){            
        alert("글 내용을 입력하세요");
        bbs.content.focus();
        return false;
    } 
    document.bbs.submit();
 
}
</SCRIPT>
</head>
<body>

    <div id="pageContainer">
        <div style="padding-top: 25px; text-align: center">
            <!-- form 시작 ---------->
            <form name="bbs" action="${pageContext.request.contextPath}/BoardWriteOK.do" method="POST">
                <table width="95%" border="2" align="center">
                    <tr>
                        <td width="20%" align="center">제목</td>
                        <td width="80%" align="left"><input type="text"    name="subject" size="40"></td>
                    </tr>
                 
                   
                    <tr>
                        <td width="20%" align="center">글내용</td>
                        <td width="80%" align="left"><textarea rows="10" cols="60" name="content" class="ckeditor"></textarea></td>
                    </tr>
              
                    <tr>
                        <td width="20%" align="center">첨부파일</td>
                        <td width="80%" align="left"><input type="file" name="filename"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="button" value="글쓰기" onclick="check();" /> 
                            <input type="reset"  value="다시쓰기" />
                        </td>
                    </tr>
                </table>
              </form>
            
        </div>
    </div>
</body>
</html>