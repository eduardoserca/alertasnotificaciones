package pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.base.inf.GenericDAO;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Perfil;

import java.util.List;

/**
 * Created by jarvis on 13/03/2016.
 */
public interface PerfilDao extends GenericDAO<Perfil> {

    public List<Perfil> obtenerPerfilPorEstado(Perfil perfil) throws PersistenciaException;

}
