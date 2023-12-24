package com.revature.uih;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class InputHndlerForUserTest {


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

//    @Test
//    public void testGetUserDetailsForRegistration() {
//        // Mock user input for testing
//        String mockInput = "John\nDoe\njohn.doe@example.com\nValidPass123\n1234567890\n123 Main St\n0";
//        InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
//        System.setIn(inputStream);
//
//        // Redirect System.out for testing output
//        // (Note: This assumes that you print messages directly to System.out in your code)
//        // Uncomment and adjust this part if necessary
//        // ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        // System.setOut(new PrintStream(outputStream));
//
//        // Run the method
//        try {
//            inputHandler.getUserDetailsForRegistration();
//        } catch (Exception e) {
//            // Handle any exceptions if needed
//        }
//
//        // Assert statements based on your expected behavior
//        // Uncomment and adjust this part if necessary
//        // assertTrue(outputStream.toString().contains("Expected output message"));
//
//        // Reset System.in and System.out
//        System.setIn(System.in);
//        // System.setOut(System.out);
//    }

//    @Test(expecte = NoSuchElementException.class)
//    public void testGetDetailsForLogin() {
//        // Mock user input for testing
//        String mockInput = "john.doe@example.com\nValidPass123\n";
//        InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
//        System.setIn(inputStream);
//
//        // Run the method
//        inputHandler.getDetailsForLogin();
//
//        // Reset System.in
//        System.setIn(System.in);
//    }
}
