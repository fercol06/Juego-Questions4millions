package Threads;

import TiposDeDatos.Pregunta;
import Ventanas.VentanaCargarPregunta;

public class CargarPregunta extends Thread{
	Pregunta preguntaAleatoria;
	public CargarPregunta(Pregunta preguntaAleatoria){
		super();
		this.preguntaAleatoria = preguntaAleatoria;
	}
	
	public void run(){
		VentanaCargarPregunta vcp = new VentanaCargarPregunta(preguntaAleatoria);
		vcp.setVisible(true);
		System.out.println("Pregunta cargada");
		notify();
	}

}
