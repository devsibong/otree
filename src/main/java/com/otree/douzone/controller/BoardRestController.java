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

import com.otree.douzone.dto.*;
import com.otree.douzone.service.BoardService;


@RestController 
@RequestMapping("/BoardRest/")
public class BoardRestController {

	private BoardService boardService;
	
	@Autowired
	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	// [1][2][3][4][5]이거 눌렀을때 페이징 처리한거 가져오기.
	@GetMapping
	public ResponseEntity<List<Board>> getBoardListForPaging(int page, String field, String query) {
		List<Board> boardList = null;
		try {
			boardList = boardService.getBoardListForPaging(page, field, query);
			return new ResponseEntity<List<Board>>(boardList,HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<List<Board>>(boardList,HttpStatus.BAD_REQUEST);
	}
	}
	
	//boardTitle로 검색하기
	@GetMapping("/{boardTitle}")
	public ResponseEntity<List<Board>> getBoardListByBoardTitle(@PathVariable("boardTitle") String boardTitle) {
		List<Board> boardList = null;
		
		try {
	    	boardList = boardService.getBoardListByBoardTitle(boardTitle);
	    	System.out.println(boardList);
			return new ResponseEntity<List<Board>>(boardList,HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<List<Board>>(boardList,HttpStatus.BAD_REQUEST);
	}
	}

	
	
	
}
