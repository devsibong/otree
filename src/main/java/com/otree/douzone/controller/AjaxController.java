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

import com.otree.douzone.dto.Emp;
import com.otree.douzone.service.EmpService;

@RestController
@RequestMapping("/emp")
public class AjaxController {

	private EmpService empService;
	
	@Autowired
	public AjaxController(EmpService empService) {
		this.empService = empService;
	}
	
	@GetMapping
	public ResponseEntity<List<Emp>> getEmpListResponseBody() {
		List<Emp> empList = empService.getEmpList();
		System.out.println(empList);
		return ResponseEntity.status(HttpStatus.OK).body(empList);
	}
	
	@PostMapping
    public ResponseEntity<String> createResponseBody(@RequestBody Emp emp) {
        empService.insertEmp(emp);
        return ResponseEntity.status(HttpStatus.CREATED).body("insert success");
    }
	
	@PutMapping("/{empno}")
	public ResponseEntity<String> updateEmpResponseBody(@PathVariable("empno") int empno, @RequestBody Emp updatedEmp) {
		empService.updateEmp(updatedEmp);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("update success");
	}
	
	@DeleteMapping("/{empno}")
	public ResponseEntity<String> deleteEmpResponseBody(@PathVariable("empno") int empno) {
		empService.deleteEmp(empno);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("delete success");
	}
	
	@GetMapping("/search/{name}")
	public ResponseEntity<List<Emp>> searchEmpByName(@PathVariable("name") String name) {
		System.out.println(name);
	    List<Emp> empList = empService.searchEmpByName(name);
	    return ResponseEntity.status(HttpStatus.OK).body(empList);
	}
}
