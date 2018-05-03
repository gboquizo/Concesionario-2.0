package concesionario.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;

/**
 * Clase para la ventana GUI de ayuda.
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class Ayuda extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/resources/favicon.png")));
		setResizable(false);
		setTitle("Ayuda del concesionario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 198);
		contentPanel.add(scrollPane);
		{
			JTextPane txtpnAyuda = new JTextPane();
			scrollPane.setViewportView(txtpnAyuda);
			txtpnAyuda.setEditable(false);
			txtpnAyuda.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtpnAyuda.setForeground(SystemColor.desktop);
			txtpnAyuda.setToolTipText("Desarrollado por Guillermo Boquizo Sánchez");
			txtpnAyuda.setBackground(Color.WHITE);
			txtpnAyuda.setText("\r\nAyuda del Concesionario:\r\n\r\nMenú Coche:\r\n\t- "
				+ "Alta:  \r\n\t  Crea un nuevo coche.\r\n"
				+ "\t Patrón de la matrícula: 7777-PPP, 7777PPP\r\n\r\n\t- "
				+ "Baja:  \r\n\tElimina un coche dada su matrícula\r\n\r\n\t- "
				+ "Mostrar concesionario:\r\n\tMuestra todos los coches del concesionario\r\n\r\n"
				+ "Menú Buscar:\r\n\r"
				+ "\n\t- Por matrícula:\r\n\t  "
				+ "Busca un coche dada su matrícula\r\n\r"
				+ "\n\t- Por color:\r\n\t  Busca un coche por color");
		}
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnAceptar.setToolTipText("Pulsa para salir");
		btnAceptar.setBounds(313, 229, 91, 23);
		contentPanel.add(btnAceptar);
	}
}