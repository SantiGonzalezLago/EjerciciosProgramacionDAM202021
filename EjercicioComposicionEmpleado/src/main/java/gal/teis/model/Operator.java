package gal.teis.model;

public class Operator extends Employee {

	public Operator(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Operario: " + getName();
	}

}
