package steps;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.configuration.SystemPropertiesConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;

public class BusinessController {

    private static final Configuration configuration = new SystemPropertiesConfiguration(
            SystemEnvironmentVariables.createEnvironmentVariables());

    private static final EnvironmentVariables environmentVariables = configuration
            .getEnvironmentVariables();

    String webServicesEndpoint;

    public BusinessController() {
        this.webServicesEndpoint = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("endpoint");
    }


    public String getURLQueryKeyword() {
        return this.webServicesEndpoint + "textsearch/json";
    }

    public String getURLQueryPlace() {
        return this.webServicesEndpoint + "details/json";
    }
}
