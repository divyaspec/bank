package com.analyser.bank.parsers;

import com.analyser.bank.model.BankTransaction;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BankStatementCSVParserTest {

    private static final String RESOURCES = "src/test/resources/teststatement.csv";
    private BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

    @Test
    void parseLinesFromCSV() throws IOException {
        List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLines(getFileContent());
        assertThat(bankTransactions).isNotEmpty();
        assertThat(bankTransactions).extracting(b -> b.getAmount()).isNotEmpty();
        assertThat(bankTransactions).extracting(b -> b.getDate()).isNotEmpty();
        assertThat(bankTransactions).extracting(b -> b.getDescription()).isNotEmpty();
    }

    public List<String> getFileContent() throws IOException {
        final Path path = Paths.get(RESOURCES);
        return Files.readAllLines(path);
    }
}