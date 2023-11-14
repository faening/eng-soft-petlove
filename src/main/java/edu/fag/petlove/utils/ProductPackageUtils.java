package edu.fag.petlove.utils;

import edu.fag.petlove.models.ProductPackage;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ProductPackageUtils {
    public List<ProductPackage> mergeProductPackagesList(
        List<ProductPackage> productPackageSourceList,
        List<ProductPackage> productPackagesTargetList
    ) {
        List<ProductPackage> mergedList = new ArrayList<>(productPackageSourceList);

        if (productPackagesTargetList != null) {
            for (ProductPackage target : productPackagesTargetList) {
                ProductPackage correspondingSource = findCorrespondingSource(target, mergedList);
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

    private ProductPackage findCorrespondingSource(ProductPackage target, List<ProductPackage> sourceList) {
        for (ProductPackage source : sourceList) {
            if (source.getId().equals(target.getId())) {
                return source;
            }
        }
        return null;
    }

    public ProductPackage copyAndModify(ProductPackage source, ProductPackage target) {
        ProductPackage mergedProductPackage = new ProductPackage();

        if (target.getId() != null) {
            mergedProductPackage.setId(target.getId());
        } else {
            mergedProductPackage.setId(source.getId());
        }

        if (target.getName() != null) {
            mergedProductPackage.setName(target.getName());
        } else {
            mergedProductPackage.setName(source.getName());
        }

        if (target.getPrice() != null) {
            mergedProductPackage.setPrice(target.getPrice());
        } else {
            mergedProductPackage.setPrice(source.getPrice());
        }

        if (target.getProduct() != null) {
            mergedProductPackage.setProduct(target.getProduct());
        } else {
            mergedProductPackage.setProduct(source.getProduct());
        }

        mergedProductPackage.setCreatedAt(source.getCreatedAt());
        mergedProductPackage.setUpdatedAt(Date.from(Instant.now()));
        return mergedProductPackage;
    }

    public ProductPackage updateTimestamp(ProductPackage productPackage, Boolean isSaving) {
        productPackage.setUpdatedAt(Date.from(Instant.now()));
        if (isSaving) {
            productPackage.setCreatedAt(Date.from(Instant.now()));
        }
        return productPackage;
    }
}
