package com.apr.blog.tests;

import com.apr.common.Utils;
import com.apr.restservices.RestUserBlogService;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.*;
import io.restassured.response.Response;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class testCreateUpdateDeleteBlog {
    private static String blogId ;
    @Test
    @Order(1)
    @DisplayName("Create Blog for User ")
    public void testCreateBlog() {
        Response response = RestUserBlogService.createUserBlog();
        Assertions.assertEquals(201, response.getStatusCode());
        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();
        // Then simply query the JsonPath object to get a String value of the node
        blogId = jsonPathEvaluator.get("blogId");
    }

    @Test
    @Order(2)
    @DisplayName("Update Blog for User ")
    public void testUpdateBlog() {
        RestUserBlogService.UpdateUserBlog(blogId);
    }

    @Test
    @Order(3)
    @DisplayName("Delete Blog for User ")
    public void testDeleteBlog() {
        RestUserBlogService.DeleteUserBlog(blogId);
    }

    @Test
    @Order(4)
    @DisplayName("Get Blog for User that does not exist")
    public void testGetUserBlog() {
        RestUserBlogService.GetUserBlogNotExist(blogId);
    }
}
