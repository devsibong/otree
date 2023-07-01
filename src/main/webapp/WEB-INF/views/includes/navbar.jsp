<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- navigation bar -->
<header class="navbar bg-white position-fixed flex-nowrap top-0 w-100 p-0 border-bottom border-green-100">
	<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="/douzone/workspace"><i class="bi bi-circle-fill fs-2 text-green-400"></i></a>
	<input class="form-control form-control-sm w-50 rounded-5 border-0 bg-green-100 text-white mt-3 mb-3"
		type="text" placeholder="Search" aria-label="Search">
	<div class="navbar-nav">
		<div class="nav-item text-nowrap">
			<a class="nav-link px-3" href="#" id="userProfile"><i class="bi bi-person-circle fs-2 text-green-400"></i></a>
		</div>
	</div>
</header>
<!-- Modal -->
<div class="modal fade custom-modal position-fixed" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog custom-size">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body text-center">
        <div class="fs-4">홍길동</div>
        <div class="fs-7">aaaa@gmail.com</div>
        <div class="justify-content-center d-flex">
        	<div>프로필 편집</div>
        	<div>|</div>
        	<div>비밀번호 변경</div>
        </div>
      </div>
      <div class= "d-grid gap-2 m-2">
      		<button type="button" class="btn btn-primary ">로그아웃</button>
      	</div>
    </div>
  </div>
</div>