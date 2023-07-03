package com.otree.douzone.dao;

import java.sql.SQLException;
import java.util.List;

import com.otree.douzone.dto.Board;


public interface BoardDao {
		void insertBoard(Board board) throws ClassNotFoundException, SQLException; // 게시물 생성
		int getBoardCount() throws ClassNotFoundException, SQLException; // 게시물 개수 가져오기
		List<Board> getBoardList(int workspaceId) throws ClassNotFoundException, SQLException; //첫번째 화면 게시물 가져오기
		List<Board> getBoardListForPaging(int page, String field, String query) throws ClassNotFoundException, SQLException; // 페이징한 전체 게시물 가져오기
		List<Board> getBoardListByBoardTitle(String boardTitle) throws ClassNotFoundException, SQLException; // boardTitle로 게시물 검색
		Board getBoardByBoardId(int boardId) throws ClassNotFoundException, SQLException; // boardId로 게시물 상세보기
		int updateBoardReadCountByBoardId(int boardId) throws ClassNotFoundException, SQLException; // boardId로 게시물 상세보기
	    void updateBoard(Board board ) throws ClassNotFoundException, SQLException; // 게시물 업데이트
	    void deleteBoard(int boardId) throws ClassNotFoundException, SQLException; // 게시물 삭제
}
