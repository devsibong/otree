package com.otree.douzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otree.douzone.dto.Emp;
import com.otree.douzone.dto.Workspace;
import com.otree.douzone.service.WorkspaceService;

@RestController
@RequestMapping("/workspace")
public class WorkspaceRestController {
	
	private WorkspaceService workspaceService;
	
	@Autowired
	public WorkspaceRestController(WorkspaceService workspaceService) {
		this.workspaceService = workspaceService;
	}
	
	// 워크스페이스 생성
//	@PostMapping
//	public ResponseEntity<String> createWorkspace2(@RequestBody Workspace workspace) {
//		System.out.println("workspace : " + workspace);
//		// 워크스페이스 추가
//		workspaceService.createWorkspace(workspace);
//		System.out.println("insert성공");
//		// userid, workspaceid, role:owner insert
//		return ResponseEntity.status(HttpStatus.CREATED).body("insert success");
//	}
	
	// 유저의 전체 워크스페이스 목록 조회 
	@GetMapping("/list/{userId}")
	public ResponseEntity<List<Workspace>> getWorkspaceList (@PathVariable("userId") int userId) {
		System.out.println("userId : " + userId);
		List<Workspace> workspaceList = workspaceService.getWorkspaceList(userId);
		System.out.println("select성공");
		return ResponseEntity.status(HttpStatus.OK).body(workspaceList);
	}
	
	// 특정 워크스페이스 정보 조회 
	@GetMapping("/{workspaceId}")
	public ResponseEntity<Workspace> getWorkspace (@PathVariable("workspaceId") int workspaceId) {
		System.out.println("workspaceId : " + workspaceId);
		Workspace workspace = workspaceService.getWorkspaceById(workspaceId);
		System.out.println("select성공");
		return ResponseEntity.status(HttpStatus.OK).body(workspace);
	}
	
	// 특정 워크스페이스 정보 수정
	@PutMapping("/{workspaceId}")
	public ResponseEntity<String> updateEmpResponseBody(@PathVariable("workspaceId") int workspaceId, @RequestBody Workspace workspace) {
		System.out.println("workspaceId : " + workspaceId);
		workspaceService.modifyWorkspace(workspaceId, workspace);
		System.out.println("update성공");
		return ResponseEntity.status(HttpStatus.OK).body("update success");
	}
	
	// 특정 워크스페이스 삭제 
	@DeleteMapping("/{workspaceId}")
	public ResponseEntity<String> deleteEmpResponseBody(@PathVariable("workspaceId") int workspaceId) {
		System.out.println("workspaceId : " + workspaceId);
		workspaceService.removeWorkspace(workspaceId);
		System.out.println("delete성공");
		return ResponseEntity.status(HttpStatus.OK).body("delete success");
	}
	
}