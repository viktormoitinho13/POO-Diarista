package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import classes.Cliente;

public class TabelaCliente extends Database {
	
    public void mostraDados(Cliente c) {
    	// Apresenta os dados contidos em um objeto Cliente no modo console.
    	
    	System.out.print(c.getCod() + " ");
    	System.out.print(c.getNome() + " ");
    	System.out.print(c.getCpf() + " ");
    	System.out.print(c.getTel() + " ");
    	System.out.print(c.getEnd() + " ");
    	if (c.getCompl() != "")
    		System.out.print(c.getCompl() + " ");
    	System.out.print(c.getBairro() + " ");
    	System.out.print(c.getCid() + " ");
    	System.out.print("\n");
    }
    

    public void inserir(Cliente c) throws Exception {
    	// Recebe um objeto Cliente e insere-o no banco
    	if (teste()) return;
    	
        conn = DriverManager.getConnection(url, user, password);
        
        // Primeiro insere o endereço na tabela residencia
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(
        		"insert into residencia values('"
        		+ c.getEnd()       + "', "
        		+ c.getCep()       + " , '"
        		+ c.getBairro()    + "', '"
        		+ c.getCid()       + "',  "
        		+ "null"           + " ,  "
        		+ c.getTam_total() + " , '"
        		+ c.getCompl()     + "')" 
        );
        
        comando.execute();
        
        
        // Depois, busca o codigo atribuído à nova residência pelo banco
        comando = (PreparedStatement) conn.prepareStatement(
        		"select * from residencia where "
        		+ "logradouro = '"  + c.getEnd()    + "' and "
        		+ "complemento = '" + c.getCompl()  + "' and "
        		+ "cep = "          + c.getCep()    + "  and "
        		+ "bairro = '"      + c.getBairro() + "' and "
        		+ "cidade = '"      + c.getCid()    + "' "
        		+ "order by id_residencia"
        );

        ResultSet resultado = comando.executeQuery();
        if (resultado.last()) {
            c.setEnd_cod(resultado.getInt("id_residencia"));
        }

        
        // Finalmente, adiciona o cliente relacionando-o com a residência
        comando = (PreparedStatement) conn.prepareStatement(
        		"insert into cliente values("
        		+ "null"         + " , '"
        		+ c.getCpf()     + "', '"
        		+ c.getNome()    + "', '"
        		+ c.getTel()     + "',  "
        		+ c.getEnd_cod() + ")"
        );
        
        comando.execute();

        
        comando.close();
        resultado.close();
        conn.close();
        conn = null;
    }

    public void atualizar(int posicao, Cliente c) throws Exception {
    	if (teste()) return;
    	
        conn = DriverManager.getConnection(url, user, password);
        PreparedStatement comando;
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"update cliente set "
        		+ "cpf_cliente = '" + c.getCpf()  + "', "
        		+        "nome = '" + c.getNome() + "', "
        		+    "telefone = '" + c.getTel()  + "'  "
        		+ "where id_cliente = " + posicao
        );
        comando.execute();

        
        comando = (PreparedStatement) conn.prepareStatement(
        		"select * from cliente where id_cliente = " + posicao
        );
        
        int id_res = 0;
        ResultSet resultado = comando.executeQuery();
        if (resultado.first()) {
            id_res = (resultado.getInt("fk_residencia_id_residencia"));
        }
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"update residencia set "
        		+    "logradouro = '" + c.getEnd()       + "', "
				+           "cep =  " + c.getCep()       + " , "
        		+        "bairro = '" + c.getBairro()    + "', "
				+        "cidade = '" + c.getCid()       + "', "
        		+ "tamanho_total =  " + c.getTam_total() + " , "
				+   "complemento = '" + c.getCompl()     + "'  "
				+ "where id_residencia = " + id_res
        );
        comando.execute();
        
        
        comando.close();
        resultado.close();
        conn.close();
        conn = null;
    }
    
    private String formataOpcao(String busca) {
    	if      (busca == "cod")       return "id_cliente";
    	else if (busca == "nome")      return "nome";
    	else if (busca == "cpf")       return "cpf_cliente";
    	else if (busca == "tel")       return "telefone";
    	else if (busca == "end_cod")   return "fk_residencia_id_residencia";
    	
    	else if (busca == "end")       return "logradouro";
    	else if (busca == "cep")       return "cep";
    	else if (busca == "bairro")    return "bairro";
    	else if (busca == "cid")       return "cidade";
    	else if (busca == "tam_total") return "tamanho_total";
    	else if (busca == "compl")     return "complemento";
    	else return busca;
    }

    public ArrayList<Cliente> buscar(String busca, String valor) throws Exception {
    	if (teste()) return null;
        
        conn = DriverManager.getConnection(url, user, password);
        
        
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(
        		"select * from cliente c, residencia r "
        		+ "where id_residencia = fk_residencia_id_residencia " 
        		+ "and " + formataOpcao(busca) + " = '" + valor + "'"
        );
        ResultSet resultado = comando.executeQuery();
        
        ArrayList<Cliente> registros = new ArrayList<>();
        
        while (resultado.next()) {
        	registros.add(
    			new Cliente(
    					resultado.getInt("id_cliente"),
    					resultado.getString("nome"),
    					resultado.getString("cpf_cliente"),
    					resultado.getString("telefone"),
    					resultado.getInt("fk_residencia_id_residencia"),
    					
    					resultado.getString("logradouro"),
    					resultado.getString("cep"),
    					resultado.getString("bairro"),
    					resultado.getString("cidade"),
    					resultado.getString("tamanho_total"),
    					resultado.getString("complemento")
        		)
        	);
        }
        
        
        resultado.close();
        comando.close();
        conn.close();
        conn = null;
        
        return registros;
    }
    
    public ArrayList<Cliente> listar() throws Exception{
    	if (teste()) return null;
        
        conn = DriverManager.getConnection(url, user, password);

        
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(
        		"select * from cliente c, residencia r "
        		+ "where id_residencia = fk_residencia_id_residencia "
        		+ "order by id_cliente "
        );
        ResultSet resultado = comando.executeQuery();
        
        
        ArrayList<Cliente> registros = new ArrayList<>();
        
        while (resultado.next()) {
        	registros.add(
        			new Cliente(
        					resultado.getInt("id_cliente"),
        					resultado.getString("nome"),
        					resultado.getString("cpf_cliente"),
        					resultado.getString("telefone"),
        					resultado.getInt("fk_residencia_id_residencia"),
        					
        					resultado.getString("logradouro"),
        					resultado.getString("cep"),
        					resultado.getString("bairro"),
        					resultado.getString("cidade"),
        					resultado.getString("tamanho_total"),
        					resultado.getString("complemento")
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
        PreparedStatement comando;
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"select * from cliente where id_cliente = " + posicao
        );
        ResultSet resultado = comando.executeQuery();
        
        int id_res = 0;
        if (resultado.first())
        	id_res = resultado.getInt("fk_residencia_id_residencia");
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        			"delete from cliente where id_cliente = " + posicao
        );
        if (id_res != 0) comando.execute();
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"delete from residencia where id_residencia = " + id_res
        );
        if (id_res != 0) comando.execute();
        
        
        comando.close();
        conn.close();
        conn = null;
    }
}