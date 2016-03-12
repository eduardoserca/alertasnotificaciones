package pe.gob.servir.sistemas.alertanotificaciones.model.domain;

import pe.gob.servir.sistemas.alertanotificaciones.model.basic.BasicObject;

import java.sql.Date;

/**
 * Created by jarvis on 11/03/2016.
 */
public class PerfilOpcion extends BasicObject {

    private static final long serialVersionUID = 1L;

    private Perfil perfil;
    private Opcion opcion;
    private Date fechaCreacion;
    private String usuarioCreacion;

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
}
