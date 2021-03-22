package gal.teis.model;

public class Trabajador {

    public static final byte ANT_NOVATO = 0;
    public static final byte ANT_MADURO = 1;
    public static final byte ANT_EXPERTO = 2;
    
    private static final double SUELDO_BASE = 1200.0;
    private static final double BONUS_NOVATO = 150.0;
    private static final double BONUS_MADURO = 300.0;
    private static final double BONUS_EXPERTO = 600.0;

    private String nombre;
    private int edad;
    private byte antiguedad;

    public Trabajador(String nombre, int edad, byte antiguedad) {
        if (!checkAntiguedad(antiguedad)) {
            throw new IllegalArgumentException("Antigüedad errónea");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public byte getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(byte antiguedad) {
        if (!checkAntiguedad(antiguedad)) {
            throw new IllegalArgumentException("Antigüedad errónea");
        }
        this.antiguedad = antiguedad;
    }

    public double calcularSueldo() {
        double sueldoTotal = SUELDO_BASE;
        switch (antiguedad) {
            case ANT_NOVATO:
                sueldoTotal += BONUS_NOVATO;
                break;
            case ANT_MADURO:
                sueldoTotal += BONUS_MADURO;
                break;
            case ANT_EXPERTO:
                sueldoTotal += BONUS_EXPERTO;
                break;
        }
        return sueldoTotal;
    }

    public static boolean checkAntiguedad(byte antiguedad) {
        return antiguedad == ANT_NOVATO || antiguedad == ANT_MADURO || antiguedad == ANT_EXPERTO;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(nombre);
        output.append(", edad: ");
        output.append(edad);
        output.append(", antigüedad: ");
        switch(antiguedad) {
            case ANT_NOVATO:
                output.append("novato.");
                break;
            case ANT_MADURO:
                output.append("maduro.");
                break;
            case ANT_EXPERTO:
                output.append("experto.");
                break;
        }
        return output.toString();
    }
}
