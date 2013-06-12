package com.isb.bks.sandbox.math.problems;

import com.isb.bks.sandbox.math.EulerProblem;

public class Euler1 implements EulerProblem {

    @Override
    public String execute() {
	int mult3 = 3, mult5 = 5;
	int acum = 0;

	while (mult3 < 1000 || mult5 < 1000) {
	    if (mult3 < mult5) {
		acum += mult3;
		mult3 += 3;
	    } else {
		acum += mult5;
		mult5 += 5;
	    }
	    if (mult3 == mult5) {
		mult3 += 3;
	    }
	}
	return String.valueOf(acum);
    }

}
