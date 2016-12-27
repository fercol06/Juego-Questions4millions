package Threads;

import TiposDeDatos.Pregunta;
import Ventanas.VentanaPregunta;
import Ventanas.VentanaSolucion;

public class Solucion extends Thread{
	Pregunta pregunta;
	boolean respuesta;
	public Solucion(Pregunta pregunta, boolean respuesta){
		super();
		this.pregunta = pregunta;
		this.respuesta=respuesta;
	}
	
	public void run(){
		VentanaSolucion vs = new VentanaSolucion(respuesta,pregunta);
		vs.setVisible(true);
		notify();
	}

}
