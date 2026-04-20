package com.turkcell.spring_starter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.dto.ProductCreatedResponse;
import com.turkcell.spring_starter.dto.ProductForCreateDto;
import com.turkcell.spring_starter.model.Product;

//Implementation

@Service //IoC'e bu türü ekledin.
public class ProductServiceImpl {
    // Controller'ın size aktaracağı işleri tanımla.
    // iş kodu..

    // repo
    private final List<Product> productsInMemory = new ArrayList<>();

    public ProductCreatedResponse create(ProductForCreateDto productDto)
    {
        
        //Aynı isimde iki ürün olamaz

        //Business Rules
        checkIfProductNameExists(productDto.getName());

        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setId(new Random().nextInt(999));

        productsInMemory.add(product); // repo

        ProductCreatedResponse response = new ProductCreatedResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());

        return response;
    }

    //İş Kuralları -> Kendine has bir classta bulunmalıdır. -> ProductBusinessRules.java gibi. -> Service'in içinde de çağırılır.
    private void checkIfProductNameExists(String name) {
        Product productWithSameName = productsInMemory.stream()
            .filter(p -> p.getName().equals(name))
            .findFirst()
            .orElse(null);

        if(productWithSameName != null) {
            throw new RuntimeException("Aynı isimde iki ürün olamaz.");
        }
    }
}


//Auto-generated

//ProductRepository <Product> -> Spring auto-generate.


//Spring IoC Nedir ? Bean,Service nedir. Bi sonraki derse girmeden bunlar bak.❓

//Inversion of Control (IoC) : Kontrolün Tersine Çevrilmesi. Spring, nesnelerin oluşturulması ve yönetilmesi gibi görevleri üstlenir. 
//@Autowired : Spring'in IoC konteyneri tarafından yönetilen bir nesneyi otomatik olarak enjekte etmek için kullanılır.

//Bean : Spring tarafından yönetilen bir nesne. Spring, uygulamanın ihtiyaç duyduğu nesneleri oluşturur ve yönetir.(IoC'deki yönetilen nesneler)