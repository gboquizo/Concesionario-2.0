package concesionario.GUI;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * Permite generar el fondo principal para la aplicaci\u00f3n.
 * @author Guillermo Boquizo S\u00e1nchez
 * @version 1.0
 *
 */
public class FondoPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public FondoPrincipal() {
		this.setSize(800, 560);
	}

	@Override
	public void paintComponent(Graphics g) {
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/resources/images.jpg"));
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}