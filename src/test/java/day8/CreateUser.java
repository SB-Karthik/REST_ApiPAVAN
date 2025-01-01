package day8;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {
    @Test
    void test_createUser(ITestContext context) {
        // to create request data we are using org

        Faker faker = new Faker();

        JSONObject data = new JSONObject();

        data.put("name", faker.name().fullName());
        data.put("gender", "Male");
        data.put("email", faker.internet().emailAddress());
        data.put("status", "inactive");

        String bearerToken = "e12a163b8d5864b0bd8a8ef7616ecf4bef4fac547c518de17c872733518c8af4";

        int id = given()
                .header("Authorization", "Bearer " + bearerToken)
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .jsonPath().getInt("id");

        System.out.println("Generated id is :" + id);

//        context.setAttribute("user_id",id);
        context.getSuite().setAttribute("user_id", id);

    }
}
