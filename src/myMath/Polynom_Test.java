package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Polynom_Test {

	@Test
	void test_polynom() {
		Polynom p1=new Polynom();
		p1.Init("0.2x^4-1.5x^3+3.0x^2-1x^1-5x^0");
		p1.derivative();
		double d=p1.root(-2, 6, 0.001);
		assertEquals(Math.abs(-3.679),d,0.001);//x of min. point				
	}
	

}
