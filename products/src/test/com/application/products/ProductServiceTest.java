package com.application.products;

import com.application.products.models.Product;
import com.application.products.repository.ProductsRepository;
import com.application.products.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Mock
    private ProductsRepository productsRepository;

    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductService(productsRepository);
    }

    @Test
    public void testGetProductsList() {
        // Mock data for ProductsRepository
        List<Integer> productIds = Arrays.asList(1, 2, 3);
        Product p1 = new Product(1, 1, 1, 1);
        Product p2 = new Product(2, 1, 2, 1);
        Product p3 = new Product(3, 2, 3, 1);
        Product p4 = new Product(4, 2, 4, 1);
        when(productsRepository.getProductsIds()).thenReturn(productIds);
        when(productsRepository.getProductWithSpecialSizes(1)).thenReturn(Optional.of(p1));
        when(productsRepository.getProductWithSpecialSizes(2)).thenReturn(Optional.of(p2));
        when(productsRepository.getProductWithSpecialSizes(3)).thenReturn(Optional.of(p3));
        when(productsRepository.getProductWithoutSpecialSizes(1)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithoutSpecialSizes(2)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithoutSpecialSizes(3)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithBackSoonSpecial(1)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithBackSoonSpecial(2)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithBackSoonSpecial(3)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithBackSoonNoSpecial(1)).thenReturn(Optional.empty());
        when(productsRepository.getProductWithBackSoonNoSpecial(2)).thenReturn(Optional.of(p2));
        when(productsRepository.getProductWithBackSoonNoSpecial(3)).thenReturn(Optional.of(p3));

        // Expected result
        List<Integer> expected = Collections.singletonList(2);

        // Test
        List<Integer> result = productService.getProductsList();
        assertEquals(expected, result);
    }

}
