package classes;

public class Cliente {
	/* A Classe Cliente trata os dados das tablelas cliente e residencia como
	 * se fossem uma só. Não apenas nos atributos, mas nas operações também */
	
	
	private int    cod;
	private String nome;
	private String cpf;
	private String tel;
	private int    end_cod;
	
	private String end;
	private String cep;
	private String bairro;
	private String cid;
	private int    tam_total;
	private String compl;
	
	// Inicializa vazia
	public Cliente() {}
	
	// Alguns argumentos, usada para testes rápidos
	public Cliente(String nome, String cpf, String tel, String end) {
		this.cod       = 0;
		this.nome      = nome;
		this.cpf       = cpf;
		this.tel       = tel;
		this.end_cod   = 0;
		
		this.end       = end;
		this.cep       = "0";
		this.bairro    = "Not Null Value";
		this.cid       = "Not Null Value";
		this.tam_total = 0;
		this.compl     = "";
	}
	
	// Também usada para testes rápidos, mas com complemento
	public Cliente(String nome, String cpf, String tel, String end, String compl) {
		this.cod       = 0;
		this.nome      = nome;
		this.cpf       = cpf;
		this.tel       = tel;
		this.end_cod   = 0;
		
		this.end       = end;
		this.cep       = "0";
		this.bairro    = "Not Null Value";
		this.cid       = "Not Null Value";
		this.tam_total = 0;
		this.compl     = compl;
	}
	
	// Preenchimento completo da classe
	public Cliente(int cod, String nome, String cpf, String tel, int end_cod, String end, String cep, String bairro, String cid, int tam_total, String compl) {
		this.cod       = cod;
		this.nome      = nome;
		this.cpf       = cpf;
		this.tel       = tel;
		this.end_cod   = end_cod;
		
		this.end       = end;
		this.cep       = cep;
		this.bairro    = bairro;
		this.cid       = cid;
		this.tam_total = tam_total;
		this.compl     = compl;
	}
	
	public Cliente getCliente() {
		return this;
	}
	
	public void setCliente(Cliente c) {
		this.cod  = c.cod;
		this.nome = c.nome;
		this.cpf  = c.cpf;
		this.tel  = c.tel;
		this.end  = c.end;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getEnd_cod() {
		return end_cod;
	}

	public void setEnd_cod(int end_cod) {
		this.end_cod = end_cod;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public int getTam_total() {
		return tam_total;
	}

	public void setTam_total(int tam_total) {
		this.tam_total = tam_total;
	}

	public String getCompl() {
		return compl;
	}

	public void setCompl(String compl) {
		this.compl = compl;
	}
}
