package com.capricove.capricove.backend.repositories;

import com.capricove.capricove.backend.entities.OrderDAO;
import com.capricove.capricove.backend.entities.OrderDetailsDAO;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetailsDAO, Integer> {

    List<OrderDetailsDAO> findAll();

    List<OrderDetailsDAO> findByOrderId(String orderId);
}
