package com.kipper.estoqueservice.repository;

import com.kipper.estoqueservice.model.PedidoDeVenda;
import feign.Param;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoDeVenda, String> {


    @Modifying
    @Transactional
    @Query("UPDATE order_pdv p SET p.status = 'APROVED' WHERE p.id = :id")
    void updateStatusParaAprovado(@Param("id") String id);

}
