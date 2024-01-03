package demo;

import com.epam.demo.Utils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(new String[]{"11.22", "2", "33", "87"}), true),
                Arguments.of(Arrays.asList(new String[]{"-11.22", "2", "33", "87"}), false),
                Arguments.of(Arrays.asList(new String[]{"-11.22", "0", "33", "87"}), false),
                Arguments.of(Arrays.asList(new String[]{"11", "0"}), false),
                Arguments.of(Arrays.asList(new String[]{""}), false),
                Arguments.of(Arrays.asList(new String[]{}), false)
        );
    }

    @MethodSource("argumentProvider")
    @ParameterizedTest
    void test(List<String> args, boolean expectedResult) {
        assertEquals(expectedResult, Utils.isAllPositiveNumbers(args));
    }
}
