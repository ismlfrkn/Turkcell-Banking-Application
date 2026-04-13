package com.turkcell;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionType; // Para yatırma, para çekme, transfer gibi işlemler için bir tür belirteci
    private double amount; 
    private LocalDateTime transactionDate;

    public Transaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = LocalDateTime.now(); // İşlem tarihi otomatik olarak atanır
    }

    @Override
    public String toString() {
        return String.format("[%s] %-10s : %.2f TL", transactionDate, transactionType, amount);
    }
}
