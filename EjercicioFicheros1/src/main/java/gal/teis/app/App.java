package gal.teis.app;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static File file;
	public static Scanner sc;

	public static void main(String[] args) {
		file = new File(System.getProperty("user.home"), "file001.txt");
		sc = new Scanner(System.in);
		System.out.printf("Accediendo al archivo %s%n", file.getAbsoluteFile());

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Se ha producido un error al crear un fichero, se va a terminar la aplicación");
				e.printStackTrace();
				System.exit(-1);
			}
		}
		while (menu()) {
			System.out.println("Pulsa Enter para continuar.");
			sc.nextLine();
		}
	}

	private static boolean menu() {
		boolean repeatMenu = true;

		System.out.println("Elija una opción:");
		System.out.println("1. Leer contenido del archivo");
		System.out.println("2. Escribir en el archivo");
		System.out.println("3. Salir");

		switch (readOption()) {
		case 1:
			readFile();
			break;
		case 2:
			writeFile();
			break;
		case 3:
			System.out.println("Hasta la próxima");
			repeatMenu = false;
		}

		return repeatMenu;
	}

	private static void readFile() {
		try (Reader reader = new FileReader(file, Charset.forName("UTF-8"))) {
			char[] bufer = new char[1024];
			StringBuilder sb = new StringBuilder();
			while (reader.read(bufer) != -1) {
				sb.append(bufer);
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			System.out.printf("Se ha producido un error: %s%n", e.getMessage());
		}
	}

	private static void writeFile() {
		try (Writer writer = new FileWriter(file, true)) {
			System.out.println("Introduzca el texto a escribir:");
			String text = sc.nextLine();
			writer.write(text);
		} catch (IOException e) {
			System.out.printf("Se ha producido un error: %s%n", e.getMessage());
		}
	}

	private static byte readOption() {
		boolean error;
		byte opcion = 0;

		do {
			error = false;
			try {
				opcion = sc.nextByte();
				if (opcion <= 0 || opcion > 3) {
					System.out.println("Debe introducir un valor entre 1 y 3");
					error = true;
				}
			} catch (InputMismatchException ex) {
				System.out.println("Introduzca un número");
				error = true;
			} finally {
				sc.nextLine();
			}
		} while (error);

		return opcion;
	}

}
