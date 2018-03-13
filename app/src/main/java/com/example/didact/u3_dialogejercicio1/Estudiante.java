package com.example.didact.u3_dialogejercicio1;

/**
 * Created by DIDACT on 13/02/2018.
 */

public class Estudiante {
    String nombre;
    int edad;
    String estudios;

    public Estudiante(String nombre, int edad, String estudios) {
        this.nombre = nombre;
        this.edad = edad;
        this.estudios = estudios;
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

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }
}
