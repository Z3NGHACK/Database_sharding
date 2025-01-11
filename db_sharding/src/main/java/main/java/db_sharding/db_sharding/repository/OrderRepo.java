package main.java.db_sharding.db_sharding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.db_sharding.db_sharding.entity.Order;
import main.java.db_sharding.db_sharding.entity.User;

import java.time.LocalDate;


public interface OrderRepo extends JpaRepository<Order, Long> 
{
    List<Order> findByUser(User user);
    List<Order> findByOrderDate(LocalDate orderDate);

}
