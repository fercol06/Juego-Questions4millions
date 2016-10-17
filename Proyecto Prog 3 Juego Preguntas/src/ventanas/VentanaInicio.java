package ventanas;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class VentanaInicio extends JFrame{

	JFrame frame;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio window = new VentanaInicio();
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
	public VentanaInicio() {
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_norte = new JPanel();
		getContentPane().add(panel_norte, BorderLayout.NORTH);
		
		JPanel panel_sur = new JPanel();
		getContentPane().add(panel_sur, BorderLayout.SOUTH);
		
		JPanel panel_izquierdo = new JPanel();
		getContentPane().add(panel_izquierdo, BorderLayout.WEST);
		
		JPanel panel_derecho = new JPanel();
		getContentPane().add(panel_derecho, BorderLayout.EAST);
		
		JPanel panel_centro = new JPanel();
		getContentPane().add(panel_centro, BorderLayout.CENTER);
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
