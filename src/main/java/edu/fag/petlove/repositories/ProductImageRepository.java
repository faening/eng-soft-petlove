package edu.fag.petlove.repositories;

import edu.fag.petlove.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long>  {
    void deleteByProductId(Long productId);
}
