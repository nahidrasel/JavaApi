package com.nahidmahmud.javaapiautomation101.reqresin;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.Assert.assertEquals;

public class DeleteUserTest {

    @Test
    public void deleteMethodByJson() {
        //Arrange
        RestAssured.baseURI = "https://reqres.in";

        String id = "2";
        String resourceUrl = "/api/users/" + id;

        //Act
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.DELETE, resourceUrl);


        //Assert
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint()+"Should be Nothing");
        assertEquals(204, response.statusCode());

        //Verify response body
        JsonPath json = response.jsonPath();

    }
}

