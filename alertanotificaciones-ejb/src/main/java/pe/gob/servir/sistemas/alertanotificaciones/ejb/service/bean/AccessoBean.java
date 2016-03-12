package pe.gob.servir.sistemas.alertanotificaciones.ejb.service.bean;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.impl.UsuarioDaoImpl;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf.PerfilOpcionDao;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf.PersonaDao;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf.SubOpcionDao;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf.UsuarioDao;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto.AccesoRemoto;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.PerfilOpcion;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Persona;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.SubOpcion;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Usuario;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by jarvis on 10/03/2016.
 */
@Stateless(mappedName = "AccessoEJB")
public class AccessoBean implements AccesoRemoto{

    @EJB
    private UsuarioDao usuarioDao;
    @EJB
    private PerfilOpcionDao perfilOpcionDao;
    @EJB
    private SubOpcionDao subOpcionDao;
    @EJB
    private PersonaDao personaDao;



    @Override
    public Integer accederSistema(Usuario usuario) throws PersistenciaException {
        return usuarioDao.accederSistema(usuario);

    }

    @Override
    public List<PerfilOpcion> obtenerOpciones(String usuario) throws PersistenciaException {
        return perfilOpcionDao.listar(usuario);
    }

    @Override
    public List<SubOpcion> obtenerSubOpcionesPorIdOpcion(SubOpcion subOpcion) throws PersistenciaException {
        return subOpcionDao.obtenerSubOpcionesPorIdOpcion(subOpcion);
    }

    @Override
    public Persona obtenerPersonaPorUsuario(String usuario) throws PersistenciaException {
        return personaDao.obtenerPersonaPorUsuario(usuario);
    }
}
