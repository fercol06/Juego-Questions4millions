package Threads;

import TiposDeDatos.Pregunta;
import Ventanas.VentanaPregunta;

public class tPregunta extends Thread{
	Pregunta preguntaAleatoria;
	public tPregunta(Pregunta pregunta){
		super();
		this.preguntaAleatoria = pregunta;
	}
	
	public void run(){
		VentanaPregunta vp = new VentanaPregunta(preguntaAleatoria);
	    vp.setVisible(true);
	    notify();
	}

}
