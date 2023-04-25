package com.application.products;

import com.application.products.mappers.ProductRowMapper;
import com.application.products.models.Product;
import com.application.products.repository.ProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductsRepositoryTest {

    @Mock
    JdbcTemplate jdbcTemplate;

    @Mock
    ProductRowMapper productRowMapper;

    ProductsRepository productsRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productsRepository = new ProductsRepository(jdbcTemplate);
    }

    @Test
    void getProductWithSpecialSizes() {
        int productId = 1;
        Optional<Product> expectedProduct = Optional.of(new Product(1, 1, 1, 10));
        when(jdbcTemplate.query(any(String.class), any(ProductRowMapper.class), any(Integer.class)))
                .thenReturn(List.of(expectedProduct.get()));
        Optional<Product> actualProduct = productsRepository.getProductWithSpecialSizes(productId);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void getProductWithoutSpecialSizes() {
        int productId = 1;
        Optional<Product> expectedProduct = Optional.of(new Product(1, 1, 1, 10));
        when(jdbcTemplate.query(any(String.class), any(ProductRowMapper.class), any(Integer.class)))
                .thenReturn(List.of(expectedProduct.get()));
        Optional<Product> actualProduct = productsRepository.getProductWithoutSpecialSizes(productId);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void getProductWithBackSoonSpecial() {
        int productId = 1;
        Optional<Product> expectedProduct = Optional.of(new Product(1, 1, 1, 0));
        when(jdbcTemplate.query(any(String.class), any(ProductRowMapper.class), any(Integer.class)))
                .thenReturn(List.of(expectedProduct.get()));
        Optional<Product> actualProduct = productsRepository.getProductWithBackSoonSpecial(productId);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void getProductWithBackSoonNoSpecial() {
        int productId = 1;
        Optional<Product> expectedProduct = Optional.of(new Product(1, 1, 1, 0));
        when(jdbcTemplate.query(any(String.class), any(ProductRowMapper.class), any(Integer.class)))
                .thenReturn(List.of(expectedProduct.get()));
        Optional<Product> actualProduct = productsRepository.getProductWithBackSoonNoSpecial(productId);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void getProductsIds() {
        when(jdbcTemplate.queryForList(any(String.class), any(Class.class))).thenReturn(List.of(1, 2, 3));
        assertEquals(List.of(1, 2, 3), productsRepository.getProductsIds());
    }
}

