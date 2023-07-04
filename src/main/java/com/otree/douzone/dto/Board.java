package com.otree.douzone.dto;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class Board {
	private int boardId;
	private int userId;
	private int workspaceId;
	private String boardTitle;
	private String boardContent;
	private Date createdAt;
	private int readcount;
	private String name; //VO를 만들어야 하지만.. 

	

}






