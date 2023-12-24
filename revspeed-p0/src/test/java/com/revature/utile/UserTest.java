package com.revature.utile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private User userUnderTest;

    @BeforeEach
    void setUp() {
        userUnderTest = new User(0, "firstName", "lastName", "email", "passWord", "0", "address");
    }

    @Test
    void testUserIdGetterAndSetter() {
        final int userId = 0;
        userUnderTest.setUserId(userId);
        assertEquals(userId, userUnderTest.getUserId());
    }

    @Test
    void testFirstNameGetterAndSetter() {
        final String firstName = "firstName";
        userUnderTest.setFirstName(firstName);
        assertEquals(firstName, userUnderTest.getFirstName());
    }

    @Test
    void testLastNameGetterAndSetter() {
        final String lastName = "lastName";
        userUnderTest.setLastName(lastName);
        assertEquals(lastName, userUnderTest.getLastName());
    }

    @Test
    void testEmailGetterAndSetter() {
        final String email = "email";
        userUnderTest.setEmail(email);
        assertEquals(email, userUnderTest.getEmail());
    }

    @Test
    void testPassWordGetterAndSetter() {
        final String passWord = "passWord";
        userUnderTest.setPassWord(passWord);
        assertEquals(passWord, userUnderTest.getPassWord());
    }

    @Test
    void testPhoneNumberGetterAndSetter() {
        final String phoneNumber = "0";
        userUnderTest.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, userUnderTest.getPhoneNumber());
    }

    @Test
    void testAddressGetterAndSetter() {
        final String address = "address";
        userUnderTest.setAddress(address);
        assertEquals(address, userUnderTest.getAddress());
    }
}
