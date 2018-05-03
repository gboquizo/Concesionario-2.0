package concesionario.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import concesionario.estructura.Coche;

import concesionario.estructura.CocheNoExisteException;
import concesionario.estructura.Gestion;
import concesionario.estructura.MatriculaNoValidaException;

/**
 * Clase que permite buscar por matrícula un coche.
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class BuscarPorMatricula extends CochesGUI {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private int indice;

	/**
	 * Create the dialog.
	 */
	public BuscarPorMatricula() {
		actualizarTextos();
		comprobarBotones();
		actualizarPanel();
		comprobarMatricula();
	}

	/**
	 * Método que comprueba que la matrícula sea válida, y muestra el coche por
	 * índice, si existe en el concesionario.
	 */
	private void comprobarMatricula() {
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Gestion.concesionario.comprobarMatricula(textField_Matricula.getText()))
					mostrarCoche(indice);
				else
					JOptionPane.showMessageDialog(null, "¡Matrícula no válida!", "Aceptar", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	/**
	 * Método que permite actualizar el panel.
	 */
	private void actualizarPanel() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

	/**
	 * Método que permite actualizar los textos de la ventana.
	 */
	private void actualizarTextos() {
		setTitle("Buscar por matrícula");
		btnCancel.setText("Cerrar");
	}

	/**
	 * Método que permite comprobar el estado de habilitación/visibilidad de los
	 * botones de la ventana.
	 */
	private void comprobarBotones() {
		btnIzda.setVisible(false);
		btnDcha.setVisible(false);
		btnOK.setVisible(false);
		comboBox_modelo.setEnabled(false);
		combobox_marca.setEnabled(false);
		rdbtnBlue.setEnabled(false);
		rdbtnRed.setEnabled(false);
		rdbtnSilver.setEnabled(false);
	}

	/**
	 * Método que permite mostrar un coche por el índice del mismo.
	 * 
	 * @param indiceCoche id del coche
	 */
	private void mostrarCoche(int indiceCoche) {
		textField_Matricula.setForeground(java.awt.Color.BLACK);
		try {
			Coche coche = Gestion.concesionario.buscarCoche(textField_Matricula.getText());
			seleccionarColor(coche.getColor());
			combobox_marca.setSelectedItem(coche.getModelo().getMarca());
			comboBox_modelo.setSelectedItem(coche.getModelo());
		} catch (MatriculaNoValidaException e) {
			textField_Matricula.setForeground(java.awt.Color.RED);
			e.printStackTrace();
		} catch (CocheNoExisteException e) {
			JOptionPane.showMessageDialog(null, "¡No existe ningun coche con esa matricula!", "Aceptar",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}