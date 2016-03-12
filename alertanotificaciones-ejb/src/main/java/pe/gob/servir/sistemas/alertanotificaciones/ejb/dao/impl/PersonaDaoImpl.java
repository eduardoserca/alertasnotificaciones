package pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.impl;

import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.base.impl.GenericDAOImpl;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.inf.PersonaDao;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Persona;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Usuario;
import pe.gob.servir.systems.util.retorno.ReturnObject;
import pe.gob.servir.systems.util.sql.Conexion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jarvis on 11/03/2016.
 */
@Stateless
public class PersonaDaoImpl extends GenericDAOImpl<Persona> implements PersonaDao {

    @PersistenceContext(unitName = "PUAlertasNotificaciones")
    private EntityManager em;

    @Override
    public Persona obtenerPersonaPorUsuario(final String usuario) throws PersistenciaException {
        Persona persona = null;
        final Map<String , Object> resultado = new HashMap<>();

        Session hbSession = em.unwrap(Session.class);
        hbSession.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println("CESC 6 connection: " + connection);
                CallableStatement cstm = null;

                try{
                    connection.setAutoCommit(false);
                    cstm = connection.prepareCall("{ Call ALERTAS.ALERTAS_NOTIFICACIONES_PKG.GET_PERSONA_POR_USUARIO ( ?, ?, ? ) }");

                    cstm.setString("v_usuario", usuario);
                    cstm.registerOutParameter("cur_persona", OracleTypes.CURSOR);
                    cstm.registerOutParameter("v_mensaje", OracleTypes.VARCHAR);

                    cstm.execute();

                    String mensaje = cstm.getString("v_mensaje");
                    System.out.println("mensaje de error: mensaje = " + mensaje);

                    if(null != mensaje && mensaje.trim().length() > 0 ){
                        throw new SQLException(mensaje);
                    }

                    ResultSet rs = (ResultSet)cstm.getObject("cur_persona");
                    while (rs.next()) {
                        Persona personaOut = new Persona();
                        personaOut.setPersonaId(rs.getLong("PERSONA_ID"));
                        personaOut.setCredencialPersona(rs.getLong("CREDENCIAL_PERSONA"));
                        personaOut.setNumDocIdentidad(rs.getString("NUM_DOC_IDENTIDAD"));
                        personaOut.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
                        personaOut.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
                        personaOut.setNombres(rs.getString("NOMBRES"));
                        personaOut.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
                        personaOut.setTelefono(rs.getString("TELEFONO"));
                        personaOut.setCargo(rs.getString("CARGO"));
                        personaOut.setEstado(rs.getString("ESTADO"));
                        resultado.put("persona",personaOut);
                    }

                }catch (SQLException e){
                    System.out.println(e);
                    throw new SQLException(e);
                }finally {
                    Conexion.closeCallableStatement(cstm);
                }
            }
        });

        if(null != resultado.get("persona")){
            persona = (Persona)resultado.get("persona");
        }

        return persona;
    }

    @Override
    public ReturnObject insertar(Persona prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public Boolean actualizar(Persona prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public Boolean eliminar(Persona prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public List<Persona> listar(Persona prmT) throws PersistenciaException {
        return null;
    }

    @Override
    public Persona buscarXId(Persona prmT) throws PersistenciaException {
        return null;
    }
}
