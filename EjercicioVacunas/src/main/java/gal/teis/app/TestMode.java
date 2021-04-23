package gal.teis.app;

import gal.teis.model.inventory.VaccineWarehouse;
import gal.teis.model.vaccines.JanssenVaccine;
import gal.teis.model.vaccines.ModernaVaccine;
import gal.teis.model.vaccines.PfizerVaccine;
import gal.teis.model.vaccines.SoberanaVaccine;
import gal.teis.model.vaccines.Vaccine;

public class TestMode {
	
	protected static final boolean ENABLED = true;

	protected static void initializeTestValues() {
		try {
			final char[] vowels = {'A','E','I','O'};
			
			VaccineWarehouse.add(new JanssenVaccine("VAxxx01"));
			VaccineWarehouse.add(new JanssenVaccine("VAxxx02"));
			VaccineWarehouse.add(new JanssenVaccine("VAxxx03"));
			VaccineWarehouse.add(new JanssenVaccine("VAxxx04"));
			VaccineWarehouse.add(new ModernaVaccine("VExxx01"));
			VaccineWarehouse.add(new ModernaVaccine("VExxx02"));
			VaccineWarehouse.add(new ModernaVaccine("VExxx03"));
			VaccineWarehouse.add(new ModernaVaccine("VExxx04"));
			VaccineWarehouse.add(new PfizerVaccine("VIxxx01"));
			VaccineWarehouse.add(new PfizerVaccine("VIxxx02"));
			VaccineWarehouse.add(new PfizerVaccine("VIxxx03"));
			VaccineWarehouse.add(new PfizerVaccine("VIxxx04"));
			VaccineWarehouse.add(new SoberanaVaccine("VOxxx01"));
			VaccineWarehouse.add(new SoberanaVaccine("VOxxx02"));
			VaccineWarehouse.add(new SoberanaVaccine("VOxxx03"));
			VaccineWarehouse.add(new SoberanaVaccine("VOxxx04"));

			for (int i = 0; i < 4; i++) {
				Vaccine authorized = VaccineWarehouse.getVaccine(String.format("V%cxxx02", vowels[i]));
				authorized.setTestPhaseResult((byte) 1, true);
				authorized.setTestPhaseResult((byte) 2, true);
				authorized.setTestPhaseResult((byte) 3, true);
				authorized.authorize();
				Vaccine rejected = VaccineWarehouse.getVaccine(String.format("V%cxxx03", vowels[i]));
				rejected.setTestPhaseResult((byte) 1, true);
				rejected.setTestPhaseResult((byte) 2, false);
				rejected.reject();
				Vaccine partialProgress = VaccineWarehouse.getVaccine(String.format("V%cxxx04", vowels[i]));
				partialProgress.setTestPhaseResult((byte) 1, true);
			}
		} catch (Exception e) {
			System.out.println("Se ha producido un error al cargar los datos de prueba:");
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
