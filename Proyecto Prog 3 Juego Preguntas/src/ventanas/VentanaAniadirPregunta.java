package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TiposDeDatos.Pregunta;

import javax.swing.JButton;
import java.awt.GridLayout;
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
	 * Create the frame.
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
				
				//Comprobar que los campos no esten vacios. 
				// Si es True campos vacios
				if(comprobarCampos()){
					JOptionPane.showInputDialog(null, "Recuerde que los campos no pueden estar vacios.","Error" ,JOptionPane.ERROR_MESSAGE);
					limpiarCampos();
				}else{
					int nivel=(int) comboBoxNivel.getSelectedItem();
					//Pregunta p= crearPregunta(textFieldPregunta, textFieldRespuestaIncorrecta1, textFieldRespuestaIncorrecta2, textFieldRespuestaIncorrecta3, textFieldRespuestaCorrecta, nivel);
					Pregunta p= crearPregunta(nivel);
					VentanaPrincipal.bd.aniadirPregunta(p);
					JOptionPane.showInputDialog(null, "Su pregunta se ha añadido correctamente.","Pregunta añadida", JOptionPane.OK_OPTION);
					limpiarCampos();
				}
				
				
			}
		});
		panelSur.add(btnAniadir);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
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
	//private Pregunta crearPregunta(JTextField textFieldPregunta,JTextField textFieldRespuestaIncorrecta1, JTextField textFieldRespuestaIncorrecta2, JTextField textFieldRespuestaIncorrecta3, JTextField textFieldRespuestaCorrecta, int nivel ){
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
}
