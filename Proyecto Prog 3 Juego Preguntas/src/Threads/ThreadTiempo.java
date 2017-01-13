package Threads;


import javax.swing.ImageIcon;
import javax.swing.JFrame;

import TiposDeDatos.Pregunta;
import Ventanas.VentanaPregunta;
import Ventanas.VentanaSolucion;

public class ThreadTiempo extends Thread{
	
	private long miliSegundos;
	private JFrame ventana;
	private Pregunta p;
	
	/**
	 * Constructor del hilo del tiempo. 
	 * @param miliSegundos - Le pasamos los milisegundos que va a durar.
	 * @param ventana - Le pasamos la ventana que deberá cerrar cuando termine. 
	 * @param p - Le pasamos un obeto pregunta que deberá pasar a la siguiente ventana. 
	 */
	public ThreadTiempo(long miliSegundos, JFrame ventana, Pregunta p){
		super();
		this.miliSegundos = miliSegundos;
		this.ventana=ventana;
		this.p=p;
	}
	
	/**
	 * Método que hace que la barra de tiempo descienda, y cuando llega al final hace que hayas perdido la pregunta no puediendo contestar.
	 */
	public void run(){
		
		String aRutas[]={"/Images/Progreso100.png","/Images/Progreso090.png","/Images/Progreso080.png", "/Images/Progreso070.png",
				"/Images/Progreso060.png","/Images/Progreso050.png","/Images/Progreso040.png","/Images/Progreso030.png",
				"/Images/Progreso020.png", "/Images/Progreso010.png", "/Images/Progreso000.png"};
		int i=0;
		long mil = miliSegundos/aRutas.length-1;
		while(miliSegundos>0 && i<aRutas.length){
			
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
				
		}
		
		if(!VentanaPregunta.estado){
			ventana.dispose();
			//ABRIR SIGUEENTE mandando que ha fallado (false) y la pregunta
			VentanaSolucion vs=new VentanaSolucion(false, p);
			vs.setVisible(true);
			
		}
	}

}
