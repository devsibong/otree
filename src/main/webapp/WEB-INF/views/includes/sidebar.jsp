<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- <div class="otree-sidebar-1 d-flex flex-column flex-shrink-0 bg-light vh-100">
	<ul class="nav nav-pills flex-column mb-auto mt-5">
		<li class="nav-item"> <a class="nav-link"></a></li>
		<li class="nav-item"> <a class="ws-rounded-circle-active">WO1</a></li>
		<li class="nav-item"> <a class="nav-link ws-rounded-circle">WO2</a></li>
		<li class="nav-item"> <a class="nav-link ws-rounded-circle">WO2</a></li>
		<li class="nav-item"> <a class="nav-link ws-rounded-circle">WO2</a></li>
		<li class="nav-item"> <a class="nav-link ws-rounded-circle">WO2</a></li>
		<li class="nav-item"> <a class="nav-link ws-rounded-circle">WO2</a></li>
		<li class="nav-item"> <a class="nav-link ws-rounded-circle">WO2</a></li>
		<li class="nav-item"> <a class="nav-link ws-rounded-circle">WO2</a></li>
		<li class="nav-item"> <a class="nav-link ws-rounded-circle">WO2</a></li>
		<li class="nav-item"> <a class="nav-link ws-rounded-circle">WO2</a></li>
		<li class="nav-item"> <a class="nav-link ws-rounded-circle">WO2</a></li>
	</ul>
</div> -->

<div class="otree-sidebar-1">
	<div class="ws-rounded-circle mt-3 mb-3 fs-7 fw-bold">WS1</div>
	<div class="ws-rounded-circle mt-3 mb-3 fs-7 fw-bold">WS1</div>
	<div class="ws-rounded-circle mt-3 mb-3 fs-7 fw-bold">WS1</div>
	<div class="ws-rounded-circle mt-3 mb-3 fs-7 fw-bold">WS1</div>
	<div class="ws-rounded-circle mt-3 mb-3 fs-7 fw-bold">WS1</div>
	<div class="ws-rounded-circle-active mt-3 mb-3 fw-bold">WS1</div>
	<div class="ws-rounded-circle mt-3 mb-3 fs-7 fw-bold">WS1</div>
	<div class="ws-rounded-circle mt-3 mb-3 fs-7 fw-bold">WS1</div>
</div>
<div class="otree-sidebar-2 d-flex flex-column flex-shrink-0 bg-green-100 vh-100">
	<div class="mt-5 mx-3">
		<h2 class="mt-5">WORKSPACE</h2>
		<p class="text-end">owner : hong</p>
	</div>
	<ul class="nav nav-pills flex-column mb-auto mx-3">
		<li class="nav-item"> <a class="nav-link active" href="${pageContext.request.contextPath}/workspace">대시보드</a></li>
		<li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/kanbanboardgo">보드</a></li>
		<li class="nav-item"> <a class="nav-link" href="#" id="todo">나의 할일</a></li>
		<li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/boardgo">게시판</a></li>
	</ul>
</div>

<div class="offcanvas offcanvas-end" tabindex="-1" id="todoOffcanvas" aria-labelledby="offcanvasRightLabel" data-bs-backdrop="false" style="margin-top: 65px;">
  <div class="offcanvas-header">
    <h5 class="offcanvas-title" id="offcanvasRightLabel">나의 할일</h5>
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body">
  	<div>할일 추가</div>
  	<div>알마인드 과제</div>
  	<div>알마인드 과제</div>
  </div>
</div>