package com.otree.douzone.dao;

import java.sql.SQLException;
import java.util.List;

import com.otree.douzone.dto.OtreeUser;

public interface OtreeUserDao {
    List<OtreeUser> getOtreeUserList() throws SQLException;
    OtreeUser getOtreeUserById(int userId) throws SQLException;
    OtreeUser getOtreeUserByEmail(String email) throws SQLException;
    void insertOtreeUser(OtreeUser otreeUser) throws SQLException;
    void updateOtreeUser(OtreeUser otreeUser) throws SQLException;
    void deleteOtreeUser(int userId) throws SQLException;
    List<OtreeUser> searchOtreeUserByName(String name) throws SQLException;
    List<OtreeUser> searchOtreeUserByNameFilter(String name) throws SQLException;
}
