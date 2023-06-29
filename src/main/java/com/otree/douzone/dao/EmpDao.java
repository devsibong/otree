package com.otree.douzone.dao;

import java.sql.SQLException;
import java.util.List;

import com.otree.douzone.dto.Emp;

public interface EmpDao {
    List<Emp> getEmpList() throws SQLException;
    void insertEmp(Emp emp) throws SQLException;
    void updateEmp(Emp emp) throws SQLException;
    void deleteEmp(int empno) throws SQLException;
    List<Emp> searchEmpByName(String name) throws SQLException;
}
