package com.isb.bks.sandbox.math.libraries;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger THREE = BigInteger.valueOf(3);
    private static final BigInteger FOUR = BigInteger.valueOf(4);

    private static List<BigInteger> primes = new ArrayList<>();

    public static List<BigInteger> primeFactors(BigInteger number) {
	BigInteger sqrt = sqrt(new BigDecimal(number), 1).toBigInteger();
	preCalculateUpTo(sqrt);
	BigInteger n = number;
	List<BigInteger> factors = new ArrayList<>();
	BigInteger i = getPrimeNumber(1);
	for (int index = 1; sqrt.compareTo(i) > 0; index++) {
	    while (n.remainder(i).equals(BigInteger.ZERO)) {
		factors.add(i);
		n = n.divide(i);
		sqrt = sqrt(new BigDecimal(n), 1).toBigInteger();
	    }
	    i = getPrimeNumber(index);
	}
	if (n.compareTo(BigInteger.ONE) > 0) {
	    factors.add(n);
	}
	return factors;
    }

    public static BigInteger getPrimeNumber(int index) {
	return primes.get(index);
    }

    public static void preCalculateUpTo(BigInteger bigInteger) {
	primes.clear();
	primes.add(TWO);
	primes.add(THREE);
	BigInteger k = BigInteger.ONE;
	while (bigInteger.compareTo(k) > 0) {
	    k = k.add(FOUR);
	    if (isPrime(k)) {
		primes.add(k);
	    }
	    k = k.add(TWO);
	    if (isPrime(k)) {
		primes.add(k);
	    }
	}
    }

    public static void preCalculate(int numbers) {
	primes.clear();
	primes.add(TWO);
	primes.add(THREE);
	BigInteger k = BigInteger.ONE;
	while (primes.size() < numbers) {
	    k = k.add(FOUR);
	    if (isPrime(k)) {
		primes.add(k);
	    }
	    k = k.add(TWO);
	    if (isPrime(k)) {
		primes.add(k);
	    }
	}
    }

    public static boolean isPrime(BigInteger number) {
	BigInteger sqrt = sqrt(new BigDecimal(number), 1).toBigInteger();
	for (int index = 0; sqrt.compareTo(primes.get(index)) >= 0; index++) {
	    if (number.remainder(primes.get(index)).equals(BigInteger.ZERO)) {
		return false;
	    }
	}
	return true;
    }

    public static BigDecimal sqrt(BigDecimal in, int scale) {
	BigDecimal sqrt = new BigDecimal(1);
	sqrt.setScale(scale + 3, RoundingMode.FLOOR);
	BigDecimal store = new BigDecimal(in.toString());
	boolean first = true;
	do {
	    if (!first) {
		store = new BigDecimal(sqrt.toString());
	    } else {
		first = false;
	    }
	    store.setScale(scale + 3, RoundingMode.FLOOR);
	    sqrt = in
		    .divide(store, scale + 3, RoundingMode.FLOOR)
		    .add(store)
		    .divide(BigDecimal.valueOf(2), scale + 3,
			    RoundingMode.FLOOR);
	} while (!store.equals(sqrt));
	return sqrt.setScale(scale, RoundingMode.FLOOR);
    }
}
