package day8.petstore;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class createUser {

    @Test
    void testCreate(ITestContext context){

        Faker faker = new Faker();

        JSONObject data = new JSONObject();

        data.put("id",faker.number().randomDigit());
        data.put("username",faker.name().username());
        data.put("firstName",faker.name().firstName());
        data.put("lastName",faker.name().lastName());
        data.put("email",faker.internet().emailAddress());
        data.put("password",faker.internet().password());
        data.put("phone",faker.phoneNumber().cellPhone());
        data.put("userStatus",0);


        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://petstore.swagger.io/v2/user");

        String userName = data.getString("username");

        System.out.println("User Name is : "+userName);

        context.getSuite().setAttribute("user_name",userName);

    }
}
