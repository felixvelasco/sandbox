package com.isb.bks.sandbox.math.problems;

import com.isb.bks.sandbox.math.EulerProblem;
import com.isb.bks.sandbox.math.libraries.PrimeNumbers;

public class Euler7 implements EulerProblem {

	@Override
	public String execute() {
		PrimeNumbers.preCalculate(10001);

		return PrimeNumbers.getPrimeNumber(10000).toString();
	}

}
