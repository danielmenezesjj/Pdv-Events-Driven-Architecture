package com.kipper.estoqueservice.controller;


import com.kipper.estoqueservice.model.PedidoDeVenda;
import com.kipper.estoqueservice.service.EstoqueListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {


    @Autowired
    private EstoqueListener service;

    @GetMapping
    public ResponseEntity getPedido(){
        var pedidos = service.list();
        return ResponseEntity.ok(pedidos);
    }

}
