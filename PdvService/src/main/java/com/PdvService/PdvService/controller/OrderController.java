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

@RestController
@RequestMapping("/v1/order")
public class OrderController {


    @Autowired
    private KafkaTemplate<String, OrderDto> kafkaTemplate;


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
        Product product = serviceProduct.getById(dto.productId());
        Order order = new Order(dto, product);
        kafkaTemplate.send("pdv-estudos", dto); // Enviando o OrderDto diretamente
        service.postOrder(order);
        return ResponseEntity.ok(order);
    }

//    @PutMapping("/{idOrder}")
//
//    public ResponseEntity putOrder (@RequestBody OrderDto dto, @PathVariable String idOrder){
//        service.updateOrder(idOrder, dto);
//        return ResponseEntity.ok().build();
//    }


}
