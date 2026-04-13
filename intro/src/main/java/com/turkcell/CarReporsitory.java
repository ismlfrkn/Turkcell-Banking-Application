package com.turkcell;

//Sistemimde Araba veritabanı olarak
//çalışmak isteyen her nesne
//bu interface'i implement etmek zorunda kalacak
public interface CarReporsitory {
    //Bir car reporsitory'si nasıl davranmalıdır? //Net kalıp ve kurallar ile tanımla
    //Soyut => içi boş,yalnızca imza içeren metotlar

    //Böylelikle PostgreSQL, MySQL, Oracle gibi farklı veritabanları için farklı implementasyonlar yazabiliriz.
    //Bu sayede kodumuz daha esnek ve genişletilebilir olur.

    void add(Car car); //Ekleme işlemi için bir metot imzası (default olarak protected ve abstract'tır)


}
