package com.isb.bks.sandbox.math;

public class EulerRunner {

    public static void main(String[] args) {
	if (args.length < 1) {
	    usage();
	} else {
	    int number = 0;
	    try {
		number = Integer.parseInt(args[0]);
	    } catch (NumberFormatException nfe) {
		usage();
	    }

	    if (number != 0) {
		try {
		    Class<?> clazz = Class
			    .forName("com.isb.bks.sandbox.math.problems.Euler"
				    + number);
		    EulerProblem problem = (EulerProblem) clazz.newInstance();
		    long act = System.nanoTime();
		    System.out.println(problem.execute());
		    long next = System.nanoTime();
		    System.out.println("Time: " + (next - act)
			    / (1000 * 1000 * 1000));
		} catch (InstantiationException | IllegalAccessException e) {
		    System.out.println("Cannot find class Euler" + number
			    + " with an empty, public constructor");
		} catch (ClassNotFoundException e) {
		    System.out.println("Cannot find class Euler" + number);
		} catch (ClassCastException e) {
		    System.out.println("Class Euler" + number
			    + " MUST implement EulerProblem");
		}
	    }
	}
    }

    private static void usage() {
	System.out.println("Usage: java EulerRunner <problemNumber>");
    }

}
