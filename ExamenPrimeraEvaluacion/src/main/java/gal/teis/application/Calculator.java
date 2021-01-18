package gal.teis.application;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase implementa la aplicación Calculadora.
 */
@SuppressWarnings("resource")
public class Calculator {
    public static void calculator(){
        Scanner sc = new Scanner(System.in);
        double num1 = 0, num2 = 0;
        char operator;
        boolean error;

        System.out.println("Bienvenido a la aplicacion Calculadora.");

        System.out.println("Introduzca dos números para realizar la operación:");
        do {
            error = false;
            try {
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
            } catch (InputMismatchException ex) {
                error = true;
                System.out.println("Ha introducido un valor incorrecto, reintroduzca los valores:");
            } finally {
                sc.nextLine();
            }
        } while (error);

        System.out.println("Introduzca el operador (+, -, *, /, %):");
        try {
            operator = sc.nextLine().charAt(0);
        } catch (StringIndexOutOfBoundsException ex) {
            operator = ' ';
            // Saltará esta excepción si el usuario no introduce ningún caracter
            // Asigno una opción no válida para que se encargue el switch de dar error
        }
        switch (operator) {
            case '+':
                add(num1, num2);
                break;
            case '-':
                sustract(num1, num2);
                break;
            // Si el usuario introduce x como operador de multiplicación, lo acepto como válido, aunque le indique que debe introducir *
            case '*':
            case 'x':
                multiply(num1, num2);
                break;
            // Si el usuario introduce : como operador de división, lo acepto como válido, aunque le indique que debe introducir /
            case '/':
            case ':':
                divide(num1, num2);
                break;
            case '%':
                module(num1, num2);
                break;
            default:
                System.out.println("El operador introducido no es válido");
        }
    }
    
    private static void add(double num1, double num2) {
        double result = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + result);
    }
    
    private static void sustract(double num1, double num2) {
        double result = num1 - num2;
        System.out.println(num1 + " - " + num2 + " = " + result);
    }
    
    private static void multiply(double num1, double num2) {
        double result = num1 * num2;
        System.out.println(num1 + " * " + num2 + " = " + result);
    }
    
    private static void divide(double num1, double num2) {
        if (num2 != 0) {
            double result = num1 / num2;
            System.out.println(num1 + " / " + num2 + " = " + result);
        } else {
            System.out.println("No se puede dividir entre 0");
        }
    }
    
    private static void module(double num1, double num2) {
        if (num2 != 0) {
            double result = num1 % num2;
            System.out.println(num1 + " % " + num2 + " = " + result);
        } else {
            System.out.println("No se puede dividir entre 0");
        }
    }
}
