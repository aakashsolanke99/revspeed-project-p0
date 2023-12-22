package com.revature.service.imple;

import com.revature.dao.imple.LoginDao;
import com.revature.dao.imple.LoginDaolmple;
import com.revature.service.LoginService;
import com.revature.utile.User;

import java.sql.SQLException;

public class LoginServiceImple implements LoginService {

    LoginDaolmple loginDao=new LoginDaolmple();


    @Override
    public void register(User user) {
        loginDao.registorDao(user);
    }

    @Override
    public void logIn() throws SQLException {
          loginDao.loginDaoImpl();
    }
}
