package pe.gob.servir.sistemas.alertanotificaciones.presentacion.mbean;

import org.primefaces.model.menu.*;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.PerfilOpcion;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.SubOpcion;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Usuario;
import pe.gob.servir.sistemas.alertanotificaciones.presentacion.base.BasicMB;

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
public class HomeMB extends BasicMB {

    private Usuario usuario;
    private MenuModel menu = new DefaultMenuModel();

    @PostConstruct
    public void inicio(){
        usuario = (Usuario)obtenerSesion();

    }


    /*private Usuario obtenerSesion(){

        FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        return (Usuario) session.getAttribute("usuario");
    }*/

    public String irPagina(String codigoOpcion){
        System.out.println("irPagina: " + codigoOpcion);
        return codigoOpcion;
    }



    public boolean getAcceso(String codigoOpcion){
        System.out.println("getAcceso");
        System.out.println("usuario.getPerfil().getListaPerfilOpcion().size(): " +usuario.getPerfil().getListaPerfilOpcion().size());
        for (PerfilOpcion perfilOpcion : usuario.getPerfil().getListaPerfilOpcion()) {
            System.out.println("perfilOpcion: " +  perfilOpcion.getOpcion().getCodigoOpcion());
            if(codigoOpcion.equals(perfilOpcion.getOpcion().getCodigoOpcion())){
                System.out.println("codigoOpcion: " + perfilOpcion.getOpcion().getCodigoOpcion());
                return true;
            }

            System.out.println("(perfilOpcion: " + perfilOpcion.getOpcion().getListaSubOpciones());
            for(SubOpcion subOpcion : perfilOpcion.getOpcion().getListaSubOpciones()){
                if(codigoOpcion.equals(subOpcion.getCodigoSubOpcion())){
                    System.out.println("codigoSubOpcion: " + subOpcion.getCodigoSubOpcion());
                    return true;
                }
            }
        }

        return false;
    }




    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
