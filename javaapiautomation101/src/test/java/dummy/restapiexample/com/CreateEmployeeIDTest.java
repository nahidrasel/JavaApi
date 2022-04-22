package dummy.restapiexample.com;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class CreateEmployeeIDTest {

    @Test
    public void CreateNewEmployee() {
        //Arrange
        RestAssured.baseURI = "https://dummy.restapiexample.com/";
        String resourceUrl = "/api/v1/create";

        //Act
        RequestSpecification httpRequest = RestAssured.given().contentType("application/json")
                .body("{\"name\":\"test\",\n\"salary\":\"123\",\n\"age\":\"23\"}");

        Response response = httpRequest.request(Method.POST, resourceUrl);

/*
        Response response = given().contentType("application/json")
                .body("{\"name\":\"test\",\n\"salary\":\"123\",\n\"age\":\"23\"}")
                .when().post(resourceUrl);
*/
        //Assert
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());
        // assertEquals(201, response.statusCode());

        //Verify response body
        JsonPath json = response.jsonPath();

        String name = json.get("data.name");
        System.out.println("Name is => " + name);
        assertEquals("test", name);

        String salary = json.get("data.salary");
        System.out.println("Salary is => " + salary);
        assertEquals("123", salary);

        String age = json.get("data.age");
        System.out.println("Age is => " + age);
        assertEquals("23", age);


        String message = json.get("message");
        System.out.println("Message => " + message);
        assertEquals("Successfully! Record has been added.", message);

    }
}

