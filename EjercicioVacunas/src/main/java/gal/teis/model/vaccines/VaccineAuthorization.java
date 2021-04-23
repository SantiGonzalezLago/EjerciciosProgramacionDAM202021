package gal.teis.model.vaccines;

import java.time.LocalDate;

public abstract class VaccineAuthorization implements IAuthorizable {

	public static final byte PENDING = 0;
	public static final byte AUTHORIZED = 1;
	public static final byte UNAUTHORIZED = 2;

	private boolean[] successfulPhase = new boolean[3];
	private byte completedPhases;

	private byte authorizationStatus;
	private LocalDate resultDate;

	@Override
	public final boolean authorize() {
		boolean authorization = completedPhases == 3 && successfulPhase[0] && successfulPhase[1] && successfulPhase[2];
		if (authorization) {
			authorizationStatus = AUTHORIZED;
			resultDate = LocalDate.now();
		}
		return authorization;
	}

	@Override
	public final boolean reject() {
		boolean rejection = false;
		for (int i = 0; i < completedPhases; i++) {
			if (!successfulPhase[i]) {
				rejection = true;
			}
		}
		if (rejection) {
			authorizationStatus = UNAUTHORIZED;
			resultDate = LocalDate.now();
		}
		return rejection;
	}

	public final byte getCompletedPhases() {
		return completedPhases;
	}

	public final boolean isAuthorized() {
		return authorizationStatus == AUTHORIZED;
	}

	public final boolean isUnauthorized() {
		return authorizationStatus == UNAUTHORIZED;
	}

	public final void setTestPhaseResult(byte phaseNumber, boolean phaseComplete)
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

	public LocalDate getResultDate() {
		return resultDate;
	}

}
