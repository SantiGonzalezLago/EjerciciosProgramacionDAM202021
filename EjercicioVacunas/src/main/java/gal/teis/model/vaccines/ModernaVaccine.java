package gal.teis.model.vaccines;

public final class ModernaVaccine extends Vaccine {

	private static final String NAME = "mRNA-1273";
	private static final String ACTIVE_PRINCIPLE = "mRNA";
	private static final String PHARMACEUTICAL = "ModernaTX, Inc.";
	private static final float DEFAULT_RECOMMENDED_PRIZE = 39.99f;

	public ModernaVaccine(String code) {
		super(code, NAME, ACTIVE_PRINCIPLE, PHARMACEUTICAL, DEFAULT_RECOMMENDED_PRIZE);
	}
}
