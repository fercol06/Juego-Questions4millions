
package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import TiposDeDatos.ConfiguracionJuego;
import TiposDeDatos.Jugador;
import TiposDeDatos.Partida;
import TiposDeDatos.Partida2;

import java.awt.Cursor;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class VentanaUsuarios extends JFrame {

	private JTextField textField;
	private ArrayList<Jugador> aUsuario;
	private ConfiguracionJuego config;
	private JButton btnComenzar, btnQuitar, btnAñadir, caractButton;
	private JSlider difslider, tiempslider, jugslider;
	private JTextPane textPane_1;
	private JSplitPane splitPane;
	private JLabel lblAjusteCaract, lblNivel, lblNumJugadores, lblTiempoPregunta;
	public static Partida partida; 
	private JScrollPane scrollPane;
	private JPanel panel;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuarios ventuser = new VentanaUsuarios();
					ventuser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaUsuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaUsuarios.class.getResource("/Images/logoCuadrado125.png")));

		// Incializar arrays
		aUsuario = new ArrayList<Jugador>();
		config = new ConfiguracionJuego();
		// Relative layout

		// getContentPane().setBackground(new Color(0, 128, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 641);
		setTitle("Configuración de la partida:");

		JPanel panel_1 = new JPanel();
		// panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setVisible(false);
		JPanel panel_2 = new JPanel();

		// ----------------------------------------------------->Comenzar

		btnComenzar = new JButton("Comenzar");
		btnComenzar.setVisible(false);
	
		btnComenzar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal.logger.log( Level.INFO, "Botón Comenzar");
				int tam = aUsuario.size();
				int tamMax = config.getNumJugadores();
				if (tam == tamMax) {
					partida = new Partida(config, aUsuario);
					textArea.append("\n Partida creada\n Comenzando...");
					//APARTIR DE AQUI JUEGO:
					setVisible(false);
					Thread t= new Thread() {
						
						@Override
						public void run() {
							partida.jugarPartida();	
						}
					};
					t.start();
					

				} else {
					textArea.append("\n Faltan más usuarios!");
				}

			}
		});
		
		//-----------------------------------------------------> Panel de texto
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		scrollPane_1.setViewportView(textArea);
				
		//-----------------------------------------------------> Panel de texto
		// panel_2.setBackground(new Color(0, 0, 255));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(182)
							.addComponent(btnComenzar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnComenzar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(11))
		);
		
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);

		JLabel lblInserteUsuario = new JLabel("Inserte Usuario");
		panel_3.add(lblInserteUsuario);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.SOUTH);

		btnQuitar = new JButton("Quitar");

		// ------------------------>Text Area

		btnQuitar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnQuitar.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String texto1=textField.getText();
					String av2= quitarUsuario(aUsuario, config, texto1);
					textArea.append("\n "+av2);
				}
		});

		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1 = textField.getText();
				// int max=6;
				String av1 = anadirUsuario(aUsuario, config, text1);
				textArea.append("\n " + av1);
				limpiarCampos();
			}
		});

		panel_4.add(btnAñadir);
		panel_4.add(btnQuitar);

		// ----------------------------------------------------->Comenzar

		splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		splitPane.setResizeWeight(0.5);
		panel_1.add(splitPane, BorderLayout.CENTER);

		textField = new JTextField();
		splitPane.setRightComponent(textField);
		textField.setColumns(10);

		textPane_1 = new JTextPane();
		splitPane.setLeftComponent(textPane_1);
		
		
		

		difslider = new JSlider();
		difslider.setMinorTickSpacing(50);
		difslider.setPaintTicks(true);
		difslider.setSnapToTicks(true);
		difslider.setName("Dificultad");

		// Label table de slider
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(new Integer(0), new JLabel("Fácil"));
		labelTable.put(new Integer(50), new JLabel("Medio"));
		labelTable.put(new Integer(100), new JLabel("Difícil"));
		difslider.setLabelTable(labelTable); // ERROR
		difslider.setPaintLabels(true);

		difslider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		difslider.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		jugslider = new JSlider();
		jugslider.setSnapToTicks(true);
		jugslider.setPaintTicks(true);
		jugslider.setMinorTickSpacing(50);
		jugslider.setName("Jugadores");
		// Label table de slider
		Hashtable<Integer, JLabel> labelTable_1 = new Hashtable<Integer, JLabel>();

		labelTable_1.put(new Integer(0), new JLabel("2"));
		labelTable_1.put(new Integer(50), new JLabel("4"));
		labelTable_1.put(new Integer(100), new JLabel("6"));
		jugslider.setLabelTable(labelTable_1); // ERROR
		jugslider.setPaintLabels(true);

		jugslider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jugslider.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		tiempslider = new JSlider();
		tiempslider.setMinorTickSpacing(50);
		tiempslider.setPaintTicks(true);
		tiempslider.setSnapToTicks(true);
		tiempslider.setName("Tiempo");
		// Label table de slider
		Hashtable<Integer, JLabel> labelTable_2 = new Hashtable<Integer, JLabel>();
		labelTable_2.put(new Integer(0), new JLabel("20"));
		labelTable_2.put(new Integer(50), new JLabel("40"));
		labelTable_2.put(new Integer(100), new JLabel("60"));
		tiempslider.setLabelTable(labelTable_2); // ERROR
		tiempslider.setPaintLabels(true);

		tiempslider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tiempslider.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		lblAjusteCaract = new JLabel("Ajustes de Caracter\u00EDsticas:");
		lblAjusteCaract.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAjusteCaract.setForeground(Color.BLACK);

		caractButton = new JButton();
		caractButton.setText("A\u00F1adir Usuarios");
		caractButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
				caractButton.setVisible(false);

				int val1 = (difslider.getValue()) * 2 / 100;
				int val2 = 2 + (jugslider.getValue()) * 4 / 100;
				int val3 = 20 + (tiempslider.getValue()) * 40 / 100;

				config = new ConfiguracionJuego(val1+1, val2, val3);
				
				VentanaPrincipal.logger.log( Level.INFO,"Dificultad "+(val1+1)+" / Jugadores "+val2+" / segundos "+val3);
				
				textPane_1.setText("Inserte Jugadores:");
				textArea.setText(config.toString());
				textPane_1.setText("\nAhora inserte los usuarios: ");
				btnComenzar.setVisible(true);

				// Escuchador botonAñadir

			}
		});

		lblNivel = new JLabel("Nivel de dificultad:");

		lblNumJugadores = new JLabel("N\u00FAmero jugadores:");

		lblTiempoPregunta = new JLabel("Tiempo por pregunta:");

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_2.createSequentialGroup().addGap(34)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAjusteCaract, GroupLayout.PREFERRED_SIZE, 199,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(caractButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(tiempslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumJugadores).addComponent(lblNivel)
								.addComponent(difslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jugslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTiempoPregunta))
						.addContainerGap(22, Short.MAX_VALUE)));
		gl_panel_2
				.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
								.addComponent(lblAjusteCaract, GroupLayout.PREFERRED_SIZE, 39,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNivel).addGap(11)
								.addComponent(difslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNumJugadores).addGap(4)
								.addComponent(jugslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblTiempoPregunta)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tiempslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(caractButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(51, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);
		getContentPane().setLayout(groupLayout);
		
		
	}

	
	public String anadirUsuario(ArrayList<Jugador> arr, ConfiguracionJuego config, String user) {

		user = user.trim();
		user = user.substring(0, 1).toUpperCase()+ user.substring(1);;
		user = user.replace(" ","");
		if (arr.size() < config.getNumJugadores() && user != null) {

			boolean repe = validateUsuario(arr, user);
			if (repe == false && 2<user.length() ) {
				VentanaPrincipal.logger.log( Level.INFO, "Usuario añadido");
				Jugador jug1 = new Jugador(user);
				arr.add(jug1);
				return "Usuario número "+arr.size()+" añadido:"+ "\n "+user;
			} else {
				if(repe == false )
					return "Tama\u00F1o minimo \n no alcanzado";
				else 
					return "Error usuario repetido\n";
			}

		}
		return "Usuarios Max alcanzados\n Comience la partida!";
	}

	public boolean validateUsuario(ArrayList<Jugador> arr, String jugador) {
		boolean repe = false;
		int i = 0;

		while (i < arr.size() && !repe) {
			String jugador1 = arr.get(i).getUser();

			if (jugador1.equals(jugador)) {
				repe = true;
			} else {
				i++;
			}

		}
		return repe;
	}
	
	public String quitarUsuario (ArrayList<Jugador> arr, ConfiguracionJuego config,String user){
		
			int i=0;
			
			while(i<arr.size()){
				String	jugador1=arr.get(i).getUser();
				
					if(jugador1.equals(user)){
						VentanaPrincipal.logger.log( Level.INFO, "Usuario quitado");
						int iaux=i;
						arr.remove(i);
						return "Usuario numero "+(iaux+1)+"\n quitado"+
								"\n Nombre: "+user+"\n Nuevo tama\u00F1o: "+arr.size();	
					}else{i++;}									
					
			}				
		
		return "Error no existe el usuario";
	}
	
	public void limpiarCampos(){
		textField.setText("");
	}
	
}


