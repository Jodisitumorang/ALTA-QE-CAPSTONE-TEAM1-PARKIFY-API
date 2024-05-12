package starter.jsonph.Transaction;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.stepdef.Login.LoginOperatorStepDef;
import starter.utils.Constants;

import java.io.File;

public class TransactionAPI {


    public static String TRANSACTION = Constants.BASE_URL + "/transaction";
    public static String TRANSACTION_ID = Constants.BASE_URL + "/transaction/{id}";
    public static String TOKEN_OPERATOR = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImpvZGlvcGVyYXRvcjJAZ21haWwuY29tIiwiZXhwIjoxNzE1MDE3MDA4LCJpYXQiOjE3MTUwMDYyMDgsInJvbGUiOiJvcGVyYXRvciJ9.iCl_rQZCwtuT7sDX7Pr762XAgR_FvjHH7iRvbgk3Ua8";
    public static String TOKEN_INVALID = "saad";


    //  Post Transaction
//    Method POST
//    POSITIVE
    @Step("Post create transaction with valid body json and valid token user")
    public void postTransactionValidBodyJson(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + LoginOperatorStepDef.token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //    NEGATIVE
    @Step("Post create transaction with invalid body json and valid token user")
    public void postTransactionInvalidBodyJson(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + LoginOperatorStepDef.token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create transaction with valid body json and invalid token user")
    public void postTransactionInvalidToken(File json) {
        SerenityRest.given()
                .header("Authorization", TOKEN_INVALID)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //    Get Transaction
//    Method GET
//    POSITIVE
    @Step("Get transaction with valid parameter id and valid token operator")
    public void getTransactionValidData(int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .header("Authorization","Bearer "+LoginOperatorStepDef.token);
    }

    //    NEGATIVE
    @Step("Get transaction with invalid parameter id and valid token operator")
    public void getTransactionInvalidParameter(String id) {
        SerenityRest.given()
                .pathParam("id", id)
                .header("Authorization","Bearer "+LoginOperatorStepDef.token);
    }

    @Step("Get transaction id with valid parameter id and invalid token operator")
    public void getTransactionInvalidToken(int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .header("Authorization", TOKEN_INVALID);
    }


}