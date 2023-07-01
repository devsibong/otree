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

import com.otree.douzone.dto.Board;
import com.otree.douzone.dto.BoardComment;
import com.otree.douzone.service.BoardCommentService;
import com.otree.douzone.service.BoardService;

// 게시판 댓글 처리를 위한 비동기 컨트롤러
@RestController 
@RequestMapping("/BoardCommentRest")
public class BoardCommentRestController {

	private BoardCommentService boardCommentService;
	
	
	@Autowired
	public BoardCommentRestController(BoardCommentService boardCommentService) {
		this.boardCommentService = boardCommentService;
	}
	
	//댓글 삽입 후 list 가져오기
	@PostMapping
	public ResponseEntity<List<BoardComment>> createBoardComment(@RequestBody BoardComment boardComment) {
		List<BoardComment> boardCommentList = null;
		try {
			System.out.println("insert 실행");
			boardCommentService.createComment(boardComment);  
			boardCommentList = boardCommentService.getCommentList(boardComment.getBoardId()); // 성공시 boardCommentList return 
			return new ResponseEntity<List<BoardComment>>(boardCommentList, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<List<BoardComment>>(boardCommentList, HttpStatus.BAD_REQUEST); // 실패시 null 기존 페이지에 list있을테니.
	}
	}
	
	
	
	// 댓글 수정 후 성공시 수정된 list return
	@PutMapping
	public ResponseEntity<List<BoardComment>> modifyBoard(@RequestBody BoardComment boardComment) {
		List<BoardComment> boardCommentList = null;
		try {
			boardCommentService.modifyComment(boardComment.getBoardComment(), boardComment.getCommentId());
			boardCommentList = boardCommentService.getCommentList(boardComment.getBoardId());
			return new ResponseEntity<List<BoardComment>>(boardCommentList, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<List<BoardComment>>(boardCommentList, HttpStatus.BAD_REQUEST);
	}
	}
	
	//댓글 삭제하기 후 성공시 삭제한 list return
	@DeleteMapping
	public ResponseEntity<String> deleteBoard(@PathVariable("boardId") int boardId) {
		List<BoardComment> boardCommentList = null;
		try {
			boardCommentService.removeComment(boardId);
			boardCommentList = boardCommentService.getCommentList(boardId);
			return new ResponseEntity<String>("delete success", HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<String>("delete fail", HttpStatus.BAD_REQUEST);
	}
}
	
	
}

