package com.revature.service;

import com.revature.utile.User;

import java.sql.SQLException;

public interface LoginService {

    public void register(User user);
    public void logIn() throws SQLException;
}
