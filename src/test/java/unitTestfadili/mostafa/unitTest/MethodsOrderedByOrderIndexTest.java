package unitTestfadili.mostafa.unitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodsOrderedByOrderIndexTest {

	private StringBuilder completed = new StringBuilder("");
	
	@AfterEach
	void printCompletedVariable() {
		
		System.out.println("the state of completed is : " + completed);
	}
	
	@Order(1)
	@Test
	void testA() {
		
		System.out.println("running testA");
		completed.append("1");
	}
	
	@Order(2)
	@Test
	void testC() {
		
		System.out.println("running testC");
		completed.append("2");
	}
	
	@Order(3)
	@Test
	void testB() {
		
		System.out.println("running testB");
		completed.append("3");
	}
	
	@Order(4)
	@Test
	void testD() {
		
		System.out.println("running testD");
		completed.append("4");
	}
}
