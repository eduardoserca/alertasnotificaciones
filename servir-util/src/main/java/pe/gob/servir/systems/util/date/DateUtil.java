package pe.gob.servir.systems.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


	public static boolean isValid(Date fechaInicio, Date fechaFin) {

        Calendar fecIni = Calendar.getInstance();
        fecIni.setTime(fechaInicio);

        Calendar fecFin = Calendar.getInstance();
        fecFin.setTime(fechaFin);

        if (fecFin.before(fecIni)) {
        	return false;
        }else{
        	return true;
        }
	}
	
	public static boolean isToday(Date fechaInicio, Date fechaFin) {

        Calendar fecIni = Calendar.getInstance();
        fecIni.setTime(fechaInicio);

        Calendar fecFin = Calendar.getInstance();
        fecFin.setTime(fechaFin);
        
        fecFin.add(Calendar.DAY_OF_YEAR,1);
        fecFin.getTime();

        if (fecFin.before(fecIni)) {
        	return false;
        }else{
        	return true;
        }
	}
	
	
	public static String convertDateAlfresco(Date fecha){
		String fechaFormato = null;
		if(fecha != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			fechaFormato = sdf.format(fecha); 
		}
		return fechaFormato;
	}
	
	public static String getStringDate(Date fecha){

		String fechaFormato = null;
		if(fecha != null){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			fechaFormato = sdf.format(fecha); 
		}else{
			fechaFormato="";
		}
		return fechaFormato;
	}
	
	public static String datePathRepositoryAlfresco(String pathAlfresco){
		StringBuilder pathAlfrescoFull = new StringBuilder();
		
		Date fecha = new Date();
        SimpleDateFormat formatDia = new SimpleDateFormat("dd");
        SimpleDateFormat formatMes = new SimpleDateFormat("MMMM");
        SimpleDateFormat formatAnio = new SimpleDateFormat("yyyy");
        
        String dia = formatDia.format(fecha);
        String mes = formatMes.format(fecha).toUpperCase();
        String anio = formatAnio.format(fecha);

        pathAlfrescoFull.append(pathAlfresco);
        //pathAlfrescoFull.append("/");
        pathAlfrescoFull.append(anio);
        pathAlfrescoFull.append("/");
        pathAlfrescoFull.append(mes);
        pathAlfrescoFull.append("/");
        pathAlfrescoFull.append(dia);
		
		return pathAlfrescoFull.toString();
	}
	
	public static String convertNameFile(String fileNameComplete){
		StringBuilder fileNameFull = new StringBuilder();
		
		int lengthComplete = fileNameComplete.length();
		int lengthFileName = lengthComplete - 4;
		String fileName = fileNameComplete.substring(0, lengthFileName);
		
		Date hora = new Date();
        
        SimpleDateFormat formatHora = new SimpleDateFormat("HH");
        SimpleDateFormat formatMin = new SimpleDateFormat("mm");
        SimpleDateFormat formatSeg = new SimpleDateFormat("ss");
        
        String hh = formatHora.format(hora);
        String mm = formatMin.format(hora);
        String ss = formatSeg.format(hora);
        
        fileNameFull.append(fileName);
        fileNameFull.append("_");
        fileNameFull.append(hh);
        fileNameFull.append("-");
        fileNameFull.append(mm);
        fileNameFull.append("-");
        fileNameFull.append(ss);
        fileNameFull.append(".pdf");
		
		return fileNameFull.toString();
	}
	
	public static int getDias(Date fInicial, Date fFinal){
		
        Calendar ci = Calendar.getInstance();
        ci.setTime(fInicial);

        Calendar cf = Calendar.getInstance();
        cf.setTime(fFinal);

        long ntime = cf.getTimeInMillis() - ci.getTimeInMillis();

        return (int)Math.ceil((double)ntime / 1000 / 3600 / 24);
    }

	public static String getAnioActual(){
		Date fecha = new Date();
        SimpleDateFormat formatAnio = new SimpleDateFormat("yyyy");
        String anio = formatAnio.format(fecha);
        
        return anio;
    }
	
	public static Date getFechaRegistro(String mes, String anio){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
		String strDate = "01" + "-" + mes + "-" + anio;
		
		Date date = new Date();
		
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static String getMesFechaExt(Date fecha){
        SimpleDateFormat formatMes = new SimpleDateFormat("MM");
        String mes = formatMes.format(fecha);
        
        return mes;
	}
	
	public static String getAnioFechaExt(Date fecha){
        SimpleDateFormat formatAnio = new SimpleDateFormat("yyyy"); 
        String anio = formatAnio.format(fecha);
        
        return anio;
	}
	
}
