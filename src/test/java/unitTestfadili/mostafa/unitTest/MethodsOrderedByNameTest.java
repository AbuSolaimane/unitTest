package unitTestfadili.mostafa.unitTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MethodsOrderedByNameTest {

	@Test
	void testA() {
		
		System.out.println("running testA");
	}
	
	@Test
	void testC() {
		
		System.out.println("running testC");
	}
	
	@Test
	void testB() {
		
		System.out.println("running testB");
	}
	
	@Test
	void testD() {
		
		System.out.println("running testD");
	}
}
