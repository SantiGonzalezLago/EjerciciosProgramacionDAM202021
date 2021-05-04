package gal.teis.model.vaccines;

/**
 * <h2>ModernaVaccine</h2>
 * 
 * Esta clase representa a la vacuna creada por la farmacéutica Moderna
 * 
 * @author Santiago González Lago
 */
public final class ModernaVaccine extends Vaccine {

	private static final String NAME = "mRNA-1273";
	private static final String ACTIVE_PRINCIPLE = "mRNA";
	private static final String PHARMACEUTICAL = "ModernaTX, Inc.";
	private static final float DEFAULT_RECOMMENDED_PRIZE = 39.99f;

	/**
	 * Crea una vacuna con el código introducido y con los valores por defecto de la vacuna de Moderna
	 * 
	 * @param code El código, que debe cumplir los requisitos
	 */
	public ModernaVaccine(String code) {
		super(code, NAME, ACTIVE_PRINCIPLE, PHARMACEUTICAL, DEFAULT_RECOMMENDED_PRIZE);
	}
}
