package day8.petstore;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {
    @Test
    void test_updateUser(ITestContext context){

        Faker faker=new Faker();

        JSONObject data =new JSONObject();

        data.put("email",faker.internet().emailAddress());
        data.put("password",faker.internet().password());
        data.put("phone",faker.phoneNumber().cellPhone());

        String userName = (String) context.getSuite().getAttribute("user_name");
        given()

                .contentType("application/json")
                .pathParam("username",userName)
                .body(data.toString())

                .when()
                .put("https://petstore.swagger.io/v2/user/{username}")

                .then()
                .statusCode(200)
                .log().all();
        System.out.println(userName);

    }
}
