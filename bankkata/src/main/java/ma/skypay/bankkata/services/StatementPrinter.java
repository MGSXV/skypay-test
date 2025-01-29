package ma.skypay.bankkata.services;

import java.util.List;

import ma.skypay.bankkata.models.Transaction;

public class StatementPrinter {
	public static void printStatement(List<Transaction> transactions) {
		System.out.println("Date	   | Amount | Balance");
		for (int i = transactions.size() - 1; i >= 0; i--) {
			Transaction transaction = transactions.get(i);
			System.out.printf("%s | %6d | %7d%n", transaction.getDate(), transaction.getAmount(), transaction.getBalance());
		}
	}
}