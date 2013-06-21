package com.isb.bks.sandbox.math.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.isb.bks.sandbox.math.EulerProblem;

public class Euler81 implements EulerProblem {

	@Override
	public String execute() {
		int table[][] = readTable();

		for (int j = table[0].length - 2; j >= 0; j--) {
			for (int i = table.length - 2; i >= 0; i--) {
				table[i][j] += Math.min(table[i][j + 1], table[i + 1][j]);
			}
		}

		return String.valueOf(table[0][0]);
	}

	private int[][] readTable() {
		int[][] ret = new int[81][81];
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
					.getResourceAsStream("resources/Euler81Matrix.txt")));
			for (int i = 0; i < 80; i++) {
				String line = br.readLine();
				ret[i] = parseLine(line);
			}
			br.close();

			ret[80] = new int[81];
			for (int i = 0; i < 79; i++) {
				ret[80][i] = Integer.MAX_VALUE;
			}

			ret[79][80] = 0;
			ret[80][79] = 0;
			ret[80][80] = 0;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ret;
		// return new int[][] { new int[] { 131, 673, 234, 103, 18, Integer.MAX_VALUE },
		// new int[] { 201, 96, 342, 965, 150, Integer.MAX_VALUE },
		// new int[] { 630, 803, 746, 422, 111, Integer.MAX_VALUE },
		// new int[] { 537, 699, 497, 121, 956, Integer.MAX_VALUE }, new int[] { 805, 732, 524, 37, 331, 0 },
		// new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0 }, };
	}

	private int[] parseLine(String line) {
		int[] ret = new int[81];
		String nums[] = line.split(",");
		for (int i = 0; i < 80; i++) {
			ret[i] = Integer.parseInt(nums[i]);
		}
		ret[80] = Integer.MAX_VALUE;
		return ret;
	}
}
