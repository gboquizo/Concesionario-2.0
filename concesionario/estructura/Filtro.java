package concesionario.estructura;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * Clase que filtra el tipo de archivo por extensión.
 * 
 * @author Guillermo Boquizo Sánchez.
 * @version 1.0
 *
 */
public class Filtro extends FileFilter {

	/**
	 * Campo que almacena la extensión.
	 */
	private String extension;

	/**
	 * Campo que guarda la descripción de la extensión.
	 */
	private String descripcion;

	/**
	 * Constructor de Filtro.
	 * 
	 * @param extension extensión especificada.
	 * @param descripcion descripción de la extensión.
	 */
	public Filtro(String extension, String descripcion) {
		this.extension = extension;
		this.descripcion = descripcion;
	}

	/**
	 * Método que comprueba si los archivos son válidos.
	 * 
	 * @param file archivo seleccionado.
	 * @return devuelve true si la extensón es correcta, si no la lleva la añade.
	 */
	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}
		return file.getName().endsWith(extension);
	}

	/**
	 * Método que devuelve la descripción.
	 * 
	 * @return descripcion devuelve la descripción relativa a una extensión.
	 */
	@Override
	public String getDescription() {
		return descripcion + String.format(" (*%s)", extension);
	}

	/**
	 * Método que devuelve la extensión
	 * 
	 * @return extension la extensión devuelta.
	 */
	public String getExtension() {
		return extension;
	}
}