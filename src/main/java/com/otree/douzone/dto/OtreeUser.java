package com.otree.douzone.dto;

import lombok.Data;

@Data
public class OtreeUser {
    private int userId;
    private String name;
    private String password;
    private String email;
    private String profileSrc;
}