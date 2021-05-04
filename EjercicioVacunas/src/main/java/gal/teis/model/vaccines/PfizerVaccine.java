package gal.teis.model.vaccines;

/**
 * <h2>PfizerVaccine</h2>
 * 
 * Esta clase representa a la vacuna creada por la farmacéutica Pfizer
 * 
 * @author Santiago González Lago
 */
public final class PfizerVaccine extends Vaccine {

	private static final String NAME = "BNT162b2";
	private static final String ACTIVE_PRINCIPLE = "mRNA";
	private static final String PHARMACEUTICAL = "Pfizer, Inc., y BioNTech";
	private static final float DEFAULT_RECOMMENDED_PRIZE = 29.99f;

	/**
	 * Crea una vacuna con el código introducido y con los valores por defecto de la vacuna de Pfizer
	 * 
	 * @param code El código, que debe cumplir los requisitos
	 */
	public PfizerVaccine(String code) {
		super(code, NAME, ACTIVE_PRINCIPLE, PHARMACEUTICAL, DEFAULT_RECOMMENDED_PRIZE);
	}

}
