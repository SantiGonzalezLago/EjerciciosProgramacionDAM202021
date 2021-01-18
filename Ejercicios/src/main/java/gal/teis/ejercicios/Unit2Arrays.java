package gal.teis.ejercicios;

import java.util.Random;

import javax.swing.JOptionPane;

import gal.teis.io.KeyboardScanner;

@SuppressWarnings("unused")
public class Unit2Arrays {

	public static void start() {
		guessMonth();
//		calculateDniLetter();
	}

	// Práctica 1
	private static void guessMonth() {
		final String[] MONTHS = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto",
				"septiembre", "octubre", "noviembre", "diciembre" };
		String secretMonth = MONTHS[new Random().nextInt(MONTHS.length)];
		KeyboardScanner sc = new KeyboardScanner();
		String month = null;
		int monthNum;
		do {
			if (month == null) {
				System.out.print("Adivine el mes secreto. Introduzca el nombre o número del mes: ");
			} else {
				System.out.printf("No es %s. Intente adivinarlo introduciendo otro mes: ", month);
			}
			month = sc.nextLine().toLowerCase();
			try {
				monthNum = Integer.parseInt(month) - 1;
				month = MONTHS[monthNum];
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
			}
		} while (!month.equals(secretMonth));
		System.out.printf("¡Ha acertado! ¡El mes era %s!%n", secretMonth);
	}

	// Práctica 2
	private static void calculateDniLetter() {
		final char[] LETTERS = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };
		int dni;
		try {
			dni = Integer.valueOf(JOptionPane.showInputDialog(null,
					"Introduzca su DNI (sin la letra, utilice solo dígitos)", "DNI", JOptionPane.QUESTION_MESSAGE));
		} catch (NumberFormatException ex) {
			dni = -1;
		}
		if (dni >= 0 && dni <= 99999999) {
			char letter = LETTERS[dni % 23];
			JOptionPane.showMessageDialog(null, String.format("%08d-%c", dni, letter), "Resultado",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "El DNI es erróneo", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
