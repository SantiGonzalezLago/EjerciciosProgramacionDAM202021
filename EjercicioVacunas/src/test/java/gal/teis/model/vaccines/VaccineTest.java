package gal.teis.model.vaccines;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VaccineTest {

	@Test
	void testTrue1() {
		assertTrue(Vaccine.isCodeValid("VAedf45"));
	}

	@Test
	void testTrue2() {
		assertTrue(Vaccine.isCodeValid("Vxxx8"));
	}

	@Test
	void testTrue3() {
		assertTrue(Vaccine.isCodeValid("VXyZJ8"));
	}

	@Test
	void testTrue4() {
		assertTrue(Vaccine.isCodeValid("VagH8"));
	}

	@Test
	void testFalse1() {
		assertFalse(Vaccine.isCodeValid("8"));
	}

	@Test
	void testFalse2() {
		assertFalse(Vaccine.isCodeValid("patatasVAedf45"));
	}

	@Test
	void testFalse3() {
		assertFalse(Vaccine.isCodeValid("VAedf45patatas"));
	}

	@Test
	void testFalse4() {
		assertFalse(Vaccine.isCodeValid("patatasVAedf45patatas"));
	}
	
}
