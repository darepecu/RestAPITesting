package models.payloads;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.aggregates.Age;
import models.aggregates.Name;
import models.aggregates.Salary;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @Builder

@JsonPropertyOrder({
        "name",
        "salary",
        "age"
})
public class Employee {
    private Name name;
    private Salary salary;
    private Age age;
}
