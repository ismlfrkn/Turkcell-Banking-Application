package com.turkcell.spring_starter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.spring_starter.dto.ProductCreatedResponse;
import com.turkcell.spring_starter.dto.ProductForCreateDto;
import com.turkcell.spring_starter.service.ProductServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



//Tarayıcılar varsayılan olarak get isteği atarlar.

//!!! Altın Kural: Veritabanı nesneleri requestte de responseda da kullanılamaz.
@RestController //Uygulamada gerektiğinde controlleri newleme işlemini yapar.
@RequestMapping("api/product") // localhost:8000/api/product -> ProductController 

//Bu class bir rest controller'dır,içini uygulama başladığında tara, http->function
public class ProductController {

    //Kullanıcı ne zaman /api/product alanına istek atarsa -> cevap bu fonksiyondan dönen cevap olsun
    //api/product -> sayHi() fonksiyonunu matchlenir.
    //HTTP Method: GET, POST, PUT, DELETE, PATCH...


    /* 
    @GetMapping("") //localhost:8000/api/product
    public String sayHi(String name,int age) //Query String : localhost:8000/api/product?name=Ali&age=25
    {
        return "Hi, " + name + " yaşınız: " + age;
    }

    //Controllerin uzantısı + get'in uzantısı -> localhost:8000/api/product/hello
    @GetMapping("/hello/{name}/{age}") //Path Variable : localhost:8000/api/product/hello/Ali
    public String sayHello(@PathVariable String name,@PathVariable int age)
    {
        return "Hello, " + name + " yaşınız: " + age;
    }

    @PostMapping
    public Product add(@RequestBody Product product) //Json->Java Object -> Spring otomatik yapar. Json formatında product bilgisi gönderilir.
    {
        //İsim 1 haneden uzun mu ?
        //fiyat 0'dan büyük mü ?
        // DB'e kaydet..
        return product;
    }
    */

    //In-Memory Çalış...
    //private List<Product> productList = new ArrayList<>();





    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }


    @PostMapping
    public ProductCreatedResponse create(@RequestBody @Valid ProductForCreateDto productDto) {
        return this.productServiceImpl.create(productDto);
    }






    /* 
    @GetMapping()
    public List<Product> getAllProduct()
    {
        //Veritabanındaki Product nesnelerini listele
        return productList;
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable int id) 
    {
        //Listeden id == product.getId() olan ürünü bul ve döndür, yoksa null döndür.
        return productList.stream().filter(i->i.getId()==id).findFirst().orElse(null);
    }

    //Request-Response Pattern ->
    //Her istek ve cevap kendine has bir modele sahio olmak zorunda!
    //Birebir başka bir istek-cevap çiftliyle aynı içeriğe sahip olsa bile!
    @PostMapping
    public ProductCreatedResponse crateProduct(@RequestBody ProductForCreateDto productDto) {
        //Veritabanına product nesnesi ekle
        //Sen dışardan ProductForCreateDto alıyorsun, ama veritabanına Product nesnesi eklemen gerekiyor.
        //O zaman ProductForCreateDto'yu Product'a çevirmen gerekiyor.

        if(productDto.getPrice()<0)
            throw new RuntimeException("Fiyat 0'dan küçük olamaz.");

        //Transfer ->MANUEL MAPPING
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setId(new Random().nextInt(999));


        productList.add(product);

        //Domain Nesnesi -> Dto
        ProductCreatedResponse response = new ProductCreatedResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());

        return response;

        //Ben controller olarak iş kodu çalıştıramam, ama bunu yapmam gerekli..
        //İş kodunu çalıştırıcak olan yapıya BAĞIMLIYIM.
        //Bağımlılık Enjeksiyonu -> Dependency Injection
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        //..
        Product productToUpdate = productList.stream().filter(p->p.getId()==product.getId()).findFirst().orElseThrow();
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable int id) {
        //Listeden id == product.getId() olan ürünü bul ve sil, yoksa null döndür.
        Product productToDelete = productList.stream().filter(p->p.getId()==id).findFirst().orElseThrow();
        productList.remove(productToDelete);
    }
    
    //DTO => Data Transfer Object => DTO'lar entity ile X (Controller, Service) arası veri transferi için oluşturulan sınıflardır.
    */
    


}
 