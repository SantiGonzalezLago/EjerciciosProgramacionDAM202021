package gal.teis.model.vaccines;

/**
 * <h2>PfizerVaccine</h2>
 * 
 * Esta clase representa a la vacuna creada por el Instituto Finlay de Vacunas
 * 
 * @author Santiago González Lago
 */
public final class SoberanaVaccine extends Vaccine {

	private static final String NAME = "Soberana 02";
	private static final String ACTIVE_PRINCIPLE = "Toxoide tetánico";
	private static final String PHARMACEUTICAL = "Instituto Finlay de Vacunas";
	private static final float DEFAULT_RECOMMENDED_PRIZE = 1f;

	/**
	 * Crea una vacuna con el código introducido y con los valores por defecto de la vacuna Soberana
	 * 
	 * @param code El código, que debe cumplir los requisitos
	 */
	public SoberanaVaccine(String code) {
		super(code, NAME, ACTIVE_PRINCIPLE, PHARMACEUTICAL, DEFAULT_RECOMMENDED_PRIZE);
	}

}
