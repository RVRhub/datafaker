package net.datafaker.optaplanner;

import net.datafaker.Faker;
import net.datafaker.service.RandomService;
import net.datafaker.transformations.Schema;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.config.solver.SolverManagerConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import static net.datafaker.transformations.Field.field;

public class DataGeneratorTest {

    @Test
    void generateData() {

        DataSolution unsolvedSolution = createProblem();

        DataSolution solvedSolution = runCalculation(unsolvedSolution);

        assert solvedSolution != null;
        solvedSolution.getPersonList().stream()
            .filter(person -> PersonSplittingScoreCalculator.isCorrelated(person.getName(), person.getEmail()))
            .distinct()
            .forEach(person -> System.out.println(person.getName() + " -> " + person.getEmail())
            );
    }

    private DataSolution runCalculation(DataSolution unsolvedSolution) {
        SolverFactory<DataSolution> solverFactory = SolverFactory.createFromXmlResource("solverConfig.xml");
        try (SolverManager<DataSolution, UUID> solverManager = SolverManager.create(solverFactory, new SolverManagerConfig())) {
            UUID problemId = UUID.randomUUID();
            var solverJob = solverManager.solve(problemId, unsolvedSolution);
            return solverJob.getFinalBestSolution();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static @NotNull DataSolution createProblem() {
        var initialData = generateInitialData(10);
        initialData.forEach(System.out::println);
        List<String> names = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        initialData.forEach(person -> {
            names.add(person.getName());
            emails.add(person.getEmail());
        });
        DataSolution unsolvedSolution = new DataSolution(names, emails, initialData);
        return unsolvedSolution;
    }

    public static List<PersonOptaPlanner> generateInitialData(int count) {
        var people = new ArrayList<PersonOptaPlanner>(count);
        for (int i = 0; i < count; i++) {
            var person = Faker.populate(PersonOptaPlanner.class);
            people.add(person);
        }

        return people;
    }

    public static Schema<Object, ?> customSchema() {
        var faker = new Faker(Locale.forLanguageTag("en-en"), new RandomService(new Random(1)));
        return Schema.of(
            field("name", () -> faker.internet().username()),
            field("email", () -> faker.internet().emailAddress())
        );
    }
}
