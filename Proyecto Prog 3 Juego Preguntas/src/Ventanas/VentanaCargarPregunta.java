package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Threads.ThreadCargarPregunta;
import TiposDeDatos.Jugador;
import TiposDeDatos.Pregunta;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCargarPregunta extends JFrame {

	private JPanel contentPane;
	private JPanel panelNorte,panelSur,panelIzquierda,panelCentro,panelDerecha;
	public static JButton btnJugar;
	private JLabel lblGenerarPregunta;
	private JSeparator separator;
	public static JLabel lblmagenCargar,lblmagenOk;
	private Pregunta pregunta;



	/**
	 * Create the frame.
	 */
	public VentanaCargarPregunta(Pregunta pregunta) {
		this.pregunta=pregunta;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Próxima pregunta");
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblGenerarPregunta = new JLabel("Generando pregunta...");
		panelNorte.add(lblGenerarPregunta);
		
		separator = new JSeparator();
		panelNorte.add(separator);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPregunta vp = new VentanaPregunta(pregunta);
				dispose();
				vp.setVisible(true);
				
			}
		});
		panelSur.add(btnJugar);
		btnJugar.setVisible(false);
				
		
		panelIzquierda = new JPanel();
		contentPane.add(panelIzquierda, BorderLayout.WEST);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		lblmagenCargar = new JLabel();
		lblmagenCargar.setIcon(new ImageIcon(VentanaCargarPregunta.class.getResource("/images/gears125.gif")));
		panelCentro.add(lblmagenCargar);
		
		lblmagenOk = new JLabel();
		lblmagenOk.setHorizontalAlignment(SwingConstants.CENTER);
		lblmagenOk.setIcon(new ImageIcon(VentanaCargarPregunta.class.getResource("/images/ok.gif")));
		panelCentro.add(lblmagenOk);
		lblmagenOk.setVisible(false);
	
		
		panelDerecha = new JPanel();
		contentPane.add(panelDerecha, BorderLayout.EAST);
		
		//crear hilo
		ThreadCargarPregunta hiloBoton = new ThreadCargarPregunta();
		hiloBoton.start();
		
		
	}
	

}
