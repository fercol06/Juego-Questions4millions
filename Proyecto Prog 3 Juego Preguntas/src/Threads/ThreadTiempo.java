package Threads;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Ventanas.VentanaPregunta;

public class ThreadTiempo extends Thread{
	
	public long miliSegundos;
	public final int numImages=11; 
	
	public ThreadTiempo(long miliSegundos){
		super();
		this.miliSegundos = miliSegundos;
		
	}
	
	public void run(){
		
		String aRutas[]={"/Images/Progreso100.png","/Images/Progreso090.png","/Images/Progreso080.png", "/Images/Progreso070.png",
				"/Images/Progreso060.png","/Images/Progreso050.png","/Images/Progreso040.png","/Images/Progreso030.png",
				"/Images/Progreso020.png", "/Images/Progreso010.png", "/Images/Progreso000.png"};
		int i=0;
		long mil = miliSegundos/aRutas.length-1;
		while(miliSegundos>0 && i<aRutas.length){
			
			
			//VentanaPregunta.panelWest.add(new JLabel(new ImageIcon(aRutas[i])), BorderLayout.WEST);
			VentanaPregunta.lblimg.setIcon(new ImageIcon(VentanaPregunta.class.getResource(aRutas[i])));
			VentanaPregunta.panelWest.add(VentanaPregunta.lblimg);
			VentanaPregunta.panelWest.updateUI();
			
			i++;
			try {
				Thread.sleep(mil);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			miliSegundos-=mil;
			
			/*
			 	lblImg = new JLabel(new ImageIcon(VentanaPregunta.class.getResource("/Images/Progreso100.png")));
				panelWest.add(lblImg);
			 */
		}
	}

}
