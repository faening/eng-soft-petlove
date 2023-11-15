package edu.fag.petlove.services;

import edu.fag.petlove.exceptions.EntityPersistenceException;
import edu.fag.petlove.exceptions.ResourceNotFoundException;
import edu.fag.petlove.models.Brand;
import edu.fag.petlove.repositories.BrandRepository;
import edu.fag.petlove.utils.BrandUtils;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BrandServiceTest {
    @Mock
    private BrandRepository brandRepository;

    @Mock
    private BrandUtils brandUtils;

    @InjectMocks
    private BrandService brandService;

    @Captor
    private ArgumentCaptor<Brand> brandCaptor;

    @Captor
    private ArgumentCaptor<Long> idCaptor;

    List<Brand> dummyBrands;

    @BeforeEach()
    public void setup() {
        this.dummyBrands = new ArrayList<>();
        dummyBrands.add(new Brand("Royal Canin", new Date(), new Date()));
        dummyBrands.add(new Brand("Purina", new Date(), new Date()));

    }

    @Test
    @DisplayName("Deve retornar uma lista de marcas corretamente")
    public void testFindAll_shouldReturnBrandList() {
        when(brandRepository.findAll()).thenReturn(dummyBrands);
        List<Brand> actualBrands = brandService.findAll();
        Assertions.assertEquals(actualBrands, dummyBrands);
    }

    @Test
    @DisplayName("Deve retornar uma marca corretamente")
    public void testFindById_whenIdReceived_shouldReturnBrand() {
        when(brandRepository.findById(1L)).thenReturn(Optional.of(dummyBrands.get(0)));
        Brand actualBrand = brandService.findById(1L);
        Assertions.assertEquals(actualBrand, dummyBrands.get(0));
    }

    @Test
    @DisplayName("Deve lançar ResourceNotFoundException se a marca não for encontrada")
    public void testFindById_shouldThrowResourceNotFoundException() {
        when(brandRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> brandService.findById(1L));
    }

    @Test
    @DisplayName("Deve salvar uma marca corretamente")
    public void testSave_whenBrandReceived_shouldSaveBrandSuccessfully() {
        Brand brandToSave = new Brand("Nova Marca", new Date(), new Date());
        when(brandRepository.save(any(Brand.class))).thenReturn(brandToSave);
        Brand savedBrand = brandService.save(brandToSave);
        Mockito.verify(brandRepository, times(1)).save(brandCaptor.capture());
        Assertions.assertEquals(savedBrand, brandCaptor.getValue());
    }

    @Test
    @DisplayName("Deve lançar EntityNotFoundException ao tentar salvar uma marca nula")
    public void testSave_shouldThrowEntityNotFoundExceptionForNullBrand() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> brandService.save(null));
    }

    @Disabled
    @Test
    @DisplayName("Deve atualizar uma marca corretamente")
    public void testUpdate_shouldUpdateBrandSuccessfully() {
        Brand existingBrand = new Brand(1L, "Marca Existente", new Date(), new Date());
        Brand updatedBrand = new Brand(1L, "Marca Atualizada", new Date(), new Date());

        when(brandRepository.findById(1L)).thenReturn(Optional.of(existingBrand));
        when(brandRepository.save(any(Brand.class))).thenReturn(updatedBrand);

        Brand resultBrand = brandService.update(updatedBrand);

        Mockito.verify(brandRepository, times(1)).findById(1L);
        Mockito.verify(brandRepository, times(1)).save(brandCaptor.capture());
        Brand savedBrand = brandCaptor.getValue();

        Assertions.assertNotNull(savedBrand);
        Assertions.assertEquals(updatedBrand.getId(), savedBrand.getId());
        Assertions.assertEquals(updatedBrand.getName(), savedBrand.getName());
        Assertions.assertEquals(resultBrand, savedBrand);
    }

    @Test
    @DisplayName("Deve deletar uma marca corretamente")
    public void testDelete_shouldDeleteBrandSuccessfully() {
        when(brandRepository.findById(1L)).thenReturn(Optional.of(new Brand(1L, "Marca", new Date(), new Date())));
        brandService.delete(1L);

        Mockito.verify(brandRepository, times(1)).findById(1L);
        Mockito.verify(brandRepository, times(1)).deleteById(idCaptor.capture());
        Long deletedId = idCaptor.getValue();

        Assertions.assertEquals(1L, deletedId);
    }

    @Test
    @DisplayName("Deve lançar EntityPersistenceException ao falhar ao deletar a entidade")
    public void testDelete_shouldThrowEntityPersistenceExceptionOnRepositoryFailure() {
        when(brandRepository.findById(1L)).thenReturn(Optional.of(new Brand(1L, "Marca", new Date(), new Date())));
        Mockito.doThrow(new DataAccessException("Simulated repository failure") {}).when(brandRepository).deleteById(anyLong());

        Assertions.assertThrows(EntityPersistenceException.class, () -> brandService.delete(1L));
    }

}
