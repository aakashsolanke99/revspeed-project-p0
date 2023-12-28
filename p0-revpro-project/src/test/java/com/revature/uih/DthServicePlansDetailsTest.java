package com.revature.uih;

import com.revature.dao.imple.DthServiceDaoImple;
import com.revature.services.imple.DthServicePlanServiceImple;
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
class DthServicePlansDetailsTest {

    @Mock
    private Scanner mockSc;
    @Mock
    private ShowPlans mockShowPlans;
    @Mock
    private DthServiceDaoImple mockDthServiceDaoImple;
    @Mock
    private DthServicePlanServiceImple mockDthServicePlanServiceImple;

    private DthServicePlansDetails dthServicePlansDetailsUnderTest;

    @BeforeEach
    void setUp() {
        dthServicePlansDetailsUnderTest = new DthServicePlansDetails();
        dthServicePlansDetailsUnderTest.sc = mockSc;
        dthServicePlansDetailsUnderTest.showPlans = mockShowPlans;
        dthServicePlansDetailsUnderTest.dthServiceDaoImple = mockDthServiceDaoImple;
        dthServicePlansDetailsUnderTest.dthServicePlanServiceImple = mockDthServicePlanServiceImple;
    }


    @Test
    void testGetAllDthPlansDetails_ScannerNextIntThrowsNoSuchElementException() {
        // Setup
        when(mockSc.nextInt()).thenThrow(NoSuchElementException.class);

        // Run the test
        assertThrows(NoSuchElementException.class, () -> dthServicePlansDetailsUnderTest.getAllDthPlansDetails());
    }

    @Test
    void testGetAllDthPlansDetails_ScannerNextLineThrowsNoSuchElementException() {
        // Setup
        when(mockSc.nextInt()).thenReturn(0);
        when(mockSc.nextLine()).thenThrow(NoSuchElementException.class);

        // Run the test
        assertThrows(NoSuchElementException.class, () -> dthServicePlansDetailsUnderTest.getAllDthPlansDetails());
    }



}
