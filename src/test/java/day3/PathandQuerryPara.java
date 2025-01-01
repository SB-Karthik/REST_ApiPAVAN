package day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathandQuerryPara {

//   "https://reqres.in/api/users?page=2&id=5"
    @Test
    void PathandQuerry(){

        given()
                .pathParam("mypath","buy-used-cars-uae")
                .queryParam("sf","city:DU_DUBAI")
                .queryParam("sf","gaId:1685506273.1734681385")

                .when()
                .get("https://stage-consumer-web-ae.qac24svc.dev/{mypath}")
                .then()
                .statusCode(200)
                .log().all();

    }
}
