package gal.teis.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
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
		System.out.println("3. Contar en el archivo");
		System.out.println("0. Salir");

		switch (readOption()) {
		case 1:
			readFile();
			break;
		case 2:
			writeFile();
			break;
		case 3:
			countFile();
			break;
		case 0:
			System.out.println("Hasta la próxima");
			repeatMenu = false;
			break;
		default:
			System.out.println("Opción no válida");
		}

		return repeatMenu;
	}

	private static void countFile() {
		try (FileInputStream fileStream = new FileInputStream(file);
				InputStreamReader input = new InputStreamReader(fileStream);
				BufferedReader reader = new BufferedReader(input);) {

			int charCount = 0;
			int wordCount = 0;
			int lineCount = 1;
			int whitespaceCount = 0;

			String line;
			while ((line = reader.readLine()) != null) {
				if (line.equals("")) {
					lineCount++;
				} else {
					charCount += line.length();
					String[] wordList = line.split("\\s+"); // \\s+ es el delimitador de espacio en Java
					wordCount += wordList.length;
					whitespaceCount += wordCount - 1;
				}
			}

			System.out.printf("Carácteres: %d%n", charCount);
			System.out.printf("Palabras: %d%n", wordCount);
			System.out.printf("Líneas: %d%n", lineCount);
			System.out.printf("Espacios en blanco: %d%n", whitespaceCount);

			float size = ((float) Files.size(file.toPath()));
			int divisionCounter = 0;
			while (size > 1024 && divisionCounter < 3) {
				size /= 1024f;
				divisionCounter++;
			}
			String unit = switch (divisionCounter) {
			case 0 -> "B";
			case 1 -> "kiB";
			case 2 -> "MiB";
			case 3 -> "GiB";
			default -> "¿¿¿???";
			};
			System.out.printf("Tamaño: %.2f %s%n", size, unit);

		} catch (IOException e) {
			System.out.printf("Se ha producido un error: %s%n", e.getMessage());
		}
	}

	private static void readFile() {
		try (Reader reader = new FileReader(file, Charset.forName("UTF-8"))) {
			char[] bufer = new char[1024];
			StringBuilder sb = new StringBuilder();
			while (reader.read(bufer) != -1) {
				sb.append(bufer);
				bufer = new char[1024];
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
				if (opcion < 0) {
					System.out.println("Los valores negativos no son válidos");
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
