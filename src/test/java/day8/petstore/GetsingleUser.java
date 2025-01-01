package day8.petstore;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetsingleUser {

    @Test
    void test_Getuser(ITestContext context){

      String userName = (String) context.getSuite().getAttribute("user_name");
        System.out.println("User Name is : " + userName);

        given()

                .pathParam("username",userName)

                .when()
                .get("https://petstore.swagger.io/v2/user/{username}")

                .then()
                .statusCode(200)
                .log().all();

    }
}
