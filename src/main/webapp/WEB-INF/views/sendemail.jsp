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
	<section class="vh-100 bg-secondary">
		<div class="container py-5 h-100">
			<div class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card text-primary card-border-radius-xl">
						<div class="card-body p-5 text-center">
							<div class="mb-md-3 mt-md-4 ps-3 pe-3">
								<div class="mb-4">
									<h3 class="fw-bold mb-5">인증 메일 전송 완료</h2>
								</div>
								
								<div class="fs-6 mb-5">
									<p>아래의 메일 주소로 인증 메일을 전송했습니다.</p>
									<p>10분 이내에 인증 링크를 클릭해 주세요.</p>
									<p>전송된 이메일을 확인해 인증 절차를 완료해 주세요.</p>
								</div>
								
								<div class="mb-5">
									<h2>honggildong@naver.com</h2>
								</div>
								
								<!-- 인증메일 보내기 -->
								<div class="d-grid gap-2 mb-4">
									<button class="btn btn-primary btn-lg fw-bold">확인</button>
								</div>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>


