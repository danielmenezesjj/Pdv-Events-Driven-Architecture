package com.kipper.estoqueservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kipper.estoqueservice.json.VendaJson;
import com.kipper.estoqueservice.model.PedidoDeVenda;
import com.kipper.estoqueservice.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueListener {


    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<PedidoDeVenda> list() {
        return repository.findAll();
    }


    @KafkaListener(topics = "pdv-estudos", groupId = "pdv-estudos")
    public void processarVenda(String mensagem) throws JsonProcessingException {
        System.out.println("Venda recebida: " + mensagem);
        VendaJson venda = objectMapper.readValue(mensagem, VendaJson.class);
        String productId = venda.getProductId();
        int quantity = venda.getQuantity();
        String paymentType = venda.getPaymentType();
        System.out.println("ProductId: " + productId);
        System.out.println("Quantity: " + quantity);
        System.out.println("PaymentType: " + paymentType);
    }
}

