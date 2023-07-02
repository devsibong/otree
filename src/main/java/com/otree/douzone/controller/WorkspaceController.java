package com.otree.douzone.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.otree.douzone.dto.TeamRole;
import com.otree.douzone.dto.Workspace;
import com.otree.douzone.dto.WorkspaceTeamUser;
import com.otree.douzone.service.TeamRoleService;
import com.otree.douzone.service.WorkspaceService;

@Controller
@RequestMapping("/workspace")
public class WorkspaceController {
	
	private WorkspaceService workspaceService;
	private TeamRoleService teamRoleService;

	@Autowired
	public WorkspaceController(WorkspaceService workspaceService, TeamRoleService teamRoleService) {
	    this.workspaceService = workspaceService;
		this.teamRoleService = teamRoleService;
	}
	
	@GetMapping("/{workspaceId}")
	public String workspaceDash(@PathVariable("workspaceId") int workspaceId, Model model) {
		Workspace selectedWorkspace = workspaceService.getWorkspaceById(workspaceId);
		List<WorkspaceTeamUser> teamUserList = teamRoleService.getWorkspaceTeamList(workspaceId);
		WorkspaceTeamUser owner = null;
		for(WorkspaceTeamUser user : teamUserList) {
			if(user.getRoleId()==3) {
				owner = user;
				break;
			}
		}
		model.addAttribute("selectedWorkspace", selectedWorkspace);
		model.addAttribute("teamUserList", teamUserList);
		model.addAttribute("owner", owner);
		
		return "workspace";
	}
	
	@GetMapping("/{workspaceId}/kanban")
	public String workspaceKanban() {
		return "home"; //워크스페이스 칸반 페이지로 변경하기
	}
	
	@GetMapping("/{workspaceId}/board")
	public String workspaceBoard() {
		return "home"; //워크스페이스 게시판 페이지로 변경하기
	}
	
	@GetMapping("/empty")
	public String emptyWorkspace() {
		return "empty";
	}
	
	//워크스페이스 생성
	@PostMapping("")
	public String createWorkspace(@ModelAttribute Workspace workspace, HttpServletRequest request, RedirectAttributes redirectAttributes) {
	    HttpSession session = request.getSession();
	    int userId = (int) session.getAttribute("userId");
	    int workspaceId = workspaceService.createWorkspace(workspace);
	    TeamRole teamRole = new TeamRole(userId, workspaceId,  3);
	    teamRoleService.createWorkspaceOwner(teamRole);
	    redirectAttributes.addAttribute("workspaceId", workspaceId);
	    return "redirect:/workspace/{workspaceId}";
	}
	
//	// main
//	@GetMapping("/main")
//    public String login(Model model, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//	    int userId = (int) session.getAttribute("userId");
//		String path=null;
//    	List<Workspace> workspaceList =  workspaceService.getWorkspaceList(userId);
//    	if (workspaceList != null && !workspaceList.isEmpty()) path = "redirect:/workspace/" + workspaceList.get(0).getWorkspaceId();
//        else path = "redirect:/workspace/empty";
//        return path;
//    }	
	
	
	
}