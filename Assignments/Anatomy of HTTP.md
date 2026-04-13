# 🌐 HTTP İSTEĞİ VE YANITININ ANATOMİSİ

İnternet üzerinden başka bir bilgisayarla veri alışverişi yapmanın en yaygın yolu **HTTP protokolüdür**.

Veri alışverişinde temel olarak iki taraf yer alır:

- 🧑‍💻 **İSTEMCİ (CLIENT)**
  - Bir talep yoluyla iletişimi başlatır.

- 🖥️ **SUNUCU (SERVER)**
  - İsteği alır, işler ve karşılığında yanıt gönderir.

Bu belgede istek ve yanıtın temel prensipleri ve yaygın kullanımları açıklanmaktadır.

---

## 📤 1. HTTP İSTEĞİ (HTTP REQUEST)

Bir istek birkaç bölümden oluşur:

- URL  
- HTTP yöntemi  
- Headers (başlıklar)  
- Body (gövde)  

### 🔹 1.1. URL

Bir URL, isteğin gönderileceği kaynağın adresidir.

Bir URL birden fazla bölümden oluşur:

- **1.1.1. ŞEMA (SCHEME)**
  - URL'nin ilk kısmıdır (`http`, `https` vb.)

- **1.1.2. SUNUCU (SERVER)**
  - İsteğin gönderildiği ana bilgisayar / servis

- **1.1.3. YOL (PATH)**
  - Sunucudaki kaynağın konumu

- **1.1.4. SORGU (QUERY)**
  - `?` ile başlar, parametreleri içerir (`anahtar=değer`)

#### 📌 Örnek URL

```http
https://example.com/users?id=5
```

- **Şema (Scheme):** `https`
- **Sunucu (Server / Host):** `example.com`
- **Yol (Path):** `/users`
- **Sorgu (Query):** `id=5`

---

### 1.2. İSTEK METOTLARI (REQUEST METHODS)

HTTP, tanımlanan kaynak üzerinde gerçekleştirilmek istenen eylemi belirten yöntemleri (bazen fiiller olarak da adlandırılır) tanımlar.


| Method   | Açıklama                |
|:--------:|:----------------------|
|GET       | Veri çekme               |
|POST      | Veri gönderme / oluşturma|
|PUT       | Tam güncelleme           |
|PATCH     | Kısmi güncelleme         |
|DELETE    | Silme                    |


---


#### 🔹1.2.1 GET (ELDE ETMEK)

GET istekleri, sunucudan bir kaynak sorgulamak veya istemek için kullanılır.  

Bu genellikle veri çekme işlemlerinde kullanılır (JSON, HTML, resim, dosya vb.).

- GET istekleri, sunucudan bir kaynak sorgulamak veya istemek anlamına gelir. Tipik bir web servis senaryosunda bu genellikle veridir, ancak sorgu bir resim, dosya veya HTML için de olabilir.

- GET istekleri, isteğe bağlı olarak döndürülecek veri veya kaynak aralığını sınırlandırmak/kısıtlamak için bir sorgu içerebilir. (`query`)

- GET istekleri genellikle bir gövde içermez.

- Geçerli bir istek olması durumunda, hizmet istenen kaynağı içeren bir yanıt sunmalıdır. Yanıt metinsel (veri, HTML) veya ikili formatta (PDF, resim, diğer dosya türü) olabilir.

📌 Örnek:

```http
GET /api/users?id=5 HTTP/1.1
Host: www.server.com
Authorization: Bearer <token>
Body: Yok
```

---

#### 🔹 1.2.2. POST (GÖNDERME)

POST istekleri, sunucuya veri göndermek için kullanılır. Genellikle yeni bir kayıt oluşturmak için tercih edilir.

- POST istekleri genellikle bir sipariş, müşteri veya veri kaydı oluşturmak için kullanılır.

- POST isteklerinde sorgu dizesi bulunmaz.

- POST istekleri genellikle sunucuya gönderilen verilerden (resim, metin, dosya) oluşan bir gövdeye sahiptir.

- POST isteğine verilen yanıt, isteğe bağlı olarak değişir. POST isteği yalnızca isteğin onaylanmasıyla yanıtlanabilir. Veya veri servislerine yapılan POST istekleri, eksiksiz doldurulmuş veri kaydıyla yanıtlanabilir.

📌 Örnek:

```http
POST /users HTTP/1.1
Host: www.server.com
Authorization: Bearer <token>
Content-Type: application/json
Body:
{
  "name": "Ali",
  "age": 25,
  "city": "Istanbul"
}
```

---

#### 🔹1.2.3. PUT (GÜNCELLEME)

PUT istekleri, mevcut bir kaynağı tamamen güncellemek için kullanılır.

- PUT istekleri, POST isteklerine benzer; bir gövde içerirler, genellikle bir yanıt içerirler, ancak bir PUT isteği genellikle sunucudaki bir kaynağın güncellenmesi veya değiştirilmesi gerektiğini belirtir.

- PUT istekleri genellikle güncellenecek kaynağı belirtmek için parametreli bir yol kullanır. Aşağıda gösterilen örnekte, yol içindeki 1200 değeri güncellenecek müşteriyi belirtir.

📌 Örnek:

```http
PUT /users/1200 HTTP/1.1
Host: www.server.com
Authorization: Bearer <token>
Content-Type: application/json

{
  "name": "Ali",
  "age": 26,
  "city": "Istanbul"
}
```

---

#### 🔹1.2.4. DİĞER HTTP METOTLARI(PATCH, DELETE, HEAD, MERGE(DESTEKLENMİYOR))

HTTP protokolü, servis tarafında farklı görevler gerçekleştiren birçok yöntemi destekler.  

Her yöntem, kullanılan API veya servis tarafından farklı şekilde uygulanabilir.

- 🔹 **1.2.4.1 PATCH (KISMİ GÜNCELLEME)**

PATCH istekleri, PUT isteklerine benzer ancak önemli bir fark vardır:

- PUT → kaynağın tamamını değiştirir  
- PATCH → sadece belirli alanları günceller (birleştirme mantığı)

📌 Örnek:

```http
PATCH /users/1200 HTTP/1.1
Host: www.server.com
Authorization: Bearer <token>
Content-Type: application/json

{
  "age": 30
}
``` 

- 🔹 **1.2.4.2. DELETE (SİLME)**

DELETE isteği, mevcut bir kaynağın kaldırılması (silinmesi) gerektiğini belirtir.

Genellikle body içermez
Silinecek kaynak URL üzerinden belirtilir

```http
DELETE /users/1200 HTTP/1.1
Host: www.server.com
Authorization: Bearer <token>
```
---

### 🔹 1.3. HTTP BAŞLIKLARI (HTTP HEADERS)

HTTP başlıkları, istemci ve sunucunun bir HTTP isteği veya yanıtı ile birlikte ek bilgiler iletmesini sağlar.

Başlıklar genellikle:

- Kimlik doğrulama (Authentication)
- İçerik türü belirtme (Content-Type)
- Kabul edilen veri formatı (Accept)
- Tarayıcı bilgisi (User-Agent)

gibi amaçlarla kullanılır.

---

📌 Bir HTTP başlığı şu yapıdadır:

```http
User-Agent: Mozilla/5.0
Authorization: Basic YjhiZWU5ZGNiYzgxODhjNlZjE4YjBkOWIwZjdjZTY=
Accept: application/json
Content-Type: application/json
```

### 1.4. TALEP GÖVDESİ (REQUEST BODY)
Gövde, sunucuya gönderilen verileri içerir. Gövde metinsel veya ikili formatta olabilir.

Açıklandığı gibi, genellikle yalnızca PUT ve POST istekleri bir gövde içerirken, GET istekleri içermez.

---

## 📥 2. HTTP YANITI (HTTP RESPONSE)

Sunucu, isteği işledikten sonra bir yanıt gönderecektir.

Bir yanıt, bir yanıt kodu (isteğin başarılı veya başarısız olduğunu gösterir), bir dizi başlık ve bir gövde içerir.

GET istekleri, istenen kaynak(lar)ı gönderirken, POST istekleri yalnızca başarı göstergesiyle veya eklenen/gönderilen kaynağın tüm içeriğiyle birlikte yanıt verebilir.

Yanıtlar metinsel veya ikili formatta olabilir.

Bir HTTP yanıtı şu bölümlerden oluşur:

- **Durum kodu (Status Code)** → isteğin başarılı veya başarısız olduğunu gösterir  
- **Başlıklar (Headers)** → ek bilgiler içerir  
- **Gövde (Body)** → dönen veri  

📌 Örnek HTTP Yanıtı (Detaylı)

```http
HTTP/1.1 200 OK
Content-Type: application/json
Date: Thu, 20 Jan 2022 14:13:05 GMT
Server: Apache
X-Correlation-Id: 0a491944-9e95-4ed9-85d9-d3f430ce5d59

{
  "orderReference": "PO16262999",
  "orderNumber": "ORD00000031671",
  "lineItems": [
    {
      "sku": "A1-103/0",
      "description": "A desk lamp",
      "qty": 2
    },
    {
      "sku": "A1-401/0",
      "description": "Some Bulbs",
      "qty": 1
    }
  ]
}
```
---

### 🔹 2.1. HTTP DURUM KODLARI (STATUS CODES)

Durum kodları, bir isteğin sonucunu belirten 3 haneli sayılardır.  
İlk rakam, yanıtın kategorisini ifade eder:

- **1xx (Bilgilendirme)** → İstek alındı, işlem devam ediyor  
- **2xx (Başarılı)** → İstek başarıyla işlendi  
- **3xx (Yönlendirme)** → Ek işlem gerekli (redirect)  
- **4xx (İstemci Hatası)** → İstek hatalı  
- **5xx (Sunucu Hatası)** → Sunucu isteği gerçekleştiremedi  

📌 Yaygın durum kodları:

| Kod | Anlamı |
|-----|--------|
| 200 | OK |
| 201 | Created |
| 301 | Moved Permanently |
| 400 | Bad Request |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |
| 500 | Internal Server Error |

📌 Not:

Durum kodlarının kullanımı standartlara bağlı olsa da, her API kendi implementasyonuna göre davranabilir.

---

### 🔹 2.2. HTTP BAŞLIKLARI (RESPONSE HEADERS)

Yanıt başlıkları, istemciye dönen veri hakkında ek bilgiler içerir.

Örneğin:

- İçeriğin türü (Content-Type)  
- Önbellek durumu (Cache-Control)  
- Sunucu bilgisi (Server)  

📌 Örnek:

```http id="3v5c0r"
Content-Type: application/json
Cache-Control: no-cache
Server: nginx
```

### 🔹 2.3. YANIT GÖVDESİ (RESPONSE BODY)

Bu kısım, sunucudan gelen verileri içerir. Veriler metinsel veya ikili formatta olabilir.