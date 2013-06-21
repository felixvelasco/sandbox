package com.isb.bks.sandbox.math.problems;

import java.math.BigInteger;

import com.isb.bks.sandbox.math.EulerProblem;
import com.isb.bks.sandbox.math.libraries.Fibonacci;

public class Euler25 implements EulerProblem {

	@Override
	public String execute() {
		BigInteger fib;
		int i = 0;
		do {
			i++;
			fib = Fibonacci.fib(i);
		} while (fib.toString().length() < 1000);

		return String.valueOf(i);
	}
}
