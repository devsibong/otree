package com.otree.douzone.dao;

import java.sql.SQLException;
import java.util.List;

import com.otree.douzone.dto.Workspace;

public interface WorkspaceDao {
	public void insertWorkspace(Workspace workspace) throws SQLException;
	public List<Workspace> selectWorkspaceList(int userId) throws SQLException;
	public Workspace selectWorkspaceById(int workspaceId) throws SQLException;
	public void updateWorkspace(Workspace workspace) throws SQLException;
	public void deleteWorkspace(int workspaceId) throws SQLException;
}
