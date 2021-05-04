package gal.teis.model.vaccines;

/**
 * <h2>Vaccine</h2>
 * 
 * Esta clase contiene los métodos para la gestión las vacunas, excepto aquellos necesarios para la autorización,
 * que están en la clase {@link VaccineAuthorization}
 * 
 * @author Santiago González Lago
 */
public abstract class Vaccine extends VaccineAuthorization {

	private final String code;
	private String name;
	private String activePrinciple;
	private String pharmaceutical;
	private float recommendedPrize;

	/**
	 * Crea una vacuna con los datos introducidos
	 * 
	 * @param code El código, que debe cumplir los requisitos
	 * @param name El nombre
	 * @param activePrinciple El principio activo
	 * @param pharmaceutical La farmacéutica que la produce
	 * @param recommendedPrize El precio recomendado por la farmacéutica
	 */
	public Vaccine(String code, String name, String activePrinciple, String pharmaceutical, float recommendedPrize) {
		if (!isCodeValid(code))
			throw new IllegalArgumentException("El código tiene un formato erróneo");
		this.code = code;
		this.name = name;
		this.activePrinciple = activePrinciple;
		this.pharmaceutical = pharmaceutical;
		this.recommendedPrize = recommendedPrize;
	}

	/**
	 * @return El código de la vacuna
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return El precio recomendado de la vacuna
	 */
	public float getRecommendedPrize() {
		return recommendedPrize;
	}

	/**
	 * Cambia el precio recomendado
	 * 
	 * @param recommendedPrize  El nuevo precio recomendado
	 */
	public void setRecommendedPrize(float recommendedPrize) {
		this.recommendedPrize = recommendedPrize;
	}

	/**
	 * Comprueba que el código tenga el formato apropiado
	 * <ul>
	 * <li>Comenzará por la letra V seguida de una vocal en mayúsculas.</li>
	 * <li>A continuación, tres o cuatro letras minúsculas.</li>
	 * <li>Finaliza, o con dos números del 4 al 7, o bien con el número 8.</li>
	 * </ul>
	 * 
	 * @param code El código a comprobar
	 * @return Si el código es válido
	 */
	public final static boolean isCodeValid(String code) {
		// 
		return code.matches("^V[AEIOU][a-z]{3,4}([4-7]{2}|8)$");
		// Explicación de la expresión regular:
		// ^ indica el principio de la cadena, $ indica el final
		// V indica que debe encontrar una V
		// [AEIOU] indica que debe encontrar uno de esos caracteres
		// [a-z]{3,4} indica que debe encontrar un caracter entre a y z, y que debe
		// hacerlo entre 3 y 4 veces
		// ([4-7]{2}|8) indica que debe encontrar un caracter entre 4 y 7, 2 veces, o
		// bien un 8, los parentesis indican el ambito del or
	}

	/**
	 * @return Los datos de la vacuna organizados en un String
	 */
	@Override
	public String toString() {
		// NOTA: La tabulación es correcta con un tamaño de tabulador de 4
		StringBuilder sb = new StringBuilder();

		sb.append("Datos de la vacuna:\n");

		sb.append("\tCódigo\t\t\t");
		sb.append(code);
		sb.append("\n");

		sb.append("\tNombre\t\t\t");
		sb.append(name);
		sb.append("\n");

		sb.append("\tP. activo\t\t");
		sb.append(activePrinciple);

		if (isAuthorized()) {
			sb.append("\n");
			sb.append("\tFarmacéutica\t");
			sb.append(pharmaceutical);
			sb.append("\n");

			sb.append("\tPrecio\t\t\t");
			sb.append(String.format("%.2f€", recommendedPrize));
		} else if (!isUnauthorized()) {
			sb.append("\n");
			sb.append("\tPendiente de autorización");
		}

		return sb.toString();
	}

	/**
	 *
	 */
	@Override
	public boolean equals(Object o) {
		return (o instanceof Vaccine && (this == o || this.code == ((Vaccine) o).code));
	}

}
