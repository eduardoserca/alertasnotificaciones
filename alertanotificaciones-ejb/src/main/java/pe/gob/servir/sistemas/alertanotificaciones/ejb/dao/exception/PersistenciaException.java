package pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception;

public class PersistenciaException extends Exception {

	private static final long serialVersionUID = 1L;

	public PersistenciaException(){
	}
	
	public PersistenciaException(String arg0) {
		super(arg0);
	}

	public PersistenciaException(Throwable arg0) {
		super(arg0);
	}

	public PersistenciaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PersistenciaException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		//super(arg0, arg1, arg2, arg3);
	}
	
}
