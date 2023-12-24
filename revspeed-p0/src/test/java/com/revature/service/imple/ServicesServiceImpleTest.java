package com.revature.service.imple;

import com.revature.dao.imple.TypesOfServiceImple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ServicesServiceImpleTest {

    @Mock
    private TypesOfServiceImple mockTypesOfServiceImple;

    private ServicesServiceImple servicesServiceImpleUnderTest;

    @BeforeEach
    void setUp() {
        servicesServiceImpleUnderTest = new ServicesServiceImple();
        servicesServiceImpleUnderTest.typesOfServiceImple = mockTypesOfServiceImple;
    }

    @Test
    void testGetServices() {
        // Setup
        // Run the test
        servicesServiceImpleUnderTest.getServices();

        // Verify the results
        verify(mockTypesOfServiceImple).getTypesOfService();
    }
}
