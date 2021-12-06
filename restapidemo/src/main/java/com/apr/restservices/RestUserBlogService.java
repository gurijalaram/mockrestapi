package com.apr.restservices;

import com.apr.common.Utils;
import com.apr.constants.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class RestUserBlogService {

    // Submit Get/Post/Delete/Put rquest

    /*
     Get single blog information for a user 1 and blog 19
     Verify Response schema, http status code = 200
     */
    public static void getUserSingleBlogAndVerifySchema() {
        RestAssured
                .given().log().all()
                    .baseUri(Endpoints.BASE_URL)
                    .contentType(ContentType.JSON)
                .when()
                    .get(Endpoints.USER_SINGLE_BLOG.replace("{id}", "1").replace("{bid}", "19"))
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("getUserBlogsSchema.json"));
    }

    /*
        Get single blog information for a user 1 and blog 19
        Verify Response schema, http status code = 200
        */
    public static Response getUserAllBlogs() {
        return (Response) RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.USER_BLOGS.replace("{id}", "1"))
                .andReturn();
    }

    /*
       Get single blog information for a user 1 and blog 19
       Verify Response schema, http status code = 200
       */
    public static Response createUserBlog() {
        String blogID = String.valueOf(Integer.parseInt(Utils.getRandomNumber()));
        String requestBodyJson = "[\n" +
                "  {\n" +
                "    \"createdAt\": \"<Today>\",\n" +
                "    \"title\": \"Use the digital SSL pixel, then you can copy the 1080p interface!\",\n" +
                "    \"content\": \"The SDD port is down, generate the solid state port so we can connect the SMS circuit!\",\n" +
                "    \"blogId\": \"<Random>\",\n" +
                "    \"userId\": \"10\",\n" +
                "    \"user\": {\n" +
                "      \"createdAt\": \"<Today>\",\n" +
                "      \"name\": \"Rest apidemo<Random>\",\n" +
                "      \"email\": \"test<Random>@gmail.com\",\n" +
                "      \"avatar\": \"https://cdn.fakercloud.com/avatars/uxward_128.jpg\",\n" +
                "      \"userId\": \"10\"\n" +
                "    },\n" +
                "    \"likes\": [\n" +
                "      {\n" +
                "        \"id\": \"1\",\n" +
                "        \"blogId\": \"<Random>\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        return (Response) RestAssured
                .given()
                    .baseUri(Endpoints.BASE_URL)
                    .contentType(ContentType.JSON)
                .when()
                    .body(requestBodyJson.replaceAll("<Today>",Utils.getDateInTZFormat()).replaceAll("<Random>", blogID))
                .post(Endpoints.USER_BLOGS.replace("{id}", "10"))
                .andReturn();

    }

    /*
      Get single blog information for a user 1 and blog 19
      Verify Response schema, http status code = 200
      */
    public static void UpdateUserBlog(String blogID) {
        String updRandNum = String.valueOf(Integer.parseInt(Utils.getRandomNumber()));
        String requestBodyJson = "[\n" +
                "  {\n" +
                "    \"createdAt\": \"2021-12-06T01:05:02Z\",\n" +
                "    \"title\": \"Use the digital SSL pixel, then you can copy the 1080p interface!\",\n" +
                "    \"content\": \"The SDD port is down, generate the solid state port so we can connect the SMS circuit!\",\n" +
                "    \"blogId\": \"924\",\n" +
                "    \"userId\": \"10\",\n" +
                "    \"user\": {\n" +
                "      \"createdAt\": \"2021-12-06T01:05:02Z\",\n" +
                "      \"name\": \"Rest apidemo924\",\n" +
                "      \"email\": \"test924@gmail.com\",\n" +
                "      \"avatar\": \"https://cdn.fakercloud.com/avatars/uxward_128.jpg\",\n" +
                "      \"userId\": \"10\"\n" +
                "    },\n" +
                "    \"likes\": [\n" +
                "      {\n" +
                "        \"id\": \"1\",\n" +
                "        \"blogId\": \"924\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"createdAt\": \"<Today>\",\n" +
                "    \"title\": \"The FTP transmitter is down, connect the primary panel so we can bypass the COM hard drive!\",\n" +
                "    \"content\": \"You can\\u0027t input the card without indexing the neural AGP firewall!\",\n" +
                "    \"blogId\": \"<BLOGID\",\n" +
                "    \"userId\": \"10\",\n" +
                "    \"user\": {\n" +
                "      \"createdAt\": \"<Today>\",\n" +
                "      \"name\": \"Ted Legros Jr.\",\n" +
                "      \"email\": \"Grace<Random>@yahoo.com\",\n" +
                "      \"avatar\": \"https://cdn.fakercloud.com/avatars/megdraws_128.jpg\",\n" +
                "      \"userId\": \"10\"\n" +
                "    },\n" +
                "    \"likes\": []\n" +
                "  }\n" +
                "]";
            RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBodyJson.replaceAll("<Today>",Utils.getDateInTZFormat()).replaceAll("<Random>", updRandNum).replace("<BLOGID>",blogID))
                .put(Endpoints.USER_SINGLE_BLOG.replace("{id}", "10").replace("{bid}",blogID))
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .log().all();

        }
    /*
  Delete single blog information for a user 1 and blog 19
  Verify Response schema, http status code = 200
  */
    public static void DeleteUserBlog(String blogID) {
        RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .delete(Endpoints.USER_SINGLE_BLOG.replace("{id}", "10").replace("{bid}", blogID))
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    /*
     Get single blog information for a user 1 and dynamic blod id that got deleted
     Verify Response schema, http status code = 200 and verify response "Not Found"
     This case can be considered negative test trying to get blogid that doesn't exist
     */
    public static void GetUserBlogNotExist(String blogID) {
        RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.USER_SINGLE_BLOG.replace("{id}", "10").replace("{bid}", blogID))
                .then()
                .assertThat()
                .statusCode(404)
                .log().all();
    }
}


