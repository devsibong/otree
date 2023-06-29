package com.otree.douzone.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Workspace {
	private int workspaceId;
	private String workspaceName;
	private Date createdAt;
	private String description;
}
