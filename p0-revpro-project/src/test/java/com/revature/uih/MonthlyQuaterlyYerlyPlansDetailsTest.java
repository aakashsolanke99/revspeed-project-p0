package com.revature.uih;

import com.revature.dao.imple.BroadbandServicePlansDaoImple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MonthlyQuaterlyYerlyPlansDetailsTest {

    @Mock
    private Scanner mockSc;
    @Mock
    private ShowPlans mockShowPlans;
    @Mock
    private BroadbandServicePlansDaoImple mockBroadbandServicePlansDaoImple;

    private MonthlyQuaterlyYerlyPlansDetails monthlyQuaterlyYerlyPlansDetailsUnderTest;

    @BeforeEach
    void setUp() {
        monthlyQuaterlyYerlyPlansDetailsUnderTest = new MonthlyQuaterlyYerlyPlansDetails();
        monthlyQuaterlyYerlyPlansDetailsUnderTest.sc = mockSc;
        monthlyQuaterlyYerlyPlansDetailsUnderTest.showPlans = mockShowPlans;
        monthlyQuaterlyYerlyPlansDetailsUnderTest.broadbandServicePlansDaoImple = mockBroadbandServicePlansDaoImple;
    }



    @Test
    void testGetAllBroadBandServicePlansMQY_ScannerNextIntThrowsNoSuchElementException() {
        // Setup
        when(mockSc.nextInt()).thenThrow(NoSuchElementException.class);

        // Run the test
        assertThrows(NoSuchElementException.class,
                () -> monthlyQuaterlyYerlyPlansDetailsUnderTest.getAllBroadBandServicePlansMQY());
    }

    @Test
    void testGetAllBroadBandServicePlansMQY_ScannerNextLineThrowsNoSuchElementException() {
        // Setup
        when(mockSc.nextInt()).thenReturn(0);
        when(mockSc.nextLine()).thenThrow(NoSuchElementException.class);

        // Run the test
        assertThrows(NoSuchElementException.class,
                () -> monthlyQuaterlyYerlyPlansDetailsUnderTest.getAllBroadBandServicePlansMQY());
    }


}
