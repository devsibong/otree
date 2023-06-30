package com.otree.douzone.dao;

import java.sql.SQLException;
import java.util.List;

import com.otree.douzone.dto.BoardComment;

public interface BoardCommentDao {
	
	void insertComment(BoardComment boardcomment) throws ClassNotFoundException, SQLException;
	List<BoardComment> getCommentList(int boardId) throws ClassNotFoundException, SQLException;
	void updateComment(String boardComment, int commentId) throws ClassNotFoundException, SQLException;
	void deleteComment(int commentId) throws ClassNotFoundException, SQLException;
	
}
