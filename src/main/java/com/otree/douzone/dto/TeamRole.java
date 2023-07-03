package com.otree.douzone.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

//OTREEUSER_WORKSPACE 테이블
@Data
@AllArgsConstructor
public class TeamRole {
	private int userId;
	private int workspaceId;
	private int roleId;
}
