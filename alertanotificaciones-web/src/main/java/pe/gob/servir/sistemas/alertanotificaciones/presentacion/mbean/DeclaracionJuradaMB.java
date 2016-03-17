package pe.gob.servir.sistemas.alertanotificaciones.presentacion.mbean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.gob.servir.sistemas.alertanotificaciones.model.domain.Parametros;
import pe.gob.servir.sistemas.alertanotificaciones.presentacion.base.BasicMB;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by jarvis on 17/03/2016.
 */
@ManagedBean(name = "declaracionJuradaMB")
@ViewScoped
public class DeclaracionJuradaMB extends BasicMB {

    private static final Logger log = LoggerFactory.getLogger(DeclaracionJuradaMB.class);

    private List<Parametros> listaDeclaracionJurada;
    private Parametros parametros;


    @PostConstruct
    private void iniciar(){
        parametros = new Parametros();
    }


    public String verRegistrarDeclaracionJurada(){
        log.info("verRegistrarDeclaracionJurada");

        return "verRegistrarDeclaracionJurada";
    }


    public void buscarDeclaracionJurada(){
        log.info("buscarDeclaracionJurada");

    }

    public void limpiarFormulario(){
        log.info("limpiarFormulario");

    }




    public List<Parametros> getListaDeclaracionJurada() {
        return listaDeclaracionJurada;
    }

    public void setListaDeclaracionJurada(List<Parametros> listaDeclaracionJurada) {
        this.listaDeclaracionJurada = listaDeclaracionJurada;
    }

    public Parametros getParametros() {
        return parametros;
    }

    public void setParametros(Parametros parametros) {
        this.parametros = parametros;
    }
}
