package pe.gob.servir.sistemas.alertanotificaciones.ejb.service.bean;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf.ParametrosDao;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto.ParametrosRemoto;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Parametros;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;

/**
 * Created by jarvis on 15/03/2016.
 */
@Stateless(mappedName = "ParametrosEJB")
public class ParametrosBean implements ParametrosRemoto {

    @EJB
    private ParametrosDao parametrosDao;

    @Override
    public List<Parametros> obtenerParametrosPorCodigoTabla(String codigoTabla) throws PersistenciaException {
        return parametrosDao.obtenerParametrosPorCodigoTabla(codigoTabla);
    }

    @Override
    public Map<String, Parametros> obtenerMapaParametrosPorCodigoTabla(String codigoTabla) throws PersistenciaException {
        return parametrosDao.obtenerMapaParametrosPorCodigoTabla(codigoTabla);
    }
}
