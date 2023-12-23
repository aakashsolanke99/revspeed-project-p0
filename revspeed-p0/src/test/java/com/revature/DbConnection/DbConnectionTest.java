package com.revature.DbConnection;
import static org.junit.jupiter.api.Assertions.*;

import com.revature.config.DbConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

public class DbConnectionTest {

    private Connection con;
    @Test
    public void getConnectionTest() throws SQLException {

         con = DbConnection.getConnection();
        assertNotNull(con);
    }

//    @Test
//    public void closedConnectionTest(){
//
////        DbConnection.closeConnection();
//        assertNull(con);
//    }
}
