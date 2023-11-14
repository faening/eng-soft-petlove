package edu.fag.petlove.mappers;

import edu.fag.petlove.dto.ProductDTO;
import edu.fag.petlove.dto.ProductResponseDTO;
import edu.fag.petlove.models.Brand;
import edu.fag.petlove.models.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductDTO productDTO) {
        Brand brand = productDTO.getBrand();
        return new Product(
            productDTO.getId(),
            productDTO.getName(),
            productDTO.getDescription(),
            productDTO.getBarCode(),
            brand,
            productDTO.getCreatedAt(),
            productDTO.getUpdatedAt()
        );
    }

    public ProductDTO toProductDTO(Product product) {
        Brand brand = product.getBrand();
        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getBarCode(),
            brand,
            product.getCreatedAt(),
            product.getUpdatedAt()
        );
    }

    public ProductResponseDTO toProductResponseDTO(Product product) {
        Brand brand = product.getBrand();
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        responseDTO.setProduct(new ProductDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getBarCode(),
            brand,
            product.getCreatedAt(),
            product.getUpdatedAt()
        ));
        responseDTO.setProductPackages( product.getProductPackages() );
        responseDTO.setProductImages( product.getProductImages() );
        responseDTO.setProductSpecifications( product.getProductSpecifications() );

        return responseDTO;
    }
}

