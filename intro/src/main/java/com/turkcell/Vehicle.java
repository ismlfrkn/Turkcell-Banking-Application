package com.turkcell;

//ARAÇ klasmanına giren nesnelerin 
//tüm ortak özelliklerini ve davranışlarını tanımlayacağımız sınıf
public class Vehicle {
private String brand;
private String model;
private int year;
private double pricePerDay;

public String getBrand() {
    return brand;
}
public void setBrand(String brand) {
    this.brand = brand;
}
public String getModel() {
    return model;
}
public void setModel(String model) {
    this.model = model;
}
public int getYear() {
    return year;
}
public void setYear(int year) {
    this.year = year;
}
public double getPricePerDay() {
    return pricePerDay;
}
public void setPricePerDay(double pricePerDay) {
    if(pricePerDay < 0){
        System.out.println("Günlük fiyat negatif olamaz!");
        return;
    }
    this.pricePerDay = pricePerDay;
}



}
