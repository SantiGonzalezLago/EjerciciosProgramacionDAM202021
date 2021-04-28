package gal.teis.model.vaccines;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VaccineAuthorizationTest {

	VaccineAuthorization instance;
	
	@BeforeEach
	void createInstance() {
		// Creo cualquier clase que implemente esta, dado que esta es abstracta y los métodos son finales
		instance = new JanssenVaccine("VAedf45");
	}
	
	@Test
	void testAuthorizeTrue() throws IllegalAccessException, IllegalArgumentException {
		instance.setTestPhaseResult((byte) 1, true);
		instance.setTestPhaseResult((byte) 2, true);
		instance.setTestPhaseResult((byte) 3, true);
		assertTrue(instance.authorize());
	}
	
	@Test
	void testAuthorizeFalse1() throws IllegalAccessException, IllegalArgumentException {
		instance.setTestPhaseResult((byte) 1, true);
		assertFalse(instance.authorize());
	}
	
	@Test
	void testAuthorizeFalse2() throws IllegalAccessException, IllegalArgumentException {
		instance.setTestPhaseResult((byte) 1, true);
		instance.setTestPhaseResult((byte) 2, true);
		instance.setTestPhaseResult((byte) 3, true);
		instance.reject();
		assertFalse(instance.authorize());
	}
	
	@Test
	void testRejectTrue1() throws IllegalAccessException, IllegalArgumentException {
		instance.setTestPhaseResult((byte) 1, true);
		instance.setTestPhaseResult((byte) 2, false);
		assertTrue(instance.reject());
	}
	
	@Test
	void testRejectTrue2() throws IllegalAccessException, IllegalArgumentException {
		instance.setTestPhaseResult((byte) 1, true);
		instance.setTestPhaseResult((byte) 2, true);
		instance.setTestPhaseResult((byte) 3, false);
		assertTrue(instance.reject());
	}
	
	@Test
	void testRejectFalse() throws IllegalAccessException, IllegalArgumentException {
		instance.setTestPhaseResult((byte) 1, true);
		instance.setTestPhaseResult((byte) 2, true);
		instance.setTestPhaseResult((byte) 3, false);
		instance.authorize();
		assertTrue(instance.reject());
	}

}
