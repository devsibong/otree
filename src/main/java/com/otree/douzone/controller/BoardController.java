package com.otree.douzone.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.otree.douzone.dto.Board;
import com.otree.douzone.dto.BoardComment;
import com.otree.douzone.dto.BoardFile;
import com.otree.douzone.service.BoardCommentService;
import com.otree.douzone.service.BoardFileService;
import com.otree.douzone.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardCommentService boardCommentService;
	
	@Autowired
	private BoardFileService boardFileService;
	
	
	//왼쪽의 게시판 배너 클릭했을때
	@GetMapping("/getBoardList")
	public String getBoardList(Model model) {
		List<Board> boardList = null;
		int boardCount = boardService.getBoardCount();
		boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		return "board"; 
	}
	
	//게시글 눌렀을때
	@GetMapping("/getBoardDetail")
	public String getBoardDetail(@RequestParam("boardId") int boardId,Model model) {
		Board board = boardService.getBoardByBoardId(boardId);
		List<BoardComment> boardCommentList = boardCommentService.getCommentList(boardId);
		List<BoardFile> boardFile = boardFileService.getFile(boardId);
		model.addAttribute("boardDetail",board);
		model.addAttribute("boardFileList", boardFile);
		model.addAttribute("boardCommentList",boardCommentList);
		System.out.println(boardId);
		return "board2"; 
	}
	
	//detail들어가서 목록 눌렀을때 
	@GetMapping("/getBoardList2")
	public String getBoardList2() {
		return "redirect:getBoardList"; 
	}
	
	//글쓰기 버튼 눌렀을때
	@GetMapping("/createBoard")
	public String createBoard() {
		return "boardregisterform"; 
	}
		
	// 글양식, 파일첨부 후 등록 버튼 눌렀을때 
	//form action="" method =post
	@PostMapping("/createBoard")
	public String createBoard2(@RequestBody Board board) {
		System.out.println("controller : "+board);
		//boolean result = false;
		//String pathResult = null;
		boardService.createBoard(board);
		//System.out.println("?? : "+result);
//	
//		if (result==true) {
//			pathResult = "login"; //성공시 redirect : /BoardList/getBoardList
//		}
//		else {
//			pathResult = "login"; //실패시 boardregisterform
//		}
		
		return "boardlist"; //pathResult 페이지로 수정하기
		
	}
	
	//board detial 에서 update 버튼 눌렀을때
	@GetMapping("/updateBoard")
	public String modifyBoard() {
		return "login"; // boardupdateform
	}
	
	//update form에서 수정완료 눌렀을때 
	@PostMapping("/updateBoard")
	public String modifyBoard2(Board board,Model model) {
		boolean result = false;
		String pathResult = null;
		result = boardService.modifyBoard(board);
		if (result==true) {
			pathResult = "login"; //성공시 redirect : /Board/getBoardDetail
			model.addAttribute("modifyBoard",boardService.getBoardByBoardId(board.getBoardId()));   
		}
		else {
			pathResult = "login"; //실패시 boardupdateform 
		}
		return pathResult;
	}
	
	//board detail에서 delete 버튼 눌렀을때
	@GetMapping("/deleteBoard")
	public String removeBoard(@RequestParam("boardId") int boardId) {
		boolean result = false;
		String pathResult = null;
		result = boardService.removeBoard(boardId);
		if(result==true) {
			pathResult = "login"; //성공시redirect:/Board/getBoardList
		}
		else {
			pathResult = "login"; //실패시 boardupdateform
		}
		
		return "pathResult"; 
		
		
	}
	
}









