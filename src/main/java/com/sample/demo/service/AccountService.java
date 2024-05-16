package com.sample.demo.service;

import com.sample.demo.entity.Account;

import java.util.List;

public interface AccountService {
        public Account createAccount(Account account);
        public Account getAccountDetailsByAccountNumber(Long accountNumberLong);
        public List<Account> getAllAccountDetails();
        public Account depositAmount(Long AccountNumber,Double  amount );
        public Account withdrawAmount(Long accountNumber,Double amount);
        public  void closeAccount(Long  accountNumber);


        Account getAccountByAccountDetailsByAccountNumber(Long accountNumber);
}
