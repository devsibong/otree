package com.otree.douzone.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Task {
	private int taskId;
	private int workspaceId;
	private Date startDate;
	private Date endDate;
	private String taskContent;
	private int taskSeq;
	private int statusId;
	private Date createdAt;
}
