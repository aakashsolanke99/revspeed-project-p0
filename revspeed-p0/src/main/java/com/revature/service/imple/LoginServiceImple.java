package com.revature.service.imple;

import com.revature.dao.imple.LoginDao;
import com.revature.dao.imple.LoginDaolmple;
import com.revature.service.LoginService;

public class LoginServiceImple implements LoginService {

    LoginDaolmple loginDao=new LoginDaolmple();
    @Override
    public void register() {

        loginDao.registorDao();

    }

    @Override
    public void logIn() {

    }
}
