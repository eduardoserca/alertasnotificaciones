package pe.gob.servir.systems.util.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Conexion {
	
	
	public static void closeResultSet(ResultSet rs) {
		if (rs!=null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void closeCallableStatement(CallableStatement cstm) {
		
		if (cstm!=null) {
			try {
				cstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConnection(Connection cn){
		
		if(cn!=null){
			try {
				if (!cn.isClosed()) {
					cn.close();	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeSqlConnections(ResultSet rs, CallableStatement cstm, Connection cn) {
		closeResultSet(rs);
		closeCallableStatement(cstm);
		//closeConnection(cn);
	}
	
	public static void closeSqlConnections(ResultSet rs, CallableStatement cstm) {
		closeResultSet(rs);
		closeCallableStatement(cstm);
		
	}
	
	public static void closeSqlConnections(CallableStatement cstm, Connection cn) {
		
		closeCallableStatement(cstm);
		closeConnection(cn);
	}
	
}

