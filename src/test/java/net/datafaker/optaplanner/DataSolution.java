package net.datafaker.optaplanner;

import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoftbigdecimal.HardSoftBigDecimalScore;

import java.util.ArrayList;
import java.util.List;

@PlanningSolution
public class DataSolution {
    private List<String> nameRange;
    private List<String> emailRange;
    private List<PersonOptaPlanner> personList;
    private HardSoftBigDecimalScore score = HardSoftBigDecimalScore.ZERO;

    public DataSolution() {
        this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public DataSolution(List<String> nameRange, List<String> emailRange, List<PersonOptaPlanner> personList) {
        this.nameRange = nameRange;
        this.emailRange = emailRange;
        this.personList = personList;
    }

    @ValueRangeProvider(id = "nameRange")
    @ProblemFactCollectionProperty
    public List<String> getNameRange() {
        return nameRange;
    }

    public void setNameRange(List<String> nameRange) {
        this.nameRange = nameRange;
    }

    @ValueRangeProvider(id = "emailRange")
    @ProblemFactCollectionProperty
    public List<String> getEmailRange() {
        return emailRange;
    }

    public void setEmailRange(List<String> emailRange) {
        this.emailRange = emailRange;
    }

    @PlanningEntityCollectionProperty
    public List<PersonOptaPlanner> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonOptaPlanner> personList) {
        this.personList = personList;
    }

    @PlanningScore
    public HardSoftBigDecimalScore getScore() {
        return score;
    }

    public void setScore(HardSoftBigDecimalScore score) {
        this.score = score;
    }
}
