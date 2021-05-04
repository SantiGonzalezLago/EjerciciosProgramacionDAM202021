package gal.teis.model.vaccines;

import java.time.LocalDate;

/**
 * <h2>VaccineAuthorization</h2>
 * 
 * Esta clase contiene los métodos para la gestión de la autorización de las vacunas
 * 
 * @author Santiago González Lago
 */
public abstract class VaccineAuthorization implements IAuthorizable {

	public static final byte PENDING = 0;
	public static final byte AUTHORIZED = 1;
	public static final byte UNAUTHORIZED = 2;

	private boolean[] successfulPhase = new boolean[3];
	private byte completedPhases;

	private byte authorizationStatus;
	private LocalDate resultDate;

	/**
	 * Comprueba que la vacuna cumpla los requisitos para ser autorizada y, si los cumple, la autoriza
	 * 
	 * Los requisitos son los siguientes:
	 *   Se han superado con éxito todas las fases de prueba
	 *   Está pendiente de autorización
	 * 
	 * @return Si la vacuna ha sido autorizada
	 */
	@Override
	public final boolean authorize() {
		boolean authorization = authorizationStatus == PENDING && completedPhases == 3 && successfulPhase[0] && successfulPhase[1] && successfulPhase[2];
		if (authorization) {
			authorizationStatus = AUTHORIZED;
			resultDate = LocalDate.now();
		}
		return authorization;
	}

	/**
	 * Comprueba que la vacuna cumpla los requisitos para ser rechazada y, si los cumple, la rechaza
	 * 
	 * Los requisitos son los siguientes:
	 *   Está pendiente de autorización
	 * 
	 * @return Si la vacuna ha sido rechazada
	 */
	@Override
	public final boolean reject() {
		boolean rejection = authorizationStatus == PENDING;
		if (rejection) {
			authorizationStatus = UNAUTHORIZED;
			resultDate = LocalDate.now();
		}
		return rejection;
	}

	/**
	 * @return El número de fases completadas
	 */
	public final byte getCompletedPhases() {
		return completedPhases;
	}

	/**
	 * @return Si la vacuna está autorizada
	 */
	public final boolean isAuthorized() {
		return authorizationStatus == AUTHORIZED;
	}

	/**
	 * @return Si la vacuna está rechazada
	 */
	public final boolean isUnauthorized() {
		return authorizationStatus == UNAUTHORIZED;
	}

	/**
	 * Introduce el resultado de una fase de pruebas
	 * 
	 * @param phaseNumber El número de fase que se desea introducir
	 * @param phaseComplete El resultado de la fase, true para superada, false para fallada
	 * @throws IllegalAccessException Si todas las fases han sido completadas
	 * @throws IllegalArgumentException Si se introduce una fase distinta de la esperada
	 */
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

	/**
	 * @return La fecha en la que la vacuna fue autorizada o rechazada
	 */
	public LocalDate getResultDate() {
		return resultDate;
	}

}
