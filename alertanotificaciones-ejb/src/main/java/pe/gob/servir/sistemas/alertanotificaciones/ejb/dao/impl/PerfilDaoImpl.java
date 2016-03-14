package pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.impl;

import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.base.impl.GenericDAOImpl;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf.PerfilDao;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Perfil;
import pe.gob.servir.sistemas.alertanotificaciones.util.Constantes;
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
 * Created by jarvis on 13/03/2016.
 */
@Stateless
public class PerfilDaoImpl extends GenericDAOImpl<Perfil> implements PerfilDao {

    @PersistenceContext(unitName = "PUAlertasNotificaciones")
    private EntityManager em;

    @Override
    public List<Perfil> obtenerPerfilPorEstado(final Perfil perfil) throws PersistenciaException {
        List<Perfil> listaPerfiles = null;
        final List<Perfil> lista = new ArrayList<>();


        Session hbSession = em.unwrap(Session.class);
        hbSession.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {

                CallableStatement cstm = null;

                try {
                    connection.setAutoCommit(false);
                    cstm = connection.prepareCall("{ Call ALERTAS.ALERTAS_NOTIFICACIONES_PKG.GET_LTS_PERFIL_ESTADO ( ?,?,?,? ) }");

                    cstm.setString("vn_code_estado", perfil.getEstado());
                    cstm.setString("vn_des_perfil", perfil.getNombrePerfil());
                    cstm.registerOutParameter("cur_perfiles", OracleTypes.CURSOR);
                    cstm.registerOutParameter("v_mensaje", OracleTypes.VARCHAR);

                    cstm.execute();

                    String mensaje = cstm.getString("v_mensaje");
                    System.out.println("mensaje de error: mensaje = " + mensaje);

                    if (null != mensaje && mensaje.trim().length() > 0) {
                        throw new SQLException(mensaje);
                    }

                    ResultSet rs = (ResultSet) cstm.getObject("cur_perfiles");
                    while (rs.next()) {
                        Perfil perfilOut = new Perfil();
                        perfilOut.setPerfilId(rs.getLong("PERFIL_ID"));
                        perfilOut.setCodigoPerfil(rs.getString("CODIGO_PERFIL"));
                        perfilOut.setNombrePerfil(rs.getString("NOMBRE_PERFIL"));
                        perfilOut.setDescripcion(rs.getString("DESCRIPCION"));
                        perfilOut.setEstado(rs.getString("ESTADO"));
                        perfilOut.setFechaCreacion(rs.getDate("FECHA_CREACION"));
                        perfilOut.setUsuarioCreacion(rs.getString("USUARIO_CREACION"));

                        if (Constantes.ESTADO_ACTIVO.equals(perfilOut.getEstado())) {
                            perfilOut.setDescripcionEstado(Constantes.ESTADO_ACTIVO_DESCRIPCION);
                        } else {
                            perfilOut.setDescripcionEstado(Constantes.ESTADO_INACTIVO_DESCRIPCION);
                        }

                        lista.add(perfilOut);
                    }


                } catch (SQLException e) {
                    System.out.println(e);
                    throw new SQLException(e);
                } finally {
                    Conexion.closeCallableStatement(cstm);
                }
            }
        });


        if (lista.size() > 0) {
            listaPerfiles = lista;
        }


        return listaPerfiles;

    }

    @Override
    public ReturnObject insertar(final Perfil perfil) throws PersistenciaException {

        ReturnObject returnObject = new ReturnObject();

        Session hbSession = em.unwrap(Session.class);

        hbSession.doWork(new Work() {
            @Override
            public void execute(Connection cn) throws SQLException {

                CallableStatement cstm = null;

                try {
                    //cn.setAutoCommit(false);
                    cstm = cn.prepareCall("{ Call ALERTAS.ALERTAS_NOTIFICACIONES_PKG.REGISTRAR_PERFIL( ?, ?, ?, ?, ?, ?,?) }");

                    cstm.registerOutParameter("v_mensaje", OracleTypes.VARCHAR);
                    cstm.registerOutParameter("vn_perfil_id", OracleTypes.NUMBER);
                    cstm.setString("v_codigo_perfil", perfil.getCodigoPerfil());
                    cstm.setString("v_nombre_perfil", perfil.getNombrePerfil());
                    cstm.setString("v_descripcion", perfil.getDescripcion());
                    cstm.setString("v_estado", perfil.getEstado());
                    cstm.setString("v_usuario_creacion", perfil.getUsuarioCreacion());

                    cstm.execute();

                    String mensaje = cstm.getString("v_mensaje");
                    System.out.println("mensaje de error: mensaje = " + mensaje);

                    if (null != mensaje && mensaje.trim().length() > 0) {
                        throw new SQLException(mensaje);
                    }

                    perfil.setPerfilId(cstm.getLong("vn_perfil_id"));


                } catch (SQLException e) {
                    System.out.println(e);
                    throw new SQLException(e);
                } finally {
                    Conexion.closeCallableStatement(cstm);
                }
            }
        });

        returnObject.setId(perfil.getPerfilId());
        return returnObject;


    }

    @Override
    public Boolean actualizar(Perfil prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public Boolean eliminar(Perfil prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public List<Perfil> listar(Perfil prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public Perfil buscarXId(Perfil prmT) throws PersistenciaException {
        return null;
    }
}
