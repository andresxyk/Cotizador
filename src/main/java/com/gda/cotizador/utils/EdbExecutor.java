package com.gda.cotizador.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EdbExecutor {

	public void executeWithEdbDriver (String query, String url, String usr, String pwd) throws ClassNotFoundException, SQLException {
		Connection con = null;
		try{
		
		 Class.forName("com.edb.Driver");
		 
		 con = DriverManager.getConnection(url, usr, pwd);
		 
		 Statement stmt = con.createStatement();
		 stmt.execute(query);
			
		}catch(Exception e){
			throw e;
			
		}finally {
			con.close();
		}
	}
	
	public Connection getConnetion(String url, String usr, String pwd) throws Exception{
		Connection con = null;
		try{
		
		 Class.forName("com.edb.Driver");
		 
		 con = DriverManager.getConnection(url, usr, pwd);
		 con.setAutoCommit(false);
		}catch(Exception e){
			throw e;			
		}
		return con;
	}
   
}

