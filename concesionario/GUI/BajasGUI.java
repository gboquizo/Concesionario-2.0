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
 * @author Guillermo Boquizo S\u00e1nchez.
 * @version 1.0.
 *
 */
public class BajasGUI extends CochesGUI {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private int indice;

	/**
	 * Create the dialog.
	 */
	public BajasGUI() {
		modificarComportamientos();
		modificarTextos();
		actualizarBotones();
	}

	/**
	 * M\u00e9todo que permite modificar el comportamiento de la ventana.
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
	 * M\u00e9todo que muestra el coche dado su \u00edndice.
	 * 
	 * @param indice \u00edndice pasado como par\u00e1metro.
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
			int respuesta = JOptionPane.showOptionDialog(null, "Se eliminar\u00e1 el coche, \u00bfEsta seguro?",
					"\u00bfEst\u00e1 seguro de que desea eliminar?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, opciones, opciones[0]);
			if (respuesta == 0 && Gestion.concesionario.eliminar(textField_Matricula.getText())) {
				JOptionPane.showMessageDialog(contentPanel, "Coche eliminado correctamente", "INFORMACI\u00d3N",
						JOptionPane.INFORMATION_MESSAGE);
				limpiar();
				Gestion.setModificado(true);
			}
		} catch (MatriculaNoValidaException e) {
			textField_Matricula.setForeground(java.awt.Color.RED);
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "\u00a1\u00a1ERROR!!", JOptionPane.ERROR_MESSAGE);
		} catch (CocheNoExisteException e) {
			textField_Matricula.setForeground(java.awt.Color.RED);
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "\u00a1\u00a1ERROR!!", JOptionPane.ERROR_MESSAGE);
		}
	};

	/**
	 * M\u00e9todo que permite modificar los textos de la ventana.
	 */
	private void modificarTextos() {
		setTitle("Bajas de coches\r\n");
		btnCancel.setText("Cerrar");
		btnBuscar.setText("Eliminar");
	}

	/**
	 * M\u00e9todo que permite modificar el estado de visibilidad/actividad de los botones.
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