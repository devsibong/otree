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
								<form action="${pageContext.request.contextPath}/member/register" method="post" id="registerForm">
									<!-- 이메일 입력 -->
									<div class="row mb-4">
										<div class="text-primary text-start mb-2">이메일 입력</div>
										<div class="col-9 form-outline form-white text-start">
											<input type="email" id="email" name="email" class="form-control" placeholder="이메일" />
										</div>
										<div class="col-3 px-0 d-grid gap-2">
											<button class="btn btn-primary" id="emailConfirm">
												<span class="spinner-border spinner-border-sm d-none" role="status" id="spinner" aria-hidden="true"></span>
												<span id="spinnerText" class="">인증</span>
											</button>
										</div>
									</div>
									<div class="row d-none" id="emailConfirmArea">
										<div class="col-9 form-outline form-white mb-4 text-start">
											<div id="emailErrorMessage" class="text-danger"></div>
										</div>
									</div>
									<div class="row d-none" id="verificationArea">
										<div class="text-primary text-start mb-2">인증번호 확인</div>
										<div class="col-9 form-outline form-white text-start">
											<input type="text" id="verificationInput" class="form-control"/>				
										</div>
										<div class="col-3 px-0 d-grid gap-2">
											<button class="btn btn-primary" id="emailVerification">확인</button>
										</div>
									</div>
									<div class="row d-none" id="verificationNumberArea">
										<div class="col-9 form-outline form-white mb-4 text-start">
											<div id="emailVerifyMessage" class="text-danger"></div>
										</div>
									</div>
									<!-- 비밀번호 입력 -->
									<div class="form-outline form-white mb-4 text-start">
										<label class="form-label" for="password">비밀번호</label>
										<input type="password" id="password" name="password" class="form-control" placeholder="8~20자 이내의 영문, 숫자, 특수문자" />
									</div>
									
									<!-- 비밀번호 확인 -->
									<div class="form-outline form-white mb-4 text-start">
										<label class="form-label" for="passwordConfirm">비밀번호 확인</label>
										<input type="password" id="passwordConfirm" class="form-control" placeholder="비밀번호" />
									</div>
									
									<div class="row d-none" id="verificationPassword">
										<div class="col-9 form-outline form-white mb-4 text-start">
											<div id="pwVerificationMessage" class="text-danger"></div>
										</div>
									</div>
									
									<!-- 닉네임 입력 -->
									<div class="form-outline form-white mb-5 text-start">
										<label class="form-label" for="name">닉네임</label>
										<input type="text" id="name" name="name" class="form-control" placeholder="1~5자 이내의 영문 또는 한글" />									
									</div>
									
									<!-- 인증메일 보내기 -->
									<div class="d-grid gap-2 mb-4">
										<button class="btn btn-primary btn-lg fw-bold" type="submit" id="register">회원가입</button>
									</div>
								</form>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/register.js"></script>
</body>
</html>


