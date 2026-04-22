CREATE DATABASE kutuphanedb

-- ============================================
-- DDL KOMUTLARI - KÜTÜPHANE SİSTEMİ
-- ============================================

-- 1. Adres tablosu
CREATE TABLE adres(
	ilKodu INT PRIMARY KEY,
	ilAdi VARCHAR(100) NOT NULL,
	ilceAd VARCHAR(100) NOT NULL,
	bolge VARCHAR(100) NOT NULL
);

ALTER TABLE adres ADD UNIQUE (ilAdi);

-- 2. Yayinevi tablosu
CREATE TABLE yayinevi(
	yayineviNo SERIAL PRIMARY KEY,
	yayineviAd VARCHAR(50) NOT NULL,
	telefonNo   VARCHAR(11) NOT NULL,
    ilKodu      INT NOT NULL,
	CONSTRAINT fk_yayinevi_adres FOREIGN KEY (ilKodu) REFERENCES adres(ilKodu) 
);

ALTER TABLE yayinevi ADD UNIQUE (telefonNo);

-- 3. Yazar tablosu
CREATE TABLE yazar(
	yazarNo SERIAL PRIMARY KEY,
	yazarAd VARCHAR(150) NOT NULL,
	ulke   VARCHAR(100) NOT NULL,
    yayineviNo INT ,
	CONSTRAINT fk_yazar_yayinevi FOREIGN KEY (yayineviNo) REFERENCES yayinevi(yayineviNo) 
);

-- 4. Kitaplar tablosu
CREATE TABLE kitaplar (
    kitapID    SERIAL PRIMARY KEY,
    kitapAd    VARCHAR(200) NOT NULL,
    sayfaSayisi INT,
    kitapTuru  VARCHAR(100),
    yayineviNo INT,
    yazarNo    INT NOT NULL,
    CONSTRAINT fk_kitap_yayinevi FOREIGN KEY (yayineviNo) REFERENCES yayinevi(yayineviNo),
    CONSTRAINT fk_kitap_yazar    FOREIGN KEY (yazarNo)    REFERENCES yazar(yazarNo)
);


-- 5. Kutuphaneler tablosu
CREATE TABLE kutuphaneler (
    kutuphaneID  SERIAL PRIMARY KEY,
    kutuphaneAd  VARCHAR(150) NOT NULL,
    telefonNo    VARCHAR(11) NOT NULL,
    acilisSaati  TIME NOT NULL DEFAULT '09:00:00',
    kapanisSaati TIME NOT NULL DEFAULT '18:00:00',
    ilKodu       INT NOT NULL,
    CONSTRAINT fk_kutuphane_adres FOREIGN KEY (ilKodu) REFERENCES adres(ilKodu)
);

-- 6. KutuphaneKitap (ara tablo - Kutuphane <-> Kitap)
CREATE TABLE kutuphanekitap (
    kutuphaneID   INT NOT NULL,
    kitapID       INT NOT NULL,
    stokMiktar    INT NOT NULL DEFAULT 0,
    eklemeTarihi  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (kutuphaneID, kitapID),
    CONSTRAINT fk_kk_kutuphane FOREIGN KEY (kutuphaneID) REFERENCES kutuphaneler(kutuphaneID),
    CONSTRAINT fk_kk_kitap     FOREIGN KEY (kitapID)     REFERENCES kitaplar(kitapID)
);

-- 7. Ogrenciler tablosu
CREATE TABLE Ogrenciler (
    ogrenciID  SERIAL PRIMARY KEY,
    ogrenciAd  VARCHAR(150) NOT NULL,
    email      VARCHAR(200) NOT NULL UNIQUE
);

-- 8. KutuphaneOgrenci (ara tablo - Kutuphane <-> Ogrenci)
CREATE TABLE kutuphaneogrenci (
    ogrenciID    INT NOT NULL,
    kutuphaneID  INT NOT NULL,
    kayitTarihi  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    kartNo       VARCHAR(50) UNIQUE,
    aktifMi      BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (ogrenciID, kutuphaneID),
    CONSTRAINT fk_ko_ogrenci    FOREIGN KEY (ogrenciID)   REFERENCES ogrenciler(ogrenciID),
    CONSTRAINT fk_ko_kutuphane  FOREIGN KEY (kutuphaneID) REFERENCES kutuphaneler(kutuphaneID)
);

-- 9. OgrenciKitap (ara tablo - Ogrenci <-> Kitap, ödünç alma)
CREATE TABLE ogrencikitap (
    ogrenciID   INT NOT NULL,
    kitapID     INT NOT NULL,
    alisTarihi  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    iadeTarihi  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    iadeDurumu  BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (ogrenciID, kitapID),
    CONSTRAINT fk_ok_ogrenci FOREIGN KEY (ogrenciID) REFERENCES ogrenciler(ogrenciID),
    CONSTRAINT fk_ok_kitap   FOREIGN KEY (kitapID)   REFERENCES kitaplar(kitapID)
);

-- 10. Personel tablosu (üst sınıf)
CREATE TABLE personel (
    personelNo       SERIAL PRIMARY KEY,
    personelAd       VARCHAR(150) NOT NULL,
    gorevBaslangic   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    kutuphaneID      INT NOT NULL,
    CONSTRAINT fk_personel_kutuphane FOREIGN KEY (kutuphaneID) REFERENCES kutuphaneler(kutuphaneID)
);

-- 11. Mudur tablosu (Personel'den miras)
CREATE TABLE Mudur (
    personelNo    INT PRIMARY KEY,
    mudurMaas     NUMERIC(10,2),
    diplomaAlani  VARCHAR(150),
    CONSTRAINT fk_mudur_personel FOREIGN KEY (personelNo) REFERENCES personel(personelNo)
);

-- 12. KutuphaneSorumlusu tablosu (Personel'den miras)
CREATE TABLE KutuphaneSorumlusu (
    personelNo      INT PRIMARY KEY,
    sorumluMaas     NUMERIC(10,2),
    uzmanlikAlani   VARCHAR(150),
    sertifikaTuru   VARCHAR(100),
    sorumluBolum    VARCHAR(100),
    CONSTRAINT fk_sorumlu_personel FOREIGN KEY (personelNo) REFERENCES personel(personelNo)
);

-- 13. Hademe tablosu (Personel'den miras)
CREATE TABLE Hademe (
    personelNo       INT PRIMARY KEY,
    hademeMaas       NUMERIC(10,2),
    vardiyaTuru      VARCHAR(50),
    temizlikBolgesi  VARCHAR(150),
    CONSTRAINT fk_hademe_personel FOREIGN KEY (personelNo) REFERENCES personel(personelNo)
);

-- ============================================
-- DML KOMUTLARI - KÜTÜPHANE SİSTEMİ
-- ============================================

-- 1. ADRES 
INSERT INTO adres (ilKodu, ilAdi, ilceAd, bolge) VALUES (34, 'İstanbul', 'Kadıköy', 'Marmara');
INSERT INTO adres (ilKodu, ilAdi, ilceAd, bolge) VALUES (6, 'Ankara', 'Çankaya', 'İç Anadolu');
INSERT INTO adres (ilKodu, ilAdi, ilceAd, bolge) VALUES (35, 'İzmir', 'Bornova', 'Ege');
INSERT INTO adres (ilKodu, ilAdi, ilceAd, bolge) VALUES (54, 'Sakarya', 'Serdivan', 'Marmara');
INSERT INTO adres (ilKodu, ilAdi, ilceAd, bolge) VALUES (41, 'Kocaeli', 'İzmit', 'Marmara');

UPDATE adres SET bolge = 'İç Anadolu Bölgesi' WHERE ilKodu = 6;
UPDATE adres SET bolge = 'Ege Bölgesi' WHERE ilKodu = 35;
UPDATE adres SET bolge = 'Marmara Bölgesi' WHERE ilKodu = 34;
UPDATE adres SET bolge = 'Marmara Bölgesi' WHERE ilKodu = 54;
UPDATE adres SET bolge = 'Marmara Bölgesi' WHERE ilKodu = 41;

SELECT * FROM adres;
SELECT * FROM adres ORDER BY bolge desc;
SELECT COUNT(*) FROM adres WHERE bolge = 'Marmara Bölgesi';

-- 2. YAYINEVİ 
INSERT INTO yayinevi (yayineviAd, telefonNo, ilKodu) VALUES ('Yapı Kredi Yayınları', '02123456789', 34);
INSERT INTO yayinevi (yayineviAd, telefonNo, ilKodu) VALUES ('İş Bankası Kültür', '03124567890', 6);
INSERT INTO yayinevi (yayineviAd, telefonNo, ilKodu) VALUES ('Doğan Kitap', '03525678901', 35);
INSERT INTO yayinevi (yayineviAd, telefonNo, ilKodu) VALUES ('Alfa Yayınları', '02644445566', 54);
INSERT INTO yayinevi (yayineviAd, telefonNo, ilKodu) VALUES ('Can Yayınları', '02625556677', 41);

UPDATE yayinevi SET telefonNo = '02129999999' WHERE yayineviNo = 1;
SELECT * FROM yayinevi;
SELECT * FROM yayinevi WHERE ilKodu = 34;
SELECT * FROM yayinevi WHERE yayineviAd LIKE 'D%'

-- 3. YAZAR 
INSERT INTO yazar (yazarAd, ulke, yayineviNo) VALUES ('Orhan Pamuk', 'Türkiye', 1);
INSERT INTO yazar (yazarAd, ulke, yayineviNo) VALUES ('Sabahattin Ali', 'Türkiye', 2);
INSERT INTO yazar (yazarAd, ulke, yayineviNo) VALUES ('Elif Şafak', 'Türkiye', 3);
INSERT INTO yazar (yazarAd, ulke, yayineviNo) VALUES ('Fyodor Dostoyevski', 'Rusya', 4);
INSERT INTO yazar (yazarAd, ulke, yayineviNo) VALUES ('Franz Kafka', 'Çekya', 5);

UPDATE yazar SET ulke = 'Almanya' WHERE yazarNo = 5;
SELECT * FROM yazar ORDER BY yazarAd ASC;
SELECT * FROM yazar WHERE ulke = 'Türkiye';
SELECT * FROM yazar WHERE ulke LIKE '%e'

-- 4. KİTAPLAR 
INSERT INTO kitaplar (kitapAd, sayfaSayisi, kitapTuru, yayineviNo, yazarNo) VALUES ('Kar', 426, 'Roman', 1, 1);
INSERT INTO kitaplar (kitapAd, sayfaSayisi, kitapTuru, yayineviNo, yazarNo) VALUES ('Kürk Mantolu Madonna', 152, 'Roman', 2, 2);
INSERT INTO kitaplar (kitapAd, sayfaSayisi, kitapTuru, yayineviNo, yazarNo) VALUES ('Aşk', 510, 'Roman', 3, 3);
INSERT INTO kitaplar (kitapAd, sayfaSayisi, kitapTuru, yayineviNo, yazarNo) VALUES ('Suç ve Ceza', 671, 'Roman', 4, 4);
INSERT INTO kitaplar (kitapAd, sayfaSayisi, kitapTuru, yayineviNo, yazarNo) VALUES ('Dönüşüm', 128, 'Novella', 5, 5);

UPDATE kitaplar SET kitapAd = 'Kan' WHERE kitapID = 1;
SELECT * FROM kitaplar ORDER BY sayfaSayisi DESC;
SELECT COUNT(*) FROM kitaplar WHERE kitapTuru = 'Roman';
SELECT AVG(sayfaSayisi) FROM kitaplar;

-- 5. KÜTÜPHANELER 
INSERT INTO kutuphaneler (kutuphaneAd, telefonNo, acilisSaati, kapanisSaati, ilKodu) VALUES ('Kadıköy Halk Kütüphanesi', '02161112233', '08:00', '20:00', 34);
INSERT INTO kutuphaneler (kutuphaneAd, telefonNo, acilisSaati, kapanisSaati, ilKodu) VALUES ('Çankaya Merkez Kütüphanesi', '03122223344', '09:00', '18:00', 6);
INSERT INTO kutuphaneler (kutuphaneAd, telefonNo, acilisSaati, kapanisSaati, ilKodu) VALUES ('Bornova İlçe Kütüphanesi', '02323334455', '09:00', '17:00', 35);
INSERT INTO kutuphaneler (kutuphaneAd, telefonNo, acilisSaati, kapanisSaati, ilKodu) VALUES ('Serdivan Kütüphanesi', '02644445577', '08:30', '19:00', 54);
INSERT INTO kutuphaneler (kutuphaneAd, telefonNo, acilisSaati, kapanisSaati, ilKodu) VALUES ('İzmit Merkez Kütüphanesi', '02626667788', '08:00', '20:00', 41);

UPDATE kutuphaneler SET kapanisSaati = '22:00' WHERE kutuphaneID = 1;
SELECT * FROM kutuphaneler ORDER BY kutuphaneAd ASC;
SELECT * FROM kutuphaneler WHERE acilisSaati <= '09:00';
SELECT COUNT(*) FROM kutuphaneler;

-- 6. KÜTÜPHANEKİTAP 
INSERT INTO kutuphanekitap (kutuphaneID, kitapID, stokMiktar, eklemeTarihi) VALUES (1, 1, 5, '2024-01-10');
INSERT INTO kutuphanekitap (kutuphaneID, kitapID, stokMiktar, eklemeTarihi) VALUES (2, 2, 7, '2024-02-01');
INSERT INTO kutuphanekitap (kutuphaneID, kitapID, stokMiktar, eklemeTarihi) VALUES (3, 3, 6, '2024-03-05');
INSERT INTO kutuphanekitap (kutuphaneID, kitapID, stokMiktar, eklemeTarihi) VALUES (4, 4, 2, '2024-03-20');
INSERT INTO kutuphanekitap (kutuphaneID, kitapID, stokMiktar, eklemeTarihi) VALUES (5, 5, 8, '2024-04-01');

UPDATE kutuphanekitap SET stokMiktar = stokMiktar + 3 WHERE kutuphaneID = 1 AND kitapID = 1;
SELECT * FROM kutuphanekitap ORDER BY stokMiktar DESC;
SELECT SUM(stokMiktar) FROM kutuphanekitap;
SELECT MAX(stokMiktar) FROM kutuphanekitap;

-- 7. ÖĞRENCİLER 
INSERT INTO ogrenciler (ogrenciAd, email) VALUES ('Ahmet Yılmaz', 'ahmet.yilmaz@gmail.com');
INSERT INTO ogrenciler (ogrenciAd, email) VALUES ('Ayşe Kaya', 'ayse.kaya@gmail.com');
INSERT INTO ogrenciler (ogrenciAd, email) VALUES ('Mehmet Demir', 'mehmet.demir@hotmail.com');
INSERT INTO ogrenciler (ogrenciAd, email) VALUES ('Fatma Çelik', 'fatma.celik@outlook.com');
INSERT INTO ogrenciler (ogrenciAd, email) VALUES ('Emre Şahin', 'emre.sahin@gmail.com');

UPDATE ogrenciler SET email = 'ahmet.yeni@gmail.com' WHERE ogrenciID = 1;
SELECT * FROM ogrenciler ORDER BY ogrenciAd ASC;
SELECT * FROM ogrenciler WHERE email ILIKE '%gmail%';
SELECT COUNT(*) FROM ogrenciler;

-- 8. KÜTÜPHANEÖĞRENCİ 
INSERT INTO kutuphaneogrenci (ogrenciID, kutuphaneID, kayitTarihi, kartNo, aktifMi) VALUES (1, 1, '2024-01-20', 'KRT-0001', TRUE);
INSERT INTO kutuphaneogrenci (ogrenciID, kutuphaneID, kayitTarihi, kartNo, aktifMi) VALUES (2, 2, '2024-01-22', 'KRT-0002', TRUE);
INSERT INTO kutuphaneogrenci (ogrenciID, kutuphaneID, kayitTarihi, kartNo, aktifMi) VALUES (3, 3, '2024-02-05', 'KRT-0003', TRUE);
INSERT INTO kutuphaneogrenci (ogrenciID, kutuphaneID, kayitTarihi, kartNo, aktifMi) VALUES (4, 4, '2024-02-18', 'KRT-0004', FALSE);
INSERT INTO kutuphaneogrenci (ogrenciID, kutuphaneID, kayitTarihi, kartNo, aktifMi) VALUES (5, 5, '2024-03-10', 'KRT-0005', TRUE);

UPDATE kutuphaneogrenci SET aktifMi = FALSE WHERE ogrenciID = 3 AND kutuphaneID = 3;
SELECT * FROM kutuphaneogrenci WHERE aktifMi = TRUE;
SELECT COUNT(*) FROM kutuphaneogrenci WHERE aktifMi = TRUE;
SELECT * FROM kutuphaneogrenci ORDER BY kayitTarihi DESC;

-- 9. ÖĞRENCİKİTAP 
INSERT INTO ogrencikitap (ogrenciID, kitapID, alisTarihi, iadeTarihi, iadeDurumu) VALUES (1, 1, '2024-05-01', '2024-05-15', TRUE);
INSERT INTO ogrencikitap (ogrenciID, kitapID, alisTarihi, iadeTarihi, iadeDurumu) VALUES (2, 2, '2024-05-03', '2024-05-17', FALSE);
INSERT INTO ogrencikitap (ogrenciID, kitapID, alisTarihi, iadeTarihi, iadeDurumu) VALUES (3, 3, '2024-05-05', '2024-05-20', TRUE);
INSERT INTO ogrencikitap (ogrenciID, kitapID, alisTarihi, iadeTarihi, iadeDurumu) VALUES (4, 4, '2024-05-07', '2024-05-21', FALSE);
INSERT INTO ogrencikitap (ogrenciID, kitapID, alisTarihi, iadeTarihi, iadeDurumu) VALUES (5, 5, '2024-05-10', '2024-05-25', TRUE);

UPDATE ogrencikitap SET iadeDurumu = TRUE WHERE ogrenciID = 2 AND kitapID = 2;
SELECT * FROM ogrencikitap WHERE iadeDurumu = FALSE;
SELECT COUNT(*) FROM ogrencikitap WHERE iadeDurumu = FALSE;
SELECT * FROM ogrencikitap ORDER BY alisTarihi ASC;

-- 10. PERSONEL 
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Ali Koç', '2020-09-01', 1);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Selin Yıldız', '2019-03-15', 2);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Burak Öztürk', '2021-06-01', 3);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Merve Aydın', '2018-11-20', 4);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Hasan Polat', '2022-01-10', 5);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Gül Demirci', '2017-07-05', 1);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Can Arslan', '2016-04-12', 2);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Nisa Yılmaz', '2023-02-28', 3);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Tarık Kaya', '2015-09-09', 4);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Pınar Çelik', '2021-11-01', 5);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Kemal Tunç', '2018-05-15', 1);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Hatice Öz', '2019-08-20', 2);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Murat Başar', '2020-03-10', 3);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Leyla Güneş', '2021-07-25', 4);
INSERT INTO personel (personelAd, gorevBaslangic, kutuphaneID) VALUES ('Serkan Yurt', '2022-09-05', 5);

UPDATE personel SET kutuphaneID = 3 WHERE personelNo = 2;
SELECT * FROM personel ORDER BY gorevBaslangic ASC;
SELECT COUNT(*) FROM personel WHERE kutuphaneID = 1;
SELECT * FROM personel WHERE personelAd ILIKE '%a%';

-- 11. MÜDÜR (5 ayrı INSERT - personelNo 1-5)
INSERT INTO mudur (personelNo, mudurMaas, diplomaAlani) VALUES (1, 25000.00, 'Kütüphanecilik');
INSERT INTO mudur (personelNo, mudurMaas, diplomaAlani) VALUES (2, 27000.00, 'Bilgi ve Belge Yönetimi');
INSERT INTO mudur (personelNo, mudurMaas, diplomaAlani) VALUES (3, 24000.00, 'Eğitim Bilimleri');
INSERT INTO mudur (personelNo, mudurMaas, diplomaAlani) VALUES (4, 26000.00, 'İşletme');
INSERT INTO mudur (personelNo, mudurMaas, diplomaAlani) VALUES (5, 23000.00, 'Hukuk');

UPDATE mudur SET mudurMaas = 30000.00 WHERE personelNo = 1;
SELECT * FROM mudur ORDER BY mudurMaas DESC;
SELECT AVG(mudurMaas) FROM mudur;
SELECT MAX(mudurMaas) FROM mudur;


-- 12. KÜTÜPHANESORUMLUSU 
INSERT INTO kutuphanesorumlusu (personelNo, sorumluMaas, uzmanlikAlani, sertifikaTuru, sorumluBolum) VALUES (6, 20000.00, 'Dijital Arşivleme', 'ISO 15489', 'Arşiv Birimi');
INSERT INTO kutuphanesorumlusu (personelNo, sorumluMaas, uzmanlikAlani, sertifikaTuru, sorumluBolum) VALUES (7, 18000.00, 'Çocuk Edebiyatı', 'MEB Onaylı', 'Çocuk Bölümü');
INSERT INTO kutuphanesorumlusu (personelNo, sorumluMaas, uzmanlikAlani, sertifikaTuru, sorumluBolum) VALUES (8, 19000.00, 'Referans Hizmetleri', 'IFLA Sertifikası', 'Referans Birimi');
INSERT INTO kutuphanesorumlusu (personelNo, sorumluMaas, uzmanlikAlani, sertifikaTuru, sorumluBolum) VALUES (9, 21000.00, 'Kataloglama', 'RDA Sertifikası', 'Katalog Birimi');
INSERT INTO kutuphanesorumlusu (personelNo, sorumluMaas, uzmanlikAlani, sertifikaTuru, sorumluBolum) VALUES (10, 17500.00, 'Süreli Yayınlar', 'ULAKBİM Onaylı', 'Süreli Yayınlar');

UPDATE kutuphanesorumlusu SET sorumluBolum = 'Genel Hizmetler' WHERE personelNo = 10;
SELECT * FROM kutuphanesorumlusu WHERE uzmanlikAlani ILIKE '%arşiv%';
SELECT MAX(sorumluMaas) FROM kutuphanesorumlusu;
SELECT AVG(sorumluMaas) FROM kutuphanesorumlusu;

-- 13. HADEME 
INSERT INTO hademe (personelNo, hademeMaas, vardiyaTuru, temizlikBolgesi) VALUES (11, 12000.00, 'Sabah', 'Zemin Kat');
INSERT INTO hademe (personelNo, hademeMaas, vardiyaTuru, temizlikBolgesi) VALUES (12, 11500.00, 'Akşam', '1. Kat');
INSERT INTO hademe (personelNo, hademeMaas, vardiyaTuru, temizlikBolgesi) VALUES (13, 12500.00, 'Gündüz', '2. Kat');
INSERT INTO hademe (personelNo, hademeMaas, vardiyaTuru, temizlikBolgesi) VALUES (14, 11000.00, 'Sabah', 'Bodrum Kat');
INSERT INTO hademe (personelNo, hademeMaas, vardiyaTuru, temizlikBolgesi) VALUES (15, 13000.00, 'Gece', 'Tüm Katlar');

UPDATE hademe SET vardiyaTuru = 'Gündüz' WHERE personelNo = 12;
SELECT * FROM hademe WHERE vardiyaTuru = 'Sabah';
SELECT MIN(hademeMaas) FROM hademe;
SELECT AVG(hademeMaas) FROM hademe;