package starter.jsonph.Login;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class LoginAPI {
    public static String LOGIN = Constants.BASE_URL + "/login";

    @Step("Create login user with valid email and password")
    public void postCreateLoginUserWithValidBodyJson(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Create login user with invalid email and valid password")
    public void postCreateLoginUserWithInvalidEmail(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

//  Login Operator
    @Step("Login operator")
    public void postLogiOperator(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

//   Login User
    @Step ("Login User")
    public void postLoginUser (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }



}