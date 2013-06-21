package com.isb.bks.sandbox.math.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.isb.bks.sandbox.math.EulerProblem;

public class Euler78 implements EulerProblem {

	@Override
	public String execute() {
		List<BigInteger> p = new ArrayList<>();
		p.add(BigInteger.ONE);

		int n = 1;
		while (true) {
			int i = 0;
			int penta = 1;
			p.add(BigInteger.ZERO);

			while (penta <= n) {
				boolean sign = i % 4 > 1;
				p.set(n, sign ? p.get(n).subtract(p.get(n - penta)) : p.get(n).add(p.get(n - penta)));
				i++;

				int j = i % 2 == 0 ? i / 2 + 1 : -(i / 2 + 1);
				penta = j * (3 * j - 1) / 2;
			}

			if (p.get(n).toString().endsWith("000000")) {
				System.out.println(p.get(n));
				break;
			}
			n++;
		}
		return String.valueOf(n);
	}
}
