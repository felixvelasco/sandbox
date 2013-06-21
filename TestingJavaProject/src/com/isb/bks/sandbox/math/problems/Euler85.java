package com.isb.bks.sandbox.math.problems;

import com.isb.bks.sandbox.math.EulerProblem;

public class Euler85 implements EulerProblem {

	@Override
	public String execute() {
		int diff = 10000;
		int area = 0;

		for (int x = 3; x < 100; x++) {
			for (int y = 2; y < 100; y++) {
				long newDiff = Math.abs(2000000 - calculateFast(x, y));
				if (newDiff < diff) {
					area = x * y;
				}
			}
		}

		return String.valueOf(area);
	}

	private long calculateFast(int x, int y) {
		return x * (x + 1) / 2 * (y * (y + 1) / 2);
	}
}
