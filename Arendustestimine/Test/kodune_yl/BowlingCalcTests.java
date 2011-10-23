package kodune_yl;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingCalcTests {

	@SuppressWarnings("unused")
	@Test
	public void Test1() {
		BowlingCalc calc = new BowlingCalc();
	}
	
	@Test
	public void Test2() throws Exception {
		BowlingCalc calc = new BowlingCalc();
		for (int i = 0; i < 20; i++) { // 20 viset iga kord üks maha
			calc.hit(1);
		}
		assertEquals(20, calc.getScore());
	}
	
	@Test
	public void Test3() throws Exception {
		BowlingCalc calc = new BowlingCalc();
		for (int i = 0; i < 20; i++) {
			calc.hit(2);
		}
		assertEquals(40, calc.getScore());
	}
	
	@Test
	public void Test4() throws Exception {
		BowlingCalc calc = new BowlingCalc();
		for (int i = 0; i < 21; i++) {
			calc.hit(5);
		}
		assertEquals(150, calc.getScore());
	}
	
	@Test(expected = Exception.class)
	public void Test5() throws Exception {
		BowlingCalc calc = new BowlingCalc();
		for (int i = 0; i < 21; i++) {
			calc.hit(10);
		}
	}
	
	@Test
	public void Test7() throws Exception {
		BowlingCalc calc = new BowlingCalc();
		calc.hit(10);
		calc.hit(10);
		calc.hit(10);
		calc.hit(10);
		calc.hit(10);
		calc.hit(10);
		calc.hit(10);
		calc.hit(10);
		calc.hit(10);
		calc.hit(10);
		calc.hit(10);
		calc.hit(10);
		calc.hit(10);
		assertEquals(300, calc.getScore());
	}
	
	@Test
	public void Test8() throws Exception {
		BowlingCalc calc = new BowlingCalc();
		calc.hit(3);
		calc.hit(5);
		calc.hit(5);
		calc.hit(5);
		calc.hit(2);
		calc.hit(5);
		calc.hit(10);
		calc.hit(2);
		calc.hit(8);
		calc.hit(10);
		calc.hit(5);
		calc.hit(2);
		calc.hit(7);
		calc.hit(1);
		calc.hit(3);
		calc.hit(7);
		calc.hit(10);
		calc.hit(7);
		calc.hit(3);
		assertEquals(139, calc.getScore());
	}
	
	@Test
	public void Test6() throws Exception {
		BowlingCalc calc = new BowlingCalc();
		calc.hit(10);
		calc.hit(10);
		calc.hit(6);
		calc.hit(4);
		calc.hit(10);
		calc.hit(4);
		calc.hit(5);
		calc.hit(9);
		calc.hit(0);
		calc.hit(8);
		calc.hit(2);
		calc.hit(10);
		calc.hit(10);
		calc.hit(7);
		calc.hit(3);
		calc.hit(10);
		assertEquals(190, calc.getScore());
	}
	
}
