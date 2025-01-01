package day3;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CookiesDemo {

//    @Test
    void testCookies(){

        given()

                .when()
                .get("https://www.google.cm/")
                .then()
                .cookies("AEC","AZ6Zc-U1XPKZ4Tosm6wVakCA3J51WXO6qAjeQqkkPxHlUC86GiVtrvyNC5k" )
                .log().all();

    }

    @Test
    void getCookiesInfo(){

        Response res=given()
                .when()
                .get("https://www.google.cm/");

        // get single cookie info
//        String cookie_value = res.getCookie("AEC");
//        System.out.println("Value of cookie is ====== "+cookie_value);

        // get all the cookies
       Map<String, String> cookies_value = res.getCookies();
//        System.out.println(cookie_value.keySet());
        for (String k:cookies_value.keySet()){
            String cookie_value=res.getCookie(k);
            System.out.println(k+"       "+cookie_value);
        }
    }
}
