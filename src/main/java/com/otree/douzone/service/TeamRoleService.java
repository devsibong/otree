package com.otree.douzone.service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otree.douzone.dao.TeamRoleDao;
import com.otree.douzone.dto.TeamRole;

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
	
}