package com.analyser.bank;

import com.analyser.bank.parsers.BankStatementCSVParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankApplicationTests {

	BankStatementCSVParser csvParser = new BankStatementCSVParser();

	@Test
	void contextLoads() {

	}

}
