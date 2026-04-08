package com.turkcell;

import java.util.List;
import java.util.ArrayList;

public class InMemoryAccountRepository implements AccountRepository 
{

    private List<Account> accounts = new ArrayList<>();

    
    public void register(Account account) {
        if(account == null){
            System.out.println("Hata: Hesap bilgileri boş olamaz!");
            return;
        }
        accounts.add(account);
        System.out.println("-> Kayıt başarılı! Hesap numaranız: " + account.getAccountNumber());
    }

    public Account login(String identityNumber, String password) {
        for (Account account : accounts) {
            if (account.getIdentityNumber().equals(identityNumber) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null; // Giriş başarısız
    }

    public void deposit(Account account, double amount) {
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            account.addTransaction(new Transaction("Deposit", amount));
        }
    }

    public void withdraw(Account account, double amount) {
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            account.addTransaction(new Transaction("Withdrawal", amount));
        }
    }

    public void transfer(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount != null && toAccount != null && fromAccount.getBalance() >= amount) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            fromAccount.addTransaction(new Transaction("Transfer withdrawal", amount));
            toAccount.setBalance(toAccount.getBalance() + amount);
            toAccount.addTransaction(new Transaction("Transfer deposit", amount));
        }
    }

    public List<Account> findAll() {
        return accounts;
    }

    public List<Transaction> getTransactionHistory(Account account) {
       if(account == null){
           System.out.println("Hata: Hesap bilgileri boş olamaz!");
           return new ArrayList<>();
       }
       return account.getTransactionHistory();
    }

}

