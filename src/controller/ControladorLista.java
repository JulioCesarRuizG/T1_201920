package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.Viaje;

public class ControladorLista {

	private Viaje viaje1;
	private static boolean valor=true;
	private static Viaje ultimo;

	public static void main(String[] args) {

		CSVReader reader = null;
		CSVReader reader2 = null;
		try {
			reader= new CSVReader(new FileReader("./data/bogota-cadastral-2018-1-All-MonthlyAggregate.csv"));
			String[] inutil = reader.readNext();  //La primera línea no se debe leer
			String[] parte1 = reader.readNext();
			Viaje viaje1 = new Viaje(Integer.parseInt(parte1[0]),Integer.parseInt(parte1[1]),Integer.parseInt(parte1[2]),Double.parseDouble(parte1[3]), Double.parseDouble(parte1[4]),Double.parseDouble(parte1[5]),Double.parseDouble(parte1[6]), null);
			Viaje actual = viaje1;
			for(String[] nextLine : reader) {
				Viaje i = new Viaje(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]), null);
				ultimo = i;
				actual.darSiguiente();
				actual = actual.darSiguiente();
			}
			reader2 = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-MonthlyAggregate.csv"));
			String[] inutil2 = reader.readNext();  //La primera línea no se debe leer
			Viaje actual2= ultimo;
			for(String[] nextLine : reader) {
				Viaje i = new Viaje(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]), null);
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
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}


	}

}
}
