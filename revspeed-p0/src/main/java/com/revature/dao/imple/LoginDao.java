package com.revature.dao.imple;

import com.revature.utile.User;

import java.sql.SQLException;

public interface LoginDao {
    public void registorDao(User user) throws SQLException;
    public void loginDaoImpl() throws SQLException;
}
