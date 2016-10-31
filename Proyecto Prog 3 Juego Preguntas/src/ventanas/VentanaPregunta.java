package ventanas;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import Threads.ThreadTiempo;

import java.awt.FlowLayout;
import java.awt.GridLayout;

public class VentanaPregunta extends JFrame{

	private JFrame frame;
	private JPanel panel_norte,panel_sur,panel_centro,panel_derecho;
	private JPanel panel, panel_11,panel_12,panel_21,panel_22;
	private JButton btnRespuesta1, btnRespuesta2, btnRespuesta3, btnRespuesta4;
	private JLabel lblPregunta, lblUsuario;
	private JPanel panel_Iniciar;


	  
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPregunta window = new VentanaPregunta();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPregunta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Atenci\u00F3n, \u00A1pregunta!");
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel_Iniciar = new JPanel();
		getContentPane().add(panel_Iniciar, BorderLayout.CENTER);
		panel_Iniciar.setLayout(new BorderLayout(0, 0));
		
		
		
		panel_norte = new JPanel();
		panel_Iniciar.add(panel_norte, BorderLayout.NORTH);
		
		lblUsuario = new JLabel("Turno para: ");
		panel_norte.add(lblUsuario);
		
	
		panel_derecho = new JPanel();
		panel_Iniciar.add(panel_derecho, BorderLayout.EAST);
		
		/*
		ThreadTiempo ttiempo = new ThreadTiempo();
		ttiempo.start();
		*/
		
		ImagenTiempo imagenTiempo= new ImagenTiempo("/images/Progreso100.png");
		panel_Iniciar.add(imagenTiempo, BorderLayout.WEST);
		
		
		
		panel_centro = new JPanel();
		panel_Iniciar.add(panel_centro, BorderLayout.CENTER);
		
		lblPregunta = new JLabel("Pregunta");
		panel_centro.add(lblPregunta);
		
		panel_sur = new JPanel();
		panel_Iniciar.add(panel_sur, BorderLayout.SOUTH);
		panel_sur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel = new JPanel();
		panel_sur.add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		panel_11 = new JPanel();
		panel.add(panel_11);
		
		btnRespuesta1 = new JButton("Respuesta 1");
		panel_11.add(btnRespuesta1);
		
		panel_12 = new JPanel();
		panel.add(panel_12);
		
		btnRespuesta2 = new JButton("Respuesta 2");
		panel_12.add(btnRespuesta2);
		
		panel_21 = new JPanel();
		panel.add(panel_21);
		
		btnRespuesta3 = new JButton("Respuesta 3");
		panel_21.add(btnRespuesta3);
		
		panel_22 = new JPanel();
		panel.add(panel_22);
		
		btnRespuesta4 = new JButton("Respuesta 4");
		panel_22.add(btnRespuesta4);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setTitle("Questions4millions");
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}

}
