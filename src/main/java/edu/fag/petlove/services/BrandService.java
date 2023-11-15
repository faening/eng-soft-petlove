package edu.fag.petlove.services;

import edu.fag.petlove.models.Brand;
import edu.fag.petlove.repositories.BrandRepository;
import edu.fag.petlove.utils.BrandUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService extends _GenericService<Brand> {
    @Autowired
    BrandRepository brandRepository;

    @Autowired
    BrandUtils brandUtils;

    public BrandService(BrandRepository brandRepository) {
        super(brandRepository);
    }

    @Override
    protected Brand updateTimestampBeforeSaving(Brand entity) {
        return brandUtils.updateTimestamp(entity, false);
    }

    @Override
    protected Long getEntityId(Brand entity) {
        return entity.getId();
    }

    @Override
    protected Brand updateExistingEntity(Brand sourceEntity, Brand targetEntity) {
        return brandUtils.copyAndModify(sourceEntity, targetEntity);
    }
}
