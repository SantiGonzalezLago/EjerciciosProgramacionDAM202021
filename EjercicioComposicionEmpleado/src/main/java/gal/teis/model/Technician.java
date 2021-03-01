package gal.teis.model;

public class Technician extends Operator {

	public Technician(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Técnico: " + getName();
	}

}
