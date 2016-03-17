package pe.gob.servir.sistemas.alertanotificaciones.model.domain;

import pe.gob.servir.sistemas.alertanotificaciones.model.basic.BasicObject;

/**
 * Created by jarvis on 15/03/2016.
 */
public class Responsable extends BasicObject {

    private static final long serialVersionUID = -7020610138755340846L;

    private Long responsableId;

    public Long getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(Long responsableId) {
        this.responsableId = responsableId;
    }
}
