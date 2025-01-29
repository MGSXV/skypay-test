package ma.skypay.bankkata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.skypay.bankkata.services.Account;

@SpringBootApplication
public class BankkataApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankkataApplication.class, args);
		Account account = new Account();
		account.deposit(3);
		account.withdraw(100);
		account.deposit(500);
		account.printStatement();
	}

}
