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
					<!-- 개요 -->
					<div class="mt-5">
						<div class="row">
							<div class="col-auto">
								<h2>보드</h2>
							</div>
							<div class="col-auto mt-2">
								<button class="btn btn-primary btn-sm" href="#" id="plusMemberIcon">
									<i class="bi bi-plus-lg text-white"></i>업무 추가
								</button>
							</div>
							<div class="spinner-border text-green-400" role="status" id="kanbanSpinner">
								<span class="visually-hidden">Loading...</span>
							</div>
						</div>
					</div>
					<div class="mt-3 row">
						<!-- 생성됨 영역 -->
						<div class="col-3">
							<p class="fs-5 text-primary">생성됨</p>
							<div class="card border-green-200 vh-70 p-3 pt-0" id="generated"></div>
						</div>
						<div class="col-3">
							<p class="fs-5 text-primary">진행중</p>
							<div class="card bg-green-100 border-white vh-70 p-3 pt-0" id="processing"></div>
						</div>
						<div class="col-3">
							<p class="fs-5 text-primary">완료됨</p>
							<div class="card border-green-200 vh-70 p-3 pt-0" id="complete"></div>
						</div>

					</div>
				</div>
			</main>
		</div>
	</section>

	<div class="card border-green-500 mt-3 d-none" id="taskTemplate">
		<div class="card-body">
			<div class="fs-6 fw-bold" name="taskContent">기획서 초안 작성</div>
			<div class="row mt-3 align-items-end">
				<div class="col-9 text-start fs-8 text-secondary">
					<span name="startDate"></span>~<span name="endDate"></span>
				</div>
				<div class="d-none" name="taskId"></div>
				<div class="d-none" name="statusId"></div>
				<div class="d-none" name="taskSeq"></div>
			</div>
		</div>
	</div>
	<div class="offcanvas offcanvas-end border-left-green-200" tabindex="-1" id="taskOffcanvas" aria-labelledby="offcanvasRightLabel" data-bs-backdrop="false" style="margin-top: 65px;">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasRightLabel">새 작업</h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<form id="taskForm">
				<div class="mb-3">
					<label for="startDate" class="form-label">시작일</label> <input type="date" class="form-control" id="startDate" name="startDate" required>
				</div>
				<div class="mb-3">
					<label for="endDate" class="form-label">종료일</label> <input type="date" class="form-control" id="endDate" name="endDate" required>
				</div>
				<div class="mb-3">
					<label for="taskContent" class="form-label">작업 내용</label>
					<textarea class="form-control" id="taskContent" name="taskContent" required></textarea>
				</div>
				<button id="createTask" class="btn btn-primary">작업 생성</button>
			</form>
		</div>
	</div>
	<div class="offcanvas offcanvas-end border-left-green-200" tabindex="-1" id="taskDetailOffcanvas" aria-labelledby="offcanvasRightLabel" data-bs-backdrop="false" style="margin-top: 65px;">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasRightLabel" name="taskContent"></h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<div class="mb-3" name="taskStart"></div>
			<div class="mb-3" name="taskEnd"></div>
			<button id="removeTask" class="btn btn-primary">삭제</button>
		</div>
	</div>





	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/navbar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/sidebar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/todo.js"></script>
	<script src="https://unpkg.com/sortablejs-make/Sortable.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-sortablejs@latest/jquery-sortable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/kanban.js"></script>
</body>
</html>


