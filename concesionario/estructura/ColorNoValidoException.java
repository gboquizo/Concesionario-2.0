package concesionario.estructura;

public class ColorNoValidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ColorNoValidoException(String mensaje) {
		super(mensaje);
	}
}