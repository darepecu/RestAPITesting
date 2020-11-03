package steps;

import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

import static io.restassured.RestAssured.given;

public class test {

    public void testing(String endPoint){

        Response response = given()
                .log().all()
                .contentType("application/json")
                .body("{\"name\":\"empleado de Juan\",\"salary\":\"123\",\"age\":\"23\"}")
                .post(endPoint);
    }
}
