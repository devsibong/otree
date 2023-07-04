package com.otree.douzone.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.otree.douzone.dao.OtreeUserDao;
import com.otree.douzone.dto.OtreeUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final SqlSession sqlSession;
	
	public int login(String email, String password) {
		int result = -1;
		OtreeUser otreeUser = null;
	    try {
	        OtreeUserDao otreeUserDao = sqlSession.getMapper(OtreeUserDao.class);
	        otreeUser = otreeUserDao.getOtreeUserByEmail(email);
	        if(otreeUser.getPassword().equals(password)) result = otreeUser.getUserId();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (NullPointerException e) {
	    	e.printStackTrace();
	    }
		return result;
	}
	
	public OtreeUser getOtreeUserById(int userId) {
		OtreeUser otreeUser = null;
		try {
			OtreeUserDao userDao = sqlSession.getMapper(OtreeUserDao.class);
			otreeUser = userDao.getOtreeUserById(userId);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return otreeUser;
	}
	
	public List<OtreeUser> getOtreeUserList() {
		List<OtreeUser> userList = null;
		try {
			OtreeUserDao userDao = sqlSession.getMapper(OtreeUserDao.class);
			userList = userDao.getOtreeUserList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public boolean modifyOtreeUser(OtreeUser user) {
		boolean result = false;
		try {
			OtreeUserDao userDao = sqlSession.getMapper(OtreeUserDao.class);
			userDao.updateOtreeUser(user);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean reomoveOtreeUser(int userId) {
		boolean result = false;
		try {
			OtreeUserDao userDao = sqlSession.getMapper(OtreeUserDao.class);
			userDao.deleteOtreeUser(userId);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean createOtreeUser(OtreeUser user) {
		boolean result = false;
		try {
			OtreeUserDao userDao = sqlSession.getMapper(OtreeUserDao.class);
			userDao.insertOtreeUser(user);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<OtreeUser> getOtreeUserListByName(String name, int workspaceId) {
		List<OtreeUser> userList = null;
		try {
			OtreeUserDao userDao = sqlSession.getMapper(OtreeUserDao.class);
			userList = userDao.searchOtreeUserByNameFilter(name, workspaceId); 
			//userList = userDao.searchOtreeUserByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public OtreeUser getOtreeUserByEmail(String email) {
		OtreeUser user = null;
		try {
			OtreeUserDao userDao = sqlSession.getMapper(OtreeUserDao.class);
			user = userDao.getOtreeUserByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
