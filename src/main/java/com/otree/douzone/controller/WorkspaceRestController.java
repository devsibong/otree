package com.otree.douzone.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	// 유저의 전체 워크스페이스 목록 조회 
	@GetMapping("/list/{userId}")
	public ResponseEntity<List<Workspace>> getWorkspaceList (@PathVariable("userId") int userId) {
		System.out.println("userId : " + userId);
		List<Workspace> workspaceList = workspaceService.getWorkspaceList(userId);
		System.out.println("select성공");
		return ResponseEntity.status(HttpStatus.OK).body(workspaceList);
	}
	
//	// 특정 워크스페이스 정보 조회 
//	@GetMapping("/{workspaceId}")
//	public ResponseEntity<Workspace> getWorkspace (@PathVariable("workspaceId") int workspaceId) {
//		System.out.println("workspaceId : " + workspaceId);
//		Workspace workspace = workspaceService.getWorkspaceById(workspaceId);
//		System.out.println("select성공");
//		return ResponseEntity.status(HttpStatus.OK).body(workspace);
//	}
	
	// 특정 워크스페이스 정보 수정
	@PutMapping("/{workspaceId}")
	public ResponseEntity<Map<String,String>> updateWorkspace(@PathVariable("workspaceId") int workspaceId, @RequestBody Workspace changedWorkspace) {
		Workspace workspace = new Workspace();
		workspace = workspaceService.getWorkspaceById(workspaceId);
		if(changedWorkspace.getWorkspaceName() != null ) workspace.setWorkspaceName(changedWorkspace.getWorkspaceName());
		if(changedWorkspace.getDescription() != null) workspace.setDescription(changedWorkspace.getDescription());
		workspaceService.modifyWorkspace(workspace);
		Map<String, String> response = new HashMap<>();
		response.put("message", "success");
		return ResponseEntity.ok(response);
	}
	
	// 특정 워크스페이스 삭제 
	@DeleteMapping("/{workspaceId}")
	public ResponseEntity<String> deleteWorkspace(@PathVariable("workspaceId") int workspaceId) {
		System.out.println("workspaceId : " + workspaceId);
		workspaceService.removeWorkspace(workspaceId);
		System.out.println("delete성공");
		return ResponseEntity.status(HttpStatus.OK).body("delete success");
	}
	
}