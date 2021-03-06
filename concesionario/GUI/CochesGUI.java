package concesionario.GUI;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import concesionario.estructura.Gestion;
import concesionario.estructura.Marca;
import concesionario.estructura.Modelo;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Clase padre de todas las ventanas de tipo JDialog
 * 
 * @author Guillermo Boquizo S\u00e1nchez
 * @version 1.0
 *
 */
public class CochesGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JTextField textField_Matricula;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdbtnSilver;
	JRadioButton rdbtnBlue;
	JRadioButton rdbtnRed;
	JButton btnDcha;
	JButton btnIzda;
	JComboBox<Modelo> comboBox_modelo;
	JComboBox<Marca> combobox_marca;
	JButton btnCancel;
	JButton btnOK;
	JButton btnBuscar;


	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CochesGUI() {
		setResizable(false);
		setModal(true);
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CochesGUI.class.getResource("/resources/favicon.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBounds(10, 11, 422, 221);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(null);

		JLabel lblMatricula = new JLabel("Matr\u00edcula");
		lblMatricula.setToolTipText("A\u00f1ade una matr\u00edcula");
		lblMatricula.setBounds(10, 11, 69, 14);
		contentPanel.add(lblMatricula);

		textField_Matricula = new JTextField();
		textField_Matricula.setBounds(10, 32, 407, 20);
		contentPanel.add(textField_Matricula);
		textField_Matricula.setColumns(10);
		controlDeFoco();

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setToolTipText("Escoge un color");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Color",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 78, 204, 45);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			rdbtnRed = new JRadioButton("Rojo");
			rdbtnRed.setBackground(new Color(240, 248, 255));
			rdbtnRed.setBounds(6, 16, 53, 23);
			panel.add(rdbtnRed);
			buttonGroup.add(rdbtnRed);
			rdbtnRed.setHorizontalAlignment(SwingConstants.LEFT);
		}
		{
			rdbtnSilver = new JRadioButton("Plata");
			rdbtnSilver.setBackground(new Color(240, 248, 255));
			rdbtnSilver.setBounds(61, 16, 59, 23);
			panel.add(rdbtnSilver);
			buttonGroup.add(rdbtnSilver);
			rdbtnSilver.setHorizontalAlignment(SwingConstants.LEFT);
		}
		{
			rdbtnBlue = new JRadioButton("Azul");
			rdbtnBlue.setBackground(new Color(240, 248, 255));
			rdbtnBlue.setBounds(116, 16, 82, 23);
			panel.add(rdbtnBlue);
			rdbtnBlue.setHorizontalAlignment(SwingConstants.LEFT);
			buttonGroup.add(rdbtnBlue);
		}

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setToolTipText("Escoge la marca");
		lblMarca.setBounds(20, 133, 46, 14);
		contentPanel.add(lblMarca);

		combobox_marca = new JComboBox<Marca>();
		combobox_marca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBox_modelo.setModel(new DefaultComboBoxModel(getModelo(combobox_marca)));
			}
		});
		combobox_marca.setBounds(10, 158, 114, 29);
		contentPanel.add(combobox_marca);
		combobox_marca.setModel(new DefaultComboBoxModel(Marca.values()));

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setToolTipText("Escoge el modelo\r\n");
		lblModelo.setBounds(150, 134, 46, 14);
		contentPanel.add(lblModelo);

		comboBox_modelo = new JComboBox(new DefaultComboBoxModel(Modelo.getModelo()));
		comboBox_modelo.setBounds(150, 158, 114, 29);
		contentPanel.add(comboBox_modelo);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(302, 90, 91, 23);
		contentPanel.add(btnBuscar);
		{
			btnIzda = new JButton("<");
			btnIzda.setBounds(302, 124, 43, 23);
			contentPanel.add(btnIzda);
		}
		{
			btnDcha = new JButton(">");
			btnDcha.setBounds(350, 124, 43, 23);
			contentPanel.add(btnDcha);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(0, 232, 442, 41);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				btnCancel = new JButton("Cancelar");
				btnCancel.setBounds(316, 11, 95, 23);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});

				btnOK = new JButton("Aceptar");
				btnOK.setBounds(183, 11, 102, 23);
				btnOK.setActionCommand("OK");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnOK);
				buttonPane.add(btnCancel);
				getRootPane().setDefaultButton(btnOK);
			}
		}
	}
	
	/**
	 * Obtiene un array de modelos a partir de la marca del combobox.
	 * 
	 * @param comboMarca el combobox para la marca.
	 * @return los modelos volcados en un array.
	 */
	private Object[] getModelo(JComboBox<Marca> comboMarca) {
		Marca marca = (Marca) comboMarca.getSelectedItem();
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		for (Modelo m : Modelo.values()) {
			if (m.getMarca() == marca) {
				modelos.add(m);
			}
		}
		return modelos.toArray();
	}
	
	
	/**
	 *M\u00e9todo encargado de gestionar el foco en el campo matr\u00edcula. 
	 *
	 */
	private void controlDeFoco() {
		textField_Matricula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textField_Matricula.setText(textField_Matricula.getText().toUpperCase());
				if (!Gestion.concesionario.comprobarMatricula(textField_Matricula.getText())) {
					textField_Matricula.setText(textField_Matricula.getText());
					textField_Matricula.setForeground(java.awt.Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				textField_Matricula.setForeground(java.awt.Color.BLACK);
			}
		});
	}
	
	/**
	 * M\u00e9todo que permite obtener un color de los dados en el enum Color 
	 * en funci\u00f3n de la selecci\u00f3n en el radioButton.
	 * 
	 * @return color obtenido.
	 */
	protected concesionario.estructura.Color getSelectedColor() {
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
	 * M\u00e9todo que permite establecer el color seleccionado 
	 * dentro de un rango de valores dados en una enumeraci\u00f3n.
	 * @param color color seleccionado.
	 */
	protected void seleccionarColor(concesionario.estructura.Color color) {
		switch (color) {
		case PLATA:
			rdbtnSilver.setSelected(true);
			break;
		case ROJO:
			rdbtnRed.setSelected(true);
			break;
		case AZUL:
			rdbtnBlue.setSelected(true);
			break;
		}
	}
	
	void limpiar() {
		textField_Matricula.setText("");
		combobox_marca.setSelectedItem(null);
		comboBox_modelo.setSelectedItem(null);
		buttonGroup.clearSelection();
	}
}