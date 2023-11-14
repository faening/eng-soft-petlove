package edu.fag.petlove.utils;

import edu.fag.petlove.models.ProductImage;
import edu.fag.petlove.models.ProductPackage;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ProductImageUtils {
    public List<ProductImage> mergeProductImagesList(
            List<ProductImage> productImagesSourceList,
            List<ProductImage> productImagesTargetList
    ) {
        List<ProductImage> mergedList = new ArrayList<>(productImagesSourceList);

        if (productImagesTargetList != null) {
            for (ProductImage target : productImagesTargetList) {
                ProductImage correspondingSource = findCorrespondingSource(target, mergedList);
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

    private ProductImage findCorrespondingSource(ProductImage target, List<ProductImage> sourceList) {
        for (ProductImage source : sourceList) {
            if (source.getId().equals(target.getId())) {
                return source;
            }
        }
        return null;
    }

    public ProductImage copyAndModify(ProductImage source, ProductImage target) {
        ProductImage mergedProductImage = new ProductImage();

        if (target.getId() != null) {
            mergedProductImage.setId(target.getId());
        } else {
            mergedProductImage.setId(source.getId());
        }

        if (target.getImageUrl() != null) {
            mergedProductImage.setImageUrl(target.getImageUrl());
        } else {
            mergedProductImage.setImageUrl(source.getImageUrl());
        }

        if (target.getImageUrl() != null) {
            mergedProductImage.setImageUrl(target.getImageUrl());
        } else {
            mergedProductImage.setImageUrl(source.getImageUrl());
        }

        if (target.getProduct() != null) {
            mergedProductImage.setProduct(target.getProduct());
        } else {
            mergedProductImage.setProduct(source.getProduct());
        }

        mergedProductImage.setCreatedAt(source.getCreatedAt());
        mergedProductImage.setUpdatedAt(Date.from(Instant.now()));
        return mergedProductImage;
    }

    public ProductImage updateTimestamp(ProductImage productImage, Boolean isSaving) {
        productImage.setUpdatedAt(Date.from(Instant.now()));
        if (isSaving) {
            productImage.setCreatedAt(Date.from(Instant.now()));
        }
        return productImage;
    }
}
