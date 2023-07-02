package com.otree.douzone.dto;

import lombok.Data;

@Data
public class WorkspaceTeamUser {
    private int userId;
    private String name;
    private String email;
    private String profileSrc;
    private int workspaceId;
    private int roleId;
    private String rolename;
}