package com.turkcell;

public class Interfaces {

    public static void main(String[] args) {
        CarReporsitory carReporsitory = new MsCarRepository(); //Sol taraf => Bana CarReporsitory kurallarına uyan somut bir class ver.
        carReporsitory.add(new Car(true, "BMW"));
        carReporsitory.add(new Car(true, "Mercedes"));
        carReporsitory.add(new Car(false, "Ford"));



    }

    // Yeni bir proje oluşturmak (aynı klasör içinde olabilir)
    // BankingApplication adında bir proje oluşturun

    //Bir bankacılık uygulaması => İçerik tamamen size ait
    //Min +3 özellik

    //In-memory Repository => Veriler RAM'de saklanacak, uygulama kapandığında silinecek

    //Tek bir main classta oluşturun => BankingApplication


}
