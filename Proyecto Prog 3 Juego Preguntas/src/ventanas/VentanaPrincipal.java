package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BasesDeDatos.BD;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

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
	
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_21;
	private JPanel panel_22;

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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/images/logoCuadrado125.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		//panel_norte = new JPanel();
		//frame.getContentPane().add(panel_norte, BorderLayout.NORTH);
		
		ImagenPanel imagenLogo= new ImagenPanel("/images/AppLogo768x68.png");
		frame.getContentPane().add(imagenLogo, BorderLayout.NORTH);
		//imagenLogo.setSize(new Dimension(3000, 3000));
		//imagenLogo.setBounds(imagenLogo.getX(), imagenLogo.getY(), imagenLogo.getWidth(), imagenLogo.getHeight());
		
		panel_sur = new JPanel();
		frame.getContentPane().add(panel_sur, BorderLayout.SOUTH);
		
		panel = new JPanel();
		panel_sur.add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		panel_11 = new JPanel();
		panel.add(panel_11);
		
		btnJugar = new JButton("Jugar");
		panel_11.add(btnJugar);
		
		panel_12 = new JPanel();
		panel.add(panel_12);
		
		btnSalir = new JButton("Salir");
		panel_12.add(btnSalir);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bd.desconectar();
				System.exit(0);
			}
		});
		
		panel_21 = new JPanel();
		panel.add(panel_21);
		
		btnMarcadores = new JButton("Marcadores");
		panel_21.add(btnMarcadores);
		
		panel_22 = new JPanel();
		panel.add(panel_22);
		
		btnInstrucciones = new JButton("Instrucciones");
		panel_22.add(btnInstrucciones);
		btnInstrucciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Instrucciones...", "Instrucciones Q4M:", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
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
		
		btnAdmin = new JButton();
		btnAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaLogin vl = new VentanaLogin();
				vl.setVisible(true);
			}
		});
		//btnAdmin.setBounds(0, 0, 125, 125);
		panel_centro_norte.add(btnAdmin);
	    //Creamos un objeto ImageIcon con el nombre de la imagen
	    ImageIcon face = new ImageIcon(getClass().getResource("/images/admin40_25.png"));
	    //Añadimos la imagen al boton
	    btnAdmin.setIcon(face);
	    //Creamos un objeto ImageIcon con el nombre de la imagen
	    ImageIcon linked = new ImageIcon(getClass().getResource("/images/admin100_25.png"));
	    //Añadimos la imagen al boton, con el metodo setRolloverIcon que hace que la imagen se muestre cuando pasamos el cursor encima del boton
	    btnAdmin.setRolloverIcon(linked);


		//ImageIcon im = new ImageIcon("/images/admin50.png");
		//lblFoto = new JLabel(im);
		//lblFoto.setBounds(10, 11, 154, 172);
		//lblFoto.resize(im.getIconWidth(), im.getIconHeight());
		

	}

}
