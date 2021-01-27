package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import classes.Diarista;

public class TabelaDiarista extends Database{
	
    public void mostraDados(Diarista d) {
    	System.out.print(d.getCod() + " ");
    	System.out.print(d.getNome() + " ");
    	System.out.print(d.getCpf() + " ");
    	System.out.print(d.getTel() + " ");
    	System.out.print(d.getNasc() + " ");
    	System.out.print(d.getEnd() + " ");
    	System.out.print("\n");
    }
    

    public void inserir(Diarista d) throws Exception {
    	if (teste()) return;
    	
        conn = DriverManager.getConnection(url, user, password);

        String Sql = "insert into diarista values("
    		+ "null"      + ",'" 
    		+ d.getNome() + "','" 
    		+ d.getCpf()  + "','" 
    		+ d.getTel()  + "','" 
    		+ d.getNasc() + "','"
    		+ d.getEnd()  + "')"
        ;
        
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
        comando.execute();
        
        comando.close();
        conn.close();
        conn = null;
    }

    public void atualizar(int posicao, Diarista d) throws Exception {
    	if (teste()) return;
    	
        conn = DriverManager.getConnection(url, user, password);

        String Sql = "update diarista set " + 
        		"nome = '"         + d.getNome() + "', " +
        		"cpf_diarista ='"  + d.getCpf()  + "', " +
        		"telefone = '"     + d.getTel()  + "', " +
        		"nascimento = '"   + d.getNasc() + "', " +
        		"endereco = '"     + d.getEnd()  + "' "  +
        		"where num_reg = " + posicao;
        
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
        comando.execute();
        
        comando.close();
        conn.close();
        conn = null;
    }
    
    private String formataOpcao(String busca) {
    	if      (busca == "cod")  return "num_reg";
    	else if (busca == "nome") return "nome";
    	else if (busca == "cpf")  return "cpf_diarista";
    	else if (busca == "tel")  return "telefone";
    	else if (busca == "nasc") return "nascimento";
    	else if (busca == "end")  return "endereco";
    	else return busca;
    }

    public ArrayList<Diarista> buscar(String busca, String valor) throws Exception {
    	if (teste()) return null;
        
        conn = DriverManager.getConnection(url, user, password);
        
        String SqlCom = "select * from diarista where " + formataOpcao(busca) + " = '" + valor + "'";
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(SqlCom);
        ResultSet resultado = comando.executeQuery();
        
        ArrayList<Diarista> registros = new ArrayList<>();
        
        while (resultado.next()) {
        	registros.add(
    			new Diarista(
        			Integer.parseInt(resultado.getString("num_reg")),
        			resultado.getString("nome"),
        			resultado.getString("cpf_diarista"),
        			resultado.getString("telefone"),
        			resultado.getString("nascimento"),
        			resultado.getString("endereco")
        		)
        	);
        }
        
        resultado.close();
        comando.close();
        conn.close();
        conn = null;
        
        return registros;
    }
    
    public ArrayList<Diarista> listar() throws Exception{
    	if (teste()) return null;
        
        conn = DriverManager.getConnection(url, user, password);

        
        String SqlCom = "select * from diarista order by num_reg";
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(SqlCom);
        ResultSet resultado = comando.executeQuery();
        
        ArrayList<Diarista> registros = new ArrayList<>();
        
        int i = 0;
        while (resultado.next()) {
        	registros.add(
    			new Diarista(
        			Integer.parseInt(resultado.getString("num_reg")),
        			resultado.getString("nome"),
        			resultado.getString("nascimento"),
        			resultado.getString("cpf_diarista"),
        			resultado.getString("telefone"),
        			resultado.getString("endereco")
        		)
        	);
        }
        
        resultado.close();
        comando.close();
        conn.close();
        conn = null;
        
        return registros;
    }

    public void remover(int posicao) throws Exception {
    	if (teste()) return;
    	
        conn = DriverManager.getConnection(url, user, password);

        String Sql = "delete from diarista where num_reg = " + posicao;
        
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
        comando.execute();
        
        comando.close();
        conn.close();
        conn = null;
    }
}