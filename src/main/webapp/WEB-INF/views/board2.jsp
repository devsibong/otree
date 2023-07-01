<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					
					
					<c:forEach var="file" items="${boardFileList}">
											
						<td width="30%"><c:out value="${file.fileSrc}" /></td>
					
					</c:forEach>
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
							<a href="BoardEdit.do?idx=${boardDetail.boardId}&cp=1&ps=5">수정</a> |
							<a href="BoardDelete.do?idx=${boardDetail.boardId}&cp=1&ps=5">삭제</a> |
							<a href="BoardRewrite.do?idx=${boardDetail.boardId}&cp=1&ps=5&subject=${boardDetail.boardTitle}">답글</a>
						</td>
					</tr>
				</table>
				
				<!-- 댓글 목록 -->
				<table width="80%" border="1">
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
				
				<!-- 댓글 작성 폼 -->
				<form name="reply" action="ReplyOk.do" method="POST">
					<!-- hidden 태그를 이용해 필요한 데이터 전달 -->
					<input type="hidden" name="boardId" value="${boardDetail.boardId}">
					<input type="hidden" name="userId" value=""><!-- 추후 필요에 따라 변경 -->
					
					<table width="80%" border="1">
						<tr>
							<th colspan="2">댓글 쓰기</th>
						</tr>
						<tr>
							<td align="left">작성자: <input type="text" name="reply_writer" /></td>
							<td>내용: <textarea name="reply_content" rows="2" cols="50"></textarea></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="댓글 작성" />
							</td>
						</tr>
					</table>
				</form>
		</div>
	</div>
</body>
</html>
