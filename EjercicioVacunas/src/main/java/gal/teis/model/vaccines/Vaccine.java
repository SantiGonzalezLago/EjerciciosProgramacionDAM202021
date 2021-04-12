package gal.teis.model.vaccines;

public abstract class Vaccine {

	private String code;
	private String name;
	private String activeIngredient;
	private String pharmaceutical;
	private float recommendedPrize;

	public Vaccine(String code, String name, String activeIngredient, String pharmaceutical, float recommendedPrize) {
		if (!isCodeValid(code))
			throw new IllegalArgumentException("El código tiene un formato erróneo");
		this.code = code;
		this.name = name;
		this.activeIngredient = activeIngredient;
		this.pharmaceutical = pharmaceutical;
		this.recommendedPrize = recommendedPrize;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public float getRecommendedPrize() {
		return recommendedPrize;
	}

	public void setRecommendedPrize(float recommendedPrize) {
		this.recommendedPrize = recommendedPrize;
	}

	public abstract void setTestPhasesResult(boolean phase1Complete, boolean phase2Complete, boolean phase3Complete);

	public final static boolean isCodeValid(String code) {
		// El código tendrá el siguiente formato:
		//   Comenzará por la letra V seguida de una vocal en mayúsculas.
		//   A continuación, tres o cuatro letras minúsculas.
		//   Finaliza, o con dos números del 4 al 7, o bien con el número 8.
		return code.matches("^V[a-zA-Z]{3,4}([0-9]{2}|8)$");
		// Explicación de la expresión regular:
		//   ^ indica el principio de la cadena, $ indica el final
		//   V indica que debe encontrar una V
		//   [a-zA-Z]{3,4} indica que debe encontrar un caracter entre a y z o entre A y Z, y que debe hacerlo entre 3 y 4 veces
		//   ([0-9]{2}|8) indica que debe encontrar un caracter entre 0 y 9, 2 veces, o bien un 8, los parentesis indican el ambito del or
	}

	@Override
	public String toString() {
		//TODO Comprobar si la tabulación es correcta
		StringBuilder sb = new StringBuilder();

		sb.append("Datos de la vacuna:\n");

		sb.append("\tCódigo\t\t\t");
		sb.append(code);
		sb.append("\n");

		sb.append("\tNombre\t\t\t");
		sb.append(name);
		sb.append("\n");

		sb.append("\tP. activo\t\t");
		sb.append(activeIngredient);
		sb.append("\n");

		sb.append("\tFarmacéutica\t");
		sb.append(pharmaceutical);
		sb.append("\n");

		sb.append("\tPrecio\t\t\t");
		sb.append(String.format("%.2f€", recommendedPrize));

		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof Vaccine && ( this == o || this.code == ((Vaccine) o).code));
	}
}