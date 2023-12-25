package com.revature.services.imple;

import com.revature.dao.imple.UserDaoImple;
import com.revature.services.UserService;
import com.revature.uih.IhShowUserDetails;
import com.revature.uih.InputHndlerForUser;
import com.revature.util.User;

import java.sql.SQLException;

public class UserServiceImple implements UserService {
    InputHndlerForUser inputHndlerForUser=new InputHndlerForUser();
    IhShowUserDetails ihShowUserDetails=new IhShowUserDetails();
    UserDaoImple userDaoImple=new UserDaoImple();
//    UserDaoImple userDaoImple=new UserDaoImple();
    @Override
    public void register() throws SQLException {
        inputHndlerForUser.getUserDetailsForRegistration();
    }

    @Override
    public void login() throws SQLException {
        inputHndlerForUser.getDetailsForLogin();
    }

    @Override
    public void changePassWordService(String newPass, int id) throws SQLException {
        userDaoImple.changePassword(newPass,id);
    }

    @Override
    public void pudateProfile(int id) throws SQLException {
        userDaoImple.updateProfile(id);
    }

}
