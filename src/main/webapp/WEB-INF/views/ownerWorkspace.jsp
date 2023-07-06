<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/custom.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
						<h2>
							프로젝트 개요 <span> <a href="#" id="modifyDescriptionIcon"><i class="bi bi-pencil-square fs-4 text-secondary"></i></a> <a href="#" id="modifyDescriptionConfirmIcon" class="d-none"><i class="bi bi-check2-square fs-4 text-secondary"></i></a>
							</span>
						</h2>
						<p id="workspaceDescription" class="text-start">${selectedWorkspace.description}</p>
						<input id="modifyDescription" class="form-control d-none" type="text"></input>
					</div>

					<!-- 멤버 -->
					<div class="mt-4">
						<h3>
							멤버 <span><a href="#" id="addMemberIcon"><i class="bi bi-plus-lg fs-4 text-secondary"></i></a></span>
						</h3>
						<div class="row" id="memberList">
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
														<div class="justify-content-end">
															<c:if test="${teamUser.userId eq owner.userId}">
																<p class="badge text-bg-primary">Owner</p>
															</c:if>
															<a href="#" class="removeMemberIcon" id="${teamUser.userId}"><i class="bi bi-trash-fill text-primary"></i></a>
														</div>
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
					<div class="mt-4">
						<h3>작업</h3>
						<div class="row text-center">
							<div class="col-3">
								<div class="card border-green-100 vh-20 shadow-sm">
									<div class="card-body">
										<h5 class="card-title">생성됨</h5>
										<h2 class="text-center mt-5">3</h2>
									</div>
								</div>
							</div>
							<div class="col-3">
								<div class="card border-green-100 vh-20 shadow-sm">
									<div class="card-body">
										<h5 class="card-title">진행중</h5>
										<h2 class="text-center mt-5">3</h2>
									</div>
								</div>
							</div>
							<div class="col-3">
								<div class="card border-green-100 vh-20 shadow-sm">
									<div class="card-body">
										<h5 class="card-title">완료함</h5>
										<h2 class="text-center mt-5">2</h2>
									</div>
								</div>
							</div>
							<div class="col-3">
								<div class="card border-green-100 vh-20 shadow-sm">
									<div class="card-body">
										<div class="d-flex justify-content-center">
											<div class="col-6">
												<canvas id="pjChart"></canvas>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- 마일스톤, 파일 -->
					<div class="row mt-4">

						<!-- 마일스톤 -->
						<div class="col-6">
							<h3>
								마일스톤 <span><a href="#"><i class="bi bi-pencil-square fs-4 text-secondary"></i></a></span>
							</h3>
							<div class="row text-center">
								<div class="col">
									<div class="card border-green-100 shadow-sm">
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
														<td>요구사항 정의</td>
														<td>2023.06.26</td>
													</tr>
													<tr>
														<th scope="row">2</th>
														<td>논리ERD 설계</td>
														<td>2023.06.09</td>
													</tr>
													<tr>
														<th scope="row">3</th>
														<td>기획안 확정</td>
														<td>2023.07.07</td>
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
							<h3>파일</h3>
							<div class="row text-center">
								<div class="col">
									<div class="card border-green-100 shadow-sm">
										<div class="card-body">
											<table class="table">
												<thead>
													<tr>
														<th scope="col">No</th>
														<th scope="col">파일명</th>
														<th scope="col">일자</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<th scope="row">1</th>
														<td>와이어프레임.pdf</td>
														<td>2023.06.26</td>
													</tr>
													<tr>
														<th scope="row">2</th>
														<td>스토리보드.pdf</td>
														<td>2023.06.26</td>
													</tr>
													<tr>
														<th scope="row">3</th>
														<td>기획안 ver1.word</td>
														<td>2023.06.29</td>
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


	<div class="offcanvas offcanvas-end" tabindex="-1" id="memberOffcanvas" data-bs-backdrop="false" style="margin-top: 65px;">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasRightLabel">새 멤버 추가</h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<div class="row">
				<div class="col-3">
					<input class="form-control" placeholder="이름"></input>
				</div>
				<div class="col-9">
					<input class="form-control" id="memberSerch" placeholder="이름으로 검색하세요..."></input>
				</div>
			</div>
			<div id="resultArea"></div>
			<div class="card border-green-200 shadow-sm mt-3 d-none" name="memberCard">
				<div class="card-body p-3">
					<div class="row">
						<div class="col-3">
							<img src="${pageContext.request.contextPath}/resources/static/image/icon/person-circle.svg" alt="userIcon">
						</div>
						<div class="col ms-2">
							<div class="d-flex justify-content-between">
								<h5 class="card-title" name="memberName">Name</h5>
								<div class="d-none" name="memberId"></div>
								<div class="justify-content-end">
									<a href="#" id="plusMemberIcon"><i class="bi bi-plus-lg text-primary"></i></a>
								</div>
							</div>
							<p class="card-text" name="memberEmail">dddd@com</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-3 d-none" id="memberTemplate">
			<div class="card border-green-200 shadow-sm mt-3">
				<div class="card-body p-3">
					<div class="row">
						<div class="col-3">
							<img src="${pageContext.request.contextPath}/resources/static/image/icon/person-circle.svg" alt="userIcon">
						</div>
						<div class="col ms-2">
							<div class="d-flex justify-content-between">
								<h5 class="card-title" name="memberName">Name</h5>
								<div class="d-none" name="memberId"></div>
								<p class="badge text-bg-primary d-none" name="ownerBadge">Owner</p>
								<div class="justify-content-end">
									<a href="#" class="removeMemberIcon"><i class="bi bi-trash-fill text-primary"></i></a>
								</div>
							</div>
							<p class="card-text" name="memberEmail">dddd@com</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/navbar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/ownerSidebar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/ownerWorkspace.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/todo.js"></script>
</body>
</html>


