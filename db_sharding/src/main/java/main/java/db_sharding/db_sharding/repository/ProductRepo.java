package main.java.db_sharding.db_sharding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.db_sharding.db_sharding.entity.Product;
import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long> 
{
    List<Product> findByProductName(String productName);
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}
