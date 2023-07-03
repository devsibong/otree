<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/static/css/custom.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body>
	<!-- navbar -->
	<jsp:include page="./includes/navbar.jsp" />
	<section class="container-fluid">
		<div class="row">
			<!-- sidebar -->
			<jsp:include page="./includes/sidebar.jsp" />
			<!-- main -->
			<main class="col">
				<!-- 여백 -->
				<div class="p-4"></div>
				<div class="container mt-5">
					<!-- 개요 -->
					<div class="mt-5">
						<h2>게시판</h2>
					</div>

					<div
						class="mt-5 row border-top border-bottom border-green-500 border-2 vh-60">
						<table class="table text-center" style="table-layout: fixed">
							<thead>
								<tr>
									<th class="col-1">No</th>
									<th class="col-6">제목</th>
									<th class="col-2">작성자</th>
									<th class="col-2">날짜</th>
									<th class="col-1">조회</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="board" items="${boardList}">
									<tr class="vh-5">
										<th scope="row"><c:out value="${board.boardId}" /></th>
										<td class="text-start"><a href="/douzone/workspace/${board.workspaceId}/getBoardDetail?boardId=${board.boardId}"><c:out value="${board.boardTitle}"/></a></td>
										<td>${board.userId}</td>
										<td><c:out value="${board.createdAt}" /></td>
										<td><c:out value="${board.createdAt}" /></td>
									</tr>
								</c:forEach>
								<!-- 테이블 높이 조절을 위한 행 -->
								<tr class="border-white">
									<th scope="row"></th>
									<td class="text-start"></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
					<button onclick="window.location.href='/douzone/workspace/${workspaceId}/createBoard'">글쓰기</button>
				</div>
			</main>
		</div>
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/static/js/navbar.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/static/js/sidebar.js"></script>
</body>
</html>


