package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 0, agencia, tipo, aniversario;
		String titular;
		float saldo, limite, rendimento;

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
			System.out.println("|                5 - Apagar conta                             |");
			System.out.println("|                6 - Sacar                                    |");
			System.out.println("|                7 - Depositar                                |");
			System.out.println("|                8 - Transferir valores entre contas          |");
			System.out.println("|                9 - Sair                                     |");
			System.out.println("|                                                             |");
			System.out.println("|*************************************************************|");
			System.out.println("|_____________________________________________________________|");
			System.out.println("  -  Insira opção desejada:                                    " + Cores.TEXT_RESET);
			opcao = leia.nextInt();

			switch (opcao) {
			case 1 -> {
				System.out.println(theme2 + "                 Opção criar conta selecionada.                ");

				System.out.println("Digite o número da agência: ");
				agencia = leia.nextInt();
				leia.skip("\\R");

				System.out.println("Digita o nome do titular da conta:");
				titular = leia.nextLine();

				System.out.println("Escolha o tipo da conta:\n 1 - Conta Corrente \n 2 - Conta Poupança ");
				do {tipo = leia.nextInt();}
				while (tipo < 1 || tipo > 2);

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

			}
			case 2 -> {
				System.out.println(theme2 + "            Opção listar todas as contas selecionada.          ");
				contas.listarTodas();
			}
			case 3 -> {
				System.out.println(theme2 + "           Opção buscar conta por número selecionada.          ");
			}
			case 4 -> {
				System.out.println(theme2 + "            Opção atualizar dados da conta selecionada.        ");
			}
			case 5 -> {
				System.out.println(theme2 + "                  Opção apagar conta selecionada.              ");
			}
			case 6 -> {
				System.out.println(theme2 + "                      Opção sacar seçecionada.                 ");
			}
			case 7 -> {
				System.out.println(theme2 + "                    Opção depositar selecionada.               ");
			}
			case 8 -> {
				System.out.println(theme2 + "        Opção transferir valores entre contas selecionada.     ");
			}
			case 9 -> {
				System.out.println(theme2 + "                       Programa encerrado.                     ");
				sobre();
				System.exit(0);
			}
			default -> {
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED_UNDERLINED + "                      ** Opção inválida! **                    " + Cores.TEXT_RESET);

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

	public static String theme = Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND;
	public static String theme2 = Cores.TEXT_CYAN;

}
