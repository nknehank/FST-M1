/*
One test case for sending a POST request on https://petstore.swagger.io/v2/pet
One test case for sending a GET request on https://petstore.swagger.io/v2/pet/{petId}
One test case for sending a DELETE request on https://petstore.swagger.io/v2/pet/{petId}
The test cases must execute in the order:
POST request -> GET request -> DELETE request.
 */

package Activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {
    // Set base URL
    final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";

    @Test(priority=1)
    public void addNewPet() {
        // Create JSON request
        String reqBody = "{"
                + "\"id\": 77232,"
                + "\"name\": \"Riley\","
                + " \"status\": \"alive\""
                + "}";

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody) // Add request body
                        .when().post(ROOT_URI); // Send POST request

        // Place Assertion
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }

    @Test(priority=2)
    public void getPetDetails() {
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "77232") // Set path parameter
                        .get(ROOT_URI + "/{petId}"); // Send GET request

        // Assertion
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }

    @Test(priority=3)
    public void deletePetDetails() {
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "77232") // Set path parameter
                        .delete(ROOT_URI + "/{petId}"); // Send DELETE request

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("77232"));
    }
}
