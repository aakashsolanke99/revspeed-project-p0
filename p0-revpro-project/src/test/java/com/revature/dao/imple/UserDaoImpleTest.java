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
    void testChangePassword() throws Exception {
        // Setup
        // Run the test
        userDaoImpleUnderTest.changePassword("newPass", 0);

        // Verify the results
    }



}
