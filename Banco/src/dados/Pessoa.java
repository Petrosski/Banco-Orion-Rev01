package dados;
public class Pessoa {
	private String nome;
	private String nomeRua;
	private int numeroCasa;
	private String complemento;
	private int CEP;
	private String cidade;
	private String UF;
	private String CPF;
	private String profissao;
	private double renda;
	
	
	public Pessoa(String nome, String nomeRua, int numeroCasa, String complemento, int CEP, String cidade, String UF,
			String CPF, String profissao, double renda) {
		this.nome = nome;
		this.nomeRua = nomeRua;
		this.numeroCasa = numeroCasa;
		this.complemento = complemento;
		this.CEP = CEP;
		this.cidade = cidade;
		this.UF = UF;
		this.CPF = CPF;
		this.profissao = profissao;
		this.renda = renda;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeRua() {
		return this.nomeRua;
	}
	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}
	public int getNumeroCasa() {
		return this.numeroCasa;
	}
	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public String getComplemento() {
		return this.complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getCEP() {
		return this.CEP;
	}
	public void setCEP(int CEP) {
		this.CEP = CEP;
	}
	public String getCidade() {
		return this.cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUF() {
		return this.UF;
	}
	public void setUF(String UF) {
		this.UF = UF;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public String getProfissao() {
		return this.profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public double getRenda() {
		return this.renda;
	}
	public void setRenda(double renda) {
		this.renda = renda;
	}
	
	
	
	
}
