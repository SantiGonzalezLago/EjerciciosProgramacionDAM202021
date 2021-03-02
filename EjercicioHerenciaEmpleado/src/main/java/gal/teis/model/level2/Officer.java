package gal.teis.model.level2;

import gal.teis.model.level1.Operator;

public class Officer extends Operator {

	public Officer(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Oficial: " + getName();
	}

}
