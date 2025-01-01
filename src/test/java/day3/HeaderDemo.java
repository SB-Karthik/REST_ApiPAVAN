package day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeaderDemo {
//    @Test
    void testHeaders(){

        given()

                .when()
                .get("https://www.cars24.ae/")
                .then()
                .header("Content-Type","text/html; charset=utf-8")
                .header("Content-Encoding","gzip")
                .header("Server","cloudflare");


    }

    @Test
    void getHeaders(){

       Response res = given()

                .when()
                .get("https://www.cars24.ae/");

               // get single header info
//         String headrerValue = res.getHeader("Content-Type");
//        System.out.println("The Value of the Content-Type header is "+headrerValue);


        // get all headers info
        Headers myheaders =res.getHeaders();
        for (Header hd:myheaders)
        {
            System.out.println(hd.getName()+"        "+hd.getValue());
        }
    }
}
