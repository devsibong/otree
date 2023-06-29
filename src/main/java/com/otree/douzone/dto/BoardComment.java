package com.otree.douzone.dto;

import lombok.Data;

@Data
public class BoardComment {
	private int commentId;
	private String boardComment;
	private int boardId;
	private int userId;
}
