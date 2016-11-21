package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Threads.ThreadCargarPregunta;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class VentanaConfiguracion extends JFrame {

	private JPanel contentPane;
	private JPanel panelNorte,panelSur,panelIzquierda,panelCentro,panelDerecha;
	public static JButton btnJugar;
	private JLabel lblGenerarPregunta;
	private JSeparator separator;
	public static JLabel lblmagenCargar,lblmagenOk;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConfiguracion frame = new VentanaConfiguracion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaConfiguracion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Proxima pregunta");
		
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
		panelSur.add(btnJugar);
		btnJugar.setVisible(false);
		
		
		
		
		panelIzquierda = new JPanel();
		contentPane.add(panelIzquierda, BorderLayout.WEST);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		lblmagenCargar = new JLabel();
		lblmagenCargar.setIcon(new ImageIcon(VentanaConfiguracion.class.getResource("/images/gears125.gif")));
		panelCentro.add(lblmagenCargar);
		
		lblmagenOk = new JLabel();
		lblmagenOk.setHorizontalAlignment(SwingConstants.CENTER);
		lblmagenOk.setIcon(new ImageIcon(VentanaConfiguracion.class.getResource("/images/ok.gif")));
		panelCentro.add(lblmagenOk);
		lblmagenOk.setVisible(false);
	
		
		panelDerecha = new JPanel();
		contentPane.add(panelDerecha, BorderLayout.EAST);
		
		//crear hilo
		ThreadCargarPregunta hiloBoton = new ThreadCargarPregunta();
		hiloBoton.start();
		
		
	}
	

}
