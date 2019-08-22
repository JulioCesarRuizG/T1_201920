package test.logic;

import static org.junit.Assert.*;
import model.logic.MVCModelo;

import org.junit.Before;
import org.junit.Test;

public class TestMVCModelo {

	private MVCModelo modelo;

	@Before
	public void setUp1() throws Exception {
		try
		{
		modelo= new MVCModelo();
		}
		catch (Exception e) {
			fail("Error al cargar los archivos");
		}
	}

	@Test
	public void testDarTamano() {
		try
		{
		assertEquals(2097148, modelo.darTamano());
		}
		catch (Exception e) {
			fail("No se ha cargado el archivo correctamente");
		}
	}

	@Test
	public void testAgregar() {
		// TODO Completar la prueba

	}

	@Test
	public void testBuscar() {
		setUp2();
		// TODO Completar la prueba
	}

	@Test
	public void testEliminar() {
		setUp2();
		// TODO Completar la prueba

	}

}
