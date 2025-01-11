package main.java.db_sharding.db_sharding.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long        productId;

    private String      productName;
    private Double      price;

    public Product()
    {}

    public Product(
        Long productId, 
        String productName, 
        Double price
    ) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public Long getproductId() {
        return productId;
    }
    public void setproductId(Long productId) {
        this.productId = productId;
    }
    public String getproductName() {
        return productName;
    }
    public void setproductName(String productName) {
        this.productName = productName;
    }
    public Double getprice() {
        return price;
    }
    public void setprice(Double price) {
        this.price = price;
    }

}
