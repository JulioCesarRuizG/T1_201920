package test.logic;

import static org.junit.Assert.*;

import model.data_structures.Viaje;
import model.logic.MVCModelo;

import org.junit.Before;
import org.junit.Test;

public class TestMVCModelo {

	private MVCModelo modelo;
	private Viaje viaje1 = new Viaje(1,2,3,4,5,6,7,null);

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
	public void testDarUltimo()
	{
		try
		{
			Viaje ultimo = new Viaje(710,522,04,2288.59,973.86,2111.46,1.48, null);
			assertEquals(ultimo, modelo.darUltimo());
		}
		catch (Exception e) {
			fail("No se encontró el último correctamente");
		}
	}
	
	@Test
	public void testAgregar() {
		try
		{
			modelo.agregar(viaje1);
			assertEquals(viaje1, modelo.darUltimo());
		}
		catch (Exception e) {
			fail("No se ha agregado correctamente a la lista");
		}

	}

	@Test
	public void testBuscar() {
		try
		{
			Viaje buscar = new Viaje(1114,406,04,1471.89,687.5,1352.89,1.49,null);
			assertEquals(buscar, modelo.buscar(buscar));
		}
		catch (Exception e) {
			fail("No se encontró el Viaje buscado");
		}
	}

	@Test
	public void testEliminar() {
		try
		{
			Viaje eliminado = new Viaje(710,522,04,2288.59,973.86,2111.46,1.48, null);
			modelo.eliminar(2097147);
			assertEquals(null, modelo.buscar(eliminado));
		}
		catch (Exception e) {
			fail("No se eliminó correctamente");
		}

	}

}
