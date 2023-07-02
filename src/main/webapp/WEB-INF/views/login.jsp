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
									<h2 class="fw-bold mb-5">Otree</h2>
								</div>
								<form action="${pageContext.request.contextPath}/member/login" method="post">
									<!-- 이메일 입력 -->
									<div class="form-outline form-white mb-4">
										<input type="email" name="email"
											class="form-control form-control-lg" placeholder="이메일" />
									</div>
	
									<!-- 비밀번호 입력 -->
									<div class="form-outline form-white mb-2">
										<input type="password" name="password"
											class="form-control form-control-lg" placeholder="비밀번호" />
									</div>
	
	
									<!-- 자동 로그인 -->
									<div class="form-check text-start mb-4">
										<input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"> 
											<label class="form-check-label"for="flexCheckDefault"> 자동 로그인 </label>
									</div>
	
	
									<div class="d-grid gap-2 mb-4">
										<button class="btn btn-primary btn-lg fw-bold" type="submit">로그인</button>
									</div>
									
									<div>
										<a href="${pageContext.request.contextPath}/member/register"><span>비밀번호 찾기</span></a>
										<span>  | </span>
										<a href="${pageContext.request.contextPath}/member/register"><span>회원가입</span></a>
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
</body>
</html>


