package main.java.db_sharding.db_sharding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.db_sharding.db_sharding.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> 
{}
