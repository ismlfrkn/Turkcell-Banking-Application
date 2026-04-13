package com.turkcell;

//Vehicle'ın tüm özelliklerini yükle,üstüne
//buraya yazacağımız özellikleri de ekle => CAR

//subclass - superclass => alt sınıf - üst sınıf
public class Car extends Vehicle {
    /* 
    private int year;
    private String model;
    private String brand;
    //erişim belirleyiciler => public, private, protected => o alana kimlerin erişebileceğini belirleyen sistem
    private double price;
    //public => her yerden erişilebilir
    //private => sadece tanımlanan o sınıf içerisinden erişilebilir
    //protected => sadece tanımlanan o sınıf ve o sınıftan türetilen alt sınıflardan erişilebilir
    //protected => aynı paketteki sınıflardan erişilebilir.
    
    //Encapsulation => Dışardan manipülasyona kapalı
    //read-only => sadece get işlemi yapılabilir
    //write-only => sadece set işlemi yapılabilir
    public double getPrice() {
        //get işlemlerini kontrol eden mekanizma
        return price;
    }

    public void setPrice(double price) {
        //set işlemlerini kontrol eden mekanizma
        if(price < 0){
            System.out.println("Fiyat negatif olamaz!");
            return;
        }
       this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    */

    //Constructor => Yapıcı metod => Yazmasanız bile var, default constructor
    //Yazarsan Auto oluşanı override etmiş olur.

    public Car(boolean hasSunroof, String brand) {
        super(); //Vehicle'ın constructor'ını çağırır, super() => constructor'ı çağırmak için kullanılan keyword
        System.out.println("Car Constructor çalıştı!");
        this.setHasSunroof(hasSunroof);
        super.setBrand(brand); //super => üst sınıfın özelliklerine erişmek için kullanılan keyword
    }

    public Car(){}

   

    private boolean hasSunroof;
    //Referans tiplerde encapsulation'ı sağlamak için get işlemlerinde clone kullanarak dışardan manipülasyona kapatıyoruz
    private String[] specs; 

    public String[] getSpecs() {
        return specs.clone();
    }
    //Değerini al,referansını alma

    public void setSpecs(String[] specs) {
        this.specs = specs;
    }

    public boolean isHasSunroof() {
        return hasSunroof;
    }

    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    

}
