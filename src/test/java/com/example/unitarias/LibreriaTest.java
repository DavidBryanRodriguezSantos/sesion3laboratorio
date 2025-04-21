// Ejemplo tomado de https://www.arquitecturajava.com/java-mockito-y-los-mock-objects/

package com.example.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

    @Test
    public void testFlujoCompletoDeLibro() {
        // Agregar dos libros
        libreria.agregarLibro("Cien Años de Soledad");
        libreria.agregarLibro("Cien Años de Soledad");

        // Verificar que hay 2 copias
        assertEquals(2, libreria.cantidadDeCopias("Cien Años de Soledad"));

        // Verificar disponibilidad
        assertTrue(libreria.estaDisponible("Cien Años de Soledad"));

        // Prestar uno
        libreria.prestarLibro("Cien Años de Soledad");

        // Ahora debe haber solo una copia
        assertEquals(1, libreria.cantidadDeCopias("Cien Años de Soledad"));

        // Prestar otra vez
        libreria.prestarLibro("Cien Años de Soledad");

        // Ya no debe estar disponible
        assertFalse(libreria.estaDisponible("Cien Años de Soledad"));
        assertEquals(0, libreria.cantidadDeCopias("Cien Años de Soledad"));
    }
}
