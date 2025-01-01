package day8;

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

        data.put("name",faker.name().fullName());
        data.put("gender","Male");
        data.put("status","active");

        String bearerToken = "e12a163b8d5864b0bd8a8ef7616ecf4bef4fac547c518de17c872733518c8af4";

//        int id = (int) context.getAttribute("user_id");
        int id = (int) context.getSuite().getAttribute("user_id");
        given()
                .header("Authorization","Bearer " + bearerToken)
                .contentType("application/json")
                .pathParam("id",id)
                .body(data.toString())

        .when()
                .put("https://gorest.co.in/public/v2/users/{id}")

        .then()
                .statusCode(200)
                .log().all();

    }
}
