package edu.fag.petlove.dto;

import edu.fag.petlove.models.Product;
import edu.fag.petlove.models.ProductImage;
import edu.fag.petlove.models.ProductPackage;
import edu.fag.petlove.models.ProductSpecification;

import java.io.Serializable;
import java.util.List;

public class ProductRequestDTO implements Serializable {
    private Product product;
    private List<ProductPackage> productPackages;
    private List<ProductImage> productImages;
    private List<ProductSpecification> productSpecifications;

    public ProductRequestDTO(
        Product product,
        List<ProductPackage> productPackages,
        List<ProductImage> productImages,
        List<ProductSpecification> productSpecifications
    ) {
        this.product = product;
        this.productPackages = productPackages;
        this.productImages = productImages;
        this.productSpecifications = productSpecifications;
    }

    public ProductRequestDTO(
        Product product
    ) {
        this.product = product;
    }

    public ProductRequestDTO() { }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<ProductPackage> getProductPackages() {
        return productPackages;
    }

    public void setProductPackages(List<ProductPackage> productPackages) {
        this.productPackages = productPackages;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public List<ProductSpecification> getProductSpecifications() {
        return productSpecifications;
    }

    public void setProductSpecifications(List<ProductSpecification> productSpecifications) {
        this.productSpecifications = productSpecifications;
    }
}
