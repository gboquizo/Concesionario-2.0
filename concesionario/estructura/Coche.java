package concesionario.estructura;

import java.io.Serializable;
import java.util.regex.Pattern;
import concesionario.estructura.Coche;
import concesionario.estructura.Color;
import concesionario.estructura.Modelo;

/**
 *
 * <p>Representa a un coche.</p>
 * Un coche tendr\u00e1 las siguientes caracter\u00edsticas:
 * <ol>
 * 		<li>Color. Se limitar\u00e1n los colores a tres: plata, rojo y azul.</li>
 * 		<li>Modelo. Se limitar\u00e1n los modelos de coches a siete: C\u00f3rdoba (marca Seat),
 * 			Toledo (marca Seat),Ibiza (marca Seat), Serie 1 (marca BMW), Serie 2 (marca
 * 			BMW),Serie 3 (marca BMW) y Serie 5 (marca BMW). Para solicitar el modelo al
 * 			dar de alta al coche podr\u00e1 implementarse un m\u00e1todo pedirModelo que mediante
 * 			la gesti\u00f3n de un men\u00fa, devolver\u00e1 el modelo indicado.</li>
 * 		<li>Matr\u00edcula (\u00fanica por coche) El formato de las matr\u00edculas ser\u00e1 el nuevo:
 * 			combinaci\u00f3n de cuatro n\u00fameros (de 0000 a 9999) y tres letras, comenzando por
 * 			BBB y terminando por ZZZ, excluyendo vocales, la LL, la \u00f1 y la Q.
 *			<ol>
 * 				<li>Matr\u00edculas v\u00e1lidas: 0000-BBB, 0000 BBB, 0000BBB, 1234ZZZ.</li>
 * 				<li>Matr\u00edculas inv\u00e1lidas: 000_BBB, 9999-BBQ, 0000-B\u00f1B, 0000-DEF, 0000
 * 				bbb,0000 AAA</li>
 * 			</ol>
 * 		</li>
 * </ol>
 * 
 * @author Guillermo Boquizo S\u00e1nchez
 * @version 1.0
 *
 */
public class Coche implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Campo para la matr\u00edcula.
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
	 * Campo constante para el patr\u00f3n de matr\u00edcula.
	 */
	private static final Pattern patronMatricula = Pattern.compile("^\\d{4}[ -]?[[B-Zb-z]&&[^QEIOUqeiou]]{3}$");
	
	/**
	 * Constructor de coche con color, modelo y matr\u00edcula como par\u00e1metro.
	 * @param matricula la matr\u00edcula del coche.
	 * @param color el color del coche.
	 * @param modelo el modelo del coche.
	 * @throws MatriculaNoValidaException en el caso de que la matr\u00edcula sea inv\u00e1lida.
	 * @throws ColorNoValidoException en el caso de que el color sea inv\u00e1lido.
	 * @throws ModeloNoValidoException en el caso de que el modelo sea inv\u00e1lido.
	 */
	Coche(String matricula, Color color, Modelo modelo) throws MatriculaNoValidaException, ColorNoValidoException, ModeloNoValidoException {
		setMatricula(matricula);
		setModelo(modelo);
		setColor(color);
	}
	
	/**
	 * Constructor sobrecargado con matr\u00edcula como par\u00e1metro.
	 * @param matricula la matr\u00edcula del coche.
	 * @throws MatriculaNoValidaException en el caso de que la matr\u00edcula sea inv\u00e1lida.
	 */
	Coche(String matricula) throws MatriculaNoValidaException {
		setMatricula(matricula);
	}
	
	/**
	 * Obtiene la matr\u00edcula.
	 * @return matricula la matr\u00edcula obtenida.
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
	 * Establece la matr\u00edcula. Lanza una excepci\u00f3n si la matr\u00edcula es inv\u00e1lida.
	 * @param matricula la matr\u00edcula a establecer.
	 * @throws MatriculaNoValidaException si la matr\u00edcula es inv\u00e1lida.
	 */
	private void setMatricula(String matricula) throws MatriculaNoValidaException {
		if (!esValida(matricula))
			throw new MatriculaNoValidaException("\n\tLa matr\u00edcula no es v\u00e1lida.");
		this.matricula = estandarizarMatricula(matricula);

	}
	
	/**
	 * Comprueba, mediante el patr\u00f3n, si la matr\u00edcula es v\u00e1lida o no.
	 * @param matricula la matr\u00edcula a comprobar.
	 * @return true o false, en funci\u00f3n de si cumple o no con el patr\u00f3n.
	 */
	static boolean esValida(String matricula) {
		return patronMatricula.matcher(matricula).matches();
	}
	
	/**
	 * Permite estandarizar la matr\u00edcula eliminando guiones y espacios.
	 * @param matricula la matr\u00edcula a estandarizar.
	 * @return la matr\u00edcula estandarizada.
	 */
	private String estandarizarMatricula(String matricula) {
		assert esValida(matricula);
		return matricula.replaceAll("[ -]", "");
	}
	
	/**
	 * Establece el modelo. Lanza una excepci\u00f3n si el modelo es inv\u00e1lido.
	 * @param modelo el modelo a establecer.
	 * @throws ModeloNoValidoException si el modelo es inv\u00e1lido.
	 */
	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if (modelo == null)
			throw new ModeloNoValidoException("\n\tEl modelo no es v\u00e1lido.");
		this.modelo = modelo;
	}
	
	/**
	 * Establece el color. Lanza una excepci\u00f3n si el color no es v\u00e1lido.
	 * @param color color a establecer.
	 * @throws ColorNoValidoException si el color es inv\u00e1lido.
	 */
	private void setColor(Color color) throws ColorNoValidoException {
		if (color == null)
			throw new ColorNoValidoException("\n\tEl color no es v\u00e1lido.");
		this.color = color;
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