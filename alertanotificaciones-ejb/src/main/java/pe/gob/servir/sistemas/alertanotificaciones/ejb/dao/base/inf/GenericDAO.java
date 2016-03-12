package pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.base.inf;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.systems.util.retorno.ReturnObject;

import java.io.Serializable;
import java.util.List;



public interface GenericDAO<T extends Serializable> {

	public ReturnObject insertar(T prmT) 	throws PersistenciaException;
	
	public Boolean actualizar(T prmT) 		throws PersistenciaException;
	
	public Boolean eliminar(T prmT) 		throws PersistenciaException;
	
	public List<T> listar(T prmT) 			throws PersistenciaException;
	
	public T buscarXId(T prmT) 				throws PersistenciaException;

}
