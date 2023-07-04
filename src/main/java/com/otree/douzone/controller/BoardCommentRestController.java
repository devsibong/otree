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
import com.otree.douzone.service.BoardCommentService;
import com.otree.douzone.service.BoardService;

// �Խ��� ��� ó���� ���� �񵿱� ��Ʈ�ѷ�
@RestController 
@RequestMapping("test")
public class BoardCommentRestController {

	private BoardCommentService boardCommentService;
	
	
	@Autowired
	public BoardCommentRestController(BoardCommentService boardCommentService) {
		this.boardCommentService = boardCommentService;
	}
	
	//��� ���� �� list ��������
	@PostMapping
	public ResponseEntity<List<BoardComment>> createBoardComment(@RequestBody BoardComment boardComment) {
		List<BoardComment> boardCommentList = null;
		System.out.println("1111111111111111111111");
		System.out.println("2222222222222222222222");
		System.out.println("3333333333333333333333");
		System.out.println("4444444444444444444444");
		System.out.println("55555555555555555555555");
		try {
			boardCommentService.createComment(boardComment);  
			boardCommentList = boardCommentService.getCommentList(boardComment.getBoardId()); // ������ boardCommentList return 
			return new ResponseEntity<List<BoardComment>>(boardCommentList, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<List<BoardComment>>(boardCommentList, HttpStatus.BAD_REQUEST); // ���н� null ���� �������� list�����״�.
	}
	}
	
	//��� ���� ���� comment id�� ���� ��� ��������
	@GetMapping
	public ResponseEntity<BoardComment> getBoardComment(@RequestParam("param") int commentId) {
		BoardComment boardComment = null;
		System.out.println("1111111111111111111111");
		System.out.println("2222222222222222222222");
		System.out.println("3333333333333333333333");
		System.out.println("4444444444444444444444");
		System.out.println("55555555555555555555555");
		try {
			boardComment = boardCommentService.getComment(commentId); // ������ boardCommentList return 
			return new ResponseEntity<BoardComment>(boardComment, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<BoardComment>(boardComment, HttpStatus.BAD_REQUEST); // ���н� null ���� �������� list�����״�.
	}
	}
	
	
	
	// ��� ���� �� ������ ������ list return
	@PutMapping
	public ResponseEntity<BoardComment> modifyBoard(@RequestBody BoardComment boardComment) {
		BoardComment boardComment1 = null;
		System.out.println("1111111111111111111111");
		System.out.println("2222222222222222222222");
		System.out.println("3333333333333333333333");
		System.out.println("4444444444444444444444");
		System.out.println("55555555555555555555555");
		try {
			boardCommentService.modifyComment(boardComment.getBoardComment(), boardComment.getCommentId());
			boardComment1 = boardCommentService.getComment(boardComment.getCommentId());
			return new ResponseEntity<BoardComment>(boardComment1, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<BoardComment>(boardComment1, HttpStatus.BAD_REQUEST);
	}
	}
	
	//��� �����ϱ� �� ������ ������ list return
	@DeleteMapping
	public ResponseEntity<List<BoardComment>> deleteBoard(@RequestParam("commentId") int commentId, @RequestParam("boardId")int boardId) {
		List<BoardComment> boardCommentList = null;
		System.out.println("1111111111111111111111");
		System.out.println("2222222222222222222222");
		System.out.println("3333333333333333333333");
		System.out.println("4444444444444444444444");
		System.out.println("55555555555555555555555");
		try {
			boardCommentService.removeComment(commentId);
			boardCommentList = boardCommentService.getCommentList(boardId);
			return new ResponseEntity<List<BoardComment>>(boardCommentList, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<List<BoardComment>>(boardCommentList, HttpStatus.BAD_REQUEST);
	}
}
	
	
}

