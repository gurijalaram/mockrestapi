package com.apr.blog.tests;

import com.apr.restservices.RestUserBlogService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;

public class testGetUserAllBlogs {
    private static String userID ;
    @Test
    @DisplayName("Get User single All Blogs")
    public void testGetUserBlog() {
        Response response = (Response) RestUserBlogService.getUserAllBlogs();
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
