package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BasesDeDatos.BD;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

public class VentanaPrincipal {

	private JFrame frame;
	private JPanel panel_norte,panel_sur,panel_centro,panel_derecha,panel_izquierda;
	private JPanel panel;
	private JButton btnInstrucciones;
	private JButton btnMarcadores;
	private JButton btnJugar;
	private JButton btnSalir;
	
	private JPanel panel_centro_norte;
	private JButton btnAdmin;
	
	//Una unica conexión
	public static BD bd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		bd = new BD();
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
		
		panel_norte = new JPanel();
		frame.getContentPane().add(panel_norte, BorderLayout.NORTH);
		
		panel_sur = new JPanel();
		frame.getContentPane().add(panel_sur, BorderLayout.SOUTH);
		
		panel = new JPanel();
		panel_sur.add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		btnJugar = new JButton("Jugar");
		panel.add(btnJugar);
		
		btnInstrucciones = new JButton("Instrucciones");
		btnInstrucciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Instrucciones...", "Instrucciones Q4M:", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panel.add(btnInstrucciones);
		
		btnMarcadores = new JButton("Marcadores");
		panel.add(btnMarcadores);
		
		btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bd.desconectar();
				System.exit(0);
			}
		});
		panel.add(btnSalir);
		
		panel_izquierda = new JPanel();
		frame.getContentPane().add(panel_izquierda, BorderLayout.WEST);
		
		panel_derecha = new JPanel();
		frame.getContentPane().add(panel_derecha, BorderLayout.EAST);
		
		panel_centro = new JPanel();
		frame.getContentPane().add(panel_centro, BorderLayout.CENTER);
		panel_centro.setLayout(new BorderLayout(0, 0));
		
		panel_centro_norte = new JPanel();
		panel_centro.add(panel_centro_norte, BorderLayout.NORTH);
		panel_centro_norte.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnAdmin = new JButton("Admin");
		panel_centro_norte.add(btnAdmin);

	}

}
