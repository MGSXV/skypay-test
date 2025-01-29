package ma.skypay.bankkata.repositories;

public interface AccountService {
	void deposit(int amount);
	void withdraw(int amount);
	void printStatement();
}
