package com.isb.bks.sandbox.math.problems;

import java.math.BigInteger;

import com.isb.bks.sandbox.math.EulerProblem;
import com.isb.bks.sandbox.math.libraries.PrimeNumbers;

public class Euler10 implements EulerProblem {

	private static final BigInteger TWOMILLION = BigInteger.valueOf(2000000);

	@Override
	public String execute() {
		PrimeNumbers.preCalculateUpTo(TWOMILLION);
		BigInteger acum = BigInteger.ZERO;
		BigInteger next = BigInteger.ZERO;
		int i = 0;
		do {
			acum = acum.add(next);
			next = PrimeNumbers.getPrimeNumber(i++);
		} while (next.compareTo(TWOMILLION) < 0);

		return acum.toString();
	}
}
