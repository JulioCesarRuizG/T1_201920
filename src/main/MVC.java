package main;
import controller.ControladorLista;
import controller.Controller;

public class MVC {
	
	public static void main(String[] args) throws Exception 
	{
		ControladorLista controler = new ControladorLista();
		controler.run();
	}
}
