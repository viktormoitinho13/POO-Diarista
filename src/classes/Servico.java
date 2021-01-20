package classes;

public class Servico {
	private int    cod_cli;
	private int    cod_dia;
	private int    cod_serv;
	
	private int    tempo;
	private String dt_ini;
	private String dt_fin;
	private double transp;
	private double taxa;
	
	private int    rp_qtd;
	private String rp_dcr;
	private double rp_vlr;
	
	private int    lp_com;
	private int    lp_ban;
	private int    lp_qrt;
	
	
	public Servico() {}
	
	public Servico(
		int cod_cli, int    cod_dia, 
		int tempo,   String dt_ini,  String dt_fin, double transp, double taxa,
		int rp_qtd,  String rp_dcr,  double  rp_vlr,
		int lp_com,  int    lp_ban,  int    lp_qrt
	) {
		this.cod_cli = cod_cli;
		this.cod_dia = cod_dia;
		
		this.tempo   = tempo;
		this.dt_ini  = dt_ini;
		this.dt_fin  = dt_fin;
		this.transp  = transp;
		this.taxa    = taxa;
		
		this.rp_qtd  = rp_qtd;
		this.rp_dcr  = rp_dcr;
		this.rp_vlr  = rp_vlr;
		
		this.lp_com  = lp_com;
		this.lp_ban  = lp_ban;
		this.lp_qrt  = lp_qrt;
	}
	
	public Servico(
		int cod_cli, int    cod_dia, int cod_serv,
		int tempo,   String dt_ini,  String dt_fin, double transp, double taxa,
		int rp_qtd,  String rp_dcr,  double  rp_vlr,
		int lp_com,  int    lp_ban,  int    lp_qrt
	) {
		this.cod_cli  = cod_cli;
		this.cod_dia  = cod_dia;
		this.cod_serv = cod_serv;
		
		this.tempo    = tempo;
		this.dt_ini   = dt_ini;
		this.dt_fin   = dt_fin;
		this.transp   = transp;
		this.taxa     = taxa;
		
		this.rp_qtd   = rp_qtd;
		this.rp_dcr   = rp_dcr;
		this.rp_vlr   = rp_vlr;
		
		this.lp_com   = lp_com;
		this.lp_ban   = lp_ban;
		this.lp_qrt   = lp_qrt;
	}


	public int getCod_cli() {
		return cod_cli;
	}


	public void setCod_cli(int cod_cli) {
		this.cod_cli = cod_cli;
	}


	public int getCod_dia() {
		return cod_dia;
	}


	public void setCod_dia(int cod_dia) {
		this.cod_dia = cod_dia;
	}


	public int getCod_serv() {
		return cod_serv;
	}


	public void setCod_serv(int cod_serv) {
		this.cod_serv = cod_serv;
	}


	public int getTempo() {
		return tempo;
	}


	public void setTempo(int tempo) {
		this.tempo = tempo;
	}


	public String getDt_ini() {
		return dt_ini;
	}


	public void setDt_ini(String dt_ini) {
		this.dt_ini = dt_ini;
	}


	public String getDt_fin() {
		return dt_fin;
	}


	public void setDt_fin(String dt_fin) {
		this.dt_fin = dt_fin;
	}


	public double getTransp() {
		return transp;
	}


	public void setTransp(float transp) {
		this.transp = transp;
	}


	public double getTaxa() {
		return taxa;
	}


	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}


	public int getRp_qtd() {
		return rp_qtd;
	}


	public void setRp_qtd(int rp_qtd) {
		this.rp_qtd = rp_qtd;
	}


	public String getRp_dcr() {
		return rp_dcr;
	}


	public void setRp_dcr(String rp_dcr) {
		this.rp_dcr = rp_dcr;
	}


	public double getRp_vlr() {
		return rp_vlr;
	}


	public void setRp_vlr(float rp_vlr) {
		this.rp_vlr = rp_vlr;
	}


	public int getLp_com() {
		return lp_com;
	}


	public void setLp_com(int lp_com) {
		this.lp_com = lp_com;
	}


	public int getLp_ban() {
		return lp_ban;
	}


	public void setLp_ban(int lp_ban) {
		this.lp_ban = lp_ban;
	}


	public int getLp_qrt() {
		return lp_qrt;
	}


	public void setLp_qrt(int lp_qrt) {
		this.lp_qrt = lp_qrt;
	}
}
