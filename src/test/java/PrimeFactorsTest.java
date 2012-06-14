
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class PrimeFactorsTest {
	private PrimeFactors primes = new PrimeFactors();

	@Test
	public void one() throws Exception {
		assertEquals(list(), primes.primeFactors(1));
	}

	@Test
	public void two() throws Exception {
		assertEquals(list(2), primes.primeFactors(2));
	}

	@Test
	public void three() throws Exception {
		assertEquals(list(3), primes.primeFactors(3));
	}

	@Test
	public void four() throws Exception {
		assertEquals(list(2,2), primes.primeFactors(4));
	}

	@Test
	public void five() throws Exception {
		assertEquals(list(5), primes.primeFactors(5));
	}

	@Test
	public void six() throws Exception {
		assertEquals(list(2,3), primes.primeFactors(6));
	}

	@Test
	public void eight() throws Exception {
		assertEquals(list(2,2,2), primes.primeFactors(8));
	}

	@Test
	public void nine() throws Exception {
		assertEquals(list(3,3), primes.primeFactors(9));
	}

	private List<Integer> list(int ...ints) {
		List<Integer> primes = new ArrayList<Integer>();
		for(int integer:ints){
			primes.add(integer);
		}
		return primes;
	}
}
