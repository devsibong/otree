<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<td width="20%" align="center"><b>파일첨부</b></td>
					<td width="30%">
					<c:forEach var="file" items="${boardFileList}">
							<p>
								<c:out value="${file.fileSrc}" />
							</p>
						</c:forEach></td>
				</tr>
				<tr>
					<td width="20%" align="center"><b>제목</b></td>
					<td colspan="1"><c:out value="${boardDetail.boardTitle}" /></td>
					<td width="20%" align="center"><b>조회수</b></td>
					<td colspan="1" align="center"><c:out value="${boardDetail.readcount}" /></td>
				</tr>
				<tr height="100">
					<td width="20%" align="center"><b>글내용</b></td>
					<td colspan="3"><p>
							<c:out value="${boardDetail.boardContent}" />
						</p></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<a href="${pageContext.request.contextPath}/workspace/${boardDetail.workspaceId}/board">목록가기</a>
						| <a href="${pageContext.request.contextPath}/workspace/${boardDetail.workspaceId}/updateBoard?boardId=${boardDetail.boardId}">수정</a> | 
						<a href="${pageContext.request.contextPath}/workspace/${boardDetail.workspaceId}/deleteBoard?boardId=${boardDetail.boardId}">삭제</a> |</td>
				</tr>
			</table>

			<!-- 댓글 목록 -->
			<div>
				<table class="commentList" width="80%" border="1">
					<tr>
						<th colspan="5">댓글 목록</th>
					</tr>
					<c:forEach var="comment" items="${boardCommentList}">
						<tr id="commentList">
							<td align="left">작성자: <c:out value="${comment.userId}" /></td>
							<td><c:out value="${comment.boardComment}" /></td>
							<!--  <td><c:out value="${comment.commentId}" /></td> -->
							<input type ="hidden" class ="commentId" value="<c:out value="${comment.commentId}"/>">
							<td><input class ="updateCommentRest" type ="button" value="수정"></td>
							<td><input class ="deleteCommentRest" type ="button" value="삭제"></td>
						</tr>
					</c:forEach>
				</table>
			</div>

			<!-- 댓글 작성 폼 -->
			<!-- hidden 태그를 이용해 필요한 데이터 전달 -->
			<input type="hidden" name="boardId" value="${boardDetail.boardId}">
			<input type="hidden" name="userId" value="">
			<!-- 추후 필요에 따라 변경 -->

			<table width="80%" border="1">
				<tr>
					<th colspan="2">댓글 쓰기</th>
				</tr>
				<tr>
					<td id = "comment2" align="center">내용: <textarea name="reply_content"
							id="comment" rows="2" cols="50"></textarea>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="button" id="commentCreate" value="댓글 작성" />
						<input type="button" id="boardDetail" value="게시글 보러가기" />
					</td>
				</tr>				
			
			</table>
		</div>
	</div>
</body>

<script type="text/javascript">
$(document).ready(function(){
<!-- 댓글 작성 눌렀을 때 삽입된 리스트 리턴 -->
$("#commentCreate").click(function(){
	
	
	let commentCreate = {
				"boardComment": $("#comment").val(), 
				"boardId": ${boardDetail.boardId},
				"userId": ${boardDetail.userId},
			};
	let data = JSON.stringify(commentCreate);
	$.ajax({
		type: "post",
		url: "/douzone/test",
		data: data,
		dataType: "json",
		contentType: "application/json; charset=utf-8",
		success: function(data){
			
			$(".commentList").empty(); // class tag사용 
			let html = "";
			html += '<tr> <th colspan="3">댓글 목록</th> </tr>'; 
			$.each(data, function(){
				html += '<tr>';
				html += '<td align="left">작성자:' + this.userId + '</td>';
				html += '<td align="left">댓글내용:' + this.boardComment + '</td>';
				html += '</tr>';
			});
				
				$(".commentList").append(html);
		}
	});
});


// 게시판 상세보기 들어가서 수정 버튼 눌렀을때
$(document).on('click', '.updateCommentRest', function() {
	let a = $(this).closest("tr").find(".commentId").val();
	console.log(a); <!-- commentId 가져오기 -->
	$.ajax({
		type: "get",
		url: "/douzone/test?param="+a,
		dataType: "json",
		contentType: "application/json; charset=utf-8",
		success: function(data){
			$(".commentList").empty(); // class tag사용 
			let html = "";
			html += '<tr> <th colspan="3">댓글 목록</th> </tr>'; 
			html += '<tr>';
			<!-- hidden으로 commentId담아 놓기 -->
			<!-- model객체에 commentList라 못담았음. -->
			html += '<input type ="hidden" id="hiddenCommentId" value="'+data.commentId+'">';
			html += '<td align="left">작성자:' + data.userId + '</td>';
			html += '<td>댓글내용: <input type="text" id="boardCommentClick" value="'+data.boardComment+'"></td>';
			html += '<td align="left"><input type="button" id="updateOk" value="수정완료"></td>';
			html += '</tr>';
			$(".commentList").append(html);
		}
	});
});


// 수정완료 버튼 눌렀을때
$(document).on('click', '#updateOk', function() {
	  let commentUpdate = {
	    "commentId": $("#hiddenCommentId").val(),
	    "boardComment": $("#boardCommentClick").val(),
	    "boardId": ${boardDetail.boardId},
	    "userId": ${boardDetail.userId}
	  };
	  let data = JSON.stringify(commentUpdate);
	  console.log(data);
	  $.ajax({
			type: "put",
			url: "/douzone/test",
			data: data,
			dataType: "json",
			contentType: "application/json; charset=utf-8",
			success: function(data){
				$(".commentList").empty(); // class tag사용 
				let html = "";
				html += '<tr> <th colspan="3">댓글 목록</th> </tr>'; 
					html += '<tr>';
					html += '<td align="left">작성자:' + data.userId + '</td>';
					html += '<td><input type="text" value="'+data.boardComment+'" readonly></td>';
					html += '</tr>';					
					$(".commentList").append(html);
			}
		});
	  
	});


// 댓글 삭제버튼
$(document).on('click', '.deleteCommentRest', function() {
		let a = $(this).closest("tr").find(".commentId").val();
		console.log(a); 
		let b = ${boardDetail.boardId};
		console.log(b);
		
		$.ajax({
			type: "delete",
			url: "/douzone/test?commentId="+a+"&boardId="+b,
			dataType: "json",
			contentType: "application/json; charset=utf-8",
			success: function(data){
				console.log(data);
				$(".commentList").empty(); // class tag사용 
				let html = "";
				html += '<tr> <th colspan="5">댓글 목록</th> </tr>' 
				$.each(data, function(){
					html += '<tr>';
					html += '<td align="left">작성자: '+this.userId+'</td>';
					html += '<td align="middle">'+this.boardComment+'</td>';
					html += '<input type ="hidden" class="commentId" value="'+this.commentId+'">';
					html += '<td><input class ="updateCommentRest" type ="button" value="수정"></td>';
					html += '<td><input class ="deleteCommentRest" type ="button" value="삭제"></td>';
					html += '</tr>';
				});
					$(".commentList").append(html);
			}
		});
	});


	<!-- 게시글로 돌아가기 눌렀을 경우 Client에서 페이지 이동 처리 data이동x -->
	$("#boardDetail").click(function(){
	console.log(${boardDetail.boardId});
	 const newPageURL = '/douzone/workspace/${boardDetail.workspaceId}/getBoardDetail?boardId='+${boardDetail.boardId};
	 window.location.href = newPageURL;

	});


});




</script>

</html>
