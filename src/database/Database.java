package database;

import java.sql.Connection;

public class Database {

	protected static Connection conn = null;
    
    protected static String     user = "root";
    protected static String password = "";
    protected static String     host = "localhost";
    protected static String     gate = "3306";	// No meu pc é a porta que funciona, mas o padrão é 3306
    protected static String database = "proj_diarista";
    
    protected static String      url = "jdbc:mysql://" 
                                       + host + ":" 
    		                           + gate + "/" 
                                       + database 
                                       + "?autoReconnect=true&useSSL=false";
    

    protected boolean teste() throws Exception {
        if (conn != null) {
        	return true;
        }

        try {
        	Class.forName("com.mysql.jdbc.Driver");
        } 
        catch(ClassNotFoundException e) {
            throw new Exception("No database");
        }
        
    	return false;
    }
}