package gal.teis.model.vaccines;

public final class JanssenVaccine extends Vaccine {

	private static final String NAME = "JNJ-78436735";
	private static final String ACTIVE_PRINCIPLE = "Vector viral";
	private static final String PHARMACEUTICAL = "Janssen Pharmaceuticals Companies of Johnson & Johnson";
	private static final float DEFAULT_RECOMMENDED_PRIZE = 59.99f;

	public JanssenVaccine(String code) {
		super(code, NAME, ACTIVE_PRINCIPLE, PHARMACEUTICAL, DEFAULT_RECOMMENDED_PRIZE);
	}

}
