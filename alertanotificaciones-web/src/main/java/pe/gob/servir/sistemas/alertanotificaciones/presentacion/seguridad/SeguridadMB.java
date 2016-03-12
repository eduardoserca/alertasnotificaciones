package pe.gob.servir.sistemas.alertanotificaciones.presentacion.seguridad;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto.AccesoRemoto;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Perfil;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.PerfilOpcion;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.SubOpcion;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Usuario;
import pe.gob.servir.sistemas.alertanotificaciones.presentacion.base.BasicMB;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jarvis on 02/03/2016.
 */
@ManagedBean(name = "seguridadMB")
@ViewScoped
public class SeguridadMB extends BasicMB {

    private static final long serialVersionUID = 1L;
    private Usuario usuario;

    @EJB(lookup = "java:global/alertanotificaciones-ear/alertanotificaciones-ejb-1.0/AccessoBean!pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto.AccesoRemoto")
    private AccesoRemoto accesoRemoto;


    @PostConstruct
    private void init(){
        usuario = new Usuario();
    }

    public void login() {}

    public String validar(){
        String pagina = "login";

            try {
                System.out.println("usuario: " + this.usuario.getUsuario());
                System.out.println("clave: " + this.usuario.getClave());

                Integer acceso = accesoRemoto.accederSistema(this.usuario);
                if(acceso == 1){// Usuario existe

                    this.usuario.setPerfil(obtenerOpciones(this.usuario.getUsuario()));
                    this.usuario.setPersona(accesoRemoto.obtenerPersonaPorUsuario(this.usuario.getUsuario()));

                    System.out.println("nombre: " + this.usuario.getPersona().getNombres());

                    iniciarSesion(this.usuario);

                    pagina = "home";
                }
            } catch (PersistenciaException e) {
                System.out.println("ERROR :( " + e);
                e.printStackTrace();
            }

        return pagina;
    }

    private Perfil obtenerOpciones(String usuario) throws PersistenciaException{
        Perfil perfil = null;
        List<PerfilOpcion> listaPerfilOpcion = accesoRemoto.obtenerOpciones(usuario);
        for(PerfilOpcion perfilOpcion : listaPerfilOpcion){
            perfil = perfilOpcion.getPerfil();
            SubOpcion subOpcion = new SubOpcion();
            subOpcion.setOpcion(perfilOpcion.getOpcion());
            perfilOpcion.getOpcion().setListaSubOpciones(accesoRemoto.obtenerSubOpcionesPorIdOpcion(subOpcion));
        }
        perfil.setListaPerfilOpcion(listaPerfilOpcion);

        return perfil;
    }

    private void iniciarSesion(Usuario usuario){

        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ectx.getRequest();
        HttpSession session = request.getSession(true);
        session.setAttribute("ID", session.getId());
        session.setAttribute("usuario", usuario);


    }


    public String cerrarSesion() {
        return "login";
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
