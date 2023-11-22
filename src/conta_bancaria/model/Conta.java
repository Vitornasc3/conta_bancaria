package conta_bancaria.model;

public abstract class Conta {

	// Definir os atributos da classe

	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	// Método construtor
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;

	}

	// Métodos Get e Set

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean sacar(float valor) {
		if (this.getSaldo() < valor) {
			System.out.println("\n Saldo insuficiente!");
			return false;
		}

		this.setSaldo(this.saldo - valor);
		return true;

	}

	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}

	// Método auxiliar visualizar

	public void visualizar() {

		String tipo = "";

		switch (this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";
		}

		System.out.println("\n\n***********************************");
		System.out.println("           Dados da conta          ");
		System.out.println("***********************************");
		System.out.println(" Número da conta: " + this.numero);
		System.out.println(" Número da agência: " + this.agencia);
		System.out.println(" Tipo da conta: " + tipo);
		System.out.println(" Titular da conta: " + this.titular);
		System.out.printf(" Saldo da conta: R$%.2f \n", this.saldo);

	}

}
