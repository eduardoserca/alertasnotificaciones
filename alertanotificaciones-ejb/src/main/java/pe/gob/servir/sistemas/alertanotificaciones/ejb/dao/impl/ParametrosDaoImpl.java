package pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.impl;

import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.base.impl.GenericDAOImpl;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf.ParametrosDao;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Parametros;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jarvis on 14/03/2016.
 */
@Stateless
public class ParametrosDaoImpl extends GenericDAOImpl<Parametros> implements ParametrosDao  {

    @PersistenceContext(unitName = "PUAlertasNotificaciones")
    private EntityManager em;

    @Override
    public List<Parametros> obtenerParametrosPorCodigoTabla(final String codigoTabla) throws PersistenciaException {
        List<Parametros> listaParametros = null;
        final List<Parametros> lista = new ArrayList<>();


        Session hbSession = em.unwrap(Session.class);
        hbSession.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {

                CallableStatement cstm = null;

                try {
                    connection.setAutoCommit(false);
                    cstm = connection.prepareCall("{ Call "+ Constantes.BD_ESQUEMA+".ALERTAS_NOTIFICACIONES_PKG.GET_LTS_PARAMETROS_COD_TABLA ( ?,?,?) }");

                    cstm.setString("v_codigo_tabla", codigoTabla);
                    cstm.registerOutParameter("cur_parametros", OracleTypes.CURSOR);
                    cstm.registerOutParameter("v_mensaje", OracleTypes.VARCHAR);

                    cstm.execute();

                    String mensaje = cstm.getString("v_mensaje");
                    System.out.println("mensaje de error: mensaje = " + mensaje);

                    if (null != mensaje && mensaje.trim().length() > 0) {
                        throw new SQLException(mensaje);
                    }

                    ResultSet rs = (ResultSet) cstm.getObject("cur_parametros");
                    while (rs.next()) {
                        Parametros parametrosOut = new Parametros();
                        parametrosOut.setParametroId(rs.getLong("PARAMETRO_ID"));
                        parametrosOut.setCodigoTabla(rs.getString("CODIGO_TABLA"));
                        parametrosOut.setCodigoParametro(rs.getString("CODIGO_PARAMETRO"));
                        parametrosOut.setEtiqueta(rs.getString("ETIQUETA"));
                        parametrosOut.setValor(rs.getString("VALOR"));
                        parametrosOut.setValor2(rs.getString("VALOR2"));
                        parametrosOut.setValor3(rs.getString("VALOR3"));
                        parametrosOut.setEstado(rs.getString("ESTADO"));
                        parametrosOut.setFechaCreacion(rs.getDate("FECHA_CREACION"));
                        parametrosOut.setUsuarioCreacion(rs.getString("USUARIO_CREACION"));

                        lista.add(parametrosOut);
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
            listaParametros = lista;
        }


        return listaParametros;
    }

    @Override
    public Map<String, Parametros> obtenerMapaParametrosPorCodigoTabla(final String codigoTabla) throws PersistenciaException{

        final Map<String, Parametros> resultado = new HashMap<>();

        Session hbSession = em.unwrap(Session.class);
        hbSession.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {

                CallableStatement cstm = null;

                try {
                    connection.setAutoCommit(false);
                    cstm = connection.prepareCall("{ Call "+ Constantes.BD_ESQUEMA+".ALERTAS_NOTIFICACIONES_PKG.GET_LTS_PARAMETROS_COD_TABLA ( ?,?,?) }");

                    cstm.setString("v_codigo_tabla", codigoTabla);
                    cstm.registerOutParameter("cur_parametros", OracleTypes.CURSOR);
                    cstm.registerOutParameter("v_mensaje", OracleTypes.VARCHAR);

                    cstm.execute();

                    String mensaje = cstm.getString("v_mensaje");
                    System.out.println("mensaje de error: mensaje = " + mensaje);

                    if (null != mensaje && mensaje.trim().length() > 0) {
                        throw new SQLException(mensaje);
                    }

                    ResultSet rs = (ResultSet) cstm.getObject("cur_parametros");
                    while (rs.next()) {
                        Parametros parametrosOut = new Parametros();
                        parametrosOut.setParametroId(rs.getLong("PARAMETRO_ID"));
                        parametrosOut.setCodigoTabla(rs.getString("CODIGO_TABLA"));
                        parametrosOut.setCodigoParametro(rs.getString("CODIGO_PARAMETRO"));
                        parametrosOut.setEtiqueta(rs.getString("ETIQUETA"));
                        parametrosOut.setValor(rs.getString("VALOR"));
                        parametrosOut.setValor2(rs.getString("VALOR2"));
                        parametrosOut.setValor3(rs.getString("VALOR3"));
                        parametrosOut.setEstado(rs.getString("ESTADO"));
                        parametrosOut.setFechaCreacion(rs.getDate("FECHA_CREACION"));
                        parametrosOut.setUsuarioCreacion(rs.getString("USUARIO_CREACION"));

                        resultado.put(parametrosOut.getCodigoParametro(),parametrosOut);
                    }


                } catch (SQLException e) {
                    System.out.println(e);
                    throw new SQLException(e);
                } finally {
                    Conexion.closeCallableStatement(cstm);
                }
            }
        });



        return resultado;
    }

    @Override
    public ReturnObject insertar(Parametros parametros) throws PersistenciaException {
        return null;
    }

    @Override
    public Boolean actualizar(Parametros parametros) throws PersistenciaException {
        return null;
    }

    @Override
    public Boolean eliminar(Parametros parametros) throws PersistenciaException {
        return null;
    }

    @Override
    public List<Parametros> listar(Parametros parametros) throws PersistenciaException {
        return null;
    }

    @Override
    public Parametros buscarXId(Parametros parametros) throws PersistenciaException {
        return null;
    }
}
