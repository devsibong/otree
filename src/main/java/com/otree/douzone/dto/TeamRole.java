package com.otree.douzone.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamRole {
	private int userId;
	private int workspaceId;
	private int roleId;
}
