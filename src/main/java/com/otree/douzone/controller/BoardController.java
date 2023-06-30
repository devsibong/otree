package com.otree.douzone.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.otree.douzone.dto.Board;
import com.otree.douzone.service.BoardFileService;
import com.otree.douzone.service.BoardService;

@Controller
@RequestMapping("/Board/")
public class BoardController {
	
	private BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
		
	//왼쪽의 게시판 배너 클릭했을때
	// 최초는 1번 페이지를 표시해야겠지만 . 그 이후 목록을 누르거나 글쓰기를 완료했거나 삭제를 완료했을때 혹은 취소를 눌렀을때 페이지 정보를 갖고가야한다.
	@GetMapping("/getBoardList")
	public String getBoardList(Model model) {
		
//		int page = boardService.getBoardCount(field, query);
//		boardService.getBoardListForPaging(page, field, query);
//		model.addAllAttributes(null);
		
		return "login"; //boardlist
	}
	
	//게시글 눌렀을때
	@GetMapping("/getBoardDetail")
	public String getBoardDetail(@RequestParam("boardId") int boardId,Model model) {
		Board board = boardService.getBoardByBoardId(boardId);
		model.addAttribute("boardDetail",board);
		return "login"; // boarddetail
	}
	
//	//detail들어가서 목록 눌렀을때 
//	// 필요한 정보들 해당 페이지, 최초의 글개수?? 그럼 중간에 누가글쓰면 어떻게 되는거지?
//	@GetMapping("/getBoardList2")
//	public String getBoardList2() {
//		
//		return "login"; //boardlist
//	}
	

	//글쓰기 버튼 눌렀을때
	@GetMapping("/createBoard")
	public String createBoard() {
		return "login"; //boardregisterform
	}
		
//	// 글양식, 파일첨부 후 등록 버튼 눌렀을때 
//	//form action="" method =post
//	@PostMapping("/createBoard")
//	public String createBoard2(Board board) {
//		boolean result = false;
//		String pathResult = null;
//		result = boardService.createBoard(board);
//	
//		if (result==true) {
//			pathResult = "login"; //성공시 redirect : /BoardList/getBoardList
//		}
//		else {
//			pathResult = "login"; //실패시 boardregisterform
//		}
//		
//		return pathResult; // 
//		
//	}
	
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









