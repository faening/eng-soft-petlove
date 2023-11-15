package edu.fag.petlove.services;

import edu.fag.petlove.models.ProductPackage;
import edu.fag.petlove.repositories.ProductPackageRepository;
import edu.fag.petlove.utils.ProductPackageUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductPackageService extends _GenericService<ProductPackage> {
    @Autowired
    ProductPackageRepository productPackageRepository;

    @Autowired
    ProductPackageUtils productPackageUtils;

    public ProductPackageService(ProductPackageRepository productPackageRepository) {
        super(productPackageRepository);
    }

    @Override
    protected ProductPackage updateTimestampBeforeSaving(ProductPackage entity) {
        return productPackageUtils.updateTimestamp(entity, true);
    }

    @Override
    protected Long getEntityId(ProductPackage entity) {
        return entity.getId();
    }

    @Override
    protected ProductPackage updateExistingEntity(ProductPackage sourceEntity, ProductPackage targetEntity) {
        return productPackageUtils.copyAndModify(sourceEntity, targetEntity);
    }

    @Transactional
    public void deleteByProductId(Long productId) {
        productPackageRepository.deleteByProductId(productId);
    }
}
