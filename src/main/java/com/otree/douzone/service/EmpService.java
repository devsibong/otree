package com.otree.douzone.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otree.douzone.dao.EmpDao;
import com.otree.douzone.dto.Emp;

@Service
public class EmpService {
	private SqlSession sqlsession;
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	public List<Emp> getEmpList() {
		List<Emp> empList = null;
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			empList = empDao.getEmpList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}
	
	public boolean updateEmp(Emp emp) {
		boolean result = false;
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			empDao.updateEmp(emp);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean deleteEmp(int empno) {
		boolean result = false;
        try {
        	EmpDao empDao = sqlsession.getMapper(EmpDao.class);
            empDao.deleteEmp(empno);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
	
	public boolean insertEmp(Emp emp) {
		boolean result = false;
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			empDao.insertEmp(emp);
			result = true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;		
	}
	
	public List<Emp> searchEmpByName(String name) {
		List<Emp> empList = null;
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			empList = empDao.searchEmpByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}
}
