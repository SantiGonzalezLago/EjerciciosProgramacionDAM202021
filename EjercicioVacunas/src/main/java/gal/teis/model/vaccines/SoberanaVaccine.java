package gal.teis.model.vaccines;

import gal.teis.model.inventory.VaccineOps;

public final class SoberanaVaccine extends Vaccine implements IAuthorizable {

	private static final String NAME = "Soberana 02";
	private static final String ACTIVE_INGREDIENT = "Toxoide tetánico";
	private static final String PHARMACEUTICAL = "Instituto Finlay de Vacunas";
	private static final float DEFAULT_RECOMMENDED_PRIZE = 1f;

	private boolean phase1Complete;
	private boolean phase2Complete;
	private boolean phase3Complete;
	private boolean[] introduced = new boolean[3];
	private byte completedPhases;

	private byte authorizationStatus;

	public SoberanaVaccine(String code) {
		super(code, NAME, ACTIVE_INGREDIENT, PHARMACEUTICAL, DEFAULT_RECOMMENDED_PRIZE);
	}

	@Override
	public boolean authorize() {
		boolean authorization = false;
		if (completedPhases == 3 && phase1Complete && phase2Complete && phase3Complete) {
			authorizationStatus = VaccineOps.AUTHORIZED;
			authorization = true;
		}
		return authorization;
	}

	@Override
	public boolean reject() {
		boolean rejection = false;
		if (completedPhases == 3 && !(phase1Complete && phase2Complete && phase3Complete)) {
			authorizationStatus = VaccineOps.UNAUTHORIZED;
			rejection = true;
		}
		return rejection;
	}

	@Override
	public void setTestPhaseResult(byte phaseNumber, boolean phaseComplete) {
		switch (phaseNumber) {
		case 1:
			phase1Complete = phaseComplete;
			break;
		case 2:
			phase2Complete = phaseComplete;
			break;
		case 3:
			phase3Complete = phaseComplete;
			break;
		default:
			throw new IllegalArgumentException("La fase debe ser 1, 2 o 3");
		}
		if (!introduced[phaseNumber-1]) {
			introduced[phaseNumber-1] = true;
			completedPhases++;
		}
	}

	@Override
	public boolean isAuthorized() {
		return authorizationStatus == VaccineOps.AUTHORIZED;
	}

	@Override
	public boolean isUnauthorized() {
		return authorizationStatus == VaccineOps.UNAUTHORIZED;
	}

}
