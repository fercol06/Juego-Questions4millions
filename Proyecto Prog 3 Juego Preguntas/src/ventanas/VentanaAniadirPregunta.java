package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaAniadirPregunta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPregunta;
	private JTextField textFieldRespuestaIncorrecta1;
	private JTextField textFieldRespuestaIncorrecta2;
	private JTextField textFieldRespuestaIncorrecta3;
	private JTextField textFieldRespuestaCorrecta;

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
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAniadir = new JButton("A\u00F1adir");
		panelSur.add(btnAniadir);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
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
		
		JComboBox comboBoxNivel = new JComboBox();
		comboBoxNivel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBoxNivel.setMaximumRowCount(3);
		panel_C_Centro.add(comboBoxNivel);
	}

}
