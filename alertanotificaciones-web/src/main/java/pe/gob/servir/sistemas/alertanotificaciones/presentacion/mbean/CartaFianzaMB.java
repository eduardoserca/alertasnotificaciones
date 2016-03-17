package pe.gob.servir.sistemas.alertanotificaciones.presentacion.mbean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto.ParametrosRemoto;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.CartaFianza;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Responsable;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Supervisor;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Usuario;
import pe.gob.servir.sistemas.alertanotificaciones.presentacion.base.BasicMB;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by jarvis on 15/03/2016.
 */
@ManagedBean(name = "cartaFianzaMB")
@ViewScoped
public class CartaFianzaMB extends BasicMB {

    private static final Logger log = LoggerFactory.getLogger(CartaFianzaMB.class);

    @EJB(lookup = "java:global/alertanotificaciones-ear/alertanotificaciones-ejb-1.0/ParametrosBean!pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto.ParametrosRemoto")
    private ParametrosRemoto parametrosRemoto;

    private CartaFianza cartaFianza;
    private CartaFianza cartaFianzaRegistrar;

    private List<CartaFianza> listaCartaFianza;
    private List<Usuario> listaUsuario;


    @PostConstruct
    private void iniciar(){
        cartaFianza = new CartaFianza();
        cartaFianzaRegistrar = new CartaFianza();
        cartaFianza.setSupervisor(new Supervisor());
        cartaFianza.setResponsable(new Responsable());
        cartaFianzaRegistrar.setSupervisor(new Supervisor());
        cartaFianzaRegistrar.setResponsable(new Responsable());


    }



    public void verRegistrarCartaFianza(){
        log.info("verRegistrarCartaFianza");
        log.info("entro");
        log.info("todo");
        System.out.println("verRegistrarCartaFianza");
        System.out.println("entro");
        System.out.println("todo");

    }

    public void verRegistrarCartaFianza_Bosstrap(){
        log.info("verRegistrarCartaFianza_Bosstrap");
    }

    public void registrarCartaFianza(){
        log.info("registrarCartaFianza");
    }

    public void cancelarRegistro(){
        log.info("cancelarRegistro");
    }

    public void buscarCartaFianza(){
        log.info("buscarCartaFianza");

    }
    public void limpiarFormulario(){
        log.info("limpiarFormulario");

    }

    public void buscarSupervisor(){
        log.info("buscarSupervisor");
    }

    public void buscarResponsable(){
        log.info("buscarResponsable");
    }

    public void buscarUsuario(){
        log.info("buscarUsuario");
    }

    public void agregarUsuario(){
        log.info("agregarUsuario");
    }



    public CartaFianza getCartaFianza() {
        return cartaFianza;
    }

    public void setCartaFianza(CartaFianza cartaFianza) {
        this.cartaFianza = cartaFianza;
    }

    public List<CartaFianza> getListaCartaFianza() {
        return listaCartaFianza;
    }

    public void setListaCartaFianza(List<CartaFianza> listaCartaFianza) {
        this.listaCartaFianza = listaCartaFianza;
    }

    public CartaFianza getCartaFianzaRegistrar() {
        return cartaFianzaRegistrar;
    }

    public void setCartaFianzaRegistrar(CartaFianza cartaFianzaRegistrar) {
        this.cartaFianzaRegistrar = cartaFianzaRegistrar;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
}
