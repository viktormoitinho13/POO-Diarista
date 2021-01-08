package diarista;

public class Teste {

	public static void main(String[] args) throws Exception {
		Database db = new Database();
		db.inserir("Getúlio Vargas", "varguinhasmilgrau@email.com");
		db.listar();
	}

}
