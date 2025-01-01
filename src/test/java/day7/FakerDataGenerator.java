package day7;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {

    @Test
    void testGenerateDummyDAta(){
        Faker faker =new Faker();

        String fullname = faker.name().fullName();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();

        String username = faker.name().username();
        String password = faker.internet().password();
        String phonenumber = faker.phoneNumber().cellPhone();

        String email = faker.internet().safeEmailAddress();

        System.out.println("Full name :"+fullname);
        System.out.println("First name :"+firstname);
        System.out.println("last name :"+lastname);
        System.out.println("User name :"+username);
        System.out.println("Password :"+password);
        System.out.println("Phone :"+phonenumber);
        System.out.println("Email :"+email);

    }
}
