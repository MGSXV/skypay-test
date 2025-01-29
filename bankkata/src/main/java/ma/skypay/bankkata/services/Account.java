package ma.skypay.bankkata.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ma.skypay.bankkata.models.Transaction;
import ma.skypay.bankkata.repositories.AccountService;

@Service
public class Account implements AccountService {
	private int balance = 0;
	private final List<Transaction> transactions = new ArrayList<>();


	public int getBalance() {
		return balance;
	}

	@Override
	public void deposit(int amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Deposit amount must be positive");
		}
		balance += amount;
		transactions.add(new Transaction(getCurrentDate(), amount, balance));
	}

	@Override
	public void withdraw(int amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Withdrawal amount must be positive");
		}
		if (amount > balance) {
			throw new IllegalArgumentException("Insufficient balance");
		}
		balance -= amount;
		transactions.add(new Transaction(getCurrentDate(), -amount, balance));
	}

	@Override
	public void printStatement() {
		StatementPrinter.printStatement(transactions);
	}

	private String getCurrentDate() {
		return java.time.LocalDate.now().toString();
	}
	
}
