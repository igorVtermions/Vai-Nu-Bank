package ProjectVnb;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bank bank = new Bank();

		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Criar conta corrente");
			System.out.println("2. Criar conta poupança");
			System.out.println("3. Realizar operações bancárias");
			System.out.println("4. Visualizar todas as contas");
			System.out.println("5. Buscar uma conta pelo número");
			System.out.println("6. Sair");

			System.out.print("Escolha uma opção: ");
			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
			case 1:
				System.out.print("Agência: ");
				String officeCC = scanner.nextLine();
				System.out.print("Nome do titular: ");
				String titleHolderCC = scanner.nextLine();
				System.out.print("CPF: ");
				String cpfCC = scanner.nextLine();
				System.out.print("Limite de crédito: ");
				double limitCredit = scanner.nextDouble();
				CurrentAccount currentAccount = new CurrentAccount(officeCC, titleHolderCC, cpfCC, limitCredit);
				bank.addAccount(currentAccount);
				break;

			case 2:
				System.out.print("Agência: ");
				String officeCP = scanner.nextLine();
				System.out.print("Nome do titular: ");
				String titleHolderCP = scanner.nextLine();
				System.out.print("CPF: ");
				String cpfCP = scanner.nextLine();
				System.out.print("Dia do aniversário: ");
				int birthday = scanner.nextInt();
				SavingsAccount savingsAccount = new SavingsAccount(officeCP, titleHolderCP, cpfCP, birthday);
				bank.addAccount(savingsAccount);
				break;

			case 3:
				System.out.print("Digite o número da conta: ");
				int numberAccount = scanner.nextInt();
				Account account = bank.searchAccount(numberAccount);

				if (account != null) {
					System.out.println("Operações para a conta: " + account);
					System.out.println("1. Sacar");
					System.out.println("2. Depositar");
					System.out.println("3. Transferir");
					int operation = scanner.nextInt();

					switch (operation) {
					case 1:
						System.out.print("Digite o valor a sacar: ");
						double valueWithdraw = scanner.nextDouble();
						account.withdraw(valueWithdraw);
						break;

					case 2:
						System.out.print("Digite o valor a depositar: ");
						double valueDeposit = scanner.nextDouble();
						account.deposit(valueDeposit);
						break;

					case 3:
						System.out.print("Digite o número da conta de destino: ");
						int numberAccountDestination = scanner.nextInt();
						Account accountDestination = bank.searchAccount(numberAccountDestination);

						if (accountDestination != null) {
							System.out.print("Digite o valor a transferir: ");
							double valueTransfer = scanner.nextDouble();
							account.transfer(accountDestination, valueTransfer);
						} else {
							System.out.println("Conta de destino não encontrada.");
						}
						break;

					default:
						System.out.println("Opção inválida.");
						break;
					}
				} else {
					System.out.println("Conta não encontrada.");
				}
				break;

			case 4:
				bank.viewAccounts();
				break;

			case 5:
				System.out.print("Digite o número da conta: ");
				int numberAccountSearch = scanner.nextInt();
				Account searchAccount = bank.searchAccount(numberAccountSearch);

				if (searchAccount != null) {
					System.out.println("Conta encontrada: " + searchAccount);
				} else {
					System.out.println("Conta não encontrada.");
				}
				break;

			case 6:
				System.out.println("Saindo do programa. Até mais!");
				System.exit(0);
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}
}