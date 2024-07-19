package com.PdvService.PdvService.service;


import com.PdvService.PdvService.dto.OrderDto;
import com.PdvService.PdvService.dto.ProductDto;
import com.PdvService.PdvService.model.Order;
import com.PdvService.PdvService.model.Product;
import com.PdvService.PdvService.repository.OrderRepository;
import com.PdvService.PdvService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrder {



    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;


    public List<Order> getAll(){
        var orders = repository.findAll();
        return orders;
    }

    public Order postOrder(Order order){
        return repository.save(order);
    }

    public Order getById(String idOrder){
        Optional<Order> optionalOrder = repository.findById(idOrder);
        if(optionalOrder.isPresent()){
            return optionalOrder.get();
        }
        throw new RuntimeException("Pedido com o Id: " + idOrder + " não localizado!");
    }

//    public Order updateOrder(String idOrder, OrderDto dto){
//        Optional<Order> optionalOrder = repository.findById(idOrder);
//        if(optionalOrder.isPresent()){
//            Order order = optionalOrder.get();
//            order.update(dto);
//            repository.save(order);
//            return order;
//        }
//        throw new RuntimeException("Pedido com o Id: " + idOrder + " não localizado!");
//    }

}
