package gal.teis.application;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase implementa únicamente el menú principal de la aplicación.
 * Las diferentes subaplicaciones están en su clase correspondiente.
 */
@SuppressWarnings("resource")
public class App {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        byte menu = 0;
        boolean error;
        do {
            System.out.println("Elija una opcion:");
            System.out.println("1. Calculadora");
            System.out.println("2. Capicúa");
            System.out.println("3. El gran juego del salto");
            System.out.println("4. Salir");
            do {
                error = false;
                try {
                    menu = sc.nextByte();
                } catch (InputMismatchException ex) {
                    System.out.println("Debe introducir un número entero:");
                    error = true;
                } finally {
                    sc.nextLine();
                }
            } while (error);
            switch (menu) {
                case 1:
                    Calculator.calculator();
                    break;
                case 2:
                    Capicua.capicua();
                    break;
                case 3:
                    BigGame.game();
                    break;
                case 4:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion no válida.");
            }

            if (menu != 4) {
                System.out.println("Pulsa Enter para continuar.");
                sc.nextLine();
            }
        }while (menu != 4);
    }
}
