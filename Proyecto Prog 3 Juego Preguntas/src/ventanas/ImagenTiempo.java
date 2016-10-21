package ventanas;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenTiempo extends JPanel {

	protected ImageIcon imagenTiempo;
	protected String nombreImagen;
	
	
	
	/**
	 * Create the panel.
	 */
	/*public ImagenTiempo(String nombreImagen) {
		imagenTiempo = new ImageIcon(getClass().getResource(nombreImagen));
		setSize(imagenTiempo.getIconWidth(), imagenTiempo.getIconHeight());
		
	}

	protected void paintComponent (Graphics g){
		Dimension d = getSize();
		g.drawImage(imagenTiempo.getImage(), 0, 0, d.width,d.height,null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
	*/
	public ImagenTiempo(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}
	protected void paintComponent (Graphics g){
		Dimension d = getSize();
		imagenTiempo=new ImageIcon(getClass().getResource(nombreImagen));
		g.drawImage(imagenTiempo.getImage(), 0, 0, d.width,d.height,null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
}
