package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import classes.Servico;

public class TabelaServico extends Database {
	
	public void mostraDados(Servico s) {
		System.out.print(s.getCod_cli()  + " ");
		System.out.print(s.getCod_dia()  + " ");
		System.out.print(s.getCod_serv() + " ");

		System.out.print(s.getTempo()    + " ");
		System.out.print(s.getDt_ini()   + " ");
		System.out.print(s.getDt_fin()   + " ");
		System.out.print(s.getTransp()   + " ");
		System.out.print(s.getTaxa()     + " ");

		System.out.print(s.getRp_qtd()   + " ");
		System.out.print(s.getRp_dcr()   + " ");
		System.out.print(s.getRp_vlr()   + " ");

		System.out.print(s.getLp_com()   + " ");
		System.out.print(s.getLp_ban()   + " ");
		System.out.print(s.getLp_qrt()   + " ");
		
		System.out.print("\n");
	}
	
	public void inserir(Servico s) throws Exception {
		if (teste()) return;

        conn = DriverManager.getConnection(url, user, password);
        PreparedStatement comando = null;
        ResultSet resultado = null;
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"insert into servico values("
        		+ "null"        + " ,  "
        		+ s.getTempo()  + " , '"
        		+ s.getDt_ini() + "', '"
        		+ s.getDt_fin() + "',  "
        		+ s.getTransp() + " ,  "
        		+ s.getTaxa()   + " )  "
        );
        comando.execute();
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"select * from servico where "
        		+ "tempo = "         + s.getTempo()  + "  and "
        		+ "data_inicial = '" + s.getDt_ini() + "' and "
        		+ "data_final = '"   + s.getDt_fin() + "' and "
        		+ "transporte = "    + s.getTransp() + "  and "
        		+ "taxa = "          + s.getTaxa()   + "      "
        );
        resultado = comando.executeQuery();
        if (resultado.last()) {
        	s.setCod_serv(resultado.getInt("ordem_serv"));
        }
        

        comando = (PreparedStatement) conn.prepareStatement(
        		"insert into _agenda_cliente_servico_diarista values("
        		+ s.getCod_cli()  + ", "
        		+ s.getCod_serv() + ", "
        		+ s.getCod_dia()  + ") "
        );
        comando.execute();
        

        comando = (PreparedStatement) conn.prepareStatement(
        		"insert into passar_roupa values("
        		+ "null"          + " ,  "
        		+ s.getRp_qtd()   + " , '"
        		+ s.getRp_dcr()   + "',  "
        		+ s.getRp_vlr()   + " ,  "
        		+ s.getCod_serv() + " )  "
        );
        comando.execute();
        

        comando = (PreparedStatement) conn.prepareStatement(
        		"insert into limpeza values("
        		+ "null"          + " ,  "
        		+ s.getLp_com()   + " ,  "
        		+ s.getLp_ban()   + " ,  "
        		+ s.getLp_qrt()   + " ,  "
        		+ s.getCod_serv() + " )  "
        );
        comando.execute();
        
        
        resultado.close();
        comando.close();
        conn.close();
        conn = null;
	}
	
	public void atualizar(int posicao, Servico s) throws Exception {
		if (teste()) return;

        conn = DriverManager.getConnection(url, user, password);
        PreparedStatement comando = null;
        

        comando = (PreparedStatement) conn.prepareStatement(
        		"update servico set "
        		+        "tempo =  " + s.getTempo()  + "  , "
        		+ "data_inicial = '" + s.getDt_ini() + "' , "
        		+   "data_final = '" + s.getDt_fin() + "' , "
        		+   "transporte =  " + s.getTransp() + "  , "
        		+         "taxa =  " + s.getTaxa()   + "    "
        		+ "where ordem_serv = " + posicao
        );
        comando.execute();
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"update passar_roupa set "
        		+ "quantidade =  "  + s.getRp_qtd() + "  , "
        		+  "descricao = '"  + s.getRp_dcr() + "' , "
        		+ "valor_serv =  "  + s.getRp_vlr() + "    "
        		+ "where fk_servico_ordem_serv = " + posicao
        );
        comando.execute();
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"update limpeza set "
        		+   "num_comodo = " + s.getLp_com() + "  , "
        		+ "num_banheiro = " + s.getLp_ban() + "  , "
        		+   "num_quarto = " + s.getLp_qrt() + "    "
        		+ "where fk_servico_ordem_serv = " + posicao
        );
        comando.execute();
        
        
        comando.close();
        conn.close();
        conn = null;
	}
	
	private String formataOpcao(String busca) {
		if      (busca == "cod_cli")  return "a.fk_cliente_cpf_cliente";
		else if (busca == "cod_dia")  return "a.fk_diarista_num_reg";
		else if (busca == "cod_serv") return "s.ordem_serv";

		else if (busca == "tempo")    return "s.tempo";
		else if (busca == "dt_ini")   return "s.data_inicial";
		else if (busca == "dt_fin")   return "s.data_final";
		else if (busca == "transp")   return "s.transporte";
		else if (busca == "taxa")     return "s.taxa";

		else if (busca == "rp_qtd")   return "p.quantidade";
		else if (busca == "rp_dcr")   return "p.descricao";
		else if (busca == "rp_vlr")   return "p.valor_serv";

		else if (busca == "lp_com")   return "l.num_comodo";
		else if (busca == "lp_ban")   return "l.num_banheiro";
		else if (busca == "lp_qrt")   return "l.num_quarto";
		else return busca;
	}
	
	public ArrayList<Servico> buscar(String busca, String valor) throws Exception {
		if (teste()) return null;

        conn = DriverManager.getConnection(url, user, password);
        PreparedStatement comando = null;
        ResultSet resultado = null;
        ArrayList<Servico> registros = new ArrayList<>();
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"select * from _agenda_cliente_servico_diarista a, servico s, passar_roupa p, limpeza l "
        		+ "where a.fk_servico_ordem_serv = s.ordem_serv "
        		+ "and p.fk_servico_ordem_serv = s.ordem_serv "
        		+ "and l.fk_servico_ordem_serv = s.ordem_serv "
        		+ "and " + formataOpcao(busca) + " = '" + valor + "'"
        );
        resultado = comando.executeQuery();

        while (resultado.next()) {
        	registros.add(
        		new Servico(
        			resultado.getInt("fk_cliente_cpf_cliente"),
        			resultado.getInt("fk_diarista_num_reg"),
        			resultado.getInt("ordem_serv"),
        			
        			resultado.getInt("tempo"),
        			resultado.getString("data_inicial"),
        			resultado.getString("data_final"),
        			resultado.getDouble("transporte"),
        			resultado.getDouble("taxa"),
        			
        			resultado.getInt("quantidade"),
        			resultado.getString("descricao"),
        			resultado.getDouble("valor_serv"),
        			
        			resultado.getInt("num_comodo"),
        			resultado.getInt("num_banheiro"),
        			resultado.getInt("num_quarto")
        		)
        	);
        }
        
        
        resultado.close();
        comando.close();
        conn.close();
        conn = null;
		
		return registros;
	}
	
	public ArrayList<Servico> listar() throws Exception {
		if (teste()) return null;

        conn = DriverManager.getConnection(url, user, password);
        PreparedStatement comando = null;
        ResultSet resultado = null;
        ArrayList<Servico> registros = new ArrayList<>();
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"select * from _agenda_cliente_servico_diarista a, servico s, passar_roupa p, limpeza l "
        		+ "where a.fk_servico_ordem_serv = s.ordem_serv "
        		+ "and p.fk_servico_ordem_serv = s.ordem_serv "
        		+ "and l.fk_servico_ordem_serv = s.ordem_serv "
        );
        resultado = comando.executeQuery();

        while (resultado.next()) {
        	registros.add(
        		new Servico(
        			resultado.getInt("fk_cliente_cpf_cliente"),
        			resultado.getInt("fk_diarista_num_reg"),
        			resultado.getInt("ordem_serv"),
        			
        			resultado.getInt("tempo"),
        			resultado.getString("data_inicial"),
        			resultado.getString("data_final"),
        			resultado.getDouble("transporte"),
        			resultado.getDouble("taxa"),
        			
        			resultado.getInt("quantidade"),
        			resultado.getString("descricao"),
        			resultado.getDouble("valor_serv"),
        			
        			resultado.getInt("num_comodo"),
        			resultado.getInt("num_banheiro"),
        			resultado.getInt("num_quarto")
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
        PreparedStatement comando = null;
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"delete from limpeza where fk_servico_ordem_serv = " + posicao
        );
        comando.execute();
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"delete from passar_roupa where fk_servico_ordem_serv = " + posicao
        );
        comando.execute();
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"delete from _agenda_cliente_servico_diarista where fk_servico_ordem_serv = " + posicao
        );
        comando.execute();
        
        
        comando = (PreparedStatement) conn.prepareStatement(
        		"delete from servico where ordem_serv = " + posicao
        );
        comando.execute();
        
        
        comando.close();
        conn.close();
        conn = null;
	}
	
//	public Servico gerarBoleto(int posicao) throws Exception {}
}
