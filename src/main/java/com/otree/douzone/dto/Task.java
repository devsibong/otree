package com.otree.douzone.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Task {
	private int taskId;
	private int workspaceId;
	private String startDate;
	private String endDate;
	private String taskContent;
	private int taskSeq;
	private int statusId;
	private Date createdAt;
}
