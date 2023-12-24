package com.revature.services;

import java.sql.SQLException;

public interface UserService {
    public void register() throws SQLException;
    public void login() throws SQLException;

}
