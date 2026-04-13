package com.turkcell;

//Implement ediyorsan imzaları birebir uygulamak zorundasın
public class PgCarRepository implements CarReporsitory {
    public void add(Car car)
    {
        System.err.println("Araba nesnesi postgreSQL veritabanına eklendi");
    }

}
