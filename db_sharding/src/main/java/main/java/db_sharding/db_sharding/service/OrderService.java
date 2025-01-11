package main.java.db_sharding.db_sharding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import main.java.db_sharding.db_sharding.entity.Order;
import main.java.db_sharding.db_sharding.repository.OrderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepo orderRepo;

    /**
     * Creates a new order in the database.
     * 
     * @param order the order to be saved
     * @return the saved order
     * @throws IllegalArgumentException if the order is null
     */
    @Transactional
    public Order createOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        logger.info("Creating order: {}", order);
        return orderRepo.save(order);
    }

    /**
     * Fetches an order by its ID.
     * 
     * @param orderId the ID of the order to fetch
     * @return the order if found
     * @throws RuntimeException if the order is not found
     */
    public Order getOrderById(Long orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException("Order ID cannot be null");
        }
        logger.info("Fetching order with ID: {}", orderId);
        return orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
    }

    /**
     * Fetches all orders.
     * 
     * @return the list of all orders
     */
    public List<Order> getAllOrders() {
        logger.info("Fetching all orders");
        return orderRepo.findAll();
    }

    /**
     * Deletes an order by its ID.
     * 
     * @param orderId the ID of the order to delete
     */
    @Transactional
    public void deleteOrder(Long orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException("Order ID cannot be null");
        }
        logger.info("Deleting order with ID: {}", orderId);
        orderRepo.deleteById(orderId);
    }
    
}
