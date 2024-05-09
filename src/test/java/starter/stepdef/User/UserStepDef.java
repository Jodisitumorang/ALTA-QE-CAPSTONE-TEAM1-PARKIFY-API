package starter.stepdef.User;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.User.UserAPI;
import starter.utils.Constants;
import java.io.File;


public class UserStepDef {

    @Steps
    UserAPI userAPI;

    //POSITIVE
    @Given("Create add a new user with valid json {string}")
    public void createAddANewUserWithValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY_USER + json);
        userAPI.postCreateUserValidJson(jsonFile);
    }

    @When("Send request create add a new user")
    public void sendRequestCreateAddANewUser() {
        SerenityRest.when().post(UserAPI.USER);
    }


    //NEGATIVE
    @Given("Create add a new user with invalid json {string}")
    public void createAddANewUserWithInvalidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY_USER + json);
        userAPI.postCreateUserInvalidJson(jsonFile);

    }


}

