package unitTestfadili.mostafa.unitTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodsOrderedByOrderIndexTest {

	@Order(1)
	@Test
	void testA() {
		
		System.out.println("running testA");
	}
	
	@Order(2)
	@Test
	void testC() {
		
		System.out.println("running testC");
	}
	
	@Order(3)
	@Test
	void testB() {
		
		System.out.println("running testB");
	}
	
	@Order(4)
	@Test
	void testD() {
		
		System.out.println("running testD");
	}
}
