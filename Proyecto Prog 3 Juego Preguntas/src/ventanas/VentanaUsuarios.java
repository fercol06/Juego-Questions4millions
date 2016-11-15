
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
import java.util.Dictionary;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import TiposDeDatos.ConfiguracionJuego;
import TiposDeDatos.Partida;

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
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
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
		
		btnQuitar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JButton btnAñadir = new JButton("A\u00F1adir");
		
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//Escuchador botonAñadir
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnAñadir);
		panel_4.add(btnQuitar);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(0.6);
		panel_1.add(splitPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		splitPane.setRightComponent(textField);
		textField.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		splitPane.setLeftComponent(textPane_1);
		
		//Devuelve el numero de usuarios insertados hasta ahora
		
		
		
	
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Inserte las características de la partida: ");
		
		textPane.setBackground(Color.BLACK);
		textPane.setForeground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
				.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
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
		labelTable_2.put( new Integer( 0 ), new JLabel("30") );
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
				ConfiguracionJuego config = new ConfiguracionJuego();
				textPane_1.setText("Inserte Jugadores:");
				
				
			}
		});
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(127)
					.addComponent(caractButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(111, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(46, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(tiempslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(difslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAjusteCaract, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
						.addComponent(jugslider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35))
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
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(caractButton, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		getContentPane().setLayout(groupLayout);
	}
}

