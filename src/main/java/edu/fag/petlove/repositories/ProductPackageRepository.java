package edu.fag.petlove.repositories;

import edu.fag.petlove.models.ProductPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPackageRepository extends JpaRepository<ProductPackage, Long>  {
    void deleteByProductId(Long productId);
}
