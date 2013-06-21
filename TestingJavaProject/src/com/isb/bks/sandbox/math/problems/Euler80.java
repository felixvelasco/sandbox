package com.isb.bks.sandbox.math.problems;

import java.math.BigDecimal;

import com.isb.bks.sandbox.math.EulerProblem;
import com.isb.bks.sandbox.math.libraries.PrimeNumbers;

public class Euler80 implements EulerProblem {

	@Override
	public String execute() {
		long sum = 0L;
		for (int i = 2; i < 100; i++) {
			BigDecimal sqrt = PrimeNumbers.sqrt(BigDecimal.valueOf(i), 99);
			if (sqrt.stripTrailingZeros().scale() > 0) {
				sum += sumDecimals(sqrt);
			}
		}

		return String.valueOf(sum);
	}

	private long sumDecimals(BigDecimal num) {
		long acum = 0;
		String pointLess = num.unscaledValue().toString();
		for (int i = 0; i < 100; i++) {
			acum += pointLess.charAt(i);
		}
		acum -= '0' * 100;

		return acum;
	}
}
