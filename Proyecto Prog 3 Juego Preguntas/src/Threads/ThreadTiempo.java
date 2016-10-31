package Threads;

import javax.swing.ImageIcon;

import ventanas.ImagenTiempo;
import ventanas.VentanaPregunta;

public class ThreadTiempo extends Thread{
	
	public long miliSegundos;
	
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
