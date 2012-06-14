
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GreatestCommonDenominatorTest {
	private GreatestCommonDenominator calc;

	@Before
	public void setUp() throws Exception {
		calc	= new GreatestCommonDenominator();
	}

	@Test
	public void canFindOneAndOneCommon() throws Exception {
		assertEquals(1, calc.calculate(1,1));
	}

	@Test
	public void canFindOneAndTwoCommon() throws Exception {
		assertEquals(1, calc.calculate(2, 1));
	}

	@Test
	public void canFindFourAndTwoCommon() throws Exception {
		assertEquals(2, calc.calculate(4,2));
	}

	@Test
	public void canFindReallyLargeGreatestCommons() throws Exception {
		assertEquals(57, calc.calculate(2166, 6099));
	}

	@Test
	public void canFindReallyReallyLargeGreatestCommons() throws Exception {
		assertEquals(5, calc.calculate(216647355, 609987895));
	}
}
