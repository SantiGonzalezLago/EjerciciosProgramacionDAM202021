package gal.teis.application;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase implementa la aplicación Capicúa.
 */
@SuppressWarnings("resource")
public class Capicua {
    public static void capicua(){
        Scanner sc = new Scanner(System.in);
        String number = ""; //Almacena el número como String porque realizaré la comprobación comparando caracteres
        byte index = 0;
        char c1, c2;
        boolean isCapicua = true;
        boolean error;

        System.out.println("Bienvenido a la aplicacion Capicúa.");

        System.out.println("Introduzca un número:");
        do {
            error = false;
            try {
                number = String.valueOf(sc.nextLong());
            } catch (InputMismatchException ex) {
                error = true;
                System.out.println("Ha introducido un valor incorrecto, intentelo de nuevo:");
            } finally {
                sc.nextLine();
            }
        } while (error);

        do {
            c1 = number.charAt(index);
            c2 = number.charAt(number.length() - (index + 1));
            if (c1 != c2) {
                isCapicua = false;
            }
            index++;
        } while (index < number.length()/2 && isCapicua);
        //Solo recorro el array hasta la mitad, porque después estaria repitiendo las mismas comparaciones

        if (isCapicua) {
            System.out.println(number + " es capicúa.");
        } else {
            System.out.println(number + " no es capicúa.");
        }
    }
}
