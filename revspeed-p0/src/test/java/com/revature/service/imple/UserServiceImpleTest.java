package com.revature.service.imple;

import com.revature.uih.InputHndlerForUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImpleTest {

    @Mock
    private InputHndlerForUser mockInputHndlerForUser;

    private UserServiceImple userServiceImpleUnderTest;

    @BeforeEach
    void setUp() {
        userServiceImpleUnderTest = new UserServiceImple();
        userServiceImpleUnderTest.inputHndlerForUser = mockInputHndlerForUser;
    }

    @Test
    void testRegister() {
        // Setup
        // Run the test
        userServiceImpleUnderTest.register();

        // Verify the results
        verify(mockInputHndlerForUser).getUserDetailsForRegistration();
    }

    @Test
    void testLogin() throws Exception {
        // Setup
        // Run the test
        userServiceImpleUnderTest.login();

        // Verify the results
        verify(mockInputHndlerForUser).getDetailsForLogin();
    }

    @Test
    void testLogin_InputHndlerForUserThrowsSQLException() throws Exception {
        // Setup
        doThrow(SQLException.class).when(mockInputHndlerForUser).getDetailsForLogin();

        // Run the test
        assertThrows(SQLException.class, () -> userServiceImpleUnderTest.login());
    }
}
