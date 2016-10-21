package ventanas;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class VentanaPregunta extends JFrame{

	JFrame frame;
    
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
		setTitle("Atenci\u00F3n, \u00A1pregunta!");
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_norte = new JPanel();
		getContentPane().add(panel_norte, BorderLayout.NORTH);
		
		JLabel lblUsuario = new JLabel("Turno para: ");
		panel_norte.add(lblUsuario);
		
		JPanel panel_sur = new JPanel();
		getContentPane().add(panel_sur, BorderLayout.SOUTH);
		panel_sur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel_sur.add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		
		JButton btnRespuesta1 = new JButton("Respuesta 1");
		panel_11.add(btnRespuesta1);
		
		JPanel panel_12 = new JPanel();
		panel.add(panel_12);
		
		JButton btnRespuesta2 = new JButton("Respuesta 2");
		panel_12.add(btnRespuesta2);
		
		JPanel panel_21 = new JPanel();
		panel.add(panel_21);
		
		JButton btnRespuesta3 = new JButton("Respuesta 3");
		panel_21.add(btnRespuesta3);
		
		JPanel panel_22 = new JPanel();
		panel.add(panel_22);
		
		JButton btnRespuesta4 = new JButton("Respuesta 4");
		panel_22.add(btnRespuesta4);
		
		/*JPanel panel_izquierdo = new JPanel();
		getContentPane().add(panel_izquierdo, BorderLayout.WEST);
		
		JLabel lblReloj = new JLabel("Reloj");
		panel_izquierdo.add(lblReloj);
		*/
		ImagenTiempo imagenTiempo= new ImagenTiempo("/images/Progreso100.png"); //como le paso la foto?
		getContentPane().add(imagenTiempo, BorderLayout.WEST);
		
		
		JPanel panel_derecho = new JPanel();
		getContentPane().add(panel_derecho, BorderLayout.EAST);
		
		JPanel panel_centro = new JPanel();
		getContentPane().add(panel_centro, BorderLayout.CENTER);
		
		JLabel lblPregunta = new JLabel("Pregunta");
		panel_centro.add(lblPregunta);
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
