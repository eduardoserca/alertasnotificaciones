package pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.base.inf.GenericDAO;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Usuario;

/**
 * Created by jarvis on 11/03/2016.
 */
public interface UsuarioDao extends GenericDAO<Usuario> {

    public Integer accederSistema(Usuario usuario) throws PersistenciaException;

}
