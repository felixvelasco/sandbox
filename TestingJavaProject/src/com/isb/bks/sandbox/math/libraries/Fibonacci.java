package com.isb.bks.sandbox.math.libraries;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    private static List<BigInteger> fibCache = new ArrayList<BigInteger>();
    static {
	fibCache.add(BigInteger.ZERO);
	fibCache.add(BigInteger.ONE);
    }

    public static List<Integer> findUpTo(int max) {
	List<Integer> ret = new ArrayList<>();

	int num = 0, fibNum = 0;

	while (fibNum < max) {
	    ret.add(fibNum);
	    num++;
	    fibNum = fib(num).intValue();
	}

	return ret;
    }

    public static BigInteger fib(int n) {
	if (n >= fibCache.size()) {
	    fibCache.add(n, fib(n - 1).add(fib(n - 2)));
	}
	return fibCache.get(n);
    }
}
