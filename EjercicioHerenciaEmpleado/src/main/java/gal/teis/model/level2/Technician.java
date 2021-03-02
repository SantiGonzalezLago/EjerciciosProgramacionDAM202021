package gal.teis.model.level2;

import gal.teis.model.level1.Operator;

public class Technician extends Operator {

	public Technician(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Técnico: " + getName();
	}

}
