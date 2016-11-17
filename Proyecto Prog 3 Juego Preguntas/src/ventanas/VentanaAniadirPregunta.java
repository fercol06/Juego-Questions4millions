package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TiposDeDatos.Pregunta;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAniadirPregunta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPregunta;
	private JTextField textFieldRespuestaIncorrecta1;
	private JTextField textFieldRespuestaIncorrecta2;
	private JTextField textFieldRespuestaIncorrecta3;
	private JTextField textFieldRespuestaCorrecta;
	private JComboBox comboBoxNivel;
	private JButton btnAtras,btnAniadir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAniadirPregunta frame = new VentanaAniadirPregunta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame de añadir nuevas preguntas.
	 */
	public VentanaAniadirPregunta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Nueva pregunta");
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAniadir = new JButton("A\u00F1adir");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Si es True campos vacios
				if(comprobarCampos()){
					JOptionPane.showMessageDialog(null, "Recuerde que los campos no pueden estar vacios.","Error" ,JOptionPane.ERROR_MESSAGE);
					limpiarCampos();
				}else{
					int nivel=1;
					nivel+= comboBoxNivel.getSelectedIndex();//selecciono el indice del array
					//Pregunta p= crearPregunta(textFieldPregunta, textFieldRespuestaIncorrecta1, textFieldRespuestaIncorrecta2, textFieldRespuestaIncorrecta3, textFieldRespuestaCorrecta, nivel);
					Pregunta p= crearPregunta(nivel);
					//Comprobar si existe pregunta
					if(existePregunta(p)){
						JOptionPane.showMessageDialog(null, "Su pregunta ya existe en la Base de Datos.","Pregunta repetida", JOptionPane.ERROR_MESSAGE);
						limpiarCampos();
					}else{
						VentanaPrincipal.bd.aniadirPregunta(p);
						JOptionPane.showMessageDialog(null, "Su pregunta se ha añadido correctamente.","Pregunta añadida", JOptionPane.DEFAULT_OPTION);
						limpiarCampos();
					}	
				}
			}
		});
		panelSur.add(btnAniadir);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Volver a la otra ventana
				VentanaAdministracion va= new VentanaAdministracion();
				va.setVisible(true);
				dispose();
			}
		});
		panelSur.add(btnAtras);
		
		JPanel panelIzquierda = new JPanel();
		contentPane.add(panelIzquierda, BorderLayout.WEST);
		
		JPanel panelDerecha = new JPanel();
		contentPane.add(panelDerecha, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_C_Norte = new JPanel();
		panelCentro.add(panel_C_Norte, BorderLayout.NORTH);
		panel_C_Norte.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblTexto = new JLabel("Inserta una nueva pregunta: ");
		panel_C_Norte.add(lblTexto);
		
		JSeparator separator = new JSeparator();
		panel_C_Norte.add(separator);
		
		JPanel panel_C_Centro = new JPanel();
		panelCentro.add(panel_C_Centro, BorderLayout.CENTER);
		panel_C_Centro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblPregunta = new JLabel("Pregunta:");
		panel_C_Centro.add(lblPregunta);
		
		textFieldPregunta = new JTextField();
		panel_C_Centro.add(textFieldPregunta);
		textFieldPregunta.setColumns(10);
		
		JLabel lblRespuestaIncorrecta = new JLabel("Respuesta Incorrecta 1:");
		panel_C_Centro.add(lblRespuestaIncorrecta);
		
		textFieldRespuestaIncorrecta1 = new JTextField();
		panel_C_Centro.add(textFieldRespuestaIncorrecta1);
		textFieldRespuestaIncorrecta1.setColumns(10);
		
		JLabel lblRespuestaIncorrecta_1 = new JLabel("Respuesta Incorrecta 2:");
		panel_C_Centro.add(lblRespuestaIncorrecta_1);
		
		textFieldRespuestaIncorrecta2 = new JTextField();
		panel_C_Centro.add(textFieldRespuestaIncorrecta2);
		textFieldRespuestaIncorrecta2.setColumns(10);
		
		JLabel lblRespuestaIncorrecta_2 = new JLabel("Respuesta Incorrecta 3:");
		panel_C_Centro.add(lblRespuestaIncorrecta_2);
		
		textFieldRespuestaIncorrecta3 = new JTextField();
		panel_C_Centro.add(textFieldRespuestaIncorrecta3);
		textFieldRespuestaIncorrecta3.setColumns(10);
		
		JLabel lblRespuestaCorrecta = new JLabel("Respuesta Correcta:");
		panel_C_Centro.add(lblRespuestaCorrecta);
		
		textFieldRespuestaCorrecta = new JTextField();
		panel_C_Centro.add(textFieldRespuestaCorrecta);
		textFieldRespuestaCorrecta.setColumns(10);
		
		JLabel lblNivel = new JLabel("Nivel:");
		panel_C_Centro.add(lblNivel);
		
		comboBoxNivel = new JComboBox();
		comboBoxNivel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBoxNivel.setMaximumRowCount(3);
		panel_C_Centro.add(comboBoxNivel);
		

	}

	
	/**
	 * Crea el frame de editar preguntas.
	 */
	public VentanaAniadirPregunta( Pregunta p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Editar pregunta");
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		
		btnAniadir = new JButton("Editar");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*// Si es True campos vacios
				if(comprobarCampos()){
					JOptionPane.showMessageDialog(null, "Recuerde que los campos no pueden estar vacios.","Error" ,JOptionPane.ERROR_MESSAGE);
					limpiarCampos();
				}else{
					int nivel=1;
					nivel+= comboBoxNivel.getSelectedIndex();//selecciono el indice del array
					//Pregunta p= crearPregunta(textFieldPregunta, textFieldRespuestaIncorrecta1, textFieldRespuestaIncorrecta2, textFieldRespuestaIncorrecta3, textFieldRespuestaCorrecta, nivel);
					Pregunta p= crearPregunta(nivel);
					//Comprobar si existe pregunta
					if(existePregunta(p)){
						JOptionPane.showMessageDialog(null, "Su pregunta ya existe en la Base de Datos.","Pregunta repetida", JOptionPane.ERROR_MESSAGE);
						limpiarCampos();
					}else{
						VentanaPrincipal.bd.aniadirPregunta(p);
						JOptionPane.showMessageDialog(null, "Su pregunta se ha añadido correctamente.","Pregunta añadida", JOptionPane.DEFAULT_OPTION);
						limpiarCampos();
					}	
				}*/
			}
		});
		panelSur.add(btnAniadir);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Volver a la otra ventana
				VentanaAdministracion va= new VentanaAdministracion();
				va.setVisible(true);
				dispose();
			}
		});
		panelSur.add(btnAtras);
		
		JPanel panelIzquierda = new JPanel();
		contentPane.add(panelIzquierda, BorderLayout.WEST);
		
		JPanel panelDerecha = new JPanel();
		contentPane.add(panelDerecha, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_C_Norte = new JPanel();
		panelCentro.add(panel_C_Norte, BorderLayout.NORTH);
		panel_C_Norte.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblTexto = new JLabel("Edita la pregunta: ");
		panel_C_Norte.add(lblTexto);
		
		JSeparator separator = new JSeparator();
		panel_C_Norte.add(separator);
		
		JPanel panel_C_Centro = new JPanel();
		panelCentro.add(panel_C_Centro, BorderLayout.CENTER);
		panel_C_Centro.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		JLabel lblPregunta = new JLabel("Pregunta:");
		panel_C_Centro.add(lblPregunta);
		
		textFieldPregunta = new JTextField();
		panel_C_Centro.add(textFieldPregunta);
		textFieldPregunta.setColumns(10);
		
		JLabel lblRespuestaIncorrecta = new JLabel("Respuesta Incorrecta 1:");
		panel_C_Centro.add(lblRespuestaIncorrecta);
		
		textFieldRespuestaIncorrecta1 = new JTextField();
		panel_C_Centro.add(textFieldRespuestaIncorrecta1);
		textFieldRespuestaIncorrecta1.setColumns(10);
		
		JLabel lblRespuestaIncorrecta_1 = new JLabel("Respuesta Incorrecta 2:");
		panel_C_Centro.add(lblRespuestaIncorrecta_1);
		
		textFieldRespuestaIncorrecta2 = new JTextField();
		panel_C_Centro.add(textFieldRespuestaIncorrecta2);
		textFieldRespuestaIncorrecta2.setColumns(10);
		
		JLabel lblRespuestaIncorrecta_2 = new JLabel("Respuesta Incorrecta 3:");
		panel_C_Centro.add(lblRespuestaIncorrecta_2);
		
		textFieldRespuestaIncorrecta3 = new JTextField();
		panel_C_Centro.add(textFieldRespuestaIncorrecta3);
		textFieldRespuestaIncorrecta3.setColumns(10);
		
		JLabel lblRespuestaCorrecta = new JLabel("Respuesta Correcta:");
		panel_C_Centro.add(lblRespuestaCorrecta);
		
		textFieldRespuestaCorrecta = new JTextField();
		panel_C_Centro.add(textFieldRespuestaCorrecta);
		textFieldRespuestaCorrecta.setColumns(10);
		
		JLabel lblNivel = new JLabel("Nivel:");
		panel_C_Centro.add(lblNivel);
		
		comboBoxNivel = new JComboBox();
		comboBoxNivel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBoxNivel.setMaximumRowCount(3);
		panel_C_Centro.add(comboBoxNivel);
		
		aniadeCampos(p);
		

	}

	/**
	 * Metodo que crea un obeto pregunta tras recibir los parametros. 
	 * Este metodo se encarga de reordenar las respuestas de manera aleatoria.
	 * @param textFieldPregunta
	 * @param textFieldRespuestaIncorrecta1
	 * @param textFieldRespuestaIncorrecta2
	 * @param textFieldRespuestaIncorrecta3
	 * @param textFieldRespuestaCorrecta
	 * @param nivel
	 * @return Pregunta
	 */
	private Pregunta crearPregunta(int nivel){	
		//Para colocar la respuesta correcta en orden aleatorio
		Random rnd = new Random(System.currentTimeMillis());
		int numOK= rnd.nextInt(3);
		
		String preg,resp1,resp2,resp3,resp4,respOk;
		preg=textFieldPregunta.getText();
		resp1=textFieldRespuestaIncorrecta1.getText();
		resp2=textFieldRespuestaIncorrecta2.getText();
		resp3=textFieldRespuestaIncorrecta3.getText();
		respOk=textFieldRespuestaCorrecta.getText();
		
		Pregunta p=null;
		
		switch(numOK){
		case 0:
			p = new Pregunta(preg, respOk, resp1, resp2, resp3, respOk, nivel);
			break;
		case 1:
			p = new Pregunta(preg, resp1, respOk, resp2, resp3, respOk, nivel);
			break;
		case 2:
			p = new Pregunta(preg, resp1, resp2, respOk, resp3, respOk, nivel);
			break;
		case 3:
			p = new Pregunta(preg, resp1, resp2, resp3, respOk, respOk, nivel);
			break;
		}
		return p;
	}
	
	/**
	 * Metodo que comprueba que los campos no esten vacios
	 * @return true si está vacio. 
	 */
	private boolean comprobarCampos(){
		String preg=textFieldPregunta.getText();
		String resp1=textFieldRespuestaIncorrecta1.getText();
		String resp2=textFieldRespuestaIncorrecta2.getText();
		String resp3=textFieldRespuestaIncorrecta3.getText();
		String respOk=textFieldRespuestaCorrecta.getText();
		boolean vacio=false;
		if(preg.trim().length()==0 && resp1.trim().length()==0 && resp2.trim().length()==0 && resp3.trim().length()==0&& respOk.trim().length()==0){
			vacio=true;
		}
		return vacio;
	}
	/**
	 * Metodo que limpia los campos
	 */
	private void limpiarCampos() {
		textFieldPregunta.setText("");
		textFieldRespuestaIncorrecta1.setText("");
		textFieldRespuestaIncorrecta2.setText("");
		textFieldRespuestaIncorrecta3.setText("");
		textFieldRespuestaCorrecta.setText("");
		comboBoxNivel.setSelectedIndex(0);
	}
	
	/**
	 * Metodo que añade datos a los campos
	 */
	private void aniadeCampos(Pregunta p) {
		textFieldPregunta.setText(p.getPregunta());
		textFieldRespuestaCorrecta.setText(p.getRespCorrecta());
		//para mostrar erroneas
		int i=0;
		if(p.getResp1().equals(p.getRespCorrecta())){
			i=1;
			/*
			textFieldRespuestaIncorrecta1.setText(p.getResp2());
			textFieldRespuestaIncorrecta2.setText(p.getResp3());
			textFieldRespuestaIncorrecta3.setText(p.getResp4());
			 */
		}else if(p.getResp2().equals(p.getRespCorrecta())){
			i=2;
			/*
			textFieldRespuestaIncorrecta1.setText(p.getResp1());
			textFieldRespuestaIncorrecta2.setText(p.getResp3());
			textFieldRespuestaIncorrecta3.setText(p.getResp4());
			 */
		}else if(p.getResp3().equals(p.getRespCorrecta())){
			i=3;
			/*
			textFieldRespuestaIncorrecta1.setText(p.getResp1());
			textFieldRespuestaIncorrecta2.setText(p.getResp2());
			textFieldRespuestaIncorrecta3.setText(p.getResp4());
			 */
		}else{
			i=4;
			/*
			textFieldRespuestaIncorrecta1.setText(p.getResp1());
			textFieldRespuestaIncorrecta2.setText(p.getResp2());
			textFieldRespuestaIncorrecta3.setText(p.getResp3());
			 */
		}
		String campo="p.getResp"+i+"()";
		textFieldRespuestaIncorrecta1.setText(campo);
		textFieldRespuestaIncorrecta2.setText(campo);
		textFieldRespuestaIncorrecta3.setText(campo);
		comboBoxNivel.setSelectedIndex(p.getNivel());
		
		
	}
	
	/**
	 * Comprueba si existe pregunta
	 */
	private boolean existePregunta(Pregunta p){
		boolean existe=false;
		String pregunta=p.getPregunta();
		String preguntaBD="";
		
		//Obtengo un arrayList de Preguntas para comprobar
		ArrayList<Pregunta> aP= VentanaPrincipal.bd.obtenerPregunta();
		for(int i=0; i<aP.size();i++){
			 preguntaBD=aP.get(i).getPregunta();
			 //compruebo si son iguales 
			 if(preguntaBD.equalsIgnoreCase(pregunta)){
				 existe=true;
			 }
		}
		return existe;
	}
	
	
	
}
