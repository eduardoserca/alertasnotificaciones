package pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.base.inf.GenericDAO;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Parametros;

import java.util.List;
import java.util.Map;

/**
 * Created by jarvis on 14/03/2016.
 */
public interface ParametrosDao extends GenericDAO<Parametros> {

    public List<Parametros> obtenerParametrosPorCodigoTabla(String codigoTabla)throws PersistenciaException;
    public Map<String, Parametros> obtenerMapaParametrosPorCodigoTabla(String codigoTabla) throws PersistenciaException;

}
