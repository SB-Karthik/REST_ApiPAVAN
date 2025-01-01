package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteUser {

    @Test
    void test_deleteUser(ITestContext context){
        String bearerToken ="e12a163b8d5864b0bd8a8ef7616ecf4bef4fac547c518de17c872733518c8af4";

//        int id = (int) context.getAttribute("user_id");
        int id = (int) context.getSuite().getAttribute("user_id");
        given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("id",id)

                .when()
                .delete("https://gorest.co.in/public/v2/users/{id}")

                .then()
                .statusCode(204)
                .log().all();

    }
}
