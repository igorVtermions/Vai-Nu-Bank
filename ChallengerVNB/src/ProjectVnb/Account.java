package ProjectVnb;

import java.util.Random;

public abstract class Account {

	protected String accountNumber;
	protected String office;
	protected String titleHolder;
	protected String cpf;
	protected double balance;

	public Account(String office, String titleHolder, String cpf) {
		this.accountNumber = generateAccountNumber();
		this.office = generateAgencyNumber();
		this.titleHolder = titleHolder;
		if (cpfValid(cpf)) {
			this.cpf = cpf;
		} else {
			throw new IllegalArgumentException("CPF deve ter exatamente 11 dígitos.");
		}
		this.balance = 0;
	}

	private boolean cpfValid(String cpf) {
		return cpf != null && cpf.matches("\\d{11}");
	}

	private String generateAgencyNumber() {
		Random random = new Random();
		int numberAgency = random.nextInt(9000) + 1000;
		return String.valueOf(numberAgency);
	}

	private String generateAccountNumber() {
		Random random = new Random();
		int numberAccount = random.nextInt(900000) + 100000;
		return String.valueOf(numberAccount);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOffice() {
		return office;
	}

	public String getTitleHolder() {
		return titleHolder;
	}

	public String getCpf() {
		return cpf;
	}

	public String toString() {
		return "Conta{" + "numeroConta=" + accountNumber + ", agencia='" + office + '\'' + ", nomeTitular='"
				+ titleHolder + '\'' + ", cpf='" + cpf + '\'' + '}';
	}

	public void deposit(double value) {
		balance += value;
		System.out.println("Depósito realizado com sucesso. Saldo atual: " + balance);
	}

	public void withdraw(double value) {
		if (value <= balance) {
			balance -= value;
			System.out.println("Saque realizado com sucesso. Saldo atual: " + balance);
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}

	public void transfer(Account destination, double value) {
		if (value <= balance) {
			balance -= value;
			destination.deposit(value);
			System.out.println("Transferência realizada com sucesso. Saldo atual: " + balance);
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}
	
	 public void displayInformation() {
	        System.out.println("Nome do Titular: " + titleHolder);
	        System.out.println("CPF: " + cpf);
	        System.out.println("Agência: " + office);
	        System.out.println("Número da Conta: " + accountNumber);
	        System.out.println("Saldo: " + balance);
	    }
}
