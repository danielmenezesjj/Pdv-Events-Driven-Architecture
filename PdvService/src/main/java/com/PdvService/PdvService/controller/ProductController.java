package com.PdvService.PdvService.controller;


import com.PdvService.PdvService.dto.ProductDto;
import com.PdvService.PdvService.model.Product;
import com.PdvService.PdvService.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
public class ProductController {


    @Autowired
    private ServiceProduct service;

    @GetMapping
    public ResponseEntity getProduct(){
        var produtos = service.getAll();
        return ResponseEntity.ok(produtos);
    }


    @GetMapping("/{idProduct}")
    public ResponseEntity getOneProduct(@PathVariable String idProduct){
        var product = service.getById(idProduct);
        return ResponseEntity.ok(product);
    }


    @PostMapping
    public ResponseEntity postProduct(@RequestBody ProductDto dto){
        Product product = new Product(dto);
        service.postProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{idProduct}")

    public ResponseEntity putProduct (@RequestBody ProductDto dto, @PathVariable String idProduct){
        service.updateProduct(idProduct, dto);
        return ResponseEntity.ok().build();
    }


}
