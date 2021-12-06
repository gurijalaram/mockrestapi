package com.apr.restservices;

import com.apr.common.Utils;
import com.apr.constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

/*
 This is service class is to cover the CRUD operations for Users Rest API.
 */
public class RestUserService {

    /*
    Get single user and verify response json schema
     */
    public static void getSingleUserAndVerifySchema(){
        RestAssured
                .given()
                    .baseUri(Endpoints.BASE_URL)
                    .contentType(ContentType.JSON)
                .when()
                    .get(Endpoints.SINGLE_USER.replace("{id}", "1"))
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("getUserSchema.json"));
    }

    /*
   Get all users and verify status code
    */
    public static void getAllUsers(){
        RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.ALL_USERS)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public static Response createUser(){
        Response response ;
                String jsonRequestBody = "{\n" +
                        "  \"createdAt\": \"<Today>\",\n" +
                        "  \"name\": \"tes ssijuh\",\n" +
                        "  \"email\": \"asf2@gmail.com\",\n" +
                        "  \"avatar\": \"https://cdn.fakercloud.com/avatars/uxward_128.jpg\"\n" +
                        "}";
        response = RestAssured
                .given()
                    .baseUri(Endpoints.BASE_URL)
                    .contentType(ContentType.JSON)
                .when()
                    .body(jsonRequestBody.replace("<Today>",Utils.getDateInTZFormat()))
                .post(Endpoints.ALL_USERS)
                .andReturn();

        return response;
    }

    public static void updateUser(String userid){
        String jsonRequestBody = "{\n" +
                "  \"createdAt\": \"<Today>\",\n" +
                "  \"name\": \"tes ssijuh<Random>\",\n" +
                "  \"email\": \"asf2@gmail.com\",\n" +
                "  \"avatar\": \"https://cdn.fakercloud.com/avatars/uxward_128.jpg\"\n" +
                "}";
            RestAssured
                .given()
                    .baseUri(Endpoints.BASE_URL)
                    .contentType(ContentType.JSON)
                    .body(jsonRequestBody.replace("<Today>",Utils.getDateInTZFormat()).replace("<Random>", Utils.getRandomNumber()))
                .when()
                    .put(Endpoints.SINGLE_USER.replace("{id}", userid))
                .then()
                    .assertThat()
                    .statusCode(200)
                    .log().all();
    }

    public static void deleteUser(String userid){
        RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .delete(Endpoints.SINGLE_USER.replace("{id}", userid))
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    public static void getUserNotExist(String userid){
        RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.SINGLE_USER.replace("{id}", userid))
                .then()
                .assertThat()
                .statusCode(404)
                .log().all();
    }
}
