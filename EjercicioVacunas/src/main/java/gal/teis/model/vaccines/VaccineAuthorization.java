package gal.teis.model.vaccines;

public abstract class VaccineAuthorization implements IAuthorizable {

	public static final byte PENDING = 0;
	public static final byte AUTHORIZED = 1;
	public static final byte UNAUTHORIZED = 2;

	private boolean[] successfulPhase = new boolean[3];
	private byte completedPhases;

	private byte authorizationStatus;

	@Override
	public boolean authorize() {
		boolean authorization = completedPhases == 3 && successfulPhase[0] && successfulPhase[1] && successfulPhase[2];
		if (authorization) {
			authorizationStatus = AUTHORIZED;
		}
		return authorization;
	}

	@Override
	public boolean reject() {
		boolean rejection = false;
		for (int i = 0; i < completedPhases; i++) {
			if (!successfulPhase[i]) {
				rejection = true;
			}
		}
		if (rejection) {
			authorizationStatus = PENDING;
		}
		return rejection;
	}

	public byte getCompletedPhases() {
		return completedPhases;
	}

	public boolean isAuthorized() {
		return authorizationStatus == AUTHORIZED;
	}

	public boolean isUnauthorized() {
		return authorizationStatus == UNAUTHORIZED;
	}

	public void setTestPhaseResult(byte phaseNumber, boolean phaseComplete)
			throws IllegalAccessException, IllegalArgumentException {
		if (completedPhases == 3) {
			throw new IllegalAccessException("Ya se han completado las fases de prueba");
		}
		byte expectedPhase = (byte) (completedPhases + 1);
		if (phaseNumber != expectedPhase) {
			throw new IllegalArgumentException(String.format("Se espera la fase %d", expectedPhase));
		}
		successfulPhase[phaseNumber - 1] = phaseComplete;
		completedPhases++;
	}

}
