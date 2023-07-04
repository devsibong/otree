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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otree.douzone.dto.Board;
import com.otree.douzone.dto.BoardComment;
import com.otree.douzone.dto.BoardCommentVO;
import com.otree.douzone.service.BoardCommentService;
import com.otree.douzone.service.BoardService;

// 게시판 댓글 처리를 위한 비동기 컨트롤러
@RestController 
@RequestMapping("test")
public class BoardCommentRestController {

	private BoardCommentService boardCommentService;
	
	
	@Autowired
	public BoardCommentRestController(BoardCommentService boardCommentService) {
		this.boardCommentService = boardCommentService;
	}
	
	//댓글 삽입 후 list 가져오기
	@PostMapping
	public ResponseEntity<List<BoardCommentVO>> createBoardComment(@RequestBody BoardComment boardComment) {
		List<BoardCommentVO> boardCommentList = null;
		try {
			boardCommentService.createComment(boardComment);  
			boardCommentList = boardCommentService.getCommentListVO(boardComment.getBoardId()); // 성공시 boardCommentList return 
			return new ResponseEntity<List<BoardCommentVO>>(boardCommentList, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<List<BoardCommentVO>>(boardCommentList, HttpStatus.BAD_REQUEST); // 실패시 null 기존 페이지에 list있을테니.
	}
	}
	
//	//댓글 삽입 후 obj 가져오기
//		@PostMapping
//		public ResponseEntity<BoardCommentVO> createBoardComment(@RequestBody BoardComment boardComment) {
//			BoardCommentVO boardCommentVO = null;
//			try {
//				boardCommentService.createComment(boardComment);  
//				boardCommentVO = boardCommentService.getCommentVO(boardComment.getBoardId()); 
//				return new ResponseEntity<BoardCommentVO>(boardCommentVO, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<BoardCommentVO>(boardCommentVO, HttpStatus.BAD_REQUEST); 
//		}
//		}
	
	
	
	//댓글 수정 누른 comment id를 통해 댓글 가져오기
	@GetMapping
	public ResponseEntity<BoardCommentVO> getBoardComment(@RequestParam("param") int commentId) {
		BoardCommentVO boardCommentVO = null;
		try {
			boardCommentVO = boardCommentService.getCommentVO(commentId); // 성공시 boardCommentList return 
			return new ResponseEntity<BoardCommentVO>(boardCommentVO, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<BoardCommentVO>(boardCommentVO, HttpStatus.BAD_REQUEST); // 실패시 null 기존 페이지에 list있을테니.
	}
	}
	
	
	// 댓글 수정 후 성공시 수정된 댓글  return
	@PutMapping
	public ResponseEntity<BoardCommentVO> modifyBoard(@RequestBody BoardComment boardComment) {
		BoardCommentVO boardComment1 = null;
		try {
			boardCommentService.modifyComment(boardComment.getBoardComment(), boardComment.getCommentId());
			boardComment1 = boardCommentService.getCommentVO(boardComment.getCommentId());
			return new ResponseEntity<BoardCommentVO>(boardComment1, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<BoardCommentVO>(boardComment1, HttpStatus.BAD_REQUEST);
	}
	}
	
	
	//댓글 삭제하기 후 성공시 삭제한 list return
	@DeleteMapping
	public ResponseEntity<List<BoardCommentVO>> deleteBoard(@RequestParam("commentId") int commentId, @RequestParam("boardId")int boardId) {
		List<BoardCommentVO> boardCommentList = null;
		try {
			boardCommentService.removeComment(commentId);
			boardCommentList = boardCommentService.getCommentListVO(boardId);
			return new ResponseEntity<List<BoardCommentVO>>(boardCommentList, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<List<BoardCommentVO>>(boardCommentList, HttpStatus.BAD_REQUEST);
	}
}
	
	
}

