package diarista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;

public class Database {

    private Connection conn;
    
    private static String     user = "root";
    private static String password = "";
    private static String     host = "localhost";
    private static String     gate = "3308";	// No meu pc é a porta que funciona, mas o padrão é 3306
    private static String    table = "pood3_db_teste";
    
    private static String url = "jdbc:mysql://" + host 
    							+ ":" + gate 
    							+ "/" + table 
    							+ "?autoReconnect=true&useSSL=false";
    
    private boolean teste() throws Exception {
    	boolean verify = true;
    	
        if (conn != null) {
        	return verify;
        }

        try {
        	Class.forName("com.mysql.jdbc.Driver");
        } 
        catch(ClassNotFoundException e) {
            throw new Exception("No database");
        }
        
    	verify = false;
    	return verify;
    }
    

    public void inserir(String nome, String email) throws Exception {
    	if (teste()) return;
    	
        conn = DriverManager.getConnection(url, user, password);

        String Sql = "insert into cadastro values(null, '" + nome + "','" + email + "')";
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
        comando.execute();
        
        comando.close();
        conn.close();
        conn = null;
    }
    
    public void listar() throws Exception{
    	//if (teste()) return;
        
        conn = DriverManager.getConnection(url, user, password);

        
        String SqlCom = "select * from cadastro";
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(SqlCom);
        ResultSet resultado = comando.executeQuery();
        ArrayList<String> registros = new ArrayList<>();
        while(resultado.next())
        {
            registros.add(resultado.getString("codigo") + 
                    " " + resultado.getString("nome") + 
                    " " + resultado.getString("email"));
        }
        String lista = "";
        int j;
        for(j=0; j<registros.size(); j++) {
            lista = lista + registros.get(j) + "\n";
        }
        System.out.print(lista);
        
        resultado.close();
        comando.close();
        conn.close();
        conn = null;
    }
}