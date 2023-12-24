package com.revature.services.imple;

import com.revature.dao.imple.UserDaoImple;
import com.revature.services.UserService;
import com.revature.uih.InputHndlerForUser;
import com.revature.util.User;

import java.sql.SQLException;

public class UserServiceImple implements UserService {
    InputHndlerForUser inputHndlerForUser=new InputHndlerForUser();

    UserDaoImple userDaoImple=new UserDaoImple();
    @Override
    public void register() throws SQLException {
        inputHndlerForUser.getUserDetailsForRegistration();
    }

    @Override
    public void login() throws SQLException {
        inputHndlerForUser.getDetailsForLogin();
    }

//    @Override
//    public User getUsersDetailsInService()  {
//        return userDaoImple.getUserDetails();
//    }
}
