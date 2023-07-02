package com.otree.douzone.dao;

import java.sql.SQLException;
import java.util.List;

import com.otree.douzone.dto.Task;
import com.otree.douzone.dto.TaskWithStatus;

public interface TaskDao {
	public void insertTask(Task task) throws SQLException;
	public List<TaskWithStatus> selectTaskList(int workspaceId) throws SQLException;
	public TaskWithStatus selectTaskById(int taskId) throws SQLException;
	public void updateTask(Task task) throws SQLException;
	public int deleteTask(int taskId) throws SQLException;
}