package edu.fag.petlove.seeds;

import edu.fag.petlove.dto.ProductRequestDTO;
import edu.fag.petlove.enums.PetAge;
import edu.fag.petlove.enums.PetSize;
import edu.fag.petlove.enums.PetType;
import edu.fag.petlove.enums.SpecificationName;
import edu.fag.petlove.models.*;
import edu.fag.petlove.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {

    }

    /*
    @Override
    public void run(String... args) throws Exception {
        // Brands
        List<Brand> brands = new ArrayList<>();
        brands.add( new Brand("Essence") );
        brands.add( new Brand("Pedigree") );
        brands.add( new Brand("Bio Dog") );
        brands.add( new Brand("Friskies") );
        brands.add( new Brand("Whiskas") );
        brands.forEach( brand -> brandService.save(brand) );

        // All of product
        List<ProductRequestDTO> productsForPersistenceList = new ArrayList<>();
        List<ProductImage> productImages = new ArrayList<>();
        List<ProductPackage> productPackages = new ArrayList<>();
        List<ProductSpecification> productSpecifications = new ArrayList<>();

        // Product 1
        Product product_1 = new Product(
            "Petisco Pedigree Dentastix Cuidado Oral Para Cães Adultos Raças Pequenas",
            "Indicado para cães adultos de raças pequenas; Sem corantes e aromas artificiais; Petisco funcional com ingredientes ativos e Vitamina E;",
            "7896029052334",
            brands.get(1)
        );
        productImages.add(new ProductImage(
            "https://images.petz.com.br/fotos/1694718495781.jpg",
            product_1
        ));
        productImages.add(new ProductImage(
            "https://images.petz.com.br/fotos/1694718521043.jpg",
            product_1
        ));
        productImages.add(new ProductImage(
            "https://images.petz.com.br/fotos/1694718521944.jpg",
            product_1
        ));
        productPackages.add(new ProductPackage(
            "3 unidades",
            10.69,
                product_1
        ));
        productPackages.add(new ProductPackage(
            "7 unidades",
            20.55,
                product_1
        ));
        productSpecifications.add(new ProductSpecification(
            SpecificationName.PET.getDisplayName(),
            PetType.DOG.getDisplayName(),
                product_1
        ));
        productSpecifications.add(new ProductSpecification(
            SpecificationName.AGE.getDisplayName(),
            PetAge.PUP.getDisplayName() + ", " + PetAge.ADULT.getDisplayName() + " e " + PetAge.OLD.getDisplayName(),
                product_1
        ));
        productSpecifications.add(new ProductSpecification(
            SpecificationName.SIZE.getDisplayName(),
            PetSize.SMALL.getDisplayName(),
                product_1
        ));

        ProductRequestDTO productSave_1 = new ProductRequestDTO(
                product_1,
                productPackages,
                productImages,
                productSpecifications
        );

        productService.save(productSave_1);

        productImages.clear();
        productPackages.clear();
        productSpecifications.clear();

        // Product 2
        Product product_2 = new Product(
            "Snack Bio Dog para Cães Adultos e Filhotes Gourmet Soft Strips",
            "Indicado para cães em geral; Petiscos 100% naturais;",
            "7898950325068",
            brands.get(2)
        );
        productImages.add(new ProductImage(
            "https://images.petz.com.br/fotos/1454507593006.jpg",
            product_2
        ));
        productPackages.add(new ProductPackage(
            "100 gramas",
            26.99,
            product_2
        ));
        productSpecifications.add(new ProductSpecification(
            SpecificationName.PET.getDisplayName(),
            PetType.DOG.getDisplayName(),
            product_2
        ));
        productSpecifications.add(new ProductSpecification(
            SpecificationName.AGE.getDisplayName(),
            PetAge.ADULT.getDisplayName(),
            product_2
        ));
        productSpecifications.add(new ProductSpecification(
            SpecificationName.SIZE.getDisplayName(),
            PetSize.SMALL.getDisplayName() + ", " + PetSize.MEDIUM.getDisplayName(),
            product_2
        ));
        productSpecifications.add(new ProductSpecification(
            SpecificationName.TYPE.getDisplayName(),
            "Petisco",
            product_2
        ));
        productSpecifications.add(new ProductSpecification(
            SpecificationName.FLAVOR.getDisplayName(),
            "Frango",
            product_2
        ));

        productsForPersistenceList.add(new ProductRequestDTO(
            product_2,
            productPackages,
            productImages,
            productSpecifications
        ));

        ProductRequestDTO productSave_2 = new ProductRequestDTO(
            product_2,
            productPackages,
            productImages,
            productSpecifications
        );

        productService.save(productSave_2);

        productImages.clear();
        productPackages.clear();
        productSpecifications.clear();
    }

 */
}
