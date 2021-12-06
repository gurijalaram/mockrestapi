package com.apr.blog.tests;

import com.apr.restservices.RestUserBlogService;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.MatcherAssert.assertThat;

public class testGetUserSingleBlog {
    @Test
    @DisplayName("Get User single Blog")
    public void testGetUserBlog() {
        RestUserBlogService.getUserSingleBlogAndVerifySchema();
    }
}
