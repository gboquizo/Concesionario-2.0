package concesionario.estructura;

import java.util.ArrayList;

import concesionario.estructura.Marca;
import concesionario.estructura.Modelo;

/**
 * 
 *<p>Representa los modelos.</p> 
 *Según el enunciado del examen:
 *Se limitarán los modelos de coches a siete:
 *	<ul>  
 * 		<li>Córdoba (marca Seat)</li>
 *  	<li>Toledo (marca Seat)</li>
 *  	<li>Ibiza (marca Seat)</li>
 *  	<li>Serie 1 (marca BMW)</li> 
 *  	<li>Serie 2 (marca BMW)</li>
 *  	<li>Serie 3 (marca BMW)</li> 
 *  	<li>Serie 5 (marca BMW)</li>
 *  </ul>
 *
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public enum Modelo {
	
	SERIE1(Marca.BMW),//Modelos, que contienen la marca, predefinidas en Enum Marca.
	SERIE2(Marca.BMW),
	SERIE3(Marca.BMW),
	SERIE5(Marca.BMW),
	CORDOBA(Marca.SEAT),
	IBIZA(Marca.SEAT),
	TOLEDO(Marca.SEAT);
	
	/**
	 * Campo de marca.	
	 */
	private Marca marca;
	
	/**
	 * Constructor singleton de modelo.
	 * @param marca la marca.
	 */
	private Modelo (Marca marca) {
		setMarca(marca);
	}
	
	/**
	 * Establece la marca del modelo.
	 * @param marca la marca del modelo.
	 */
	private void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	/**
	 * Obtiene la marca del modelo.
	 * @return marca la marca del modelo.
	 */
	public Marca getMarca(){
		return marca;
	}
		
	/**
	 * Genera las opciones del menú.
	 * 
	 * @return Opciones del menú.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[values().length];
		int i = 0;
		for (Modelo modelo : Modelo.values()) {
			opcionesMenu[i++] = modelo.name();
		}
		return opcionesMenu;
	}
	
	/**
	 * Permite obtener un modelo a partir de la marca.
	 * @return arrayModelo modelo a mostrar
	 */
	public static Object[] getModelo() {
		ArrayList<Modelo> arrayModelo = new ArrayList<Modelo>();
		for (Modelo modelo : Modelo.values()) {
			if (modelo.getMarca() == Marca.BMW) {
			arrayModelo.add(modelo);
			}
		}
		return arrayModelo.toArray();
	}
	
	/**
	 * toString de Modelo, devuelve el nombre del modelo.
	 */
	public String toString() {
		return name();
	}
}