package pe.gob.servir.sistemas.alertanotificaciones.presentacion.utilidad;




import javax.faces.context.FacesContext;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;


public class PropiedadesUtilidades {
    public static String getConstantsMessage(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("Constants");
        String value = bundle.getString(key);
        return value;
    }

    public static String getMessage(Locale locale, String key) {
        return PropiedadesUtilidades.getBundle(locale).getString(key);
    }

    public static String getMessage(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("Messages", JSFUtilidades.getCurrentLocale());
        String value = bundle.getString(key);
        return value;
    }

    public static ResourceBundle getBundle(Locale locale) {
        return ResourceBundle.getBundle("Messages", locale);
    }

    public static ResourceBundle getBundle(String propertyFile, Locale locale) {
        return ResourceBundle.getBundle(propertyFile, locale);
    }

    public static String getMessage(String propertyFile, Locale locale, String key) {
        ResourceBundle bundle = ResourceBundle.getBundle(propertyFile, locale);
        return bundle.getString(key);
    }

    public static String getMessage(String propertyFile, Locale locale, String key, Object ... params) {
        return MessageFormat.format(PropiedadesUtilidades.getBundle(propertyFile, locale).getString(key), params);
    }

    public static String getMessage(String propertyFile, String key, Object[] params) {
        return PropiedadesUtilidades.getMessage(propertyFile, JSFUtilidades.getCurrentLocale(), key, params);
    }

    public static String getMessage(Locale locale, String key, Object ... params) {
        return MessageFormat.format(PropiedadesUtilidades.getBundle(locale).getString(key), params);
    }

    public static String getMessage(String key, Object ... params) {
        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        return MessageFormat.format(PropiedadesUtilidades.getBundle(locale).getString(key), params);
    }
    
    public static Timestamp currentTimestamp() {
        try {
            SimpleDateFormat dfDate = new SimpleDateFormat(GeneralConstants.TIMESTAMP_PATTERN);
            Calendar calCurrentDate = Calendar.getInstance();
            dfDate.setTimeZone(calCurrentDate.getTimeZone());
            String strCurrentDate = dfDate.format(calCurrentDate.getTime());
            Date currentDate = dfDate.parse(strCurrentDate);
            return new Timestamp(currentDate.getTime());
        }
        catch (ParseException e) {
            return new Timestamp(new Date().getTime());
        }
    }  
    
}
