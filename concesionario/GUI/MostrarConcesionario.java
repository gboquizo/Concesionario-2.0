package concesionario.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ListIterator;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import concesionario.estructura.Coche;
import concesionario.estructura.Gestion;


/**
 * Clase que gestiona la GUI que muestra el concesionario.
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class MostrarConcesionario extends CochesGUI {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private ListIterator<Coche> iterador;
	private Coche coche;

	/**
	 * Create the dialog.
	 */
	public MostrarConcesionario() {
		setTitle("Mostrar concesionario");
		comboBox_modelo.setEnabled(false);
		combobox_marca.setEnabled(false);
		rdbtnBlue.setEnabled(false);
		rdbtnRed.setEnabled(false);
		rdbtnSilver.setEnabled(false);
		textField_Matricula.setEditable(false);
		btnOK.setVisible(false);
		btnBuscar.setVisible(false);
		btnDcha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cocheAdelante();
			}
		});

		btnIzda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cocheAtras();
			}
		});

		btnCancel.setText("Cerrar");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		iterador = Gestion.concesionario.listIterator();
		coche = iterador.next();
		mostrarCoche();
		btnIzda.setEnabled(false);
	}
	
	private void mostrarCoche() {
		textField_Matricula.setText(coche.getMatricula());
		combobox_marca.setSelectedItem(coche.getModelo().getMarca());
		comboBox_modelo.setSelectedItem(coche.getModelo());
		seleccionarColor(coche.getColor());
		comprobarBotones();
	}

	private void cocheAdelante() {
		if (iterador.hasNext()) {
			coche = iterador.next();
		}
		mostrarCoche();
	}

	private void cocheAtras() {
		if (iterador.hasPrevious()) {
			coche = iterador.previous();
		}
		mostrarCoche();
	}

	private void comprobarBotones() {
		if (!iterador.hasNext()) {
			btnDcha.setEnabled(false);
			coche = iterador.previous();
		} else {
			btnDcha.setEnabled(true);
		}
		if (!iterador.hasPrevious()) {
			btnIzda.setEnabled(false);
			coche = iterador.next();
		} else {
			btnIzda.setEnabled(true);
		}
	}
}