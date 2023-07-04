package com.otree.douzone.controller;

import java.util.ArrayList;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

//	// 워크스페이스 팀원 초대 : 닉네임
//	@PostMapping
//	public ResponseEntity<String> createTeamRoleByName(@RequestBody OtreeUser otreeuser, @PathVariable("workspaceId") int workspaceId) {
//		// 사용자가 이름검색 > 클릭 > getUserListByName에서 클릭한 객체의 아이디 보내주기!
//		// 받아온 아이디와 워크스페이스 아이디로 insert
//		TeamRole teamRole = new TeamRole(otreeuser.getUserId(), workspaceId,  2);
//		teamRoleService.createWorkspaceOwner(teamRole);
//		return ResponseEntity.status(HttpStatus.CREATED).body("insert success");
//	}
	
	// 워크스페이스 팀원 초대 : 이메일
	@PostMapping("/{workspaceId}")
	public ResponseEntity<Map<String,String>> createTeamRoleByName(@PathVariable("workspaceId") int workspaceId, @RequestBody Map<String, Integer> requestBody) {
		int userId = requestBody.get("userId");
		TeamRole teamRole = new TeamRole(userId, workspaceId,  2);
		teamRoleService.createWorkspaceOwner(teamRole);
		Map<String, String> response = new HashMap<>();
		response.put("message", "success");
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{workspaceId}")
	public ResponseEntity<Map<String,Object>> getWorkspaceTeamList (@PathVariable("workspaceId") int workspaceId) {
	    List<WorkspaceTeamUser> workspaceTeamList = teamRoleService.getWorkspaceTeamList(workspaceId);
	    WorkspaceTeamUser owner = null;
	    for(WorkspaceTeamUser user : workspaceTeamList) {
	        if(user.getRoleId()==3) {
	            owner = user;
	            break;
	        }
	    }
	    List<WorkspaceTeamUser> memberList = new ArrayList<>(workspaceTeamList);
	    memberList.remove(owner);

	    Map<String, Object> response = new HashMap<>();
	    response.put("owner", owner);
	    response.put("memberList", memberList);

	    return ResponseEntity.ok(response);
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
	

    @PostMapping("/{workspaceId}/search")
	public ResponseEntity<Map<String, Object>> getMemberByName(@PathVariable int workspaceId, @RequestBody Map<String, String> requestBody) {
		String searchName = requestBody.get("searchKeyword");
		List<OtreeUser> userList = memberService.getOtreeUserListByName(searchName, workspaceId);
		ObjectMapper objectMapper = new ObjectMapper();
		String json;
		try {
			json = objectMapper.writeValueAsString(userList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("message", "Error occurred during JSON serialization");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}

		Map<String, Object> response = new HashMap<>();
		response.put("message", "success");
		response.put("data", json);

		return ResponseEntity.ok(response);
	}
	
	
}