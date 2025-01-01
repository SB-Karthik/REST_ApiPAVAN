package day7;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Authentications {

//    @Test
    void  testBasicAuthentication(){
        given()
                .auth().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

//    @Test
    void  testDigestAuthentication(){
        given()
                .auth().digest("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

//    @Test
    void  testPreemptiveAuthentication(){
        given()
                .auth().preemptive().basic("postman","password")

        .when()
                .get("https://postman-echo.com/basic-auth")

        .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

//    @Test
    void testBearerToken(){

        String bearerToken ="provide token";
        given()
                .header("Authentication","Bearer "+bearerToken)

                .when()
                     .get("url")

                .then()
                     .statusCode(200)
                     .log().all();
    }

//    @Test
    void testOauth2(){

        given()
                .auth().oauth2("provide token here")

                .when()
                      .get("url")

                .then()
                     .statusCode(200)
                     .log().all();
    }


    @Test
    void testApiKey(){

//        Method1
        /*given()
                .queryParam("appid","provide api key")

                .when()
                .get("https://stage-consumer-web-ae.qac24svc.dev/buy-used-cars-dubai?sf=city:DU_DUBAI&sf=gaId:1685506273.1734681385")

                .then()
                .statusCode(200)
                .log().all();*/

//        Method2
        /*given()
                .queryParam("appid","api key")
                .pathParam("mypath","buy-used-cars-dubai")
                .queryParam("sf","city:DU_DUBAI")
                .queryParam("sf","gaId:1685506273.1734681385")
        .when()
                .get("https://stage-consumer-web-ae.qac24svc.dev/")

                .then()
                .statusCode(200)
                .log().all();*/

    }
}
