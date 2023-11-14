package edu.fag.petlove.utils;

import edu.fag.petlove.models.Product;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class ProductUtils {
    public Product copyAndModify(Product source, Product target) {
        Product mergedProduct = new Product();

        if (target.getId() != null) {
            mergedProduct.setId(target.getId());
        } else {
            mergedProduct.setId(source.getId());
        }

        if (target.getName() != null) {
            mergedProduct.setName(target.getName());
        } else {
            mergedProduct.setName(source.getName());
        }

        if (target.getDescription() != null) {
            mergedProduct.setDescription(target.getDescription());
        } else {
            mergedProduct.setDescription(source.getDescription());
        }

        if (target.getBarCode() != null) {
            mergedProduct.setBarCode(target.getBarCode());
        } else {
            mergedProduct.setBarCode(source.getBarCode());
        }

        if (target.getBrand() != null) {
            mergedProduct.setBrand(target.getBrand());
        } else {
            mergedProduct.setBrand(source.getBrand());
        }

        mergedProduct.setCreatedAt(source.getCreatedAt());
        mergedProduct.setUpdatedAt(Date.from(Instant.now()));
        return mergedProduct;
    }

    public Product updateTimestamp(Product product, Boolean isSaving) {
        product.setUpdatedAt(Date.from(Instant.now()));
        if (isSaving) {
            product.setCreatedAt(Date.from(Instant.now()));
        }
        return product;
    }
}
