package edu.fag.petlove.utils;

import edu.fag.petlove.models.ProductSpecification;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ProductSpecificationUtils {
    public List<ProductSpecification> mergeProductSpecificationsList(
            List<ProductSpecification> productSpecificationSourceList,
            List<ProductSpecification> productSpecificationTargetList
    ) {
        List<ProductSpecification> mergedList = new ArrayList<>(productSpecificationSourceList);

        if (productSpecificationTargetList != null) {
            for (ProductSpecification target : productSpecificationTargetList) {
                ProductSpecification correspondingSource = findCorrespondingSource(target, mergedList);
                if (correspondingSource != null) {
                    mergedList.remove(correspondingSource);
                    mergedList.add(copyAndModify(correspondingSource, target));
                } else {
                    mergedList.add(target);
                }
            }
        }
        return mergedList;
    }

    private ProductSpecification findCorrespondingSource(ProductSpecification target, List<ProductSpecification> sourceList) {
        for (ProductSpecification source : sourceList) {
            if (source.getId().equals(target.getId())) {
                return source;
            }
        }
        return null;
    }

    public ProductSpecification copyAndModify(ProductSpecification source, ProductSpecification target) {
        ProductSpecification mergedProductSpecification = new ProductSpecification();

        if (target.getId() != null) {
            mergedProductSpecification.setId(target.getId());
        } else {
            mergedProductSpecification.setId(source.getId());
        }

        if (target.getName() != null) {
            mergedProductSpecification.setName(target.getName());
        } else {
            mergedProductSpecification.setName(source.getName());
        }

        if (target.getValue() != null) {
            mergedProductSpecification.setValue(target.getValue());
        } else {
            mergedProductSpecification.setValue(source.getValue());
        }

        if (target.getProduct() != null) {
            mergedProductSpecification.setProduct(target.getProduct());
        } else {
            mergedProductSpecification.setProduct(source.getProduct());
        }

        mergedProductSpecification.setCreatedAt(source.getCreatedAt());
        mergedProductSpecification.setUpdatedAt(Date.from(Instant.now()));
        return mergedProductSpecification;
    }

    public ProductSpecification updateTimestamp(ProductSpecification productSpecification, Boolean isSaving) {
        productSpecification.setUpdatedAt(Date.from(Instant.now()));
        if (isSaving) {
            productSpecification.setCreatedAt(Date.from(Instant.now()));
        }
        return productSpecification;
    }
}
