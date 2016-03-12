package pe.gob.servir.sistemas.alertanotificaciones.ejb.service.base.inf;

import java.io.Serializable;
import java.util.List;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.service.exception.ServicioException;
import pe.gob.servir.systems.util.retorno.ReturnObject;

public interface GenericService<T extends Serializable> {

	public ReturnObject insertar(T prmT) 		throws ServicioException;
	
	public Boolean actualizar(T prmT)  		throws ServicioException;
	
	public Boolean eliminar(T prmT)  		throws ServicioException;
	
	public List<T> listar(T prmT)  			throws ServicioException;
	
	public T buscarXId(T prmT)  			throws ServicioException;
	
}
