package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 0;
		while (true) {
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
				System.out.println(theme +"                 Opção criar conta selecionada.                ");
			}
			case 2 -> {
				System.out.println(theme +"            Opção listar todas as contas selecionada.          ");
			}
			case 3 -> {
				System.out.println(theme +"           Opção buscar conta por número selecionada.          ");
			}
			case 4 -> {
				System.out.println(theme +"            Opção atualizar dados da conta selecionada.        ");
			}
			case 5 -> {
				System.out.println(theme +"                  Opção apagar conta selecionada.              ");
			}
			case 6 -> {
				System.out.println(theme +"                      Opção sacar seçecionada.                 ");
			}
			case 7 -> {
				System.out.println(theme +"                    Opção depositar selecionada.               ");
			}
			case 8 -> {
				System.out.println(theme +"        Opção transferir valores entre contas selecionada.     ");
			}
			case 9 -> {
				System.out.println(theme +"                       Programa encerrado.                     ");
				sobre();
				System.exit(0);
				}
			default -> {
				System.out.println(theme + "                       Opção inválida!                         ");

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

	
}
