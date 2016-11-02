package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TiposDeDatos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldContrasenia;
	private JButton btnIniciarSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_sur = new JPanel();
		contentPane.add(panel_sur, BorderLayout.SOUTH);
		
		JPanel panel_norte = new JPanel();
		contentPane.add(panel_norte, BorderLayout.NORTH);
		
		JPanel panel_centro = new JPanel();
		contentPane.add(panel_centro, BorderLayout.CENTER);
		panel_centro.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_centro.add(panel_4);
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_5);
		
		JLabel lblNombre = new JLabel("Nombre:");
		panel_5.add(lblNombre);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_15 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_15.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_7.add(panel_15);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a:");
		panel_15.add(lblContrasenia);
		
		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);
		panel_9.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_9.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_9.add(panel_13);
		
		textFieldNombre = new JTextField();
		panel_13.add(textFieldNombre);
		textFieldNombre.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldNombre.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10);
		panel_10.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_10.add(panel_14);
		
		textFieldContrasenia = new JTextField();
		panel_14.add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		JPanel panel_16 = new JPanel();
		panel_centro.add(panel_16, BorderLayout.NORTH);
		
		JPanel panel_17 = new JPanel();
		panel_centro.add(panel_17, BorderLayout.SOUTH);
		
		btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String txtnombre = textFieldNombre.getText();
				String txtcontraseña = textFieldContrasenia.getText();
				
				if (txtnombre.equals("") || txtcontraseña.equals("")) {
					JOptionPane.showMessageDialog(null,"Para poder administrar el juego tienes que insertar un nombre de usuario y una contraseña validos",	"Error!", JOptionPane.ERROR_MESSAGE);
				} else {
					Usuario u = VentanaPrincipal.bd.obtenerUsuarioAdmin(txtnombre);
					if (u == null) {
					 	//No existe
						JOptionPane.showMessageDialog(null, "Lo siento pero no tienes permisos para acceder a esta página","Fallo de Autenticación!", JOptionPane.ERROR_MESSAGE);

					} else if (!u.getCon().equals(textFieldContrasenia.getText())) {
						//contraseña incorrecta
						JOptionPane.showMessageDialog(null, "Lo sentimos, la contraseña no es correcta", "Error!", JOptionPane.ERROR_MESSAGE);
					} else {
						//Contraseña Correcta
						VentanaAdministracion va = new VentanaAdministracion();
						va.dispose();
					}
				}
				limpiarCampos();
				 
				
			}
		});
		panel_17.add(btnIniciarSesion);
		
		JPanel panel_18 = new JPanel();
		panel_centro.add(panel_18, BorderLayout.WEST);
		
		JPanel panel_19 = new JPanel();
		panel_centro.add(panel_19, BorderLayout.EAST);
		
	}
	/**
	 * Método para borrar campos
	 */
	private void limpiarCampos() {
		textFieldNombre.setText("");
		textFieldContrasenia.setText("");
	}

}
