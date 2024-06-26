package starter.stepdef.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.jsonph.Login.LoginAPI;
import starter.jsonph.Login.LoginResponse;
import starter.utils.Constants;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;


public class ResponseStepDef {


    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(LoginAPI.LOGIN);
    }

    @Then("Status code Login should be {int}")
    public void statusCodeLoginShouldBe(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }

    @And("Response body name should be {string}")
    public void responseBodyNameShouldBe(String message) {
        SerenityRest.and().body(LoginResponse.MESSAGE, equalTo(message));
    }

    @And("Validate login user json schema {string}")
    public void validateLoginUserJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_LOGIN + json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


}