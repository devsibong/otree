<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/static/css/custom.css">
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
						<h2>프로젝트 개요</h2>
						<p>샘플 프로젝트입니다.</p>
					</div>
					
					<!-- 멤버 -->
					<div class="mt-5">
						<h2>멤버</h2>
						<div class="row">
							<div class="col-3">
								<div class="card border-green-100">
									<div class="card-body">
										<h5 class="card-title">홍길동</h5>
										<p class="card-text">ㅇㅇㅇ@gmail.com</p>
									</div>
								</div>
							</div>
							<div class="col-3">
								<div class="card border-green-100">
									<div class="card-body">
										<h5 class="card-title">홍길동</h5>
										<p class="card-text">ㅇㅇㅇ@gmail.com</p>
									</div>
								</div>
							</div>
							<div class="col-3">
								<div class="card border-green-100">
									<div class="card-body">
										<h5 class="card-title">홍길동</h5>
										<p class="card-text">ㅇㅇㅇ@gmail.com</p>
									</div>
								</div>
							</div>
							<div class="col-3">
								<div class="card border-green-100">
									<div class="card-body">
										<h5 class="card-title">홍길동</h5>
										<p class="card-text">ㅇㅇㅇ@gmail.com</p>
									</div>
								</div>
							</div>

						</div>
					</div>
					
					<!-- 작업 -->
					<div class="mt-5">
						<h2>작업</h2>
						<div class="row text-center">
							<div class="col-3">
								<div class="card border-green-100">
									<div class="card-body">
										<h5 class="card-title">배정됨</h5>
										<h2 class="text-center">9</h2>
									</div>
								</div>
							</div>
							<div class="col-3">
								<div class="card border-green-100">
									<div class="card-body">
										<h5 class="card-title">완료함</h5>
										<h2 class="text-center">9</h2>
									</div>
								</div>
							</div>
							<div class="col-3">
								<div class="card border-green-100">
									<div class="card-body">
										<h5 class="card-title">만료됨</h5>
										<h2 class="text-center">9</h2>
									</div>
								</div>
							</div>
							<div class="col-3">
								<div class="card border-green-100">
									<div class="card-body">
										<h5 class="card-title">완료율</h5>
										<h2 class="text-center">9%</h2>
									</div>
								</div>
							</div>

						</div>
					</div>
					
					<!-- 마일스톤, 파일 -->
					<div class="row mt-5">
					
						<!-- 마일스톤 -->
						<div class="col-6">
							<h2>마일스톤</h2>
							<div class="row text-center">
								<div class="col">
									<div class="card border-green-100">
										<div class="card-body">
											<table class="table">
												<thead>
													<tr>
														<th scope="col">No</th>
														<th scope="col">마일스톤</th>
														<th scope="col">일자</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<th scope="row">1</th>
														<td>기획안 확정</td>
														<td>2023.06.26</td>
													</tr>
													<tr>
														<th scope="row">1</th>
														<td>기획안 확정</td>
														<td>2023.06.26</td>
													</tr>
													<tr>
														<th scope="row">1</th>
														<td>기획안 확정</td>
														<td>2023.06.26</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						
						<!-- 파일 -->
						<div class="col-6">
							<h2>파일</h2>
							<div class="row text-center">
								<div class="col">
									<div class="card border-green-100">
										<div class="card-body">
											<table class="table">
												<thead>
													<tr>
														<th scope="col">No</th>
														<th scope="col">마일스톤</th>
														<th scope="col">일자</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<th scope="row">1</th>
														<td>기획안 확정</td>
														<td>2023.06.26</td>
													</tr>
													<tr>
														<th scope="row">1</th>
														<td>기획안 확정</td>
														<td>2023.06.26</td>
													</tr>
													<tr>
														<th scope="row">1</th>
														<td>기획안 확정</td>
														<td>2023.06.26</td>
													</tr>
												</tbody>
											</table>
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


