package com.application.products.daos;

import com.application.products.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsDao {
    Optional<Product> getProductWithSpecialSizes(int id);
    Optional<Product> getProductWithoutSpecialSizes(int id);
    Optional<Product> getProductWithBackSoonSpecial(int id);
    Optional<Product> getProductWithBackSoonNoSpecial(int id);
    List<Integer> getProductsIds();
}
