package gal.teis.model.vaccines;

public final class SoberanaVaccine extends Vaccine {

	private static final String NAME = "Soberana 02";
	private static final String ACTIVE_PRINCIPLE = "Toxoide tetánico";
	private static final String PHARMACEUTICAL = "Instituto Finlay de Vacunas";
	private static final float DEFAULT_RECOMMENDED_PRIZE = 1f;

	public SoberanaVaccine(String code) {
		super(code, NAME, ACTIVE_PRINCIPLE, PHARMACEUTICAL, DEFAULT_RECOMMENDED_PRIZE);
	}

}
