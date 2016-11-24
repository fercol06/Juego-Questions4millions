package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaMarcadores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabla;
	private JScrollPane scroll;
	private JPanel panel_sur;
	private JPanel panel_norte;
	private JButton btnAtras;
	private JLabel lblMarcadores;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMarcadores frame = new VentanaMarcadores();
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
	public VentanaMarcadores() {
		
		/*
		 * Cuando cierro la ventana me pone la variable estatica a false para que se pueda 
		 * volver a abrir la ventana Marcadores.
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				VentanaPrincipal.numVentanasMarcadores = false;
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaPrincipal.class.getResource("/images/logoCuadrado125.png")));
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setTitle("Marcadores Q4M!");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		String[] columnNames = { "Usuario", "Puntuación máxima"};
		Object[][] datos = {{"Emilio", "2340"},{"Augusto","8304"},{"Martín","450"}};
		
		panel_norte = new JPanel();
		contentPane.add(panel_norte, BorderLayout.NORTH);
		panel_norte.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblMarcadores = new JLabel("Marcadores:");
		panel_norte.add(lblMarcadores);
		
		separator = new JSeparator();
		panel_norte.add(separator);
		
		panel_sur = new JPanel();
		contentPane.add(panel_sur, BorderLayout.SOUTH);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal.numVentanasMarcadores = false;
				dispose();
			}
		});
		panel_sur.add(btnAtras);

		tabla = new JTable(datos, columnNames); 
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tabla.setFillsViewportHeight(true);
		scroll = new JScrollPane(tabla);
		contentPane.add(scroll);
	}

}
