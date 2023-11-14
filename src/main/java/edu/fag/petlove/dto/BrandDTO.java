package edu.fag.petlove.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BrandDTO {
    private Long id;

    private String name;

    public BrandDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public BrandDTO() { }

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
}
