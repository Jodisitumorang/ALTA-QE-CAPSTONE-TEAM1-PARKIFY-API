package starter.stepdef.Transaction;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Transaction.TransactionAPI;
import starter.utils.Constants;
import java.io.File;


public class PostTransactionStepDef {

    @Steps
    TransactionAPI transactionAPI;

    //    POSITIVE
    @Given("Post create transaction with body json {string} and token user")
    public void postCreateTransactionWithBodyJsonAndTokenUser(String json) {
        File jsonFile = new File(Constants.REQ_BODY_TRANSACTION + json);
        transactionAPI.postTransactionValidBodyJson(jsonFile);
    }

    @When("Send request post transaction")
    public void sendRequestPostTransaction() {
        SerenityRest.when().post(TransactionAPI.TRANSACTION);
    }


    //    NEGATIVE
    @Given("Post create transaction with invalid body json {string} and valid token user")
    public void postCreateTransactionWithInvalidBodyJsonAndValidTokenUser(String json) {
        File jsonFile = new File(Constants.REQ_BODY_TRANSACTION + json);
        transactionAPI.postTransactionInvalidBodyJson(jsonFile);
    }

    @Given("Post create transaction with valid body json {string} and invalid token user")
    public void postCreateTransactionWithValidBodyJsonAndInvalidTokenUser(String json) {
        File jsonFile = new File(Constants.REQ_BODY_TRANSACTION + json);
        transactionAPI.postTransactionInvalidToken(jsonFile);
    }
}