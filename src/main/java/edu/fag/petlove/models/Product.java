package edu.fag.petlove.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false, length = 255)
    private String name;

    @Column(name="description", nullable = false)
    @Lob
    private String description;

    @Column(name="bar_code", length = 13)
    private String barCode;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ProductPackage> productPackages;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ProductSpecification> productSpecifications;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public Product(
        Long id,
        String name,
        String description,
        String barCode,
        Brand brand,
        List<ProductPackage> productPackages,
        List<ProductImage> productImages,
        List<ProductSpecification> productSpecifications,
        Date createdAt, Date updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.barCode = barCode;
        this.brand = brand;
        this.productPackages = productPackages;
        this.productImages = productImages;
        this.productSpecifications = productSpecifications;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(
        Long id,
        String name,
        String description,
        String barCode,
        Brand brand
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.barCode = barCode;
        this.brand = brand;
    }

    public Product(
        String name,
        String description,
        String barCode,
        Brand brand,
        List<ProductPackage> productPackages,
        List<ProductImage> productImages,
        List<ProductSpecification> productSpecifications,
        Date createdAt,
        Date updatedAt
    ) {
        this.name = name;
        this.description = description;
        this.barCode = barCode;
        this.brand = brand;
        this.productPackages = productPackages;
        this.productImages = productImages;
        this.productSpecifications = productSpecifications;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(
        Long id,
        String name,
        String description,
        String barCode,
        Brand brand,
        Date createdAt,
        Date updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.barCode = barCode;
        this.brand = brand;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(
        String name,
        String description,
        String barCode,
        Brand brand,
        List<ProductPackage> productPackages,
        List<ProductImage> productImages,
        List<ProductSpecification> productSpecifications
    ) {
        this.name = name;
        this.description = description;
        this.barCode = barCode;
        this.brand = brand;
        this.productPackages = productPackages;
        this.productImages = productImages;
        this.productSpecifications = productSpecifications;
    }

    public Product() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
