package concesionario.estructura;

public class CocheNoExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CocheNoExisteException(String mensaje) {
		super(mensaje);
	}
}