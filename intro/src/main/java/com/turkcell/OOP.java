package com.turkcell;

public class OOP {
    public static void main(String[] args) {

        //car1 => car instance'ı
        Car car1 = new Car(); //new => yeni bir instance oluşturma keyword'ü
        car1.setBrand("BMW"); //set
        car1.setModel("X5"); //set
        car1.setYear(2020); //set
        //car1.price = 500000; //set

        car1.setPricePerDay(-500); //set

        String[] specs = {"Cam Tavan", "Bebek Koltuğu", "Otonom Sürüş"};
        car1.setSpecs(specs); //set

        String[] x = car1.getSpecs(); //get
        x[0] = "abc";

        System.out.println(car1.getSpecs()[0]); //get
        System.out.println(car1.getBrand()); //get
        System.out.println(car1.getPricePerDay()); //get

        Bike bike1 = new Bike();

        Car car2 = new Car(true, "Mercedes");
        System.out.println(car2.getBrand());




        
    }
}
