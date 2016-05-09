package io.github.rebelizant.jaxrsexample.rest;

import io.github.rebelizant.jaxrsexample.domain.Product;
import io.github.rebelizant.jaxrsexample.persistence.ProductRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * @author rebelizant
 *         Created on 06.05.16
 */
@Named
@Singleton
public class ProductResourceImpl implements ProductResource {

    @Inject
    private ProductRepository productRepository;

    @Override
    public Product getProduct(Long id) {
        return productRepository.getProduct(id);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        productRepository.updateProduct(id, product);
    }

    @Override
    public List<Product> getProducts(int start, int count) {
        return productRepository.getProducts(start, count);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteProduct(id);
    }

}
