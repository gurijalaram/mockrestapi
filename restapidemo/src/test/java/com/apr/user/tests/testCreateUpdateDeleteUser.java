package com.apr.user.tests;

import com.apr.restservices.RestUserService;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.*;
import io.restassured.response.Response;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class testCreateUpdateDeleteUser {
    public static String userID;
    @Test
    @Order(1)
    @DisplayName("Create User ")
    public void testCreateUser(){
        Response response = RestUserService.createUser();
        Assertions.assertEquals(201, response.getStatusCode());
        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();
        // Then simply query the JsonPath object to get a String value of the node
        userID = jsonPathEvaluator.get("userId");
        System.out.println(userID);
    }

    @Test
    @Order(2)
    @DisplayName("Update User ")
    public void testUpdateUser(){
        RestUserService.updateUser(userID);
    }

    @Test
    @Order(3)
    @DisplayName("Delete User ")
    public void testDeleteUser(){
        RestUserService.deleteUser(userID);
    }

    @Test
    @Order(4)
    @DisplayName("get User that does not exist ")
    public void testGetDeletedUser(){
        RestUserService.getUserNotExist(userID);
    }

}
