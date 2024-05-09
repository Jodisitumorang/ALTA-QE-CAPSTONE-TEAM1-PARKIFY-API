package starter.stepdef.Parkingslot;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Parkingslot.ParkingSlotAPI;
import starter.utils.Constants;

import java.io.File;

public class DeleteParkingSlotStepDef {

    @Steps
    ParkingSlotAPI parkingSlotAPI;

    @Given("Delete parking slot with valid parameter {} and valid token operator")
    public void deleteParkingSlotWithValidParameterAndValidTokenOperator(int id) {
        parkingSlotAPI.deleteParkingSlotValid(id);
    }

    @When("Send request delete parking slot")
    public void sendRequestDeleteParkingSlot() {
        SerenityRest.when().delete(ParkingSlotAPI.PARKINGS_ID);
    }

    @Then("Status code delete parking slot {int}")
    public void statusCodeDeleteParkingSlot(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }

    @And("Validate delete parking slot json schema {string}")
    public void validateDeleteParkingSlotJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_PARKING_SLOT + json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Delete parking slot with invalid parameter {} and valid token operator")
    public void deleteParkingSlotWithInvalidParameterAndValidTokenOperator(String id) {
        parkingSlotAPI.deleteParkingSlotInvalidParameter(id);
    }

    @Given("Delete parking slot with valid parameter {} and invalid token operator")
    public void deleteParkingSlotWithValidParameterAndInvalidTokenOperator(int id) {
        parkingSlotAPI.deleteParkingSlotInvalidToken(id);
    }
}
