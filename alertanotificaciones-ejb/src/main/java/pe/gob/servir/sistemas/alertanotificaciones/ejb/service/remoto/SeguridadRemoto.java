package pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Perfil;
import pe.gob.servir.systems.util.retorno.ReturnObject;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by jarvis on 13/03/2016.
 */
@Remote
public interface SeguridadRemoto {

    public List<Perfil> obtenerPerfilPorEstado(Perfil perfil) throws PersistenciaException;
    public ReturnObject registrarPerfil(final Perfil perfil) throws PersistenciaException;



}
