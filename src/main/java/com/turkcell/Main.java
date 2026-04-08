package com.turkcell;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        AccountRepository repo = new InMemoryAccountRepository();

        boolean sistemAcik = true;

        while (sistemAcik) {
            System.out.println("\n=== TURKCELL BANKASINA HOŞGELDİNİZ ===");
            System.out.println("1. Kayıt Ol");
            System.out.println("2. Giriş Yap");
            System.out.println("3. Tüm Müşterileri Listele");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            
            String secim = scanner.nextLine();

            switch (secim) {
                case "1": // KAYIT OL
                    System.out.print("Ad Soyad: ");
                    String ad = scanner.nextLine();
                    
                    System.out.print("TC Kimlik No (11 Hane): ");
                    String tc = scanner.nextLine();
                    

                    if (tc.length() != 11 || !tc.matches("\\d+")) {
                        System.out.println("-> Hata: TC Kimlik No 11 haneli bir sayı olmalıdır!");
                        System.out.println("-> Kayıt işlemi iptal edildi. Ana menüye dönülüyor...\n");
                        break; 
                    }
                    
                    
                    System.out.print("Şifre Belirleyin: ");
                    String sifre = scanner.nextLine();

                    Account yeniHesap = new Account(ad, sifre, tc);
                    repo.register(yeniHesap);
                    break;

                case "2": // GİRİŞ YAP
                    System.out.print("TC Kimlik Numaranız: ");
                    String girilenTc = scanner.nextLine();
                    
                    System.out.print("Şifreniz: ");
                    String girilenSifre = scanner.nextLine();

                    Account aktifHesap = repo.login(girilenTc, girilenSifre);

                    if (aktifHesap != null) {
                        System.out.println("\nBaşarıyla giriş yapıldı. Hoşgeldin, " + aktifHesap.getAccountHolder());
                        
                        boolean icMenu = true;
                        while (icMenu) {
                            System.out.println("\n--- HESAP İŞLEMLERİ ---");
                            System.out.println("Güncel Bakiyeniz: " + aktifHesap.getBalance() + " TL");
                            System.out.println("1. Para Yatır");
                            System.out.println("2. Para Çek");
                            System.out.println("3. Havale / EFT");
                            System.out.println("4. Hesap Hareketleri (Geçmiş)");
                            System.out.println("9. Çıkış Yap");
                            System.out.print("İşlem Seçin: ");
                            
                            String islem = scanner.nextLine();

                            switch (islem) {
                                case "1":
                                    System.out.print("Yatırılacak Tutar (TL): ");
                                    double yatir = Double.parseDouble(scanner.nextLine());
                                    repo.deposit(aktifHesap, yatir);
                                    System.out.println("İşlem başarılı.");
                                    break;

                                case "2":
                                    System.out.print("Çekilecek Tutar (TL): ");
                                    double cek = Double.parseDouble(scanner.nextLine());
                                    repo.withdraw(aktifHesap, cek);
                                    break;

                                case "3":
                                    System.out.print("Alıcı Hesap No (TR...): ");
                                    String aliciNo = scanner.nextLine();
                                    System.out.print("Gönderilecek Tutar (TL): ");
                                    double gonder = Double.parseDouble(scanner.nextLine());
                                    
                                    Account aliciHesap = null;
                                    for (Account a : repo.findAll()) {
                                        if (a.getAccountNumber().equals(aliciNo)) {
                                            aliciHesap = a;
                                            break;
                                        }
                                    }

                                    if (aliciHesap != null) {
                                        repo.transfer(aktifHesap, aliciHesap, gonder);
                                        System.out.println("Transfer işlemi tamamlandı.");
                                    } else {
                                        System.out.println("Hata: Alıcı hesap bulunamadı!");
                                    }
                                    break;

                                case "4":
                                    System.out.println("\n--- İŞLEM GEÇMİŞİ ---");
                                    List<Transaction> gecmis = repo.getTransactionHistory(aktifHesap);
                                    if (gecmis == null || gecmis.isEmpty()) {
                                        System.out.println("Henüz bir hesap hareketiniz bulunmamaktadır.");
                                    } else {
                                        for (Transaction t : gecmis) {
                                            System.out.println(t.toString());
                                        }
                                    }
                                    break;

                                case "9":
                                    icMenu = false;
                                    System.out.println("Hesabınızdan güvenli çıkış yapıldı.");
                                    break;

                                default:
                                    System.out.println("Geçersiz işlem!");
                            }
                        }
                    } else {
                        System.out.println("\nHata: TC Kimlik numarası bulunamadı veya şifre yanlış!");
                    }
                    break;

                case "3": // TÜM KULLANICILARI LİSTELE
                    System.out.println("\n--- SİSTEMDEKİ TÜM MÜŞTERİLER ---");
                    List<Account> tumHesaplar = repo.findAll();
                    
                    if (tumHesaplar.isEmpty()) {
                        System.out.println("Sistemde henüz kayıtlı müşteri yok.");
                    } else {
                        for (Account a : tumHesaplar) {
                            System.out.println(a);
                        }
                    }
                    break;

                case "0": // ÇIKIŞ
                    sistemAcik = false;
                    System.out.println("Turkcell Bankasını tercih ettiğiniz için teşekkür ederiz. İyi günler!");
                    break;

                default:
                    System.out.println("Geçersiz seçim, lütfen menüdeki numaralardan birini tuşlayın.");
            }
        }
        
        scanner.close();
    }
}