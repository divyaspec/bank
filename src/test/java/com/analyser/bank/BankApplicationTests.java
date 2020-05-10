package com.analyser.bank;

import com.analyser.bank.parsers.BankStatementCSVParser;
import com.analyser.bank.parsers.BankStatementParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankApplicationTests {

	BankStatementParser csvParser = new BankStatementCSVParser();

	@Test
	void contextLoads() {

	}

}
