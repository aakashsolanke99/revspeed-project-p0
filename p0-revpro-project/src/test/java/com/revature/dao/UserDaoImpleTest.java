package com.revature.dao;

import com.revature.config.DbConnection;
import com.revature.dao.imple.UserDaoImple;
import com.revature.util.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpleTest {
    @Test
    public void testRegistorDao() throws SQLException {
        // Arrange
        String userInput = "John\nDoe\njohn@example.com\npassword\n1234567890\nSample Address\n";

        // Mocking
        Connection mockconnection = Mockito.mock(Connection.class);
        PreparedStatement mockpreparedStatement = Mockito.mock(PreparedStatement.class);
        Mockito.when(mockconnection.prepareStatement(Mockito.anyString())).thenReturn(mockpreparedStatement);

        Mockito.mockStatic(DbConnection.class);
        Mockito.when(DbConnection.getConnection()).thenReturn(mockconnection);
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());

        UserDaoImple userDaoImple=new UserDaoImple();

        User user = new User(); // Create a user object
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john@example.com");
        user.setPassWord("password");
        user.setPhoneNumber("1234567890");
        user.setAddress("Sample Address");

        Assertions.assertDoesNotThrow(()->userDaoImple.registorDao(user));
//        Mockito.when(Connection.).thenReturn(connection);



        // Act

        // Assert
        Mockito.verify(mockconnection).prepareStatement(Mockito.anyString());
        Mockito.verify(mockpreparedStatement).setString(1, user.getFirstName());
        Mockito.verify(mockpreparedStatement).setString(2, user.getLastName());
        Mockito.verify(mockpreparedStatement).setString(3,user.getEmail());
        Mockito.verify(mockpreparedStatement).setString(4, user.getPassWord());
        Mockito.verify(mockpreparedStatement).setString(5, user.getPhoneNumber());
        Mockito.verify(mockpreparedStatement).setString(6, user.getAddress());
        Mockito.verify(mockpreparedStatement).executeUpdate();

        Mockito.verify(mockconnection).close();

    }

}
