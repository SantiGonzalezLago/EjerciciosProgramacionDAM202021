package gal.teis.model;

import java.util.ArrayList;
import java.util.List;

public class Country {

	public static final List<Country> countryList = new ArrayList<>();
	
	private String name;
	private int population;
	private String capital;
	private String[] officialLanguages;
	private GovernmentSystem governmentSystem;

	public Country(String name) {
		this.name = name;
	}

	public Country(String name, String capital) {
		this(name);
		this.capital = capital;
	}

	public Country(String name, String capital, GovernmentSystem governmentSystem) {
		this(name, capital);
		this.governmentSystem = governmentSystem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String[] getOfficialLanguages() {
		return officialLanguages;
	}

	public void setOfficialLanguages(String[] officialLanguages) {
		this.officialLanguages = officialLanguages;
	}

	public GovernmentSystem getGovernmentSystem() {
		return governmentSystem;
	}

	public void setGovernmentSystem(GovernmentSystem governmentSystem) {
		this.governmentSystem = governmentSystem;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: ");
		sb.append(name);
		if (capital != null) {
			sb.append(", capital: ");
			sb.append(capital);
		}
		if (governmentSystem != null) {
			sb.append(", sistema de gobierno: ");
			sb.append(governmentSystem.toString());
		}
		return sb.toString();
	}

}
