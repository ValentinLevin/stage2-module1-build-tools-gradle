package utils;

import com.epam.utils.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilsTest {

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
                Arguments.of("088", false),
                Arguments.of("0", false),
                Arguments.of("-11.88", false),
                Arguments.of("8080", true),
                Arguments.of("19.90", true),
                Arguments.of("", false)
        );
    }

    @MethodSource("argumentProvider")
    @ParameterizedTest
    void test(String arg, boolean expectedResult) {
        assertEquals(expectedResult, StringUtils.isPositiveNumber(arg));
    }
}
