package ProjectVnb;

public class SavingsAccount extends Account implements BankingOperations {
	private int birthday;

	public SavingsAccount(String office, String titleHolder, String cpf, int birthday) {
		super(office, titleHolder, cpf);
		this.birthday = birthday;
	}

	public void withdraw(double value) {
		if (value <= balance) {
			balance -= value;
			System.out.println("Saque realizado com sucesso. Saldo atual: " + balance);
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}

	public void deposit(double value) {
		balance += value;
		System.out.println("Depósito realizado com sucesso. Saldo atual: " + balance);
	}

	public void transfer(Account recipient, double value) {
		if (value <= balance) {
			balance -= value;
			recipient.deposit(value);
			System.out.println("Transferência realizada com sucesso. Saldo atual: " + balance);
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
}