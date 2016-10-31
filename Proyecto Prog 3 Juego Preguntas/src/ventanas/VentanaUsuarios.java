
package ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;
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
import java.util.Dictionary;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class VentanaUsuarios extends JFrame {

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
		panel.setBackground(new Color(0, 0, 205));
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		
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
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(167, Short.MAX_VALUE)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JTextArea textArea = new JTextArea();
		
		JButton btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(32)
					.addComponent(btnAñadir)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(btnEliminar)
					.addGap(24))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(63, Short.MAX_VALUE)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(51))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(32)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAñadir)
						.addComponent(btnEliminar))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JSlider slider = new JSlider();
		slider.setMinorTickSpacing(50);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setName("Dificultad");
		
		//Label table de slider
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put( new Integer( 0 ), new JLabel("Facil") );
		labelTable.put( new Integer( 50 ), new JLabel("Medio") );
		labelTable.put( new Integer( 100 ), new JLabel("Dificil") );
		slider.setLabelTable( labelTable ); //ERROR
		slider.setPaintLabels(true);
		
		slider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		slider.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JSlider slider_1 = new JSlider();
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setMinorTickSpacing(50);
		slider_1.setName("Jugadores");
		//Label table de slider
				Hashtable<Integer, JLabel> labelTable_1 = new Hashtable<Integer, JLabel>();
				
				labelTable_1.put( new Integer( 0 ), new JLabel("2") );
				labelTable_1.put( new Integer( 50 ), new JLabel("4") );
				labelTable_1.put( new Integer( 100 ), new JLabel("6") );
				slider_1.setLabelTable( labelTable_1 ); //ERROR
				slider_1.setPaintLabels(true);
				
		slider_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		slider_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JSlider slider_2 = new JSlider();
		slider_2.setMinorTickSpacing(50);
		slider_2.setPaintTicks(true);
		slider_2.setSnapToTicks(true);
		slider_2.setName("Tiempo");
		//Label table de slider
		Hashtable<Integer, JLabel> labelTable_2= new Hashtable<Integer, JLabel>();
		labelTable_2.put( new Integer( 0 ), new JLabel("30") );
		labelTable_2.put( new Integer( 50 ), new JLabel("40") );
		labelTable_2.put( new Integer( 100 ), new JLabel("60") );
		slider_2.setLabelTable( labelTable_2 ); //ERROR
		slider_2.setPaintLabels(true);
		
		slider_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		slider_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		
		JLabel lblAjusteCaract = new JLabel("AJUSTE CARACTERISTICA");
		lblAjusteCaract.setForeground(Color.WHITE);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						
						.addComponent(slider_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(43, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(38, Short.MAX_VALUE)
					.addComponent(lblAjusteCaract, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAjusteCaract, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					
					.addGap(29)
					.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(slider_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		panel_2.setLayout(gl_panel_2);
		getContentPane().setLayout(groupLayout);
	}
}

