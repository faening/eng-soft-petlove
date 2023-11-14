package edu.fag.petlove.dto;

import edu.fag.petlove.models.Brand;

import java.io.Serializable;
import java.util.Date;

public class ProductDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String barCode;
    private Brand brand;
    private Date createdAt;
    private Date updatedAt;

    public ProductDTO(Long id, String name, String description, String barCode, Brand brand, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.barCode = barCode;
        this.brand = brand;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ProductDTO(Long id, String name, String description, String barCode, Brand brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.barCode = barCode;
        this.brand = brand;
    }

    public ProductDTO() { }

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
