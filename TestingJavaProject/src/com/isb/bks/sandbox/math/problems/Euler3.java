package com.isb.bks.sandbox.math.problems;

import java.math.BigInteger;
import java.util.List;

import com.isb.bks.sandbox.math.EulerProblem;
import com.isb.bks.sandbox.math.libraries.PrimeNumbers;

public class Euler3 implements EulerProblem {

	@Override
	public String execute() {
		List<BigInteger> primes = PrimeNumbers.primeFactors(new BigInteger("600851475143"));

		return primes.get(primes.size() - 1).toString();
	}

}
