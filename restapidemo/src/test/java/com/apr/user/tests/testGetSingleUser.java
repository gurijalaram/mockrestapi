package com.apr.user.tests;

import com.apr.restservices.RestUserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testGetSingleUser {
    @Test
    @DisplayName("Get User single Blog")
    public void testGetUser() {
        RestUserService.getSingleUserAndVerifySchema();
    }
}
