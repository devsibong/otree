//package com.otree.douzone.controller;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.otree.douzone.dto.Workspace;
//import com.otree.douzone.service.WorkspaceService;
//
//@Controller
//@RequestMapping("/workspace2")
//public class WorkspaceController {
//	
//	private WorkspaceService workspaceService;
//
//	// 로그인하면 로그인한 사용자가 가진 워크스페이스 목록 가지고 워크스페이스 메인 페이지로 이동
//	// 프론트 처리는 : 리스트의 가장 처음 워크스페이스를 보여주고(workspaceList[0]), 없다면 워크스페이스 생성화면을 보여주면 됨.
//	@GetMapping("/{userId}/main")
//	public String workspaceEnter(@PathVariable("userId") int userId, Model model)  {
//		List<Workspace> workspaceList = workspaceService.getWorkspaceList(userId);
//		model.addAttribute("workspaceList", workspaceList);
//		System.out.println("workspaceList : " + workspaceList);
//		return "home"; //워크스페이스 대쉬보드 페이지로 변경하기
//	}
//	
//	
//	// 페이지 이동
//	@GetMapping("/{workspaceId}/main2")
//	public String workspaceMain() {
//		return "home"; //워크스페이스 대쉬보드 페이지로 변경하기
//	}
//	
//	@GetMapping("/{workspaceId}/kanban")
//	public String workspaceKanban() {
//		return "home"; //워크스페이스 칸반 페이지로 변경하기
//	}
//	
//	@GetMapping("/{workspaceId}/board")
//	public String workspaceBoard() {
//		return "home"; //워크스페이스 게시판 페이지로 변경하기
//	}
//	
//	
//}