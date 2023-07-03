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
			<jsp:include page="./includes/emptysidebar.jsp" />			
			
			<!-- main -->
			<main class="col justify-content-start d-flex">
				<!-- 여백 -->
				<div class="container mt-5">
					<!-- 개요 -->
					<div class="mt-5">
						<h2>워크스페이스가 없습니다. 새로운 워크스페이스를 생성하세요.</h2>
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


