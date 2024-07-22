package com.daniel.estoqueservice.controller;


import com.daniel.estoqueservice.model.PedidoDeVenda;
import com.daniel.estoqueservice.service.EstoqueListener;
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
