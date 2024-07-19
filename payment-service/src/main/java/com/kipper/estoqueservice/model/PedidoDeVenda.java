package com.kipper.estoqueservice.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "order_pdv")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDeVenda {


    @Id
    private String id;
    private String type_payment;
    private Integer quantity;
    private String status;





}
