package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BasesDeDatos.BD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.*;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frame;
	private JPanel panel_norte, panel_sur, panel_centro, panel_derecha, panel_izquierda;
	private JPanel panel;
	private JButton btnInstrucciones;
	private JButton btnMarcadores;
	private JButton btnJugar;
	private JButton btnSalir;

	private JPanel panel_centro_norte;
	private JButton btnAdmin;

	// Una unica conexión
	public static BD bd;

	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_21;
	private JPanel panel_22;

	protected static boolean numVentanasLogin = false; // false no se ha creado
														// ventana login
	protected static boolean numVentanasMarcadores = false;
	private JPanel panel_1;
	
	// Obtener un logger
	private static Logger logger = Logger.getLogger( "Q4M" );

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				logger.setLevel( Level.ALL );
				try {
					/*Logs*/
					Handler h = new StreamHandler( System.out, new SimpleFormatter() );
					h.setLevel( Level.FINEST );
					logger.addHandler( h );  // Saca todos los errores a out
					logger.addHandler( new FileHandler( "Q4M.log.xml") );
					logger.log( Level.INFO, "Inicio Q4M");
					/*Logs*/
					
					VentanaPrincipal window = new VentanaPrincipal();
					
					/*Me salta error si no hay tabla. */
					if(VentanaPrincipal.bd.hayAdmin()){
						//hay admin
						logger.log( Level.INFO, "Hay Admin");
						window.frame.setVisible(true);
					}else{
						//no admin
						logger.log( Level.INFO, "No hay Admin");
						VentanaPrincipal.bd.BorrarTablas();
						VentanaPrincipal.bd.crearTablas();
						VentanaLogin vl= new VentanaLogin(false);
					}
				} catch (Exception e) {
					//e.printStackTrace();
					logger.log( Level.SEVERE, e.toString(), e );
				}
			}
		});
	}

	public JFrame getWindow(){
		return frame;
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
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaPrincipal.class.getResource("/images/logoCuadrado125.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setTitle("Questions4Millions!");

		// imagenLogo.setSize(new Dimension(3000, 3000));
		// imagenLogo.setBounds(imagenLogo.getX(), imagenLogo.getY(),
		// imagenLogo.getWidth(), imagenLogo.getHeight());

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

		btnMarcadores = new JButton("Marcadores");
		panel_12.add(btnMarcadores);
		btnMarcadores.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				logger.log( Level.INFO, "Botón Marcadores");
				if (!numVentanasMarcadores) { // comprobar que solo crea 1
												// ventana.
					numVentanasMarcadores = true;
					VentanaMarcadores vl = new VentanaMarcadores();
					vl.setVisible(true);
				}

			}
		});

		panel_21 = new JPanel();
		panel.add(panel_21);

		btnInstrucciones = new JButton("Instrucciones");
		panel_21.add(btnInstrucciones);
		btnInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.log( Level.INFO, "Botón Instrucciones");
				JOptionPane.showMessageDialog(null,
						"Bienvenido a Questions4Millions!\n"
								+ "Q4M es un juego de preguntas y respuestas donde deberás contestar"
								+ "a todas las preguntas dentro de un límite de tiempo "
								+ "mientras se incrementa la dificultad de estas.\n"
								+ "Tu objetivo será contestár más preguntas que tus rivales y llevarte el gran premio.\n"
								+ "Mucha suerte!",
						"Instrucciones Q4M:", JOptionPane.DEFAULT_OPTION);
			}
		});

		panel_22 = new JPanel();
		panel.add(panel_22);

		btnSalir = new JButton("Salir");
		panel_22.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.log( Level.INFO, "Botón Salir");
				bd.desconectar();
				System.exit(0);
			}
		});

		panel_izquierda = new JPanel();
		frame.getContentPane().add(panel_izquierda, BorderLayout.WEST);

		panel_derecha = new JPanel();
		frame.getContentPane().add(panel_derecha, BorderLayout.EAST);

		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);

		panel_centro = new JPanel();
		frame.getContentPane().add(panel_centro, BorderLayout.CENTER);
		panel_centro.setLayout(new BorderLayout(0, 0));

		panel_centro_norte = new JPanel();
		panel_centro.add(panel_centro_norte, BorderLayout.NORTH);

		btnAdmin = new JButton();

		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.log( Level.INFO, "Botón Administracion");
				if (!numVentanasLogin) { // comprobar que solo crea 1 ventana.
					numVentanasLogin = true;
					VentanaLogin vl = new VentanaLogin(true);
					vl.setVisible(true);
				}
			}
		});
		panel_centro_norte.setLayout(new BorderLayout(0, 0));

		// btnAdmin.setBounds(0, 0, 125, 125);
		panel_centro_norte.add(btnAdmin, BorderLayout.EAST);
		// Creamos un objeto ImageIcon con el nombre de la imagen
		ImageIcon face = new ImageIcon(getClass().getResource("/images/admin40_25.png"));
		// Añadimos la imagen al boton
		btnAdmin.setIcon(face);
		// Creamos un objeto ImageIcon con el nombre de la imagen
		ImageIcon linked = new ImageIcon(getClass().getResource("/images/admin100_25.png"));
		// Añadimos la imagen al boton, con el metodo setRolloverIcon que hace
		// que la imagen se muestre cuando pasamos el cursor encima del boton
		btnAdmin.setRolloverIcon(linked);

		// panel_norte = new JPanel();
		// frame.getContentPane().add(panel_norte, BorderLayout.NORTH);

		ImagenPanel imagenLogo = new ImagenPanel("/images/AppLogo768x68.png");
		panel_centro_norte.add(imagenLogo, BorderLayout.CENTER);
		imagenLogo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// ImageIcon im = new ImageIcon("/images/admin50.png");
		// lblFoto = new JLabel(im);
		// lblFoto.setBounds(10, 11, 154, 172);
		// lblFoto.resize(im.getIconWidth(), im.getIconHeight());

	}

}
