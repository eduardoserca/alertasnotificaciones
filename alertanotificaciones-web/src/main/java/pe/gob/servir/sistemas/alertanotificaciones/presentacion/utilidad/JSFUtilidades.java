package pe.gob.servir.sistemas.alertanotificaciones.presentacion.utilidad;

import org.primefaces.context.RequestContext;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import java.util.Locale;

public class JSFUtilidades {
    public static void putRequestMap(String name, Object obj) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(name, obj);
    }

    public static Object getRequestMap(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(name);
    }

    public static void removeRequestMap(String name) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().remove(name);
    }

    public static void putViewMap(String name, Object obj) {
        FacesContext.getCurrentInstance().getViewRoot().getViewMap().put(name, obj);
    }

    public static Object getViewMap(String name) {
        return FacesContext.getCurrentInstance().getViewRoot().getViewMap().get(name);
    }

    public static void removeViewMap(String name) {
        FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
    }

    public static void putSessionMap(String name, Object obj) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(name, obj);
    }

    public static Object getSessionMap(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(name);
    }

    public static void removeSessionMap(String name) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(name);
    }

    public static Object findViewComponent(String key) {
        return FacesContext.getCurrentInstance().getViewRoot().findComponent(key);
    }

    public static String getRequestParameterMap(String key) {
        return (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }

    public static void showSimpleValidationDialog() {
        JSFUtilidades.updateComponent("cnfMsgCustomValidation");
        JSFUtilidades.executeJavascriptFunction("cnfwMsgCustomValidation.show()");
    }

    public static void showRequiredValidationDialog() {
        JSFUtilidades.updateComponent("cnfMsgRequiredValidation");
        JSFUtilidades.executeJavascriptFunction("cnfwMsgRequiredValidation.show()");
    }

    public static void updateComponent(String componentId) {
    	RequestContext.getCurrentInstance().update(componentId);
    }

    public static void executeJavascriptFunction(String function) {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute(function.toString());
    }

    public static Locale getCurrentLocale() {
        return FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }

    public static void resetViewRoot() {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse();
    }

    public static void showMessageOnDialog(String keyHeaderProperty, Object[] headerData, String keyBodyProperty, Object[] bodyData) {
        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        String headerMessageConfirmation = "";
        if (!(keyHeaderProperty == null || keyHeaderProperty.isEmpty())) {
            headerMessageConfirmation = PropiedadesUtilidades.getMessage(locale, keyHeaderProperty, headerData);
        }
        String bodyMessageConfirmation = "";
        if (!(keyBodyProperty == null || keyBodyProperty.isEmpty())) {
            bodyMessageConfirmation = PropiedadesUtilidades.getMessage(locale,keyBodyProperty,bodyData);
        }
        JSFUtilidades.putViewMap("bodyMessageView", bodyMessageConfirmation);
        JSFUtilidades.putViewMap("headerMessageView", headerMessageConfirmation);
    }

    public static void showMessageOnDialog(String headerMessageConfirmation, String bodyMessageConfirmation) {
        JSFUtilidades.putViewMap("bodyMessageView", bodyMessageConfirmation);
        JSFUtilidades.putViewMap("headerMessageView", headerMessageConfirmation);
    }
    
    public static void addContextMessage(String controlId,Severity severity,String summary,String detail){
		  FacesMessage fMessage=new FacesMessage(severity, summary, detail);
		  FacesContext.getCurrentInstance().addMessage(controlId, fMessage);
		  if(controlId!=null && !controlId.isEmpty()){
		   setInvalidViewComponent(controlId);
		  }
   }
    public static void setInvalidViewComponent(String key){
		  Object component=findViewComponent(key);
		  if(component instanceof UIInput){
		   UIInput input=(UIInput)component;
		   input.setValid(false);
		  }
	 }
    
    
}