package com.turkcell;

import java.lang.reflect.Array;
import java.util.Arrays;

//Entrypoint (Giriş Noktası)
public class Main {
    public static void main(String[] args) { //args => komut satırından gelen argümanları tutan dizi
        System.out.println("Merhaba Turkcell, Java'ya hoş geldiniz!");

        
         
          // Programlama Konseptleri
          // 1. Scope Kavramı => {} Kapsama alanı
          
          {
          int x = 10;
          }
          // System.out.println("x değişkeni: " + x); //Hata verir, çünkü x değişkeni
          // sadece {} içinde geçerlidir.
          
          // 2. Değişkenler (Variables)
          // Kodun akışında değer tutan isimli veriler.
          System.out.println(10);
          int x = 10;
          System.out.println(x);
          x = 20;
          System.out.println(x);
          
          // Değişken tipleri => int, double, char, boolean, String
          String name = "Furkan";
          int age = 24;
          boolean isStudent = true;
          char grade = 'A';
          double height = 1.83;
          
          // Diziler (Arrays)
          String[] names = { "Ali", "Ayşe", "Mehmet" };
          System.out.println(names[2]); // Mehmet
          
          // Primitive (ilkel) tipler => int, double, char, boolean
          int a = 0;
          int b = a;
          a = 10;
          System.out.println("a: " + a);
          System.out.println("b: " + b);
          
          // Reference (referans) tipler => String, Arrays, Objects
          
          int[] c = { 0, 1, 2, 3 };
          int[] d = c;
          d[3] = 30;
          System.out.println(c[3]);
          System.out.println(d[3]);
          
          System.out.println("****************");
          
          int k = 0;
          int m = 0;
          System.out.println(k==m);
          
          int [] arr1 = {1,2,3};
          int [] arr2 = {1,2,3};
          System.out.println(arr1==arr2);
          System.out.println(Arrays.equals(arr1, arr2)); //Arrays sınıfının equals() metodunu kullanmak gerekir.
          
          
          String s1 = "Merhaba";
          String s2 = "Merhaba";
          System.out.println(s1==s2); //String pool sayesinde true döner.
          
          //Yine de daha güvenli bir karşılaştırma için equals() metodunu kullanmak daha iyidir.
          System.out.println(s1.equals(s2)); //true
          
          String s3 = "Turkcell";
          String s4 = s3.intern(); //s3'ün referansını string pool'a ekler ve o referansı döner.
          System.out.println(s3==s4); //true
          
          String str3 = "Turkcell";
          String str4 = new String("Turkcell"); //instance oluşturulduğunda heap'te yeni bir referans oluşur.
          System.out.println(str3==str4); //false, çünkü str4 heap'te oluşturulur ve string pool'daki str3'ten farklı bir referansa sahiptir.
          
          
          System.out.println("***********************************************");
          //3. Operatörler (Operators)
          System.out.println(1 == 1);
          System.out.println(1 != 1);
          System.out.println(5 > 10);
          
          //4.Döngüler (Loops)
          //İteration (Tekrarlama) yapmamızı sağlar.
          
          //değişken,koşul,artış miktarı veya azalış miktarı
          for (int i = 0; i < 5; i++) {System.out.println("For çalıştı");
          }
          
          String [] students = {"Ali","Ayşe","Mehmet"};
          for (int i = 0; i < students.length; i++) {
          System.out.println(students[i]);}
          
          //for-each döngüsü
          for (String s : students) {
          System.out.println(s);}
          
          //iterasyon => koşul
          int whileDöngüsü = 0;
          while (whileDöngüsü < 5) {
          System.out.println("While çalıştı");
          whileDöngüsü++;
          }
          
          String name2 = "Furkan";
          System.out.println(name2);
          name2 = "Nurgül";
          System.out.println(name2);
          String name3 = name2.concat("abc");
          //String immutable (değişmez) bir sınıftır, yani mevcut string üzerinde değişiklik yapmaz, yeni bir string oluşturur.
         System.out.println(name3);
         

        // Karar Blokları & Döngüler
        // Belirli 1+ kapsamdaki kod bloklarını belirli koşullara göre ateşlemek.

        int age2 = 18;
        if (age2 >= 18) {
            System.out.println("Reşitsiniz");
        } else if (age2 == 18) {
            System.out.println("Yeni reşit oldunuz");
        } else {
            System.out.println("Reşit değilsiniz");
        }

        String usurname = "halit";
        if (usurname.equals("tamer")) {
            System.out.println("Hoş geldin..");
        }
        // Karar blokları illaki bir scope çalıştırmak zorunda değildir.

        String result1 = calculateGrade(85);
        String result2 = calculateGrade(70,"Ayşe");
        String result3 = calculateGrade(60);
        String result4 = calculateGrade(50,"Nurgül");
        String result5 = calculateGrade(30,"Tamer");

        System.out.println(result1); // konsole'a yazdırma
        // result2 db'e yaz
        // result3 email at
        // result4 sms at
        // result5 logla


        double toplam1 = sum(10.5,20.3);
        System.out.println("Toplam: "+toplam1);

        double toplam2 = sum(1,2,4,5,6,7);
        System.out.println("Toplam: "+toplam2);
    }

    // Methodlar => Belirli bir işi yapan kod bloklarıdır. Tekrar tekrar kullanılır.
    //erişim belirleyicisi |-| static veya boş |-| dönüş tipi (void => boş) |-| method adı |-| (parametreler)
    public static String calculateGrade(int grade,String name) //required parameters (gerekli parametreler)
    {    
        
        if(grade >=85) 
        {
            String result = name+" Notunuz: A";
            return result;
        } 
        else if (grade >= 70) 
        {
            return name+" Notunuz: B";
        } 
        else if (grade >= 50) 
        {
            return name+" Notunuz: C";
        } 
        else 
        {
            return name+" Notunuz: F";
        }
    }

    //Name gönderilmezse, "Öğrenci" varsayılan olarak atansın.
    //Method Overloading (Aşırı Yükleme) => Aynı isimde farklı parametrelerle method tanımlama.
    public static String calculateGrade(int grade) //overloaded method (aşırı yüklenmiş method)
    {    
         return calculateGrade(grade,"Öğrenci");
    }


    public static double sum(double a, double b) {
        return a + b;
    }

    public static double sum(double... numbers) { //varargs (variable arguments)
        double total = 0;
        for(double num : numbers) {
            total += num;
        }
        return total;
    }
} // Main class'ının kapsama alanı (sınır)
