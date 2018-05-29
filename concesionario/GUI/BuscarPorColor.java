package concesionario.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import concesionario.estructura.Coche;
import concesionario.estructura.Color;
import concesionario.estructura.Gestion;

/**
 * Clase que permite la b\u00fasqueda por color.
 * 
 * @author Guillermo Boquizo S\u00e1nchez.
 * @version 1.0
 *
 */
public class BuscarPorColor extends CochesGUI {

	private static final long serialVersionUID = 1L;
	private ListIterator<Coche> it;
	private Coche coche;

	/**
	 * Create the dialog.
	 */
	public BuscarPorColor() {
		actualizarTextos();
		comprobarBotones();
		actualizarPane();
		actualizarEventos();
	}
	/**
	 * M\u00e9todo que permite seleccionar un color entre las opciones dadas en la enumeraci\u00f3n
	 * @return un color de la selecci\u00f3n dada.
	 */
	private Color seleccionarColor() {
		if (rdbtnRed.isSelected()) {
			return concesionario.estructura.Color.ROJO;
		} else if (rdbtnSilver.isSelected()) {
			return concesionario.estructura.Color.PLATA;
		} else if (rdbtnBlue.isSelected()) {
			return concesionario.estructura.Color.AZUL;
		} else {
			return null;
		}
	}
	/**
	 * M\u00e9todo que permite mostrar un coche.
	 * 
	 */
	private void mostrarCoche() {
		textField_Matricula.setText(coche.getMatricula());
		combobox_marca.setSelectedItem(coche.getModelo().getMarca());
		comboBox_modelo.setSelectedItem(coche.getModelo());
		textField_Matricula.setForeground(java.awt.Color.BLACK);
		seleccionarColor(coche.getColor());
		comprobarBtnDesplazamiento();
	}

	/**
	 * M\u00e9todo que permite comprobar el estado de habilitaci\u00f3n/inhabilitaci\u00f3n de
	 * los botones principales.
	 */
	private void comprobarBotones() {
		btnDcha.setEnabled(false);
		btnIzda.setEnabled(false);
		btnOK.setVisible(false);
		comboBox_modelo.setEnabled(false);
		combobox_marca.setEnabled(false);
		textField_Matricula.setEditable(false);
	}

	/**
	 * M\u00e9todo que comprueba el estado de habilitaci\u00f3n/inhabilitaci\u00f3n de los
	 * botones de desplazamiento.
	 */
	private void comprobarBtnDesplazamiento() {
		if (!it.hasNext()) {
			btnDcha.setEnabled(false);
			coche = it.previous();
		} else {
			btnDcha.setEnabled(true);
		}
		if (!it.hasPrevious()) {
			btnIzda.setEnabled(false);
			coche = it.next();
		} else {
			btnIzda.setEnabled(true);
		}
	}
	
	/**
	 * M\u00e9todo que permite iterar hacia adelante .
	 */
	private void cocheAdelante() {
		if (it.hasNext()) {
			coche = it.next();
		}
		mostrarCoche();
	}

	/**
	 * M\u00e9todo que permite iterar hacia atr\u00e1s.
	 */
	private void cocheAtras() {
		if (it.hasPrevious()) {
			coche = it.previous();
		}
		mostrarCoche();
	}

	/**
	 * M\u00e9todo que permite actualizar dimensiones y layout del panel.
	 */
	private void actualizarPane() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
	}

	/**
	 * M\u00e9todo que permite actualizar los textos de la ventana.
	 */
	private void actualizarTextos() {
		setTitle("Mostrar por color");
		btnCancel.setText("Cerrar");
	}

	/**
	 * M\u00e9todo que actualiza los eventos asociados a los botones principales de la ventana.
	 */
	private void actualizarEventos() {
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					it = Gestion.concesionario.buscarCocheColor(seleccionarColor()).listIterator();
					coche = it.next();
					mostrarCoche();
					btnIzda.setEnabled(false);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "\u00a1No hay coches del color seleccionado!", "Atenci\u00f3n",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		/**
		 * M\u00e9todo que gestiona el comportamiento del bot\u00f3n derecho.
		 */
		btnDcha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cocheAdelante();
			}
		});

		/**
		 * M\u00e9todo que gestiona el comportamiento del bot\u00f3n izquierdo.
		 *
		 */
		btnIzda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cocheAtras();
			}
		});
	}
}