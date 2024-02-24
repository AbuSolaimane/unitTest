package unitTestfadili.mostafa.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class DemoRepeatedTest {

	private Calculator calculator;

	@BeforeEach
	void beforeEachTestMethod() {
		
		 calculator = new Calculator();
		 System.out.println("Executing @BeforeEach method");
	}
	
	@RepeatedTest(value = 3, name = "{displayName}, "
			+ "Repeatition # {currentRepetition} of {totalRepetitions}")
	@DisplayName("sum 2 integers")
	void testSum_WhenTwoAddedToOne_ShouldReturnThree(
					RepetitionInfo repetitionInfo,
					TestInfo testInfo
					) {
		
		System.out.println("Running " + testInfo.getTestMethod().get().getName());
		System.out.println("repetition #" + repetitionInfo.getCurrentRepetition()
						+ " of " + repetitionInfo.getTotalRepetitions());
		//given 
		int num1 = 2;
		int num2 = 1;
		int expected = 3;
		
		//when
		int result = calculator.sum(num1, num2);
		
		//then
		assertEquals(expected, result, "the expected value is not this");
	}
}
