package concesionario.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;

import concesionario.estructura.CocheYaExisteException;
import concesionario.estructura.Color;
import concesionario.estructura.ColorNoValidoException;
import concesionario.estructura.Gestion;
import concesionario.estructura.MatriculaNoValidaException;
import concesionario.estructura.Modelo;
import concesionario.estructura.ModeloNoValidoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase que gestiona la GUI de altas del concesionario.
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class AltasGUI extends CochesGUI {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public AltasGUI() {

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltasGUI.class.getResource("/resources/favicon.png")));
		setModal(true);
		setResizable(false);
		setTitle("Altas de coches\r\n");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		btnCancel.setText("Cerrar");
		btnBuscar.setText("Añadir");
		btnIzda.setVisible(false);
		btnDcha.setVisible(false);
		btnOK.setVisible(false);
		contentPanel.setBackground(java.awt.Color.WHITE);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		annadir();
	}

	
	/**
	 * Método que permite seleccionar el color, sobrescrito de la ventana padre CochesGUI.
	 */
	@Override
	protected Color getSelectedColor() {
		return super.getSelectedColor();
	}

	/**
	 * Método encargado de gestionar el comportamiento de los eventos vinculados al botón que añade al concesionario.
	 */
	private void annadir() {
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Gestion.concesionario.annadir(textField_Matricula.getText(), getSelectedColor(),
							(Modelo) comboBox_modelo.getSelectedItem());
					textField_Matricula.setText("");
					Gestion.setModificado(true);
				} catch (ColorNoValidoException | ModeloNoValidoException | MatriculaNoValidaException | CocheYaExisteException e) {
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
}