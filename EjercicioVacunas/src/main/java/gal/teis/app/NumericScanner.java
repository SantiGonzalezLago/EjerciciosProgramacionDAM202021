package gal.teis.app;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <h2>NumericScanner</h2>
 * 
 * Esta clase métodos necesarios para el control de datos al leer números de un Scanner
 * 
 * @author Santiago González Lago
 */
public class NumericScanner {

    private final Scanner sc;

    public NumericScanner(Scanner sc) {
        this.sc = sc;
    }
    
    public byte readByte() {
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
    
    public int readInt() {
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
    
    public double readDouble() {
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
