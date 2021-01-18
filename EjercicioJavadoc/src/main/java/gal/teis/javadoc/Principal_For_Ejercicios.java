package gal.teis.javadoc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h2>Principal_For_Ejercicios</h2>
 * 
 * Esta clase contiene métodos que realizan diversas funciones matemáticas
 * 
 * @author Santiago González Lago
 * @version 1.0.210118
 */
@SuppressWarnings("resource")
public class Principal_For_Ejercicios {

	/**
	 * Calcula el factorial de un número entero
	 * @return el resultado
	 */
	public static int ejer1_Factorial() {
		int num = 3;
		int fact = 1;
		for (int i = 2; i <= num; i++) {
			fact *= i;
		}
		System.out.println("El factorial de " + num + " es " + fact);
		return fact;
	}

	/**
	 * Calcula el sumatorio de un número entero
	 * @return el resultado
	 */
	public static int ejer2_Sumatorio() {
		int num = 3;
		int sumatorio = 0;
		for (int i = 1; i <= num; i++) {
			sumatorio += i;
		}
		System.out.println("El sumatorio de " + num + " es " + sumatorio);
		return sumatorio;
	}

	/**
	 * Calcula la lista de divisores de un número entero
	 * @return un array con los divisores
	 */
	public static Integer[] ejer3_Divisores() {
		int num = 10;
		ArrayList<Integer> divisores = new ArrayList<>();
		System.out.println("Los divisores de " + num + "son:");
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				System.out.println(i);
				divisores.add(i);
			}
		}
		return (Integer[]) divisores.toArray();
	}

	/**
	 * Solicita diez números por consola y calcula la media de los negativos y la cantidad de ceros
	 * @return un array con la media de negativos en [0] y la cantidad de ceros en [1]
	 */
	public static int[] ejer5_MediasVarias() {
		int media_negativos = 0, cantidad_ceros = 0;
		int numero;
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			System.out.println("Introduce el número " + i);
			numero = sc.nextInt();
			if (numero < 0) {
				media_negativos += 1;
			} else if (numero == 0) {
				cantidad_ceros += 1;
			}
		}
		return new int[] {media_negativos, cantidad_ceros};
	}

	/**
	 * Calcula si un número es primo
	 * @return un boolean que informa del resultado
	 */
	public static boolean ejer6_Primos() {
		int num = 10;
		boolean primo = true;
		// TODO Se optimizará usando while
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				primo = false;
			}
		}
		return primo;
	}

	/**
	 * Dibuja una escalera
	 */
	static void ejer7_Escalera() {
		int tope = 10;
		for (int i = 1; i < tope; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

}