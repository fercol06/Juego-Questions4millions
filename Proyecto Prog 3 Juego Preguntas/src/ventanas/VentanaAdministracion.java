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
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JProgressBar;

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
		setTitle("Lista de preguntas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		scrlPnlPreguntas = new JScrollPane();
		contentPane.add(scrlPnlPreguntas, BorderLayout.CENTER);
		
		lstPreguntas = new JList<Pregunta>();
		lstPreguntas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstPreguntas.setModel(new DefaultListModel<Pregunta>());
		scrlPnlPreguntas.setViewportView(lstPreguntas);
		
		JPanel panel_norte = new JPanel();
		contentPane.add(panel_norte, BorderLayout.NORTH);
		panel_norte.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblPreguntasQm = new JLabel("Preguntas Q4M:");
		panel_norte.add(lblPreguntasQm);
		
		JSeparator separator = new JSeparator();
		panel_norte.add(separator);
		
		
		/* INICIO Lista con Scroll*/
		
		insertarPreguntaEnLista();
		
		/* FIN Lista con Scroll*/
		
		JPanel panel_sur = new JPanel();
		contentPane.add(panel_sur, BorderLayout.SOUTH);
		panel_sur.setLayout(new GridLayout(2, 2, 0, 0));
		
		

		
		JPanel panel_c_sur = new JPanel();
		panel_sur.add(panel_c_sur);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String tipo="Editar";
				//le pasa desde 0.
				//Compruebo que se ha seleccionado un valor para editar
				if(lstPreguntas.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "No has seleccionado ninguna pregunta.", "Error al seleccionar!", JOptionPane.ERROR_MESSAGE);
				}else{
					int posSeleccionado=lstPreguntas.getSelectedIndex();
					Pregunta p=obtenerPreguntaPos(posSeleccionado);
					VentanaAniadirPregunta vap = new VentanaAniadirPregunta(p);
				
					vap.setVisible(true);
					dispose();
				}
				
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
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(lstPreguntas.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "No has seleccionado ninguna pregunta.", "Error al seleccionar!", JOptionPane.ERROR_MESSAGE);
				}else{
					//Confirmación que se desea borrar pregunta. 
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar esta pregunta?", "Confirmación borrar pregnta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(respuesta== JOptionPane.YES_OPTION){
						int posSeleccionado=lstPreguntas.getSelectedIndex();
						Pregunta p=obtenerPreguntaPos(posSeleccionado);
						VentanaPrincipal.bd.borrarPregunta(p);
					}
				}
			}
		});
		panel_c_sur.add(btnBorrar);
		panel_c_sur.add(btnNueva);
		
		JPanel panel_bajo = new JPanel();
		panel_sur.add(panel_bajo);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n ");
		panel_bajo.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPrincipal.numVentanasLogin=false;
			}
			
		});
		
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
	

	/**
	 * Método para obtener 1 pregunta dependiendo de la posicion del panel de admin
	 */
	private Pregunta obtenerPreguntaPos(int i) {
		Pregunta p=null;
		//obtengo todas las preguntas en orden
		ArrayList<Pregunta> aP=VentanaPrincipal.bd.obtenerPregunta();
		//Selecciono la posicion en la que estaba en la lista
		p=aP.get(i);
		return p;
	}
}
