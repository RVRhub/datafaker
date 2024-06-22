package net.datafaker.optaplanner;

import org.optaplanner.core.api.score.buildin.hardsoftbigdecimal.HardSoftBigDecimalScore;
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator;

import java.math.BigDecimal;
import java.util.Arrays;

public class PersonSplittingScoreCalculator implements EasyScoreCalculator<DataSolution, HardSoftBigDecimalScore> {

    @Override
    public HardSoftBigDecimalScore calculateScore(DataSolution solution) {
        int hardScore = 0;
        int softScore = 0;
        for (PersonOptaPlanner person : solution.getPersonList()) {
            if (isCorrelated(person.getName(), person.getEmail())) {
                hardScore++;
            } else {
                softScore++;
            }
        }
        return HardSoftBigDecimalScore.of(new BigDecimal(hardScore), new BigDecimal(softScore));
    }

    public static boolean isCorrelated(String name, String email) {
        String[] splitedEmail = email.split("@")[0].split("\\.");
        String[] splitedName = name.split("\\.");

        return Arrays.stream(splitedName)
            .allMatch(namePart -> Arrays.asList(splitedEmail).contains(namePart));

    }
}
