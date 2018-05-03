package concesionario.estructura;

public class CocheYaExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public CocheYaExisteException(String mensaje) {
		super(mensaje);
	}
}