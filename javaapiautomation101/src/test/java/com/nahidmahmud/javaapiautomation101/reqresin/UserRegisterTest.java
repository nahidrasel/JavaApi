package com.nahidmahmud.javaapiautomation101.reqresin;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.Assert.assertEquals;

public class UserRegisterTest {

    @Test
    public void userRegistration() {
        //Arrange
        RestAssured.baseURI = "https://reqres.in";

        String id = "";
        String resourceUrl = "/api/register/";

        //Act
        Response response = given().contentType("application/json")
                .body("{\"email\":\"eve.holt@reqres.in\",\n\"password\":\"pistol\"}")
                .when().post(resourceUrl);


        //Assert
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());
        assertEquals(200, response.statusCode());

        //Verify response body
        JsonPath json = response.jsonPath();

    }
}

