package Threads;

import java.awt.Color;

import Ventanas.VentanaSolucion;

public class ThreadSolucion extends Thread{
	
	public ThreadSolucion() {
		super();
	}
	
	public void run(){
		
		while(true){
			VentanaSolucion.lblCorrecto.setForeground(Color.BLACK);
			VentanaSolucion.lblFallo.setForeground(Color.BLACK);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			VentanaSolucion.lblCorrecto.setForeground(Color.GREEN);
			VentanaSolucion.lblFallo.setForeground(Color.RED);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
