package edu.fag.petlove.services;

import edu.fag.petlove.models.Brand;
import edu.fag.petlove.utils.BrandUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class BrandService extends _GenericService<Brand> {
    @Autowired
    BrandUtils brandUtils;

    @Override
    protected Brand updateTimestampBeforeSaving(Brand entity) {
        entity.setCreatedAt(Date.from(Instant.now()));
        entity.setUpdatedAt(Date.from(Instant.now()));
        return entity;
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
