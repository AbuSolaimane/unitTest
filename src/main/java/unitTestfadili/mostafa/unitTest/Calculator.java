package unitTestfadili.mostafa.unitTest;

public class Calculator {

	public int sum (int a, int b) {
		
		return a + b;
	}
	
	public int integerSubtraction(int minuend, int subtrahend) {
		return minuend - subtrahend;
	}
	
	public int integerDivision(int divided, int dividing) throws ArithmeticException {
		
		if (dividing == 0)
			throw new ArithmeticException("cannot divide by 0");
		
		return divided / dividing;
	}
}
