package pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.base.inf.GenericDAO;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.PerfilOpcion;

import java.util.List;

/**
 * Created by jarvis on 11/03/2016.
 */
public interface PerfilOpcionDao extends GenericDAO<PerfilOpcion> {

    public List<PerfilOpcion> listar(String usuario) throws PersistenciaException;

}
