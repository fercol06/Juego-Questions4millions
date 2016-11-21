package Threads;

import ventanas.VentanaConfiguracion;

public class ThreadCargarPregunta extends Thread{
	
	public ThreadCargarPregunta() {
		super();
	}
	
	public void run(){
		
		try {
			Thread.sleep(1500);
			VentanaConfiguracion.lblmagenCargar.setVisible(false);
			Thread.sleep(100);
			VentanaConfiguracion.btnJugar.setVisible(true);
			VentanaConfiguracion.lblmagenOk.setVisible(true);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
