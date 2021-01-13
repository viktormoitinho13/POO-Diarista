package classes;

public class Diarista {
	private    int cod;
	private String nome;
	private String nasc;
	private String cpf;
	private String tel;
	private String end;
	
	public Diarista() {}
	
	public Diarista(String nome, String nasc, String cpf, String tel, String end) {
		this.nome = nome;
		this.nasc = nasc;
		this.cpf  = cpf;
		this.tel  = tel;
		this.end  = end;
	}
	
	public Diarista(int cod, String nome, String nasc, String cpf, String tel, String end) {
		this.cod  = cod;
		this.nome = nome;
		this.nasc = nasc;
		this.cpf  = cpf;
		this.tel  = tel;
		this.end  = end;
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

	public String getNasc() {
		return nasc;
	}

	public void setNasc(String nasc) {
		this.nasc = nasc;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
}
