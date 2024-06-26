package net.datafaker.idnumbers;

import net.datafaker.AbstractFakerTest;
import net.datafaker.providers.base.BaseFaker;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

class ChineseIdNumberTest extends AbstractFakerTest {
    private final BaseFaker faker = new BaseFaker(new Locale("zh", "CN"));

    @RepeatedTest(10)
    void testValidChineseIdNumber() {
        String idNumber = faker.idNumber().valid();
        final int length = idNumber.length();
        assertThatSsnNumberValid(length, idNumber);
    }

    @RepeatedTest(10)
    void testChecksumOfChineseIdNumber() {
        String s = faker.idNumber().valid();
        boolean isSatisfied = true;
        int count = 0;
        count += (s.charAt(0) - '0') * 7;
        count += (s.charAt(1) - '0') * 9;
        count += (s.charAt(2) - '0') * 10;
        count += (s.charAt(3) - '0') * 5;
        count += (s.charAt(4) - '0') * 8;
        count += (s.charAt(5) - '0') * 4;
        count += (s.charAt(6) - '0') * 2;
        count += (s.charAt(7) - '0');
        count += (s.charAt(8) - '0') * 6;
        count += (s.charAt(9) - '0') * 3;
        count += (s.charAt(10) - '0') * 7;
        count += (s.charAt(11) - '0') * 9;
        count += (s.charAt(12) - '0') * 10;
        count += (s.charAt(13) - '0') * 5;
        count += (s.charAt(14) - '0') * 8;
        count += (s.charAt(15) - '0') * 4;
        count += (s.charAt(16) - '0') * 2;
        count %= 11;
        if (count == 10) {
            if (s.charAt(17) != 'X') isSatisfied = false;
        } else if ((s.charAt(17) - '0') != count) isSatisfied = false;
        assertThat(isSatisfied).isTrue();
    }

    @RepeatedTest(100)
    void testValidZhCnIdNumber() {
        ChineseIdNumber id = new ChineseIdNumber();
        String idNumber = id.generateValid(faker);
        assertThatSsnNumberValid(idNumber.length(), idNumber);
    }

    private static void assertThatSsnNumberValid(int idNumber, String idNumber1) {
        boolean isSatisfied = idNumber == 18;
        for (int j = 0; j < idNumber; j++) {
            char ch = idNumber1.charAt(j);
            if (j != idNumber - 1) {
                if (ch > '9' || ch < '0') {
                    isSatisfied = false;
                    break;
                }
            } else {
                if ((ch > '9' || ch < '0') && ch != 'X') {
                    isSatisfied = false;
                    break;
                }
            }
        }
        assertThat(isSatisfied).isTrue();
    }
}
