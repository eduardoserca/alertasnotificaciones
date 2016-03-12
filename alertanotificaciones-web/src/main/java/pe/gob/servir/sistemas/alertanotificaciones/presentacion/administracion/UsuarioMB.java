package pe.gob.servir.sistemas.alertanotificaciones.presentacion.administracion;

import pe.gob.servir.sistemas.alertanotificaciones.presentacion.base.BasicMB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by jarvis on 02/03/2016.
 */
@ManagedBean(name = "usuarioMB")
@ViewScoped
public class UsuarioMB extends BasicMB{

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String mensaje;

    public void say(){
        mensaje = "Hola " + nombre;
        System.out.println("mensaje: " + mensaje);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
