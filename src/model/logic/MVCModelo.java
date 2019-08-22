package model.logic;

import model.data_structures.listaEnlazada;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.IListaEnlazada;
import model.data_structures.Viaje;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IListaEnlazada datos;

	private int enero=0;
	private int febrero=0;
	private int marzo=0;
	private int abril=0;
	private int mayo=0;
	private int junio=0;

	private Viaje viaje1;
	private boolean valor=true;
	private Viaje ultimo;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo() throws Exception
	{
		CSVReader reader = null;
		CSVReader reader2 = null;
		try {
			reader= new CSVReader(new FileReader("C://users/User/Desktop/Uniandes/Semestre 3/Estructuras de datos/GitHub/Talleres/T1_201920/data/bogota-cadastral-2018-1-All-MonthlyAggregate.csv"));
			String[] comandos = reader.readNext();  //La primera línea no se debe leer
			if(comandos.length!=7||!comandos[0].equals("sourceid")||!comandos[1].equals("dstid")||!comandos[2].equals("month")||!comandos[3].equals("mean_travel_time")||!comandos[4].equals("standard_deviation_travel_time")||!comandos[5].equals("geometric_mean_travel_time")||!comandos[6].equals("geometric_standard_deviation_travel_time"))
				throw new Exception("Los comandos no están organizados de la forma adecuada");
			String[] parte1 = reader.readNext();
			Viaje viaje1 = new Viaje(Integer.parseInt(parte1[0]),Integer.parseInt(parte1[1]),Integer.parseInt(parte1[2]),Double.parseDouble(parte1[3]), Double.parseDouble(parte1[4]),Double.parseDouble(parte1[5]),Double.parseDouble(parte1[6]), null);
			Viaje actual = viaje1;
			for(String[] readNext : reader) {
				Viaje i = new Viaje(Integer.parseInt(readNext[0]),Integer.parseInt(readNext[1]),Integer.parseInt(readNext[2]),Double.parseDouble(readNext[3]),Double.parseDouble(readNext[4]),Double.parseDouble(readNext[5]),Double.parseDouble(readNext[6]), null);
				System.out.println("inicio");
				ultimo = i;
				if(i.darMes()==01)
					enero++;
				else if(i.darMes()==02)
					febrero++;
				else if(i.darMes()==03)
					marzo++;
				else if(i.darMes()==04)
					abril++;
				else if(i.darMes()==05)
					mayo++;
				else if(i.darMes()==06)
					junio++;
				actual.cambiarSiguiente(i);
				actual = actual.darSiguiente();
				System.out.println("final");
			}
			reader2 = new CSVReader(new FileReader("C://Users/User/Desktop/Uniandes/Semestre 3/Estructuras de datos/GitHub/Talleres/T1_201920/data/bogota-cadastral-2018-2-All-MonthlyAggregate.csv"));
			comandos= reader2.readNext();  //La primera línea no se debe leer
			if(comandos.length!=7||!comandos[0].equals("sourceid")||!comandos[1].equals("dstid")||!comandos[2].equals("month")||!comandos[3].equals("mean_travel_time")||!comandos[4].equals("standard_deviation_travel_time")||!comandos[5].equals("geometric_mean_travel_time")||!comandos[6].equals("geometric_standard_deviation_travel_time"))
				throw new Exception("Los comandos no están organizados de la forma adecuada");
			Viaje actual2= ultimo;
			for(String[] readNext : reader) {
				Viaje i = new Viaje(Integer.parseInt(readNext[0]),Integer.parseInt(readNext[1]),Integer.parseInt(readNext[2]),Double.parseDouble(readNext[3]),Double.parseDouble(readNext[4]),Double.parseDouble(readNext[5]),Double.parseDouble(readNext[6]), null);
				System.out.println("segunda");
				ultimo =i;
				if(i.darMes()==01)
					enero++;
				else if(i.darMes()==02)
					febrero++;
				else if(i.darMes()==03)
					marzo++;
				else if(i.darMes()==04)
					abril++;
				else if(i.darMes()==05)
					mayo++;
				else if(i.darMes()==06)
					junio++;
				actual.cambiarSiguiente(i);
				actual = actual.darSiguiente();
				System.out.println("tercera");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			if (reader != null) {
				try {
					reader.close();
					reader2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		datos = new listaEnlazada(viaje1);
		
	}

	/**
	 * Devuelve el primer Viaje almacenado
	 * @return viaje1
	 */
	public Viaje darPrimero()
	{
		return viaje1;
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{

		return enero+ febrero+ marzo+ abril+ mayo+ junio;
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Viaje dato)
	{	
		datos.agregar(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Viaje a buscar
	 * @return Viaje encontrado, null en caso contrario
	 */
	public Viaje buscar(Object dato)
	{
		return (Viaje) datos.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param posición del dato a eliminar
	 */
	public void eliminar(int posicion)
	{
		datos.eliminar(posicion);
	}


}
