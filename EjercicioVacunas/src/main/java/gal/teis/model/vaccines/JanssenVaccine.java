package gal.teis.model.vaccines;

/**
 * <h2>JanssenVaccine</h2>
 * 
 * Esta clase representa a la vacuna creada por la farmacéutica Janssen
 * 
 * @author Santiago González Lago
 */
public final class JanssenVaccine extends Vaccine {

	private static final String NAME = "JNJ-78436735";
	private static final String ACTIVE_PRINCIPLE = "Vector viral";
	private static final String PHARMACEUTICAL = "Janssen Pharmaceuticals Companies of Johnson & Johnson";
	private static final float DEFAULT_RECOMMENDED_PRIZE = 59.99f;

	/**
	 * Crea una vacuna con el código introducido y con los valores por defecto de la vacuna de Janssen
	 * 
	 * @param code El código, que debe cumplir los requisitos
	 */
	public JanssenVaccine(String code) {
		super(code, NAME, ACTIVE_PRINCIPLE, PHARMACEUTICAL, DEFAULT_RECOMMENDED_PRIZE);
	}

}
