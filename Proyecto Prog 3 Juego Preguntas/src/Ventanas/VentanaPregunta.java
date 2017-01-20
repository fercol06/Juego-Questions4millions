package Ventanas;


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
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JSeparator;

public class VentanaPregunta extends JFrame implements ActionListener{


	private static final long serialVersionUID = -861869990532028500L;
	private JPanel panel_norte,panel_sur,panel_centro,panel_derecho;
	private JPanel panel, panel_11,panel_12,panel_21,panel_22;
	private JButton btnRespuesta1, btnRespuesta2, btnRespuesta3, btnRespuesta4;
	private JLabel lblPregunta, lblUsuario;
	public static JPanel panel_Iniciar,panelWest;
	private Pregunta pregunta;
	private JLabel lblNomUsuario;
	private boolean respuesta;
	public static JLabel lblimg;
	private int tiempoPregunta;
	private ThreadTiempo th;
	public static boolean estado;
	private JPanel panel_1;
	private JSeparator separator;
	  
	/**
	 * Crea la ventana pregunta a la que se le pasa la pregunta aleatoria
	 * y el tiempo que tiene para contestar
	 * @param preguntaAleatoria - Un objeto de tipo Pregunta. 
	 * @param tiempo - Tiempo para la partida. 
	 */
	public VentanaPregunta(Pregunta preguntaAleatoria,int tiempo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPregunta.class.getResource("/Images/logoCuadrado125.png")));
		this.pregunta=preguntaAleatoria;
		this.tiempoPregunta=tiempo;
		estado=false;
		
		setBounds(100, 100, 745, 450);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setTitle("Questions4millions");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Atenci\u00F3n, \u00A1pregunta!");
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel_Iniciar = new JPanel();
		getContentPane().add(panel_Iniciar, BorderLayout.CENTER);
		panel_Iniciar.setLayout(new BorderLayout(0, 0));
		
		
		
		panel_norte = new JPanel();
		panel_Iniciar.add(panel_norte, BorderLayout.NORTH);
		panel_norte.setLayout(new GridLayout(2, 1, 0, 0));
		
		panel_1 = new JPanel();
		panel_norte.add(panel_1);
		
		lblUsuario = new JLabel("Turno para: ");
		panel_1.add(lblUsuario);
		lblUsuario.setFont(new Font("Tahoma", Font.ITALIC, 16));
		
		//
		lblNomUsuario = new JLabel(Partida.jugadorTurno.getUser().substring(0, 1).toUpperCase()+ Partida.jugadorTurno.getUser().substring(1));
		//lblNomUsuario = new JLabel(Partida.jugadorTurno.getUser());
		panel_1.add(lblNomUsuario);
		lblNomUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		separator = new JSeparator();
		panel_norte.add(separator);
		
	
		panel_derecho = new JPanel();
		panel_Iniciar.add(panel_derecho, BorderLayout.EAST);
	
		panelWest = new JPanel();
		
		
		panel_Iniciar.add(panelWest,BorderLayout.WEST);
		
		lblimg = new JLabel("");
		lblimg.setIcon(new ImageIcon(VentanaPregunta.class.getResource("/Images/Progreso000.png")));
		panelWest.add(lblimg);
		
		panel_centro = new JPanel();
		panel_Iniciar.add(panel_centro, BorderLayout.CENTER);
		
		/* ---
		 * 
		 * AQUIIII
		 * 
		 * 
		 */
		lblPregunta = new JLabel(preguntaAleatoria.getPregunta());
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
		
		btnRespuesta1 = new JButton(preguntaAleatoria.getResp1());
		panel_11.add(btnRespuesta1);
		btnRespuesta1.addActionListener(this);
		
		panel_12 = new JPanel();
		panel.add(panel_12);
		
		btnRespuesta2 = new JButton(preguntaAleatoria.getResp2());
		panel_12.add(btnRespuesta2);
		btnRespuesta2.addActionListener(this);
		
		panel_21 = new JPanel();
		panel.add(panel_21);
		
		btnRespuesta3 = new JButton(preguntaAleatoria.getResp3());
		panel_21.add(btnRespuesta3);
		btnRespuesta3.addActionListener(this);
		
		panel_22 = new JPanel();
		panel.add(panel_22);
		
		btnRespuesta4 = new JButton(preguntaAleatoria.getResp4());
		panel_22.add(btnRespuesta4);
		btnRespuesta4.addActionListener(this);
		
		
		th = new ThreadTiempo(tiempoPregunta,this,pregunta);
		th.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado =(JButton) e.getSource();
		String respCorrecta= pregunta.getRespCorrecta();
		estado=true;
		
		if(botonPulsado == btnRespuesta1){
			if(btnRespuesta1.getText().equals(respCorrecta)){
				respuesta=true;
			}else{
				respuesta=false;
			}
		}
		else if(botonPulsado == btnRespuesta2){
			String text=btnRespuesta2.getText();
			if(text.equals(respCorrecta)){
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
		if(th.isAlive()){
			th.stop();
		}
		
		//Ya sabemos si ha acertado o fallado.
		//Mandamos respuesta.
		VentanaSolucion vs = new VentanaSolucion(respuesta,pregunta);
		vs.setVisible(true);
		this.dispose();	
	}
	

	/**
	 * M�todo que devuelve una cadena separada por saltos de linea.
	 * @param  pasas una pregunta
	 * @return pregunta devuelve una pregunta con espacios.
	 */
	/*
	public String separarLetras(String pregunta){
		
		int cont=0;
		int numMax=80;
		String caracter=" ";
		String preguntaEntera=pregunta;
		String suplente="";
		
		String[] palabrasSeparadas = preguntaEntera.split(caracter);
		
		if(preguntaEntera.length()>numMax){
			for(int i=0; i<palabrasSeparadas.length; i++){
				cont=cont+palabrasSeparadas[i].length()+1;
				suplente=suplente.concat(palabrasSeparadas[i]);
				suplente=suplente.concat(" ");
				if(cont>70){
					if(palabrasSeparadas[i+1].length()<10){
						suplente=suplente.concat(palabrasSeparadas[i+1]);
						i++;
					}
					suplente=suplente.concat("\n");
					cont=0;
				}
			}
		}
		
		return suplente;
	}
	 */	
	
	/**
	 * M�todo que recibe un String y devuelve el n�mero de palabras que contiene
	 * @param s. Recive una cadena 
	 * @return Devuelve un numero de palabras
	 */
	public static int contarPalabras(String s) {
	    int contador = 1, pos;
	    s = s.trim(); //eliminar los posibles espacios en blanco al principio y al final
	    if (s.isEmpty()) { //si la cadena est� vac�a
	    	contador = 0;
	    } else {
	    	pos = s.indexOf(" "); //se busca el primer espacio en blanco
	    	while (pos != -1) { //mientras que se encuentre un espacio en blanco
	    		contador++; //se cuenta una palabra
	    		pos = s.indexOf(" ", pos + 1); //se busca el siguiente espacio en blanco
	    	}                                               //a continuaci�n del actual
	    }
	    return contador;
	}

}
