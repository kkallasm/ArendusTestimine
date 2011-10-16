package kodune_yl;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingCalcTests {

	@Test
	public void Test1() {
		BowlingCalc calc = new BowlingCalc();
	}
	
	@Test
	public void Test2() {
		BowlingCalc calc = new BowlingCalc();
		for (int i = 0; i < 20; i++) { // 20 viset iga kord üks maha
			calc.hit(1);
		}
		assertEquals(20, calc.getScore());
	}
	
	@Test
	public void Test3() {
		BowlingCalc calc = new BowlingCalc();
		for (int i = 0; i < 20; i++) {
			calc.hit(2);
		}
		assertEquals(40, calc.getScore());
	}
	
	@Test
	public void Test4() {
		BowlingCalc calc = new BowlingCalc();
		for (int i = 0; i < 21; i++) {
			calc.hit(5);
		}
		assertEquals(150, calc.getScore());
	}
	
	@Test
	public void Test5() {
		BowlingCalc calc = new BowlingCalc();
		for (int i = 0; i < 21; i++) {
			calc.hit(10);
		}
		//TODO
	}
	
	@Test
	public void Test6() {
		BowlingCalc calc = new BowlingCalc();
		calc.hit(4);
		calc.hit(5);
		calc.hit(8);
		calc.hit(2);
		calc.hit(10);
		
		//TODO: ...
	}
	
}
