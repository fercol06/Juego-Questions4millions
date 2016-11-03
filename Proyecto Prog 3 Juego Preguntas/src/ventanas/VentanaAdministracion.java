package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import TiposDeDatos.Pregunta;
import TiposDeDatos.Usuario;

import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaAdministracion extends JFrame {

	private JPanel contentPane;
	private JList listPreguntas;
	private JScrollPane slistPreguntas;

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
		panel_centro.add(panel_c_centro,BorderLayout.CENTER);
		
		slistPreguntas = new JScrollPane();
		panel_c_centro.add(slistPreguntas);
		
		listPreguntas = new JList<Pregunta>();
		listPreguntas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPreguntas.setModel(new DefaultListModel<Pregunta>());
		slistPreguntas.setViewportView(listPreguntas);
		
		/*JList listPreguntas = new JList();
		listPreguntas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane slistPreguntas = new JScrollPane(listPreguntas);
		*/
		//panel_centro.add(panel_c_centro, BorderLayout.CENTER);
		
		JPanel panel_c_sur = new JPanel();
		panel_centro.add(panel_c_sur, BorderLayout.SOUTH);
		
		JButton btnEditar = new JButton("Editar");
		panel_c_sur.add(btnEditar);
		
		JButton btnNueva = new JButton("Nueva");
		panel_c_sur.add(btnNueva);
		
		JPanel panel_sur = new JPanel();
		contentPane.add(panel_sur, BorderLayout.SOUTH);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n ");
		btnCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Cierra la sesion de Admin
				dispose();
			}
		});
		panel_sur.add(btnCerrarSesion);
		
		JPanel panel_izquierda = new JPanel();
		contentPane.add(panel_izquierda, BorderLayout.WEST);
		
		JPanel panel_derecha = new JPanel();
		contentPane.add(panel_derecha, BorderLayout.EAST);
	}
	
	/**
	 * Método que inserta en la lista las preguntas.
	 */
	private void insertarPreguntaEnLista() {
		
		//Hago aqui la llamada a la bd para todas las preguntas?
		// o lo guardo en un array?
		Pregunta p = VentanaPrincipal.bd.obtenerPregunta(); // me devuelve 1????
		/*
		DefaultListModel<Pregunta> dlm = (DefaultListModel<Pregunta>) listPreguntas.getModel();
		for(int i=0; i<){
			dlm.addElement(element);
		}
		listPreguntas.setModel(dlm);
		*/
	}
	
}
