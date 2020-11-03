package steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

import static io.restassured.RestAssured.given;

public class StepDefinitions {

    private EnvironmentVariables environmentVariables;

    @Dado("que Juan como usuario desea crear un evento")
    public void que_Juan_como_usuario_desea_crear_un_evento() {
        System.out.println("Vamos a Crear un Empleado");
    }

    @Cuando("Envíe la información correcta")
    public void envíe_la_información_correcta() {

        String webServicesEndpoint = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base");

       test test = new test();

       test.testing(webServicesEndpoint+"create");

        //response.prettyPrint();

    }

    @Entonces("se crea el evento")
    public void se_crea_el_evento() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Dado("que Juan como usuario desea consultar los eventos")
    public void que_Juan_como_usuario_desea_consultar_los_eventos() {
        System.out.println("Vamos a Consultar los empleados");
    }

    @Cuando("Juan envíe la petición de consulta")
    public void juan_envíe_la_petición_de_consulta() {
        String webServicesEndpoint = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base");

        Response response = given()
                .log().all()
                .get(webServicesEndpoint+"employees");

        //response.prettyPrint();
    }

    @Entonces("se muestan los eventos creados")
    public void se_muestan_los_eventos_creados() {
        // Write code here that turns the phrase above into concrete actions

    }
}
