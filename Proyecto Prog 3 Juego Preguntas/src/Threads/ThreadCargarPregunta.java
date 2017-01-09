package Threads;

import Ventanas.VentanaCargarPregunta;

public class ThreadCargarPregunta extends Thread{
	
	public ThreadCargarPregunta() {
		super();
	}
	
	/**
	 * M�todo que espera 1,5segundos y muestra el bot�n de Jugar
	 */
	public void run(){
		
		try {
			Thread.sleep(1500);
			VentanaCargarPregunta.lblmagenCargar.setVisible(false);
			Thread.sleep(100);
			VentanaCargarPregunta.btnJugar.setVisible(true);
			VentanaCargarPregunta.lblmagenOk.setVisible(true);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
