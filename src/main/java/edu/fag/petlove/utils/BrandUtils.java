package edu.fag.petlove.utils;

import edu.fag.petlove.models.Brand;
import edu.fag.petlove.models.Product;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class BrandUtils {
    public Brand copyAndModify(Brand source, Brand target) {
        if (target.getName() == null) {
            target.setName(source.getName());
        }
        target.setCreatedAt(source.getCreatedAt());
        target.setUpdatedAt(Date.from(Instant.now()));
        return target;
    }

    public Brand updateTimestamp(Brand brand, Boolean isSaving) {
        brand.setUpdatedAt(Date.from(Instant.now()));
        if (isSaving) {
            brand.setCreatedAt(Date.from(Instant.now()));
        }
        return brand;
    }
}
