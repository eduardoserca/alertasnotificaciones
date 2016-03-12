package pe.gob.servir.systems.util.code;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CodeUtil {

	public static String parseEncode( String data) {
		if (data==null) {
			data="";
		}
		try {
			data= URLEncoder.encode(data, "ISO-8859-1");
			data= URLDecoder.decode(data, "UTF-8");			
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error Encode/Decode "+e.getMessage());
			e.printStackTrace();
		}
		return data;
	}
	
}
