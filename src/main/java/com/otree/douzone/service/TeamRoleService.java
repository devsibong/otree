package com.otree.douzone.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otree.douzone.dao.TeamRoleDao;
import com.otree.douzone.dao.WorkspaceDao;
import com.otree.douzone.dto.TeamRole;
import com.otree.douzone.dto.WorkspaceTeamUser;

@Service
public class TeamRoleService {
	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	// OtreeuserWorkspace는 워크스페이스 구성원을 정의하는 테이블이다. 
	
	// 워크스페이스 소유자 등록
	public void createWorkspaceOwner (TeamRole teamRole) {
		try {
			TeamRoleDao teamRoleDao = sqlsession.getMapper(TeamRoleDao.class);
			teamRoleDao.insertTeamRole(teamRole);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 워크스페이스 멤버 등록 : 닉네임으로
	public void createTeamRoleByName (TeamRole teamRole) {
		try {
			TeamRoleDao teamRoleDao = sqlsession.getMapper(TeamRoleDao.class);
			teamRoleDao.insertTeamRole(teamRole);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 워크스페이스 팀원 목록 조회 
	public List<WorkspaceTeamUser> getWorkspaceTeamList(int workspaceId) {
		List<WorkspaceTeamUser> workspaceTeamList = null;
		try {
			TeamRoleDao teamRoleDao = sqlsession.getMapper(TeamRoleDao.class);
			workspaceTeamList = teamRoleDao.selectWorkspaceTeamList(workspaceId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return workspaceTeamList;
	}
	
	// 특정 워크스페이스 특정 유저 정보 삭제 : 워크스페이스 강퇴
	public void removeUser (int workspaceId, int userId) {
		int result = 0;
		try {
			TeamRoleDao teamRoleDao = sqlsession.getMapper(TeamRoleDao.class);
			result = teamRoleDao.deleteTeamRole(workspaceId, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}