package com.revature.uih;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputHandelerForUserTest {

    private InputHndlerForUser inputHandler;

    @BeforeEach
    public void setUp() {
        inputHandler = new InputHndlerForUser();
    }

    @Test
    public void testIsValidEmail() {
        assertTrue(inputHandler.isValidEmail("test@example.com"));      // Valid email
        assertTrue(inputHandler.isValidEmail("user123@gmail.com"));     // Valid email
        assertFalse(inputHandler.isValidEmail("invalid-email"));        // Invalid email format
        assertFalse(inputHandler.isValidEmail("missing@dotcom"));       // Invalid email format
        assertFalse(inputHandler.isValidEmail("noatsignanddotcom"));    // Invalid email format
    }

    @Test
    public void testIsValidPassword() {
        assertTrue(inputHandler.isValidPassword("ValidPass123"));        // Valid password
        assertFalse(inputHandler.isValidPassword("Short"));              // Invalid, too short
        assertFalse(inputHandler.isValidPassword("nopassword"));         // Invalid, no digit or uppercase letter
        assertFalse(inputHandler.isValidPassword("NoDigitUpperCase"));  // Invalid, no lowercase letter
    }

    @Test
    public void testIsValidName() {
        assertTrue(inputHandler.isValidName("JohnDoe"));                 // Valid name
        assertTrue(inputHandler.isValidName("AliceWonderland"));       // Valid name with space
        assertFalse(inputHandler.isValidName("123"));                   // Invalid, contains digits
        assertFalse(inputHandler.isValidName(""));                      // Invalid, empty
    }

    @Test
    public void testIsValidPhoneNumber() {
        assertTrue(inputHandler.isValidPhoneNumber("1234567890"));           // Valid phone number
        assertTrue(inputHandler.isValidPhoneNumber("555-123-4567"));         // Valid phone number with dashes
        assertTrue(inputHandler.isValidPhoneNumber("987 654 3210"));         // Valid phone number with spaces
        assertFalse(inputHandler.isValidPhoneNumber("not a number"));        // Invalid, contains non-digit characters
        assertFalse(inputHandler.isValidPhoneNumber("123-abc-4567"));        // Invalid, contains non-digit characters
    }
}
