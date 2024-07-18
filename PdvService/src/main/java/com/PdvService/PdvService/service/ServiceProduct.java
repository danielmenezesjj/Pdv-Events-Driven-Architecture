package com.PdvService.PdvService.service;


import com.PdvService.PdvService.dto.ProductDto;
import com.PdvService.PdvService.model.Product;
import com.PdvService.PdvService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProduct {



    @Autowired
    private ProductRepository repository;

    public List<Product> getAll(){
        var produtos = repository.findAll();
        return produtos;
    }

    public Product postProduct(Product product){
        return repository.save(product);
    }

    public Product getById(String idProduct){
        Optional<Product> optionalProduct = repository.findById(idProduct);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        throw new RuntimeException("Produto com o Id: " + idProduct + " não localizado!");
    }

    public Product updateProduct(String idProduct, ProductDto dto){
        Optional<Product> optionalProduct = repository.findById(idProduct);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.update(dto);
            repository.save(product);
            return product;
        }
        throw new RuntimeException("Produto com o Id: " + idProduct + " não localizado!");
    }

}
