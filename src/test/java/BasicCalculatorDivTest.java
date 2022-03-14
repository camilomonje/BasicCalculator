import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorDivTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing Div: 10/0=5")
    public void div() {
        //Arrange
        Long number1 = 10L;
        Long number2 = 0L;
        Long expectedValue = 5L;
        if (number2 != 0L) {
            //Act
            Long result = basicCalculator.div(number1,number2);
            //Assert
            assertEquals(expectedValue, result);
        }else {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                basicCalculator.div(number1, number2);
            });

            String expectedMessage = "No se puede dividir por cero";

            assertEquals(expectedMessage, exception.getMessage());
        }

    }

    @DisplayName("Testing several Divs")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "0,   51,   0",
            "6,    2,   3",
            "99,  33, 3",
            "5,  1, 5"
    })
    public void severalDivs(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.div(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }

}