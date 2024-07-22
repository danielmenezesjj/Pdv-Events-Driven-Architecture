package com.daniel.estoqueservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.daniel.estoqueservice.json.OrderJson;
import com.daniel.estoqueservice.model.PedidoDeVenda;
import com.daniel.estoqueservice.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueListener {


    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<PedidoDeVenda> list() {
        return repository.findAll();
    }


    @KafkaListener(topics = "email-topic", groupId = "pdv-estudos")
    public void processarVenda(String mensagem) throws JsonProcessingException {
        System.out.println("Email: " + mensagem);

        ObjectMapper objectMapper = new ObjectMapper();
        OrderJson order = objectMapper.readValue(mensagem, OrderJson.class);

        String productId = order.getProduct().getId();
        String idPedido = order.getId();
        System.out.println("Product ID: " + productId);
        System.out.println("Id Pedido:" + idPedido);
        repository.updateStatusParaAprovado(idPedido);
    }
}

