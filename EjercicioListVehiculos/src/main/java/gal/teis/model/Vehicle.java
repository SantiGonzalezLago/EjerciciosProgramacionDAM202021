package gal.teis.model;

public class Vehicle {
	public static final String CAR = "Coche";
	public static final String TRUCK = "Camión";
	public static final String VAN = "Furgoneta";
	public static final String BIKE = "Moto";

	private int id;
	private String type;

	public Vehicle(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
