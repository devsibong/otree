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
public class BoardFileService {

	SqlSession sqlsession;
	
	@Autowired
	public BoardFileService(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
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
	
	
}
