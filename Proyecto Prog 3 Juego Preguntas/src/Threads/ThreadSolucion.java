package Threads;

import java.awt.Color;

import Ventanas.VentanaSolucion;

public class ThreadSolucion extends Thread{
	
	public ThreadSolucion() {
		super();
	}
	
	/**
	 * Método que muestra un texto parpadeante en diferentes colores.
	 */
	public void run(){
		
		while(true){
			VentanaSolucion.lblCorrecto.setForeground(Color.BLACK);
			VentanaSolucion.lblFallo.setForeground(Color.BLACK);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			VentanaSolucion.lblCorrecto.setForeground(Color.GREEN);
			VentanaSolucion.lblFallo.setForeground(Color.RED);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
