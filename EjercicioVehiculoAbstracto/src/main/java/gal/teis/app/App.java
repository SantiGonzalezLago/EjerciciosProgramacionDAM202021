package gal.teis.app;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import gal.teis.model.*;

public class App {
	public static final char CLIENTE = 'C';
	public static final char ABONADO = 'A';

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Vehiculo v;
		char tipoCliente;
		int tiempo;
		String codigoDescuento = null;
		double importe;

		System.out.printf("¿Cliente (%C) o abonado (%C)?%n", CLIENTE, ABONADO);
		tipoCliente = introducirTipo();
		System.out.println("¿Cuánto tiempo (en días) ha tenido el vehículo?");
		tiempo = introducirTiempo();

		if (tipoCliente == ABONADO) {
			System.out.println("Introduzca el código de descuento (déjelo en blanco si no tiene)");
			codigoDescuento = sc.nextLine();
		}

		v = switch (tipoCliente) {
		case CLIENTE -> new VehiculoCliente("0001");
		case ABONADO -> new VehiculoAbonado("0001");
		default -> null;
		};
		v.setTiempo(tiempo);

		if (v instanceof VehiculoAbonado && Objects.nonNull(codigoDescuento) && codigoDescuento.length() > 0) {
			importe = ((VehiculoAbonado) v).factura(codigoDescuento);
		} else {
			importe = v.factura();
		}
		System.out.printf("El importe a abonar es de %.2f€%n", importe);
	}

	public static char introducirTipo() {
		boolean success = false;
		char returnValue = '0';
		while (!success) {
			try {
				returnValue = sc.nextLine().toUpperCase().charAt(0);
				if (returnValue == CLIENTE || returnValue == ABONADO) {
					success = true;
				} else {
					System.out.printf("Introduzca %C o %C, por favor.%n", CLIENTE, ABONADO);
				}
			} catch (IndexOutOfBoundsException ex) {
				System.out.println("Por favor, introduzca una respuesta.");
			}
		}
		return returnValue;
	}

	public static int introducirTiempo() {
		boolean success = false;
		int returnValue = 0;
		while (!success) {
			try {
				returnValue = sc.nextInt();
				if (returnValue > 0) {
					success = true;
				} else {
					System.out.println("El número de horas debe ser positivo.");
				}
			} catch (InputMismatchException ex) {
				System.out.println("Introduzca el número de horas, por favor.");
			} finally {
				sc.nextLine();
			}

		}
		return returnValue;
	}
}
