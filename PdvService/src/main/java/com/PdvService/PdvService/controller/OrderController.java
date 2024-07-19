package com.PdvService.PdvService.controller;


import com.PdvService.PdvService.dto.OrderDto;
import com.PdvService.PdvService.dto.ProductDto;
import com.PdvService.PdvService.model.Order;
import com.PdvService.PdvService.model.Product;
import com.PdvService.PdvService.service.ServiceOrder;
import com.PdvService.PdvService.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/order")
public class OrderController {


    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;


    @Autowired
    private ServiceOrder service;

    @Autowired
    private ServiceProduct serviceProduct;

    @GetMapping
    public ResponseEntity getOrder(){
        var orders = service.getAll();
        return ResponseEntity.ok(orders);
    }


    @GetMapping("/{idOrder}")
    public ResponseEntity getOneOrder(@PathVariable String idOrder){
        var order = service.getById(idOrder);
        return ResponseEntity.ok(order);
    }


    @PostMapping
    public ResponseEntity postOrder(@RequestBody OrderDto dto){
        Optional<Product> optionalProduct = Optional.ofNullable(serviceProduct.getById(dto.productId()));

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            Integer ValorAtt =  product.getQuantity() - dto.quantity();
            product.setQuantity(ValorAtt);
            Order order = new Order(dto, product);
            service.postOrder(order);

            kafkaTemplate.send("pdv-estudos", order);
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }

//    @PutMapping("/{idOrder}")
//
//    public ResponseEntity putOrder (@RequestBody OrderDto dto, @PathVariable String idOrder){
//        service.updateOrder(idOrder, dto);
//        return ResponseEntity.ok().build();
//    }


}
