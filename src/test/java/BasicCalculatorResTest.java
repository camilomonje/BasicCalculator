import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicCalculatorResTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing res: 3-1=2")
    public void res() {
        //Arrange
        Long number1 = 3L;
        Long number2 = 1L;
        Long expectedValue = 2L;
        //Act
        Long result = basicCalculator.res(number1,number2);
        //Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several res")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "50,   2,   48",
            "3,    2,   1",
            "10,  51, -41",
            "100,  9, 91"
    })
    public void severalRes(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.res(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }
}