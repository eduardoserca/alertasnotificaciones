package pe.gob.servir.sistemas.alertanotificaciones.model.domain;

import pe.gob.servir.sistemas.alertanotificaciones.model.basic.BasicObject;

import java.sql.Date;
import java.util.List;

/**
 * Created by jarvis on 11/03/2016.
 */
public class Opcion  extends BasicObject {

    private static final long serialVersionUID = 1L;

    private Long opcionId;
    private String codigoOpcion;
    private String descripcion;
    private String estado;
    private Long orden;
    private Date fechaCreacion;
    private String usuarioCreacion;
    private List<SubOpcion> listaSubOpciones;

    public Long getOpcionId() {
        return opcionId;
    }

    public void setOpcionId(Long opcionId) {
        this.opcionId = opcionId;
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

    public List<SubOpcion> getListaSubOpciones() {
        return listaSubOpciones;
    }

    public void setListaSubOpciones(List<SubOpcion> listaSubOpciones) {
        this.listaSubOpciones = listaSubOpciones;
    }

    public String getCodigoOpcion() {
        return codigoOpcion;
    }

    public void setCodigoOpcion(String codigoOpcion) {
        this.codigoOpcion = codigoOpcion;
    }
}
