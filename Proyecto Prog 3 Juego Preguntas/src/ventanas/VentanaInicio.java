package ventanas;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class VentanaInicio extends JFrame implements ActionListener{

	private JFrame frame;
	private JPanel panel_centro = new JPanel();
	private JButton btnJugar = new JButton("Jugar");
	private JButton btnMarcadores = new JButton("Marcadores");
	private JButton btnInstrucciones = new JButton("Instrucciones");
	private JButton btnSalir = new JButton("Salir");
	private JPanel panel = new JPanel();






    
	/**
	 * Launch the application.
	 * Ventana Principal.
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
		
		getContentPane().add(panel_centro, BorderLayout.CENTER);
		panel_centro.setLayout(null);
		
		btnJugar.setBounds(47, 154, 150, 29);
		panel_centro.add(btnJugar);
		
		btnMarcadores.setBounds(47, 199, 150, 29);
		panel_centro.add(btnMarcadores);
		
		btnInstrucciones.setBounds(212, 154, 150, 29);
		panel_centro.add(btnInstrucciones);
		
		btnSalir.setBounds(212, 199, 150, 29);
		panel_centro.add(btnSalir);
		
		panel.setBounds(69, 16, 267, 116);
		panel_centro.add(panel);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton) e.getSource();
		if(source.equals(btnJugar)){
			
		}
	}
}
