package com.application.products;

import com.application.products.models.Product;
import com.application.products.repository.ProductsRepository;
import com.application.products.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Mock
    private ProductsRepository productsRepository;

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductService(productsRepository);
    }

    @Test
    public void testGetProductsList() {
        // mock the repository method calls
        List<Integer> productIds = Arrays.asList(1, 2, 3, 4);
        when(productsRepository.getProductsIds()).thenReturn(productIds);

        Optional<Product> productWithSpecialSizes = Optional.of(new Product(1, 1, 1, 10));
        Optional<Product> productWithBackSoonSpecial = Optional.empty();
        Optional<Product> productWithoutSpecialSizes = Optional.of(new Product(2, 2, 2, 20));
        Optional<Product> productWithBackSoonNoSpecial = Optional.empty();

        when(productsRepository.getProductWithSpecialSizes(1)).thenReturn(productWithSpecialSizes);
        when(productsRepository.getProductWithBackSoonSpecial(1)).thenReturn(productWithBackSoonSpecial);
        when(productsRepository.getProductWithoutSpecialSizes(1)).thenReturn(productWithoutSpecialSizes);
        when(productsRepository.getProductWithBackSoonNoSpecial(1)).thenReturn(productWithBackSoonNoSpecial);

        when(productsRepository.getProductWithSpecialSizes(2)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithBackSoonSpecial(2)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithoutSpecialSizes(2)).thenReturn(productWithoutSpecialSizes);
        when(productsRepository.getProductWithBackSoonNoSpecial(2)).thenReturn(Optional.of(new Product(2, 2, 2, 0)));

        when(productsRepository.getProductWithSpecialSizes(3)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithBackSoonSpecial(3)).thenReturn(Optional.of(new Product(3, 3, 3, 0)));
        when(productsRepository.getProductWithoutSpecialSizes(3)).thenReturn(Optional.of(new Product(3, 3, 3, 30)));
        when(productsRepository.getProductWithBackSoonNoSpecial(3)).thenReturn(Optional.empty());

        when(productsRepository.getProductWithSpecialSizes(4)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithBackSoonSpecial(4)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithoutSpecialSizes(4)).thenReturn(Optional.of(new Product(4, 4, 4, 0)));
        when(productsRepository.getProductWithBackSoonNoSpecial(4)).thenReturn(Optional.empty());

        when(productsRepository.getProductWithSpecialSizes(5)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithBackSoonSpecial(5)).thenReturn(Optional.of(new Product(4, 4, 4, 0)));
        when(productsRepository.getProductWithoutSpecialSizes(5)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithBackSoonNoSpecial(5)).thenReturn(Optional.empty());

        when(productsRepository.getProductWithSpecialSizes(6)).thenReturn(Optional.of(new Product(4, 4, 4, 0)));
        when(productsRepository.getProductWithBackSoonSpecial(6)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithoutSpecialSizes(6)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithBackSoonNoSpecial(6)).thenReturn(Optional.empty());

        when(productsRepository.getProductWithSpecialSizes(7)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithBackSoonSpecial(7)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithoutSpecialSizes(7)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithBackSoonNoSpecial(7)).thenReturn(Optional.empty());

        // call the method under test
        List<Integer> result = productService.getProductsList();

        // verify the results
        assertEquals(Arrays.asList(1, 2, 3, 4), result);
    }
}
