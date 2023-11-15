package edu.fag.petlove.utils;

import edu.fag.petlove.models.Brand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Date;

@SpringBootTest
public class BrandUtilsTest {
    @Test
    @DisplayName("Deve atualizar a marca corretamente")
    void testCopyAndModify_shouldCopyAndModifyBrand() {
        Brand source = new Brand(1L, "BrandSource", Date.from(Instant.parse("2023-01-01T00:00:00Z")), Date.from(Instant.parse("2023-01-01T00:00:00Z")));
        Brand target = new Brand(2L, "BrandTarget", null, null);
        Date fixedDate = Date.from(Instant.now());

        BrandUtils brandUtils = new BrandUtils();
        Brand mergedBrand = brandUtils.copyAndModify(source, target);

        Assertions.assertEquals(target.getId(), mergedBrand.getId());
        Assertions.assertEquals(target.getName(), mergedBrand.getName());
        Assertions.assertEquals(source.getCreatedAt(), mergedBrand.getCreatedAt());
        Assertions.assertEquals(fixedDate, mergedBrand.getUpdatedAt());
    }

    @Test
    @DisplayName("Deve atualizar a data de criação e atualização")
    void testUpdateTimestamp_shouldUpdateTimestamp() {
        Brand brand = new Brand(1L, "BrandName", null, null);
        Date fixedDate = Date.from(Instant.now());
        BrandUtils brandUtils = new BrandUtils();
        Brand updatedBrand = brandUtils.updateTimestamp(brand, true);
        Assertions.assertEquals(fixedDate, updatedBrand.getCreatedAt());
        Assertions.assertEquals(fixedDate, updatedBrand.getUpdatedAt());
    }

    @Test
    @DisplayName("Deve atualizar apenas a data de atualização")
    void testUpdateTimestamp_shouldUpdateOnlyUpdatedAt() {
        Brand brand = new Brand(1L, "BrandName", Date.from(Instant.parse("2023-01-01T00:00:00Z")), Date.from(Instant.parse("2023-01-01T00:00:00Z")));
        Date fixedDate = Date.from(Instant.now());
        BrandUtils brandUtils = new BrandUtils();
        Brand updatedBrand = brandUtils.updateTimestamp(brand, false);
        Assertions.assertEquals(fixedDate, updatedBrand.getUpdatedAt());
    }
}
