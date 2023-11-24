package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	// Criar collection
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	// Variavel para receber o numero da conta
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {

		Optional<Conta> conta = buscarNaColection(numero);

		if (conta.isPresent()) {
			conta.get().visualizar();

		} else
			System.out.println("A conta " + numero + " não foi encontrada!");
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta número " + conta.getNumero() + " foi criada com sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {

		Optional<Conta> buscaConta = buscarNaColection(conta.getNumero());

		if (buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.println("A conta " + conta.getNumero() + " foi atualizada com sucesso!");
			
		} else
			System.out.println("A conta " + conta.getNumero() + " não foi encontrada!");

	}

	@Override
	public void deletar(int numero) {

		Optional<Conta> conta = buscarNaColection(numero);
		if (conta.isPresent()) {
			if (listaContas.remove(conta.get()) == true)
				System.out.println("A conta " + numero + " foi excluída com sucesso!");
		} else
			System.out.println("A conta " + numero + " não foi encontrada!");

	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferir(int numeroOrigen, int numeroDestino, int valor) {
		// TODO Auto-generated method stub

	}
	// Métodos auxiliares

	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Conta> buscarNaColection(int numero) {

		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return Optional.of(conta);
				// return conta;
			}
		}
		// return null;
		return Optional.empty();
	}

}
