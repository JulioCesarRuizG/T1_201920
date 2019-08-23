package controller;

import java.util.Scanner;

import model.data_structures.Viaje;
import model.logic.MVCModelo;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;

	private Viaje primero;

	/* Instancia de la Vista*/
	private MVCView view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		try {
			modelo = new MVCModelo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				System.out.println("--------- \n Dar mes y el identificador que serán utilizados en el proximo servicio ");
				int mes = lector.nextInt();
				int id = lector.nextInt();
				modelo.recibirDatosParaFuturosServicios(mes, id); 
				System.out.println("Datos agregados");
				System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
				break;

			case 2:
				System.out.println("--------- \nDar total viajes del semestre: ");


				System.out.println(modelo.darTamano() + "\n---------");						
				break;

			case 3:
				System.out.println("--------- \nDar indice del viaje a buscar: ");
				dato = lector.next();
				Viaje buscado = modelo.buscar(Integer.parseInt(dato));
				if ( buscado != null)
				{
					System.out.println("Dato encontrado: "+ respuesta);
				}
				else
				{
					System.out.println("Dato NO encontrado");
				}
				System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
				break;

			case 4:
				System.out.println("--------- \nDar indice del viaje a eliminar: ");
				dato = lector.next();
				Viaje resultado =modelo.eliminar(Integer.parseInt(dato));
				if(resultado!=null)
					System.out.println("--------- \nEl viaje fue eliminado ");
				else
					System.out.println("--------- \n No se pudo eliminar el viaje ");
				System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
				break;

			case 5: 
				System.out.println("--------- \nContenido del Arreglo: ");
				view.printModelo(modelo);
				System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
				break;	

			case 6: 
				System.out.println("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
