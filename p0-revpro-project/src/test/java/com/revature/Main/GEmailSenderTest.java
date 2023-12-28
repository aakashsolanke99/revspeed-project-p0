package com.revature.Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;

class GEmailSenderTest {

    @Mock
    private GEmailSender gEmailSenderUnderTest;

    @BeforeEach
    void setUp() {
        gEmailSenderUnderTest = new GEmailSender();
    }

    @Test
    void testSendEmail() {
        assertFalse(gEmailSenderUnderTest.sendEmail("from", "from", "subject", "text"));
    }
}
