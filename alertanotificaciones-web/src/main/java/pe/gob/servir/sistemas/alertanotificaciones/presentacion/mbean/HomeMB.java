package pe.gob.servir.sistemas.alertanotificaciones.presentacion.mbean;

import org.primefaces.model.menu.MenuModel;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Created by jarvis on 11/03/2016.
 */
@ManagedBean(name = "homeMB")
@ViewScoped
public class HomeMB {

    private Usuario usuario;
    private MenuModel menuModel;

    @PostConstruct
    public void inicio(){
        usuario = obtenerSesion();

    }


    private Usuario obtenerSesion(){

        FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        return (Usuario) session.getAttribute("usuario");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
