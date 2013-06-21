package com.isb.bks.sandbox.math.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.isb.bks.sandbox.math.EulerProblem;

public class Euler88 implements EulerProblem {

	@Override
	public String execute() {
		int maximum = 12;

		List<Integer> minimum = new ArrayList<>();
		minimum.add(6);
		minimum.add(6);
		for (int i = 2; i < maximum + 1; i++) {
			minimum.add(Integer.valueOf(Integer.MAX_VALUE));
		}

		List<Integer> factors = new ArrayList<>();
		factors.add(2);
		factors.add(2);
		int prod = multiply(factors);
		int sum = sum(factors);
		int index = 0;
		while (factors.size() < 13) {
			int size = prod - sum + factors.size();
			if (size <= maximum) {
				if (minimum.get(size) > prod) {
					minimum.set(size, prod);
				}
			}
			System.out.println(minimum);
			if (prod > maximum * 2) {
				if (index == factors.size() - 1) {
					for (int i = 0; i < factors.size(); i++) {
						factors.set(i, 2);
					}
					factors.add(2);
				} else {
					factors.set(index, 2);
					index++;
					factors.set(index, factors.get(index) + 1);
				}
			} else {
				factors.set(index, factors.get(index) + 1);
			}
			prod = multiply(factors);
			sum = sum(factors);
		}

		Set<Integer> nums = new HashSet<>(minimum);
		System.out.println(nums);

		long acum = 0;
		for (int num : nums) {
			acum += num;
		}

		return String.valueOf(acum);
	}

	private int multiply(List<Integer> nums) {
		int acum = 1;
		for (int num : nums) {
			acum *= num;
		}
		return acum;
	}

	private int sum(List<Integer> nums) {
		int acum = 0;
		for (int num : nums) {
			acum += num;
		}
		return acum;
	}
}
