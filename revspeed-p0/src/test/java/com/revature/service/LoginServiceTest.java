package com.revature.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//    @Mock
//    private User mockedUser;
//
//    @InjectMocks
//    private LoginService loginService = new LoginServiceImple();
//
//    @Test
//    void testRegister() {
//        // Mocking user input
//        when(mockedUser.getFirstName()).thenReturn("John");
//        when(mockedUser.getLastName()).thenReturn("Doe");
//        when(mockedUser.getEmail()).thenReturn("john.doe@example.com");
//        when(mockedUser.getPassWord()).thenReturn("password");
//        when(mockedUser.getPhoneNumber()).thenReturn(1234567890L);
//        when(mockedUser.getAddress()).thenReturn("123 Main St");
//
//        // Run the register method
//        loginService.register(mockedUser);
//
//        // Verify that the setters were called with the expected values
//        verify(mockedUser).setFirstName("John");
//        verify(mockedUser).setLastName("Doe");
//        verify(mockedUser).setEmail("john.doe@example.com");
//        verify(mockedUser).setPassWord("password");
//        verify(mockedUser).setPhoneNumber(1234567890L);
//        verify(mockedUser).setAddress("123 Main St");
//
//        // Verify that the registerDao method was called
//        verify(((LoginServiceImple) loginService), times(1)).register(mockedUser);
//
//    }
}