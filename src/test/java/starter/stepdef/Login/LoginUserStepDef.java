package starter.stepdef.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Login.LoginAPI;
import starter.jsonph.Parking.ParkingAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginUserStepDef {

    public static String token;


    @Steps
    LoginAPI loginAPI;

    @Given("User  login with email {string}")
    public void userLoginWithEmail(String json) {
        File jsonFile = new File(Constants.REQ_BODY_Login+json);
        loginAPI.postLoginUser(jsonFile);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }



}
