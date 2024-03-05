package StepDef;

import Model.RequestModel.UserReqModel;
import io.cucumber.java.en.Given;
import utils.createUserUtils;

import java.io.IOException;

public class createUserStepDef {

    UserReqModel userReqModel;

    @Given("User Create new user")
    public void userCreateNewUser() throws IOException {
        System.out.println("hi hi hiiii");
        userReqModel = createUserUtils.createUserRequest();
        System.out.println(userReqModel.email + " email");
    }
}
