package ProjectVnb;

public class CurrentAccount extends Account implements BankingOperations {
	private double balance;
	private double limitCredit;

	public CurrentAccount(String office, String titleHolder, String cpf, double limitCredit) {
		super(office, titleHolder, cpf);
		this.limitCredit = limitCredit;
	}

	public void withdraw(double value) {
		if (value <= balance + limitCredit) {
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
		if (value <= balance + limitCredit) {
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

	public double getLimitCredit() {
		return limitCredit;
	}

	public void setLimitCredit(double limitCredit) {
		this.limitCredit = limitCredit;
	}
}