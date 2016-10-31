package Threads;

import javax.swing.ImageIcon;

import ventanas.ImagenTiempo;
import ventanas.VentanaPregunta;

public class ThreadTiempo extends Thread{
	
	public long miliSegundos;
	
	public ThreadTiempo(){
		super();
		this.miliSegundos = miliSegundos;
	}
	
	public void run(){
		
		String aRutas[]={"/images/Progreso100.png","/images/Progreso90.png","/images/Progreso80.png", "/images/Progreso70.png",
				"/images/Progreso60.png","/images/Progreso50.png","/images/Progreso40.png","/images/Progreso30.png",
				"/images/Progreso20.png", "/images/Progreso10.png", "/images/Progreso0.png"};
		int i=0;
		
		while(true){
			ImagenTiempo im = new ImagenTiempo(aRutas[i]);
			//imagenTiempo.setIcon(imagenTiempos); 
			i++;
			if(i==aRutas.length){
				i=0;
			}
			try {
				Thread.sleep(miliSegundos);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
