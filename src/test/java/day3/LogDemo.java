package day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LogDemo {
    @Test
    void testLogs(){
        given()
                .when()
                .get("https://www.cars24.ae/")
                .then()
//                .log().body();
//                .log().cookies();
                .log().headers();
    }
}
