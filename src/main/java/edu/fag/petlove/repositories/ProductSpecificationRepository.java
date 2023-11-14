package edu.fag.petlove.repositories;

import edu.fag.petlove.models.ProductSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification, Long>  {
    void deleteByProductId(Long productId);
}
