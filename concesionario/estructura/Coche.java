package concesionario.estructura;

import java.io.Serializable;
import java.util.regex.Pattern;
import concesionario.estructura.Coche;
import concesionario.estructura.Color;
import concesionario.estructura.Modelo;

/**
 *
 * <p>Representa a un coche.</p>
 * Un coche tendrá las siguientes características:
 * <ol>
 * 		<li>Color. Se limitarán los colores a tres: plata, rojo y azul.</li>
 * 		<li>Modelo. Se limitarán los modelos de coches a siete: Córdoba (marca Seat),
 * 			Toledo (marca Seat),Ibiza (marca Seat), Serie 1 (marca BMW), Serie 2 (marca
 * 			BMW),Serie 3 (marca BMW) y Serie 5 (marca BMW). Para solicitar el modelo al
 * 			dar de alta al coche podrá implementarse un método pedirModelo que mediante
 * 			la gestión de un menú, devolverá el modelo indicado.</li>
 * 		<li>Matrícula (única por coche) El formato de las matrículas será el nuevo:
 * 			combinación de cuatro números (de 0000 a 9999) y tres letras, comenzando por
 * 			BBB y terminando por ZZZ, excluyendo vocales, la LL, la Ñ y la Q.
 *			<ol>
 * 				<li>Matrículas válidas: 0000-BBB, 0000 BBB, 0000BBB, 1234ZZZ.</li>
 * 				<li>Matrículas inválidas: 000_BBB, 9999-BBQ, 0000-BÑB, 0000-DEF, 0000
 * 				bbb,0000 AAA</li>
 * 			</ol>
 * 		</li>
 * </ol>
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class Coche implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Campo para la matrícula.
	 */
	private String matricula;
	
	/**
	 * Campo para el color.
	 */
	private Color color;
	
	/**
	 * Campo para el modelo.
	 */
	private Modelo modelo;
	
	/**
	 * Campo constante para el patrón de matrícula.
	 */
	private static final Pattern patronMatricula = Pattern.compile("^\\d{4}[ -]?[[B-Zb-z]&&[^QEIOUqeiou]]{3}$");
	
	/**
	 * Constructor de coche con color, modelo y matrícula como parámetro.
	 * @param matricula la matrícula del coche.
	 * @param color el color del coche.
	 * @param modelo el modelo del coche.
	 * @throws MatriculaNoValidaException en el caso de que la matrícula sea inválida.
	 * @throws ColorNoValidoException en el caso de que el color sea inválido.
	 * @throws ModeloNoValidoException en el caso de que el modelo sea inválido.
	 */
	Coche(String matricula, Color color, Modelo modelo) throws MatriculaNoValidaException, ColorNoValidoException, ModeloNoValidoException {
		setMatricula(matricula);
		setModelo(modelo);
		setColor(color);
	}
	
	/**
	 * Constructor sobrecargado con matrícula como parámetro.
	 * @param matricula la matrícula del coche.
	 * @throws MatriculaNoValidaException en el caso de que la matrícula sea inválida.
	 */
	Coche(String matricula) throws MatriculaNoValidaException {
		setMatricula(matricula);
	}
	
	/**
	 * Obtiene la matrícula.
	 * @return matricula la matrícula obtenida.
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Obtiene el modelo.
	 * @return modelo el modelo obtenido.
	 */
	public Modelo getModelo() {
		return modelo;
	}
	
	/**
	 * Obtiene el color.
	 * @return color el color obtenido.
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Establece la matrícula. Lanza una excepción si la matrícula es inválida.
	 * @param matricula la matrícula a establecer.
	 * @throws MatriculaNoValidaException si la matrícula es inválida.
	 */
	private void setMatricula(String matricula) throws MatriculaNoValidaException {
		if (!esValida(matricula))
			throw new MatriculaNoValidaException("\n\tLa matrícula no es válida.");
		this.matricula = estandarizarMatricula(matricula);

	}
	
	/**
	 * Establece el modelo. Lanza una excepción si el modelo es inválido.
	 * @param modelo el modelo a establecer.
	 * @throws ModeloNoValidoException si el modelo es inválido.
	 */
	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if (modelo == null)
			throw new ModeloNoValidoException("\n\tEl modelo no es válido.");
		this.modelo = modelo;
	}
	
	/**
	 * Establece el color. Lanza una excepción si el color no es válido.
	 * @param color color a establecer.
	 * @throws ColorNoValidoException si el color es inválido.
	 */
	private void setColor(Color color) throws ColorNoValidoException {
		if (color == null)
			throw new ColorNoValidoException("\n\tEl color no es válido.");
		this.color = color;
	}
	
	/**
	 * Comprueba, mediante el patrón, si la matrícula es válida o no.
	 * @param matricula la matrícula a comprobar.
	 * @return true o false, en función de si cumple o no con el patrón.
	 */
	static boolean esValida(String matricula) {
		return patronMatricula.matcher(matricula).matches();
	}
	
	/**
	 * Permite estandarizar la matrícula eliminando guiones y espacios.
	 * @param matricula la matrícula a estandarizar.
	 * @return la matrícula estandarizada.
	 */
	private String estandarizarMatricula(String matricula) {
		assert esValida(matricula);
		return matricula.replaceAll("[ -]", "");
	}
	
	/**
	 * hashCode para implementar el contains de coche.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	
	/**
	 * Equals para implementar el contains de coche.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equalsIgnoreCase(other.matricula))
			return false;
		return true;
	}
	
	/**
	 * toString de Coche.
	 */
	@Override
	public String toString() {
		return "Coche [matricula = " + matricula.toUpperCase() + ", color = " + color + ", modelo = " + modelo + "]";
	}
}