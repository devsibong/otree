package com.otree.douzone.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
	private int boardId;
	private int userId;
	private int workspaceId;
	private String boardTitle;
	private String boardContent;
	private Date createdAt;
	
}
