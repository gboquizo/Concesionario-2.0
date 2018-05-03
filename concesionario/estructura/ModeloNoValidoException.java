package concesionario.estructura;

public class ModeloNoValidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ModeloNoValidoException(String mensaje) {
		super(mensaje);
	}
}