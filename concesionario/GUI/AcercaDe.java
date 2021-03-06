package concesionario.GUI;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * Clase para la ventana GUI AcercaDe.
 * 
 * @author Guillermo Boquizo S\u00e1nchez.
 * @version 1.0
 *
 */
public class AcercaDe extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		getContentPane().setBackground(new Color(102, 205, 170));
		setTitle("Acerca de...\r\n");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcercaDe.class.getResource("/resources/favicon.png")));
		setResizable(false);
		setBounds(100, 100, 605, 550);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblAcercaDe = new JLabel(
				"<html>\r\n<h1>I.E.S Gran Capit\u00e1n, 2018</h1>\t\r\n\r\n<h2>Concesionario de coches.</h2>\r\n<ul>\r\n\t<li>Desarrollado por:</li>\r\n\t\t\r\n\t\t\t<p>Guillermo Boquizo S\u00e1nchez</p>\r\n\r\n\t\t\t<p>Versi\u00f3n: 1.0</p>\r\n\t\r\n\t\t\t<p>Abril - Mayo 2018</p>\r\n</ul>\r\n</html>");
		lblAcercaDe.setForeground(new Color(0, 0, 0));
		lblAcercaDe.setBounds(10, 11, 424, 185);
		getContentPane().add(lblAcercaDe);
		lblAcercaDe.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblimagen = new JLabel("");
		lblimagen.setForeground(Color.WHITE);
		lblimagen.setBounds(35, 195, 414, 300);
		getContentPane().add(lblimagen);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setLayout(null);
		panel.setBounds(456, 403, 133, 92);
		getContentPane().add(panel);

		JButton btnSalir = new JButton("Aceptar");
		btnSalir.setToolTipText("Permite salir de esta ventana");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(10, 33, 117, 48);
		panel.add(btnSalir);
		lblimagen.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/resources/coche.gif")));
	}
}