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
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	//Board table 기능

	//(C)글 생성
	public boolean createBoard(Board board) {
		boolean result = false;
		try {
			BoardDao boardDao = sqlsession.getMapper(BoardDao.class);
			boardDao.insertBoard(board);
			result = true;
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();		
		}
		return result;
	}
	
	
	
	//(R)게시판 글 전체개수 조회, 페이징 처리 조회
	
	
	
	//(R) 페이징 없이 전체 조회
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
			System.out.println("1111111111111111");
			System.out.println("2222222222222222");
		List<Board> listBoard = null;
		System.out.println("3333333333333333");
		try {
			BoardDao boardDao = sqlsession.getMapper(BoardDao.class);
			System.out.println("4444444444444444");
			listBoard = boardDao.getBoardByBoardTitle(boardTitle);
			System.out.println("5555555555555555");
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
	
	//(D) 삭제
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
	
	//Boardfile 기능
	
	//(C) 글쓰기 할때 파일 리스트 파라미터 입력받고 파일 삽입.
	// 여기서 파일첨부 갖고 놀아야됨.
	public boolean createFile(List<BoardFile> list) {
		boolean result = false;
		try {
			BoardFileDao boardFileDao = sqlsession.getMapper(BoardFileDao.class);
			boardFileDao.insertFile(list);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return result;
	}
	
	//(R)
	// 게시판 상세보기 눌렀을 때 파일 리스트 가져오기
	public List<BoardFile> getFile(int boardId)  {
		List<BoardFile> listBoardFile = null;
		try {
			BoardFileDao boardFileDao = sqlsession.getMapper(BoardFileDao.class);
			listBoardFile = boardFileDao.getFile(boardId);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return listBoardFile;
	}
	
	//(U)
	// 글쓴 유저가 본인 글  게시판 상세보기 누른 후 첨부파일 업데이트(수정)
	public boolean modifyFile(BoardFile boardfile)  {
		boolean result = false;
		List<BoardFile> listBoardFile = null;
		try {
			BoardFileDao boardFileDao = sqlsession.getMapper(BoardFileDao.class);
			boardFileDao.updateFile(boardfile);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return result;
	}
	
	//(D)
	// 글쓴 유저가 본인 글 게시판 상세보기 누른 후 글 삭제
	public boolean removeFile(int fileId)  {
		boolean result = false;
		try {
			BoardFileDao boardFileDao = sqlsession.getMapper(BoardFileDao.class);
			boardFileDao.deleteFile(fileId);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return result;
	}
	
	//BoardComment 기능
	//C
	// 게시글 상세조회 후 댓글 작성시 
	public boolean createComment(BoardComment boardcomment) {
		boolean result = false;
		try {
			BoardCommentDao boardCommentDao = sqlsession.getMapper(BoardCommentDao.class);
			boardCommentDao.insertComment(boardcomment);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return result;
	}
		
	//R
	// 게시글 상세조회시 DB에 들어있던 댓글정보 가져오기
	public List<BoardComment> getComment(int boardId) {
		List<BoardComment> listBoardComment = null;
		try {
			BoardCommentDao boardCommentDao = sqlsession.getMapper(BoardCommentDao.class);
			listBoardComment  = boardCommentDao.getComment(boardId);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return listBoardComment;
	}
	
	//U
	//게시글 상세조회 후 기존에 있던 댓글 수정
	public boolean modifyComment(String boardComment, int commentId) {
		boolean result = false;
		try {
			BoardCommentDao boardCommentDao = sqlsession.getMapper(BoardCommentDao.class);
			boardCommentDao.updateComment(boardComment,commentId);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return result;
	}
	
	
	//D
	//게시글 상세조회 후 기존 댓글 삭제
	public boolean removeComment(int boardId) {
		boolean result = false;
		try {
			BoardCommentDao boardCommentDao = sqlsession.getMapper(BoardCommentDao.class);
			boardCommentDao.deleteComment(boardId);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return result;
	}
	
	
	
	//예제 
	public boolean updateEmp(Emp emp) {
		boolean result = false;
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			empDao.updateEmp(emp);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean deleteEmp(int empno) {
		boolean result = false;
        try {
        	EmpDao empDao = sqlsession.getMapper(EmpDao.class);
            empDao.deleteEmp(empno);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
	
	public boolean insertEmp(Emp emp) {
		boolean result = false;
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			empDao.insertEmp(emp);
			result = true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;		
	}
	
	public List<Emp> searchEmpByName(String name) {
		List<Emp> empList = null;
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			empList = empDao.searchEmpByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}
	
	
}
