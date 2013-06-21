package com.isb.bks.sandbox.math.problems;

import java.util.List;

import com.isb.bks.sandbox.math.EulerProblem;
import com.isb.bks.sandbox.math.libraries.Fibonacci;

public class Euler2 implements EulerProblem {

	@Override
	public String execute() {
		List<Integer> fibs = Fibonacci.findUpTo(4000000);
		int acum = 0;
		for (int fib : fibs) {
			if (fib % 2 == 0) {
				acum += fib;
			}
		}
		return String.valueOf(acum);
	}

}
