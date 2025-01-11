package main.java.db_sharding.db_sharding.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long        orderId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User        user;
    private String      orderDate;


    public Order() {
    }

    public Order(
            Long orderId, 
            User user, 
            String orderDate
    ) {
        this.orderId = orderId;
        this.user = user;
        this.orderDate = orderDate;
    }

    public Long getorderId() {
        return orderId;
    }

    public void setorderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getorderDate() {
        return orderDate;
    }

    public void setorderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
