package com.otree.douzone.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Emp {
	private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private double sal;
    private double comm;
    private int deptno;
}