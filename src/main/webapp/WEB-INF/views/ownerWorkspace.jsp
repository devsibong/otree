<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/static/css/custom.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<!-- navbar -->
	<jsp:include page="./includes/navbar.jsp" />
	<section class="container-fluid">
		<div class="row">
			<jsp:include page="./includes/sidebar.jsp" />			
			
			<!-- main -->
			<main class="col justify-content-start d-flex">
				<!-- 여백 -->
				<div class="container mt-5">
					<!-- 개요 -->
					<div class="mt-5">
						<h2>프로젝트 개요 <span><a href="#"><i class="bi bi-pencil-square fs-4 text-secondary"></i></a></span></h2>
						<p>${selectedWorkspace.description}</p>
					</div>

					<!-- 멤버 -->
					<div class="mt-5">
						<h2>멤버
							<span><a href="#"><i class="bi bi-pencil-square fs-4 text-secondary"></i></a></span>
						</h2>
						<div class="row">
							<c:forEach var="teamUser" items="${teamUserList}">
								<div class="col-3">
									<div class="card border-green-200 shadow-sm">
										<div class="card-body p-3">
											<div class="row">
												<div class="col-3">
													<img src="${pageContext.request.contextPath}/resources/static/image/icon/person-circle.svg" alt="userIcon">
												</div>
												<div class="col ms-2">
													<div class="d-flex justify-content-between">
														<h5 class="card-title">${teamUser.name}</h5>
														<c:if test="${teamUser.userId eq owner.userId}">
							                                <p class="badge text-bg-primary">Owner</p>
							                            </c:if>
													</div>
													<p class="card-text">${teamUser.email}</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
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
							<h2>마일스톤
								<span><a href="#"><i class="bi bi-pencil-square fs-4 text-secondary"></i></a></span>
							</h2>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/navbar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/sidebar.js"></script>
</body>
</html>


