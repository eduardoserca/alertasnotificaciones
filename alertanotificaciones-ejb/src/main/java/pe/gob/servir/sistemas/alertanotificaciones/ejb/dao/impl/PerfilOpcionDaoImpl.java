package pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.impl;

import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.base.impl.GenericDAOImpl;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf.PerfilOpcionDao;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Opcion;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Perfil;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.PerfilOpcion;
import pe.gob.servir.systems.util.retorno.ReturnObject;
import pe.gob.servir.systems.util.sql.Conexion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jarvis on 11/03/2016.
 */
@Stateless
public class PerfilOpcionDaoImpl  extends GenericDAOImpl<PerfilOpcion> implements PerfilOpcionDao {

    @PersistenceContext(unitName = "PUAlertasNotificaciones")
    private EntityManager em;

    @Override
    public ReturnObject insertar(PerfilOpcion prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public Boolean actualizar(PerfilOpcion prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public Boolean eliminar(PerfilOpcion prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public List<PerfilOpcion> listar(PerfilOpcion prmT) throws PersistenciaException {
       return null;
    }

    @Override
    public PerfilOpcion buscarXId(PerfilOpcion prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public List<PerfilOpcion> listar(final String usuario) throws PersistenciaException {
        final List<PerfilOpcion> listaPerfilOpcion = new ArrayList<>();

        Session hbSession = em.unwrap(Session.class);
        hbSession.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {

                CallableStatement cstm = null;

                try{
                    connection.setAutoCommit(false);
                    cstm = connection.prepareCall("{ Call ALERTAS.ALERTAS_NOTIFICACIONES_PKG.GET_PERFIL_OPCION ( ?, ?, ? ) }");

                    cstm.setString("v_usuario", usuario);
                    cstm.registerOutParameter("cur_perfil_op", OracleTypes.CURSOR);
                    cstm.registerOutParameter("v_mensaje", OracleTypes.VARCHAR);

                    cstm.execute();

                    String mensaje = cstm.getString("v_mensaje");
                    System.out.println("mensaje de error: mensaje = " + mensaje);

                    if(null != mensaje && mensaje.trim().length() > 0 ){
                        throw new SQLException(mensaje);
                    }

                    ResultSet rs = (ResultSet)cstm.getObject("cur_perfil_op");
                    while (rs.next()) {
                        PerfilOpcion perfilOpcion = new PerfilOpcion();
                        perfilOpcion.setPerfil(new Perfil());
                        perfilOpcion.getPerfil().setPerfilId(rs.getLong("PERFIL_ID"));
                        perfilOpcion.getPerfil().setDescripcion(rs.getString("PERFIL_DES"));
                        perfilOpcion.getPerfil().setCodigoPerfil(rs.getString("CODIGO_PERFIL"));
                        perfilOpcion.setOpcion(new Opcion());
                        perfilOpcion.getOpcion().setOpcionId(rs.getLong("OPCION_ID"));
                        perfilOpcion.getOpcion().setCodigoOpcion(rs.getString("CODIGO_OPCION"));
                        perfilOpcion.getOpcion().setDescripcion(rs.getString("OPCION_DES"));
                        perfilOpcion.getOpcion().setOrden(rs.getLong("OPCION_ORDEN"));

                        listaPerfilOpcion.add(perfilOpcion);
                    }



                }catch (SQLException e){
                    System.out.println(e);
                    throw new SQLException(e);
                }finally {
                    Conexion.closeCallableStatement(cstm);
                }
            }
        });


        return listaPerfilOpcion;
    }




}
