package gal.teis.model;

public class Empleado extends Trabajador {

    private static final double BONUS = 350.0;
    
    private static int contador;
    
    private double irpf;

    public Empleado(String nombre, int edad) {
        this(nombre, edad, Trabajador.ANT_NOVATO);
        // La clase padre no tiene un constructor sin antigüedad, así que le
        // pongo novato por defecto
    }
    
    public Empleado(String nombre, int edad, byte antiguedad) {
        super(nombre, edad, antiguedad);
        contador++;
    }

    public Empleado(String nombre, int edad, byte antiguedad, double irpf) {
        super(nombre, edad, antiguedad);
        if (!checkIrpf(irpf)) {
            throw new IllegalArgumentException("IRPF fuera del rango válido");
        }
        this.irpf = irpf;
        contador++;
        // Aquí no llamo a this porque causaría que el contador aumentase aunque
        // saltase una excepción por IRPF erróneo
    }

    public double getIrpf() {
        return irpf;
    }

    public void setIrpf(double irpf) {
        if (!checkIrpf(irpf)) {
            throw new IllegalArgumentException("IRPF fuera del rango válido");
        }
        this.irpf = irpf;
    }

    public static int getContador() {
        return contador;
    }
    
    @Override
    public double calcularSueldo() {
        return super.calcularSueldo() + BONUS;
    }
    
    public double mostrarRetencion() {
        return calcularSueldo() * irpf / 100.0;
    }

    public double mostrarSalarioLiquido()  {
        return calcularSueldo() - mostrarRetencion();
    }
    
    // Compruebo que el IRPF este entre 0 y 100.
    private boolean checkIrpf(double irpf) {
        return irpf >= 0.0 && irpf <= 100.0;
    }
}
