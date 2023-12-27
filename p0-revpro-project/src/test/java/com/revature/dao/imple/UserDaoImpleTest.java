package com.revature.dao.imple;

import com.revature.Main.GEmailSender;
import com.revature.uih.ForBroadBandPlansAndUserDetails;
import com.revature.util.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserDaoImpleTest {

    @Mock
    private GEmailSender mockGEmailSender;
    @Mock
    private DthServiceDaoImple mockDthServiceDaoImple;
    @Mock
    private BroadbandServicePlansDaoImple mockBroadbandServicePlansDaoImple;
    @Mock
    private ForBroadBandPlansAndUserDetails mockForBroadBandPlansAndUserDetails;

    private UserDaoImple userDaoImpleUnderTest;

    @BeforeEach
    void setUp() {
        userDaoImpleUnderTest = new UserDaoImple();
        userDaoImpleUnderTest.gEmailSender = mockGEmailSender;
        userDaoImpleUnderTest.dthServiceDaoImple = mockDthServiceDaoImple;
        userDaoImpleUnderTest.broadbandServicePlansDaoImple = mockBroadbandServicePlansDaoImple;
        userDaoImpleUnderTest.forBroadBandPlansAndUserDetails = mockForBroadBandPlansAndUserDetails;
    }

    @Test
    void testRegistorDao() throws Exception {
        // Setup
        final User user = new User(0, "firstName", "lastName", "email", "passWord","22344365", "address");

        // Run the test
        userDaoImpleUnderTest.registorDao(user);

        // Verify the results
        verify(mockGEmailSender).sendEmail("email", "from", "Registration successful - Welcome to Revspeed",
                "We are delighted to inform you that your registration on RevSpeed was successful! Welcome to our community.");
    }

    @Test
    void testLoginDao() throws Exception {
        // Setup
        // Run the test
        userDaoImpleUnderTest.loginDao("email", "password");

        // Verify the results
        verify(mockDthServiceDaoImple).planOptOutForDth();
        verify(mockBroadbandServicePlansDaoImple).planOptOutForBroadBand();
        verify(mockForBroadBandPlansAndUserDetails).getAllBroadBandServicePlansAndUserDetails();
    }

    @Test
    void testLoginDao_DthServiceDaoImpleThrowsSQLException() throws Exception {
        // Setup
        doThrow(SQLException.class).when(mockDthServiceDaoImple).planOptOutForDth();

        // Run the test
        userDaoImpleUnderTest.loginDao("email", "password");

        // Verify the results
    }

    @Test
    void testLoginDao_BroadbandServicePlansDaoImpleThrowsSQLException() throws Exception {
        // Setup
        doThrow(SQLException.class).when(mockBroadbandServicePlansDaoImple).planOptOutForBroadBand();

        // Run the test
        userDaoImpleUnderTest.loginDao("email", "password");

        // Verify the results
        verify(mockDthServiceDaoImple).planOptOutForDth();
    }

    @Test
    void testLoginDao_ForBroadBandPlansAndUserDetailsThrowsSQLException() throws Exception {
        // Setup
        doThrow(SQLException.class).when(
                mockForBroadBandPlansAndUserDetails).getAllBroadBandServicePlansAndUserDetails();

        // Run the test
        userDaoImpleUnderTest.loginDao("email", "password");

        // Verify the results
        verify(mockDthServiceDaoImple).planOptOutForDth();
        verify(mockBroadbandServicePlansDaoImple).planOptOutForBroadBand();
    }

    @Test
    void testChangePassword() throws Exception {
        // Setup
        // Run the test
        userDaoImpleUnderTest.changePassword("newPass", 0);

        // Verify the results
    }

    @Test
    void testChangePassword_ThrowsSQLException() {
        // Setup
        // Run the test
        assertThrows(SQLException.class, () -> userDaoImpleUnderTest.changePassword("newPass", 0));
    }

    @Test
    void testUpdateProfile() throws Exception {
        // Setup
        // Run the test
        userDaoImpleUnderTest.updateProfile(0);

        // Verify the results
    }

    @Test
    void testUpdateProfile_ThrowsSQLException() {
        // Setup
        // Run the test
        assertThrows(SQLException.class, () -> userDaoImpleUnderTest.updateProfile(0));
    }

    @Test
    void testPasswordExists() throws Exception {
        assertFalse(UserDaoImple.passwordExists("password"));
        assertThrows(SQLException.class, () -> UserDaoImple.passwordExists("password"));
    }
}
