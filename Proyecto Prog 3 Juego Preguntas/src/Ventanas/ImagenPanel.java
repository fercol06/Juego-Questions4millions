package Ventanas;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenPanel extends JPanel {

	private static final long serialVersionUID = -5429845582765633705L;
	private ImageIcon imagenTiempo;
	private String nombreImagen;
	
	/**
	 * Constructor
	 * @param nombreImagen - Le pasamos el nombre de la imagen
	 */
	public ImagenPanel(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}
	/**
	 * Método que me dibuja la imagen que le hemos pasado. 
	 */
	protected void paintComponent (Graphics g){
		Dimension d = getSize();
		//Dimension d = new Dimension(getWidth(), 100);
		imagenTiempo=new ImageIcon(getClass().getResource(nombreImagen));
		g.drawImage(imagenTiempo.getImage(), 0, 0, d.width,d.height,null);
		//g.drawImage(imagenTiempo.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
}
