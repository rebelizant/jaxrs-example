package io.github.rebelizant.jaxrsexample.persistence;

import io.github.rebelizant.jaxrsexample.domain.*;
import java.util.List;

public interface ProductRepository extends Repository<Product> {
    
    void addProduct(Product product);
    
    Product getProduct(Long id);
    
    List<Product> getProducts(int start, int count);
    
    void deleteProduct(Long id);
    
    void updateProduct(Long id, Product product);
    
}