<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <form action="updateBoardOk" method="POST">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Board ID:</label>
            <div class="col-sm-10">
                <input type="text" name="boardId" value="${board.boardId}" class="form-control" readonly>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">User ID:</label>
            <div class="col-sm-10">
                <input type="text" value="${board.name}" class="form-control" readonly>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Workspace ID:</label>
            <div class="col-sm-10">
                <input type="text" value="${board.workspaceId}" class="form-control" readonly>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Board Title:</label>
            <div class="col-sm-10">
                <input type="text" name="boardTitle" value="${board.boardTitle}" class="form-control">
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Board Content:</label>
            <div class="col-sm-10">
                <input type="text" name="boardContent" value="${board.boardContent}" class="form-control">
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Created At:</label>
            <div class="col-sm-10">
                <input type="text" value="${board.createdAt}" class="form-control" readonly>
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-10 offset-sm-2">
                <input type="submit" value="수정하기" class="btn btn-primary">
            </div>
        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>
