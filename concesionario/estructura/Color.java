package concesionario.estructura;

import concesionario.estructura.Color;

/**
 * 
 *<p>Representa los colores.</p> 
 *Según el enunciado del examen:
 *Se limitarán los colores de coches a tres:
 *
 *	<ul>  
 * 		<li>Rojo</li>
 *  	<li>Azul</li>
 *  	<li>Plata</li>
 *  </ul>
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public enum Color {
	
	/**
	 * Colores para los coches.
	 */
	ROJO, AZUL, PLATA;
	
	/**
	 * Método que genera las opciones de un menú de colores.
	 * @return opcionesMenu las opciones del menú de colores.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[Color.values().length];
		int i = 0;
		for (Color color : Color.values()) {
			opcionesMenu[i++] = color.name();
		}
		return opcionesMenu;
	}
}