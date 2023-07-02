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

import com.otree.douzone.dto.OtreeUser;
import com.otree.douzone.dto.TeamRole;
import com.otree.douzone.dto.Workspace;
import com.otree.douzone.service.MemberService;
import com.otree.douzone.service.TeamRoleService;

@RestController
@RequestMapping("/teamrole")
public class TeamRoleRestController {
	@Autowired
	private TeamRoleService teamRoleService;
	
	@Autowired
	private MemberService memberService;

	/*
	// 워크스페이스 팀원 초대 : 닉네임으로
	@PostMapping
	public ResponseEntity<String> createTeamRoleByName(@RequestBody String userName) {
		System.out.println("userName: " + userName);
		// 이름을 받으면 user 검색후 아이디 받아오기
		OtreeUser otreeUser = memberService.getOtreeUserListByName(userName);
		// 받아온 아이디와 워크스페이스 아이디로 insert
		
		teamRoleService.createTeamRoleByName(userName);
		System.out.println("insert성공");
		// userid, workspaceid, role:owner insert
		return ResponseEntity.status(HttpStatus.CREATED).body("insert success");
	}
	*/
	
	// 워크스페이스 팀원 초대 : 이메일로
	@PostMapping("/{workspaceId}")
	public ResponseEntity<String> createTeamRoleByEmail(@RequestBody OtreeUser otreeuser, @PathVariable("workspaceId") int workspaceId) {
		// 이름을 받으면 user 검색후 아이디 받아오기
		OtreeUser otreeUser = memberService.getOtreeUserByEmail(otreeuser.getEmail());
		// 받아온 아이디와 워크스페이스 아이디로 insert
		TeamRole teamRole = new TeamRole(otreeUser.getUserId(), workspaceId,  2);
		teamRoleService.createWorkspaceOwner(teamRole);
		return ResponseEntity.status(HttpStatus.CREATED).body("insert success");
	}
	

	
}