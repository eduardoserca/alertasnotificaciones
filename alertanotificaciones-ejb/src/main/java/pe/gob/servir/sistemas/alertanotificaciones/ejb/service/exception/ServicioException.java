package pe.gob.servir.sistemas.alertanotificaciones.ejb.service.exception;

public class ServicioException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServicioException() {
	}

	public ServicioException(String arg0) {
		super(arg0);
	}

	public ServicioException(Throwable arg0) {
		super(arg0);
	}

	public ServicioException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ServicioException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		//super(arg0, arg1, arg2, arg3);
	}
	
}
