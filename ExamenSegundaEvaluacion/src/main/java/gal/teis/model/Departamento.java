package gal.teis.model;

import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private Directivo jefe;
    private ArrayList<Trabajador> trabajadores;

    private Departamento(String nombre) {
        this.nombre = nombre;
    }

    public Departamento(String nombre, Directivo jefe) {
        this(nombre);
        this.jefe = jefe;
    }

    public Departamento(String nombre, Directivo jefe, ArrayList<Trabajador> trabajadores) {
        this(nombre, jefe);
        this.trabajadores = trabajadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Directivo getJefe() {
        return jefe;
    }

    public void setJefe(Directivo jefe) {
        this.jefe = jefe;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
 
}