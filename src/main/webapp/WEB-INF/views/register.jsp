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
							<div class="mb-md-3 mt-md-4 ps-5 pe-5">
								<div class="mb-4">
									<h3 class="fw-bold mb-5">회원가입</h3>
								</div>

								<!-- 이메일 입력 -->
								<div class="form-outline form-white mb-4 text-start">
									<label class="form-label" for="email">이메일</label>
									<input type="email" id="email" class="form-control" placeholder="이메일" />									
								</div>

								<!-- 비밀번호 입력 -->
								<div class="form-outline form-white mb-4 text-start">
									<label class="form-label" for="password">비밀번호</label>
									<input type="password" id="password" class="form-control" placeholder="8~20자 이내의 영문, 숫자, 특수문자" />
								</div>
								
								<!-- 비밀번호 확인 -->
								<div class="form-outline form-white mb-4 text-start">
									<label class="form-label" for="passwordConfirm">비밀번호 확인</label>
									<input type="password" id="passwordConfirm" class="form-control" placeholder="비밀번호" />
								</div>
								
								<!-- 닉네임 입력 -->
								<div class="form-outline form-white mb-5 text-start">
									<label class="form-label" for="name">닉네임</label>
									<input type="email" id="name" class="form-control" placeholder="1~5자 이내의 영문 또는 한글" />									
								</div>
								
								<!-- 인증메일 보내기 -->
								<div class="d-grid gap-2 mb-4">
									<button class="btn btn-primary btn-lg fw-bold" type="submit">인증메일 보내기</button>
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


