<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판 상세</title>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container py-5">
		<h2 class="text-center">게시판 글내용</h2>
		<table class="table">
			<tr>
				<th scope="col">글번호</th>
				<td><c:out value="${boardDetail.boardId}" /></td>
				<th scope="col">작성일</th>
				<td><c:out value="${boardDetail.createdAt}" /></td>
			</tr>
			<tr>
				<th scope="col">글쓴이</th>
				<td><c:out value="${boardDetail.name}" /></td>
				<th scope="col">조회수</th>
				<td colspan="3" align="center"><c:out
						value="${boardDetail.readcount}" /></td>

				</td>
			</tr>
			<tr>
				<th scope="col">제목</th>
				<td colspan="3"><c:out value="${boardDetail.boardTitle}" /></td>

			</tr>
			<tr>
				<th scope="col">글내용</th>
				<td colspan="3">
					<p>
						<c:out value="${boardDetail.boardContent}" />
					</p>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center"><a class="btn btn-primary"
					href="${pageContext.request.contextPath}/workspace/${boardDetail.workspaceId}/board">목록가기</a>
					<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/workspace/${boardDetail.workspaceId}/updateBoard?boardId=${boardDetail.boardId}">수정</a>
					<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/workspace/${boardDetail.workspaceId}/deleteBoard?boardId=${boardDetail.boardId}">삭제</a>
				</td>
			</tr>
		</table>

		<!-- 댓글 목록 -->
		<div>
			<table class="table commentList">
				<tr>
					<th colspan="5">댓글 목록</th>
				</tr>

				<c:forEach var="comment" items="${boardCommentList}">
					<tr>
						<input type="hidden" class="commentId" value="<c:out value="${comment.commentId}" />">
						<input type="hidden" id="userId" value="<c:out value="${comment.userId}" />">
						<td align="left">작성자: <c:out value="${comment.name}" /></td>
						<td><c:out value="${comment.boardComment}" /></td>
						<td>
							<c:if test="${comment.userId eq boardDetail.userId}">
								
									<input class="btn btn-primary updateCommentRest" type="button"	value="수정">
									<input class="btn btn-primary deleteCommentRest" type="button" value="삭제">
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<!-- 댓글 작성 폼 -->
		<table class="table">
			<tr>
				<th colspan="2">댓글 쓰기</th>
			</tr>
			<tr>
				<td id="comment2" align="center">내용: <textarea
						name="reply_content" id="comment" rows="2" cols="50"></textarea></td>
			</tr>
			<tr>
				<td align="center"><input type="button" id="commentCreate"
					class="btn btn-primary" value="댓글 작성" /></td>
			</tr>
		</table>
	</div>

	
	
	<script type="text/javascript">
        $(document).ready(function(){
            // 댓글 작성 눌렀을 때 삽입된 리스트 리턴
            $("#commentCreate").click(function(){
                let commentCreate = {
                    "boardComment": $("#comment").val(),
                    "boardId": ${boardDetail.boardId},
                    "userId": ${boardDetail.userId}
                };
                let data = JSON.stringify(commentCreate);
                $.ajax({
                    type: "post",
                    url: "/douzone/test",
                    data: data,
                    dataType: "json",
                    contentType: "application/json; charset=utf-8",
                    success: function(data){
                        $(".commentList").empty();
                        let html = "";
                        html += '<tr><th colspan="5">댓글 목록</th></tr>';
                        console.log(data);
                        	/*
                            html += '<tr>';
                            html += '<td align="left">작성자: ' + this.name + '</td>';
                            html += '<td align="left">댓글내용: ' + this.boardComment + '</td>';
                            html += '<input type ="hidden" class="commentId" value="'+this.commentId+'">';
                            html += '<td><input class="btn btn-primary updateCommentRest" type="button" value="수정"></td>';
                            html += '<td><input class="btn btn-primary deleteCommentRest" type="button" value="삭제"></td>';
                            html += '</tr>';*/
                            $.each(data, function(index, comment) {
                            	  html += '<tr>';
                            	  html += '<input type ="hidden" class="commentId" value="'+comment.commentId+'">';
                            	  html += '<td align="left">작성자:' + comment.name + '</td>';
                            	  html += '<td>' + comment.boardComment + '</td>';
                            	  html += '<td>';
                            	  
                            	  if (comment.userId === ${boardDetail.userId}) {
                            	    html += '<button class="btn btn-primary updateCommentRest" type="button" value="수정">';
                            	    html += '<button class="btn btn-primary deleteCommentRest" type="button" value="삭제">';
                            	  }
                            	  
                            	  html += '</td>';
                            	  html += '</tr>';
                            	});
                   
                        $(".commentList").append(html);
                    }
                });
            });

            // 동기,비동기로 불러온 댓글List 수정 버튼 눌렀을 때
            $(document).on('click', '.updateCommentRest', function() {
                let a = $(this).closest("tr").find(".commentId").val();
                console.log(a);
                $.ajax({
                    type: "get",
                    url: "/douzone/test?param="+a,
                    dataType: "json",
                    contentType: "application/json; charset=utf-8",
                    success: function(data){
                    	console.log(data);
                        $(".commentList").empty();
                        let html = "";
                        html += '<tr><th colspan="5">댓글 목록</th></tr>';
                        html += '<tr>';
                        html += '<input type="hidden" id="hiddenCommentId" value="'+data.commentId+'">';
                        html += '<td align="left">작성자: ' + data.name + '</td>';
                        html += '<td>댓글내용: <input type="text" id="boardCommentClick" value="'+data.boardComment+'"></td>';
                        html += '<td align="left"><input type="button" id="updateOk" class="btn btn-primary" value="수정완료">   <input type="button" id="boardDetail" class="btn btn-primary" value="댓글 목록으로 돌아가기" /></td>';
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
                        $(".commentList").empty();
                        let html = "";
                        html += '<tr><th colspan="5">댓글 목록</th></tr>';
                        html += '<tr>';
                        html += '<td align="left">작성자: ' + data.name + '</td>';
                        html += '<td><input type="text" value="'+data.boardComment+'" readonly></td>';
                        html += '<td><input type="button" id="boardDetail" class="btn btn-primary" value="댓글 목록으로 돌아가기" /></td>';
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
                        $(".commentList").empty();
                        let html = "";
                        html += '<tr><th colspan="5">댓글 목록</th></tr>';
                       
                        $.each(data, function(index, comment) {
                      	  html += '<tr>';
                      	  html += '<input type ="hidden" class="commentId" value="'+comment.commentId+'">';
                      	  html += '<td align="left">작성자:' + comment.name + '</td>';
                      	  html += '<td>' + comment.boardComment + '</td>';
                      	  html += '<td>';
                      	  
                      	  if (comment.userId === ${boardDetail.userId}) {
                      	    html += '<input class="btn btn-primary updateCommentRest" type="button" value="수정">';
                      	    html += '<input class="btn btn-primary deleteCommentRest" type="button" value="삭제">';
                      	  }
                      	  
                      	  html += '</td>';
                      	  html += '</tr>';
                      	});
             
                 	 $(".commentList").append(html);
                 	 
                    }
                });
                 	
            });

            // 비동기로 만든 태그에서 댓글목록 눌렀을 경우.
            $(document).on('click', '#boardDetail', function(){
                console.log(${boardDetail.boardId});
                const newPageURL = '/douzone/workspace/${boardDetail.workspaceId}/getBoardDetail?boardId='+${boardDetail.boardId};
                window.location.href = newPageURL;
            });
            
            
            
            
            
            
            
        });
        
    </script>
      
    
</body>
</html>
