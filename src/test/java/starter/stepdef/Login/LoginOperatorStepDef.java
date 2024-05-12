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

public class LoginOperatorStepDef {

    public static String token;


    @Steps
    LoginAPI loginAPI;

    @Given("User operator login with email {string}")
    public void userOperatorLoginWithEmail(String json) {
        File jsonFile = new File(Constants.REQ_BODY_PARKING + json);
        loginAPI.postLogiOperator(jsonFile);
    }

    @When("Send request post login operator")
    public void sendRequestPostLoginOperator() {
        Response response = SerenityRest.when().post(ParkingAPI.LOGIN);
        JsonPath jsonPathEvaluator = response.jsonPath();
        token = jsonPathEvaluator.get("data.token");
        System.out.println(token);
    }

    @Then("Status code login operator should be {int}")
    public void statusCodeLoginOperatorShouldBe(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }
}
