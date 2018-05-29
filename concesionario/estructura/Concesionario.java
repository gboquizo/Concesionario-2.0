package concesionario.estructura;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;


/**
 * Envoltorio de arrayList de coches.
 * @author Guillermo Boquizo S\u00e1nchez
 * @version 1.0
 *
 */
public class Concesionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Coche> concesionario = new ArrayList<Coche>();
	private final String NOMBRE = "I.E.S Gran Capit\u00e1n";
	
	/**
	 * A\u00f1ade un coche al concesionario.Si el concesionario ya contiene el coche, lanza una excepci\u00f3n.
	 * @param matricula la matr\u00edcula del coche a a\u00f1adir.
	 * @param color el color del coche a a\u00f1adir.
	 * @param modelo el modelo del coche a a\u00f1adir.
	 * @throws Exception cualquier Exception checked que se lance al a\u00f1adir.
	 */
	public void annadir(String matricula, Color color, Modelo modelo) throws Exception {
		Coche coche = new Coche(matricula, color, modelo);
		if (concesionario.contains(coche))
			throw new CocheYaExisteException("\n\tEl coche ya existe en el concesionario. ");
		concesionario.add(coche);
	}
	
	/**
	 * Elimina un coche del concesionario. Si la matr\u00edcula no es v\u00e1lida, lanza una excepci\u00f3n.
	 * @param matricula la matr\u00edcula del coche a eliminar.
	 * @return el coche a borrar.
	 * @throws MatriculaNoValidaException si la matr\u00edcula es inv\u00e1lida.
	 */
	public boolean eliminar(String matricula) throws MatriculaNoValidaException {
		return concesionario.remove(new Coche(matricula));
	}
	
	/**
	 * Devuelve el tama\u00f1o del concesionario.
	 * @return tama\u00f1o del concesionario. 
	 */
	public int tamanno() {
		return concesionario.size();
	}
	
	/**
	 * Comprueba si el concesionario est\u00e1 o no vac\u00edo.
	 * @return true o false, en funci\u00f3n del estado del concesionario.
	 */
	public boolean vacio() {
		return concesionario.isEmpty();
	}
	
	/**
	 * Busca un coche por matr\u00edcula.
	 * @param matricula la matr\u00edcula por la que se busca el coche.
	 * @return el coche encontrado por esa matr\u00edcula.
	 * @throws MatriculaNoValidaException si la matr\u00edcula es inv\u00e1lida.
	 * @throws CocheNoExisteException si el coche no se encuentra en el concesionario.
	 */
	public Coche buscarCoche(String matricula) throws MatriculaNoValidaException, CocheNoExisteException {
		try {
			return concesionario.get(concesionario.indexOf(new Coche(matricula)));
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new CocheNoExisteException("\n\tEl coche no existe en el concesionario");
		}
	}
	
	/**
	 * Permite buscar los coches de determinado color.
	 * @param color color por el que se busca un coche.
	 * @return listaCochesColor lista de coches de un color determinado.
	 */
	public ArrayList<Coche> buscarCocheColor(Color color) {
		ArrayList<Coche> listaCochesColor = new ArrayList<Coche>();
		for (Coche coche : concesionario) {
			if (coche.getColor() == color)
				listaCochesColor.add(coche);
		}
		return listaCochesColor;
	}
	
	/**
	 * Pasa el concesionario a un array bidimensional de string.
	 * @return array el array generado.
	 */
	public String[][] toArray() {
		String[][] array = new String[concesionario.size()][3];
		for (int i = 0; i < array.length; i++) {
			array[i][0] = concesionario.get(i).getMatricula();
			array[i][1] = String.valueOf(concesionario.get(i).getColor());
			array[i][2] = String.valueOf(concesionario.get(i).getModelo());
		}

		return array;
	}

	/**
	 * Comprueba que la matr\u00edcula sea v\u00e1lida.
	 * 
	 * @param matricula la matr\u00edcula a comprobar
	 * @return true si es v\u00e1lida, false en caso contrario.
	 */
	public boolean comprobarMatricula(String matricula) {
		return Coche.esValida(matricula);
	}

	/**
	 * Permite iterar hacia atr\u00e1s y adelante un concesionario.
	 * @return el concesionario iterable.
	 */
	public ListIterator<Coche> listIterator() {
		return concesionario.listIterator();
	}
	
	@Override
	public String toString() {
		return "\n\tConcesionario " + NOMBRE + "\n\t" + "[almacen = " + concesionario + "]";
	}
}