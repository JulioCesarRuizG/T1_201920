package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class listaEnlazada implements IListaEnlazada {
	/**
	 * Primer elemento de la lista enlazada
	 */
	private Viaje primero;
	/**
	 * Nodo actual de la lista
	 */
	private Viaje actual;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public listaEnlazada(Viaje pPrimero)
	{
		primero = pPrimero;
		actual = pPrimero;
		verificarInvariante();
	}

	public Viaje darPrimero()
	{
		return primero;
	}
	public Viaje darActual()
	{
		return actual;
	}

	public void agregar( Object dato )
	{
		Viaje agrego = (Viaje) dato;
		Viaje aqui = primero;
		while(aqui.darSiguiente() != null)
		{
			aqui = aqui.darSiguiente();
		}
		aqui.cambiarSiguiente(agrego);
	}

	public int darTamano() {

		int tamano = 0;
		Viaje aqui = primero;
		while(aqui != null)
		{
			tamano++;
			aqui = aqui.darSiguiente();
		}
		return tamano;
	}

	public Viaje darElemento(int i) {
		i --;
		Viaje aqui = primero;
		while(i != 0)
		{
			aqui = aqui.darSiguiente(); 
			i--;
		}
		return aqui;
	}

	public Viaje buscar(Object dato) {
		Viaje busqueda = (Viaje) dato;
		Viaje aqui = primero;
		while(!busqueda.equals(aqui) && aqui != null)
		{
			aqui = aqui.darSiguiente();
		}
		if(aqui == null)
		{
			return null;
		}
		else
			return (Viaje) dato;
	}

	public void eliminar(int posicion) 
	{
		if(posicion == 1)
		{
			primero = primero.darSiguiente();
		}
		else
		{
			posicion--;
			Viaje aqui = primero;
			while(posicion != 1)
			{
				aqui = aqui.darSiguiente();
				posicion --;
			}
			aqui.cambiarSiguiente(aqui.darSiguiente().darSiguiente());
		}
	}

	public void avanzarUnNodo()
	{
		if(actual.darSiguiente() != null)
		{
			actual = actual.darSiguiente();
		}
	}

	public void retrocederUnNodo()
	{
		if(actual == primero);
		else
		{
			Viaje evitar = actual;
			actual = primero;
			while(actual.darSiguiente() != evitar)
			{
				actual = actual.darSiguiente();
			}
		}
	}

	public Viaje darNodoActual()
	{
		return actual;
	}

	public void iniciarRecorrido()
	{
		falta implementar
	}
	public void verificarInvariante()
	{

	}
}