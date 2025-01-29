package ma.skypay.bankkata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ma.skypay.bankkata.services.Account;

@SpringBootTest
class BankkataApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void testDeposit() {
		Account accountService = new Account();

		accountService.deposit(1000);
		accountService.deposit(2000);
		accountService.printStatement();
		assertEquals(3000, accountService.getBalance());
	}

	@Test
	void testWithdraw() {
		Account accountService = new Account();
	
		accountService.deposit(3000);
		accountService.withdraw(500);
		accountService.printStatement();
		System.out.println("---------------->" + accountService.getBalance());
		assertEquals(2500, accountService.getBalance());
	}

	@Test
	void testWithdrawInsufficientBalance() {
		Account accountService = new Account();
		assertThrows(IllegalArgumentException.class, () -> {
			accountService.withdraw(1000);
		});
	}

}
