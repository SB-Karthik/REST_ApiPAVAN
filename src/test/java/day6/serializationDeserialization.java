package day6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;



// POJO ---- SERIALIZE --- JSON  Object -- de-serialize ---> Pojo
public class serializationDeserialization {

    // POJo -----> JSON
//    @Test
     void  convertPojo2Json() throws JsonProcessingException {

        // Created java object using pojo class
        Student stupojo = new Student();

        stupojo.setName("Kiran");
        stupojo.setId("4");
        stupojo.setAge(22);
        stupojo.setGender("male");
        String coursesArr[]={"C","C++"};
        stupojo.setCourses(coursesArr);

        // convert java object --> json object (serialization)

        ObjectMapper objectMapper=new ObjectMapper();
        String jsondata=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
        System.out.println(jsondata);

    }

//    Json ----> POJO (De-serialization)
    @Test
    void  convertJson2Pojo() throws JsonProcessingException {

        String jsondata ="{\n" +
                "  \"name\" : \"Kiran\",\n" +
                "  \"id\" : \"4\",\n" +
                "  \"age\" : 22,\n" +
                "  \"gender\" : \"male\",\n" +
                "  \"courses\" : [ \"C\", \"C++\" ]\n" +
                "}";

        // convert java data --> pojo object (de serialization)
        ObjectMapper objMapper=new ObjectMapper();
        Student stupojo =objMapper.readValue(jsondata,Student.class);

        System.out.println("Name : "+stupojo.getName());
        System.out.println("Age : "+stupojo.getAge());
        System.out.println("Id : "+stupojo.getId());
        System.out.println("Gender : "+stupojo.getGender());
        System.out.println("Corses 1 : "+stupojo.getCourses()[0]);
        System.out.println("Course 2 : "+stupojo.getCourses()[1]);

    }
}
