package pe.gob.servir.sistemas.alertanotificaciones.model.domain;

import pe.gob.servir.sistemas.alertanotificaciones.model.basic.BasicObject;

/**
 * Created by jarvis on 15/03/2016.
 */
public class Supervisor extends BasicObject {

    private static final long serialVersionUID = 5477287060161269050L;


    private Long supervisorId;

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }
}
