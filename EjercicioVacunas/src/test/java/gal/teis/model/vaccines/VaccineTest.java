package gal.teis.model.vaccines;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VaccineTest {

	@Test
	void testTrue1() {
		// V, 4 letras, 2 dígitos
		assertTrue(Vaccine.isCodeValid("VAedf45"));
	}

	@Test
	void testTrue2() {
		// V, 3 letras, 2 dígitos
		assertTrue(Vaccine.isCodeValid("Vxxx8"));
	}

	@Test
	void testTrue3() {
		// V, 4 letras, 8
		assertTrue(Vaccine.isCodeValid("VXyZJ8"));
	}

	@Test
	void testTrue4() {
		// V, 3 letras, 8
		assertTrue(Vaccine.isCodeValid("VagH8"));
	}

	@Test
	void testFalse1() {
		// Solo un 8
		assertFalse(Vaccine.isCodeValid("8"));
	}

	@Test
	void testFalse2() {
		// Termina por código válido
		assertFalse(Vaccine.isCodeValid("patatasVAedf45"));
	}

	@Test
	void testFalse3() {
		// Empieza por código válido
		assertFalse(Vaccine.isCodeValid("VAedf45patatas"));
	}

	@Test
	void testFalse4() {
		// Código válido en medio
		assertFalse(Vaccine.isCodeValid("patatasVAedf45patatas"));
	}

	@Test
	void testFalse5() {
		// 2 letras
		assertFalse(Vaccine.isCodeValid("Vab12"));
	}

	@Test
	void testFalse6() {
		// 5 letras
		assertFalse(Vaccine.isCodeValid("Vabcde12"));
	}

	@Test
	void testFalse7() {
		// 1 dígito distinto de 8
		assertFalse(Vaccine.isCodeValid("VagH4"));
	}

	@Test
	void testFalse8() {
		// 3 dígitos
		assertFalse(Vaccine.isCodeValid("VagH458"));
	}

}
