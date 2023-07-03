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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otree.douzone.dto.OtreeUser;
import com.otree.douzone.dto.TeamRole;
import com.otree.douzone.dto.WorkspaceTeamUser;
import com.otree.douzone.service.MemberService;
import com.otree.douzone.service.TeamRoleService;

@RestController
@RequestMapping("/teamrole")
public class TeamRoleRestController {
	@Autowired
	private TeamRoleService teamRoleService;
	
	@Autowired
	private MemberService memberService;

	// 워크스페이스 팀원 초대 : 닉네임
	@PostMapping
	public ResponseEntity<String> createTeamRoleByName(@RequestBody OtreeUser otreeuser, @PathVariable("workspaceId") int workspaceId) {
		// 사용자가 이름검색 > 클릭 > getUserListByName에서 클릭한 객체의 아이디 보내주기!
		// 받아온 아이디와 워크스페이스 아이디로 insert
		TeamRole teamRole = new TeamRole(otreeuser.getUserId(), workspaceId,  2);
		teamRoleService.createWorkspaceOwner(teamRole);
		return ResponseEntity.status(HttpStatus.CREATED).body("insert success");
	}
	
	// 워크스페이스 팀원 초대 : 이메일
	@PostMapping("/{workspaceId}")
	public ResponseEntity<String> createTeamRoleByEmail(@RequestBody OtreeUser otreeuser, @PathVariable("workspaceId") int workspaceId) {
		// 이름을 받으면 user 검색후 아이디 받아오기
		OtreeUser otreeUser = memberService.getOtreeUserByEmail(otreeuser.getEmail());
		// 받아온 아이디와 워크스페이스 아이디로 insert
		TeamRole teamRole = new TeamRole(otreeUser.getUserId(), workspaceId,  2);
		teamRoleService.createWorkspaceOwner(teamRole);
		return ResponseEntity.status(HttpStatus.CREATED).body("insert success");
	}
	
	// 워크스페이스 팀원 리스트 조회
	@GetMapping("/{workspaceId}")
	public ResponseEntity<List<WorkspaceTeamUser>> getWorkspaceTeamList (@PathVariable("workspaceId") int workspaceId) {
		List<WorkspaceTeamUser> workspaceTeamList = teamRoleService.getWorkspaceTeamList(workspaceId);
		//System.out.println("select성공 : "+ workspaceTeamList);
		return ResponseEntity.status(HttpStatus.OK).body(workspaceTeamList);
	}
	
	// 워크스페이스 팀원 삭제(추방)
	@DeleteMapping("/{workspaceId}")
	public ResponseEntity<Map<String,String>> removeTeamRole(@PathVariable("workspaceId") int workspaceId, @RequestBody Map<String, Integer> requestBody) {
		int userId = requestBody.get("removeId");
		teamRoleService.removeUser(workspaceId, userId);
		Map<String, String> response = new HashMap<>();
		response.put("message", "success");
		return ResponseEntity.ok(response);
	}
	
}