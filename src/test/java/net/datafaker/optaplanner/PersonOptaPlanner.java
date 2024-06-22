package net.datafaker.optaplanner;

import net.datafaker.annotations.FakeForSchema;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.Objects;

@FakeForSchema("net.datafaker.optaplanner.DataGeneratorTest#customSchema")
@PlanningEntity
public class PersonOptaPlanner {
    private String name;
    private String email;

    public PersonOptaPlanner() {
    }

    public PersonOptaPlanner(String newName, String newEmail) {
        name = newName;
        email = newEmail;
    }

    @PlanningVariable(valueRangeProviderRefs = "nameRange")
    public String getName() {
        return name;
    }

    @PlanningVariable(valueRangeProviderRefs = "emailRange")
    public String getEmail() {
        return email;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setEmail(String newEmail) {
        email = newEmail;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonOptaPlanner that = (PersonOptaPlanner) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    @Override
    public String toString() {
        return "PersonOptaPlanner{" +
            "name='" + getName() + '\'' +
            ", email='" + getEmail() + '\'' +
            '}';
    }
}
