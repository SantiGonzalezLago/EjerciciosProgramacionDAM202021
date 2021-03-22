package gal.teis.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerNumericos {

    private final Scanner sc;

    public ScannerNumericos(Scanner sc) {
        this.sc = sc;
    }
    
    public byte leerByte() {
        boolean error;
        byte input = 0;

        do {
            error = false;
            try {
                input = sc.nextByte();
            } catch (InputMismatchException ex) {
                System.out.println("Debe introducir un número entero");
                error = true;
            } finally {
                sc.nextLine();
            }
        } while (error);

        return input;
    }
    
    public int leerInt() {
        boolean error;
        int input = 0;

        do {
            error = false;
            try {
                input = sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Debe introducir un número entero");
                error = true;
            } finally {
                sc.nextLine();
            }
        } while (error);

        return input;
    }
    
    public double leerDouble() {
        boolean error;
        double input = 0;

        do {
            error = false;
            try {
                input = sc.nextDouble();
            } catch (InputMismatchException ex) {
                System.out.println("Debe introducir un número");
                error = true;
            } finally {
                sc.nextLine();
            }
        } while (error);

        return input;
    }
    
}
