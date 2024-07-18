package com.PdvService.PdvService.model;


import com.PdvService.PdvService.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    private String productName;
    private Integer quantity;
    private Float  price;

    public Product(ProductDto dto){
        this.productName = dto.productName();
        this.price = dto.price();
        this.quantity = dto.quantity();
    }

    public void update(ProductDto dto){
        if(dto.productName() != null){
            this.productName = dto.productName();
        }
        if(dto.quantity() != null){
            this.quantity = dto.quantity();
        }
        if(dto.price() != null){
            this.price = dto.price();
        }
    }

}
