package gal.teis.model.level1;

import gal.teis.model.level0.Employee;

public class Operator extends Employee {

	public Operator(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Operario: " + getName();
	}

}
