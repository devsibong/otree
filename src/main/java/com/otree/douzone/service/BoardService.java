package com.otree.douzone.service;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otree.douzone.dao.BoardCommentDao;
import com.otree.douzone.dao.BoardDao;
import com.otree.douzone.dao.BoardFileDao;
import com.otree.douzone.dao.EmpDao;
import com.otree.douzone.dto.Board;
import com.otree.douzone.dto.BoardComment;
import com.otree.douzone.dto.BoardFile;
import com.otree.douzone.dto.Emp;


@Service
public class BoardService {

	SqlSession sqlsession;
	
	@Autowired
	public BoardService(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	//(C)게시글 생성
	public boolean createBoard(Board board) {
		System.out.println("BoardService: "+board);
		boolean result = false;
		try {
			BoardDao boardDao = sqlsession.getMapper(BoardDao.class);
			boardDao.insertBoard(board);
			System.out.println("확인 : "+board);
			result = true;
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();		
		}
		return result;
	}
	
	//(R) 페이징 처리 조회에 필요한 method 
	public int getBoardCount(String field, String query) {
		int result = 0;
		try {
			BoardDao boardDao = sqlsession.getMapper(BoardDao.class);
			result = boardDao.getBoardCount(field, query);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();		
		}
		
		return result;
	}
	
	
	//(R) 페이징 처리 조회
	public List<Board> getBoardListForPaging(int page, String field, String query){
		List<Board> boardList = null;
		try {
			BoardDao boardDao = sqlsession.getMapper(BoardDao.class);
			boardList = boardDao.getBoardListForPaging(page,field,query);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();		
		}
		return boardList;
	}
	
	
	//(R) 첫화면 가져오기
	public List<Board> getBoardList() {
		List<Board> boardList = null;
		try {
			BoardDao boardDao = sqlsession.getMapper(BoardDao.class);
			boardList = boardDao.getBoardList();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();		
		}
		return boardList;
		}
	
	
	//(R) boardTitle로 게시물 검색
		public List<Board> getBoardListByBoardTitle(String boardTitle){
		List<Board> listBoard = null;
		try {
			BoardDao boardDao = sqlsession.getMapper(BoardDao.class);
			listBoard = boardDao.getBoardByBoardTitle(boardTitle);
		} catch(SQLException e) {
			System.out.println("");
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		return listBoard;
		}
	
	
	// (R) boardId로 상세조회 ( 게시글 클릭)
		public Board getBoardByBoardId(int boardId) {
		Board board = null;
		try {
			BoardDao boardDao = sqlsession.getMapper(BoardDao.class);
			board = boardDao.getBoardByBoardId(boardId);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();		
		}
		return board;
	}
		
		
		// (U) 게시글 수정 상세 조회 후 수정버튼 있음.
		public boolean modifyBoard(Board board) {
			boolean result = false;
			try {
				BoardDao boardDao = sqlsession.getMapper(BoardDao.class);
				boardDao.updateBoard(board);
				result = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			return result;
		}
	
	//(D) 게시글 삭제 
	public boolean removeBoard(int boardId) {
		boolean result = false;
		try {
			BoardDao boardDao = sqlsession.getMapper(BoardDao.class);
			boardDao.deleteBoard(boardId);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
}
