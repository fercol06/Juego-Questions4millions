package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VentanaAdministracion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdministracion frame = new VentanaAdministracion();
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
	public VentanaAdministracion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_norte = new JPanel();
		contentPane.add(panel_norte, BorderLayout.NORTH);
		
		JPanel panel_centro = new JPanel();
		contentPane.add(panel_centro, BorderLayout.CENTER);
		panel_centro.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_c_derecha = new JPanel();
		panel_centro.add(panel_c_derecha, BorderLayout.EAST);
		
		JPanel panel_c_centro = new JPanel();
		panel_centro.add(panel_c_centro, BorderLayout.CENTER);
		
		JComboBox comboBox = new JComboBox();
		panel_c_centro.add(comboBox);
		
		JPanel panel_c_sur = new JPanel();
		panel_centro.add(panel_c_sur, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_c_sur.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		panel_c_sur.add(btnNewButton);
		
		JPanel panel_sur = new JPanel();
		contentPane.add(panel_sur, BorderLayout.SOUTH);
		
		JPanel panel_izquierda = new JPanel();
		contentPane.add(panel_izquierda, BorderLayout.WEST);
		
		JPanel panel_derecha = new JPanel();
		contentPane.add(panel_derecha, BorderLayout.EAST);
	}

}
