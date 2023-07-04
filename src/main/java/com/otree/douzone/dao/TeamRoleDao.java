package com.otree.douzone.dao;

import java.sql.SQLException;
import java.util.List;

import com.otree.douzone.dto.TeamRole;
import com.otree.douzone.dto.WorkspaceTeamUser;

public interface TeamRoleDao {
	public void insertTeamRole(TeamRole teamRole) throws SQLException;
	public List<WorkspaceTeamUser> selectWorkspaceTeamList(int workspaceId) throws SQLException;
	public int deleteTeamRole(int workspaceId, int userId) throws SQLException;
}