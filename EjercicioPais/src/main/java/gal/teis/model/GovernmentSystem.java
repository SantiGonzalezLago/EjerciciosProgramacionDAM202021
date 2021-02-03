package gal.teis.model;

public enum GovernmentSystem {
	REPUBLIC("República"),
	MONARCHY("Monarquía");

	private String toString;

	private GovernmentSystem(String toString) {
		this.toString = toString;
	}

	@Override
	public String toString() {
		return toString;
	}
}
