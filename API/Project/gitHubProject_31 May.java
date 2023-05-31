package Project;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

import io.ktor.http.cio.RequestResponseBuilder;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;
import java.util.Map;


public class gitHubProject {

    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICUCo8PW6cmIRthjM//m0ye0jfHzND4b96WlT+Xk/rLu gmx";
int sshKeyId;

    //Request Specification
          RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com/user/keys").addHeader("Authorization", "token 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")
                .addHeader("Content-Type", "application/json")
                .build();

        //Response Specification
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                // Check response content type
                .expectContentType("application/json")
                .build();


    @Test(priority=1)
    public void postKey()
    {
        String reqBody = "{" +"\"title\": \"TestAPIKey\","
                +"\"key\": \"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICUCo8PW6cmIRthjM//m0ye0jfHzND4b96WlT+Xk/rLu\"" +
                "}";

         Response response =
                given().spec(requestSpec) // Set headers
                        .body(reqBody) // Add request body
                        .when().post(); // Send POST request

        //Print response json
        String resBody = response.asPrettyString();
        System.out.println(resBody);

        // Extract ID from response jason
        JsonPath jsonPathEvaluator = response.jsonPath();
        sshKeyId = jsonPathEvaluator.get("id");
        System.out.println("value of sshkeyid is" + sshKeyId);

        //Assertion for status 201 expected
        //If request is successful, status code will be 200
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 201 /*expected value*/,
                "Correct status code returned");

    }

    @Test(priority=2)
    public void getKey()
    {

        Response response =
                given().spec(requestSpec)
                        .pathParam("keyId", sshKeyId)                      // Add request body
                        .when().get("/{keyId}"); // Send GET request
        // Get the status code of the request.
        //If request is successful, status code will be 200
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 200/*expected value*/, "Correct status code returned");

        String resBody = response.getBody().asPrettyString();
        System.out.println(resBody);
        // Find json path

    }

    @Test(priority=3)
    public void deleteKey()
    {
        //sshKeyId = postKey();
        System.out.println("In method delete" + sshKeyId);
        Response response =
                given().spec(requestSpec) // Set headers
                        .pathParam("keyId",sshKeyId) // Add request body
                        .when().delete("/{keyId}"); // Send Delete request
        String resBody = response.getBody().asPrettyString();
        System.out.println(resBody);

        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 204/*expected value*/, "Correct status code returned");

        String respBody = response.asPrettyString();
        System.out.println(respBody);
        // Find json path

        // Find json path

    }

}
