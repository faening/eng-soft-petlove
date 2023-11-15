package edu.fag.petlove.services;

import edu.fag.petlove.models.ProductImage;
import edu.fag.petlove.repositories.ProductImageRepository;
import edu.fag.petlove.utils.ProductImageUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService extends _GenericService<ProductImage> {
    @Autowired
    ProductImageRepository productImageRepository;

    @Autowired
    ProductImageUtils productImageUtils;

    public ProductImageService(ProductImageRepository productImageRepository) {
        super(productImageRepository);
    }

    @Override
    protected ProductImage updateTimestampBeforeSaving(ProductImage entity) {
        return productImageUtils.updateTimestamp(entity, true);
    }

    @Override
    protected Long getEntityId(ProductImage entity) {
        return entity.getId();
    }

    @Override
    protected ProductImage updateExistingEntity(ProductImage sourceEntity, ProductImage targetEntity) {
        return productImageUtils.copyAndModify(sourceEntity, targetEntity);
    }

    @Transactional
    public void deleteByProductId(Long productId) {
        productImageRepository.deleteByProductId(productId);
    }
}
