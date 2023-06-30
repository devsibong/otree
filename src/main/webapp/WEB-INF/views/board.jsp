<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/static/css/custom.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
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
						<h2>보드</h2>
					</div>
					<div class="mt-5 row">
						<!-- 생성됨 영역 -->
						<div class="col-3">
							<p>생성됨</p>
							<div class="card border-green-200 vh-70 p-3 pt-0">
								
								<!-- 업무 카드 -->
								<div class="card border-green-500 mt-3">
									<div class="card-body">
										<div class="fs-6 fw-bold">기획서 초안 작성</div>
										<div class="row mt-3 align-items-end">
											<div class="col-9 text-start fs-8 text-secondary">6월 24일~6월 26일</div>
											<div class="col-3 d-flex justify-content-end align-items-end">
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
											</div>
										</div>
									</div>
								</div>
								
								<div class="card border-green-500 mt-3">
									<div class="card-body">
										<div class="fs-6 fw-bold">기획서 초안 작성</div>
										<div class="row mt-3 align-items-end">
											<div class="col-9 text-start fs-8 text-secondary">6월 24일~6월 26일</div>
											<div class="col-3 d-flex justify-content-end align-items-end">
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
											</div>
										</div>
									</div>
								</div>
								
								<div class="card border-green-500 mt-3">
									<div class="card-body">
										<div class="fs-6 fw-bold">기획서 초안 작성</div>
										<div class="row mt-3 align-items-end">
											<div class="col-9 text-start fs-8 text-secondary">6월 24일~6월 26일</div>
											<div class="col-3 d-flex justify-content-end align-items-end">
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-3">
							<p>진행중</p>
							<div class="card bg-green-100 border-white vh-70 p-3 pt-0">
								<div class="card border-green-500 mt-3">
									<div class="card-body">
										<div class="fs-6 fw-bold">기획서 초안 작성</div>
										<div class="row mt-3 align-items-end">
											<div class="col-9 text-start fs-8 text-secondary">6월 24일~6월 26일</div>
											<div class="col-3 d-flex justify-content-end align-items-end">
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
											</div>
										</div>
									</div>
								</div>
								<div class="card border-green-500 mt-3">
									<div class="card-body">
										<div class="fs-6 fw-bold">기획서 초안 작성</div>
										<div class="row mt-3 align-items-end">
											<div class="col-9 text-start fs-8 text-secondary">6월 24일~6월 26일</div>
											<div class="col-3 d-flex justify-content-end align-items-end">
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
											</div>
										</div>
									</div>
								</div>
								<div class="card border-green-500 mt-3">
									<div class="card-body">
										<div class="fs-6 fw-bold">기획서 초안 작성</div>
										<div class="row mt-3 align-items-end">
											<div class="col-9 text-start fs-8 text-secondary">6월 24일~6월 26일</div>
											<div class="col-3 d-flex justify-content-end align-items-end">
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-3">
							<p>완료됨</p>
							<div class="card border-green-200 vh-70 p-3 pt-0">
								<div class="card border-green-500 mt-3">
									<div class="card-body">
										<div class="fs-6 fw-bold">기획서 초안 작성</div>
										<div class="row mt-3 align-items-end">
											<div class="col-9 text-start fs-8 text-secondary">6월 24일~6월 26일</div>
											<div class="col-3 d-flex justify-content-end align-items-end">
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
												<p class="pe-1 mb-0 text-secondary"><i class="bi bi-person-circle"></i></p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						
					</div>
				</div>
			</main>
		</div>
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>


