package concesionario.estructura;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * Clase que filtra el tipo de archivo por extensi\u00f3n.
 * 
 * @author Guillermo Boquizo S\u00e1nchez.
 * @version 1.0
 *
 */
public class Filtro extends FileFilter {

	/**
	 * Campo que almacena la extensi\u00f3n.
	 */
	private String extension;

	/**
	 * Campo que guarda la descripci\u00f3n de la extensi\u00f3n.
	 */
	private String descripcion;

	/**
	 * Constructor de Filtro.
	 * 
	 * @param extension extensi\u00f3n especificada.
	 * @param descripcion descripci\u00f3n de la extensi\u00f3n.
	 */
	public Filtro(String extension, String descripcion) {
		this.extension = extension;
		this.descripcion = descripcion;
	}

	/**
	 * M\u00e9todo que comprueba si los archivos son v\u00e1lidos.
	 * 
	 * @param file archivo seleccionado.
	 * @return devuelve true si la extens\u00f3n es correcta, si no la lleva la a\u00f1ade.
	 */
	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}
		return file.getName().endsWith(extension);
	}

	/**
	 * M\u00e9todo que devuelve la descripci\u00f3n.
	 * 
	 * @return descripcion devuelve la descripci\u00f3n relativa a una extensi\u00f3n.
	 */
	@Override
	public String getDescription() {
		return descripcion + String.format(" (*%s)", extension);
	}

	/**
	 * M\u00e9todo que devuelve la extensi\u00f3n
	 * 
	 * @return extension la extensi\u00f3n devuelta.
	 */
	public String getExtension() {
		return extension;
	}
}