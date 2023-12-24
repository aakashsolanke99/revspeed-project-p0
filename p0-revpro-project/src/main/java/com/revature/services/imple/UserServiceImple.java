package com.revature.services.imple;

import com.revature.services.UserService;
import com.revature.uih.InputHndlerForUser;

import java.sql.SQLException;

public class UserServiceImple implements UserService {
    InputHndlerForUser inputHndlerForUser=new InputHndlerForUser();

    @Override
    public void register() throws SQLException {
        inputHndlerForUser.getUserDetailsForRegistration();
    }

    @Override
    public void login() throws SQLException {
        inputHndlerForUser.getDetailsForLogin();
    }
}
