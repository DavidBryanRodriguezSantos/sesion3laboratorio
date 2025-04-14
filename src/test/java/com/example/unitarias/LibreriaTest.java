// Ejemplo tomado de https://www.arquitecturajava.com/java-mockito-y-los-mock-objects/

package com.example.unitarias;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class LibreriaTest {

    private Libreria libreria;

    @Before
    public void setUp() {
        libreria = new Libreria();
    }

    @Test
    public void testAgregarYVerificarLibro() {
        libreria.agregarLibro("Señor de los Anillos");
        assertEquals(libreria.estaDisponible("Señor de los Anillos"), true);
    }

    @Test
    public void testLibroNoDisponible() {
        assertEquals(libreria.estaDisponible("1984"), false);
    }

    @Test
    public void testLibrosDuplicados() {
        libreria.agregarLibro("El Principito");
        libreria.agregarLibro("El Principito");
        assertEquals(2, libreria.cantidadDeCopias("El Principito"));
    }
}
