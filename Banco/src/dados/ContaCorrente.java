package dados;
public class ContaCorrente {
	private int numeroConta;
	private String agencia;
	private double saldo;
	private Pessoa pessoa;
	private double limiteConta;

	public double getLimiteConta() {
		return this.limiteConta;
	}

	public void setLimiteConta(double limiteConta) {
		this.limiteConta = limiteConta*2;
	}
		
	public int getNumeroConta() {
		return this.numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public String getAgencia() {
		return this.agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo += saldo;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public boolean sacar(double valor) {
		if(this.saldo > valor) {
			this.saldo -= valor;
			return true;
		} 
		return false;
	}
	
	public boolean transferir(ContaCorrente destinatario, double valor) {
		if (this.sacar(valor)) {
			destinatario.setSaldo(valor);
			return true;
		}
		return false;
	}

}
