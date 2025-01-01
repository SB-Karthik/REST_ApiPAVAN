package day8.petstore;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {
    @Test
    void test_deleteUser(ITestContext context){

        String userName = (String) context.getSuite().getAttribute("user_name");

        given()
                .pathParam("username",userName)

                .when()
                .delete("https://petstore.swagger.io/v2/user/{username}")

                .then()
                .statusCode(200)
                .log().all();

    }
}
