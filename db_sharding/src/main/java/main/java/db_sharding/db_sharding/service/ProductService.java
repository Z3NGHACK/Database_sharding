package main.java.db_sharding.db_sharding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import main.java.db_sharding.db_sharding.entity.Product;
import main.java.db_sharding.db_sharding.repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepo productRepo;

    /**
     * Creates a new product in the database.
     * 
     * @param product the product to be saved
     * @return the saved product
     * @throws IllegalArgumentException if the product is null
     */
    @Transactional
    public Product createProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        logger.info("Creating product: {}", product);
        return productRepo.save(product);
    }

    /**
     * Fetches a product by its ID.
     * 
     * @param productId the ID of the product to fetch
     * @return the product if found
     * @throws RuntimeException if the product is not found
     */
    public Product getProductById(Long productId) {
        if (productId == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        logger.info("Fetching product with ID: {}", productId);
        return productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
    }

    /**
     * Fetches all products.
     * 
     * @return the list of all products
     */
    public List<Product> getAllProducts() {
        logger.info("Fetching all products");
        return productRepo.findAll();
    }

    /**
     * Deletes a product by its ID.
     * 
     * @param productId the ID of the product to delete
     */
    @Transactional
    public void deleteProduct(Long productId) {
        if (productId == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        logger.info("Deleting product with ID: {}", productId);
        productRepo.deleteById(productId);
    }
}
