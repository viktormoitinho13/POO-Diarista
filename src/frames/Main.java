package frames;

import java.util.ArrayList;

import classes.Cliente;
import classes.Diarista;
import database.TabelaCliente;
import database.TabelaDiarista;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws Exception {
		 // Operações com a diarista
		TabelaDiarista db_d = new TabelaDiarista();
		ArrayList<Diarista> reg;
		
		Diarista a = new Diarista(
				"Jessica",
				"1991-06-10",
				"12345678901",
				"11987654321",
				"Rua 12"
		);
		
		Diarista b = new Diarista(
				"Juliana",
				"1995-09-26",
				"00000000001",
				"00000000011",
				"Avenida dos Andes, 695"
		);

		System.out.print("Antes da inserção:\n\n");
		reg = db_d.listar();
		for (int i = 0; i < reg.size(); i++)
			db_d.mostraDados(reg.get(i));
		System.out.print("\n\n");
		
		
		db_d.inserir(a);

		System.out.print("Depois da inserção:\n\n");
		reg = db_d.listar();
		for (int i = 0; i < reg.size(); i++)
			db_d.mostraDados(reg.get(i));
		System.out.print("\n\n");
		
		
		int posicao = 0;
		reg = db_d.buscar("nome", "Jessica");
		if (reg.size() != 0) 
			posicao = reg.get(0).getCod();

		
		db_d.atualizar(posicao, b);

		System.out.print("Depois de atualizar os campos:\n\n");
		reg = db_d.listar();
		for (int i = 0; i < reg.size(); i++)
			db_d.mostraDados(reg.get(i));
		System.out.print("\n\n");
		
		
		db_d.remover(posicao);

		System.out.print("Depois da exclusão:\n\n");
		reg = db_d.listar();
		for (int i = 0; i < reg.size(); i++)
			db_d.mostraDados(reg.get(i));
		System.out.print("\n\n");
		
		
		System.out.print("Busca por nome:\n\n");
		reg = db_d.buscar("nome", "sara");
		for (int i = 0; i < reg.size(); i++)
			db_d.mostraDados(reg.get(i));
		System.out.print("\n\n");
		
		
		
		/*
		// Operações com o cliente
		TabelaCliente  db_c = new TabelaCliente();
		
		db_c.remover(5);
		ArrayList<Cliente> registros = db_c.listar();
		
		for (int i = 0; i < registros.size(); i++) {
			db_c.mostraDados(registros.get(i));
		}
		*/
	}
	
}
