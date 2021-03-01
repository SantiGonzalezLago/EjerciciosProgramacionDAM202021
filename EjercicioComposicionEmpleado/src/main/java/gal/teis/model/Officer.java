package gal.teis.model;

public class Officer extends Operator {

	public Officer(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Oficial: " + getName();
	}

}
