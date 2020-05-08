package com.analyser.bank.controllers;

import com.analyser.bank.model.BankTransaction;
import com.analyser.bank.parsers.BankStatementCSVParser;
import com.analyser.bank.processors.BankStatementProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

@RestController
@Component
public class BankStatementAnalyserController {

    private static final String RESOURCES = "src/main/resources/";

    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    @RequestMapping(value= "/upload", method= RequestMethod.POST, headers = "Accept=application/json, application/xml")
    public ResponseEntity<?> upload(@RequestBody String file, BindingResult result){
        return ResponseEntity.ok().body("");
    }

    public static void main(final String... args) throws IOException {
        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is "
                + bankStatementProcessor.calculateTotalAmount());

        System.out.println("The total for transactions in January is "
                + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));

        System.out.println("The total for transactions in February is "
                + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));

        System.out.println("The total salary received is "
                + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
