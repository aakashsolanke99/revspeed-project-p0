package com.revature.dao;

import com.revature.util.User;

import java.sql.SQLException;

public interface UserDao {
    public void registorDao(User user) throws SQLException;
    public void loginDao(String email,String password) throws SQLException;

    public void changePassword(String newPass,int id) throws SQLException;
    public void updateProfile(int id) throws SQLException;

}
