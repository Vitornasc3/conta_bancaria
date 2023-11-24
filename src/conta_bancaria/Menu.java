package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 0, agencia, numero, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, rendimento, valor;

		ContaController contas = new ContaController();

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 456, 1, "Felipe", 100000.0f, 2000f);
		contas.cadastrar(cc1);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Claudia", 50000f, 0.4f, 5);
		contas.cadastrar(cp1);

		while (true) {
			System.out.println("");
			System.out.println(theme);
			System.out.println("_______________________________________________________________");
			System.out.println("|*************************************************************|");
			System.out.println("|-------------------------- Banco ----------------------------|");
			System.out.println("|                                                             |");
			System.out.println("|                1 - Criar conta                              |");
			System.out.println("|                2 - Listar todas as contas                   |");
			System.out.println("|                3 - Buscar conta por número                  |");
			System.out.println("|                4 - Atualizar dados da conta                 |");
			System.out.println("|                5 - Deletar conta                            |");
			System.out.println("|                6 - Sacar                                    |");
			System.out.println("|                7 - Depositar                                |");
			System.out.println("|                8 - Transferir valores entre contas          |");
			System.out.println("|                9 - Sair                                     |");
			System.out.println("|                                                             |");
			System.out.println("|*************************************************************|");
			System.out.println("|_____________________________________________________________|");
			System.out.println("  -  Insira opção desejada:                                    " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();

			} catch (InputMismatchException e) {
				// System.out.println("");
				leia.nextLine();
				opcao = 0;
			}

			switch (opcao) {
			case 1 -> {
				System.out.println("                 Opção criar conta selecionada.                \n");

				System.out.println("Digite o número da agência: ");
				agencia = leia.nextInt();
				leia.skip("\\R");

				System.out.println("Digita o nome do titular da conta:");
				titular = leia.nextLine();

				System.out.println("Escolha o tipo da conta:\n1 - Conta Corrente \n2 - Conta Poupança ");
				do {
					tipo = leia.nextInt();
				} while (tipo < 1 || tipo > 2);

				System.out.println("Digite o valor do primeiro depósito: ");
				saldo = leia.nextFloat();

				switch (tipo) {

				case 1 -> {
					System.out.println("Defina o valor do limite: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o aniversário da conta: ");
					aniversario = leia.nextInt();
					System.out.println("Digite a taxa de rendimento da conta: ");
					rendimento = leia.nextFloat();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, rendimento,
							aniversario));
				}

				}
				keyPress();
			}
			case 2 -> {
				System.out.println("            Opção listar todas as contas selecionada.          \n");
				contas.listarTodas();
				keyPress();
			}
			case 3 -> {
				System.out.println("           Opção buscar conta por número selecionada.          \n");

				System.out.println("Digite o número da conta que deseja buscar:");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);

				keyPress();
			}
			case 4 -> {
				System.out.println("            Opção atualizar dados da conta selecionada.        \n");

				System.out.println("Digite o número da conta que deseja atualizar:");
				numero = leia.nextInt();

				Optional<Conta> conta = contas.buscarNaColection(numero);

				if (conta.isPresent()) {

					System.out.println("Digite o número da agência: ");
					agencia = leia.nextInt();
					leia.skip("\\R");

					System.out.println("Digita o nome do titular da conta:");
					titular = leia.nextLine();

					tipo = conta.get().getTipo();

					System.out.println("Digite o valor do saldo atual: ");
					saldo = leia.nextFloat();

					switch (tipo) {

					case 1 -> {
						System.out.println("Defina o valor do limite: ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o aniversário da conta: ");
						aniversario = leia.nextInt();

						System.out.println("Digite a taxa de rendimento da conta: ");
						rendimento = leia.nextFloat();

						contas.atualizar(
								new ContaPoupanca(numero, agencia, tipo, titular, saldo, rendimento, aniversario));
					}

					}

				} else
					System.out.println(" A conta " + numero + " não foi encontrada.");

				keyPress();
			}
			case 5 -> {
				System.out.println("                  Opção deletar conta selecionada.              \n");

				System.out.println("Digite o número da conta que deseja deletar:");
				numero = leia.nextInt();
				contas.deletar(numero);

				keyPress();
			}
			case 6 -> {
				System.out.println("                      Opção sacar selecionada.                 \n");

				System.out.println("Digite o número da conta que deseja efetuar o saque:");
				numero = leia.nextInt();

				System.out.println("Digite o valor do saque:");
				valor = leia.nextFloat();

				contas.sacar(numero, valor);

				keyPress();
			}
			case 7 -> {
				System.out.println("                    Opção depositar selecionada.               \n");

				System.out.println("Digite o número da conta que deseja realizar o depósito:");
				numero = leia.nextInt();

				System.out.println("Digite o valor do depósito:");
				valor = leia.nextFloat();

				contas.depositar(numero, valor);

				keyPress();
			}
			case 8 -> {
				System.out.println("        Opção transferir valores entre contas selecionada.     \n");

				System.out.println("Digita a conta de origem da transferência: ");
				numero = leia.nextInt();

				System.out.println("Digita a conta de destino da transferência: ");
				numeroDestino = leia.nextInt();
				if (numero != numeroDestino) {
					System.out.println("Digite o valor da transferência: ");
					valor = leia.nextFloat();

					contas.transferir(numero, numeroDestino, valor);
				} else
					System.out.println("Os números da contas são iguais");

				keyPress();
			}
			case 9 -> {
				System.out.println("                       Programa encerrado.                     \n");
				keyPress();
				sobre();
				System.exit(0);
			}
			default -> {
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED_UNDERLINED
						+ "                      ** Opção inválida! **                    " + Cores.TEXT_RESET);

			}

			}
		}
	}

	public static void sobre() {
		System.out.println(theme);
		System.out.println("                                                                        ");
		System.out.println("************************************************************************");
		System.out.println(" Projeto conta bancária desenvolvido por: Vitor do Nascimento Ferreira  ");
		System.out.println(" Generation Brasil - generation@generation.org                          ");
		System.out.println(" GitHub: github.com/Vitornasc3/conta_bancaria                           ");
		System.out.println("************************************************************************");
		System.out.println(Cores.TEXT_RESET);
	}

	public static void keyPress() {

		try {
			System.out.println("\n\n  ***  Pressione a tecla Enter para continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla inválida!");
		}
	}

	public static String theme = Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND;

}
