package pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.impl;

import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.base.impl.GenericDAOImpl;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf.UsuarioDao;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Usuario;
import pe.gob.servir.sistemas.alertanotificaciones.util.Constantes;
import pe.gob.servir.systems.util.retorno.ReturnObject;
import pe.gob.servir.systems.util.sql.Conexion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jarvis on 11/03/2016.
 */
@Stateless
public class UsuarioDaoImpl extends GenericDAOImpl<Usuario> implements UsuarioDao {

    @PersistenceContext(unitName = "PUAlertasNotificaciones")
    private EntityManager em;

    @Override
    public Integer accederSistema(final Usuario usuario) throws PersistenciaException {
        System.out.println("CESC 5 accederSistema");
        Integer acceso = 0;
        final Map<String, Object> resultado = new HashMap<String, Object>();

        System.out.println("CESC 5.1 em: " + em);
        Session hbSession = em.unwrap(Session.class);
        hbSession.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println("CESC 6 connection: " + connection);
                CallableStatement cstm = null;

                try{
                    //connection.setAutoCommit(false);
                    cstm = connection.prepareCall("{ Call "+ Constantes.BD_ESQUEMA+ ".ALERTAS_NOTIFICACIONES_PKG.AUTENTIFICACION ( ?, ?, ?, ? ) }");
                    System.out.println("CESC 7 cstm: " + cstm);

                    System.out.println("getUsuario: " + usuario.getUsuario());
                    System.out.println("getClave: "+usuario.getClave());

                    cstm.setString("v_usuario", usuario.getUsuario());
                    cstm.setString("v_clave", usuario.getClave());
                    cstm.registerOutParameter("vn_acceso", OracleTypes.INTEGER);
                    cstm.registerOutParameter("v_mensaje", OracleTypes.VARCHAR);

                    System.out.println("CESC 8 ");
                    cstm.execute();

                    String mensaje = cstm.getString("v_mensaje");
                    System.out.println("CESC 9 " + mensaje);
                    if(null != mensaje && !"[OK]".equals(mensaje) ){
                        throw new SQLException(mensaje);
                    }

                    resultado.put("acceso",cstm.getInt("vn_acceso"));



                }catch (SQLException e){
                    System.out.println(e);
                    throw new SQLException(e);
                }finally {
                    Conexion.closeCallableStatement(cstm);
                }
            }
        });

        acceso = (Integer)resultado.get("acceso");
        System.out.println("===> acceso: " + acceso);

        return acceso;
    }

    @Override
    public ReturnObject insertar(Usuario prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public Boolean actualizar(Usuario prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public Boolean eliminar(Usuario prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public List<Usuario> listar(Usuario prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public Usuario buscarXId(Usuario prmT) throws PersistenciaException {
        return null;
    }
}
