package unitTestfadili.mostafa.unitTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
public class MethodsOrderedRandomlyTest {

	@Test
	void testA() {
		
		System.out.println("running testA");
	}
	
	@Test
	void testB() {
		
		System.out.println("running testB");
	}
	
	@Test
	void testC() {
		
		System.out.println("running testC");
	}
	
	@Test
	void testD() {
		
		System.out.println("running testD");
	}
}
