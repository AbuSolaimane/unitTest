package unitTestfadili.mostafa.unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 
 * @author fadili
 * to name a test method
 * test<Method under test>_<condtion or state change>_<Expected_result>
 */

@DisplayName("Test math operaations class")
class CalculatorTest {

	Calculator calculator;
	
	@BeforeAll
	static void setup() {
		
		System.out.println("Executing @BeforeAll method");
	}
	
	@AfterAll
	static void cleanup() {
		
		System.out.println("Executing @AfterAll method");
	}
	
	@BeforeEach
	void beforeEachTestMethod() {
		
		 calculator = new Calculator();
		 System.out.println("Executing @BeforeEach method");
	}
	
	@AfterEach
	void afterEachTestMethod() {
		
		calculator = null;
		System.out.println("Executing @AfterEach method");
	}
	
	@Test
	@DisplayName("2 + 1")
	void testSum_WhenTwoAddedToOne_ShouldReturnThree() {
		System.out.println("2 + 1");
		//given 
		int num1 = 2;
		int num2 = 1;
		int expected = 3;
		
		//when
		int result = calculator.sum(num1, num2);
		
		//then
		assertEquals(expected, result, "the expected value is not this");
	}
	
	@Test
	@DisplayName("32 - 1")
	void integerSubtraction() {
		System.out.println("32 - 1");
		//given
		int minuend = 32;
		int subtrahend = 1;
		int expected = 31;
		
		//when
		int result = calculator.integerSubtraction(minuend, subtrahend);
		
		//then
		assertEquals(expected, result);
	}
	
	@ParameterizedTest
	@MethodSource("getStreamOfArgumentsTopass")
	@DisplayName("Test integer substraction [minuend - subtrahend = expected]")
	void integerSubtraction(int minuend, int subtrahend, int expected) {
		
		System.out.println(minuend + " - " + subtrahend + " = " + expected);
		
		//when
		int result = calculator.integerSubtraction(minuend, subtrahend);
		
		//then
		assertEquals(expected, result, () -> String.format("%d - %d didn't produce %d", minuend, subtrahend, expected));
	}
	
	private static Stream<Arguments> getStreamOfArgumentsTopass() {
		
		return Stream.of(
					Arguments.of(32, 1, 31),
					Arguments.of(40, 15, 25),
					Arguments.of(14, 5, 9)
				);
	}

	//@Disabled("TODO : still need work on")
	@Test
	@DisplayName("Division by zzero")
	void testIntegerDivision_WhenDivideByZero_ShouldThrowArithEx() {
		System.out.println("Division by zzero");
		//given
		int dividend = 5;
		int divisor = 0;
		String expectedErrorMessage = "cannot divide by 0";
		
		// when & then
		ArithmeticException exception = assertThrows(ArithmeticException.class, () ->
				calculator.integerDivision(dividend, divisor),
				"division by zero should have thrown exception");
		
		//then
		assertEquals(expectedErrorMessage, exception.getMessage(),
				"Unexpected error message");
	}
	
	@ParameterizedTest
	@CsvSource({
		"11, 12, 23",
		"14, 6, 20",
		"3, 6, 9"
	})
	@DisplayName("Test the sum of integer [operand1 + operand2 = expected]")
	void testIntegerSum(int operand1, int operand2, int expected) {
		System.out.println(operand1 + " + " + operand2 + " = " + expected);
		
		//when
		int result = calculator.sum(operand1, operand2);
		
		//then
		assertEquals(expected, result, "the expected value is not this");
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/integerDivision.csv")
	@DisplayName("Division [dividend / divisor = expected]")
	void testIntegerDivision(int dividend, int divisor, int expected) {
		
		// when
		int actual = calculator.integerDivision(dividend, divisor);
		
		//then
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"mostafa", "bilal", "hamza"})
	void testValueSource(String name) {
		
		System.out.println(name);
		assertNotNull(name);
	}
}
