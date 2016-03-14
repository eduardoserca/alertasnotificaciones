package pe.gob.servir.sistemas.alertanotificaciones.presentacion.base;


import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by jarvis on 02/03/2016.
 */
@ManagedBean(name = "basicMB")
public class BasicMB implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Object obtenerSesion(){

        FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        return session.getAttribute("usuario");
    }

}
