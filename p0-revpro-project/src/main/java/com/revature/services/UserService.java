package com.revature.services;

import com.revature.util.User;

import java.sql.SQLException;

public interface UserService {
    public void register() throws SQLException;
    public void login() throws SQLException;

//    public User getUsersDetailsInService() throws SQLException;
}
