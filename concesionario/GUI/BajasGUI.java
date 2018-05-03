package concesionario.GUI;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import concesionario.estructura.Coche;
import concesionario.estructura.CocheNoExisteException;
import concesionario.estructura.Gestion;
import concesionario.estructura.MatriculaNoValidaException;

import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase que gestiona la GUI de bajas del concesionario.
 * 
 * @author Guillermo Boquizo Sánchez.
 * @version 1.0.
 *
 */
public class BajasGUI extends CochesGUI {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private int indice = 0;

	/**
	 * Create the dialog.
	 */
	public BajasGUI() {
		modificarComportamientos();
		modificarTextos();
		actualizarBotones();
	}

	/**
	 * Método que permite modificar el comportamiento de la ventana.
	 */
	private void modificarComportamientos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BajasGUI.class.getResource("/resources/favicon.png")));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		FlowLayout fl_contentPanel = new FlowLayout();
		fl_contentPanel.setAlignOnBaseline(true);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setLayout(fl_contentPanel);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCoche(indice);
			}
		});
	}

	/**
	 * Método que muestra el coche dado su índice.
	 * 
	 * @param indice índice pasado como parámetro.
	 */
	private void mostrarCoche(int indice) {

		try {
			Coche coche = Gestion.concesionario.buscarCoche(textField_Matricula.getText());
			textField_Matricula.setForeground(java.awt.Color.BLACK);
			textField_Matricula.setText(coche.getMatricula());
			combobox_marca.setSelectedItem(coche.getModelo().getMarca());
			comboBox_modelo.setSelectedItem(coche.getModelo());
			seleccionarColor(coche.getColor());

			Object[] opciones = { "Eliminar", "Cancelar" };
			int respuesta = JOptionPane.showOptionDialog(null, "Se eliminará el coche, ¿Esta seguro?",
					"¿Está seguro de que desea eliminar?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, opciones, opciones[0]);
			if (respuesta == 0 && Gestion.concesionario.eliminar(textField_Matricula.getText())) {
				JOptionPane.showMessageDialog(contentPanel, "Coche eliminado correctamente", "INFORMACIÓN",
						JOptionPane.INFORMATION_MESSAGE);
				textField_Matricula.setText("");
				Gestion.setModificado(true);
			}
		} catch (MatriculaNoValidaException e) {
			textField_Matricula.setForeground(java.awt.Color.RED);
		} catch (CocheNoExisteException e) {
			JOptionPane.showMessageDialog(null, "¡No existe ningun coche con esa matricula!", "Aceptar",
					JOptionPane.ERROR_MESSAGE);
		}
	};

	/**
	 * Método que permite modificar los textos de la ventana.
	 */
	private void modificarTextos() {
		setTitle("Bajas de coches\r\n");
		btnCancel.setText("Cerrar");
		btnBuscar.setText("Eliminar");
	}

	/**
	 * Método que permite modificar el estado de visibilidad/actividad de los botones.
	 */
	private void actualizarBotones() {
		
		comboBox_modelo.setEnabled(false);
		combobox_marca.setEnabled(false);
		rdbtnBlue.setEnabled(false);
		rdbtnRed.setEnabled(false);
		rdbtnSilver.setEnabled(false);
		
		btnOK.setVisible(false);
		btnIzda.setVisible(false);
		btnDcha.setVisible(false);
	}
}
