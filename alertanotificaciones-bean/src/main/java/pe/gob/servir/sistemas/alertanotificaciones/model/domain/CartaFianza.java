package pe.gob.servir.sistemas.alertanotificaciones.model.domain;

import pe.gob.servir.sistemas.alertanotificaciones.model.basic.BasicObject;

/**
 * Created by jarvis on 15/03/2016.
 */
public class CartaFianza extends BasicObject {

    private static final long serialVersionUID = 5361396743078617273L;

    private Long cartaFianzaId;
    private String tipo;
    private String numeroDocumento;
    private Long numeroContrato;
    private String estado;
    private String comentario;

    private Supervisor supervisor;
    private Responsable responsable;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Long getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(Long numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public Long getCartaFianzaId() {
        return cartaFianzaId;
    }

    public void setCartaFianzaId(Long cartaFianzaId) {
        this.cartaFianzaId = cartaFianzaId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
