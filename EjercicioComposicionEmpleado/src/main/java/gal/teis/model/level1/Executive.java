package gal.teis.model.level1;

import gal.teis.model.level0.Employee;

public class Executive extends Employee {

	public Executive(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Directivo: " + getName();
	}
}
