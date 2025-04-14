// Ejemplo tomado de https://www.arquitecturajava.com/java-mockito-y-los-mock-objects/

package com.example.unitarias;

import java.util.ArrayList;
import java.util.List;

public class Libreria {

    private final List<String> libros;

    public Libreria() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(String libro) {
        libros.add(libro);
    }

    public boolean estaDisponible(String libro) {
        return libros.contains(libro);
    }

    public int cantidadDeCopias(String libro) {
        int count = 0;
        for (String l : libros) {
            if (l.equals(libro)) count++;
        }
        return count;
    }
}
