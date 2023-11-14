package edu.fag.petlove.services;

import edu.fag.petlove.dto.*;
import edu.fag.petlove.exceptions.EntityPersistenceException;
import edu.fag.petlove.exceptions.RequestInvalidException;
import edu.fag.petlove.exceptions.ResourceNotFoundException;
import edu.fag.petlove.mappers.ProductMapper;
import edu.fag.petlove.models.*;
import edu.fag.petlove.repositories.ProductRepository;
import edu.fag.petlove.utils.ProductImageUtils;
import edu.fag.petlove.utils.ProductPackageUtils;
import edu.fag.petlove.utils.ProductSpecificationUtils;
import edu.fag.petlove.utils.ProductUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ProductUtils productUtils;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    private ProductPackageService productPackageService;

    @Autowired
    private ProductPackageUtils productPackageUtils;

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private ProductImageUtils productImageUtils;

    @Autowired
    private ProductSpecificationService productSpecificationService;

    @Autowired
    ProductSpecificationUtils productSpecificationUtils;

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<ProductResponseDTO> findAll() {
        try {
            List<Product> products = productRepository.findAll();
            return mapToProductResponseListDTO(products);
        } catch (DataAccessException e) {
            throw new EntityPersistenceException("Failed to search entities", e);
        }
    }

    private List<ProductResponseDTO> mapToProductResponseListDTO(List<Product> products) {
        return products.stream()
            .map(this::mapToProductResponseDTO)
            .collect(Collectors.toList());
    }

    private ProductResponseDTO mapToProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProduct(productMapper.toProductDTO(product));
        productResponseDTO.setProductPackages(product.getProductPackages());
        productResponseDTO.setProductImages(product.getProductImages());
        productResponseDTO.setProductSpecifications(product.getProductSpecifications());
        return productResponseDTO;
    }

    public ProductResponseDTO findById(Long id) {
        Product product = productRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ID " + id + " not found"));
        return productMapper.toProductResponseDTO(product);
    }

    @Transactional
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        if (productRequestDTO == null) {
            throw new RequestInvalidException("Invalid request");
        }
        try {
            Product product = productUtils.updateTimestamp(productRequestDTO.getProduct(), true);
            Product savedProduct = productRepository.save(product);

            associateProductPackageWithProduct(productRequestDTO.getProductPackages(), savedProduct);
            associateProductImagesWithProduct(productRequestDTO.getProductImages(), savedProduct);
            associateProductSpecificationWithProduct(productRequestDTO.getProductSpecifications(), savedProduct);

            productRequestDTO.getProductPackages().forEach( productPackage -> {
                productPackageService.save(productPackage);
            });

            productRequestDTO.getProductImages().forEach( productImage -> {
                productImageService.save(productImage);
            });

            productRequestDTO.getProductSpecifications().forEach( productSpecification -> {
                productSpecificationService.save(productSpecification);
            });

            entityManager.flush();
            entityManager.refresh( savedProduct );
            return findById(savedProduct.getId());
        } catch (DataAccessException e) {
            throw new EntityPersistenceException("Failed to save the product", e);
        }
    }

    private void associateProductPackageWithProduct(List<? extends ProductPackage> entities, Product product) {
        if (entities != null) {
            for (ProductPackage entity : entities) {
                entity.setProduct(product);
            }
        }
    }

    private void associateProductImagesWithProduct(List<? extends ProductImage> entities, Product product) {
        if (entities != null) {
            for (ProductImage entity : entities) {
                entity.setProduct(product);
            }
        }
    }

    private void associateProductSpecificationWithProduct(List<? extends ProductSpecification> entities, Product product) {
        if (entities != null) {
            for (ProductSpecification entity : entities) {
                entity.setProduct(product);
            }
        }
    }

    @Transactional
    public ProductResponseDTO update(ProductRequestDTO productRequestDTO) {
        ProductResponseDTO sourceProductDTO = findById(productRequestDTO.getProduct().getId());
        if (sourceProductDTO == null) {
            throw new EntityNotFoundException("Entity not found");
        }
        try {
            Product mergedProduct = mergeProductBeforeUpdate(sourceProductDTO, productRequestDTO);
            Product updatedProduct = productRepository.save(mergedProduct);

            List<ProductPackage> mergedProductPackageList = productPackageUtils.mergeProductPackagesList(
                sourceProductDTO.getProductPackages(),
                productRequestDTO.getProductPackages()
            );
            associateProductPackageWithProduct(mergedProductPackageList, updatedProduct);
            mergedProductPackageList.forEach( productPackage -> {
                productPackageService.update(productPackage);
            });

            List<ProductImage> mergedProductImagesList = productImageUtils.mergeProductImagesList(
                sourceProductDTO.getProductImages(),
                productRequestDTO.getProductImages()
            );
            associateProductImagesWithProduct(mergedProductImagesList, updatedProduct);
            mergedProductImagesList.forEach( productImage -> {
                productImageService.update(productImage);
            });

            List<ProductSpecification> mergedProductSpecificationsList = productSpecificationUtils.mergeProductSpecificationsList(
                    sourceProductDTO.getProductSpecifications(),
                    productRequestDTO.getProductSpecifications()
            );
            associateProductSpecificationWithProduct(mergedProductSpecificationsList, updatedProduct);
            mergedProductSpecificationsList.forEach( productSpecification -> {
                productSpecificationService.update(productSpecification);
            });

            entityManager.flush();
            entityManager.refresh( updatedProduct );
            return findById(updatedProduct.getId());
        } catch (DataAccessException e) {
            throw new EntityPersistenceException("Failed to update entity", e);
        }
    }

    private Product mergeProductBeforeUpdate(ProductResponseDTO sourceProductDTO, ProductRequestDTO targetProductDTO) {
        Product sourceProduct = productMapper.toProduct(sourceProductDTO.getProduct());
        Product targetProduct = targetProductDTO.getProduct();
        Product mergedProduct = productUtils.copyAndModify(sourceProduct, targetProduct);
                mergedProduct = productUtils.updateTimestamp(mergedProduct, false);
                mergedProduct.setProductPackages(sourceProductDTO.getProductPackages());
                mergedProduct.setProductImages(sourceProductDTO.getProductImages());
                mergedProduct.setProductSpecifications(sourceProductDTO.getProductSpecifications());
        
        return mergedProduct;
    }

    @Transactional
    public void delete(Long productId) {
        ProductResponseDTO sourceProductDTO = findById(productId);
        if (sourceProductDTO == null) {
            throw new EntityNotFoundException("ID " + productId + " not found");
        }
        try {
            productPackageService.deleteByProductId(productId);
            productImageService.deleteByProductId(productId);
            productSpecificationService.deleteByProductId(productId);

            Product productToDelete = productMapper.toProduct(sourceProductDTO.getProduct());
            productRepository.delete(productToDelete);
        } catch (DataAccessException e) {
            throw new EntityPersistenceException("Failed to delete entity", e);
        }
    }
}
