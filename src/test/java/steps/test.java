package steps;


import io.restassured.response.Response;
import models.aggregates.Age;
import models.aggregates.Name;
import models.aggregates.Salary;
import models.payloads.Employee;

import net.serenitybdd.rest.SerenityRest;


public class test {

    public void testing(String endPoint){

        Age age = Age.builder()
                .age("10")
                .build();

        Name name = Name.builder()
                .name("Employeeeeeee")
                .build();

        Salary salary = Salary.builder()
                .salary("1234567890")
                .build();

        Employee employee = Employee.builder()
                .name(name)
                .salary(salary)
                .age(age)
                .build();


        Response response = SerenityRest.given()
                .log().all()
                .contentType("application/json")
                .body(employee)
                .post(endPoint);

        response.prettyPrint();

    }
}
