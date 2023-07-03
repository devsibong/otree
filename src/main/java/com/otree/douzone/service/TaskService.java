package com.otree.douzone.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otree.douzone.dao.TaskDao;
import com.otree.douzone.dto.Task;
import com.otree.douzone.dto.TaskWithStatus;

@Service
public class TaskService {
	private SqlSession sqlsession;
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	// 칸반 업무 생성
	public int createTask(Task task) {
		int taskId = -1;
		try {
			TaskDao taskDao = sqlsession.getMapper(TaskDao.class);
			taskDao.insertTask(task);
			taskId = task.getTaskId();
			System.out.println("TaskService:inserted-taskId "+taskId);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taskId;
	}
	
	// 워크스페이스의 전체 칸반 업무 목록 조회 
	public List<TaskWithStatus> getTaskList(int workspaceId) {
		List<TaskWithStatus> taskList = null;
		try {
			System.out.println("Task Service 진입");
			TaskDao taskDao = sqlsession.getMapper(TaskDao.class);
			taskList = taskDao.selectTaskList(workspaceId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taskList;
	}
	
	// 특정 칸반 업무 정보 조회 
	public TaskWithStatus getTaskById(int taskId) {
		TaskWithStatus taskWithStatus = null;
		try {
			TaskDao taskDao = sqlsession.getMapper(TaskDao.class);
			taskWithStatus = taskDao.selectTaskById(taskId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taskWithStatus;
	}
	
	// 특정 칸반 업무 정보 수정
	public void modifyTask (Task task) {
		try {
			TaskDao taskDao = sqlsession.getMapper(TaskDao.class);
			taskDao.updateTask(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 특정 칸반 업무 삭제 
	public void removeTask (int taskId) {
		int result = 0;
		try {
			TaskDao taskDao = sqlsession.getMapper(TaskDao.class);
			result = taskDao.deleteTask(taskId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("service result : "+ result);
	}

}