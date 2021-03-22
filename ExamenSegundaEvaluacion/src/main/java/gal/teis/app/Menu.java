package gal.teis.app;

import gal.teis.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static Scanner sc;
    private static ScannerNumericos scNum;

    private static final String[] OPCIONES = {
        "Crear Empleados", // 1
        "Crear Directivos", // 2
        "Ver el número de trabajadores total que se han creado", // 3
        "Ver datos personales de los empleados (nombre, edad, antiguedad)", // 4
        "Listar el salario líquido y la parte del salario retenida por el "
        + "IRPF de todos los empleados", // 5
        "Salir" // 6
    };
    
    private static List<Trabajador> listaTrabajadores;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        scNum = new ScannerNumericos(sc);
        listaTrabajadores = new ArrayList<>();

        System.out.println("Bienvenido a la aplicación de gestión de empleados");
        while (menu()) {
            // menu() devuelve un boolean
            // menu() == true, se entra en el bucle
            // menu() == false, se termina el bucle sin entrar
            System.out.println("Pulsa Enter para continuar");
            sc.nextLine();
        }
        System.out.println("Hasta la próxima");
    }

    private static boolean menu() {
        boolean repetirMenu = true;

        System.out.println("Elija una opción:");
        for (int i = 0; i < OPCIONES.length; i++) {
            System.out.println((i + 1) + ". " + OPCIONES[i]);
        }

        switch (leerOpcion()) {
            case 1:
                crearTrabajador('E');
                break;
            case 2:
                crearTrabajador('D');
                break;
            case 3:
                verNumeroTrabajadores();
                break;
            case 4:
                verDatosPersonalesEmpleados();
                break;
            case 5:
                listarSalarioLiquidoYRetencion();
                break;
            case 6:
                repetirMenu = false;
        }

        return repetirMenu;
    }

    private static byte leerOpcion() {
        boolean error;
        byte opcion = 0;

        do {
            error = false;
            opcion = scNum.leerByte();
            if (opcion <= 0 || opcion > OPCIONES.length) {
                System.out.println("Debe introducir un valor entre 1 y " + OPCIONES.length);
                error = true;
            }
        } while (error);

        return opcion;
    }

    private static void crearTrabajador(char tipo) {
        System.out.print("Creando un ");
        switch (tipo) {
            case 'E':
                System.out.println("empleado.");
                break;
            case 'D':
                System.out.println("directivo.");
                break;
        }

        System.out.println("Introduzca el nombre:");
        String nombre = sc.nextLine();
        System.out.println("Introduzca la edad:");
        int edad = scNum.leerInt();
        System.out.println("Introduzca la antigüedad (0 - Novato, 1 - Maduro, 2 - Experto):");
        byte antiguedad = introducirAntiguedad();
        System.out.println("Introduzca el IRPF (en %):");
        double irpf = introducirIrpf();
        
        switch(tipo) {
            case 'E':
                listaTrabajadores.add(new Empleado(nombre, edad, antiguedad, irpf));
                break;
            case 'D':
                listaTrabajadores.add(new Directivo(nombre, edad, antiguedad, irpf));
                break;
        }
    }

    private static byte introducirAntiguedad() {
        boolean error;
        byte anti = 0;

        do {
            error = false;
            anti = scNum.leerByte();
            if (!Trabajador.checkAntiguedad(anti)) {
                System.out.println("Valor no válido");
                error = true;
            }
        } while (error);

        return anti;
    }

    private static double introducirIrpf() {
        boolean error;
        double irpf = 0;

        do {
            error = false;
            irpf = scNum.leerDouble();
            if (irpf < 0 || irpf > 100) {
                System.out.println("Debe introducir un valor entre 0 y 100");
                error = true;
            }
        } while (error);

        return irpf;
    }

    private static void verNumeroTrabajadores() {
        int numTrabajadores = listaTrabajadores.size();
        switch (numTrabajadores) {
            case 0:
                System.out.println("No se ha creado ningún trabajador.");
                break;
            case 1:
                System.out.println("Se ha creado un total de 1 trabajador.");
                break;
            default:
                System.out.println("Se han creado un total de " + numTrabajadores + " trabajadores.");
        }
    }

    private static void verDatosPersonalesEmpleados() {
        boolean hayEmpleados = false;
        for (Trabajador t : listaTrabajadores) {
            if (t instanceof Empleado) {
                System.out.println(t);
                hayEmpleados = true;
            }
        }
        if (!hayEmpleados) {
            System.out.println("No hay ningún empleado");
        }
    }

    private static void listarSalarioLiquidoYRetencion() {
        boolean hayEmpleados = false;
        for (Trabajador t : listaTrabajadores) {
            if (t instanceof Empleado) {
                Empleado e = (Empleado) t;
                StringBuilder output = new StringBuilder();
                output.append(e.getNombre());
                output.append(", salario líquido: ");
                // Formateo el salario líquido y la retención a 2 decimales
                output.append(String.format("%.2f€", e.mostrarSalarioLiquido()));
                output.append(", retención: ");
                output.append(String.format("%.2f€", e.mostrarRetencion()));
                System.out.println(output);
                hayEmpleados = true;
            }
        }
        if (!hayEmpleados) {
            System.out.println("No hay ningún empleado");
        }
    }
}
