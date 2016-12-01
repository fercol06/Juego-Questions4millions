package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Threads.ThreadCargarPregunta;
import Threads.ThreadSolucion;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class VentanaSolucion extends JFrame {

	private JPanel contentPane;
	public static JLabel lblCorrecto,lblFallo,lblImagCorrecto,lblImagIncorrecto;
	private JPanel panel;
	private JLabel lblPuntos;
	private JLabel lblVida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSolucion frame = new VentanaSolucion();
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
	public VentanaSolucion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Solución");
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panelNorte.add(panel_1);
		
		lblCorrecto = new JLabel("\u00A1Correcto!");
		panel_1.add(lblCorrecto);
		lblCorrecto.setFont(new Font("Segoe UI Black", Font.ITALIC, 24));
		
		lblFallo = new JLabel("\u00A1Has fallado!");
		panel_1.add(lblFallo);
		lblFallo.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblImagCorrecto = new JLabel("");
		panelCentro.add(lblImagCorrecto);
		lblImagCorrecto.setIcon(new ImageIcon(VentanaSolucion.class.getResource("/images/correcto.png")));
		
		lblImagIncorrecto = new JLabel("");
		lblImagIncorrecto.setIcon(new ImageIcon(VentanaSolucion.class.getResource("/images/incorrecto.png")));
		panelCentro.add(lblImagIncorrecto);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		lblPuntos = new JLabel("+30 Puntos");
		lblPuntos.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		panel.add(lblPuntos);
		
		lblVida = new JLabel("-1 Vida");
		lblVida.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		panel.add(lblVida);
		
		
		//crear hilo
		ThreadSolucion hiloParpadear = new ThreadSolucion();
		hiloParpadear.start();
	}

}
