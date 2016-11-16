
package ventanas;
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
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import TiposDeDatos.ConfiguracionJuego;
import TiposDeDatos.Partida;
import TiposDeDatos.Usuario;

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

@SuppressWarnings("serial")
public class VentanaUsuarios extends JFrame {

	private JTextField textField;
	private ArrayList<Usuario> aUsuario=new ArrayList<Usuario>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					VentanaUsuarios frame = new VentanaUsuarios();
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
	public VentanaUsuarios() {
		
		// Relative layout 

		getContentPane().setBackground(new Color(0, 128, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 528);
		
		JPanel panel =  new JPanel();
		panel.setBackground(Color.BLACK);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setVisible(false);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 255));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblInserteUsuario = new JLabel("Inserte Usuario");
		panel_3.add(lblInserteUsuario);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnQuitar = new JButton("Quitar");

//------------------------>Text Area
		
		JTextArea textPane = new JTextArea();
		textPane.setText(" Inserte las características"
						+ "\n de la partida: ");
		textPane.setBackground(Color.BLACK);
		textPane.setForeground(Color.WHITE);

//------------------------>Text Area
				
		btnQuitar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JButton btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1 =textField.getText();
				int max=6;
				String av1= anadirUsuario(aUsuario,max,text1);
				textPane.append("\n "+av1);
			}
		});
		
		
		panel_4.add(btnAñadir);
		panel_4.add(btnQuitar);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		splitPane.setResizeWeight(0.5);
		panel_1.add(splitPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		splitPane.setRightComponent(textField);
		textField.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		splitPane.setLeftComponent(textPane_1);
		
		//Devuelve el numero de usuarios insertados hasta ahora
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 162, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
					.addGap(16))
		);
		panel.setLayout(gl_panel);
		
			
		
		
		
		JSlider difslider = new JSlider();
		difslider.setMinorTickSpacing(50);
		difslider.setPaintTicks(true);
		difslider.setSnapToTicks(true);
		difslider.setName("Dificultad");
		
		//Label table de slider
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put( new Integer( 0 ), new JLabel("Facil") );
		labelTable.put( new Integer( 50 ), new JLabel("Medio") );
		labelTable.put( new Integer( 100 ), new JLabel("Dificil") );
		difslider.setLabelTable( labelTable ); //ERROR
		difslider.setPaintLabels(true);
		
		difslider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		difslider.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JSlider jugslider = new JSlider();
		jugslider.setSnapToTicks(true);
		jugslider.setPaintTicks(true);
		jugslider.setMinorTickSpacing(50);
		jugslider.setName("Jugadores");
		//Label table de slider
				Hashtable<Integer, JLabel> labelTable_1 = new Hashtable<Integer, JLabel>();
				
				labelTable_1.put( new Integer( 0 ), new JLabel("2") );
				labelTable_1.put( new Integer( 50 ), new JLabel("4") );
				labelTable_1.put( new Integer( 100 ), new JLabel("6") );
				jugslider.setLabelTable( labelTable_1 ); //ERROR
				jugslider.setPaintLabels(true);
				
		jugslider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jugslider.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JSlider tiempslider = new JSlider();
		tiempslider.setMinorTickSpacing(50);
		tiempslider.setPaintTicks(true);
		tiempslider.setSnapToTicks(true);
		tiempslider.setName("Tiempo");
		//Label table de slider
		Hashtable<Integer, JLabel> labelTable_2= new Hashtable<Integer, JLabel>();
		labelTable_2.put( new Integer( 0 ), new JLabel("20") );
		labelTable_2.put( new Integer( 50 ), new JLabel("40") );
		labelTable_2.put( new Integer( 100 ), new JLabel("60") );
		tiempslider.setLabelTable( labelTable_2 ); //ERROR
		tiempslider.setPaintLabels(true);
		
		tiempslider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tiempslider.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		
		JLabel lblAjusteCaract = new JLabel("AJUSTE CARACTERISTICA");
		lblAjusteCaract.setForeground(Color.WHITE);
		
		JButton caractButton = new JButton();
		caractButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
				caractButton.setVisible(false);
				
				int val1= difslider.getValue();
				int val2= jugslider.getValue();
				int val3= tiempslider.getValue();
				
				ConfiguracionJuego config = new ConfiguracionJuego(val1,val2,val3);
				ArrayList<Usuario> impUsuarios= new ArrayList<>();
				textPane_1.setText("Inserte Jugadores:");
				textPane.setText(config.toString());
				textPane_1.setText("\n Ahora inserte los usuarios: ");
				Partida part=new Partida(config,impUsuarios);
				
					btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					//Escuchador botonAñadir
					
			}
		});
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(tiempslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(difslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAjusteCaract, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
								.addComponent(jugslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(35))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(caractButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(112))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(lblAjusteCaract, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(difslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(jugslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(tiempslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(caractButton, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		getContentPane().setLayout(groupLayout);
	}
	public String anadirUsuario (ArrayList<Usuario> arr, int Max,String user ){
		if(arr.size()<Max && user!=null){
			Usuario us1=new Usuario(user);
			arr.add(us1);
			
			return "Usuario numero: "+arr.size()+" añadido:"+
					"\n "+user;
					
		}else	{return "error";}
	}
}

