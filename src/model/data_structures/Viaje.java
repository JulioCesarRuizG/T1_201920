package model.data_structures;

public class Viaje {

	private int inicioID;
	private int destinoID;
	private int mes;
	private double tiempoPromedio;
	private double desviacionEstandar;
	private double tiempoPromedioG;
	private double desviacionEstandarG;
	private Viaje siguiente;

	public Viaje(int pInicioID, int pDestinoID, int pMes, double pTiempoPromedio, double pDesviacionEstandar, double pTiempoPromedioG, double pDesviacionEstandarG, Viaje pSiguiente)
	{
		inicioID = pInicioID;
		destinoID = pDestinoID;
		mes = pMes;
		tiempoPromedio = pTiempoPromedio;
		desviacionEstandar = pDesviacionEstandar;
		tiempoPromedioG = pTiempoPromedioG;
		desviacionEstandarG = pDesviacionEstandarG;
		siguiente = pSiguiente;
	}
	public int darInicioID()
	{
		return inicioID;
	}
	public int darDestinoID()
	{
		return destinoID;
	}
	public int darMes()
	{
		return mes;
	}
	public double darTiempoPromedio()
	{
		return tiempoPromedio;
	}
	public double darDesviacionEstandar()
	{
		return desviacionEstandar;
	}
	public double darTiempoPromedioG()
	{
		return tiempoPromedioG;
	}
	public double darDesviacionEstandarG()
	{
		return desviacionEstandarG;
	}
	public Viaje darSiguiente()
	{
		return siguiente;
	}
	public void cambiarSiguiente(Viaje pViaje)
	{
		siguiente = pViaje;
	}
}