<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/custom.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<style>
.ghost {
	opacity: 0;
}
</style>
<body>
	<!-- navbar -->
	<jsp:include page="./includes/navbar.jsp" />
	<section class="container-fluid">
		<div class="row">
			<jsp:include page="./includes/sidebar.jsp" />
			<!-- main -->
			<main class="col">
				<!-- 여백 -->
				<div class="p-4"></div>
				<div class="container mt-5">
					<h2>
						<c:out value="${boardDetail.boardTitle}" />
					</h2>
					<div class="d-none" id="boardId">
						<c:out value="${boardDetail.boardId}" />
					</div>

					<div class="row">
						<div class="d-flex justify-content-between">
							<div class="card border-0 mt-3">
								<div class="card-body p-1">
									<div class="row">
										<div class="col-auto">
											<i class="bi bi-person-circle text-green-300 fs-1"></i>
										</div>
										<div class="col ms-2 pt-2">
											<div class="d-flex justify-content-between">
												<h5 class="card-title fw-bold fs-6 mb-0">
													<c:out value="${boardDetail.name}" />
												</h5>
											</div>
											<p class="card-text">
												<c:out value="${boardDetail.createdAt}" />
											</p>
										</div>
									</div>
								</div>
							</div>
							<div class="mt-4 text-primary fs-5 fw-bold">
								<div>
									<i class="bi bi-chat-dots me-1"></i> <span class="fs-7">댓글</span> <span class="me-1 fs-7">10</span>
								</div>
							</div>
						</div>
						<hr class="border-green-300 mt-0">
						<div class="container p-3 mb-5 text-break">
							<c:out value="${boardDetail.boardContent}" />
						</div>
						<div class="col">
							<div class="p-3 bg-green-100">
								<div class="fw-bold">댓글</div>
								<div class="" id="commentList"></div>
								<div class="mt-4 d-none" id="commentTemplate">
									<div class="row">
										<div class="col-10">
											<div class="row">
												<div class="col-auto">
													<i class="bi bi-person-circle fs-2 text-white"></i>
												</div>
												<div class="col">
													<div class="fw-bold" name="name">작성자</div>
													<div class="fs-7" name="comment">댓글내용</div>
													<div class="d-none" name="userId"></div>
													<div class="d-none" name="commentId"></div>
												</div>
											</div>
										</div>
										<div class="col-2" name="modifyComment" id="modifyComment">
											<button class="btn btn-outline-primary btn-sm" type="button">수정</button>
											<button class="btn btn-outline-danger btn-sm" type="button" id="removeComment">삭제</button>
										</div>
									</div>
								</div>
								<div class="fw-bold mt-4">댓글 쓰기</div>
								<div class="row mt-4">
									<div class="col-10">
										<textarea class="form-control" id="commentInput" rows="3"></textarea>
									</div>
									<div class="col-2">
										<button class="btn btn-primary" id="commentRegister">등록</button>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</main>
		</div>
	</section>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/navbar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/sidebar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/todo.js"></script>
	<script type="text/javascript">
        $(document).ready(function(){
        	getCommentList();
            // 댓글 작성 눌렀을 때 삽입된 리스트 리턴
            $("#commentRegister").click(function(){
                let commentCreate = {
                    "boardComment": $("#commentInput").val(),
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
                    	getCommentList();
                    	$("#commentInput").val("");
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

            $(document).on('click', '#removeComment', function() {
            	let commentId = $(this).closest("#commentTemplate").find("[name='commentId']").text();
                let boardId = ${boardDetail.boardId};
                console.log(commentId);
                $.ajax({
                    type: "delete",
                    url: "/douzone/test?commentId=" + commentId + "&boardId=" + boardId,
                    dataType: "json",
                    contentType: "application/json; charset=utf-8",
                    success: function(data) {
                        getCommentList();
                    }
                });
            });



            // 비동기로 만든 태그에서 댓글목록 눌렀을 경우.
            $(document).on('click', '#boardDetail', function(){
                console.log(${boardDetail.boardId});
                const newPageURL = '/douzone/workspace/${boardDetail.workspaceId}/getBoardDetail?boardId='+${boardDetail.boardId};
                window.location.href = newPageURL;
            });            
        
        
            function getCommentList() {
                let data = {
                    "boardId": ${boardDetail.boardId}
                };

                $.ajax({
                    type: "POST",
                    url: "/douzone/test/comments",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(data),
                    success: function (data) {
                    	console.log("hello");
                        let commentListContainer = $("#commentList");
                        let commentTemplate = $("#commentTemplate");
                        commentListContainer.empty();
                        data.forEach(function (comment) {
                        	
                            let newCommentCard = commentTemplate.clone();
                            newCommentCard.removeClass("d-none");
                            newCommentCard.find('[name="name"]').text(comment.name);
                            newCommentCard.find('[name="comment"]').text(comment.boardComment);
                            newCommentCard.find('[name="userId"]').text(comment.userId);
                            newCommentCard.find('[name="commentId"]').text(comment.commentId);
                            commentListContainer.append(newCommentCard);
                            if (comment.userId === ${boardDetail.userId}) {
                            } else {
                            	newCommentCard.find('[name="modifyComment"]').addClass('d-none');
                            }
                        });
                    },
                    error: function (error) {
                        console.log(error);
                    }
                });
            }


        });
        
    </script>
</body>
</html>


