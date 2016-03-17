package pe.gob.servir.sistemas.alertanotificaciones.presentacion.utilidad;

import java.io.Serializable;

/**
 * Created by jarvis on 13/03/2016.
 */
public class GeneralConstants implements Serializable {

    private static final long serialVersionUID = 7193349600335565187L;

    public static final String DATE_PATTERN_OPTIONAL = "ddMMyyyy";
    public static final String DATE_PATTERN_MINIMAL = "ddMMyy";
    public static final String DATE_PATTERN_MINIMAL_REV = "yyMMdd";
    public static final String HOUR_PATTERN_OPTIONAL = "HHMMs";
    public static final String DATETIME_PATTERN = "ddMMyyyyHHmmss";
    public static final String DATETIME_HOURS_PATTERN = "yyyyMMddHHmm";
    public static final String DATE_PATTERN_BILLING = "yyyyMMdd";
    public static final String HOUR_PATTERN = "HH:mm:ss";
    public static final String YEAR_PATTERN = "yyyy";
    public static final String STR_BLANK = "";
    public static final String STR_ZERO = "0";
    public static final String STR_ONE = "1";
    public static final String HYPHEN ="-";
    public static final Integer[] NO_UTIL_DAYS = new Integer[]{7, 1};
    public static final String CHARACTER_TRUNCATE_STRING = ".....";
    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final String TIMESTAMP_PATTERN = "dd/MM/yyyy HH:mm:ss.SSS";


    public static final String TABLA_ESTADOS = "TBL_ESTADO";
    public static final String ESTADO_ELIMINADO = "E";


}
