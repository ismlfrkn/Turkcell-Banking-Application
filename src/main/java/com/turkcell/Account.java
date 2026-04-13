package com.turkcell;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Account {
    private String identityNumber;
    private String accountNumber;
    private String accountHolder;
    private String password;
    private double balance;
    private List<Transaction> transactionHistory; //İşlem geçmişlerini için bir liste //List olarak tutmamızın sebebi bir çok işlem geçmişi olmasından kaynaklıdır.

    public Account(String accountHolder, String password,String identityNumber) {
        this.setAccountHolder(accountHolder);
        this.setAccountNumber(); //Hesap numarası otomatik olarak oluşturulur
        setPassword(password);
        this.identityNumber = identityNumber;
        this.balance = 0.0; // Başlangıç bakiyesi sıfır olarak ayarlanır
        this.transactionHistory = new ArrayList<>(); 
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public String getAccountNumber() {
        return accountNumber; 
    }

    //Private olma nedeni hesap açılırken otomatik olarak oluşturulması ve dışarıdan değiştirilmemesi içindir
    private void setAccountNumber() {
        int generatedNo = ThreadLocalRandom.current().nextInt(100000, 1000000);
        // Başına "TR" metnini ekliyoruz
        this.accountNumber = "TR" + String.valueOf(generatedNo);
    }

    //Getter ve Setter metodları
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getAccountHolder() {return accountHolder;}
    public void setAccountHolder(String accountHolder) {this.accountHolder = accountHolder;}
    public double getBalance() {return balance;}
    public void setBalance(double balance) {
        if(balance < 0){
            System.out.println("Hata: Bakiye negatif olamaz!");
            return;
        }
        this.balance = balance;
    }
    public List<Transaction> getTransactionHistory() {return transactionHistory;}

    public void addTransaction(Transaction transactionHistory) {
        this.transactionHistory.add(transactionHistory);
    }

    @Override
    public String toString() {
        return String.format("Hesap No: %-10s | Müşteri: %-15s | TC: %-11s | Bakiye: %.2f TL", 
                             accountNumber, accountHolder, identityNumber, balance);
    }
    

    

}
