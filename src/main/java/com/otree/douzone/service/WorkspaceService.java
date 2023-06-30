package com.otree.douzone.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otree.douzone.dao.WorkspaceDao;
import com.otree.douzone.dto.Workspace;

@Service
public class WorkspaceService {
	private SqlSession sqlsession;
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	// 워크스페이스 생성
	public void createWorkspace (Workspace workspace) {
		try {
			WorkspaceDao workspaceDao = sqlsession.getMapper(WorkspaceDao.class);
			workspaceDao.insertWorkspace(workspace);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 유저의 전체 워크스페이스 목록 조회 
	public List<Workspace> getWorkspaceList(int userId) {
		List<Workspace> workspaceList = null;
		try {
			WorkspaceDao workspaceDao = sqlsession.getMapper(WorkspaceDao.class);
			workspaceList = workspaceDao.selectWorkspaceList(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workspaceList;
	}
	
	// 특정 워크스페이스 정보 조회 
	public Workspace getWorkspaceById(int workspaceId) {
		Workspace workspace = null;
		try {
			WorkspaceDao workspaceDao = sqlsession.getMapper(WorkspaceDao.class);
			workspace = workspaceDao.selectWorkspaceById(workspaceId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workspace;
	}
	
	// 특정 워크스페이스 정보 수정
	public void modifyWorkspace (int workspaceId, Workspace workspace) {
		try {
			WorkspaceDao workspaceDao = sqlsession.getMapper(WorkspaceDao.class);
			workspaceDao.updateWorkspace(workspaceId, workspace);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 특정 워크스페이스 삭제 
	public void removeWorkspace (int workspaceId) {
		try {
			WorkspaceDao workspaceDao = sqlsession.getMapper(WorkspaceDao.class);
			workspaceDao.deleteWorkspace(workspaceId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 특정 워크스페이스 유저한명 추가
	
	
	// 특정 워크스페이스 전체 유저 목록 조회
	
	
	// 특정 워크스페이스 특정 유저 정보 조회
	
	
	// 특정 워크스페이스 특정 유저 정보 수정
	
	
	// 특정 워크스페이스 특정 유저 정보 삭제
}