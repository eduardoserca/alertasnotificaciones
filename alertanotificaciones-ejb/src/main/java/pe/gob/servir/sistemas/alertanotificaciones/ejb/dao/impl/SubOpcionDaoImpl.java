package pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.impl;

import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.base.impl.GenericDAOImpl;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf.SubOpcionDao;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Opcion;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.SubOpcion;
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
 * Created by jarvis on 11/03/2016.
 */
@Stateless
public class SubOpcionDaoImpl extends GenericDAOImpl<SubOpcion> implements SubOpcionDao {

    @PersistenceContext(unitName = "PUAlertasNotificaciones")
    private EntityManager em;

    @Override
    public List<SubOpcion> obtenerSubOpcionesPorIdOpcion(final SubOpcion subOpcion) throws PersistenciaException {
        final List<SubOpcion> lista = new ArrayList<>();
        CallableStatement cstm = null;

        Session hbSession = em.unwrap(Session.class);
        hbSession.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println("CESC 6 connection: " + connection);
                CallableStatement cstm = null;

                try{
                    connection.setAutoCommit(false);
                    cstm = connection.prepareCall("{ Call "+ Constantes.BD_ESQUEMA+ ".ALERTAS_NOTIFICACIONES_PKG.GET_SUBOPCIONES ( ?, ?, ? ) }");

                    cstm.setLong("vn_opcion_id", subOpcion.getOpcion().getOpcionId());
                    cstm.registerOutParameter("cur_sub_opciones", OracleTypes.CURSOR);
                    cstm.registerOutParameter("v_mensaje", OracleTypes.VARCHAR);

                    cstm.execute();

                    String mensaje = cstm.getString("v_mensaje");
                    System.out.println("mensaje de error: mensaje = " + mensaje);

                    if(null != mensaje && mensaje.trim().length() > 0 ){
                        throw new SQLException(mensaje);
                    }

                    ResultSet rs = (ResultSet)cstm.getObject("cur_sub_opciones");
                    while (rs.next()) {
                        SubOpcion subOpcionOut = new SubOpcion();
                        subOpcionOut.setSubopcionId(rs.getLong("SUBOPCION_ID"));
                        subOpcionOut.setOpcion(new Opcion());
                        subOpcionOut.getOpcion().setOpcionId(rs.getLong("OPCION_ID"));
                        subOpcionOut.setCodigoSubOpcion(rs.getString("CODIGO_SUBOPCION"));
                        subOpcionOut.setDescripcion(rs.getString("DESCRIPCION"));
                        subOpcionOut.setEstado(rs.getString("ESTADO"));
                        lista.add(subOpcionOut);
                    }

                }catch (SQLException e){
                    System.out.println(e);
                    throw new SQLException(e);
                }finally {
                    Conexion.closeCallableStatement(cstm);
                }
            }
        });

        return lista;
    }

    @Override
    public ReturnObject insertar(SubOpcion prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public Boolean actualizar(SubOpcion prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public Boolean eliminar(SubOpcion prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public List<SubOpcion> listar(SubOpcion prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public SubOpcion buscarXId(SubOpcion prmT) throws PersistenciaException {
        return null;
    }
}
