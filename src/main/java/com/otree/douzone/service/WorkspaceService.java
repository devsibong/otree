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
	public int createWorkspace (Workspace workspace) {
		int workspaceId = -1;
		try {
			WorkspaceDao workspaceDao = sqlsession.getMapper(WorkspaceDao.class);
			workspaceDao.insertWorkspace(workspace);
			workspaceId = workspace.getWorkspaceId();
			System.out.println("WorkspaceService:inserted-workspaceId "+workspaceId);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return workspaceId;
	}
	
	// 유저의 전체 워크스페이스 목록 조회 
	public List<Workspace> getWorkspaceList(int userId) {
		List<Workspace> workspaceList = null;
		try {
			System.out.println("Workspace Service 진입");
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
	public void modifyWorkspace (Workspace workspace) {
		try {
			WorkspaceDao workspaceDao = sqlsession.getMapper(WorkspaceDao.class);
			workspaceDao.updateWorkspace(workspace);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 특정 워크스페이스 삭제 
	public void removeWorkspace (int workspaceId) {
		int result = 0;
		try {
			WorkspaceDao workspaceDao = sqlsession.getMapper(WorkspaceDao.class);
			result = workspaceDao.deleteWorkspace(workspaceId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("service result : "+ result);
	}

}