package Threads;

import ventanas.VentanaCargarPregunta;

public class ThreadCargarPregunta extends Thread{
	
	public ThreadCargarPregunta() {
		super();
	}
	
	public void run(){
		
		try {
			Thread.sleep(1500);
			VentanaCargarPregunta.lblmagenCargar.setVisible(false);
			Thread.sleep(100);
			VentanaCargarPregunta.btnJugar.setVisible(true);
			VentanaCargarPregunta.lblmagenOk.setVisible(true);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
