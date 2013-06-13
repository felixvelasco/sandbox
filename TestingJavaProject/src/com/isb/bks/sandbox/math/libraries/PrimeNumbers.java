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

    /**
     * Returns a list of the prime factors of a given number
     * 
     * @param the
     *            number to exam
     * @return the list of prime factors
     */
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

    /**
     * Returns the index-ism prime number, if it has been previously calculated
     * 
     * @param index
     * @return
     */
    public static BigInteger getPrimeNumber(int index) {
	return primes.get(index);
    }

    /**
     * Calculates and stores every prime number lower than a specific one
     * 
     * @param limit
     *            the limit of primes to calculate
     */
    public static void preCalculateUpTo(BigInteger limit) {
	primes.clear();
	primes.add(TWO);
	primes.add(THREE);
	BigInteger k = BigInteger.ONE;
	while (limit.compareTo(k) > 0) {
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

    /**
     * Calculates and stores max prime numbers
     * 
     * @param max
     *            the number of primes to calculate
     */
    public static void preCalculate(int max) {
	primes.clear();
	primes.add(TWO);
	primes.add(THREE);
	BigInteger k = BigInteger.ONE;
	while (primes.size() < max) {
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

    /**
     * Evaluate if a number is prime
     * 
     * @param number
     *            number to evaluate
     * @return true if the number is prime
     */
    public static boolean isPrime(BigInteger number) {
	BigInteger sqrt = sqrt(new BigDecimal(number), 1).toBigInteger();
	for (int index = 0; sqrt.compareTo(primes.get(index)) >= 0; index++) {
	    if (number.remainder(primes.get(index)).equals(BigInteger.ZERO)) {
		return false;
	    }
	}
	return true;
    }

    /**
     * Returns the square root of a given number, in the provided scale
     * 
     * @param in
     *            the number to obtain the square root from
     * @param scale
     *            the number of decimal places to return
     * @return the square root
     */
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
	    sqrt = in.divide(store, scale + 3, RoundingMode.FLOOR).add(store)
		    .divide(BigDecimal.valueOf(2), scale + 3, RoundingMode.FLOOR);
	} while (!store.equals(sqrt));
	return sqrt.setScale(scale, RoundingMode.FLOOR);
    }
}
