package concesionario.estructura;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;


/**
 * Envoltorio de arrayList de coches.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class Concesionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Coche> concesionario = new ArrayList<Coche>();
	private final String NOMBRE = "I.E.S Gran Capitán";
	
	/**
	 * Añade un coche al concesionario.Si el concesionario ya contiene el coche, lanza una excepción.
	 * @param matricula la matrícula del coche a añadir.
	 * @param color el color del coche a añadir.
	 * @param modelo el modelo del coche a añadir.
	 * @throws Exception cualquier Exception checked que se lance al añadir.
	 */
	public void annadir(String matricula, Color color, Modelo modelo) throws Exception {
		Coche coche = new Coche(matricula, color, modelo);
		if (concesionario.contains(coche))
			throw new CocheYaExisteException("\n\tEl coche ya existe en el concesionario. ");
		concesionario.add(coche);
	}
	
	/**
	 * Elimina un coche del concesionario. Si la matrícula no es válida, lanza una excepción.
	 * @param matricula la matrícula del coche a eliminar.
	 * @return el coche a borrar.
	 * @throws MatriculaNoValidaException si la matrícula es inválida.
	 */
	public boolean eliminar(String matricula) throws MatriculaNoValidaException {
		return concesionario.remove(new Coche(matricula));
	}
	
	/**
	 * Devuelve el tamaño del concesionario.
	 * @return tamaño del concesionario. 
	 */
	public int tamanno() {
		return concesionario.size();
	}
	
	/**
	 * Comprueba si el concesionario está o no vacío.
	 * @return true o false, en función del estado del concesionario.
	 */
	public boolean vacio() {
		return concesionario.isEmpty();
	}
	
	/**
	 * Busca un coche por matrícula.
	 * @param matricula la matrícula por la que se busca el coche.
	 * @return el coche encontrado por esa matrícula.
	 * @throws MatriculaNoValidaException si la matrícula es inválida.
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
	 * Comprueba que la matrícula sea válida.
	 * 
	 * @param matricula la matrícula a comprobar
	 * @return true si es válida, false en caso contrario.
	 */
	public boolean comprobarMatricula(String matricula) {
		return Coche.esValida(matricula);
	}

	/**
	 * Permite iterar hacia atrás y adelante un concesionario.
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