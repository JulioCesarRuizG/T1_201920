package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.IListaEnlazada;
import model.data_structures.Viaje;
import model.data_structures.listaEnlazada;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IListaEnlazada datos;
	private Viaje viaje1;
	private  boolean valor=true;
	private  Viaje ultimo;
	private int enero=0;
	private int febrero=0;
	private int marzo=0;
	private int abril=0;
	private int mayo=0;
	private int junio=0;
	private int sMes;
	private int sID;
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo ()throws Exception
	{
		CSVReader reader = null;
		CSVReader reader2 = null;
		
		try {
			reader= new CSVReader(new FileReader("./data/bogota-cadastral-2018-1-All-MonthlyAggregate.csv"));
			String[] comandos = reader.readNext();  //La primera línea no se debe leer
			if(comandos.length!=7||!comandos[0].equals("sourceid")||!comandos[1].equals("dstid")||!comandos[2].equals("month")||!comandos[3].equals("mean_travel_time")||!comandos[4].equals("standard_deviation_travel_time")||!comandos[5].equals("geometric_mean_travel_time")||!comandos[6].equals("geometric_standard_deviation_travel_time"))
throw new Exception("Los comandos no están organizados de la forma adecuada");
			String[] parte1 = reader.readNext();
			Viaje viaje1 = new Viaje(Integer.parseInt(parte1[0]),Integer.parseInt(parte1[1]),Integer.parseInt(parte1[2]),Double.parseDouble(parte1[3]), Double.parseDouble(parte1[4]),Double.parseDouble(parte1[5]),Double.parseDouble(parte1[6]), null);
			Viaje actual = viaje1;
			for(String[] nextLine : reader) {
				Viaje i = new Viaje(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]), null);
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
				actual.darSiguiente();
				actual = actual.darSiguiente();
			}
			reader2 = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-MonthlyAggregate.csv"));
			comandos= reader2.readNext();  //La primera línea no se debe leer
			if(comandos.length!=7||!comandos[0].equals("sourceid")||!comandos[1].equals("dstid")||!comandos[2].equals("month")||!comandos[3].equals("mean_travel_time")||!comandos[4].equals("standard_deviation_travel_time")||!comandos[5].equals("geometric_mean_travel_time")||!comandos[6].equals("geometric_standard_deviation_travel_time"))
				throw new Exception("Los comandos no están organizados de la forma adecuada");
			Viaje actual2= ultimo;
			for(String[] nextLine : reader) {
				Viaje i = new Viaje(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]), null);
				ultimo=i;
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
				actual.darSiguiente();
				actual = actual.darSiguiente();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			if (reader != null) {
				try {
					reader.close();
					reader2.close();
					datos= new listaEnlazada(viaje1);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */

	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return enero + febrero + marzo+ abril +mayo+junio;
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		datos.agregar(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Viaje buscar(Viaje dato)
	{
		return datos.buscar(dato);
	}
	public void recibirDatosParaFuturosServicios(int mes, int id){
		sMes=mes;
		sID=id;
	}
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Viaje eliminar(Viaje dato)
	{
		return datos.eliminar(dato);
	}


}
