
public class GreatestCommonDenominator {

	public long calculate(long m, long n) {
		m	= m%n;
		if(m == 0){
			return n;
		}
		n	= n%m;
		if(n == 0){
			return m;
		}
		return calculate(m, n);
	}

}
