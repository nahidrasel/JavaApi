package dummy.restapiexample.com;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class UpdateEmployeeIDTest {

    @Test
    public void UpdateEmployeeID() {
        //Arrange
        RestAssured.baseURI = "https://dummy.restapiexample.com/";
        String resourceUrl = "/public/api/v1/update/21";

        //Act

        RequestSpecification httpRequest = RestAssured.given().contentType("application/json")
                .body("{\"employee_name\":\"Nahid\",\n\"employee_salary\":\"123\",\n\"employee_age\":\"23\"}");

        Response response = httpRequest.request(Method.PUT, resourceUrl);


        //Assert
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());
       assertEquals(200, response.statusCode());

        //Verify response body
        JsonPath json = response.jsonPath();

        String name = json.get("data.employee_name");
        System.out.println("Name is => " + name);
        assertEquals("Nahid", name);

        String salary = json.get("data.employee_salary");
        System.out.println("Salary is => " + salary);
        assertEquals("123", salary);

        String age = json.get("data.employee_age");
        System.out.println("Age is => " + age);
        assertEquals("23", age);


        String message = json.get("message");
        System.out.println("Message => " + message);
        assertEquals("Successfully! Record has been added.", message);

    }
}

