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
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAdministracion extends JFrame {

	private JPanel contentPane;
	private JList <Pregunta> lstPreguntas;
	private JScrollPane scrlPnlPreguntas;

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
		
		JLabel lblPreguntasQm = new JLabel("Preguntas Q4M:");
		panel_norte.add(lblPreguntasQm);
		
		JPanel panel_centro = new JPanel();
		contentPane.add(panel_centro, BorderLayout.CENTER);
		panel_centro.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_c_derecha = new JPanel();
		panel_centro.add(panel_c_derecha, BorderLayout.EAST);
		
		JPanel panel_c_centro = new JPanel();
		panel_centro.add(panel_c_centro,BorderLayout.CENTER);
		
		
		/* INICIO Lista con Scroll*/
		scrlPnlPreguntas = new JScrollPane();
		panel_c_centro.add(scrlPnlPreguntas);
		
		lstPreguntas = new JList<Pregunta>();
		lstPreguntas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstPreguntas.setModel(new DefaultListModel<Pregunta>());
		scrlPnlPreguntas.setViewportView(lstPreguntas);
		
		insertarPreguntaEnLista();
		
		/* FIN Lista con Scroll*/
		
		
		//panel_centro.add(panel_c_centro, BorderLayout.CENTER);
		
		JPanel panel_c_sur = new JPanel();
		panel_centro.add(panel_c_sur, BorderLayout.SOUTH);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//EDitar
				//String tipo="Editar";
				VentanaAniadirPregunta vap = new VentanaAniadirPregunta();
				vap.setVisible(true);
				//pasar datos a vap
				dispose();
			}
		});
		panel_c_sur.add(btnEditar);
		
		JButton btnNueva = new JButton("Nueva");
		btnNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String tipo="Nueva";
				VentanaAniadirPregunta vap = new VentanaAniadirPregunta();
				vap.setVisible(true);
				dispose();
			}
		});
		panel_c_sur.add(btnNueva);
		
		JPanel panel_sur = new JPanel();
		contentPane.add(panel_sur, BorderLayout.SOUTH);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n ");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPrincipal.numVentanasLogin=false;
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
		
		ArrayList<Pregunta> aPreguntas= VentanaPrincipal.bd.obtenerPregunta(); // me devuelve arrayList
		
		DefaultListModel<Pregunta> dlm = (DefaultListModel<Pregunta>) lstPreguntas.getModel();
		for(int i=0;i<aPreguntas.size();i++){
			dlm.addElement(aPreguntas.get(i));
		}
		lstPreguntas.setModel(dlm);
	}
	
}
