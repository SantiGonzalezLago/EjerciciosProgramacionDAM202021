package gal.teis.main;

import java.math.BigDecimal;
import java.util.InputMismatchException;

import gal.chanchi.scanner.KeyboardScanner;
import gal.teis.model.Account;

public class App {

	private static KeyboardScanner sc;

	public static void main(String[] args) {
		sc = new KeyboardScanner();
		byte option;
		boolean exit = false;
		do {
			System.out.println("Elija una opción:");
			System.out.println("1. Acceder");
			System.out.println("2. Acceder como administrador");
			System.out.println("3. Salir");
			try {
				option = sc.nextByte();
				switch (option) {
				case 1:
					userMenu();
					break;
				case 2:
					adminMenu();
					break;
				case 3:
					System.out.println("Adios");
					exit = true;
					break;
				default:
					System.out.println("Opción no válida");
				}
			} catch (InputMismatchException ex) {
				System.out.println("Debes introducir un valor numérico");
			}
		} while (!exit);
	}

	private static void userMenu() {
		try {
			Account acc = login();
			handleAccount(acc, Account.BASIC_ACCESSS_LEVEL);
		} catch (Exception ex) {
			System.out.println("La información introducida es incorrecta");
		}
	}

	private static void adminMenu() {
		byte option;
		System.out.println("Elija una opción:");
		System.out.println("1. Acceder a cuenta");
		System.out.println("2. Crear nueva cuenta");
		System.out.println("3. Salir");
		try {
			option = sc.nextByte();
			switch (option) {
			case 1:
				try {
					Account acc = login();
					handleAccount(acc, Account.ADMIN_ACCESSS_LEVEL);
				} catch (Exception ex) {
					System.out.println("La información introducida es incorrecta");
				}
				break;
			case 2:
				createAccount();
				break;
			case 3:
				System.out.println("Adios");
				break;
			default:
				System.out.println("Opción no válida");
			}
		} catch (InputMismatchException ex) {
			System.out.println("Debes introducir un valor numérico");
		}
	}

	private static void handleAccount(Account acc, byte accessLevel) {
		System.out.println("Bienvenido, " + acc.getName());
		byte option;
		BigDecimal amount;
		boolean exit = false;
		do {
			System.out.println("Elija una opción:");
			System.out.println("1. Consultar saldo");
			System.out.println("2. Ingresar saldo");
			System.out.println("3. Retirar saldo");
			System.out.println("4. Cambiar nombre");
			System.out.println("5. Cambiar contraseña");
			if (accessLevel == Account.ADMIN_ACCESSS_LEVEL)
				System.out.println("6. Cambiar número de cuenta");
			System.out.println("7. Salir");
			try {
				option = sc.nextByte();
				switch (option) {
				case 1:
					System.out.println("Su saldo es de " + acc.getBalance() + "€");
					break;
				case 2:
					System.out.println("Inserte la cantidad a ingresar:");
					amount = sc.nextBigDecimal();
					if (acc.addBalance(amount)) {
						System.out.println("Operación completada con éxito");
					} else {
						System.out.println("No se ha podido realizar la operación");
					}
					break;
				case 3:
					System.out.println("Inserte la cantidad a retirar:");
					amount = sc.nextBigDecimal();
					if (acc.removeBalance(amount)) {
						System.out.println("Operación completada con éxito");
					} else {
						System.out.println("No se ha podido realizar la operación");
					}
					break;
				case 4:
					System.out.println("Introduzca el nuevo nombre:");
					String name = sc.nextLine();
					if (acc.setName(name)) {
						System.out.println("Operación completada con éxito");
					} else {
						System.out.println("No se ha podido realizar la operación");
					}
					break;
				case 5:
					String curPwd, newPwd, repeatNewPwd;
					System.out.println("Introduzca la contraseña actual:");
					curPwd = sc.nextLine();
					System.out.println("Introduzca la nueva contraseña:");
					newPwd = sc.nextLine();
					System.out.println("Repita la nueva contraseña:");
					repeatNewPwd = sc.nextLine();
					if (acc.setPwd(curPwd, newPwd, repeatNewPwd)) {
						System.out.println("Operación completada con éxito");
					} else {
						System.out.println("No se ha podido realizar la operación");
					}
					break;
				case 7:
					System.out.println("Adios");
					exit = true;
					break;
				case 6:
					if (accessLevel == Account.ADMIN_ACCESSS_LEVEL) {
						System.out.println("Introduzca el nuevo número de cuenta:");
						String accNumber = sc.nextLine();
						if (AccountList.updateAccountNumber(acc, accNumber, accessLevel)) {
							System.out.println("Operación completada con éxito");
						} else {
							System.out.println("No se ha podido realizar la operación");
						}
						break;
					}
				default:
					System.out.println("Opción no válida");
				}
			} catch (InputMismatchException ex) {
				System.out.println("Debes introducir un valor numérico");
			}
		} while (!exit);
	}

	private static void createAccount() {
		String accNumber, pwd, name;
		System.out.println("Introduzca el número de cuenta:");
		accNumber = sc.nextLine();
		System.out.println("Introduzca el nombre:");
		name = sc.nextLine();
		System.out.println("Introduzca la contraseña:");
		pwd = sc.nextLine();
		Account acc = new Account(accNumber, pwd, name, new BigDecimal(0));
		if (AccountList.add(acc)) {
			System.out.println("Operación completada con éxito");
		} else {
			System.out.println("No se ha podido realizar la operación");
		}
	}

	private static Account login() throws Exception {
		String accNumber, pwd;
		System.out.println("Introduzca el número de cuenta:");
		accNumber = sc.nextLine();
		System.out.println("Introduzca la contraseña:");
		pwd = sc.nextLine();
		return AccountList.get(accNumber, pwd);
	}
}
