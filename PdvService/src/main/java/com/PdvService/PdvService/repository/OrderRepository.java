package com.PdvService.PdvService.repository;

import com.PdvService.PdvService.model.Order;
import com.PdvService.PdvService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
