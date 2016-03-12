package pe.gob.servir.sistemas.alertanotificaciones.model.domain;

import pe.gob.servir.sistemas.alertanotificaciones.model.basic.BasicObject;

import java.sql.Date;

/**
 * Created by jarvis on 11/03/2016.
 */
public class SubOpcion extends BasicObject {

    private static final long serialVersionUID = 1L;


    private Long subopcionId;
    private Opcion opcion;
    private String descripcion;
    private String estado;
    private Long orden;
    private Date fechaCreacion;
    private String usuarioCreacion;

    public Long getSubopcionId() {
        return subopcionId;
    }

    public void setSubopcionId(Long subopcionId) {
        this.subopcionId = subopcionId;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
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

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
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
