package com.isb.bks.sandbox.math.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import com.isb.bks.sandbox.math.EulerProblem;

public class Euler83 implements EulerProblem {

	private static final int MAXIMUM = Integer.MAX_VALUE >> 1;
	private int tables[][];
	private int sols[];
	private Queue<Integer> queue;

	@Override
	public String execute() {
		tables = readTable();

		sols = new int[tables.length * tables[0].length];
		for (int i = 0; i < sols.length; i++) {
			sols[i] = MAXIMUM;
		}

		sols[0] = tables[0][0];
		queue = new LinkedList<>();
		queue.add(0);

		while (!queue.isEmpty()) {
			int next = queue.poll();
			int x = next / 80, y = next % 80;
			int currSol = sols[next];
			if (x > 0) {
				check(next - 80, currSol, tables[x - 1][y]);
			}
			if (x < tables.length - 1) {
				check(next + 80, currSol, tables[x + 1][y]);
			}
			if (y > 0) {
				check(next - 1, currSol, tables[x][y - 1]);
			}
			if (y < tables.length - 1) {
				check(next + 1, currSol, tables[x][y + 1]);
			}

		}

		return String.valueOf(sols[sols.length - 1]);
	}

	private void printSols() {
		for (int k = 0; k < sols.length; k++) {
			System.out.print(sols[k] + ",");
		}
		System.out.println();
	}

	private void check(int index, int currSol, int value) {
		if (currSol + value < sols[index]) {
			sols[index] = currSol + value;
			queue.offer(index);
		}
	}

	private int[][] readTable() {
		int[][] ret = new int[80][80];
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
					.getResourceAsStream("resources/Euler81Matrix.txt")));
			for (int i = 0; i < 80; i++) {
				String line = br.readLine();
				ret[i] = parseLine(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ret;
	}

	private int[][] readSmallTable() {

		return new int[][] { new int[] { 131, 673, 234, 103, 18 }, new int[] { 201, 96, 342, 965, 150 },
				new int[] { 630, 803, 746, 422, 111 }, new int[] { 537, 699, 497, 121, 956 },
				new int[] { 805, 732, 524, 37, 331 }, };
	}

	private int[] parseLine(String line) {
		int[] ret = new int[80];
		String nums[] = line.split(",");
		for (int i = 0; i < 80; i++) {
			ret[i] = Integer.parseInt(nums[i]);
		}
		return ret;
	}
}
