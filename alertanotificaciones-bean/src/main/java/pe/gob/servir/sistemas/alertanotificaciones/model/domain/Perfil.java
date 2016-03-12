package pe.gob.servir.sistemas.alertanotificaciones.model.domain;

import pe.gob.servir.sistemas.alertanotificaciones.model.basic.BasicObject;

import java.sql.Date;
import java.util.List;


/**
 * Created by jarvis on 02/03/2016.
 */
public class Perfil extends BasicObject {

    private static final long serialVersionUID = 1L;

    private Long perfilId;
    private String descripcion;
    private String estado;
    private Date fechaCreacion;
    private String usuarioCreacion;
    private List<PerfilOpcion> listaPerfilOpcion;

    public Long getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Long perfilId) {
        this.perfilId = perfilId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public List<PerfilOpcion> getListaPerfilOpcion() {
        return listaPerfilOpcion;
    }

    public void setListaPerfilOpcion(List<PerfilOpcion> listaPerfilOpcion) {
        this.listaPerfilOpcion = listaPerfilOpcion;
    }
}