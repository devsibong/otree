<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="updateBoardOk" method="POST">
    <label>Board ID:</label>
    <input type="text" name="boardId" value="${board.boardId}" readonly><br>
    
    <label>User ID:</label>
    <input type="text" value="${board.userId}" readonly><br>
    
    <label>Workspace ID:</label>
    <input type="text" value="${board.workspaceId}" readonly><br>
    
    <label>Board Title:</label>
    <input type="text" name="boardTitle" value="${board.boardTitle}"><br>
    
    <label>Board Content:</label>
    <input type="text" name="boardContent" value="${board.boardContent}"><br>
    
    <label>Created At:</label>
    <input type="text" value="${board.createdAt}" readonly><br>
    
    <input type="submit" value="수정하기">
</form>

</body>
</html>