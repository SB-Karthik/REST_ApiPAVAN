package day4;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class parsingJsonData {
    @Test(priority = 1)
    void testJsonResponse(){
        // Approach 1

        /*given()
                .contentType(Content-Type.JSON)
                .when()
                .get("http://localhost:3000/store")

                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .body("books[2].category",equalTo("Classic"));*/


        // Approach 2
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/store");
        Assert.assertEquals(res.getStatusCode(),200);   // validation
        Assert.assertEquals(res.header("Content-Type"),"application/json");
        String bookName= res.jsonPath().get("books[2].category").toString();
        Assert.assertEquals(bookName,"Classic");
    }

    @Test(priority = 2)
    void testJsonResponseData(){

        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/store");

        //using  JsonObject class

        JSONObject jo=new JSONObject(res.asString());    // converting response to JsonObject

        /*for (int i = 0; i < jo.getJSONArray("books").length(); i++)
        {
           String bookTitle = jo.getJSONArray("books").getJSONObject(i).get("category").toString();
           System.out.println(bookTitle);
        }*/

        // search for the tittle of the book in json
        boolean status=false;

        for (int i = 0; i < jo.getJSONArray("books").length(); i++)
        {
            String bookTitle = jo.getJSONArray("books").getJSONObject(i).get("category").toString();
            if (bookTitle.equals("Classic")){
                status=true;
                break;
            }
        }
        Assert.assertEquals(status,true);

        // validate total price of the book
        double totalPrice=0;
        for (int i = 0; i < jo.getJSONArray("books").length(); i++)
        {
            String price = jo.getJSONArray("books").getJSONObject(i).get("price").toString();

            totalPrice=totalPrice+Double.parseDouble(price);
        }

        System.out.println("total price of the price is = "+totalPrice);
        Assert.assertEquals(totalPrice,83.96000000000001);
    }
}
