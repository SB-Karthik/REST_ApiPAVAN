package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class createPostRequest {

//    @Test(priority = 1)
//    void postHashmap(){
//        HashMap data = new HashMap();
//        data.put("name","Kiran");
//        data.put("id","4");
//        data.put("age",22);
//        data.put("gender","male");
//
//        String courseArr [] ={"C","C++"};
//        data.put("courses", courseArr);
//
//        given()
//                .contentType("application/json").body(data)
//                .when()
//                .post("http://localhost:3000/students")
//
//                .then()
//                .statusCode(201)
//                .body("name",equalTo("Kiran"))
//                .body("age",equalTo(22))
//                .body("gender",equalTo("male"))
//                .body("courses[0]",equalTo("C"))
//                .body("courses[1]",equalTo("C++"))
//                .header("Content-Type","application/json")
//                .log().all();
//    }


//    @Test(priority = 1)
    void postJsonLibrary(){
        JSONObject data = new JSONObject();

        data.put("name","Kiran");
        data.put("id","4");
        data.put("age",22);
        data.put("gender","male");

        String coursesArr[]={"C","C++"};
        data.put("courses",coursesArr);

        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("Kiran"))
                .body("id",equalTo("4"))
                .body("age",equalTo(22))
                .body("gender",equalTo("male"))
                .body("courses[0]",equalTo("C"))
                .body("courses[1]",equalTo("C++"))
                .header("Content-Type","application/json")
                .log().all();
    }

//    @Test(priority = 1)
    void pojoClass(){
        Pojo_PostReuest data = new Pojo_PostReuest();

        data.setName("Kiran");
        data.setId("4");
        data.setAge(22);
        data.setGender("male");
        String coursesArr[]={"C","C++"};
        data.setCourses(coursesArr);


        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("Kiran"))
                .body("id",equalTo("4"))
                .body("age",equalTo(22))
                .body("gender",equalTo("male"))
                .body("courses[0]",equalTo("C"))
                .body("courses[1]",equalTo("C++"))
                .header("Content-Type","application/json")
                .log().all();
    }

    @Test(priority = 1)
    void externalJson() throws FileNotFoundException {
        File f= new File("/Users/user/Desktop/JAVA/REST_ApiPAVAN/body.json");

        FileReader fr=new FileReader(f);
        JSONTokener jt=new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);


        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("Kiran"))
                .body("id",equalTo("4"))
                .body("age",equalTo(22))
                .body("gender",equalTo("male"))
                .body("courses[0]",equalTo("C"))
                .body("courses[1]",equalTo("C++"))
                .header("Content-Type","application/json")
                .log().all();
    }
    @Test(priority = 2)
    void testDelete(){
        given()
                .when().delete("http://localhost:3000/students/4")
                .then().statusCode(200);
    }

}
