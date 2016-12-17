package Ventanas;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import Threads.ThreadTiempo;
import TiposDeDatos.Partida;
import TiposDeDatos.Pregunta;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaPregunta extends JFrame{


	private JPanel panel_norte,panel_sur,panel_centro,panel_derecho;
	private JPanel panel, panel_11,panel_12,panel_21,panel_22;
	private JButton btnRespuesta1, btnRespuesta2, btnRespuesta3, btnRespuesta4;
	private JLabel lblPregunta, lblUsuario;
	private JPanel panel_Iniciar;
	private Pregunta pregunta;
	private JLabel lblNomUsuario;
	private boolean respuesta;

	  
	/**
	 * Create the application.
	 */
	public VentanaPregunta(Pregunta pregunta) {
		this.pregunta=pregunta;
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setTitle("Questions4millions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Atenci\u00F3n, \u00A1pregunta!");
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel_Iniciar = new JPanel();
		getContentPane().add(panel_Iniciar, BorderLayout.CENTER);
		panel_Iniciar.setLayout(new BorderLayout(0, 0));
		
		
		
		panel_norte = new JPanel();
		panel_Iniciar.add(panel_norte, BorderLayout.NORTH);
		
		lblUsuario = new JLabel("Turno para: ");
		lblUsuario.setFont(new Font("Tahoma", Font.ITALIC, 16));
		panel_norte.add(lblUsuario);
		
		lblNomUsuario = new JLabel(Partida.jugadorTurno.getUser());
		lblNomUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_norte.add(lblNomUsuario);
		
	
		panel_derecho = new JPanel();
		panel_Iniciar.add(panel_derecho, BorderLayout.EAST);
		
		/*
		ThreadTiempo ttiempo = new ThreadTiempo();
		ttiempo.start();
		*/
		
		ImagenPanel imagenTiempo= new ImagenPanel("/images/Progreso100.png");
		panel_Iniciar.add(imagenTiempo, BorderLayout.WEST);
		
		
		panel_centro = new JPanel();
		panel_Iniciar.add(panel_centro, BorderLayout.CENTER);
		
		lblPregunta = new JLabel(pregunta.getPregunta());
		lblPregunta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_centro.add(lblPregunta);
		
		panel_sur = new JPanel();
		panel_Iniciar.add(panel_sur, BorderLayout.SOUTH);
		panel_sur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel = new JPanel();
		panel_sur.add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		panel_11 = new JPanel();
		panel.add(panel_11);
		
		btnRespuesta1 = new JButton(pregunta.getResp1());
		panel_11.add(btnRespuesta1);
		
		panel_12 = new JPanel();
		panel.add(panel_12);
		
		btnRespuesta2 = new JButton(pregunta.getResp2());
		panel_12.add(btnRespuesta2);
		
		panel_21 = new JPanel();
		panel.add(panel_21);
		
		btnRespuesta3 = new JButton(pregunta.getResp3());
		panel_21.add(btnRespuesta3);
		
		panel_22 = new JPanel();
		panel.add(panel_22);
		
		btnRespuesta4 = new JButton(pregunta.getResp4());
		panel_22.add(btnRespuesta4);
		
		
	}
	
	//AQUI?
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado =(JButton) e.getSource();
		String respCorrecta= pregunta.getRespCorrecta();
		
		if(botonPulsado == btnRespuesta1){
			if(btnRespuesta1.getText().equals(respCorrecta)){
				respuesta=true;
			}else{
				respuesta=false;
			}
		}
		else if(botonPulsado == btnRespuesta2){
			if(btnRespuesta2.getText().equals(respCorrecta)){
				respuesta=true;
			}else{
				respuesta=false;
			}
		}
		else if(botonPulsado == btnRespuesta3){
			if(btnRespuesta3.getText().equals(respCorrecta)){
				respuesta=true;
			}else{
				respuesta=false;
			}
		}
		else if(botonPulsado == btnRespuesta4){
			if(btnRespuesta4.getText().equals(respCorrecta)){
				respuesta=true;
			}else{
				respuesta=false;
			}
		}
		//Ya sabemos si ha acertado o fallado.
		//Mandamos respuesta.
		VentanaSolucion vs = new VentanaSolucion(respuesta,pregunta);
		vs.setVisible(true);
		this.dispose();
		
	}


}
