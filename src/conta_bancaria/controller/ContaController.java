package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	
	public void procurarPorNome(String titular) {
		
		List<Conta> listaNomes = listaContas.stream()
				.filter(c -> c.getTitular().contains(titular))
				.collect(Collectors.toList());
		
		for(var conta : listaNomes)
			conta.visualizar();
		
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
		
		Optional<Conta> conta = buscarNaColection(numero);
		
		if (conta.isPresent()) {
			if (conta.get().sacar(valor) == true)
				System.out.printf("O saque de R$%.2f foi efetuado com sucesso!", valor);
				System.out.printf("\nSaldo restante: R$%.2f", conta.get().getSaldo());
		} else
			System.out.println("A conta " + numero + " não foi encontrada!");

	}

	@Override
	public void depositar(int numero, float valor) {
		
		Optional<Conta> conta = buscarNaColection(numero);
		
		if (conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.printf("O depósito de R$%.2f foi efetuado com sucesso!", valor);
			System.out.printf("\nNovo saldo: R$%.2f", conta.get().getSaldo());
		} else
			System.out.println("A conta " + numero + " não foi encontrada!");
	}

	@Override
	public void transferir(int numeroOrigen, int numeroDestino, float valor) {
		Optional<Conta> contaOrigen = buscarNaColection(numeroOrigen);
		Optional<Conta> contaDestino = buscarNaColection(numeroDestino);
		
		if (contaOrigen.isPresent() && contaDestino.isPresent() ) {
			if (contaOrigen.get().sacar(valor) == true) {
				contaDestino.get().depositar(valor);
				System.out.println("Transferência efetuada com sucesso!");
				System.out.printf("\nSaldo atual da conta origem: R$%.2f", contaOrigen.get().getSaldo());
				System.out.printf("\nSaldo atual da conta destino: R$%.2f", contaDestino.get().getSaldo());
			}
			
		}else
			System.out.println("Falha na transferência, conta inválida!");
		

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
