package com.isb.bks.sandbox.math.problems;

import java.math.BigInteger;

import com.isb.bks.sandbox.math.EulerProblem;
import com.isb.bks.sandbox.math.libraries.PrimeNumbers;

public class Euler77 implements EulerProblem {

	@Override
	public String execute() {
		int target = 100;
		PrimeNumbers.preCalculateUpTo(BigInteger.valueOf(target + 10));

		int[] ways = new int[target + 1];
		ways[0] = 1;
		int currentPrime;
		int i = 0;

		do {
			currentPrime = PrimeNumbers.getPrimeNumber(i).intValue();
			for (int j = currentPrime; j <= target; j++) {
				ways[j] += ways[j - currentPrime];
			}
			i++;
		} while (currentPrime < target);

		for (int index = 0; index < ways.length; index++) {
			if (ways[index] > 5000) {
				return String.valueOf(index);
			}
		}

		return "";
	}
}
