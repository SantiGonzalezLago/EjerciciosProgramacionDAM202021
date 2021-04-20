package gal.teis.model.vaccines;

public final class PfizerVaccine extends Vaccine {

	private static final String NAME = "BNT162b2";
	private static final String ACTIVE_PRINCIPLE = "mRNA";
	private static final String PHARMACEUTICAL = "Pfizer, Inc., y BioNTech";
	private static final float DEFAULT_RECOMMENDED_PRIZE = 29.99f;

	public PfizerVaccine(String code) {
		super(code, NAME, ACTIVE_PRINCIPLE, PHARMACEUTICAL, DEFAULT_RECOMMENDED_PRIZE);
	}

}
