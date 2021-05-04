package gal.teis.app;

import gal.teis.model.inventory.VaccineWarehouse;
import gal.teis.model.vaccines.JanssenVaccine;
import gal.teis.model.vaccines.ModernaVaccine;
import gal.teis.model.vaccines.PfizerVaccine;
import gal.teis.model.vaccines.SoberanaVaccine;
import gal.teis.model.vaccines.Vaccine;

/**
 * <h2>TestMode</h2>
 * 
 * Esta clase se utilizará para inicializar valores por defecto de la aplicación para realizar pruebas
 * 
 * @author Santiago González Lago
 */
public class TestMode {

	protected static void runTestMode() {
		System.out.println("SE HA INICIADO LA APLICACIÓN EN MODO TEST");
		initializeTestValues();
	}
	
	private static void initializeTestValues() {
		try {
			final char[] vowels = {'A','E','I','O'};
			
			VaccineWarehouse.add(new JanssenVaccine("VAxxx44"));
			VaccineWarehouse.add(new JanssenVaccine("VAxxx45"));
			VaccineWarehouse.add(new JanssenVaccine("VAxxx46"));
			VaccineWarehouse.add(new JanssenVaccine("VAxxx47"));
			VaccineWarehouse.add(new ModernaVaccine("VExxx44"));
			VaccineWarehouse.add(new ModernaVaccine("VExxx45"));
			VaccineWarehouse.add(new ModernaVaccine("VExxx46"));
			VaccineWarehouse.add(new ModernaVaccine("VExxx47"));
			VaccineWarehouse.add(new PfizerVaccine("VIxxx44"));
			VaccineWarehouse.add(new PfizerVaccine("VIxxx45"));
			VaccineWarehouse.add(new PfizerVaccine("VIxxx46"));
			VaccineWarehouse.add(new PfizerVaccine("VIxxx47"));
			VaccineWarehouse.add(new SoberanaVaccine("VOxxx44"));
			VaccineWarehouse.add(new SoberanaVaccine("VOxxx45"));
			VaccineWarehouse.add(new SoberanaVaccine("VOxxx46"));
			VaccineWarehouse.add(new SoberanaVaccine("VOxxx47"));

			for (int i = 0; i < 4; i++) {
				Vaccine authorized = VaccineWarehouse.getVaccine(String.format("V%cxxx45", vowels[i]));
				authorized.setTestPhaseResult((byte) 1, true);
				authorized.setTestPhaseResult((byte) 2, true);
				authorized.setTestPhaseResult((byte) 3, true);
				authorized.authorize();
				Vaccine rejected = VaccineWarehouse.getVaccine(String.format("V%cxxx46", vowels[i]));
				rejected.setTestPhaseResult((byte) 1, true);
				rejected.setTestPhaseResult((byte) 2, false);
				rejected.reject();
				Vaccine partialProgress = VaccineWarehouse.getVaccine(String.format("V%cxxx47", vowels[i]));
				partialProgress.setTestPhaseResult((byte) 1, true);
			}
		} catch (Exception e) {
			System.out.println("Se ha producido un error al cargar los datos de prueba:");
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
