package steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;

public class StepDefinitions {

    private String user;
    private String place;
    private String placeId;
    private String operation;

    RequestController requestController = new RequestController();

    @Dado("que {word} esta en la busqueda de informacion de {word} con {word}")
    public void query_by_place(String user, String place, String placeID ) {
        this.user = user;
        this.place = place;
        this.placeId = placeID;
        this.operation = "query_by_place";
    }

    @Dado("que {word} esta en la busqueda de un {word}")
    public void query_by_keyword(String user, String place) {
        this.user = user;
        this.place = place;
        this.operation = "query_by_keyword";
    }

    @Cuando("el\\/ella haga la solicitud de busqueda a Google Maps")
    public void send_request() {

        if (this.operation.equals("query_by_keyword")){
            requestController.requestQueryKeyword(this.place);
        }
        else if (this.operation.equals("query_by_place")){
            requestController.requestQueryPlace(this.placeId);
        }
        else {
            System.out.println("Favor Validar la Operación enviada");
        }

    }

    @Entonces("se muestra la información básica del lugar")
    public void basic_data_place() {
        Ensure.that("El codigo de Respuesta sea un 200.", response -> response.statusCode(200));

        JsonSchemaValidator jsonSchemaValidator = JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/200_basic_data_place.json");
        Ensure.that("Validando Estrucutra de respuesta con JsonSchema",
                response -> response.assertThat().body(jsonSchemaValidator));

        SerenityRest.lastResponse().prettyPrint();
    }

    @Entonces("se muestran los resultados de la busqueda")
    public void query_results() {
        Ensure.that("El codigo de Respuesta sea un 200.", response -> response.statusCode(200));

        JsonSchemaValidator jsonSchemaValidator = JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/200_query_results.json");
        Ensure.that("Validando Estrucutra de respuesta con JsonSchema",
                response -> response.assertThat().body(jsonSchemaValidator));

        SerenityRest.lastResponse().prettyPrint();
    }
}
