package com.isb.bks.sandbox.math.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.isb.bks.sandbox.math.EulerProblem;

public class Euler82 implements EulerProblem {

	private static final int MAXIMUM = Integer.MAX_VALUE >> 1;

	@Override
	public String execute() {
		int table[][] = readTable();

		int sol[] = new int[table.length];
		for (int i = 0; i < table.length; i++) {
			sol[i] = table[i][0];
		}

		int I = table.length;
		int J = table[0].length;

		for (int j = 1; j < J; j++) {

			for (int i = 1; i < I - 1; i++) {
				sol[i] = table[i][j] + Math.min(sol[i - 1], sol[i]);
			}

			for (int i = I - 2; i > 0; i--) {
				sol[i] = Math.min(sol[i], table[i][j] + sol[i + 1]);
			}
		}

		int min = MAXIMUM;
		for (int i = 1; i < table.length - 1; i++) {
			min = Math.min(min, sol[i]);
		}

		return String.valueOf(min);
	}

	private int[][] readTable() {
		int[][] ret = new int[82][81];
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
					.getResourceAsStream("resources/Euler81Matrix.txt")));
			for (int i = 1; i < 81; i++) {
				String line = br.readLine();
				ret[i] = parseLine(line);
			}
			br.close();

			ret[81] = new int[81];
			ret[0] = new int[81];
			for (int i = 0; i < 79; i++) {
				ret[81][i] = MAXIMUM;
				ret[0][i] = MAXIMUM;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return ret;
	}

	private int[][] readSmallTable() {

		return new int[][] { new int[] { MAXIMUM, MAXIMUM, MAXIMUM, MAXIMUM, MAXIMUM, MAXIMUM },
				new int[] { 0, 131, 673, 234, 103, 18 }, new int[] { 0, 201, 96, 342, 965, 150 },
				new int[] { 0, 630, 803, 746, 422, 111 }, new int[] { 0, 537, 699, 497, 121, 956 },
				new int[] { 0, 805, 732, 524, 37, 331 },
				new int[] { MAXIMUM, MAXIMUM, MAXIMUM, MAXIMUM, MAXIMUM, MAXIMUM }, };
	}

	private int[] parseLine(String line) {
		int[] ret = new int[81];
		String nums[] = line.split(",");
		for (int i = 0; i < 80; i++) {
			ret[i + 1] = Integer.parseInt(nums[i]);
		}
		ret[0] = 0;
		return ret;
	}
}
