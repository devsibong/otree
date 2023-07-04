package com.otree.douzone.dao;

import java.sql.SQLException;
import java.util.List;

import com.otree.douzone.dto.BoardComment;
import com.otree.douzone.dto.BoardCommentVO;

public interface BoardCommentDao {
	
	void insertComment(BoardComment boardcomment) throws ClassNotFoundException, SQLException;
	BoardCommentVO getCommentVO(int commentId) throws ClassNotFoundException, SQLException;
	List<BoardCommentVO> getCommentListVO(int boardId) throws ClassNotFoundException, SQLException;
	void updateComment(String boardComment, int commentId) throws ClassNotFoundException, SQLException;
	void deleteComment(int commentId) throws ClassNotFoundException, SQLException;
	
}
