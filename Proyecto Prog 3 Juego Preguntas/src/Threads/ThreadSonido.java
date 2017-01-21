package Threads;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ThreadSonido extends Thread{

	private String nomSonido;
	private long tiempo; 
	public static Clip sonido;
	//public static boolean enEjecucion;
	
	public ThreadSonido(String nomSonido, long tiempo){
		super();
		this.nomSonido=nomSonido;
		this.tiempo=tiempo;
		sonido=null;
	}
	
	public void run(){
		
			
		try {
			sonido= AudioSystem.getClip();
			File a = new File(nomSonido);
			sonido.open(AudioSystem.getAudioInputStream(a));
			
			if(tiempo<6000){
				sonido.start();
			}else{
				sonido.loop(Clip.LOOP_CONTINUOUSLY);
			}
			Thread.sleep(tiempo); 
			sonido.close();
		
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
