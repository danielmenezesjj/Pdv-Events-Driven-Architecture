package com.PdvService.PdvService.model;


import com.PdvService.PdvService.dto.OrderDto;
import com.PdvService.PdvService.dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "order-pdv")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    private String typePayment;
    private Integer quantity;
    private String status;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Order(OrderDto dto, Product product){
        this.typePayment = dto.typePayment();
        this.quantity = dto.quantity();
        this.status = dto.status();
        this.product = product;
    }

    public void update(OrderDto dto, Product product){
        if(dto.typePayment() != null){
            this.typePayment = dto.typePayment();
        }
        if(dto.status() != null){
            this.status = dto.status();
        }
        if(product != null){
            this.product = product;
        }
    }
}

