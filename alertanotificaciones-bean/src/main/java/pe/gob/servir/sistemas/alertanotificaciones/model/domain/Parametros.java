package pe.gob.servir.sistemas.alertanotificaciones.model.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by jarvis on 14/03/2016.
 */
public class Parametros implements Serializable {

    private static final long serialVersionUID = -7454777082039961692L;

    private Long parametroId;
    private String codigoTabla;
    private String codigoParametro;
    private String etiqueta;
    private String valor;
    private String valor2;
    private String valor3;
    private Date fechaCreacion;
    private String usuarioCreacion;
    private String estado;



    public Long getParametroId() {
        return parametroId;
    }

    public void setParametroId(Long parametroId) {
        this.parametroId = parametroId;
    }

    public String getCodigoTabla() {
        return codigoTabla;
    }

    public void setCodigoTabla(String codigoTabla) {
        this.codigoTabla = codigoTabla;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

    public String getValor3() {
        return valor3;
    }

    public void setValor3(String valor3) {
        this.valor3 = valor3;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoParametro() {
        return codigoParametro;
    }

    public void setCodigoParametro(String codigoParametro) {
        this.codigoParametro = codigoParametro;
    }
}
