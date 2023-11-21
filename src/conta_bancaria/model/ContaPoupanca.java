package conta_bancaria.model;

public class ContaPoupanca extends Conta{

	private float rendimento;
	private int aniversario;
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, float rendimento, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.rendimento = rendimento;		
		this.aniversario = aniversario;
	}

	public float getRendimento() {
		return rendimento;
	}

	public void setRendimento(float rendimento) {
		this.rendimento = rendimento;
	}
	
		
	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf(" Data aniversário: %d", this.aniversario);
		System.out.printf("\n Rendimento mensal: %.1f%%", this.rendimento);
		System.out.printf("\n Estimativa de rendimento mensal: R$ %.2f", ((this.rendimento * getSaldo()) / 100));
	}

}
