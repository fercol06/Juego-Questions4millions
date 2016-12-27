package Threads;

import javax.swing.ImageIcon;

import Ventanas.ImagenPanel;
import Ventanas.VentanaPregunta;

public class ThreadTiempo extends Thread{
	
	public long miliSegundos;
	public final int numImages=11; 
	
	public ThreadTiempo(long miliSegundos){
		super();
		this.miliSegundos = miliSegundos;
		
	}
	
	public void run(){
		
		String aRutas[]={"/images/Progreso100.png","/images/Progreso090.png","/images/Progreso080.png", "/images/Progreso070.png",
				"/images/Progreso060.png","/images/Progreso050.png","/images/Progreso040.png","/images/Progreso030.png",
				"/images/Progreso020.png", "/images/Progreso010.png", "/images/Progreso000.png"};
		int i=0;
		
		while(true){
			ImagenPanel im = new ImagenPanel(aRutas[i]);
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
