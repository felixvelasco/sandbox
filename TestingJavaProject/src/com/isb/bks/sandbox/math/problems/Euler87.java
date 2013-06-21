package com.isb.bks.sandbox.math.problems;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.isb.bks.sandbox.math.EulerProblem;
import com.isb.bks.sandbox.math.libraries.PrimeNumbers;

public class Euler87 implements EulerProblem {

	private static final int MAX = 50000000;

	@Override
	public String execute() {
		PrimeNumbers.preCalculateUpTo(BigInteger.valueOf(7100));
		int sum = 0;
		int a = 0, b = 0, c = 0;
		int aP = PrimeNumbers.getPrimeNumber(a).intValue();
		int bP = PrimeNumbers.getPrimeNumber(b).intValue();
		int cP = PrimeNumbers.getPrimeNumber(c).intValue();
		int aP2 = aP * aP;
		int bP3 = bP * bP * bP;
		int cP4 = cP * cP * cP * cP;
		Set<Integer> nums = new HashSet<>();

		while (sum < MAX) {
			nums.add(sum);
			a++;
			aP = PrimeNumbers.getPrimeNumber(a).intValue();
			aP2 = aP * aP;
			sum = aP2 + bP3 + cP4;
			if (sum > MAX) {
				a = 0;
				aP = PrimeNumbers.getPrimeNumber(a).intValue();
				aP2 = aP * aP;

				b++;
				bP = PrimeNumbers.getPrimeNumber(b).intValue();
				bP3 = bP * bP * bP;
				sum = aP2 + bP3 + cP4;
				if (sum > MAX) {
					b = 0;
					bP = PrimeNumbers.getPrimeNumber(b).intValue();
					bP3 = bP * bP * bP;

					c++;
					cP = PrimeNumbers.getPrimeNumber(c).intValue();
					cP4 = cP * cP * cP * cP;
					sum = aP2 + bP3 + cP4;
				}
			}
		}

		return String.valueOf(nums.size());
	}
}
