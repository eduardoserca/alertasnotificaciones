package pe.gob.servir.sistemas.alertanotificaciones.presentacion.mbean;

import pe.gob.servir.sistemas.alertanotificaciones.ejb.dao.exception.PersistenciaException;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto.ParametrosRemoto;
import pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto.SeguridadRemoto;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Parametros;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Perfil;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Usuario;
import pe.gob.servir.sistemas.alertanotificaciones.presentacion.base.BasicMB;
import pe.gob.servir.sistemas.alertanotificaciones.presentacion.utilidad.GeneralConstants;
import pe.gob.servir.sistemas.alertanotificaciones.presentacion.utilidad.JSFUtilidades;
import pe.gob.servir.sistemas.alertanotificaciones.presentacion.utilidad.PropiedadesUtilidades;
import pe.gob.servir.systems.util.retorno.ReturnObject;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by jarvis on 12/03/2016.
 */
@ManagedBean(name = "perfilMB")
@ViewScoped
public class PerfilMB extends BasicMB {

    private static final long serialVersionUID = 1L;

    @EJB(lookup = "java:global/alertanotificaciones-ear/alertanotificaciones-ejb-1.0/SeguridadBean!pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto.SeguridadRemoto")
    private SeguridadRemoto seguridadRemoto;

    @EJB(lookup = "java:global/alertanotificaciones-ear/alertanotificaciones-ejb-1.0/ParametrosBean!pe.gob.servir.sistemas.alertanotificaciones.ejb.service.remoto.ParametrosRemoto")
    private ParametrosRemoto parametrosRemoto;


    private Perfil perfil;
    private Usuario usuario;
    private Perfil perfilRegistrar;
    private List<Perfil> listaPerfiles;
    private List<Parametros> listaEstados;

    @PostConstruct
    private void iniciar(){
        perfil = new Perfil();
        perfilRegistrar = new Perfil();
        usuario = (Usuario)obtenerSesion();
        listaEstados = iniciarEstados();
    }


    private List<Parametros> iniciarEstados(){
        List<Parametros> lista = null;
        try {

            lista = parametrosRemoto.obtenerParametrosPorCodigoTabla(GeneralConstants.TABLA_ESTADOS);

            for (Parametros parametros : lista ){
                if(GeneralConstants.ESTADO_ELIMINADO.equals(parametros.getValor())){
                    lista.remove(parametros);
                    break;
                }
            }

        } catch (PersistenciaException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }


    public Perfil getPerfil() {
        return perfil;
    }


    public void buscarPerfilesPorEstado(){
        System.out.println("perfil.getEstado():" +perfil.getEstado());
        System.out.println("perfil.getDescripcion():" +perfil.getDescripcion());

        if("".equals(perfil.getEstado())){
            perfil.setEstado(null);
        }
        if("".equals(perfil.getNombrePerfil().trim())){
            perfil.setNombrePerfil(null);
        }

        try {
            listaPerfiles = seguridadRemoto.obtenerPerfilPorEstado(perfil);
            System.out.println("listaPerfiles: " + listaPerfiles);
        } catch (PersistenciaException e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public void limpiar(){
        System.out.println("limpiar");
        perfil = new Perfil();
    }

    public  void mostrarRegistrarPerfil(){
        System.out.println("mostrarRegistrarPerfil");
        perfilRegistrar = new Perfil();

    }

    public  void registrarPerfil(){
        System.out.println("registrarPerfil");
        try {
            perfilRegistrar.setUsuarioCreacion(usuario.getUsuario());
            ReturnObject returnObject = seguridadRemoto.registrarPerfil(perfilRegistrar);
            System.out.println("perfilRegistrar.getPerfilId(): " + returnObject.getId());
            Object[] bodyData = new Object[]{returnObject.getId()};

            //JSFUtilidades.executeJavascriptFunction("PF('wModalRegistroPerfil').hide()");

            JSFUtilidades.showMessageOnDialog(PropiedadesUtilidades.getMessage("label.header.alerta.exito"), PropiedadesUtilidades.getMessage("adm.articulo.exito.registro",bodyData));
            JSFUtilidades.executeJavascriptFunction("PF('cnfwEndTransaction').show()");


        } catch (PersistenciaException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void cancelarRegistrarPerfil(){
        perfilRegistrar = new Perfil();
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Perfil> getListaPerfiles() {
        return listaPerfiles;
    }

    public void setListaPerfiles(List<Perfil> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    public Perfil getPerfilRegistrar() {
        return perfilRegistrar;
    }

    public void setPerfilRegistrar(Perfil perfilRegistrar) {
        this.perfilRegistrar = perfilRegistrar;
    }

    public List<Parametros> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<Parametros> listaEstados) {
        this.listaEstados = listaEstados;
    }
}
