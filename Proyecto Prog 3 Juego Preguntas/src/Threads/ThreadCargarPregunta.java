package Threads;

import ventanas.VentanaCaragarPregunta;

public class ThreadCargarPregunta extends Thread{
	
	public ThreadCargarPregunta() {
		super();
	}
	
	public void run(){
		
		try {
			Thread.sleep(1500);
			VentanaCaragarPregunta.lblmagenCargar.setVisible(false);
			Thread.sleep(100);
			VentanaCaragarPregunta.btnJugar.setVisible(true);
			VentanaCaragarPregunta.lblmagenOk.setVisible(true);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
