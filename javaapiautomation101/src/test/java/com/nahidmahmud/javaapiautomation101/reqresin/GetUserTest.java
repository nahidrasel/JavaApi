package com.nahidmahmud.javaapiautomation101.reqresin;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static io.restassured.RestAssured.given;

/**
 * Unit test for simple App.
 */
public class GetUserTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GetUserTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GetUserTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void test_learning_getMethodUserById()
    {
        //Arrange
        RestAssured.baseURI = "https://reqres.in";
        String id = "2";
        String resourceUrl = "/api/users/" + id;

        //Act
        RequestSpecification httpRequest = RestAssured.given();
        Response response  = httpRequest.request(Method.GET, resourceUrl);

        //Assert
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
        assertEquals(200, response.statusCode());

        //Verify response body
        JsonPath json = response.jsonPath();

        int identity = json.get("data.id");
        System.out.println("ID is => " + identity);
        assertEquals(2, identity);

        String email = json.get("data.email");
        System.out.println("Email received => " + email);
        assertEquals("janet.weaver@reqres.in", email);

        String firstName = json.get("data.first_name");
        System.out.println("First Name is => " + firstName);
        assertEquals("Janet", firstName);

        String lastName = json.get("data.last_name");
        System.out.println("Last Name is => " + lastName);
        assertEquals("Weaver", lastName);

        String avatar = json.get("data.avatar");
        System.out.println("Avatar check => " + avatar);
        assertEquals("https://reqres.in/img/faces/2-image.jpg", avatar);

        String supportUrl = json.get("support.url");
        System.out.println("Support Url is => " + supportUrl);
        assertEquals("https://reqres.in/#support-heading", supportUrl);

        String supportText = json.get("support.text");
        System.out.println("Support Text is => " + supportText);
        assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!", supportText);

    }

}
