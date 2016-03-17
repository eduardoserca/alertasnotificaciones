package pe.gob.servir.sistemas.alertanotificaciones.ejb.service.bean;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf.PerfilDao;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto.SeguridadRemoto;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Perfil;
import pe.gob.servir.systems.util.retorno.ReturnObject;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by jarvis on 13/03/2016.
 */
@Stateless(mappedName = "SeguridadEJB")
public class SeguridadBean implements SeguridadRemoto {

    @EJB
    private PerfilDao perfilDao;


    @Override
    public List<Perfil> obtenerPerfilPorEstado(Perfil perfil) throws PersistenciaException {
        return perfilDao.obtenerPerfilPorEstado(perfil);
    }

    @Override
    public ReturnObject registrarPerfil(Perfil perfil) throws PersistenciaException {
        return perfilDao.insertar(perfil);
    }

    @Override
    public Boolean eliminarPerfil(Perfil perfil) throws PersistenciaException {
        return perfilDao.eliminar(perfil);
    }


}
