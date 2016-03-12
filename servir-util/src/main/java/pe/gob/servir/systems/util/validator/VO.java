package pe.gob.servir.systems.util.validator;

import java.util.List;

public class VO {

	/********************************************************************************************
	 * Empty Verification Methods
	 ********************************************************************************************/

	public static boolean isEmpty(Object obj) {
		if ((obj == null) || (obj.toString().trim().length() == 0)) {
			return true;
		}
		return false;
	}

	public static boolean isNull(Object obj) {
		if ((obj == null)) {
			return true;
		}
		return false;
	}

	public static boolean isEmptyList(List<?> obj) {
		if ((obj == null) || (obj.size() == 0)) {
			return true;
		}
		return false;
	}

	public static boolean isObjectsEquals(Object obj, Object object) {
		if (obj.equals(object)) {
			return true;
		}
		return false;
	}

	public static boolean isEquals(String obj, String object) {
		if (obj.equals(object)) {
			return true;
		}
		return false;
	}

	public static String getLike(String obj, Boolean sw) {

		if (sw) {
			return obj;
		} else {
			return "%" + obj + "%";
		}
	}

	public static String getVoid(String obj) {

		if (obj == null) {
			return "";
		} else {
			return obj;
		}
	}


	public static String getEmpty(String obj) {

		if (obj == null) {
			return "";
		} else {
			return obj;
		}
	}

	public static String getString(String obj) {
		if (obj == null) {
			return "";
		} else {
			return obj;
		}
	}

	public static Integer getInteger(Integer obj) {
		if (obj == null) {
			return 0;
		} else {
			return obj;
		}
	}

	// public static void setCodigoFull(SystemObject so) {
	//
	// if(so==null){
	// so= new SystemObject();
	// }
	//
	// if(so.getEO()==null){
	// so.setEO(new SystemEO());
	// }
	//
	// if (so.getEO().getORG()==null){
	// so.getEO().setORG("");
	// }
	//
	// if (so.getEO().getEMP()==null){
	// so.getEO().setEMP("");
	// }
	//
	// if (so.getEO().getSED()==null){
	// so.getEO().setSED("");
	// }
	//
	// if (so.getCodigo()==null){
	// so.setCodigo("");
	// }
	//
	// if (so.getVersion()==null){
	// so.setVersion("");
	// }
	//
	//
	// }

	// public static void setCodigoFullProc(ProcessObject so) {
	//
	// if(so==null){
	// so= new ProcessObject();
	// }
	//
	// if(so.getEO()==null){
	// so.setEO(new SystemEO());
	// }
	//
	// if (so.getEO().getORG()==null){
	// so.getEO().setORG("");
	// }
	//
	// if (so.getEO().getEMP()==null){
	// so.getEO().setEMP("");
	// }
	//
	// if (so.getEO().getSED()==null){
	// so.getEO().setSED("");
	// }
	//
	// if (so.getPeriodo()==null){
	// so.setPeriodo("");
	// }
	//
	// if (so.getCodigo()==null){
	// so.setCodigo("");
	// }
	//
	// if (so.getVersion()==null){
	// so.setVersion("");
	// }
	// }

	// public static void setVoidCodReg(Tabla tabla) {
	//
	// if(tabla==null){
	// tabla= new Tabla();
	// tabla.setCodReg("");
	// }else if (tabla.getCodReg()==null){
	// tabla.setCodReg("");
	// }
	// }

	public static String getParseLike(Object obj, Boolean sw) {
		return isEmpty(obj) ? "%" : getLike(obj.toString(), sw);
	}

	public static Boolean oldLike(String val) {
		if (!isEmpty(val)) {
			return val.equals("%") || val.equals("%%") || val.equals("%%%");
		}
		return false;
	}

}
