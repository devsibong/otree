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
public class BoardCommentService {

	SqlSession sqlsession;
	@Autowired
	public BoardCommentService(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
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
		public List<BoardComment> getCommentList(int boardId) {
			List<BoardComment> listBoardComment = null;
			try {
				BoardCommentDao boardCommentDao = sqlsession.getMapper(BoardCommentDao.class);
				listBoardComment  = boardCommentDao.getCommentList(boardId);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			return listBoardComment;
		}
		
		//R
		//댓글 ID로 댓글가져오기
		public BoardComment getComment(int commentId) {
			BoardComment BoardComment = null;
			try {
				BoardCommentDao boardCommentDao = sqlsession.getMapper(BoardCommentDao.class);
				BoardComment  = boardCommentDao.getComment(commentId);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			return BoardComment;
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
		public boolean removeComment(int CommentId) {
			boolean result = false;
			try {
				BoardCommentDao boardCommentDao = sqlsession.getMapper(BoardCommentDao.class);
				boardCommentDao.deleteComment(CommentId);
				result = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			return result;
		}
	
	
}
