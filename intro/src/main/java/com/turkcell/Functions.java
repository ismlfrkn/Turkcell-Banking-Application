package com.turkcell;

public class Functions {
    public static void main(String[] args) {
       
        // primitive type => fonksiyonun onu değiştirmesi orjinal değeri değiştirmez
        String name = "Barış";
        sayWelcome(name);
        System.out.println("name değişkeni: " + name);

        // reference type => fonksiyonun onu değiştirmesi orjinal değeri de değiştirir
        int [] numbers = {1, 2, 3, 4, 5};
        sum(numbers);
        System.out.println(numbers[0]);

    }

     //Pass by value => değer ile aktar
    public static void sayWelcome(String name) //camelCase => sayWelcome
    {
        name = "Halit";
        System.out.println("Hoş geldiniz, " + name);
    }

    //Pass by reference => referans ile aktar
    public static void sum (int[] numbers) {
        int total = 0;
        for(int num : numbers) {
            total += num;
        }
        System.out.println("Toplam: " + total);
        numbers[0] = 100; // dizinin ilk elemanını değiştirelim
    }

}
