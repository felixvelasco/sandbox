package com.isb.bks.sandbox.math.problems;

import com.isb.bks.sandbox.math.EulerProblem;

public class Euler86 implements EulerProblem {

	@Override
	public String execute() {
		int acum = 0;
		int a;
		for (a = 1; acum < 1000000; a++) {
			int asq = a * a;
			int a2 = a * 2;
			for (int bc = 2; bc <= a2; bc++) {
				if (isSquare(asq + bc * bc)) {
					acum += bc <= a ? bc / 2 : 1 + a - (bc + 1) / 2;
				}
			}
		}

		return String.valueOf(a - 1);
	}

	private boolean isSquare(int x) {
		int root = (int) Math.sqrt(x);
		return root * root == x;
	}
}
