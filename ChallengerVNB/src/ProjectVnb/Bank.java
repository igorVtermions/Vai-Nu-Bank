package ProjectVnb;

import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> Accounts;

	public Bank() {
		this.Accounts = new ArrayList<>();
	}

	public void addAccount(Account account) {
		Accounts.add(account);
		System.out.println("Conta adicionada com sucesso.");
	}

	public void deleteAccount(int accountNumbe) {
		Accounts.removeIf(account -> account.getAccountNumber().equals(String.valueOf(accountNumbe)));
		System.out.println("Conta excluída com sucesso.");
	}

	public Account searchAccount(int accountNumbe) {
		for (Account account : Accounts) {
			if (account.getAccountNumber().equals(String.valueOf(accountNumbe))) {
				return account;
			}
		}
		return null;
	}

	public void viewAccounts() {
		for (Account account : Accounts) {
			Main.displayInformation(account);
		}
	}
}
