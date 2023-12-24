package com.revature.config;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

class DbConnectionTest {

    @Test
    void testGetConnection() {
        // Setup
        // Run the test
        final Connection result = DbConnection.getConnection();

        // Verify the results
    }
}
