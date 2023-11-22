package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository {

	// Implementação do CRUD
	
	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	// Métodos Bancários
	
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigen, int numeroDestino, int valor);
	
}
