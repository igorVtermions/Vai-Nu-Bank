package ProjectVnb;

public interface BankingOperations {
	void withdraw(double value);
	void deposit(double value);
	void transfer(Account recipient, double value);
}