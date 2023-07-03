package com.otree.douzone.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otree.douzone.dto.Task;
import com.otree.douzone.dto.TaskWithStatus;
import com.otree.douzone.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskRestController {
	
	private TaskService taskService;
	
	@Autowired
	public TaskRestController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	// 칸반 업무 생성
	@PostMapping
	public ResponseEntity<Map<String,String>> createTask(@RequestBody Task task) {
		//System.out.println("task : " + task);
		taskService.createTask(task);
		Map<String, String> response = new HashMap<>();
		response.put("message", "success");
		return ResponseEntity.ok(response);
	}
	
	// 워크스페이스의 전체 칸반 업무 목록 조회 
	//"taskSeq": 2,
    //"statusId": 1,
	@GetMapping("/list/{workspaceId}")
	public ResponseEntity<List<TaskWithStatus>> getTaskList (@PathVariable("workspaceId") int workspaceId) {
		//System.out.println("workspaceId : " + workspaceId);
		List<TaskWithStatus> taskWithStatusList = taskService.getTaskList(workspaceId);
		//System.out.println("워크스페이스의 전체 칸반 업무 목록 조회 성공");
		return ResponseEntity.status(HttpStatus.OK).body(taskWithStatusList);
	}
	
	// 특정 칸반 업무 정보 조회 
	@GetMapping("/{taskId}")
	public ResponseEntity<TaskWithStatus> getTaskById (@PathVariable("taskId") int taskId) {
		//System.out.println("taskId : " + taskId);
		TaskWithStatus taskWithStatus = taskService.getTaskById(taskId);
		//System.out.println("특정 칸반 업무 정보 조회 성공");
		return ResponseEntity.status(HttpStatus.OK).body(taskWithStatus);
	}
	
	// 특정 칸반 업무 정보 수정
	@PutMapping("/modify")
	public ResponseEntity<Map<String,String>> modifyTask(@RequestBody Map<String, String> requestBody) {
		int taskId = Integer.parseInt(requestBody.get("taskId"));
		int taskSeq = Integer.parseInt(requestBody.get("taskSeq"));
		int statusId = Integer.parseInt(requestBody.get("statusId"));
		Task task = new Task();
		task.setTaskId(taskId);
		task.setTaskSeq(taskSeq);
		task.setStatusId(statusId);
		taskService.modifyTaskSeq(task);
		Map<String, String> response = new HashMap<>();
		response.put("message", "success");
		return ResponseEntity.ok(response);
	}
	
	// 특정 칸반 순서변경 (Drag&Drop - taskSeq update) --------------------------------------
//	@PutMapping
//	public ResponseEntity<String> modifyTaskSeq(@RequestBody List<Task> taskList ) {
//		System.out.println("taskList : " + taskList);
//		taskService.modifyTaskSeq(task);
//		System.out.println("update성공");
//		return ResponseEntity.status(HttpStatus.OK).body("update success");
//	}
	//--------------------------------------------------------------------------------------
	
	// 특정 칸반 업무 삭제 
	@DeleteMapping("/{taskId}")
	public ResponseEntity<String> removeTask(@PathVariable("taskId") int taskId) {
		//System.out.println("taskId : " + taskId);
		taskService.removeTask(taskId);
		//System.out.println("delete성공");
		return ResponseEntity.status(HttpStatus.OK).body("delete success");
	}
	
}