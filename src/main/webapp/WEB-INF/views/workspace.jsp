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
	<!-- navigation bar -->
	<header class="navbar bg-white position-fixed flex-nowrap top-0 w-100 p-0 border-bottom border-green-100">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">Logo</a>
		<input class="form-control form-control-sm w-50 rounded-5 border-0 bg-green-100 text-white mt-3 mb-3"
			type="text" placeholder="Search" aria-label="Search">
		<div class="navbar-nav">
			<div class="nav-item text-nowrap">
				<a class="nav-link px-3" href="#">Mypage</a>
			</div>
		</div>
	</header>
	<!-- sidebar -->
	<section class="container-fluid">
		<div class="row">
			<div class="otree-sidebar-1 d-flex flex-column flex-shrink-0 bg-light vh-100">
				<ul class="nav nav-pills flex-column mb-auto mt-5">
					<li class="nav-item"> <a class="nav-link"></a></li>
					<li class="nav-item"> <a class="nav-link active">WO1</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
					<li class="nav-item"> <a class="nav-link">WO2</a></li>
				</ul>

			
			</div>
			<div class="otree-sidebar-2 d-flex flex-column flex-shrink-0 bg-green-100 vh-100"">
				<div class="mt-5">
					<h2 class="mt-5">WORKSPACE</h2>
					<p class="text-end">owner : hong</p>
				</div>
				<ul class="nav nav-pills flex-column mb-auto">
					<li class="nav-item"> <a class="nav-link active">대시보드</a></li>
					<li class="nav-item"> <a class="nav-link">보드</a></li>
					<li class="nav-item"> <a class="nav-link">나의 할일</a></li>
					<li class="nav-item"> <a class="nav-link">게시판</a></li>
				</ul>
			</div>
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


