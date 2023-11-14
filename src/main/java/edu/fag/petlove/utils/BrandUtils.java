package edu.fag.petlove.utils;

import edu.fag.petlove.models.Brand;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class BrandUtils {
    public Brand copyAndModify(Brand source, Brand target) {
        Brand mergedBrand = new Brand();

        if (target.getId() != null) {
            mergedBrand.setId(target.getId());
        } else {
            mergedBrand.setId(source.getId());
        }

        if (target.getName() != null) {
            mergedBrand.setName(target.getName());
        } else {
            mergedBrand.setName(source.getName());
        }

        mergedBrand.setCreatedAt(source.getCreatedAt());
        mergedBrand.setUpdatedAt(Date.from(Instant.now()));
        return mergedBrand;
    }

    public Brand updateTimestamp(Brand brand, Boolean isSaving) {
        brand.setUpdatedAt(Date.from(Instant.now()));
        if (isSaving) {
            brand.setCreatedAt(Date.from(Instant.now()));
        }
        return brand;
    }
}
