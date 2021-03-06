package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Threads.ThreadSolucion;
import Threads.ThreadSonido;
import TiposDeDatos.Partida;
import TiposDeDatos.Pregunta;

import javax.swing.JLabel;
import java.awt.Font;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentanaSolucion extends JFrame {

	private static final long serialVersionUID = -3725562077742297576L;
	private JPanel contentPane;
	public static JLabel lblCorrecto,lblFallo,lblImagCorrecto,lblImagIncorrecto;
	private JPanel panel;
	private JLabel lblPuntos;
	private JLabel lblVida;
	private JButton btnSiguiente;
	private JPanel panel_2;
	private JPanel panel_3;
	private ThreadSolucion hiloParpadear;
	private ThreadSonido hiloSonido;

	/**
	 * Crea la ventana Soluci�n. Recive si ha acertado y la pregunta que se le ha hecho. 
	 * @param acertado - Boleano de si ha acertado la pregunta.
	 * @param preguntaAleatoria - La pregunta que se le ha hecho al jugador. 
	 */
	public VentanaSolucion(boolean acertado, Pregunta preguntaAleatoria) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaSolucion.class.getResource("/Images/logoCuadrado125.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Soluci�n");
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panelNorte.add(panel_1);
		
		lblCorrecto = new JLabel("\u00A1Correcto!");
		panel_1.add(lblCorrecto);
		lblCorrecto.setFont(new Font("Segoe UI Black", Font.ITALIC, 23));
		
		lblFallo = new JLabel("\u00A1Has fallado!");
		panel_1.add(lblFallo);
		lblFallo.setFont(new Font("Segoe UI Black", Font.PLAIN, 23));
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblImagCorrecto = new JLabel("");
		panelCentro.add(lblImagCorrecto);
		lblImagCorrecto.setIcon(new ImageIcon(VentanaSolucion.class.getResource("/Images/correcto125.png")));
		
		lblImagIncorrecto = new JLabel("");
		lblImagIncorrecto.setIcon(new ImageIcon(VentanaSolucion.class.getResource("/Images/incorrecto125.png")));
		panelCentro.add(lblImagIncorrecto);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		
		lblPuntos = new JLabel("+30 Puntos");
		panel_2.add(lblPuntos);
		lblPuntos.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		
		lblVida = new JLabel("-1 Vida");
		panel_2.add(lblVida);
		lblVida.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		
		panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal.logger.log( Level.INFO, "Bot�n Siguiente: Pr�ximo Jugador");
				Partida.siguiente=true;
				//Partida.i++;
				if(hiloParpadear.isAlive()){
					hiloParpadear.stop();
				}
				if(hiloSonido.isAlive()){
					ThreadSonido.sonido.close();
					hiloSonido.stop();
				}
				dispose();
				
			}
		});
		panel_3.add(btnSiguiente);
		
		String nomSonido=null;
		int pos = Partida.aUsuario.indexOf(Partida.jugadorTurno);
		if(acertado){
			lblVida.setVisible(false);
			lblPuntos.setVisible(true);
			lblImagIncorrecto.setVisible(false);
			lblImagCorrecto.setVisible(true);	
			lblFallo.setVisible(false);
			lblCorrecto.setVisible(true);
			nomSonido="src/Sonidos/kultur0407.wav";
			
			//Sumar puntos
			Partida.jugadorTurno.setRecord(30);
			Partida.aUsuario.set(pos, Partida.jugadorTurno);
			VentanaPrincipal.logger.log( Level.INFO,"ACERTADO");
			VentanaPrincipal.logger.log( Level.INFO,"Puntos: +30");
			
		}
		else{
			
			lblVida.setVisible(true);
			lblPuntos.setVisible(false);
			lblImagIncorrecto.setVisible(true);
			lblImagCorrecto.setVisible(false);
			lblFallo.setVisible(true);
			lblCorrecto.setVisible(false);
			nomSonido="src/Sonidos/boo.wav";
			
			//Quitar vida
			
			int num = Partida.aVidas.get(pos).intValue();
			Partida.aVidas.set(pos, new Integer(num-1));
			VentanaPrincipal.logger.log( Level.INFO,"FALLADO");
			VentanaPrincipal.logger.log( Level.INFO,"Vida: -1");
		}
		
		hiloSonido=new ThreadSonido(nomSonido,5000L);
		hiloSonido.start();
		
		//Actualizamos Base de datos con el resultado del jugador.
		VentanaPrincipal.bd.inertarPreguntaContestada(Partida.jugadorTurno,preguntaAleatoria,acertado);
		
		//crear hilo
		hiloParpadear = new ThreadSolucion();
		hiloParpadear.start();
	}

	
}
