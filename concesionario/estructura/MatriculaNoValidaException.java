package concesionario.estructura;

public class MatriculaNoValidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public MatriculaNoValidaException(String mensaje) {
		super(mensaje);
	}
}