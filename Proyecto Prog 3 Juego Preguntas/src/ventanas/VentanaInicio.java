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

public class VentanaInicio extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel_centro = new JPanel();
	private JButton btnJugar = new JButton("Jugar");
	private JButton btnMarcadores = new JButton("Marcadores");
	private JButton btnInstrucciones = new JButton("Instrucciones");
	private JButton btnSalir = new JButton("Salir");

	/**
	 * Launch the application. Ventana Principal.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setSize(640, 640);
					frame.setVisible(true);
					frame.setTitle("Questions4millions");

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

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		getContentPane().setLayout(null);

		panel_centro = new JPanel();
		panel_centro.setLocation(0, 0);
		panel_centro.setSize(428, 244);
		getContentPane().add(panel_centro, BorderLayout.CENTER);
		panel_centro.setLayout(null);

		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(47, 154, 150, 29);
		panel_centro.add(btnJugar);
		btnJugar.addActionListener(this);

		btnMarcadores = new JButton("Marcadores");
		btnMarcadores.setBounds(47, 199, 150, 29);
		panel_centro.add(btnMarcadores);

		btnInstrucciones = new JButton("Instrucciones");
		btnInstrucciones.setBounds(212, 154, 150, 29);
		panel_centro.add(btnInstrucciones);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(212, 199, 150, 29);
		panel_centro.add(btnSalir);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton) e.getSource();
		if (source.equals(btnJugar)) {
			java.awt.EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					VentanaConfiguracion frame = new VentanaConfiguracion();
					// frame.setSize(640, 640);
					frame.setVisible(true);
				}

			});
		} else if (source.equals(btnInstrucciones)) {
			java.awt.EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					VentanaConfiguracion frame = new VentanaConfiguracion();
					// frame.setSize(640, 640);
					frame.setVisible(true);
				}

			});
		}
	}
}
