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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.otree.douzone.dto.Board;
import com.otree.douzone.dto.BoardComment;
import com.otree.douzone.dto.BoardFile;
import com.otree.douzone.dto.Workspace;
import com.otree.douzone.dto.WorkspaceTeamUser;
import com.otree.douzone.service.BoardCommentService;
import com.otree.douzone.service.BoardFileService;
import com.otree.douzone.service.BoardService;
import com.otree.douzone.service.TeamRoleService;
import com.otree.douzone.service.WorkspaceService;

@Controller
@RequestMapping("/workspace")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardCommentService boardCommentService;
	
	@Autowired
	private BoardFileService boardFileService;
	
	
	
	
	
	
	//������ �Խ��� ��� Ŭ��������
	@GetMapping("/{workspaceId}/board")
	public String getBoardList(@PathVariable("workspaceId") int workspaceId, Model model /*@RequestParam("workspaceId")int workspaceId2*/) {
		List<Board> boardList = null;
//		List<Board> boardList2 = null;
		boardList = boardService.getBoardList(workspaceId);
//		boardList2 = boardService.getBoardList(workspaceId2);
		model.addAttribute("boardList", boardList);
//		model.addAttribute("boardList2", boardList2);
		model.addAttribute("workspaceId", workspaceId);
		
		return "board"; 
	}
	
	//�Խñ� ��������
	@GetMapping("/{workspaceId}/getBoardDetail")
	public String getBoardDetail(@RequestParam("boardId") int boardId,Model model, @PathVariable("workspaceId") int workspaceId) {
		//readcount+1
		boardService.modifyBoardReadCount(boardId); 
		Board board = boardService.getBoardByBoardId(boardId);
		List<BoardComment> boardCommentList = boardCommentService.getCommentList(boardId);
		List<BoardFile> boardFile = boardFileService.getFile(boardId);
		model.addAttribute("boardDetail",board);
		model.addAttribute("boardFileList", boardFile);
		model.addAttribute("boardCommentList",boardCommentList);
		return "boarddetail"; 
	}
	

	
//	detail���� ��� �������� 
//	@GetMapping("/getBoardList2")
//	public String getBoardList2(@RequestParam int workspaceId) {
//		 String path = Integer.toString(workspaceId);
//		return "redirect:/"+path+"/getBoardList"; 
//	}
	
	//�۾��� ��ư ��������
	@GetMapping("/{workspaceId}/createBoard")
	public String createBoard(@PathVariable("workspaceId") int workspaceId, Model model) {
		model.addAttribute("workspaceId", workspaceId);
		return "boardregisterform"; 
	}
		
	// �۾��� ��Ϲ�ư ��������
	@PostMapping("/{workspaceId}/createBoard")
	public String createBoard2( Board board ,@PathVariable("workspaceId")int workspaceId ) {
		boolean result = false;
		String pathResult = null;
		board.setWorkspaceId(workspaceId);
		result = boardService.createBoard(board);
		 String path = Integer.toString(workspaceId);
		if (result==true) {
			pathResult = "redirect:/workspace/"+path+"/board";
		}
		else {
			pathResult = "boardregisterform";
		}
		return pathResult; 
		
	}
	
	//board detial ���� update ��ư ��������
	@GetMapping("/{workspaceId}/updateBoard")
	public String modifyBoard(Model model, @RequestParam("boardId")int boardId ) {
		Board board = boardService.getBoardByBoardId(boardId);
		model.addAttribute("board", board);
		return "boardupdateform"; 
	}
	
	//update form���� �����ϱ� �������� 
	@PostMapping("/{workspaceId}/updateBoardOk")
	public String modifyBoard2(Board board,Model model) {
		String param = Integer.toString(board.getBoardId());
		boolean result = false;
		String pathResult = null;
		result = boardService.modifyBoard(board);
		if (result==true) {
			pathResult = "redirect:getBoardDetail?boardId="+param; //������ redirect:boarddetail
			model.addAttribute("modifyBoard",boardService.getBoardByBoardId(board.getBoardId()));   
		}
		else {
			pathResult = "boardupdateform"; //���н�
		}
		return pathResult;
	}
	
	//board detail���� delete ��ư ��������
	@GetMapping("/{workspaceId}/deleteBoard")
	public String removeBoard(@RequestParam("boardId") int boardId, @PathVariable("workspaceId")int workspaceId) {
		String param = Integer.toString(boardId); 
		boolean result = false;
		String pathResult = null;
		result = boardService.removeBoard(boardId);
		String path = Integer.toString(workspaceId);
		if(result==true) {
			pathResult = "redirect:/workspace/"+path+"/board"; //������
		}
		else {
			pathResult = "redirect:getBoardDetail?boardId="+param; //���н� 
		}
		return pathResult; 
	}
}









