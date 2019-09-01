package main;
import controller.Controller;

public class MVC {
	
	public static void main(String[] args) 
	{
		Controller controler = new Controller();
		controler.run();
	}
	
	
	
	//TODO Recomendaciones generales:
	// Todas las estructuras que se implementan en los talleres y proyectos deben ser genéricas
	// Sean organizados en la estructura del proyecto (No clases sin usar como ControladorLista)
	// Revisen la carga de los datos, creo que están agregando más de los que son.
}
