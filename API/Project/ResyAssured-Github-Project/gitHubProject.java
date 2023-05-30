package Project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

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


public class gitHubProject {

    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICUCo8PW6cmIRthjM//m0ye0jfHzND4b96WlT+Xk/rLu gmx";
int sshKeyId;
//Request Specification
    @BeforeClass
    public void setup() {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com/user/keys").addHeader("Authorization", "Bearer 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")
                .addHeader("Content-Type", "application/json")
                .build();

        //Response Specification
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                // Check response content type
                .expectContentType("application/json")
                .build();

    }

    @Test(priority=1)
    public int postKey()
    {
        String reqBody = "{" +"\"title\": \"TestAPIKey\","
                +"\"key\": \"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICUCo8PW6cmIRthjM//m0ye0jfHzND4b96WlT+Xk/rLu gmx\"" +
                "}";

        Response response =
                given().auth().oauth2("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").contentType(ContentType.JSON) // Set headers
                        .body(reqBody) // Add request body
                        .when().post("https://api.github.com/user/keys"); // Send POST request

        //Assertion
        // Get the status code of the request.
        //If request is successful, status code will be 200
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 201/*expected value*/,
                "Correct status code returned");

        // Get response body
        String resBody = response.getBody().asPrettyString();
        System.out.println(resBody);
        // Find json path
        JsonPath jsonPathEvaluator = response.jsonPath();
        // Store value of sshKeyID from response json
        int sshKeyId = jsonPathEvaluator.get("id");
        System.out.println(sshKeyId);
        return sshKeyId;

    }

    @Test(priority=2)
    public void getKey()
    {
        Response response =
                given().auth().oauth2("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").contentType(ContentType.JSON)
                        // Add request body
                        .when().get("https://api.github.com/user/emails"); // Send GET request
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
        sshKeyId = postKey();
        System.out.println("In method delete" + sshKeyId);
        Response response =
                given().auth().oauth2("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").contentType(ContentType.JSON) // Set headers
                        .pathParam("keyId",sshKeyId) // Add request body
                        .when().delete("https://api.github.com/user/keys/{keyId}"); // Send Delete request
        String resBody = response.getBody().asPrettyString();
        System.out.println(resBody);

        // Get the status code of the request.
        //If request is successful, status code will be 200
        int statusCode = response.getStatusCode();
        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 204/*expected value*/,
                "Correct status code returned");


        // Find json path

    }

}
