package concesionario.estructura;

import java.io.File;
import java.io.Serializable;

public class Gestion implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Campo para el arrayList de Coche.
	 */
	public static Concesionario concesionario = new Concesionario();

	/**
	 * Fichero
	 */
	private static File file = new File("Sin titulo");
	/**
	 * Bandera que me indica si el concesionario ha sido modificado
	 */
	private static boolean modificado;

	/**
	 * Devuelve el concesionario de coches
	 * 
	 * @return Concesionario de coches
	 */
	public static Concesionario getConcesionario() {
		return concesionario;
	}

	/**
	 * Modifica el concesionario de coches
	 * 
	 * @param concesionario Representa el nuevo concesionario de coches
	 */
	public static void setConcesionario(Concesionario concesionario) {
		Gestion.concesionario = concesionario;
	}
	
	/**
	 * Permite establecer una representación del fichero.
	 * @return file el fichero a establecer.
	 */
	public static File getFile() {
		return file;
	}
	
	/**
	 * Permite establecer una representación del fichero.
	 * @param file el fichero a establecer.
	 */
	public static void setFile(File file) {
		Gestion.file = file;
	}
	
	/**
	 * Permite establecer una modificación en el concesionario.
	 * @param modificado la modificación en el concesionario.
	 */
	public static void setModificado(boolean modificado) {
		Gestion.modificado = modificado;
	}

	/**
	 * Permite comprobar si el concesionario ha sido modificado.
	 * @return true o false, en función de si el concesionario ha sido o no modificado.
	 */
	public static boolean isModificado() {
		return modificado;
	}
}