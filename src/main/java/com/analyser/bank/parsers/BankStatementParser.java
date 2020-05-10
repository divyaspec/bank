package com.analyser.bank.parsers;

import com.analyser.bank.model.BankTransaction;

import java.util.List;

public interface BankStatementParser {
    List<BankTransaction> parseLines(List<String> lines);
}
