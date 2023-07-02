<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
	<title>게시판 상세</title>
</head>
<body>
	<div id="pageContainer">
		<div style="padding-top: 30px; text-align: center">
				<b>게시판 글내용</b>
				<table width="80%" border="1">
					<tr>
						<td width="20%" align="center"><b>글번호</b></td>
						<td width="30%"><c:out value="${boardDetail.boardId}" /></td>
						<td width="20%" align="center"><b>작성일</b></td>
						<td><c:out value="${boardDetail.createdAt}" /></td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>글쓴이</b></td>
						<td width="30%"><c:out value="${boardDetail.userId}" /></td>
						<td width="20%" align ="center"><b>파일첨부</b></td>
					
						<td width="30%">
						
					<c:forEach var="file" items="${boardFileList}">
						
						<p><c:out value="${file.fileSrc}" /></p>
						
					</c:forEach>
						
						</td>
					
											
					
					</tr>
					
					<tr>
						<td width="20%" align="center"><b>제목</b></td>
						<td colspan="3"><c:out value="${boardDetail.boardTitle}" /></td>
					</tr>
					<tr height="100">
						<td width="20%" align="center"><b>글내용</b></td>
						<td colspan="3"><p><c:out value="${boardDetail.boardContent}" /></p></td>
					</tr>
					<tr>
						<td colspan="4" align="center">
							<a href="getBoardList2">목록가기</a> |
							<a href="updateBoard?boardId=${boardDetail.boardId}">수정</a> |
							<a href="deleteBoard?boardId=${boardDetail.boardId}">삭제</a> |
						</td>
					</tr>
				</table>
				
				<!-- 댓글 목록 -->
			<div>
				<table id ="commentList" width="80%" border="1">
					<tr>
						<th colspan="2">댓글 목록</th>
					</tr>
					<c:forEach var="comment" items="${boardCommentList}">
						<tr>
							<td align="left">작성자: <c:out value="${comment.userId}" /></td>
							<td><c:out value="${comment.boardComment}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
				
				<!-- 댓글 작성 폼 -->
			
					<!-- hidden 태그를 이용해 필요한 데이터 전달 -->
					<input type="hidden" name="boardId" value="${boardDetail.boardId}">
					<input type="hidden" name="userId" value=""><!-- 추후 필요에 따라 변경 -->
					
					<table width="80%" border="1">
						<tr>
							<th colspan="2">댓글 쓰기</th>
						</tr>
						<tr>
							<td align="center" >내용: <textarea name="reply_content" id="comment" rows="2" cols="50"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="submit" id="commentCreate" value="댓글 작성" />
							</td>
						</tr>
					</table>
				
				
		</div>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
$("#commentCreate").click(function(){
	
	let commentCreate = {
				
				"boardComment": $("#comment").val(), 
				"boardId": ${boardDetail.boardId},
				"userId": ${boardDetail.userId},
			}
	let data = JSON.stringify(commentCreate);
	console.log(data);
	
	$.ajax({
		type: "post",
		url: "BoardCommentRest",
		data: data,
		dataType: "json",
		contentType: "application/json; charset=utf-8",
		success: function(data){
			
			console.log(data);
			/*
			$("#commentList").empty();
			let html = "";
			
			html += "<tr>";
			html += '<td>' + data.empno + '</td>';
			html += '<td>' + data.ename + '</td>';
			html += '<td>' + data.sal + '</td>';
			html += '<td><a class="btn btn-outline-primary empupdate" value2="' + data.empno + '">수정</a></td>';
			html +=	'<td><a class="btn btn-outline-primary empdelete" value2="' + data.empno + '">삭제</a></td>';
			html += "</tr>";
			
			
			$("#commentList").append(html);
			*/
			
		}
	});
	
	
});

});

</script>

</html>
