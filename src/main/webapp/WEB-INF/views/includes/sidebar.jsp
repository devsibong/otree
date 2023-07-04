<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="otree-sidebar-1">
	<div class="ws-rounded-circle mt-3 mb-3 fs-7 fw-bold">여백</div>
	<c:forEach var="workspace" items="${workspaceList}">
        <div class="${selectedWorkspace.workspaceId == workspace.workspaceId ? 'ws-rounded-circle-active' : 'ws-rounded-circle'} mt-3 mb-3 fs-7 fw-bold " id="${workspace.workspaceId}" name="workspaceIcon">${workspace.workspaceName.substring(0, 2)}</div>
    </c:forEach>
    <div class="ws-rounded-circle-plus mt-3 mb-3 fs-4 fw-bold border-green-300" id="createWorkspace">+</div>
</div>
<div class="otree-sidebar-2 d-flex flex-column flex-shrink-0 vh-100 border border-green-300">
	<div class="mt-5 mx-3">
		<h2 class="mt-5" id="workspaceName">${selectedWorkspace.workspaceName}</h2>
		<input type="text" class="form-control mt-5 fs-4 d-none" id="workspaceNameInput"></input>
		<p class="text-end">
			<c:if test="${isOwner}">
		        <span><a href="#" id="modifyWorkspaceName"><i class="bi bi-pencil-square fs-7 text-secondary me-2"></i></a></span>
		    </c:if>
		    <span><a href="#" id="workspaceNameModify" class="d-none"><i class="bi bi-check-square fs-7 text-secondary me-2"></i></a></span>
			<span>owner : </span>
			<span>${owner.name}</span>
		</p>
	</div>
	<ul class="nav nav-pills flex-column mb-auto mx-3">
	    <li class="nav-item mt-2">
	        <a class="nav-link ${pageType == 'dashboard' ? 'active' : ''}" href="${pageContext.request.contextPath}/workspace/${selectedWorkspace.workspaceId}">
	 			<i class="bi bi-house-door-fill me-2"></i> <span class="fw-bold">대시보드</span></a>
	    </li>
	    <li class="nav-item mt-2">
	        <a class="nav-link ${pageType == 'kanban' ? 'active' : ''}" href="${pageContext.request.contextPath}/workspace/${selectedWorkspace.workspaceId}/kanban">
	      	  <i class="bi bi-kanban-fill me-2"></i> <span class="fw-bold">보드</span>
	        </a>
	    </li>
	    <li class="nav-item mt-2">
	        <a class="nav-link" href="#" id="todo">
	        	<i class="bi bi-check2-square me-2"></i> <span class="fw-bold">나의 할일</span>
	        </a>
	    </li>
	    <li class="nav-item mt-2">
	        <a class="nav-link ${pageType == 'board' ? 'active' : ''}" href="${pageContext.request.contextPath}/workspace/${selectedWorkspace.workspaceId}/board">
	        	<i class="bi bi-clipboard-heart-fill me-2"></i> <span class="fw-bold">게시판</span>
	        </a>
	    </li>
	</ul>
	
</div>

<div class="offcanvas offcanvas-end" tabindex="-1" id="todoOffcanvas" aria-labelledby="offcanvasRightLabel" data-bs-backdrop="false" style="margin-top: 65px;">
	<div class="offcanvas-header">
	    <h5 class="offcanvas-title" id="offcanvasRightLabel">🧩나의 할일🖍️</h5>
	    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
	</div>
	<div class="offcanvas-body" id="offcanvasBody">
		<input type="text" id="inputToDo" placeholder="할일을 작성해주세요">
		<input class="btn-primary" id="addToDoBtn" type="button" value="할일추가">
	  	<div id="toDoBody">here</div>
	  	<div>알마인드 과제</div>
	  	<div>알마인드 과제</div>
	</div>
</div> 

<!-- Modal -->
<div class="modal fade position-fixed" id="createWorkspaceModal" tabindex="-1" aria-labelledby="createWorkspaceModalLabel" aria-hidden="true">
  <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header border-bottom-0">
				<h3 class="modal-title text-center">워크스페이스 생성</h3>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			
			<form action="${pageContext.request.contextPath}/workspace" method="post">
				<div class="modal-body">
					<div class="form-outline form-white mb-4 text-start">
						<label class="form-label" for="workspaceName">워크스페이스 이름</label> 
						<input type="text" name="workspaceName" id="workspaceName" class="form-control" placeholder="2자 이상의 한글 또는 영문" />
					</div>
					<div class="form-outline form-white mb-4 text-start">
						<label class="form-label" for="description">워크스페이스 설명</label> 
						<input type="text" name="description" id="description" class="form-control" placeholder="간단한 워크스페이스 또는 프로젝트 설명" />
					</div>
				</div>
				<div class="d-grid gap-2 m-2">
					<button type="submit" class="btn btn-primary" id="createWorkspace">워크스페이스 생성</button>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- Toast -->
<div class="toast-container position-fixed bottom-0 end-0 p-1">
  <div id="liveToast" class="toast bg-green-100" role="alert" aria-live="assertive" aria-atomic="true">
    <div class="toast-header border-bottom-0 bg-green-100">
      <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
    </div>
    <div class="toast-body bg-green-100">
      <p class="ps-3 fs-6">성공적으로 수정되었습니다.</p>
    </div>
  </div>
</div>
<script>
    let selectedWorkspaceId = ${selectedWorkspace.workspaceId};
</script>