package edu.fag.petlove.services;

import edu.fag.petlove.models.ProductSpecification;
import edu.fag.petlove.repositories.ProductSpecificationRepository;
import edu.fag.petlove.utils.ProductSpecificationUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSpecificationService extends _GenericService<ProductSpecification> {
    @Autowired
    ProductSpecificationRepository productSpecificationRepository;

    @Autowired
    ProductSpecificationUtils productSpecificationUtils;

    @Override
    protected ProductSpecification updateTimestampBeforeSaving(ProductSpecification entity) {
        return productSpecificationUtils.updateTimestamp(entity, true);
    }

    @Override
    protected Long getEntityId(ProductSpecification entity) {
        return entity.getId();
    }

    @Override
    protected ProductSpecification updateExistingEntity(ProductSpecification sourceEntity, ProductSpecification targetEntity) {
        return productSpecificationUtils.copyAndModify(sourceEntity, targetEntity);
    }

    @Transactional
    public void deleteByProductId(Long productId) {
        productSpecificationRepository.deleteByProductId(productId);
    }
}
