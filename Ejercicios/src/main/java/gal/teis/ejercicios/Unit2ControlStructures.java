package gal.teis.ejercicios;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

import gal.teis.io.KeyboardScanner;

@SuppressWarnings("unused")
public class Unit2ControlStructures {

	public static void start() {
//		convertHours(1000);
//		dateTime();
//		addTwoNumbers();
//		payIrpf();
//		qualificationPassFail();
//		averageQualification();
//		tooYoung();
//		temperatures();
//		qualification();
//		vehicles();
//		weekDay();
//		showEven();
//		showRange();

//		EJERCICIOS if
//		evenNumber();
//		leapYears();
//		login();
//		sortNumbers();
//		numberOfDigits();
//		payment();
//		atm();

//		EJERCICIOS for
//		factorial();
//		divisors();
//		sigmaNaturalNumbers();
//		avgNegativesAndAmountOfZeroes();
//		checkPrime();
//		staircase();

//		EJERCICIOS while
//		tens();
//		oneToTen();
//		tenToOne();
//		factorialAndSigmaWhile();
//		guessTheNumber();

//		EJERCICIOS do while
		multiplicationTables();
//		rectangle();
//		atm2();

//		PRÁCTICAS
//		caesarCipher();
//		change();
//		fibonacci();
	}

	private static void fibonacci() {
		long num1 = 1, num2 = 0, curNum = 0, position = 0;
		KeyboardScanner sc = new KeyboardScanner();
		boolean error;
		do {
			error = false;
			System.out.print("Introduzca la posición de secuencia que desee: ");
			try {
				position = sc.nextInt();
			} catch (InputMismatchException ex) {
				error = true;
			}
		} while (error);
		if (position > 92) {
			System.out.println("El programa no funciona para posiciones superiores a 92");
		} else if (position > 0) {
			for (int i = 1; i <= position; i++) {
				curNum = num1 + num2;
				if (i % 2 == 0) {
					num2 = curNum;
				} else {
					num1 = curNum;
				}
			}
			System.out.println("El número buscado es " + curNum);
		} else {
			System.out.println("El número debe ser positivo.");
		}
	}

	private static void change() {
		final double PRIZE = 4.65;
		double payment = 0f, change;
		KeyboardScanner sc = new KeyboardScanner();
		boolean error;
		do {
			error = false;
			System.out.print("Introduzca el dinero: ");
			try {
				payment = sc.nextDouble();
			} catch (InputMismatchException ex) {
				error = true;
			}
		} while (error);
		if (payment < PRIZE) {
			System.out.println("No has introducido suficiente dinero.");
		} else if (payment == PRIZE) {
			System.out.println("No hay cambio.");
		} else {
			change = payment - PRIZE;
			change = deductBillsOrCoins(change, 500, false);
			change = deductBillsOrCoins(change, 200, false);
			change = deductBillsOrCoins(change, 100, false);
			change = deductBillsOrCoins(change, 50, false);
			change = deductBillsOrCoins(change, 20, false);
			change = deductBillsOrCoins(change, 10, false);
			change = deductBillsOrCoins(change, 5, false);
			change = deductBillsOrCoins(change, 2, true);
			change = deductBillsOrCoins(change, 1, true);
			change = deductBillsOrCoins(change, 0.50, true);
			change = deductBillsOrCoins(change, 0.20, true);
			change = deductBillsOrCoins(change, 0.10, true);
			change = deductBillsOrCoins(change, 0.05, true);
			change = deductBillsOrCoins(change, 0.02, true);
			change = deductBillsOrCoins(change, 0.01, true);
		}
	}

	private static double deductBillsOrCoins(double change, double value, boolean coin) {
		int counter = 0;
		while (change >= value) {
			change -= value;
			counter++;
		}
		if (counter > 0) {
			System.out.printf("%s de %.2f€: %d%n", coin ? "Monedas" : "Billetes", value, counter);
		}
		return change;
	}

	private static void caesarCipher() {
		String text;
		StringBuilder cipheredText;
		int displacement = 0;
		KeyboardScanner sc = new KeyboardScanner();
		System.out.print("Introduzca el texto a cifrar: ");
		text = sc.nextLine();
		boolean error;
		do {
			error = false;
			System.out.print("Introduzca el desplazamiento: ");
			try {
				displacement = sc.nextInt();
			} catch (InputMismatchException ex) {
				error = true;
			}
		} while (error);
		cipheredText = new StringBuilder();
		for (char c : text.toCharArray()) {
			cipheredText.append(encodeLetter(c, displacement));
		}
		System.out.println(cipheredText);
	}

	private static char encodeLetter(char letter, int displacement) {
		final String ALPHABET = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		int ogPosition, endPosition;
		boolean caps;
		ogPosition = ALPHABET.indexOf(Character.toUpperCase(letter));
		if (ogPosition != -1) {
			caps = Character.isUpperCase(letter);
			endPosition = ogPosition + displacement;
			while (endPosition < 0) {
				endPosition += ALPHABET.length();
			}
			while (endPosition >= ALPHABET.length()) {
				endPosition -= ALPHABET.length();
			}
			if (caps) {
				return ALPHABET.charAt(endPosition);
			} else {
				return Character.toLowerCase(ALPHABET.charAt(endPosition));
			}
		}
		return letter;
	}

	private static void atm2() {
		BigDecimal balance = new BigDecimal(400);
		BigDecimal amount;
		String pwd = "1234", pwdAttempt;
		int menu, lgnMenu;
		KeyboardScanner sc = new KeyboardScanner();
		do {
			System.out.println("¿Qué desea hacer?");
			System.out.println("1. Iniciar sesión");
			System.out.println("2. Salir");
			try {
				lgnMenu = sc.nextInt();
			} catch (InputMismatchException ex) {
				lgnMenu = 0;
			}
			switch (lgnMenu) {
			case 1:
				System.out.print("Introduzca la contraseña: ");
				pwdAttempt = sc.nextLine();
				if (pwd.equals(pwdAttempt)) {
					System.out.println("Acceso concedido");
					do {
						System.out.println("Elige la operación:");
						System.out.println("1. Ingresar");
						System.out.println("2. Retirar");
						System.out.println("3. Ver saldo");
						System.out.println("4. Cambiar contraseña");
						System.out.println("5. Salir");
						try {
							menu = sc.nextInt();
						} catch (InputMismatchException ex) {
							menu = 0;
						}
						switch (menu) {
						case 1:
							System.out.print("Introduzca el valor a introducir: ");
							amount = sc.nextBigDecimal();
							balance = balance.add(amount);
							System.out.printf("Tu saldo actual es de %.2f€%n", balance);
							break;
						case 2:
							System.out.print("Introduzca el valor a retirar: ");
							amount = sc.nextBigDecimal();
							if (amount.compareTo(balance) > 0) {
								System.out.println("No tienes tanto dinero en la cuenta.");
							} else {
								balance = balance.subtract(amount);
								System.out.printf("Tu saldo actual es de %.2f€%n", balance);
							}
							break;
						case 3:
							System.out.printf("Tu saldo actual es de %.2f€%n", balance);
							break;
						case 4:
							String newPwd, repeatPwd;
							System.out.print("Introduzca la contraseña actual: ");
							pwdAttempt = sc.nextLine();
							if (pwd.equals(pwdAttempt)) {
								System.out.print("Introduzca la nueva contraseña: ");
								newPwd = sc.nextLine();
								System.out.print("Repita la nueva contraseña: ");
								repeatPwd = sc.nextLine();
								if (newPwd.equals(repeatPwd)) {
									System.out.println("Contraseña cambiada");
									pwd = newPwd;
								} else {
									System.out.println("Las contraseñas no coinciden");
								}
							} else {
								System.out.println("Contraseña incorrecta");
							}
							break;
						case 5:
							System.out.println("Hasta adios");
							break;
						default:
							System.out.println("Opción no válida");
						}
						System.out.println();
					} while (menu != 5);
				} else {
					System.out.println("Acceso denegado");
				}
				break;
			case 2:
				System.out.println("Hasta adios");
				break;
			default:
				System.out.println("Opción no válida");
			}
			System.out.println();
		} while (lgnMenu != 2);
	}

	private static void rectangle() {
		int height, width, curHeight, curWidth;
		KeyboardScanner sc = new KeyboardScanner();
		System.out.print("Introduzca la altura: ");
		height = sc.nextInt();
		System.out.print("Introduzca la anchura: ");
		width = sc.nextInt();
		curHeight = 0;
		do {
			curHeight++;
			curWidth = 0;
			do {
				curWidth++;
				if (curHeight == 1 || curHeight == height || curWidth == 1 || curWidth == width) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}
			} while (curWidth < width);
			System.out.println();
		} while (curHeight < height);
	}

	private static void multiplicationTables() {
		int table = 2;
		do {
			System.out.println("Tabla del " + table);
			int number = 0;
			do {
				System.out.println(table + " x " + number + " = " + table * number);
				number++;
			} while (number <= 10);
			System.out.println();
			table++;
		} while (table <= 9);
	}

	private static void guessTheNumber() {
		int number, attempt = 1, guess = -1;
		KeyboardScanner sc = new KeyboardScanner();
		System.out
				.println("Se va a generar aleatoriamente un número entre 0 y 100. Tiene 10 intentos para adivinarlo.");
		number = new Random().nextInt(101);
		while (attempt <= 10 && number != guess) {
			System.out.print("Intento número " + attempt + ". Intente adivinar: ");
			guess = sc.nextInt();
			if (guess > number) {
				System.out.println("Demasiado alto");
			} else if (guess < number) {
				System.out.println("Demasiado bajo");
			}
			attempt++;
		}
		if (number != guess) {
			System.out.println("Te has quedado sin intentos.");
		} else {
			System.out.println("¡Has adivinado!");
		}
	}

	private static void factorialAndSigmaWhile() {
		KeyboardScanner sc = new KeyboardScanner();
		int number, sigma = 0, factorial = 1;
		System.out.print("Introduzca el valor a calcular: ");
		number = sc.nextInt();
		if (number < 0 || number > 10) {
			System.out.println("El número tiene que estar entre 0 y 10");
		} else {
			int i = 1;
			while (i <= number) {
				sigma += i;
				factorial *= i;
				i++;
			}
			System.out.println("\u03A3" + number + " = " + sigma);
			System.out.println(number + "! = " + factorial);
		}
	}

	private static void tenToOne() {
		int x = 10;
		while (x > 0) {
			System.out.println(x--);
		}
	}

	private static void oneToTen() {
		int number = 1;
		while (number <= 10) {
			System.out.println(number++);
		}
	}

	private static void tens() {
		int number = 10;
		while (number <= 100) {
			System.out.println(number);
			number += 10;
		}
	}

	private static void sigmaNaturalNumbers() {
		KeyboardScanner sc = new KeyboardScanner();
		System.out.print("Introduzca el valor a calcular: ");
		int num = sc.nextInt();
		long result = calculateSigma(num);
		System.out.println("\u03A3" + num + " = " + result);
	}

	// Este método implemente la recursión para el método anterior
	private static int calculateSigma(int num) throws ArithmeticException {
		if (num == 0) {
			return 0;
		}
		if (num > 0)
			return num + calculateSigma(num - 1);
		else
			return num + calculateSigma(num + 1);
	}

	private static void staircase() {
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j % 10);
			}
			System.out.println();
		}
	}

	private static void checkPrime() {
		KeyboardScanner sc = new KeyboardScanner();
		int number;
		boolean isPrime = true;
		System.out.print("Introduzca un número: ");
		number = sc.nextInt();
		if (number < 2) {
			System.out.println(number + " no es un número primo");
		} else {
			for (int i = 2; i < number; i++) {
				if (number % i == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				System.out.println(number + " es un número primo.");
			} else {
				System.out.println(number + " no es un número primo");
			}
		}
	}

	private static void avgNegativesAndAmountOfZeroes() {
		KeyboardScanner sc = new KeyboardScanner();
		float number, sumNegatives = 0;
		int amountNegatives = 0, amountZeroes = 0;
		System.out.println("Introduzca 10 números, por favor");
		for (int i = 0; i < 10; i++) {
			number = sc.nextFloat();
			if (number == 0) {
				amountZeroes++;
			} else if (number < 0) {
				amountNegatives++;
				sumNegatives += number;
			}
		}
		System.out.println("Has introducido " + amountZeroes + " ceros.");
		if (amountNegatives > 0) {
			System.out.printf("La media de los números negativos es %f.%n", (sumNegatives / amountNegatives));
		} else {
			System.out.println("No has introducido números negativos.");
		}
	}

	private static void divisors() {
		KeyboardScanner sc = new KeyboardScanner();
		int number;
		System.out.print("Introduzca un número: ");
		number = sc.nextInt();
		int i = (number > 0) ? 1 : number;
		for (; i <= Math.abs(number); i++) {
			if (i != 0 && number % i == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	private static void factorial() {
		KeyboardScanner sc = new KeyboardScanner();
		System.out.print("Introduzca el valor a calcular: ");
		int num = sc.nextInt();
		try {
			long result = calculateFactorial(num);
			System.out.println(num + "! = " + result);
		} catch (ArithmeticException ex) {
			System.out.println("No existe el factorial de un número negativo");
		}
	}

	// Este método implemente la recursión para el método anterior
	private static long calculateFactorial(long num) throws ArithmeticException {
		if (num < 0) {
			throw new ArithmeticException();
		}
		if (num == 0) {
			return 1;
		}
		return num * calculateFactorial(num - 1);
	}

	private static void showRange() {
		int minValue, maxValue;
		KeyboardScanner sc = new KeyboardScanner();
		System.out.print("Introduce el valor mínimo a mostrar: ");
		minValue = sc.nextInt();
		System.out.print("Introduce el valor máximo a mostrar: ");
		maxValue = sc.nextInt();
		if (maxValue < minValue) {
			System.out.println("Error");
		} else {
			for (int i = minValue; i <= maxValue; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

	private static void showEven() {
		int maxValue;
		KeyboardScanner sc = new KeyboardScanner();
		System.out.print("Introduce el valor máximo a mostrar: ");
		maxValue = sc.nextInt();
		for (int i = 0; i <= maxValue; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	private static void atm() {
		BigDecimal balance = new BigDecimal(400);
		BigDecimal amount;
		int menu;
		KeyboardScanner sc = new KeyboardScanner();
		do {
			System.out.println("Elige la operación: ");
			System.out.println("1. Ingresar");
			System.out.println("2. Retirar");
			System.out.println("3. Salir");
			try {
				menu = sc.nextInt();
			} catch (InputMismatchException ex) {
				menu = 0;
			}
			switch (menu) {
			case 1:
				System.out.print("Introduzca el valor a introducir: ");
				amount = sc.nextBigDecimal();
				balance = balance.add(amount);
				System.out.printf("Tu saldo actual es de %.2f€%n", balance);
				break;
			case 2:
				System.out.print("Introduzca el valor a retirar: ");
				amount = sc.nextBigDecimal();
				if (amount.compareTo(balance) > 0) {
					System.out.println("No tienes tanto dinero en la cuenta.");
				} else {
					balance = balance.subtract(amount);
					System.out.printf("Tu saldo actual es de %.2f€%n", balance);
				}
				break;
			case 3:
				System.out.println("Hasta adios");
				break;
			default:
				System.out.println("Opción no válida");
			}
			System.out.println();
		} while (menu != 3);
	}

	private static void payment() {
		final String[] options = { "Al contado", "Con tarjeta", "Otro" };
		double amount;
		int response;
		try {
			amount = Float.parseFloat(JOptionPane.showInputDialog(null, "¿Cuál es el valor de la transacción?",
					"Precio", JOptionPane.QUESTION_MESSAGE));
			response = JOptionPane.showOptionDialog(null, "¿Cómo se efectúa el pago?", "Método de pago",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[2]);
			switch (response) {
			case 0:
				amount = amount * 0.95;
				System.out.println(
						"Se aplica un descuento del 5%, el precio final es de " + String.format("%.2f", amount) + "€");
				break;
			case 1:
				amount = amount * 1.03;
				System.out.println(
						"Se aplica un recargo del 3%, el precio final es de " + String.format("%.2f", amount) + "€");
				break;
			case 2:
				System.out.println("El precio final es de " + String.format("%.2f", amount) + "€");
				break;
			}
		} catch (Exception ex) {
			System.out.println("Se ha producido un error");
		}
	}

	private static void numberOfDigits() {
		int number;
		KeyboardScanner sc = new KeyboardScanner();
		System.out.println("Introduzca un número entre 0 y 99999");
		number = sc.nextInt();
		if (number < 0 || number > 99999) {
			System.out.println("El número es inválido");
		} else {
			System.out.printf("El número introducido tiene %d dígitos.%n", String.valueOf(number).length());
		}
	}

	private static void sortNumbers() {
		int[] numbers = new int[3];
		KeyboardScanner sc = new KeyboardScanner();
		for (int i = 0; i < numbers.length; i++) {
			System.out.print("Introduzca un valor: ");
			numbers[i] = sc.nextInt();
		}
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}

	private static void login() {
		final String USER = "chanchi";
		final String PWD = "1234";
		String user, pwd;
		KeyboardScanner sc = new KeyboardScanner();
		System.out.print("Usuario: ");
		user = sc.nextLine();
		System.out.print("Contraseña: ");
		pwd = sc.nextLine();
		if (USER.equals(user) && PWD.equals(pwd)) {
			System.out.println("Acceso concedido");
		} else {
			System.out.println("Acceso denegado");
		}
	}

	private static void leapYears() {
		int year;
		KeyboardScanner sc = new KeyboardScanner();
		System.out.print("Introduzca un año: ");
		year = sc.nextInt();
		if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
			System.out.println(year + " es un año bisiesto");
		} else {
			System.out.println(year + " NO es un año bisiesto");
		}
	}

	private static void evenNumber() {
		long number;
		KeyboardScanner sc = new KeyboardScanner();
		System.out.print("Introduzca un número entero: ");
		number = sc.nextLong();
		if (number % 2 == 0) {
			System.out.printf("%d es par%n", number);
		} else {
			System.out.printf("%d es impar%n", number);
		}

	}

	private static void weekDay() {
		int day;
		KeyboardScanner sc = new KeyboardScanner();
		System.out.print("Introduce el día de la semana (1-7): ");
		day = sc.nextInt();
		switch (day) {
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			System.out.println("Dia laboral");
			break;
		case 1:
		case 7:
			System.out.println("Fin de semana");
			break;
		default:
			System.out.println("La semana solo tiene 7 días");
			break;
		}
	}

	private static void vehicles() {
		String vehicleType;

		KeyboardScanner sc = new KeyboardScanner();
		System.out.print("Introduzca el tipo de vehículo: ");
		vehicleType = sc.nextLine();

		switch (vehicleType.toLowerCase()) {
		case "coche":
			System.out.println("Puedes pasar de 00:00 a 08:00");
			break;
		case "camión":
			System.out.println("Puedes pasar de 08:00 a 16:00");
			break;
		case "moto":
			System.out.println("Puedes pasar de 16:00 a 24:00");
			break;
		default:
			System.out.println("No puedes pasar con " + vehicleType);
		}

	}

	private static void qualification() {
		KeyboardScanner sc = new KeyboardScanner();
		System.out.print("Nota (0-10): ");
		double nota = sc.nextDouble();
		if (nota == 10) {
			System.out.println("Matrícula de Honor");
		} else if (nota >= 9) {
			System.out.println("Sobresaliente");
		} else if (nota >= 7) {
			System.out.println("Notable");
		} else if (nota >= 5) {
			System.out.println("Un triste aprobado");
		} else {
			System.out.println("Suspenso");
		}
	}

	private static void temperatures() {
		int temp;
		String message;
		Random rnd = new Random();
		temp = rnd.nextInt(50);

		if (temp < 10) {
			message = "cuando el grajo vuela bajo, hace un frío de carajo";
		} else if (temp < 15) {
			message = "se está fresquito";
		} else if (temp < 25) {
			message = "la temperatura es agradable";
		} else if (temp < 35) {
			message = "hace algo de calor";
		} else {
			message = "hace un calor que caen los pájaros";
		}

		System.out.printf("La temperatura actual es de %dº, %s.%n", temp, message);
	}

	private static void tooYoung() {
		int age;
		String name;
		KeyboardScanner sc = new KeyboardScanner();
		System.out.print("Introduzca su nombre, por favor: ");
		name = sc.nextLine();
		System.out.print("Introduzca su edad: ");
		age = sc.nextInt();
		if (name.equalsIgnoreCase("Ana")) {
			System.out.println("¡Hola, Ana!");
			if (age >= 18) {
				System.out.println("Eres mayor de edad.");
			} else {
				System.out.println("Aún no eres mayor de edad.");
			}
		} else {
			System.out.println("Largo de aquí, " + name + ", no eres bien recibido.");
		}
	}

	private static void averageQualification() {
		int mathQ, historyQ, computingQ;
		double average;
		mathQ = Integer.parseInt(JOptionPane.showInputDialog("Nota de Matematicas"));
		historyQ = Integer.parseInt(JOptionPane.showInputDialog("Nota de Historia"));
		computingQ = Integer.parseInt(JOptionPane.showInputDialog("Nota de Informática"));
		average = (mathQ + historyQ + computingQ) / 3;
		if (average >= 5) {
			JOptionPane.showMessageDialog(null, "¡Enhorabuena! Tu media es " + average);
		} else {
			JOptionPane.showMessageDialog(null, "¡A Septiembre! Tu media es " + average);
		}
	}

	private static void qualificationPassFail() {
		KeyboardScanner sc = new KeyboardScanner();
		int qualification;
		System.out.print("Introduce la nota del examen: ");
		qualification = sc.nextInt();
		if (qualification >= 5) {
			System.out.println("Has aprobado");
		} else {
			System.out.println("Has suspendido");
		}

	}

	private static void payIrpf() {
		KeyboardScanner sc = new KeyboardScanner();
		double income;
		System.out.print("Introduzca sus ingresos anuales: ");
		income = sc.nextDouble();
		if (income < 12450) {
			System.out.println("Estás extento de pagar IRPF");
		} else {
			System.out.println("¡¡¡PAGA!!!");
		}
	}

	private static void addTwoNumbers() {
		KeyboardScanner sc = new KeyboardScanner();
		int n1, n2;
		System.out.print("Introduce un número entero: ");
		n1 = sc.nextInt();
		System.out.print("Introduce otro número entero: ");
		n2 = sc.nextInt();
		System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
	}

	private static void dateTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("kk:mm:ss");
		System.out.println("La fecha actual es: " + dateFormat.format(date));
		System.out.println("La hora actual es: " + timeFormat.format(date));
	}

	private static void convertHours(int horas) {
		int semanas, dias, restoHoras;
		dias = horas / 24;
		restoHoras = horas % 24;
		semanas = dias / 7;
		dias %= 7;
		System.out.println(
				horas + " horas corresponden a " + semanas + " semanas, " + dias + " días y " + restoHoras + " horas.");
	}

}
