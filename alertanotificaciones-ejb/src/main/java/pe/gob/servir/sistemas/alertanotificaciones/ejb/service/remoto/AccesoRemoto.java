package pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.PerfilOpcion;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Persona;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.SubOpcion;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Usuario;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by jarvis on 10/03/2016.
 */
@Remote
public interface AccesoRemoto {

    public Integer accederSistema(Usuario usuario) throws PersistenciaException;
    public List<PerfilOpcion> obtenerOpciones(String usuario) throws PersistenciaException;
    public List<SubOpcion> obtenerSubOpcionesPorIdOpcion(SubOpcion subOpcion) throws PersistenciaException;
    public Persona obtenerPersonaPorUsuario(final String usuario) throws PersistenciaException;

}
