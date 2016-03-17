package pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Parametros;

import javax.ejb.Remote;
import java.util.List;
import java.util.Map;

/**
 * Created by jarvis on 15/03/2016.
 */
@Remote
public interface ParametrosRemoto {

    public List<Parametros> obtenerParametrosPorCodigoTabla(String codigoTabla) throws PersistenciaException;
    public Map<String, Parametros> obtenerMapaParametrosPorCodigoTabla(String codigoTabla) throws PersistenciaException;

}
