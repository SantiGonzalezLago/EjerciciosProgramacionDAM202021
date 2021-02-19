package gal.teis.main;

import java.util.Scanner;

public class DataControl {

	public static int nextInt(Scanner sc) {
		boolean error;
		int num = 0;
		do {
			error = false;
			try {
				num = sc.nextInt();
			} catch (Exception ex) {
				System.out.println("Debes introducir un número entero.");
				error = true;
			}
		} while (error);
		return num;
	}
}
