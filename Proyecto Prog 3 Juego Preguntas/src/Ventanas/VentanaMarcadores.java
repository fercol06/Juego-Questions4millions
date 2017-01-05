package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import TiposDeDatos.Jugador;
import TiposDeDatos.Partida;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.ScrollPaneConstants;

public class VentanaMarcadores extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabla;
	private JScrollPane scroll;
	private JPanel panel_sur;
	private JPanel panel_norte;
	private JButton btnAtras;
	private JLabel lblMarcadores;
	private JSeparator separator;
	protected ArrayList<Jugador> aJugadores= null;
	

	/**
	 * Create the frame.
	 */
	public VentanaMarcadores(boolean situacion) {
		
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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setTitle("Marcadores Q4M!");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		
		
		//creacion de un tablemodel para  añadir datos de la bd
		Object[] columnas = {"#", "Usuario", "Puntuación máxima"};
		DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
		
		
		
		
		
		
		/*Depende si recibe un true o un false, se muestran unos datos u otros
		 * Si se pasa un:
		 * true - Ventana todos marcadores
		 * false - Ventana solo partida
		 * */
		
		if(situacion){
			aJugadores= VentanaPrincipal.bd.obtenerUsuarios();
		}
		else{
			aJugadores=Partida.aUsuario;
		}
		aJugadores.sort(new Comparator<Jugador>() {

			@Override
			public int compare(Jugador o1, Jugador o2) {
				return o2.getRecord()-o1.getRecord();
			}
		});
		Jugador jug=null;
		Object[] datos=null;
		int pos=0;
		for(int i=0; i<aJugadores.size();i++){
			jug=aJugadores.get(i);
			datos=new Object[3];
			datos[0]=i+1;
			datos[1]=jug.getUser();
			datos[2]=jug.getRecord();
			modeloTabla.addRow(datos);
		}
		
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

		tabla = new JTable(modeloTabla); 
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tabla.setFillsViewportHeight(true);
		
		//TABLA tamaño 1º columna
		//TableColumnModel columnModel = tabla.getColumnModel();
		tabla.getColumnModel().getColumn(0).setMaxWidth(20);
		
		//Renderer
		tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				
				Component def = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);				
				if(column==0){
					def.setFont(new Font("Tahoma", Font.BOLD, 12));
				}
				
				if(row == 0 ){
					def.setBackground(new Color(101, 255, 135));
				}
				else if(row ==  aJugadores.size()-1){
					def.setBackground(new Color(255, 101, 111));
				}
				else{
					def.setBackground(Color.WHITE);
				}
				
				return def;
			}
		});
		
		
		scroll = new JScrollPane(tabla);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scroll);
	}
	
	
}
