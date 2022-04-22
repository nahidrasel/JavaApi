package dummy.restapiexample.com;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class DeleteEmployeeDataTest {

    @Test
    public void DeleteEmployeeID() {
        //Arrange
        RestAssured.baseURI = "https://dummy.restapiexample.com/";
        String resourceUrl = "/api/v1/delete/2";

        //Act
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.DELETE, resourceUrl);

        //Assert
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());
       // assertEquals(200, response.statusCode());

        //Verify response body
        JsonPath json = response.jsonPath();

        String message = json.get("message");
        System.out.println("Message => " + message);
        assertEquals("Successfully! Record has been deleted", message);

    }
}

