package com.sample.demo.service;

import com.sample.demo.entity.Account;
import com.sample.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository repo;


    @Override
    public Account createAccount(Account account) {
        return repo.save(account);
    }

    @Override
    public Account getAccountDetailsByAccountNumber(Long accountNumber) {
        Optional<Account> account = repo.findById(accountNumber);
        if (account.isEmpty()) {
            throw new RuntimeException("Account is not present");
        }
        Account account_found = account.get();
        return account_found;
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> listOfAccounts = repo.findAll();
        return listOfAccounts;
    }


    @Override
    public Account depositAmount(Long AccountNumber, Double amount) {

        Optional<Account> account = repo.findById(AccountNumber);
        if (account.isEmpty()) {
            throw new RuntimeException("Account is not present");
        }
        Account accountPresent = account.get();
        double totalBalance = accountPresent.getAccount_balance() + amount;
        accountPresent.setAccount_balance(totalBalance);
        repo.save(accountPresent);
        return accountPresent;
    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) {
        Optional<Account> account = repo.findById(accountNumber);
        if (account.isEmpty()) {
            throw new RuntimeException("Account is not present");
        }
        Account accountPresent = account.get();
        double accountBalance = accountPresent.getAccount_balance() - amount;
        accountPresent.setAccount_balance(accountBalance);
        repo.save(accountPresent);
        return accountPresent;
    }

    @Override
    public void closeAccount(Long accountNumber) {
        getAccountDetailsByAccountNumber(accountNumber);
        repo.deleteById(accountNumber);

    }

    @Override
    public Account getAccountByAccountDetailsByAccountNumber(Long accountNumber) {
        return null;
    }
}