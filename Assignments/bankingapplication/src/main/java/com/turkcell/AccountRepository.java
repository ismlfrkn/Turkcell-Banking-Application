package com.turkcell;

import java.util.List;

public interface AccountRepository { //Interace yapmamızın sebebi in-memory belki daha sonra db bağlantısı oluşturulduğunda bu interface'i implement eden farklı bir repository sınıfı oluşturabiliriz. 
    // Doğrulama
    void register(Account account);

    Account login(String identityNumber, String password);

    // İşlemler
    void deposit(Account account, double amount);

    void withdraw(Account account, double amount);

    void transfer(Account fromAccount, Account toAccount, double amount);

    // Tüm Verileri Listeleme
    List<Account> findAll();


    List<Transaction> getTransactionHistory(Account account);
}
