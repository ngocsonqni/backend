package com.codegym.dao.repository;

import com.codegym.dao.entity.Order;
import com.codegym.dao.entity.OrderDetail;
import com.codegym.dao.entity.OrderDetailPk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPk>{
    Page<OrderDetail> findAllById_OrderUser(Order order, Pageable pageable);
}
