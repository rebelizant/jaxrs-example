package io.github.rebelizant.jaxrsexample.persistence;

import io.github.rebelizant.jaxrsexample.domain.AbstractEntity;
import io.github.rebelizant.jaxrsexample.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    
    private ConcurrentMap<Long, Product> products;
    
    public ProductRepositoryImpl() {
        products = IntStream.range(1, 11).mapToObj(this::randomProduct)
                        .collect(Collectors.toConcurrentMap(AbstractEntity::getId, p -> p));
    }
    
    public void addProduct(Product product) {
        Long nextId = nextId(products);
        product.setId(nextId);
        products.put(nextId, product);
    }
    
    public Product getProduct(Long id) {
        return products.get(id);
    }
    
    public List<Product> getProducts(int start, int count) {
        Stream<Product> stream = products.values().stream().skip(start > 0 ? start - 1 : start);
        if (count > 0) {
            return stream.limit(count).collect(Collectors.toList());
        }
        return stream.collect(Collectors.toList());
    }
    
    public void deleteProduct(Long id) {
        products.remove(id);
    }
    
    public void updateProduct(Long id, Product product) {
        product.setId(id);
        products.put(id, product);
    }
    
    private Product randomProduct(int id) {
        Product product = new Product();
        product.setId((long) id);
        product.setName(String.format("Name-%s", id));
        product.setCost(BigDecimal.valueOf(Math.random() * 10));
        return product;
    }
    
}