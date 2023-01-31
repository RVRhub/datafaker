package net.datafaker.providers.entertainment;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HowToTrainYourDragonTest extends EntertainmentFakerTest {

    @Test
    void characters() {
        assertThat(faker.howToTrainYourDragon().characters()).isNotEmpty();
    }

    @Test
    void dragons() {
        assertThat(faker.howToTrainYourDragon().dragons()).isNotEmpty();
    }

    @Test
    void locations() {
        assertThat(faker.howToTrainYourDragon().locations()).isNotEmpty();
    }

}
