package test.data_structures;

import model.data_structures.Viaje;
import model.data_structures.listaEnlazada;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class listEnlazadaTest {

	private Viaje quinto = new Viaje(100, 101, 102, 103, 104, 105, 106, null);
	private Viaje cuarto = new Viaje(22,23,24,25,26,27,28, null);
	private Viaje tercero = new Viaje(15,16,17,18,19,20,21, cuarto);
	private Viaje segundo = new Viaje(8,9,10,11,12,13,14, tercero);
	private Viaje primero = new Viaje(1,2,3,4,5,6,7, segundo);

	private listaEnlazada lista;

	@Before
	public void setupEscenario1()
	{
		try
		{
			lista = new listaEnlazada(primero);
		}
		catch(Exception e)
		{
			fail( "No se debería generar el error " + e.getMessage( ) + "." );
		}
	}
	@Test
	public void testAgregar()
	{
		try
		{
			lista.agregar(quinto);
			assertEquals(quinto, lista.darPrimero().darSiguiente().darSiguiente().darSiguiente().darSiguiente());
		}
		catch(Exception e)
		{
			fail("El último elmento debería ser el quinto");
		}
	}
	@Test
	public void testDarTamano()
	{
		try
		{
			assertEquals(4, lista.darTamano());
		}
		catch (Exception e) {
			fail("El tamaño debía ser de 4 elementos");
		}
	}
	@Test
	public void testDarElemento()
	{
		try
		{
			assertEquals(primero, lista.darElemento(1));
			assertEquals(tercero, lista.darElemento(3));
			assertEquals(segundo, lista.darElemento(2));
		}
		catch (Exception e) {
			fail("Los elementos buscados no son los esperados");
		}
	}
	@Test
	public void testBuscarObjeto()
	{
		try
		{
			assertEquals(primero, lista.buscar(primero));
			assertEquals(segundo, lista.buscar(segundo));
			assertEquals(tercero, lista.buscar(tercero));
		}
		catch (Exception e) {
			fail("La búsqueda de elementos ha fallado");
		}
	}
	@Test
	public void testEliminar()
	{
		try
		{
			lista.eliminar(2);
			assertEquals(tercero, primero.darSiguiente());
			lista.eliminar(2);
			assertEquals(cuarto, primero.darSiguiente());
		}
		catch (Exception e) {
			fail("No se han eliminado correctamente los viajes");
		}
	}
	@Test
	public void testAvanzarUnNodo()
	{
		try
		{
			lista.avanzarUnNodo();
			assertEquals(segundo, lista.darActual());
			lista.avanzarUnNodo();
			assertEquals(tercero, lista.darActual());
		}
		catch (Exception e) {
			fail("El avance no ocurrió correctamente");
		}
	}
	@Test
	public void testRetrocederUnNodo()
	{
		try
		{
			lista.retrocederUnNodo();
			assertEquals(segundo, lista.darActual());
			lista.retrocederUnNodo();
			assertEquals(primero, lista.darActual());
		}
		catch (Exception e) {
			fail("El retroceso no ocurrió correctamente");
		}
	}
	@Test
	public void testIniciarRecorrido()
	{
		//falta implementar
	}


}
