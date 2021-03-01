package gal.teis.model;

public class Executive extends Employee {

	public Executive(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Directivo: " + getName();
	}
}
