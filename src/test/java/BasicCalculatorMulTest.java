import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicCalculatorMulTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing Mult: 5*2=10")
    public void mult() {
        //Arrange
        Long number1 = 5L;
        Long number2 = 2L;
        Long expectedValue = 10L;
        //Act
        Long result = basicCalculator.mult(number1,number2);
        //Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several mults")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "0,   51,   0",
            "3,    2,   6",
            "10,  51, 510",
            "1,  105, 105"
    })
    public void severalMults(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.mult(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

}